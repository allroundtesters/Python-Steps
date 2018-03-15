# -*- coding:utf-8 -*-
import json
import subprocess


def load_pynotes():
    with open("pybasic/pybasic.ipynb", 'r') as note:
        pynotes = json.load(note)
    return pynotes["cells"]


SLIDE_SEPERATOR = "---"


def before_write_to_pitchme():
    subprocess.run(["mv", "PITCHME.md", "PITCHME_BNK.md"])
    subprocess.run(["touch", "PITCHME.md"])


def write_to_pitchme():
    """
    write to pitchme.md
    :return:
    """
    note_cells = load_pynotes()
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
    before_write_to_pitchme()
    write_to_pitchme()
