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
	static LinkedList<Pair> q = new LinkedList<Pair>(); //바이러스
	static int[][] dir = {{1,0},{0,1},{0,-1},{-1,0}};
	static int[][] map;
	static int[][] log;
	static int n,m;
	static int min = Integer.MAX_VALUE;
	static int result = 0;
	static void bfs() {
		int count = 0;
		Queue<Pair> tmpQ = new LinkedList<Pair>(); //바이러스
		int size = q.size();
		log = new int[n][m];
		for(int i =0;i<size;i++) {
			log[q.get(i).x][q.get(i).y] = 1;
			tmpQ.add(q.get(i));
		}
		
		while(!tmpQ.isEmpty()) {
			Pair tmp = tmpQ.remove();
			count++;
			if(count>min) {
				return;
			}
			for(int i = 0;i<4;i++) {
				int x = tmp.x + dir[i][0];
				int y = tmp.y + dir[i][1];
				if(x<0||y<0||x>=n||y>=m)continue;
				if(log[x][y]==0&&map[x][y]==0) {
					log[x][y] = 1;
					tmpQ.add(new Pair(x,y));
				}
			}
		}
		min = Math.min(min, count);
		if(min == count) {
			result = 0;
			for(int i =0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(log[i][j] == 0&&map[i][j] == 0) result++;
				}
			}
		}
	}
	
	static void block() {
		for(int i =0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] != 0)continue;
				map[i][j] = 3;
				for(int k = 0;k<n;k++) {
					for(int h = 0;h<m;h++) {
						if(map[k][h] != 0)continue;
						map[k][h] = 3;
						for(int g = 0;g<n;g++) {
							for(int f = 0;f<m;f++) {
								if(map[g][f] != 0)continue;
								map[g][f] = 3;
									bfs();
								map[g][f] = 0;
							}
						}
						map[k][h] = 0;
					}
				}
				map[i][j] = 0;
			}
		}
	}
	
	static void print() {
		System.out.println();
		for(int i =0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		int maxCnt = -3 ;	
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) q.add(new Pair(i,j));
			}
		}
		block();
		System.out.println(result);
		
	}
}
