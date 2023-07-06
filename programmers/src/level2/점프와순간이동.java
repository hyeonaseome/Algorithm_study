package level2;

import java.util.*;

//k칸 앞으로 or (현재까지 온거리) * 2 위치로 순간이동
public class 점프와순간이동 {
 
 public int solution(int n) {
     
     int answer = 0;
     
     while (n != 0) {
         if (n % 2 == 0) {
             n /= 2;
         } else {
             n -= 1;
             answer++;
         }
     }

     return answer;
 }
}