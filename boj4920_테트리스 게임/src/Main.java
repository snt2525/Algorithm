import java.util.*;
public class Main {
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static int[][] map;
	static int[][] log;
	static int n;
	static int max = 0;
	
	static void dfs(int a,int b,int cnt,int sum) {
		if(cnt == 4) max = Math.max(max, sum);	
		log[a][b] = 1;
		for(int i =0;i<4;i++) {
			int x = a + dir[i][0];
			int y = b + dir[i][1];
			if(x<0||y<0||x>=n||y>=n)continue;
			if(log[x][y] == 0) {
				dfs(x,y,cnt+1,sum+map[x][y]);
				log[x][y] = 0;
			}
		}
		log[a][b] = 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 n = sc.nextInt();
		 map = new int[n][n];
		 log = new int[n][n];
		 for(int i = 0;i<n;i++) { 
			 for(int j=0;j<n;j++) { 
				 map[i][j] = sc.nextInt();
			 }
		 }
		 
		 
		 
	}
}
