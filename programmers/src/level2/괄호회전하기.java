package level2;

import java.util.*;

class 괄호회전하기 {
    public int solution(String s) {
        int answer = 0;        
        
        if (s.length() % 2 == 1)
            return answer;
        
        for (int i = 0; i < s.length(); i++) {
            String newS = s.substring(i, s.length()) + s.substring(0, i);
            
            Stack<Character> stack = new Stack<>();
            boolean success = true;
            for (int j = 0; j < s.length(); j++) {
                
                char curChar = newS.charAt(j);

                switch (curChar) {
                    case '[':
                    case '(':
                    case '{':
                        stack.push(curChar);
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.pop() != '[') {
                            success = false;
                        }
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.pop() != '(') {
                           success = false;
                        }
                        break;
                    case '}':
                        if (stack.isEmpty() || stack.pop() != '{') {
                            success = false;
                        }
                        break;
                }
                if (!success)
                    break;
                
            }
            
            if (stack.isEmpty() && success) {
                answer++;
            }
            
        }
        return answer;
    }
}