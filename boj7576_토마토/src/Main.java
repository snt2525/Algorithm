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
	static Queue<Pair> q = new LinkedList<Pair>();
	static int[][] dir = {{1,0},{0,1},{0,-1},{-1,0}};
	static int[][] map;
	static int[][] log;
	static int total;
	static int n;
	static int m;
	
	static int bfs(){
		int day = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			boolean flag = false;
			for(int i=0;i<size;i++) {
				Pair tmp = q.remove();
				for(int j=0;j<4;j++) {
					int x = tmp.x + dir[j][0];
					int y = tmp.y + dir[j][1];
					if(x < 0||y < 0||x >= n||y >= m||log[x][y]== 1) continue;
					if(map[x][y]== 0) {
						total--;
						log[x][y] = 1;
						q.add(new Pair(x,y));
						flag = true;
					}
				}
			}
			if(flag)
				day++; 
		}
		
		if(total == 0) 
			return day;
		else 
			return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		map = new int[n][m];
		log = new int[n][m];
		total = n * m;
		
		for(int i =0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					log[i][j] = 1;
					q.add(new Pair(i,j));
					total--;
				}else if(map[i][j]==-1)
					total--;
			}
		}
		
		int result = bfs();
		System.out.println(result);
	}
}
