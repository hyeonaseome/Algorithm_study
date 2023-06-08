package level1;

/*
개인 정보 n개
각 약관마다 개인정보 보관 유효기간이 정해져 있음

모든 달은 28일까지 있다고 가정
*/
import java.util.*;

class 개인정보수집유효기간 {
   public int[] solution(String today, String[] terms, String[] privacies) {
       
       // 오늘 날짜를 day로 환산
       int totalDay = getDays(today);
       
       int[] newTerms = new int[26];
       
       for (int i = 0; i < terms.length; i++){
           int termName = terms[i].charAt(0) - 'A'; // 약관 종류
           int termPeriod = Integer.parseInt(terms[i].split(" ")[1]); // 유효기간
           newTerms[termName]  = termPeriod;
       }
       
       Queue<Integer> queue = new ArrayDeque<Integer>();
       for (int i = 0; i < privacies.length; i++) {
           String[] splitPriv = privacies[i].split(" ");
           
           int curTermName = splitPriv[1].charAt(0) - 'A';
           int totalCurPrivDay = getDays(splitPriv[0]);
           
           // 오늘 날짜 - 개인정보 수집날짜 > 유효기간 인지 확인 => 유효기간 지남
           if ((totalDay - totalCurPrivDay) >= newTerms[curTermName] * 28) {
               queue.offer(i+1);
           }
       }
       
       int[] answer = new int[queue.size()];
       
       for (int i = 0; i< answer.length; i++) {
           answer[i] = queue.poll();
       }
       
       return answer;
   }
   
   public int getDays(String day) {
       String[] split = day.split("\\.");
       int dayYear = Integer.parseInt(split[0]);
       int dayMonth = Integer.parseInt(split[1]);
       int dayDay = Integer.parseInt(split[2]);
       
       // 날짜를 day로 환산
       return dayDay + 28*(dayMonth + 12*dayYear);
   }
}

