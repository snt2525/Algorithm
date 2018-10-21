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
	static int[][] map;
	static int[][] log;
	static int n,m,k;
	
	static int bfs(int startX,int startY) {
		int cnt = 1;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(startX,startY));
		log[startX][startY] = 1;
		
		while(!q.isEmpty()) {
			Pair tmp = q.remove();
			for(int i =0;i<4;i++) {
				int x = tmp.x + dir[i][0];
				int y = tmp.y + dir[i][1];
				if(x<0||y<0||x>=n||y>=m||log[x][y]==1||map[x][y]!=0) continue;
				q.add(new Pair(x,y));
				log[x][y] = 1;
				cnt++;
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		map = new int[n][m];
		log = new int[n][m];
		
		for(int i =0;i<k;i++) { //½ÃÀÛ (aX,aY) ³¡(bX,bY)
			int aX = sc.nextInt(); 
			int aY = sc.nextInt();
			int bX = sc.nextInt();
			int bY = sc.nextInt();
			for(int j=aY;j<bY;j++) {
				for(int h=aX;h<bX;h++) {
					map[j][h] = 1;
				}
			}
		}
		int result = 0;
		LinkedList<Integer> cnt = new LinkedList<Integer>();		
		for(int i =0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 0 && log[i][j] == 0) {
					result++;
					cnt.add(bfs(i,j));
				}
			}
		}
		Collections.sort(cnt);
		System.out.println(result);
		for(int i =0;i<result;i++)
			System.out.print(cnt.remove()+" ");
	}
}
