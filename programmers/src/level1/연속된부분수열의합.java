package level1;


import java.util.*;
//비내림차순: 다음 수가 같거나 커짐

class 연속된부분수열의합 {
 public int[] solution(int[] sequence, int k) {
     int[] answer = {-1, -1};
     
     int minStartIdx = sequence.length + 1;
     int minEndIdx = sequence.length + 1;
     int minLen = sequence.length;
     
     int[] dp = new int[sequence.length];
     for (int i = 1; i < dp.length; i++) {
         dp[i] = dp[i-1] + sequence[i];
     }
     System.out.println(Arrays.toString(dp));

     loop:
     for (int i = sequence.length - 1; i >= 0; i--) {
         int sum = 0;
         for (int j = i; j >= 0; j--) {
             
             sum += sequence[j];
             if (sum > k) {
                 break;
             }
             if (sum == k) {
                 if ( i - j + 1  < minLen) {
                     minLen = i - j + 1;
                     minStartIdx = j;
                     minEndIdx = i;
                 } else if (i - j + 1  == minLen) {
                     if (j < minStartIdx) {
                         minStartIdx = j;
                         minEndIdx = i;
                     }
                 }
                 break;
             }
             
             if ( i - j + 1 == minLen && sum < k) {
                 break loop;
             }
             
             if ( i - j + 1 > minLen) {
                 break;
             }

         }
     }
     
     answer[0] = minStartIdx;
     answer[1] = minEndIdx;
     
     return answer;
 }
}