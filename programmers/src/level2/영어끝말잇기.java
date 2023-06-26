package level2;

import java.util.*;

class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0}; // 번호, 차례
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < words.length; i++){
            int j = i + 1;
            String curWord = words[i];
            if(set.contains(curWord) 
               || (i > 0 && words[i-1].charAt(words[i-1].length() - 1) != curWord.charAt(0))) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            } else {
                set.add(curWord);
            }
        }

        return answer;
    }
}