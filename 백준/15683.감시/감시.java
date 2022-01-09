import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int map[][];

	static List<CCTV> CCTVs;

	static class CCTV {
		int x;
		int y;
		int val;
	}

	/** 카메라 종류마다 돌릴 수 있는 최대 횟수 */
	static final int rotateMX[] = { -1, 4, 2, 4, 4, 1 };
	static final int dx[] = { 0, 1, 0, -1 };
	static final int dy[] = { 1, 0, -1, 0 };
	static final boolean rotate[][] = { {}, { true, false, false, false }, // 1번 카메라
			{ true, false, true, false }, // 2번 카메라
			{ true, true, false, false }, // 3번 카메라
			{ true, true, true, false }, // 4번 카메라
			{ true, true, true, true },// 5번 카메라
	};

	static int mx = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		CCTVs = new ArrayList<CCTV>();
		
		int val = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				val = map[i][j];
				if (val >= 1 && val <= 5) {
					CCTV cctv = new CCTV();
					cctv.x = i;
					cctv.y = j;
					cctv.val = val;
					CCTVs.add(cctv);
					map[i][j] = 0; // cctv가 있는 위치를 빈 영역으로 표기
				}
			}
		}

		dfs(0);

		System.out.println(M * N - mx);
	}

	private static void dfs(int depth) {
		if (depth == CCTVs.size()) { // 기저 조건
			check();
			return;
		}
		CCTV cctv = CCTVs.get(depth);
		int K = rotateMX[cctv.val]; // 몇번 회전 가능한지
		boolean visible[] = rotate[cctv.val];
		--map[cctv.x][cctv.y]; // 자기 자신 위치는 일단 확인 가능 표시
		for (int i = 0; i < K; i++) {
			for (int dir = 0; dir < 4; dir++) { // 4방향 탐색
				if (visible[(i + dir) % 4]) { // 볼 수 있는 방향이라면
					int cx = cctv.x + dx[dir];
					int cy = cctv.y + dy[dir];
					while (cx >= 0 && cy >= 0 && cx < N && cy < M && map[cx][cy] != 6) {
						--map[cx][cy];
						cx += dx[dir];
						cy += dy[dir];
					}
				}
			}
			dfs(depth + 1);

			// undo
			for (int dir = 0; dir < 4; dir++) {
				if (visible[(i + dir) % 4]) {
					int cx = cctv.x + dx[dir];
					int cy = cctv.y + dy[dir];
					while (cx >= 0 && cy >= 0 && cx < N && cy < M && map[cx][cy] != 6) {
						++map[cx][cy];
						cx += dx[dir];
						cy += dy[dir];
					}
				}
			}
		}
		++map[cctv.x][cctv.y];
	}

	private static void check() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] < 0 || map[i][j] == 6) { //음수값을 가지고 있거나 벽 인경우 영역 체크
					++cnt;
				}
			}
		}

		mx = Math.max(cnt, mx);
	}

}
