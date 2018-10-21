import java.util.*;
public class Solution {
	static int[][] map;
	static int[][] visit;
	static int visitCnt = 0;
	static int n;
	static int min = Integer.MAX_VALUE;
	static void dfs(int[] log,int cnt,int food){
		if(cnt == n) {
			int a =0,b = 0;
			for(int i  = 0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(i==j)continue;
					if(log[i] == 1 &&log[j] == 1) a += map[i][j];
					if(log[i] == 0 &&log[j] == 0) b += map[i][j];
				}	
			}
			min = Math.min(Math.abs(a-b), min);
			return;
		}
		
		if(food > 0) {
			log[cnt] = 1;
			dfs(log, cnt + 1,food - 1);
			log[cnt] = 0;			
		}
		dfs(log,cnt + 1,food);
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int testCase = 1;testCase<=tc;testCase++) { 
			n = sc.nextInt();
			map = new int[n][n];		
			min = Integer.MAX_VALUE;
			int[] log = new int[n];
			
			for(int i =0;i<n;i++) 
				for(int j=0;j<n;j++) 
					map[i][j] = sc.nextInt();					
							
			dfs(log,0,n/2);
			System.out.println("#"+testCase+" "+min);
		}
	}
}
