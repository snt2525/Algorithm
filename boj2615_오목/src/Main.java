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
	static int[][] dir = {{0,1},{1,0},{0,-1},{1,1},{1,-1}};
	int[][] map = new int[19][19];
	int[][][] log = new int[19][19][5];
	Queue<Pair> one = new LinkedList<Pair>();
	Queue<Pair> two = new LinkedList<Pair>();
	int cnt = 1;
	
	void dfs(int count,int d,int x,int y,int color) {
		log[x][y][d] = 1;
		int xx = x + dir[d][0];
		int yy = y + dir[d][1];
		if(xx<0||yy<0||xx>=19||yy>=19) {
			cnt = count;
			return;
		}
		if(map[xx][yy]==color) {		
			dfs(count+1,d,xx,yy,color);
			return;
		}else {
			cnt = count;
			return;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main m = new Main();
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				m.map[i][j] = sc.nextInt();
				if(m.map[i][j] == 1) {
					m.one.add(new Pair(i,j));
				}else if(m.map[i][j] == 2) {
					m.two.add(new Pair(i,j));
				}
			}
		}
		
		int winner = 0;
		Pair win = new Pair(0,0);
		int size = m.one.size();
		for(int i=0;i<size;i++) {
			Pair tmp =  m.one.remove();
			for(int j=0;j<5;j++) {		
				int xx = tmp.x + dir[j][0];
				int yy = tmp.y + dir[j][1];
				if(xx<0||yy<0||xx>=19||yy>=19||m.log[xx][yy][j]==1)continue;
				if(m.map[xx][yy]==1) {
					m.cnt = 1;
					m.dfs(1,j,tmp.x,tmp.y,1);
					if(m.cnt == 5) {
						win = new Pair(tmp.x,tmp.y);
						if(j == 4 ) {
							win.x += 4;
							win.y -= 4;
						}
						winner = 1;
						i=size; break;
					}
				}
			}
		}
		
		size = m.two.size();
		for(int i=0;i<size;i++) {
			Pair tmp =  m.two.remove();
			for(int j=0;j<5;j++) {
				int xx = tmp.x + dir[j][0];
				int yy = tmp.y + dir[j][1];
				if(xx<0||yy<0||xx>=19||yy>=19||m.log[xx][yy][j]==1)continue;
				if(m.map[xx][yy]==2) {
					m.cnt = 1;
					m.dfs(1,j,tmp.x,tmp.y,2);
					if(m.cnt == 5) {
						win = new Pair(tmp.x,tmp.y);
						if(j == 4 ) {
							win.x += 4;
							win.y -= 4;
						}
						winner = 2;
						i=size; break;
					}
				}
			}
		}
		
		System.out.println(winner);	
		if(winner != 0)
			System.out.println((win.x + 1)+" "+(win.y + 1));			
	}
}
