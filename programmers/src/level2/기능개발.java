package level2;

import java.util.*;

class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int day = 0;
        int count = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            // i번째 작업 진도
            int progress = progresses[i];
            
            // n일 후 가능
            int n = (int) Math.ceil((double) (100 - progress) / (double) speeds[i]);

            if (day == 0) {
                day = n;
            }
            
            if (n > day) {
                queue.offer(count);
                count = 1;
                day = n;
            }
            else {
                count++;
            }

        }
        queue.offer(count);

        int answerSize = queue.size();
        int[] answer = new int[answerSize];
        
        for (int i = 0; i < answerSize; i++) {
            answer[i] = queue.poll();
        }
        
        return answer;
    }
}