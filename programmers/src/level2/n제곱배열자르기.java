package level2;

class n제곱배열자르기 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1L)];
        
        for (int i = 0; i < answer.length; i++) {
            int x = (int)((left + i)/n);
            int y = (int)((left + i)%n);
            answer[i] = Math.max(x, y) + 1;
        }
        
        return answer;
    }
} 