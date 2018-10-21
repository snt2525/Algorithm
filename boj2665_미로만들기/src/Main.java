import java.util.*;
class Pair{
	int x,y;
	int cnt = 0;
	Pair(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
public class Main {
	static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
	static int[][] map;
	static int[][] log;
	static int n;
	static int result = Integer.MAX_VALUE;
	static void BFS() {
		log = new int[n][n];
		for(int i = 0;i < n;i++)
			for(int j = 0;j < n;j++)
				log[i][j] = Integer.MAX_VALUE;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0, 0, 0));
		log[0][0] = 0;
		while(!q.isEmpty()) {
			int s = q.size();
			for(int j = 0;j < s;j++) {
				Pair tmp = q.remove();
				for(int i = 0;i < 4;i++) {
					int x = tmp.x + dir[i][0];
					int y = tmp.y + dir[i][1];
					if(x < 0||y < 0||x >= n||y >= n)continue;
					if(x == (n - 1) && y == (n - 1)) {
						result = Math.min(tmp.cnt, result);
						continue;
					}
					if(log[x][y] > tmp.cnt) {
						if(map[x][y] == 0) { 
							log[x][y] = tmp.cnt + 1;
							q.add(new Pair(x, y, tmp.cnt + 1));
						}else {
							log[x][y] = tmp.cnt;
							q.add(new Pair(x, y, tmp.cnt));
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		String[] tmp = sc.nextLine().trim().split("");
		for(int i = 0;i < n;i++) {
			tmp = sc.nextLine().trim().split("");
			for(int j = 0;j < n;j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}		
		BFS();
		System.out.println(result);
	}

}
