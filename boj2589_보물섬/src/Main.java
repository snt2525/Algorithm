import java.util.*;

class Pair{
	int x = 0;
	int y = 0;
	int cnt = 0; 
	Pair(int a, int b,int c){
		this.x = a;
		this.y = b;
		this.cnt = c;
	}
}

public class Main {
	static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	static int[][] map;
	static int[][] log;
	static int n,m;
	static int max = 0;
	
	static void bfs(int startX, int startY) {
		log = new int[n][m];
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(startX,startY,0));
		log[startX][startY] = 1;
		while(!q.isEmpty()) {
			Pair tmp = q.remove();
			for(int i =0;i<4;i++) {
				int x = tmp.x + dir[i][0];
				int y = tmp.y + dir[i][1];
				if(x<0||y<0||x>=n||y>=m||log[x][y]==1||map[x][y]==1)continue;
				q.add(new Pair(x,y,tmp.cnt+1));
				log[x][y] = 1;
				max = Math.max(max, tmp.cnt+1);
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		
		String[] tmp = sc.nextLine().trim().split("");
		for(int i = 0;i<n;i++) {
			tmp = sc.nextLine().trim().split("");
			for(int j = 0;j<m;j++) {
				if(tmp[j].equals("W")){
					map[i][j] = 1;
				}else if(tmp[j].equals("L"))
					map[i][j] = 2;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==2)
					bfs(i,j);
			}
		}
		
		System.out.println(max);
				
	}
}
