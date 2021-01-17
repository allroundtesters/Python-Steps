

import re

msg1 = "12321321231312390909,etestdscas"
msg2 = "123221231312390909,etestdscas"
print(len(msg1))

lines=['commit b130ab37071dceb4022675551fdbe9cb08eb5ea9\n', 'Merge: a748a09 504768f\n',
       'Author: patrick <patrickwuke@163.com>\n', '\n', '    12343345345345356909236\n',
       "    Merge branch 'master' of http://localhost:10080/workspace/git-workflow-labs\n",
       '    1. test rules\n', '    2. test rules 3\n', '    '
                                                       '3. test rules 4\n', '\n',
       'commit a748a09d71618e8dcab8e3912918a9d8a1cec9e7\n',
       'Author: patrick <patrickwuke@163.com>\n', '\n', '    12343345345345356909236\n',
       '    1. add system level\n', '    2. line 2\n', '\n']


def check_lines(lines):
    new_lines = []
    for line in lines:
        line = line.replace("\n", "")
        if len(line) > 0:
            new_lines.append(line)

    has_task_id = False
    valid_first_line_msg = False
    for idx in range(len(new_lines)):
        if new_lines[idx].startswith("Author"):
            print(new_lines[idx])
            task_id = new_lines[idx + 1].strip()
            if len(task_id) == 23 and int(task_id) > 0:
                has_task_id = True
            else:
                has_task_id = False
            first_line_msg = new_lines[idx + 2].strip()
            if len(first_line_msg) >= 10:
                valid_first_line_msg = True
            else:
                valid_first_line_msg = False
    print(has_task_id)
    print(valid_first_line_msg)
    return has_task_id,valid_first_line_msg

has_task_id,valid_fist_line_msg=check_lines(lines)
print(has_task_id,valid_fist_line_msg)