import java.util.*;
public class Solution {
	static int[][] dir = {{1,1},{1,-1},{-1,-1},{-1,1}};
	static int[][] map;
	static int[][] visit;
	static int[] log;
	static int maxCnt;
	static int n;
	static void dfs(int cnt,int x,int y,int startX,int startY,int d) {
		log[map[x][y]] = 1;
		int nextX = x + dir[d][0];
		int nextY = y + dir[d][1];
		if(nextX<0||nextY<0||nextX>=n||nextY>=n) {
			if(d+1<4) dfs(cnt,x,y,startX,startY,d+1);
			return;
		}
		if(d == 3 && nextX == startX && nextY == startY) { //되돌아 와다면,
			maxCnt = Math.max(maxCnt, cnt);
			return;
		}
		if(log[map[nextX][nextY]] == 0 && visit[nextX][nextY]==0) {
			visit[nextX][nextY] = 1;
			dfs(cnt+1,nextX,nextY,startX,startY,d);
			log[map[nextX][nextY]] = 0;
			visit[nextX][nextY] = 0;
		}
		if(d+1<4&&cnt!= 1) dfs(cnt,x,y,startX,startY,d+1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int testCase = 1;testCase<=tc;testCase++) {
			n = sc.nextInt();
			map = new int[n][n];
			visit = new int[n][n];
			log = new int[101];
			maxCnt = 0;
			for(int i =0;i<n;i++) 
				for(int j=0;j<n;j++)  
					map[i][j] = sc.nextInt();
			
			for(int i = 0;i < n-1; i++) {
				for(int j = 1;j < n-1; j++) {
					log = new int[101];
					dfs(1,i,j,i,j,0);
					//System.out.println("<"+i+","+j+"> : " + maxCnt);
				}
			}
			if(maxCnt == 0 )System.out.println("#"+testCase+" -1");
			else System.out.println("#"+testCase+" "+maxCnt);
		}
	}
}
