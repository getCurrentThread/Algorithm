#include <iostream>
#include <memory.h>
#include <stack>
using namespace std;

int **field;
int m,n;

void dfs(int y, int x)
{
    if(field[y][x] != 1)
        return;
    else{
        field[y][x] = 0;
        if(y>0) dfs(y-1, x);
        if(y<n-1) dfs(y+1, x);
        if(x>0) dfs(y, x-1);
        if(x<m-1) dfs(y, x+1);
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int t,k;
    int x,y;
    int cnt;
    
    
    cin >> t;
    
    for(int i=0; i<t; i++)
    {
        cnt = 0;
        cin >> m >> n >> k;
        
        field = new int*[n];
        for(int j=0; j<n; j++){
            field[j] = new int[m];
            memset(field[j], 0, sizeof(int)*m);
        }
        
        for(int j=0; j<k; j++){
            cin >> x >> y;
            field[y][x] = 1; 
        }
        
        for(int a=0; a<n; a++)
            for(int b=0; b<m; b++)
                if(field[a][b]){
                    dfs(a,b);
                    cnt++;
                }
        
        cout << cnt << "\n";
    }

    return 0;
}