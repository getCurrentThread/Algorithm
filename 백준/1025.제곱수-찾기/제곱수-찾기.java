

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



class Main{
        static int N, M, ans;
        static int map[][];
        public static void main(String[] args) throws Exception{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st =  new StringTokenizer(in.readLine());

            ans = -1;
            //given
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for(int i = 0; i < N; i++){
                char ch[] = in.readLine().toCharArray();
                for(int j = 0; j < M; j++){
                    map[i][j] = ch[j] - '0';
                }
            }

            for(int x = 0; x < N; x++){
                for(int y = 0; y < M; y++){
                    for(int i = -9; i < 9; i++) {
                        for(int j = -9; j < 9; j++) {
                        	if(i == 0 && j == 0) continue;
                            dfs(x, y, i, j, 0, 0);
                        }
                    }
                }
            }
            System.out.println(ans);
        }

        private static void dfs(int x, int y, int i, int j, int depth, int val) {
            if(depth != 0 && ans < val && check(val)){
                ans = val;
            }
            if(x >= N || x < 0 || y >= M || y < 0 ) return;
            dfs(x+i, y+j, i, j, depth+1, val*10 + map[x][y]);
        }

        static boolean check(int i){
            int j = (int)Math.sqrt(i);
            return i == j*j;
        }

    }

