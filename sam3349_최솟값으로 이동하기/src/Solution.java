import java.util.Scanner;
import java.io.FileInputStream;

class Solution{
	int[][] dir = {{-1,-1},{1,1},{-1,0},{0,-1},{1,0},{0,1}};
	int[][] map;
	int[][] move;
	int N,W,H;
	int result = 0;
	Solution(int N,int W,int H){
		this.map = new int[H][W];
		this.move = new int[N][2];
		this.N = N;
		this.W = W;
		this.H = H;
	}
	void dfs(int x,int y,int count) {	
		if(x == move[count][0] && y == move[count][1]) {
			result = Math.min(result, count);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int xx = x+dir[i][0];
			int yy = y+dir[i][1];
			if(xx<0||yy<0||xx>=H||yy>=W)continue;
			if(map[xx][yy]==0) {
				
			}
		}
	}
	public static void main(String args[]) throws Exception{		
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++){
			int W = sc.nextInt();
			int H = sc.nextInt();
			int N = sc.nextInt();
			Solution s = new Solution(N,W,H);
			
			for(int i=0;i<N;i++) {
				int tmpA = sc.nextInt();
				int tmpB = sc.nextInt();
				s.move[i][0] = tmpA;
				s.move[i][1] = tmpB;
			}
			
			
			
			System.out.println("#"+ test_case+" "+ s.result);
		}
	}
}