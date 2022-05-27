import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int Tcase;
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		Tcase = Integer.parseInt(in.readLine().trim());
		for (int t = 1; t <= Tcase; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(in.readLine());
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				arr[i] = (int) Math.pow(2, arr[i]);
			}
			Arrays.sort(arr);
			int ans = solution();
			out.append(String.format("#%d %d\n", t, ans));
		}
		System.out.print(out);
	}

	private static int solution() {
		int ans = 1;
		List<Square> list = new ArrayList<Square>();
		list.add(new Square(M, M));

		int tile;
		for (int i = arr.length - 1; i >= 0; i--) {
			tile = arr[i];
			int j;
			for (j = list.size() - 1; j >= 0; j--) {
				Square s = list.get(j);
				if (s.w == 0 || s.h == 0) { // 길이가 0인 쪼가리는 리스트에서 지움
					list.remove(j);
					continue;
				}
				if (tile <= s.w && tile <= s.h) { // 남는 쪼가리 중에 맞는게 있다면 잘라서 쓰고, 남은 쪼가리를 다시 넣음. (타겟이 정사각형이 아니라, 직사각형이었으면
													// 조금 더 복잡하게 작성해야함)
					list.remove(j);
					list.add(new Square(tile, s.w - tile));
					list.add(new Square(s.h - tile, tile));
					list.add(new Square(s.h - tile, s.w - tile));
					break;
				}
			}
			if (j < 0) { // 하나도 맞는 쪼가리가 없었다면, 새 M x M 타일을 가져온 후, 이를 잘라서 씀
				list.add(new Square(tile, M - tile));
				list.add(new Square(M - tile, tile));
				list.add(new Square(M - tile, M - tile));
				ans++;
			}
		}
		return ans;
	}

	static class Square {
		int h;
		int w;

		public Square(int h, int w) {
			this.h = h;
			this.w = w;
		}
	}
}
