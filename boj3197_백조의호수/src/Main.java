import java.util.*;

class Pair{
	int x = 0;
	int y = 0;
	Pair(int a,int b){
		this.x = a;
		this.y = b;
	}
}

class SwanPair{
	int x = 0;
	int y = 0;
	int cnt = 0;
	SwanPair(int a,int b,int c){
		this.x = a;
		this.y = b;
		this.cnt = c;
	}
}

public class Main {
	static int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};
	static Queue<Pair> q = new LinkedList<Pair>();
	static int[][] swanPosition = new int[2][2];
	static String[][] map;
	static int[][] meltIce;
	static int result = Integer.MAX_VALUE;
	static int n;
	static int m;
	
	static void print() {
		for(int i=0;i<n;i++) {
			System.out.println();
			for(int j=0;j<m;j++) {
				System.out.print(meltIce[i][j]);
			}
		}
		System.out.println();
	}
	
	static void bfs() {	 //먼저 돌려본다. 
		int dayCnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			dayCnt++;
			for(int j=0;j<size;j++) {
				boolean flag = true;
				Pair tmp = q.remove();
				for(int i =0;i<4;i++) {
					int x = tmp.x + dir[i][0];
					int y = tmp.y + dir[i][1];
					if(x<0||y<0||x>=n||y>=m)continue;
					if(map[x][y].equals(".") && meltIce[x][y] == 0) {
						meltIce[tmp.x][tmp.y] = dayCnt;
						map[tmp.x][tmp.y] = ".";
						flag = false;
						break;
					}			
				}
				if(flag) q.add(new Pair(tmp.x,tmp.y));
			}		
			//print();	
		}
		swan_bfs();
		//BinarySearch(dayCnt);
	}	
	
	/*
	static void BinarySearch(int max) {  // 이분탐색을 통해
		int low = 0;
		int mid = 0;
		while(low<=max) {
			mid = (low + max) / 2;
			if(!swan_bfs(mid)) low = mid + 1;
			else max = mid - 1;
		}
		result = mid;
	}*/
	
	static void swan_bfs() {
		int[][] log = new int[n][m];
		Queue<SwanPair> swanQ = new LinkedList<SwanPair>();
		swanQ.add(new SwanPair(swanPosition[0][0],swanPosition[0][1],0));
		log[swanPosition[0][0]][swanPosition[0][1]] = 1;
		
		while(!swanQ.isEmpty()){
			SwanPair tmp = swanQ.remove();
			for(int i =0;i<4;i++) {
				int x = tmp.x + dir[i][0];
				int y = tmp.y + dir[i][1];
				if(x<0||y<0||x>=n||y>=m) continue;
				if(log[x][y] == 0 && meltIce[x][y]<=result) {
					log[x][y] = 1;
					swanQ.add(new SwanPair(x,y,Math.max(tmp.cnt,meltIce[tmp.x][tmp.y])));
					if(x == swanPosition[1][0] && y == swanPosition[1][1]) {
						result =Math.min(result, tmp.cnt);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new String[n][m];
		meltIce = new int[n][m];
		int cnt = 0;
		
		String[] s = sc.nextLine().trim().split("");
		for(int i=0;i<n;i++) {
			s = sc.nextLine().trim().split("");
			for(int j=0;j<m;j++) {
				map[i][j] = s[j];
				if(s[j].equals("X")) {
					q.add(new Pair(i,j));
				}else if(s[j].equals("L")) {
					map[i][j] = ".";
					swanPosition[cnt][0] = i;
					swanPosition[cnt++][1] = j;
				}
			}
		}
		
		bfs();
		System.out.println(result);
	}
}
