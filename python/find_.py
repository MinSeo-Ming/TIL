def searcgh(arr,tar,st,ed):
    if st>ed:
        return "no";
    mid = (st+ed)//2
    if arr[mid] == tar:
        return "yes";
    elif arr[mid]>tar:
        return searcgh(arr, tar, st,mid-1)
    else:
        return searcgh(arr,tar,mid+1,ed)

N = int(input())
get = list(map(int, input().split()))
M = int(input())
have = list(map(int, input().split()))

get.sort()
ed = len(get)
have.sort()
for i in have:
    print(searcgh(get,i,0,ed),end=" ")


#
# 5
# 8 3 7 9 2
# 3
# 5 7 9