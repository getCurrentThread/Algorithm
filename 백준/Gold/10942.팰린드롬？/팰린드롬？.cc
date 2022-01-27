#include <bits/stdc++.h>

using namespace std;

int N,M,A[2010],dp[2010][2010];

int f(int s,int e){
    if(s>=e) return 1;
    if(dp[s][e]!=-1) return dp[s][e];
    dp[s][e]=(A[s]==A[e])&&f(s+1,e-1);
    return dp[s][e];
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin>>N;
    for(int i=1;i<=N;i++) cin>>A[i];
    memset(dp,-1,sizeof(dp));
    cin>>M;
    while(M--){
        int s,e; cin>>s>>e;
        cout<<f(s,e)<<'\n';
    }
    return 0;
}
