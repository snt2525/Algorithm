import java.util.*;
public class Main {
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static String[][] map;
	static int[][] visit;
	static int[] log = new int[100];
	static int r,c;
	static int max = 0;
	static void dfs(int x,int y,int cnt) {
		max = Math.max(max, cnt);	
		int tmpNum = map[x][y].charAt(0);
		log[tmpNum] = visit[x][y] = 1;
		for (int i=0;i<4;i++) {
			int xx = x + dir[i][0];
			int yy = y + dir[i][1];
			if(xx<0||yy<0||xx>=r||yy>=c) continue;
			int tmp = map[xx][yy].charAt(0);
			if(log[tmp] == 0 && visit[xx][yy] == 0) { 
				dfs(xx,yy,cnt + 1);
			}
		}
		visit[x][y] = log[tmpNum] = 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		map = new String[r][c];
		visit = new int[r][c];
		String[] s = sc.nextLine().trim().split("");
		
		for(int i = 0;i < r;i++) {
			s = sc.nextLine().trim().split("");
			for(int j = 0;j < c;j++) {
				map[i][j] = s[j];
			}
		}	
		dfs(0,0,1);				
		System.out.print(max);
	}
}
