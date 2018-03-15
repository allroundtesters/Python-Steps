# -*- coding:utf-8 -*-

# -*- coding:utf-8 -*-
import json
import subprocess

import sys


def __load_pynotes(note_path):
    with open(note_path, 'r') as note:
        pynotes = json.load(note)
    return pynotes["cells"]


SLIDE_SEPERATOR = "---"


def before_write_to_pitchme():
    subprocess.run(["mv", "PITCHME.md", "PITCHME_BNK.md"])
    subprocess.run(["touch", "PITCHME.md"])


def write_to_pitchme(note_path):
    """
    write to pitchme.md
    :return:
    """
    note_cells = __load_pynotes(note_path)
    with open('PITCHME.md', 'a') as pitchme:
        for note_cell in note_cells:
            if note_cell.get("cell_type", "none") == 'markdown':
                md = note_cell['source']
                if md[0][:2] == "##":
                    pitchme.write(SLIDE_SEPERATOR + "\n")
                    pitchme.write("\n")
                pitchme.writelines(md)
            if note_cell['cell_type'] == 'code':
                if len(note_cell["source"]) >= 1:
                    pitchme.write("\n")
                    pitchme.write("```python\n")
                    pitchme.writelines(note_cell["source"])
                    pitchme.write("\n")
                    pitchme.write("```\n")


if __name__ == '__main__':
    path = sys.argv[1]
    before_write_to_pitchme(path)
    write_to_pitchme(path)