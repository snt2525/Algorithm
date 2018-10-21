import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for(int i = 1;i<=testCase;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if(c >= a && b >= c) {
				System.out.println("#"+i+" 0");
			}else if(c > b) {
				System.out.println("#"+i+" -1");
			}else if(c < a) {
				System.out.println("#"+i+" "+ (a-c));
			}			
		}
	}
}
