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
	static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	static int[][] map;
	static int[][] log;
	static int n;
	
	static void bfs_RGB(int c,int startX,int startY) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(startX,startY));
		log[startX][startY] = 1;
		while(!q.isEmpty()) {
			Pair tmp = q.remove();
			for(int i=0;i<4;i++) {
				int x = tmp.x + dir[i][0];
				int y = tmp.y + dir[i][1];
				if(x<0||y<0||x>=n||y>=n||log[x][y]==1) continue;
				if(c == map[x][y]) {
					log[x][y] = 1;
					q.add(new Pair(x,y));
				}
			}
		}
	}
	
	static void bfs_RG(int startX,int startY) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(startX,startY));
		log[startX][startY] = 1;
		while(!q.isEmpty()) {
			Pair tmp = q.remove();
			for(int i=0;i<4;i++) {
				int x = tmp.x + dir[i][0];
				int y = tmp.y + dir[i][1];
				if(x<0||y<0||x>=n||y>=n||log[x][y]==1) continue;
				if(1 == map[x][y]||2 == map[x][y]) {
					log[x][y] = 1;
					q.add(new Pair(x,y));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		String[] tmp = sc.nextLine().trim().split("");
		map = new int[n][n];
		log = new int[n][n];
		for(int i =0;i<n;i++) {
			tmp = sc.nextLine().trim().split("");
			for(int j=0;j<n;j++) {
				if(tmp[j].equals("R"))
					map[i][j] = 1;
				else if(tmp[j].equals("G"))
					map[i][j] = 2;
				else if(tmp[j].equals("B"))
					map[i][j] = 3;
			}
		}
		
		int cnt1 = 0;
		int cnt2 = 0;
		for(int i = 1; i<=3; i++) {
			for(int j = 0;j<n;j++) {
				for(int h = 0;h<n;h++) {
					if(map[j][h] == i &&log[j][h] == 0) {
						cnt1 ++;
						bfs_RGB(i,j,h);
						if(i == 3) cnt2++;
					}
				}
			}
		}
		
		log = new int[n][n];
		for(int j = 0;j<n;j++) {
			for(int h = 0;h<n;h++) {
				if((map[j][h] == 1 || map[j][h] == 2) &&log[j][h] == 0) {
					cnt2 ++;
					bfs_RG(j,h);
				}
			}
		}
		
		System.out.println(cnt1+" "+cnt2);
	}
}
