#include <stdio.h>
#include <string.h>

int main() {
  //stack size
  int top=0;
  //input
  char str[100001];
  int sum=0;
  int len;

  fgets(str, 100001, stdin);

  len=strlen(str);
  if(str[len-1] == '\n'){ // 만약 끝에 개행이 있으면 아래 else문을 탈 수 있으므로 예외처리
  	// str[len-1] = '\0';
  	--len;
  }
  // printf("%d\n", len);

  for(int i=0; i < len; i++){
    if(str[i]=='('){
      ++top;
    }
    else{
      --top;
      if(str[i-1]==str[i]){
        sum++;
      }
      else{
        sum+=top;
      }
    }
  }

  printf("%d", sum);
  
  return 0;
}