import java.util.*;
public class Main {
	static int[][] dir = {{0,0},{0,1},{0,-1},{-1,0},{1,0}};
	static int N,M;
	static int move;
	static int[][] map;
	static int[] moveArr;
	static int[] jusawe = new int[7]; //주사위
	static LinkedList<Integer> q4 = new LinkedList<Integer>();
	static LinkedList<Integer> q3 = new LinkedList<Integer>();
	
	public static void init() {
		q4.add(2); q4.add(1); q4.add(5); q4.add(6);
		q3.add(4); q3.add(1); q3.add(3); q3.add(6);
	}
	
	public static void gameStart(int a,int b) {	
		for(int i = 0;i < move;i++) {
			int now = moveArr[i];
			if(a + dir[now][0] < 0|| b + dir[now][1] < 0|| a + dir[now][0] >= N|| b + dir[now][1] >= M)continue;
			a = a + dir[now][0]; b = b + dir[now][1];
			if(now == 1) { //동
				int tmp = q3.removeLast();
				q3.add(0 , tmp);
				q4.remove(1); q4.add(1, q3.get(1));
				q4.removeLast(); q4.add(q3.get(3));
			}else if (now == 2) { //서
				int tmp = q3.remove(0);
				q3.add(tmp); 
				q4.remove(1); q4.add(1, q3.get(1));
				q4.removeLast(); q4.add(q3.get(3));			
			}else if(now == 3) { //북
				int tmp = q4.removeLast();
				q4.add(0, tmp); 
				q3.remove(1); q3.add(1, q4.get(1));
				q3.removeLast(); q3.add(q4.get(3));										
			}else if(now == 4) { //남
				int tmp = q4.remove(0);
				q4.add(tmp); 
				q3.remove(1); q3.add(1, q4.get(1));
				q3.removeLast(); q3.add(q4.get(3));		
			}
			
			if(map[a][b] == 0) 
				map[a][b] = jusawe[q4.get(3)];
			else {
				jusawe[q4.get(3)] = map[a][b];
				map[a][b] = 0;
			}
			System.out.println(jusawe[q4.get(1)]);	
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int sN = sc.nextInt();
		int sM = sc.nextInt();
		move = sc.nextInt();
		map = new int[N][M];
		moveArr = new int[move];
		
		for(int i = 0;i < N;i++)
			for(int j = 0;j < M;j++)
				map[i][j] = sc.nextInt();
		
		for(int i = 0;i < move;i++)
			moveArr[i] = sc.nextInt();
		init();
		gameStart(sN,sM);
	}

}
