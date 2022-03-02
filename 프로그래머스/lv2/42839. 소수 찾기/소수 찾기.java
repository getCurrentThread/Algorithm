import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
		public int solution(String numbers) {
			int answer = 0;
			char[] cArr = new char[numbers.length()];
			for (int i = 0; i < numbers.length(); i++) {
				cArr[i] = numbers.charAt(i);
			}
			int[] permute = permutation(cArr);
			Arrays.sort(permute);
			List<Integer> prime = seive(permute[permute.length - 1]);

			for (int number : permute) {
				if (number >= 2 && isPrime(number, prime))
					answer++;
			}
			System.out.println(Arrays.toString(permute));
			return answer;
		}

		private boolean isPrime(int number, List<Integer> prime) {
			int sqrN = (int) Math.sqrt(number);
			for (int p : prime) {
				if (p > sqrN)
					break;
				if (number % p == 0)
					return false;
			}
			return true;
		}

		private List<Integer> seive(int N) {
			int sqrN = (int) Math.sqrt(N);
			boolean[] isPrime = new boolean[sqrN+1];
			List<Integer> prime = new ArrayList<Integer>();
			for(int i = 2; i <= sqrN; i++) {
				if(isPrime[i]) continue;
				prime.add(i);
				for(int k = i; k <= sqrN; k += i ) {
					isPrime[k] = true;
				}
			}
			return prime;
		}

		private int[] permutation(char[] cArr) {
			Set<Integer> set = new HashSet<Integer>();
			char[] numbers = new char[cArr.length];
			boolean[] visited = new boolean[cArr.length];
			dfs(cArr, numbers, visited, set, 0);
			return set.stream().mapToInt(Integer::intValue).toArray();
		}

		private void dfs(char[] origin, char[] numbers, boolean[] visited, Set<Integer> result, int depth) {
			if(depth > 0)
				result.add(Integer.parseInt(new StringBuilder().append(numbers, 0, depth).toString()));
			if (origin.length == depth) {
				return;
			}
			for (int i = 0; i < origin.length; i++) {
				if (visited[i])
					continue;
				visited[i] = true;
				numbers[depth] = origin[i];
				dfs(origin, numbers, visited, result, depth + 1);
				numbers[depth] = '\0';
				visited[i] = false;
			}
		}
	}