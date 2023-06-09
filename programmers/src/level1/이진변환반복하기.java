package level1;

class 이진변환반복하기 {
    public int[] solution(String s) { 
        int chageCount = 0;
        int zeroCount = 0;
        
        while(s.length() > 1) {
            chageCount++;
            String newS = s.replaceAll("0", "");
            zeroCount += s.length() - newS.length();
            s = Integer.toBinaryString(newS.length());
        }
        int[] answer = {chageCount, zeroCount};
        return answer;
    }
}