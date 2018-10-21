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
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static int[][] map;
	static int[][] log;
	static int[][] visit;
	static int n,m;
	static int day = 0;
	static int cnt = 0;
	static void bfs() {
		
		while(cnt>0) {
			log = new int[n][m];
			visit = new int[n][m];
			Queue<Pair> q = new LinkedList<Pair>();
			Queue<Pair> removeQ = new LinkedList<Pair>();
			q.add(new Pair(0, 0));
			while(!q.isEmpty()) {
				Pair tmp =  q.remove();
				for(int i = 0;i<4;i++) {
					int x = tmp.x + dir[i][0];
					int y = tmp.y + dir[i][1];
					if(x<0||y<0||x>=n||y>=m) continue;				
					if(map[x][y] == 0 && visit[x][y] == 0) {
						q.add(new Pair(x,y));
						visit[x][y] = 1;
					}else if(map[x][y] == 1) {
						log[x][y]++;		
						if(log[x][y]>=2) removeQ.add(new Pair(x,y));
					}				
				}
			}
			remove(removeQ);	
			day++;
		}
		
				
	}
	static void remove(Queue<Pair> removeQ) {
		int size  = removeQ.size();
		while(size-- > 0) {
			Pair tmp = removeQ.remove();
			if(map[tmp.x][tmp.y] == 1) cnt--;
			map[tmp.x][tmp.y] = 0;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j] == 1 ) cnt++;
			}
		}
		bfs();
		System.out.println(day);
	}
}
