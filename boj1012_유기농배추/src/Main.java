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
	static Queue<Pair> q = new LinkedList<Pair>();
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static int[][] map;
	static int[][] log;
	static int n,m;
	
	static void bfs(int startX, int startY) {
		 Queue<Pair> tmpQ = new LinkedList<Pair>();
		 tmpQ.add(new Pair(startX,startY));
		 while(!tmpQ.isEmpty()) {
			 Pair tmp = tmpQ.remove();
			 for(int i =0;i<4;i++) {
				 int x = tmp.x + dir[i][0];
				 int y = tmp.y + dir[i][1];
				 if(x<0||y<0||x>=n||y>=m||log[x][y] == 1 ||map[x][y] == 0)continue;
				 tmpQ.add(new Pair(x,y));
				 log[x][y] = 1;
			 }
		 }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int testCase = 0;testCase<T;testCase++) {
			n = sc.nextInt();
			m = sc.nextInt();
			map = new int[n][m]; 
			log = new int[n][m];
			
			int loop = sc.nextInt();
			
			for(int i =0;i<loop;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[a][b] = 1;
				q.add(new Pair(a,b));
			}
			int result = 0;
			int size = q.size();
			
			for(int i =0;i<size;i++) {
				Pair tmp  = q.remove();
				if(log[tmp.x][tmp.y] == 0) {
					result++;
					bfs(tmp.x,tmp.y);
				}
			}
			
			System.out.println(result);
		}
	}
}
