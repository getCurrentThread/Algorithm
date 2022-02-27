import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Solution {
		public int[] solution(String[] genres, int[] plays) {
			Map<String, Integer> gMap = new HashMap<>();
			Map<String, PriorityQueue<Music>> pMap = new HashMap<>();
			for (int i = 0; i < genres.length; i++) {
				if (gMap.containsKey(genres[i])) {
					gMap.put(genres[i], gMap.get(genres[i]) + plays[i]);
				} else {
					gMap.put(genres[i], plays[i]);
				}
			}

			for (int i = 0; i < genres.length; i++) {
				if (pMap.containsKey(genres[i])) {
					pMap.get(genres[i]).offer(new Music(i, plays[i]));
				} else {
					PriorityQueue<Music> pq = new PriorityQueue<>();
					pq.offer(new Music(i, plays[i]));
					pMap.put(genres[i], pq);
				}
			}

			// 가장 많이 진행된 장르 순으로 오름차순 리스트 만들기
			List<String> genresTop = gMap.entrySet().stream()
					.sorted((a, b) -> -Integer.compare(a.getValue(), b.getValue())).map(el -> el.getKey())
					.collect(Collectors.toList());

			List<Integer> answer = new ArrayList<Integer>();
			int count;
			for (String genre : genresTop) {
				PriorityQueue<Music> pq = pMap.get(genre);
				count = 2;
				while (count-- > 0 && !pq.isEmpty()) {
					answer.add(pq.poll().index);
				}
			}

			return answer.stream().mapToInt(Integer::intValue).toArray();
		}

		class Music implements Comparable<Music> {
			int index;
			int val;

			public Music(int index, int val) {
				this.index = index;
				this.val = val;
			}

			@Override
			public int compareTo(Music o) {
				if (Integer.compare(this.val, o.val) == 0)
					return Integer.compare(this.index, o.index);
				else
					return -Integer.compare(this.val, o.val);
			}
		}
	}