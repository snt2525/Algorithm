import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		long [] num = new long[101];
		num[0] = num[1] = num[2] = 1;
		
		for(int i=3;i<=100;i++)
			num[i] = num[i-3]+num[i-2];
			
		for(int testCase = 1;testCase<=n;testCase++) {
			int tmp = sc.nextInt();
			System.out.println("#"+testCase+" "+num[tmp-1]);
		}
	}
}
