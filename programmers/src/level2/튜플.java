package level2;

import java.util.*;

class 튜플 {
    public int[] solution(String s) {
        String[] split = (s.substring(1, s.length() - 1) + ",").split("},");
        
        Arrays.sort(split, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        
        int[] answer = new int[split.length];
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < split.length; i++) {
            String[] str = split[i].substring(1, split[i].length()).split(",");
            
            for (int j = 0; j < str.length; j++) {
                int num = Integer.parseInt(str[j]);
                if (!set.contains(num)){
                    answer[i] = num;
                    set.add(num);
                    break;
                }
            }
        }
        return answer;
    }
}
