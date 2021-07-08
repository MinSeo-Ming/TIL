import os.path
from entity.models import Todo

def file_read():
    file_exist = os.path.isfile("./date.dat")
    plan_list =[]
    if file_exist:
        fr= open("./date.dat","r", encoding="UTF8")
        while True:
            date =fr.readline()
            if not date :
                break
            elif date=="\n":
                continue
            plan = date.split(" : ")
            temp = Todo(plan[0],plan[1],plan[2],plan[3],plan[4])

            plan_list.append(temp)
        fr.close()
        
    return plan_list

             
def file_write(date):
    fw = open("./date.dat","w", encoding="UTF8")
    for plan in date:
        fw.write("{0} : {1} : {2} : {3} : {4}\n".format(plan.id,plan.title,plan.contents,plan.date,plan.done))
    fw.close()