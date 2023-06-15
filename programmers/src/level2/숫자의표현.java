package level2;

class 숫자의표현 {
    public int solution(int n) {
        
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            int sum = i * (i + 1) / 2;
            if(n - sum >= 0) {
                if ((n - sum) % i == 0)
                    answer++;
            }
            else {
                break;
            }
        }
        return answer;
    }
}