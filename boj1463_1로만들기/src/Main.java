import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		//int min =Integer.MAX_VALUE;
		int[] dp = new int[n+1];
		for(int i=1;i<n;i++) dp[i]=Integer.MAX_VALUE;
		
		for(int i=n;i>1;i--) {
			for(int j=n-1;j>=i;j--) {
				if((i/2==0&&i/2==j)||(i%3==0&&i/3==j)) 
					dp[j]=Math.min(dp[i]+1,dp[j]);
				else
					dp[j]=Math.min(dp[j],dp[j+1]+1);
			}
		}
		System.out.println(dp[1]);		
	}
}
