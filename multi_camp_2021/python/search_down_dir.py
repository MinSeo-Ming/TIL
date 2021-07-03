import os
import sys

# 실행한 시스템 명령어의 결과값 같고 오기->  os.popen("")

# 시스템 명령어 단순 호출은 -> os.system()


def search(dirname):
    try:
        filenames = os.listdir(dirname)
        for filename in filenames:
            full_filename = os.path.join(dirname, filename)
            if os.path.isdir(full_filename):
                search(full_filename)
            else:
                ext = os.path.splitext(full_filename)[-1]
                if ext == '.py': 
                    print(full_filename)
    except PermissionError:
        pass
search("./")