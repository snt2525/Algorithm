import java.util.*;
class Pair{
	int x = 0;
	int y = 0;
	int cnt = 0;
	int pre = 0;
	Pair(int a,int b,int c,int d){
		this.x = a;
		this.y = b;
		this.cnt = c;
		this.pre = d;
	}
}

public class Main {
	static Queue<Pair> R = new LinkedList<Pair>();
	static Queue<Pair> B = new LinkedList<Pair>();
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static int[][] log;
	static String[][] map;
	static int n,m;
	static int min = Integer.MAX_VALUE;
	
	static void bfs() {
		while(!R.isEmpty()) {
			Pair tmpR = R.remove();
			if(tmpR.cnt >= 11)
			for(int i = 0;i < 4;i++) {
				int xR = tmpR.x + dir[i][0];
				int yR = tmpR.y + dir[i][1];
				if(xR<0||yR<0||xR>=n||yR>=m) continue; //빨간공 부터 움직인다.
				if(log[xR][yR] == 0) { 
					bfsBlue(i);
					log[xR][yR] = 1;
					if(tmpR.pre == i)
						R.add(new Pair(xR,yR,tmpR.cnt,i));
					else
						R.add(new Pair(xR,yR,tmpR.cnt+1,i));
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new String[n][m];
		log = new int[n][m];
		String[] s = sc.nextLine().trim().split("");
		
		for(int  i = 0;i < n; i++) { 
			s = sc.nextLine().trim().split("");
			for(int j=0;j<m;j++) {
				map[i][j] = s[j];
				if(s[j].equals("B")) {
					B.add(new Pair(i,j,0,-1));
				}else if(s[j].equals("R")) {
					R.add(new Pair(i,j,0,-1));
				}
			}
		} //map 입력
		
		bfs();
		System.out.println(min);		
	}
}
