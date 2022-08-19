N=int(input()) #과목 개수
bin=[]

test=list(map(int, input().split())) #과목점수 리스트화
m=max(test) #맥스값

for i in test: #테스트점수 i에 입력
  new_score = i/m*100
  bin.append(new_score)

result=sum(bin)/N
print(result)
