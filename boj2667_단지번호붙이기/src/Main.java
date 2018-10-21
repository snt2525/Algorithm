import java.util.*;
public class Main {
	ArrayList<Integer> logx = new ArrayList<Integer>();
	ArrayList<Integer> logY = new ArrayList<Integer>();
	int[][] di = {{0,1},{0,-1},{1,0},{-1,0}};
	int[][] map;
	int[][] log;
	int N;
	Main(int N ){ 
		this.N = N;
		log = new int[N][N];
		map = new int[N][N];
	}
	int bfs(int startX,int startY,int count) {
		ArrayList<Integer> qx = new ArrayList<Integer>();
		ArrayList<Integer> qy = new ArrayList<Integer>();
		qx.add(startX);qy.add(startY);
		log[startX][startY]=1;
		
		while(!qx.isEmpty()){
			int size =qx.size();
			for(int i=0;i<size;i++) {
				int x = qx.remove(0);
				int y = qy.remove(0);
				for(int j=0;j<4;j++) {
					int xx = x + di[j][0];
					int yy = y + di[j][1];
					if(xx>=N||yy>=N||xx<0||yy<0)continue;
					if(map[xx][yy]==1&&log[xx][yy]==0) {
						qx.add(xx); qy.add(yy);
						log[xx][yy]=1;
						count++;
					}
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		int n =Integer.parseInt(sc.nextLine());
		Main m = new Main(n);
		for(int i=0;i<n;i++) {
			String[] s =sc.nextLine().trim().split("");
			for(int j=0;j<n;j++){
				m.map[i][j]=Integer.parseInt(s[j]);
				if(m.map[i][j]==1) {
					m.logx.add(i);m.logY.add(j);
				}
			}
		}
		int count=0;
		for(int i=0;i<m.logx.size();i++) {
			int a= m.logx.get(i);
			int b= m.logY.get(i);
			if(m.log[a][b]==0&&m.map[a][b]==1) {
				q.add(m.bfs(a,b,1));
				count++;
			}
		}		
		System.out.println(count);
		for(int j=0;j<count;j++) 
			System.out.println(q.poll());
	}
}
