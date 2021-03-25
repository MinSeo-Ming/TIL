from itertools import combinations
num, count = map(int, input().split())
li = []
for i in range(1,num+1):
    li.append(i)
li=list(combinations(li,count))
for i in li:
    print(' '.join(map(str, i)))
    # for j in i:
    #     print(j, end=" ")
    # print()
