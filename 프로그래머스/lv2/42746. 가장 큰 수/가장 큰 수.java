import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
		public String solution(int[] numbers) {
			String answer = Arrays.stream(numbers)
					.boxed()
					.map(String::valueOf)
					.sorted((a, b)-> {
						return -(a + b).compareTo(b + a);
					})
					.collect(Collectors.joining());

			return new BigInteger(answer).toString();
		}
	}