def mod(val, p):
    while True:
        if val >= p:
            val = val % p
        elif val < 0:
            val = val + p;
        if 0 <= val < p: break;
    return val


def all_point_List(a, b, p):
    for i in range(p):
        x_3 = mod(i * i * i, p)
        x_1 = mod(i * a, p)
        temp = mod(x_3 + x_1 + b, p)
        for j in range(p):
            temp_y = j * j
            if temp == temp_y or temp == mod(temp_y, p):
                print("({},{})".format(i, j))

def one_point_order(a, b, p, x1, y1):
    order = 1
    i = 0
    x2=None
    x3=None
    y2=None
    y3=None
    inverse_y=None
    inverse_x=None

    while True:
        if order ==1:
            if x1==0 and y1 ==0:
                print("1 P = (0,0)\n Infinite Origin\n order : 2\n")
                return
            first_s_x = mod(3 * x1 * x1 + a, p)
            for j in range(1, p):
                find = 2 * y1 * j
                if mod(find, p)==1:
                    inverse_y =j
                    break
            second_s_x = mod(first_s_x * inverse_y,p)
            third_s_x = mod(second_s_x * second_s_x, p)

            temp = mod(2*x1, p)
            x3 = mod(third_s_x - temp, p)

            first_s_y = mod(x1-x3,p)
            second_s_y = mod(first_s_x * first_s_y,p)
            y3 = mod(-y1+second_s_y, p)

            x2 = x3
            y2 = y3

            print("1P = ({},{})".format(x1, y1))
            print("2P = ({},{})".format(x3, y3))
            if y1 == 0:
                print("0 (Infinite origin) \norder : 2\n")
                return
            order = order + 1
        else:
            if x1 == x2 and ((y1 +y2) % p) ==0:
                print("{}P = 0 (Infinite origin) \n order : {}\n".format(order+1, order+1))
                return
            first_s_y = mod(y2 - y1,p)
            first_s_x = mod(x2 - x1,p)

            for j in range(1, p):
                if mod(first_s_x * j, p):
                    inverse_x = j
                    break
            second_s_x = mod(first_s_y * inverse_x,p)
            third_s_x = mod(second_s_x * second_s_x,p)

            x3 = mod(third_s_x -x1 -x2,p)

            temp = mod(x1 - x3,p)
            second_s_y = mod(second_s_x * temp, p)

            y3 = mod(-y1 + second_s_y, p)
            x2=x3
            y2= y3
            print("{}P = ({},{})".format(order+1, x3,y3))
            order = order+1

def all_points_orders(a, b, p):
    for i in range(p):
        x_3 = mod(i * i * i, p)
        x_1 = mod(i * a, p)
        temp = mod(x_3 + x_1 + b, p)
        for j in range(p):
            temp_y = j * j
            if temp == temp_y or temp == mod(temp_y, p):
                print("({},{})".format(i, j))
                one_point_order(a, b, p, i, j)
        print()


a, b, p = list(map(int, input("y^2 = x^3 + ax + b (mod p) Enter Integer 'a' 'b' and 'p'").split()))

print("Lists")
all_point_List(a, b, p)
print("Orders")
all_points_orders(a, b, p)

