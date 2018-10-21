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
	static ArrayList<ArrayList<Pair>> bridge = new ArrayList<ArrayList<Pair>>();
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static int[][] map;
	static int[][] island;
	static int n;
	static int min = Integer.MAX_VALUE;
	
	static void print(int[][] visit) {
		System.out.println();
		for(int i =0;i<n;i++){
			for(int j=0;j<n;j++) {
				System.out.print(visit[i][j]+" "); 
			}
			System.out.println();
		}
	}
	
	static void FindIsland(int a,int startX,int startY) {
		Queue<Pair> q= new LinkedList<Pair>();
		island[startX][startY] = a;
		bridge.get(a).add(new Pair(startX,startY));
		q.add(new Pair(startX,startY));
		
		while(!q.isEmpty()) {
			Pair tmp = q.remove();
			for(int i =0;i<4;i++) {
				int x = tmp.x + dir[i][0];
				int y = tmp.y + dir[i][1];
				if(x<0||y<0||x>=n||y>=n||map[x][y]==0||island[x][y]!=0)continue;				
				island[x][y] = a;
				bridge.get(a).add(new Pair(x,y));
				q.add(new Pair(x,y));
			}
		}		
	}
	
	static void bfs(int num, int startX,int startY) { //다리잇기
		int[][] visit = new int[n][n];
		Queue<Pair2> q = new LinkedList<Pair2>();
		visit[startX][startY] = 1;
		q.add(new Pair2(startX,startY,0));
		
		while(!q.isEmpty()) {
			Pair2 tmp = q.remove();
			if(tmp.cnt > min) continue;  // 가지치기
			for(int i =0;i<4;i++) { 
				int x = tmp.x + dir[i][0];
				int y = tmp.y + dir[i][1];
				if(x<0||y<0||x>=n||y>=n||visit[x][y]==1||island[x][y]==num)continue;	
				if(island[x][y] !=0 && island[x][y] != num) {
					min = Math.min(min, tmp.cnt);
					//print(visit);
					continue;
				}
				q.add(new Pair2(x,y,tmp.cnt+1));
				visit[x][y] = 1;
			}
		}
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		n = sc.nextInt();
		map = new int[n][n];
		island = new int[n][n];	
		
		for(int i =0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<=10000;i++)
			bridge.add(new ArrayList<Pair>());
		
		int cnt = 1;
		for(int i =0;i<n;i++) { //아일랜드 마다 번호 메기기
			for(int j=0;j<n;j++) {
				if(map[i][j]==1&&island[i][j]==0) {
					FindIsland(cnt++,i,j);
				}
			}
		}
			
		for(int i =1;i<cnt;i++) {
			int size = bridge.get(i).size();
			for(int j=0;j<size;j++) {
				Pair tmp = bridge.get(i).remove(0);
				bfs(island[tmp.x][tmp.y],tmp.x,tmp.y);
			}
		}
		
		System.out.println(min);
	}
}
