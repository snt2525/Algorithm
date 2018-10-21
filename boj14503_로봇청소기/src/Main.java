import java.util.*;
public class Main {
	static int n,m;
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static int[][] map;
	static int[][] log;
	static int clean = 1;
	static boolean flag = false;
	static void dfs(int x,int y,int d) {
		boolean cleaning = false;
		int tmp = d;
		for(int i =0;i<4;i++) {
			//여기서 d를 정해준다
			if(d == 0 || d == 1) d = d == 0 ? 3 : 0;
			else if(d == 3|| d == 2) d = d == 3 ?  2 : 1;		
			int xx = x + dir[d][0];
			int yy = y + dir[d][1];
			if(map[xx][yy]==1||log[xx][yy]!=0) continue;
			log[xx][yy] = ++clean;
			cleaning = true;
			//print();
			dfs(xx, yy,d);
			if(flag) return;
		}
		//뒤가 벽이면 멈춘다.		
		//여기서 d를 정해준
		if(tmp == 0 || tmp == 1) tmp = tmp== 0 ? 2 : 3;
		else if(tmp == 3|| tmp == 2) tmp = tmp == 3 ?  1 : 0;	
		if(!cleaning && map[x+dir[tmp][0]][y+dir[tmp][1]]==1)
			flag = true;
		else 
			dfs(x + dir[tmp][0],y + dir[tmp][1],d);
		
	}
	
	static void print() {
		System.out.println();
		for(int i =0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(log[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		log = new int[n][m];
		map = new int[n][m];
		int startX = sc.nextInt();
		int startY = sc.nextInt();
		int d = sc.nextInt();
		
		for(int i =0;i<n;i++) 
			for(int j=0;j<m;j++) 
				map[i][j] = sc.nextInt();
			
		log[startX][startY] = 1;
		dfs(startX,startY,d);
		
		System.out.println(clean);
	
	}
}
