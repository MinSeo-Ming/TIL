from exception.exception import *
from dao.file_registry import *
from view.templates import *


class TodoController:
    def __init__(self):
        self.load_plan()


    def is_exist(self,id):
        for idx, plan in enumerate(self.date_list):
            if plan.id ==id:
                return idx
        return -1


    def register(self,plan):
        idx = self.is_exist(plan.id)
        if idx >-1:
            raise DuplicateError(plan.id)
        self.date_list.append(plan)


    def update(self, plan):
        idx = self.is_exist(plan.id)
        if idx == -1:
            raise NotFoundError(plan.id)
        self.date_list[idx]=plan
    

    def remove(self,id):
        idx = self.is_exist(id)
        if idx ==-1:
            raise NotFoundError(id)
        self.date_list.pop(idx)

    
    def get_plan(self,id):
        idx= self.is_exist(id)
        if idx ==-1:
            raise NotFoundError(id)
        return self.date_list[idx]

    
    def display_all_plans(self):
        return self.date_list

    
    def save_plan(self):
        file_write(self.date_list)
    

    def load_plan(self):
        self.date_list = file_read()

    #찾기 위해서 리스트화 시킴.
    # def combine_lists(self):
    #     plan_list =[]
    #     for date in self.date_list:
    #         temp =[]
    #         re = str(date.id +" "+date.contents+" "+date.title)

    #         plan_list.append(re.split(" "))
    #     return plan_list
    

    # def find_keyword(self,keyword,plan_list):
    #     ids=[]
    #     for  p in plan_list:
    #         if keyword in p:
    #             ids.append(p[0])
    
    #     if len(ids)==0:
    #         raise NotFoundError("일치하는 데이터")

    #     return ids

    
    def file_find_word(self,keyword):
        ids =[]
        f = open("./date.dat",'r',encoding="UTF8")
        while True:
            data =f.readline()
            if not data :
                break
            elif data=="\n":
                continue
            if keyword in data:
                temp = data.split(" : ")
                ids.append(temp[0])
        return ids





