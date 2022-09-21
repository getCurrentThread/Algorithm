class Solution
{
    public int solution(int n, int a, int b)
    {
        // if(a == b) return 0; // a와 b는 같지 않다는 조건이 있으므로 불필요
        a = a - 1;
        b = b - 1;
        int depth = 0;
        while(true){
            if(a == b) return depth;
            a = a / 2;
            b = b / 2;
            ++depth;
        }
    }
}