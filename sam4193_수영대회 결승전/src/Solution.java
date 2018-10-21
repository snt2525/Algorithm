import java.util.*;
class Pair{
	int x,y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Solution {
	static int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};
	static int n;
	static int result;
	static int[][]map;
	static int[][]log;
	static void BFS(int sx, int sy, int fx, int fy) {
		result = Integer.MAX_VALUE;
		Queue<Pair> q = new LinkedList<Pair>();
		log[sx][sy] = 1;
		q.add(new Pair(sx, sy));
		int time = 0;
		int water = 3;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0;i < size;i++) {
				Pair tmp = q.remove();
				if(map[tmp.x][tmp.y] == 2 && water != 0) {
					q.add(new Pair(tmp.x, tmp.y));
				}else {
					for(int j = 0;j < 4;j++) {
						int x = tmp.x + dir[j][0];
						int y = tmp.y + dir[j][1];
						if(x < 0||y < 0||x >= n||y >= n||map[x][y] == 1)continue;
						if(x == fx && y == fy) {
							result = time + 1;
							return;
						}
						if(log[x][y] == 0) {
							log[x][y] = time + 1;
							q.add(new Pair(x, y));
						}
					}		
				}
			}
			time++;
			if(water == 0)
				water = 2;
			else
				water--;
		}
		result = -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1;t <= test;t++) {
			n = sc.nextInt();
			map = new int[n][n];
			log = new int[n][n];
			for(int i = 0;i < n;i++)
				for(int j = 0;j < n;j++)
					map[i][j] = sc.nextInt();
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			int fx = sc.nextInt();
			int fy = sc.nextInt();
			BFS(sx, sy, fx, fy);
			System.out.println("#"+t+" "+result);
		}
		sc.close();
	}
}
