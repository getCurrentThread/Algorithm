H, M = map(int,input().split())

if H == 0 :
  H = 24
S = (((H * 60 ) + M) - 45)
print((S//60%24),(S%60))
