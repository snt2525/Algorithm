import java.util.*;
public class Solution {
	int[][]dir = {{0,1},{1,0},{-1,0},{0,-1}};
	int[][]map;
	int[][]log;
	int N;
	int result=0;
	Solution(int N){
		this.N = N;
		this.log = new int[N][N];
		this.map = new int[N][N];
	}
	void bfs(int x,int y) {
		ArrayList<Integer> qx = new ArrayList<Integer>();
		ArrayList<Integer> qy = new ArrayList<Integer>();
		qx.add(x); qy.add(y);
		log[x][y] = 1; result = map[x][y];
		int count= 0;
		while(!qx.isEmpty()&&count<x){
			int size = qx.size();
			for(int j =0;j<size;j++) { 
				x = qx.remove(0);
				y = qy.remove(0);
				for(int i=0;i<4;i++) {
					int xx = x + dir[i][0];
					int yy = y + dir[i][1];
					if(xx<0||yy<0||xx>=N||yy>=N)continue;				
					if(log[xx][yy]==0) {
						qx.add(xx);
						qy.add(yy);
						log[xx][yy]=1;
						result +=map[xx][yy];
					}			
				}
			}
			count++;
		}	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loop= sc.nextInt();
		for(int testCase = 1;testCase<=loop;testCase++) { 
			int N = sc.nextInt();
			Solution s = new Solution(N);		
			String[] tmp = sc.nextLine().trim().split("");
			for(int i=0;i<N;i++) { 
				tmp = sc.nextLine().trim().split("");
				for(int j=0;j<N;j++) {
					s.map[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			int x = N/2 ;
			int y = N/2;
			s.bfs(N/2, N/2);
			System.out.println("#"+testCase+" "+s.result);
		}		
	}
}
