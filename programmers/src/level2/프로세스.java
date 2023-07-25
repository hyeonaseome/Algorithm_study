package level2;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class 프로세스 {
    public class Process {
        int loc;
        int priority;
        
        public Process (int loc, int priority){
            this.loc = loc;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Process> queue = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; i++) {
            int num = priorities[i];
            queue.offer(new Process(i, num));
            pq.add(num);
        }
        
       while(!pq.isEmpty()) {
           // 대기 중 프로세스 꺼내기
           Process cur = queue.poll();
           
           // 대기 중 프로세스 중 우선순위가 더 높은 프로세스가 있는 지 확인
           if (pq.peek() > cur.priority) {
               queue.add(cur);
           } else {
               pq.poll();
               answer++;
               if (cur.loc == location){
                   return answer;
               }
           }
		}
        return answer;
    }
}