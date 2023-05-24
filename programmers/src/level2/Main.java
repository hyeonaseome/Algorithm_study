package level2;

public class Main {
	public static void main(String[] args) {
		String S = "acbcbzzzaca";
//		String S = "axxaxa";
//		String S = "aaaa";
		
		Solution sol = new Solution();
		int answer = sol.solution(S);
		System.out.println("answer: "+ answer);
	}
}
