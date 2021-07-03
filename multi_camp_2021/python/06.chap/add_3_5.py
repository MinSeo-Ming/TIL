sum=0
for i in range(1,1000):
    if i%3==0 or i%5==0:
        sum+=i

print("1부터 1000미만까지의 3과 5의 배수의 합은 = {0}".format(sum))