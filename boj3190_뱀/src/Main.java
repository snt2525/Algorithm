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
	static Queue<Pair> q= new LinkedList<Pair>();
	static int[][]dir={{0,1},{-1,0},{1,0},{0,-1}}; // 오른쪽, 위,아래, 왼쪽
	static int[][]log;
	static int[][] map;
	static int timeMove[][];
	static int n;
	static int time = 0;
	static void bfs(int d,int x,int y) { 
		q.add(new Pair(x,y));
		log[x][y] = 1;
		while(true) {
			if(timeMove[time][0]!=0) {  //방향을 틀어준다
				if(d == 0) d = timeMove[time][0] == 1 ? 2 : 1;
				else if (d == 1) d = timeMove[time][0] == 1 ? 0 : 3;
				else if (d == 2) d = timeMove[time][0] == 1 ? 3 : 0;
				else if (d == 3) d = timeMove[time][0] == 1 ? 1 : 2;
			}
			int xx = x + dir[d][0];
			int yy = y + dir[d][1];
			time++;
			if(xx<0||yy<0||xx>=n||yy>=n||log[xx][yy]!=0) break;
			if(map[xx][yy]==0) {
				Pair tmp = q.remove();
				log[tmp.x][tmp.y] = 0;
			}else if(map[xx][yy]==1) 
				map[xx][yy] = 0;
			q.add(new Pair(xx,yy));
			log[xx][yy] = time;
			x = xx; y = yy;
		}
		//print();
	}
	static void print() {
		System.out.println();
		for(int i =0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(log[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		log = new int[n][n];
		//시작은 0,0 뱀의 길이 1 오른쪽을 향한다.
		int m = sc.nextInt();
		for(int i =0;i<m;i++) //1일 때 사과가 존재한다
			map[sc.nextInt()-1][sc.nextInt()-1] = 1;
		int k = sc.nextInt();
		timeMove = new int[10001][1];
		for(int i=0;i<k;i++) {
			int a = sc.nextInt();
			String b = sc.next();
			if(b.equals("D")) timeMove[a][0] = 1; //오른쪽으로
			else timeMove[a][0] = 2; //왼쪽으로
		}
		bfs(0,0,0);
		System.out.println(time);
	}
}
