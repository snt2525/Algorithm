import java.util.*;

public class Main {
	int di[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	int map[][];
	int log[][];
	int N,M;	
	int count=1;
	Main(int N,int M){
		this.log = new int [N][M];
		this.map = new int[N][M];
		this.N = N;
		this.M = M;
	}
	void bfs(int startX,int startY) {
		ArrayList<Integer> qx = new ArrayList<Integer>();
		ArrayList<Integer> qy = new ArrayList<Integer>();
		ArrayList<Integer> wall = new ArrayList<Integer>();
		qx.add(startX);qy.add(startY); wall.add(0);
		log[startX][startY]=1;
		while(!qx.isEmpty()) {
				int x = qx.remove(0);
				int y = qy.remove(0);
				int broken = wall.remove(0);
				for(int j=0;j<4;j++) {
					int xx = x + di[j][0];
					int yy = y + di[j][1];
					int brokenW = broken;					
					if(xx>=N||yy>=M||xx<0||yy<0) continue;
					
									
			}
			count++;
		}
		count = -2;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String[] s =sc.nextLine().trim().split(" ");
		int N =Integer.parseInt(s[0]);
		int M =Integer.parseInt(s[1]);
		Main m = new Main(N,M);
		for(int i=0;i<N;i++) {
			s =sc.nextLine().trim().split("");
			for(int j=0;j<M;j++)
				m.map[i][j]=Integer.parseInt(s[j]);		
		}		
		m.bfs(0,0);		
		System.out.println(m.count+1);
	}
}
