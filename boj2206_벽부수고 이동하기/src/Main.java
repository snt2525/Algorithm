import java.util.*;

class Pair{
	int x = 0;
	int y = 0;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	int di[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	int map[][];
	int N,M;	
	int count=Integer.MAX_VALUE;
	Main(int N,int M){
		this.map = new int[N][M];
		this.N = N;
		this.M = M;
	}
	int bfs(int startX,int startY,int countT) {
		int log[][] = new int [N][M];
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(startX,startY));
		log[startX][startY]=1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i =0;i<size;i++) {
				Pair t = q.remove();
				int x = t.x;
				int y = t.y;
				for(int j=0;j<4;j++) {
					int xx = x + di[j][0];
					int yy = y + di[j][1];
					if(xx>=N||yy>=M||xx<0||yy<0) continue;
					if(map[xx][yy]==0&&log[xx][yy]==0) {
						if(xx==(N-1)&&yy==(M-1))return countT+1;
						q.add(new Pair(xx,yy));
						log[xx][yy]=1;				
					}				
				}
			}
			countT++;
			if(countT>count) return Integer.MAX_VALUE;
		}
		return Integer.MAX_VALUE;
	}
	public static void main(String[] args) {
		ArrayList<Integer> wallX = new ArrayList<Integer>();
		ArrayList<Integer> wallY = new ArrayList<Integer>();
		Scanner sc= new Scanner(System.in);
		String[] s =sc.nextLine().trim().split(" ");
		int N =Integer.parseInt(s[0]);
		int M =Integer.parseInt(s[1]);
		Main m = new Main(N,M);
		for(int i=0;i<N;i++) {
			s =sc.nextLine().trim().split("");
			for(int j=0;j<M;j++){
				m.map[i][j]=Integer.parseInt(s[j]);
				if(m.map[i][j]==1) {
					wallX.add(i);wallY.add(j);
				}
			}
		}		
		m.count= m.bfs(0,0,1);
		for(int i=0;i<wallX.size();i++) {
			int a = wallX.remove(0);
			int b = wallY.remove(0);
			m.map[a][b]=0;
			m.count = Math.min(m.count, m.bfs(0, 0, 1));
			m.map[a][b]=1;
		}
		System.out.println(m.count);
	}
}