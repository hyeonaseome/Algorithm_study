package level2;

class 예상대진표
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        String binaryString = Integer.toBinaryString(n);
        
        for (int i = 0; i < binaryString.length(); i++){
            answer++;
            if ((a+1) / 2 == (b + 1) /2) {
                break;
            }
            a = (a + 1) /2;
            b = (b + 1) /2;
        }

        return answer;
    }
}