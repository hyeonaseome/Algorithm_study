package level2;

class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        String[] cache = new String[cacheSize];
        
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
        }
        
        for (String x : cities) {
            int pos = -1;
            
            for(int i = 0; i < cache.length; i++) {
                if (cache[i] != null && x.equals(cache[i])) {
                    pos = i;
                }
            }
            
            if (pos == -1) {
                for (int i = cache.length - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
                answer += 5;
            }else {
                for (int i = pos; i >=1; i--) {
                    cache[i] = cache[i - 1];
                }
                answer += 1;
            }
            
            if (cacheSize > 0)
                cache[0] = x.toUpperCase();
        }
        
        return answer;
    }
}