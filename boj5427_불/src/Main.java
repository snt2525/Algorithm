import java.util.*;

class Pair{
	int x = 0;
	int y = 0;
	Pair(int a,int b){
		this.x = a;
		this.y = b;
	}
}

class Pair2{
	int x = 0;
	int y = 0;
	int cnt = 0;
	Pair2(int a,int b,int c){
		this.x = a;
		this.y = b;
		this.cnt = c;
	}
}

public class Main {
	static Queue<Pair> fire;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static String[][] map;
	static int[][] log;
	static Pair mePosit;
	static int n,m;
	static int minTime;
	
	static void bfs() {
		Queue<Pair2> q = new LinkedList<Pair2>();
		log[mePosit.x][mePosit.y] = 1;
		q.add(new Pair2(mePosit.x,mePosit.y,0));
		
		while(!q.isEmpty()) {
			int size = q.size();
			fireSpreads();
			for(int time = 0;time<size;time++) {
				Pair2 tmp = q.remove();
				for(int i =0;i<4;i++) {
					int x = tmp.x + dir[i][0];
					int y = tmp.y + dir[i][1];
					if(x<0||y<0||x>=n||y>=m) { //Å»Ãâ ¼º°ø
						minTime = tmp.cnt + 1;
						return;
					}
					if(map[x][y].equals(".")&&log[x][y] == 0) {
						q.add(new Pair2(x,y,tmp.cnt+1));
						log[x][y] = 1;
					}
				}
			}		
		}
		minTime = -1;
	}
	
	static void fireSpreads() {
		int size = fire.size();
		for(int i =0;i<size;i++) {
			Pair tmp = fire.remove();
			for(int j = 0; j < 4; j++ ) {
				int x = tmp.x + dir[j][0];
				int y = tmp.y + dir[j][1];
				if(x>=0&&y>=0&&x<n&&y<m&map[x][y].equals(".")) {
					map[x][y] = "*";
					fire.add(new Pair(x,y));
				}
			}
		}		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int testCase = 0; testCase < t; testCase++) {
			fire = new LinkedList<Pair>();
			m = sc.nextInt();
			n = sc.nextInt();
			map = new String[n][m]; 
			log = new int[n][m];
			
			String[] s = sc.nextLine().trim().split("");
			for(int i =0;i<n;i++) {
				s = sc.nextLine().trim().split("");
				for(int j=0;j<m;j++) {
					map[i][j] = s[j];
					if(map[i][j].equals("@")){
						mePosit = new Pair(i,j);
					}else if(map[i][j].equals("*")){
						fire.add(new Pair(i,j));
					}
				}
			}
			
			bfs();			
			if(minTime == -1) {
				System.out.println("IMPOSSIBLE");
			}else {
				System.out.println(minTime);
			}			
		}
	}
}
