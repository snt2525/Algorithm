import java.util.*;

class Pair{
	int x = 0;
	int y = 0;
	Pair(int a,int b){
		this.x = a;
		this.y = b;
	}
}

public class Main {
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static int[][] visit;
	static int[][] map;
	static int[][] log;
	static int n,m;
	
	static void print() {
		System.out.println();
		for(int i =0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static int checkLand() {
		int cnt = 0;
		for(int i =0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]>0) cnt++; 
			}
		}
		return cnt;
	}
	
	static int bfs(int startX,int startY) {
		int cnt = 1;
		log = new int[n][m];
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(startX,startY));
		log[startX][startY] = 1;
		while(!q.isEmpty()) {
			Pair tmp = q.remove();
			for(int i =0;i<4;i++) {
				int x = tmp.x + dir[i][0];
				int y = tmp.y + dir[i][1];
				if(x<0||y<0||x>=n||y>=m||log[x][y]==1||map[x][y]==0)continue;
				log[x][y] = 1;
				q.add(new Pair(x,y));
				cnt++;
			}
		}
		return cnt;
	}
	
	static void meltIceLand(int startX,int startY) {
		Queue<Pair> ice = new LinkedList<Pair>();
		visit[startX][startY] = 1;
		ice.add(new Pair(startX,startY));
		while(!ice.isEmpty()) {
			Pair tmp = ice.remove();
			for(int i = 0;i<4;i++) {
				int x = tmp.x + dir[i][0];
				int y = tmp.y + dir[i][1];
				if(x<0||y<0||x>=n||y>=m||visit[x][y]==1)continue;
				if(map[x][y]>0) {
					map[x][y]--;	
					if(map[x][y]==0)visit[x][y] = 1;
				}else {
					ice.add(new Pair(x,y));
					visit[x][y] = 1;
				}
			}
		}
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		int cnt1 = 1,cnt2 = 0;
		int max = 0;
		
		for(int i =0;i<n;i++) {
			for(int j =0;j<m;j++) {
				map[i][j] = sc.nextInt();
				//if(i==0||i==n-1||j==0||j==m-1) 
				//	map[i][j] = 0;
				max = Math.max(max, map[i][j]);
			}
		}
		int t = 0;
		while(cnt1 != 0 ){
			cnt1 = checkLand();
			visit = new int[n][m];
			//print();
			for(int i =1;i<n-1;i++) {
				for(int j=1;j<m-1;j++) {
					 if(map[i][j]>0) {
						cnt2 = bfs(i,j);
						if(cnt1!= cnt2) {							
							System.out.println(t);
							return;
						}
						i = n;
						break;
					}
				}
			}
			
			for(int i =0;i<n;i++) {  //¾óÀ½ ³ìÀÌ±â
				for(int j=0;j<m;j++) {
					if(visit[i][j]==0&&map[i][j]==0)
						meltIceLand(i,j);
				}
			}
			t++;
		}
		
		System.out.print("0");	
	}
}
