import datetime
import subprocess
import sys

"""
- <DATE>-CATEOGRY-NAMING.md
"""


def generate_daily(category, summary, locale="en"):
    current_date = str(datetime.date.today())
    file_path = "daily/" + locale + "/" + "_".join([current_date, category, summary]) + ".md"
    subprocess.call(["touch", file_path])


if __name__ == '__main__':
    if len(sys.argv) < 3:
        sys.argv[3] = "cn"
    generate_daily(sys.argv[1], sys.argv[2], sys.argv[3])
