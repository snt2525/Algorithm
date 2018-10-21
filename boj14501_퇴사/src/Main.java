import java.util.*;
public class Main {
	static int[][]arr;
	static int n;
	static int maxBenefit = Integer.MIN_VALUE;
	static void dfs(int now,int cnt) {
		maxBenefit = Math.max(maxBenefit , cnt);
		
		if(now+arr[now][0]<=n) {
			dfs(now+arr[now][0],cnt+arr[now][1]);		
		}
		if(now+1<=n-1) dfs(now+1,cnt);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n+1][2];
		
		for(int i =0;i<n;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		arr[n][0] = 2000;
		dfs(0,0);
		System.out.println(maxBenefit);
	}
}
