package level1;

import java.util.HashMap;
import java.util.Map;

class 달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players;
        Map<String, Integer> map = new HashMap<String, Integer>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
         for (int i = 0; i < callings.length; i++) {
             // 불린 사람의 위치 
             int loc = map.get(callings[i]);
             
             // 그전 사람의 위치
             int locBef = loc - 1;
             // 그전 사람
             String playerBef = answer[locBef];
             
             // 그전 사람과 현재 사람의 위치 변경
             map.put(callings[i], locBef);
             map.put(playerBef, loc);
             answer[locBef] = callings[i];
             answer[loc] = playerBef;
             
        }
        
        return answer;
    }
}