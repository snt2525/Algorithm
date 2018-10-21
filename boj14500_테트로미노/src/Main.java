import java.util.*;
public class Main {
	static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
	static int[][] map;
	static int[][] log;
	static int n,m;
	static int max = Integer.MIN_VALUE;
	
	static void dfs(int a,int b,int sum,int cnt) {
		if(cnt == 4) {
			max = Math.max(max,sum);
			return;
		}
		
		for(int i =0;i<4;i++) { 
			int x = a + dir[i][0];
			int y = b + dir[i][1];
			if(x<0||y<0||x>=n||y>=m)continue;
			if(log[x][y] == 0) { 
				log[x][y] = 1;
				dfs(x,y,sum+map[x][y],cnt+1);
				log[x][y] = 0;
			}
		}
	}
	
	static void dfsExcept(int a,int b,int sum) {
		int cnt = 1;
		for(int i = 0;i<4;i++) {
			int x = a + dir[i][0];
			int y = b + dir[i][1];
			if(x<0||y<0||x>=n||y>=m)continue;
			cnt++;
			sum += map[x][y]; 
		}
		if(cnt == 5) {
			for(int i =0;i<4;i++) {
				int x = a + dir[i][0];
				int y = b + dir[i][1];
				if(x<0||y<0||x>=n||y>=m)continue;
				max = Math.max(max, sum - map[x][y]);
			}
		}else
			max = Math.max(max, sum);
			
	}
	
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		log = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i =0;i<n;i++) {
			for(int j=0;j<m;j++) {
				log[i][j] = 1;
				dfs(i,j,map[i][j],1); //일반 애들 검사한다.
				dfsExcept(i,j,map[i][j]); //예외를 처리해준다.
				log[i][j] = 0;
			}
		}
		
		System.out.println(max);
	}
}
