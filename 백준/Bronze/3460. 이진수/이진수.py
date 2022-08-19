T = int(input())
for _ in range(T):
    a = int(input())
    binary = (bin(a)[2:])[::-1] #정수를 이진수로 변환후 숫자 뒤집기!
    binary_list = list(map(int,str(binary)))
    result = []
    for i in range(len(binary_list)):
        if binary_list[i] == 1:
            result.append(i)

    print(" ".join(str(i) for i in result))
