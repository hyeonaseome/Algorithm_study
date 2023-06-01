package level1;

import java.util.*;

class 공원산책 {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {-1, -1};
        
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        
        for (int i = 0; i < routes.length; i++) {
            int dir = -1;
            int n = routes[i].charAt(2) - '0';
            
            switch(routes[i].charAt(0)) {
                case 'N':
                    dir = 0;
                    break;
                case 'S':
                    dir = 1;
                    break;
                case 'W':
                    dir = 2;
                    break;
                case 'E':
                    dir = 3;
                    break;
            }
            
            boolean flag = true;
            
            int testX = answer[0];
            int testY = answer[1];
            
            for (int j = 0; j < n; j++) {
                // 이동 중 공원을 벗어나는 지 확인
                testX += dx[dir];
                testY += dy[dir];
                
                if (!(0 <= testX &&  testX < park.length && 
                   0 <= testY &&  testY < park[0].length())) {
                    flag = false;
                    break;
                }
                
                // 이동 중 장애물 만나는 지 확인
                if (park[testX].charAt(testY) == 'X') {
                    flag = false;
                    break;
                }
            
            }
            
            if (flag) {
                answer[0] = answer[0] + n*dx[dir];
                answer[1] = answer[1] + n*dy[dir];
            }
            
        }
        return answer;
    }
}