package level3;

public class Main {
	public static void main(String[] args) {
//		String S = "<><??>>";
//		String S = "??????";
		String S = "?<<?";
		
		Solution sol = new Solution();
		int answer = sol.solution(S);
		System.out.println("answer: "+ answer);
	}
}
