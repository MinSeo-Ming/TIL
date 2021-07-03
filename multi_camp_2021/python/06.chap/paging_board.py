def getTotalPage(page,max):
    if page%max==0:
            num =page//max
    else:
            num =page//max+1
    return num
in_=list(map(int,input("총 게시물의 수와 페이지당 보여줄 게시물 수를 입력하시오  : ").split()))
# print(in_[0],in_[1])
print("총 페이지의 수 는 {0} 개 입니다.".format(getTotalPage(in_[0],in_[1])))