import java.util.*;

class Pair{
	int x; 
	int y;
	Pair(int a,int b){
		this.x = a;
		this.y = b;
	}
}

class Pair2{
	int x; 
	int y;
	int time;
	Pair2(int a,int b,int d){
		this.x = a;
		this.y = b;
		this.time = d;
	}
}

public class Main {
	static Queue<Pair> b = new LinkedList<Pair>();
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static String[][] map;
	static int[][] bTime;
	static int[][] start = new int[2][2];
	static int n = 0;
	static int s = 0;
	static int result = 0;
	static int maxTime = 1;
	static boolean flag = false;
	static void print() {
		for(int i =0;i<n;i++) { 
			for(int j=0;j<n;j++) { 
				System.out.print(bTime[i][j]);
			}
			System.out.println();
		}
	}
	
	static void bfs(int t) { //곰돌이 움직임
		Queue<Pair2> q = new LinkedList<Pair2>();
		int[][] log = new int[n][n];
		q.add(new Pair2(start[0][0],start[0][1],t));
		log[start[0][0]][start[0][1]] = 1;
		while(!q.isEmpty()) {
			Pair2 tmp = q.remove();
			for(int i =0;i<4;i++) {			
				for(int j=0;j<s;j++) {
					int add1=dir[i][0],add2=dir[i][1];
					if(add1!=0) {
						if(add1==-1) add1-=j;
						else add1+=j;
					}else if(add2!=0) {
						if(add2==-1) add2-=j;
						else add2+=j;
					}
					int x = tmp.x + add1;
					int y = tmp.y + add2;
					int time = tmp.time+1;
					if(x<0||y<0||x>=n||y>=n)continue;
					if(log[x][y]==0&&(map[x][y].equals("G")||map[x][y].equals("D"))){
						//만약 도착하면 flag = true return;					
						if(bTime[x][y]<=time)continue;
						if(map[x][y].equals("D")) { //집에 도달 가능
							flag = true;
							result = t;
							return;
						}
						log[x][y]=1;
						q.add(new Pair2(x,y,time));					
					}
				}
			}
		}
	}
	
	static void beeMove() {
		int[][] log = new int[n][n];
		while(!b.isEmpty()) {
			int size = b.size();
			for(int i = 0;i<size;i++) {
				Pair tmp = b.remove();
				log[tmp.x][tmp.y] = 1;
				for(int j = 0;j<4;j++) {
					int x = tmp.x + dir[j][0];
					int y = tmp.y + dir[j][1];
					if(x>=n||x<0||y>=n||y<0)continue;
					if(!map[x][y].equals("T")&&log[x][y]==0) {
						log[x][y] = 1;
						bTime[x][y] = maxTime;
						b.add(new Pair(x,y));
					}
				}
			}
			maxTime++;
		}
		print();
	}
	static void BinarySearch() {
		int low = 0;
		int high = maxTime -1;
		while(low+1<high) {
			int mid = (low+high)/2;
			flag = false;
			bfs(mid);
			if(flag) { //방법을 찾았다
				low = mid + 1;
			}else if(!flag) { //방법을 못찾았따
				high = mid - 1;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 n = sc.nextInt();
		 s = sc.nextInt();
		 map = new String[n][n]; //map 입력
		 bTime = new int[n][n]; //벌의 시간
		 //입력 m:곰돌이, d:곰돌이의 집, h:벌집
		 String[] tmp = sc.nextLine().trim().split("");
		 for(int i =0;i<n;i++) {
			 tmp = sc.nextLine().trim().split("");
			 for(int j=0;j<n;j++) {
				 map[i][j] = tmp[j];
				 if(tmp[j].equals("M")) {
					 start[0][0] = i;
					 start[0][1] = j;
 				 }else if(tmp[j].equals("D")) {
 					 start[1][0] = i;
 					 start[1][1] = j;
 				 }else if(tmp[j].equals("H")) {
 					 b.add(new Pair(i,j));
 				 }
			 }
		 }
		 beeMove();
		 BinarySearch();
		 System.out.println(result);
	}
}
