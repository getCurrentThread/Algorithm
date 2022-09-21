class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int n = arr1.length;
        int m = arr2[0].length;
        int l = arr2.length;
        int[][] answer = new int[n][m];

        // i x n, n x j
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = 0;
                for (int x = 0; x < l; x++) {
                    tmp += arr1[i][x] * arr2[x][j];
                }
                answer[i][j] = tmp;
            }
        }
        return answer;
    }
}