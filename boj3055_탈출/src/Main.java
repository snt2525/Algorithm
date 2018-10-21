import java.util.*;

class Pair{
	int x = 0;
	int y = 0;
	Pair(int a,int b){
		this.x = a;
		this.y = b;
	}
}

class Biber{
	int x = 0;
	int y = 0;
	int cnt = 0;
	Biber(int a,int b,int c){
		this.x = a;
		this.y = b;
		this.cnt = c;
	}
}

public class Main {
	static Queue<Pair> water = new LinkedList<Pair>();
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static int[][] log;
	static String[][] map;
	static int n,m;
	static int min = Integer.MAX_VALUE;
	
	static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
	}
	
	static void bfs(int startX,int startY,int finalX,int finalY) {
		Queue<Biber> q = new LinkedList<Biber>();
		q.add(new Biber(startX,startY,0));
		log[startX][startY] = 1;
		
		while(!q.isEmpty()) {
			waterFull(finalX,finalY);
			int size = q.size();
			for(int k= 0;k<size;k++) {
				Biber tmp = q.remove();
				if(tmp.x == finalX&& tmp.y == finalY) { 
					min = tmp.cnt;
					return;
				}
				for(int i=0;i<4;i++) {
					int x = tmp.x + dir[i][0];
					int y = tmp.y + dir[i][1];
					if(x<0||y<0||x>=n||y>=m||log[x][y]!=0)continue;
					map[x][y]="S";
					log[x][y] = 1;
					q.add(new Biber(x,y,tmp.cnt + 1));
				}
				//print();
			}
		}	
	}
	
	static void waterFull(int finalX,int finalY) {  //È«¼ö´Â 2 
		int size = water.size();
		for(int i =0;i<size;i++) {
			Pair tmp = water.remove();
			for(int j=0;j<4;j++) {
				int x = tmp.x + dir[j][0];
				int y = tmp.y + dir[j][1];
				if(x == finalX && y == finalY) continue;
				if(x<0||y<0||x>=n||y>=m||log[x][y]==2||map[x][y].equals("D")||map[x][y].equals("X")) continue;		
				map[x][y] = "*";
				water.add(new Pair(x,y));
				log[x][y] = 2;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		log = new int[n][m];
		map = new String[n][m];
		int x = 0,y = 0;
		int fx = 0,fy = 0;
		String[] tmp = sc.nextLine().trim().split("");
		
		for(int i =0;i<n;i++) {
			tmp = sc.nextLine().trim().split("");
			for(int j=0;j<m;j++) {
				if(tmp[j].equals("S")) {
					x = i; y = j;
				}else if(tmp[j].equals("*")) {
					water.add(new Pair(i,j));
					log[i][j] = 2;
				}else if(tmp[j].equals("D")) {
					fx = i; fy = j;
				}else if(tmp[j].equals("X")) {
					log[i][j] = 3;
				}
				map[i][j] = tmp[j];
			}
		}
		
		bfs(x,y,fx,fy);
		
		if(min == Integer.MAX_VALUE) 
			System.out.println("KAKTUS");
		else
			System.out.println(min);
	}
}
