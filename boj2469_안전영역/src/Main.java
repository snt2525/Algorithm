import java.util.*;
class Pair{
	int x = 0;
	int y = 0;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	static int[][] map;
	static int[][] log;
	static int n;
	
	static void bfs(int i,int startX,int startY) {
		Queue<Pair> q = new LinkedList<Pair>();
		log[startX][startY] = 1;
		q.add(new Pair(startX,startY));
		
		while(!q.isEmpty()) {
			Pair tmp = q.remove();
			for(int j=0;j<4;j++) {
				int x = tmp.x + dir[j][0];
				int y = tmp.y  + dir[j][1];
				if(x<0||y<0||x>=n||y>=n||map[x][y]<=i||log[x][y]==1)continue;
				log[x][y] = 1;
				q.add(new Pair(x,y));
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		
		int max = 0;
		for(int i= 0 ;i<n;i++) {
			for(int j =0;j<n;j++) {
				map[i][j] = sc.nextInt();
				max = Math.max(max, map[i][j]);
			}
		}
		
		int resultMax = 0;
		for(int i = 0;i <= max;i++) {
			int saveCnt = 0;
			log = new int[n][n]; 
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(map[j][k]>i&&log[j][k]==0) {
						saveCnt++;
						bfs(i,j,k);
					}
				}
			}
			resultMax = Math.max(resultMax, saveCnt);			
		}
		
		System.out.println(resultMax);		
	}
}
