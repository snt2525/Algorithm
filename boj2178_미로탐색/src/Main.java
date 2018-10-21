import java.util.*;

class Pair{
	int x = 0;
	int y = 0;
	int cnt = 0;
	Pair(int a,int b,int c){
		this.x = a;
		this.y = b;
		this.cnt = c;
	}
}
public class Main {
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static int[][] map;
	static int[][] visit;
	static int n;
	static int m;
	static int bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,0,1));
		visit[0][0]=1;
		while(!q.isEmpty()){
			Pair tmp = q.remove();
			if(tmp.x == (n-1) && tmp.y == (m-1)) return tmp.cnt;
			for(int i =0;i<4;i++) {
				int x = tmp.x + dir[i][0];
				int y = tmp.y + dir[i][1];
				if(x < 0||y < 0||x >= n||y >= m||map[x][y] == 0 ||visit[x][y] == 1) continue;
				visit[x][y]=1;
				q.add(new Pair(x,y,tmp.cnt + 1));
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visit = new int[n][m];
		String[] tmp = sc.nextLine().trim().split("");
		for(int i =0;i<n;i++) {
			tmp = sc.nextLine().trim().split("");
			for(int j=0;j<m;j++) {
				map[i][j]= Integer.parseInt(tmp[j]);
			}
		}
		
		int result = bfs();
		System.out.println(result);
	}
}
