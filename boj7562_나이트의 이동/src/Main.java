import java.util.*;

class Pair{
	int x = 0;
	int y = 0;
	int cnt = 0;
	Pair(int a,int b,int c){
		this.x = a;
		this.y = b;
		this.cnt = c;
	}
}

public class Main {
	static int[][] dir = {{-2,-1},{-1,-2},{2,1},{1,2},{1,-2},{-1,2},{-2,1},{2,-1}};
	static int[][] log;
	static int n;

	static int bfs(int startX,int startY,int finalX,int finalY) {
		Queue<Pair> q = new LinkedList<Pair>();
		log[startX][startY] = 1;
		q.add(new Pair(startX, startY, 0));
		
		while(!q.isEmpty()) {
			Pair tmp = q.remove();
			if(tmp.x == finalX && tmp.y == finalY)
				return tmp.cnt;
			for(int i =0;i<8;i++) {
				int x = tmp.x + dir[i][0];
				int y = tmp.y + dir[i][1];

				if(x < 0||y < 0||x >= n||y >= n ||log[x][y] == 1)continue;
				log[x][y] = 1;
				q.add(new Pair(x, y,tmp.cnt+1));
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int testCase = 0;testCase<T;testCase++) {
			n = sc.nextInt();
			log = new int[n][n];
			
			int startX = sc.nextInt();
			int startY = sc.nextInt();
			int finalX = sc.nextInt();
			int finalY = sc.nextInt();
			
			int result = bfs(startX,startY,finalX,finalY);
			System.out.println(result);
		}	
	}
}
