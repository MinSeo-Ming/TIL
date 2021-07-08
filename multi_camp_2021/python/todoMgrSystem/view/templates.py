from entity.models import Todo
import uuid

def menu_display():
    print("==== 일정 관리 시스템 ====\n")
    print("1. 일정 전체 보기")
    print("2. 일정 등록")
    print("3. 일정 수정")
    print("4. 일정 삭제")
    print("5. 일정 상세보기")
    print("0. 종료")


def menu_input():
    menu = input("메뉴를 선택하시오 : ")
    return menu


def list_display(plans):
    print("=== 전체 일정===")
    for idx,p in enumerate(plans):
        print(str(idx)+".\n"+p.info())
        print()



def input_display():
    id = uuid.uuid4()
    title = input("제목 : ")
    date =input ("날짜(형식은 YYYY-MM-DD) : ")
    contents = input("일정 내용 : ")
# 아직 확신은 없지만 일정 생성시 이부분은 아마 false일것이라
    # done = input("준수 여부 : ")

    return Todo(id,title,contents,date,"False")


def id_input_display(command):
    id = input("{0} id는? : ".format(command))
    return id


def todo_display(todo):
    print("===일정 상세 정보===")
    print(todo.info())


def update_input_display(id):
    title = input("제목 : ")
    date =input ("날짜(형식은 YYYY-MM-DD) : ")
    contents = input("일정 내용 : ")
    done = input("일정 준수 여부 : ")

    return Todo(id,title,contents,date,done)


def message_display(msg):
    print(msg)