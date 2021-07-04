a = "a:b:c:d"
re_1 = a.split(":")
re_1="#".join(re_1)
print(re_1)

#2
a = {'A': 90, 'B': 80}
try:
    print(a['C'])
except KeyError as e:
    if str(e) =="\'C\'":
        print(70)

#3
# + 기호와 extend의 차이점???

#4
A = [20, 55, 67, 82, 45, 33, 90, 87, 100, 25]

sum=0
for score in A:
    if score>=50:
        sum+=score
        
print(sum)

#5 일반적인 피보나치
def fibo(num):
    if num<2:
        return num
    else:
        return fibo(num-1)+fibo(num-2)

num= 10#int(input("피보나치 수열 출력"))
print(fibo(num))

#5-1
fibo_li=[0,1,]
for i in range(0,num+1):

    if i<2:
        print(fibo_li[i], end=", ")
    else:
        fibo_li.append(fibo_li[i - 1] + fibo_li[i - 2])
        if i<num:
            print(fibo_li[i], end=", ")
        else:
            print(fibo_li[i])

#06
#
# num =list(map(int,input("숫자를 입력하시오 : ").split(',')))
# print(num)
# sum=0
# for i in num:
#     sum+=i
# print(sum)

#07
# #multi =int(input("구구단을 출력할 숫자를 입력하세요(2~9): "))
multi =2
for i in range(1,10):
    print(i*multi, end=" ")

#08
with open("abc.txt",'r') as f:
    data = f.read()
data2=""
for line in data:
    data2=line+data2
# print(data2)
with open("abc.txt",'w')as fw:
    fw.write(data2)


#09
with open("sample.txt", 'r') as f:
    data = f.readlines()
i=0
sum=0
for line in data:
    i+=1
    line = line.strip('\n')
    sum += int(line)
avg = sum/i
with open("result.txt",'w')as fw:
    fw.write(str(avg))

#10

class Calculator:
    def __init__(self,lists):
        self.lists = list(map(int,lists))
    def sum(self):
        self.result = 0
        for i in self.lists:
            self.result+=i
        print(self.result)
        # return self.result
    def avg(self):
        leg = len(self.lists)
        self.avg =self.result/leg
        print(self.avg)

print("\n")
cal1 = Calculator([1,2,3,4,5])
cal1.sum()
cal1.avg()

cal2 = Calculator([6,7,8,9,10])
cal2.sum()
cal2.avg()


#12 답은 7 같음
result = 0

try:
    [1, 2, 3][3]
    "a"+1
    4 / 0
except TypeError:
    result += 1
except ZeroDivisionError:
    result += 2
except IndexError:
    result += 3
finally:
    result += 4

print(result)

#13
def DashInsert(string):
    list_str = list(string)
    result = list_str.pop(0)
    for s in list_str:
        if int(result[-1])%2==0 and int(s)%2==0:
            result =result+"*"+s
        elif int(result[-1])%2==1 and int(s)%2==1:
            result =result+"-"+s
        else:
            result = result+s
    print(result)

DashInsert("4546793")

str_= "aaabbccccccaaacczzzz"
str_list = list(str_)

cnt = 1
c=str_list.pop(0)
re=""
for s in str_list:
    if c==s:
        cnt+=1
    else:
        re+=c+str(cnt)
        c=s
        cnt=1
re+=c+str(cnt)
print(re)

#15
# import re
in_list="0123456789 01234 01234567890 6789012345 012322456789"
num_list = in_list.split(" ")

for num in num_list:
    re_c = "False"
    error ="NOT"
    n_list = list(num)
    check = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

    if len(check)==len(n_list):
        while len(check) != 0 or len(n_list) != 0:
                c=n_list.pop()
                if check.count(c)==0:
                    break
                check.remove(c)
                print(len(n_list),len(check))

        re_c="True"

    print(re_c, end=" ")
print()
#16
str_list ={
    'A'	:'.-',	'N'	:'-.',
    'B'	:'-...',	'O'	:'---',
    'C'	:'-.-.',	'P':	'.--.',
    'D'	:'-..','Q'	:'--.-',
    'E'	:'.'	,'R':	'.-.',
    'F'	:'..-.',	'S':	'...',
    'G'	:'--.',	'T':	'-',
    'H'	:'....',	'U'	:'..-',
    'I'	:'..',	'V':	'...-',
    'J'	:'.---',	'W'	:'.--',
    'K'	:'-.-',	'X'	:'-..-',
    'L'	:'.-..',	'Y'	:'-.--',
    'M'	:'--',	'Z':	'--..'
    }
n_list={}
for k,v in str_list.items():
    n_list[v]=k
# print(n_list)
dots =".... .  ... .-.. . . .--. ...  . .- .-. .-.. -.--"
dots_li =dots.split(" ")


re=""
for d in dots_li :
    if d=='':
        re+=" "
    else:
        re+=n_list.get(d)
print(re)

#17 ekqdms 4

phone ="""park 010-9999-9988
kim 010-9909-7789
lee 010-8789-7768"""
phone_list =phone.split("\n")
phone_list_more = []
for p in phone_list:
    temp = p.split('-')
    phone_list_more.append(temp)
re =[]
for p in phone_list_more:
    p[2]="####"
    re.append('-'.join(p))

print(re)

