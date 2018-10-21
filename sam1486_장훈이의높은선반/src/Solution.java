import java.util.*;
public class Solution {
	int[] map;
	int[] log;
	int n,top,min=Integer.MAX_VALUE;
	Solution(int n,int top){
		this.n =n;
		this.top = top;
		this.map = new int[n];
		this.log = new int[n];
	}
	void dfs(int x,int sum) {
		if(sum>=top) {
			min = Math.min(min, sum);
			return;
		}
		for(int i=x;i<n;i++) {
			int xx = i;
			if(xx<0||xx>=n)continue;
			if(log[xx]==0) {
				log[xx]=1;
				dfs(xx,sum+map[xx]);
				log[xx]=0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int test = 1;test<=tc;test++) {
			int n = sc.nextInt();
			int top = sc.nextInt();
			Solution s = new Solution(n,top);			
			for(int i=0;i<n;i++)
				s.map[i] = sc.nextInt();				
			s.dfs(0, 0);			
			System.out.println("#"+test+" "+(s.min-top));
		}
	}
}
