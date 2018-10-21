import java.util.*;
class Pair{
	int a;
	int b;
	Pair(int a, int b){
		this.a = a;
		this.b = b;
	}
}
public class Main {
	static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}}; //d´Â + 1;
	static int[][] map;
	static String[] move;
	static int N;
	static int Apple;
	static int time = 0;
	static int moveDir = 0;	
	static void SnakeMove(){
		Queue<Pair> q = new LinkedList<Pair>();
		int[][] log = new int[N][N];
		int nowN = 0, nowM = 0;
		q.add(new Pair(0 , 0));
		log[0][0] = 1;
		while(true) {
			time++;
			nowN += dir[moveDir][0];
			nowM += dir[moveDir][1];
			if(nowN < 0|| nowM < 0|| nowN >= N || nowM >= N || log[nowN][nowM] == 1) break;			
			if(map[nowN][nowM] == 1) {
				map[nowN][nowM] = 0;				
			}else {
				Pair tmp = q.remove();
				log[tmp.a][tmp.b] = 0;		
			}
			q.add(new Pair(nowN,nowM));
			log[nowN][nowM] = 1;
			if(move[time].equals("D") || move[time].equals("L")) {
				if(move[time].equals("D"))
					moveDir = moveDir == 3 ? 0 : moveDir + 1;
				if(move[time].equals("L"))
					moveDir = moveDir == 0 ? 3 : moveDir - 1;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			map = new int[N][N];
			move = new String[10001];
			Apple = sc.nextInt();
			for(int i = 0;i<Apple;i++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				map[a][b] = 1;
			}
			Arrays.fill(move, "");
			int tmp = sc.nextInt();
			for(int i = 0;i < tmp;i++) {
				int a = sc.nextInt();
				String b = sc.next();
				move[a] = b;
			}
			SnakeMove();
			System.out.println(time);			
	}
}
