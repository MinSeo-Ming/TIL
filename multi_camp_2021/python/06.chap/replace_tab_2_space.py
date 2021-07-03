import sys

src = sys.argv[1]
dst = sys.argv[2]
dst2 =sys.argv[3]
f = open(src)
tab_content = f.read()
f.close()

space_content = tab_content.replace(" ", "\t")

space_content2 = space_content.replace("\t", " ")
print(space_content)
f = open(dst, 'w')
f.write(space_content)
f.close()

f = open(dst2, 'w')
f.write(space_content2)
f.close()
print(space_content2)

# test="Life    is  too short   You need    python"
# test = "life    is  too short"
# re =test.replace(" ","\t")
# print(re)

#????왜 인식이 안되는거지??? 흠...한번 반대로 해볼까????
#반대로 space바는 \t로 변환이 잘 되는데 안된다... 왜지????