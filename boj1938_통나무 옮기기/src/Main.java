import java.util.*;
class Pair{
	int[]x = new int[3];
	int[]y = new int[3];
	int d;
	Pair(int[]x, int[]y, int d) {
		for(int i = 0;i < 3;i++) {
			this.x[i] = x[i];
			this.y[i] = y[i];
		}
		this.d = d;
	}
}
public class Main {
	static int[][]dir = {{0,1},{1,0},{-1,0},{1,0}};
	static int[][]dir2 = {{-1,1},{-1,-1},{1,1},{1,-1}};
	static int[]BBBx = new int[3];
	static int[]BBBy = new int[3];
	static String[][] map;
	static int[][][] log;
	static int n;
	static int result;	
	static void BFS(int d) {
		Queue<Pair> q = new LinkedList<Pair>();
		log[d][BBBx[1]][BBBy[1]] = 1;
		q.add(new Pair(BBBx, BBBy, d));
		int time = 0;
		while(!q.isEmpty()) {
			time++;
			int s = q.size();
			for(int j = 0;j < s;j++) {
				Pair tmp = q.remove();
				if(tmp.x[1] == 4 && tmp.y[1] == 2 && tmp.d == 0)
					result = 1;
				for(int i = 0;i < 5;i++) {
					int[] x = new int[3];
					int[] y = new int[3];
					for(int k = 0;k < 3;k++) {
						x[k] = tmp.x[k];
						y[k] = tmp.y[k];
					}
					int di = tmp.d;
					boolean flag = true;
					if(i == 4) { //회전					
						for(int k = 0;k < 4;k++) {
							int tmpX = x[1] + dir[k][0];
							int tmpY = y[1] + dir[k][1];
							int tmpX2 = x[1] + dir2[k][0];
							int tmpY2 = y[1] + dir2[k][1];
							if(tmpX < 0 || tmpY < 0|| tmpX >= n || tmpY >= n ||map[tmpX][tmpY].equals("1")||
									tmpX2 < 0 || tmpY2 < 0|| tmpX2 >= n || tmpY2 >= n ||map[tmpX2][tmpY2].equals("1")){
								flag = false;
								break;
							}
						}
						if(flag) {							
							if(di == 0) { //가로면 세로로
								di = 1;
								x[0] = x[1] - 1; 
								x[2] = x[1] + 1;
								y[0] = y[2] = y[1];
							}else if(di == 1) {
								di = 0;
								x[0] = x[2] = x[1];
								y[0] = y[1] - 1;
								y[2] = y[1] + 1;
							}
						}
					}else {
						for(int k = 0;k < 3;k++) {
							x[k] += dir[i][0];
							y[k] += dir[i][1];
							if(x[k] < 0||y[k] < 0||x[k] >= n||y[k] >= n||map[x[k]][y[k]].equals("1")) {
								flag = false;
								break;
							}
						}
					}
					if(flag) {
						//도착
						if(x[1] == 4 && y[1] == 2) {
							System.out.print("왔어");
						}
						if(map[x[0]][y[0]].equals("E") && map[x[1]][y[1]].equals("E") 
								&& map[x[2]][y[2]].equals("E")){
							result = time;
							return;
						}else if(log[di][x[1]][y[1]] == 0) {
							log[di][x[1]][y[1]] = 1;
							q.add(new Pair(x, y, di));
						}
					}
				}
				
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cntB = 0;
		result = 0;
		n = sc.nextInt();
		log = new int[2][n][n];
		map = new String[n][n];
		
		String[] tmp = sc.nextLine().trim().split("");
		for(int i = 0;i < n;i++) {
			 tmp = sc.nextLine().trim().split("");
			 for(int j = 0;j < n;j++) {
				 map[i][j] = tmp[j];
				 if(tmp[j].equals("B")) {
					 BBBx[cntB] = i;
					 BBBy[cntB++] = j;
				 }				 
			 }
		}
		int d = 0;
		if(BBBx[0] == BBBx[1] - 1 && BBBy[0] == BBBy[1]) d = 1; //세로일때
		BFS(d);
		System.out.println(result);
	}
}
