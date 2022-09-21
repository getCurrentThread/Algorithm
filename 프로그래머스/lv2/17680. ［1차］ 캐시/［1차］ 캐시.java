import java.util.*;

class Solution {
    class LRUcache<K, V> extends LinkedHashMap<K, V> {
        private int size;

        public LRUcache(int size) {
            this.size = size;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > size;
        }
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Map<String, Integer> cache = new LRUcache<>(cacheSize);
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
            if (cache.containsKey(cities[i])) {
                cache.remove(cities[i]); // put 으로 기존 삽입된 값의 변경이 이루어지지 않으므로 삭제
                answer += 1; // cache hit
            } else {
                answer += 5; // cache miss
            }

            cache.put(cities[i], null);
        }
        return answer;
    }
}