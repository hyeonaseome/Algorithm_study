package level1;

//1 <= 마라톤 경기에 참여한 선수의 수 <= 100,000
//completion.length = participant.length - 1
//1 <= 참가지이름.length <= 20
//동명이인 가능
import java.util.*;

class 완주하지못한선수 {
 public String solution(String[] participant, String[] completion) {
     Map<String, Integer> map = new HashMap<>();
     
     for (int i = 0; i < participant.length; i++) {
         String value = participant[i];
         map.put(value, map.getOrDefault(value, 0) + 1);
     }
     
     for (int i = 0; i < completion.length; i++) {
         String value = completion[i];
         map.put(value, map.getOrDefault(value, 0) - 1);
     }
     
     String answer = "";
     
     for (int i = 0; i < participant.length; i++) {
         String value = participant[i];

         if (map.get(value) == 1) {
             answer =  value;
             break;
         }
     }
     
     return answer;
 }
}