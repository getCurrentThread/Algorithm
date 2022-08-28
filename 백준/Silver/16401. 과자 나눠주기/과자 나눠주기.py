import sys
input = sys.stdin.readline

N, M= map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

def line(mid): 
    #print(mid)   
    cnt = 0
    for num in arr:
        cnt += (num // mid)
    return cnt

def upper_bound():
    global N
    left = 1
    right = arr[-1]    
    while left <= right:
        mid = (left + right) // 2
        linecnt = line(mid)
        if linecnt >= N:
            left = mid + 1
        else:
            right = mid - 1
    return right

print(upper_bound())