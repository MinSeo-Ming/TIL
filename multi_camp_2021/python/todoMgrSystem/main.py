from exception.exception import *
from view.templates import *
from controller.views import *

# from todoMgrSystem.entity.models import *
#todoMgrSystem.

# from view.templat
con = TodoController()
while True:
    menu_display()
    menu = menu_input()
    
    if menu =="0":
        con.save_plan()
        message_display("일정 시스템을 종료합니다.")
        break
    elif menu =="1":
        plans =con.display_all_plans()
        list_display(plans)
    elif menu =="2":
        plan_1 = input_display()
        try:
            con.register(plan_1)
            message_display("등록 성공")
        except DuplicateError as e:
            message_display(e)
        #finally붙을지 아닐진 추후 고민
        
    elif menu =="3":
        id = id_input_display("수정할 ")
        try:
            plan = update_input_display(id)
            con.update(plan)
            message_display(id+" 수정 성공")
        except NotFoundError as e:
            message_display(e)
    elif menu =="4":
        id = id_input_display("삭제할 ")
        try:
            con.remove(id)
            message_display(id+" 삭제 성공")
        except NotFoundError as e:
            message_display(e)
    elif menu =="5":
        id = id_input_display("보고 싶은 ")
        try:
            todo=con.get_plan(id)
            todo_display(todo)
            message_display(id+" 검색 성공")
        except NotFoundError as e:
            message_display(e)
    elif menu =="6":
        keyword = key_word_input()
        find_lists=[]
        try:
            plan_lists = con.combine_lists()
            find_lists = con.find_keyword(keyword,plan_lists)
            message_display(keyword+" 검색 성공")
        except NotFoundError as e:
            message_display(e)
        for id in find_lists:
            try:
                find=con.get_plan(id)
                todo_display(find)
                message_display(id+" 나열 성공")
            except NotFoundError as e:
                message_display(e)

    else:
        message_display("\n 1,2,3,4,5,6,0 중 하나를 입력해주세요.")

