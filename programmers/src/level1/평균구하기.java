package level1;

class 평균구하기 {
    public double solution(int[] arr) {
        double answer = 0;
        
        for (int i = 0; i < arr.length; i++ ){
            answer += arr[i] * 1.0;
        }
        
        answer /= arr.length;
        
        return answer;
    }
}