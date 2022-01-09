import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st;
		
		Vector<int[]> v = new Vector<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			v.add(new int[] {b,a});
		}
		Collections.sort(v, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if(a[0] == b[0])
					return (a[1] - b[1]);
				else return (a[0] - b[0]);
			}
		} );
		int ans = 0;
		int time = 0;
		for(int i = 0; i < n; i++) {
			if(time <= v.get(i)[1]) {
				time = v.get(i)[0];
				ans++;
			}
		}
		System.out.println(ans);
	}
}
