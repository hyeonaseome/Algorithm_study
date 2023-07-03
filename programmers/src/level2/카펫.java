package level2;

class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        
        int xplusy = (brown + 4) / 2;
        int xmutiy = brown + yellow;
        
        for (int i = 1; i <= xmutiy; i++) {
            if (xmutiy % i == 0 && (xmutiy / i) + i == xplusy){
                answer[0] = xmutiy / i;
                answer[1] = i;
                break;
            }
        }
        
        return answer;
    }
}