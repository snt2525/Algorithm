import java.util.*;
public class Main {
	static int[][] map;
	static int[] log;
	static int n;
	static int min = Integer.MAX_VALUE;
	static void dfs(int i,int cnt) {
		if(cnt == n/2) {
			int cntA = 0;
			int cntB = 0;
 			for(int j =0;j<n;j++) {
				for(int k =0;k<n;k++) {
					if(j==k)continue;
					if(log[j]==1&&log[k]==1) cntA += map[j][k];
					if(log[j]==0&&log[k]==0) cntB += map[j][k];
				}
			}
			min = Math.min(min, Math.abs(cntA-cntB));
			return;
		}
		if(cnt<n/2&&i+1<n) {
			log[i] = 1;
			dfs(i+1,cnt+1);
			log[i] = 0;
		}
		if(i+1<n) dfs(i+1,cnt);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int testCase = 1;testCase<=tc;testCase++) { 
			n = sc.nextInt();
			map = new int[n][n];
			log = new int[n];
			min = Integer.MAX_VALUE;
			for(int i =0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			dfs(0,0);
			
			System.out.println("#"+testCase+" "+ min);
		}
	}
}
