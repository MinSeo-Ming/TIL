import sys

if len(sys.argv)<2:
    print("insert wrong option please insert right input")
    sys.exit()
option = sys.argv[1]

if option =="-a":
    memo = sys.argv[2]
    with open("memo.txt","a")as f:
        f.write(memo+"\n")

elif option =="-r":
    with open("memo.txt",'r')as f:
        data = f.read()
        print(data)
else:
    print("insert wrong option please insert right input")
