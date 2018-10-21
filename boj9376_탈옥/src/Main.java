import java.util.*;

class Pair2{ 
	int x = 0;
	int y = 0;
	Pair2(int a,int b){
		this.x = a;
		this.y = b;
	}
}

class Pair{ 
	int x = 0;
	int y = 0;
	int open = 0;
	int find = 0;
	Pair(int a,int b,int c,int d){
		this.x = a;
		this.y = b;
		this.open = c;
		this.find = d; 
	}
}

public class Main {
	static Queue<Pair2> door = new LinkedList<Pair2>();
	static Queue<Pair> q =new LinkedList<Pair>();
	static int[][] dir= {{1,0},{0,1},{0,-1},{-1,0}};
	static String[][] map;
	static int[][] log;
	static int n,m;
	static int min = Integer.MAX_VALUE;
	
	static void print() {
		System.out.println();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(log[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	// 초기화
	static void init() {
		int size = door.size();		
		
		for(int i = 0;i<size;i++) {
			Pair2 tmp = door.remove();			
			if(map[tmp.x][tmp.y].equals(".")) {
				log[tmp.x][tmp.y]= 0;
				q.add(new Pair(tmp.x,tmp.y,0,0));
			}else if(map[tmp.x][tmp.y].equals("#")) {
				log[tmp.x][tmp.y]= 1;
				q.add(new Pair(tmp.x,tmp.y,1,0));
			}else if(map[tmp.x][tmp.y].equals("$")) {
				log[tmp.x][tmp.y]= 0;
				q.add(new Pair(tmp.x,tmp.y,0,1));
			}	
		}	
	}
	
	static void bfs() {// 공간은 '.', 지나갈 수 없는 벽은 '*', 문은 '#', 죄수의 위치는 '$'이다.
		init();
		
		while(!q.isEmpty()) {
			Pair tmp = q.remove();		
			for(int i =0;i<4;i++) {
				int x = tmp.x + dir[i][0];
				int y = tmp.y + dir[i][1];
				if(x<0||y<0||x>=n||y>=m||map[x][y].equals("*"))continue;
				if(log[x][y]!= -1 && log[x][y]<=tmp.open) continue;  //가지치기
				
				if(map[x][y].equals(".")) {		//빈공간일 때
					q.add(new Pair(x,y,tmp.open,tmp.find));	
					log[x][y] = log[x][y] == -1? tmp.open : Math.min(log[x][y], tmp.open);				
				}else if(map[x][y].equals("#")) { //문일 때
					q.add(new Pair(x,y,tmp.open + 1,tmp.find));	
					log[x][y] = log[x][y] == -1? tmp.open+1 : Math.min(log[x][y], tmp.open + 1);				
				}else if(map[x][y].equals("$")) { //찾았을 때
					if(tmp.find == 1) {
						min = Math.min(min, tmp.open);
						continue;
					}
					q.add(new Pair(x,y,tmp.open,1));
					log[x][y] = log[x][y] == -1? tmp.open : Math.min(log[x][y], tmp.open);				
				}	
				print();
			}
		}		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int testCase = 0; testCase < t; testCase++) {
			n = sc.nextInt();
			m = sc.nextInt();
			map = new String[n][m];
			log = new int[n][m];
			
			String[] s = sc.nextLine().trim().split("");
			for(int i =0;i<n;i++) {
				s = sc.nextLine().trim().split("");
				for (int j=0;j<m;j++) {
					map[i][j] = s[j];
					log[i][j] = -1;
					if((i==0||j==0||i==(n-1)||j==(m-1))&&!map[i][j].equals("*"))
						door.add(new Pair2(i,j));	
				}
			}
			
			bfs();
			System.out.println(min);			
	 	} 
	}
}
