import java.util.*;
class Pair{
	int x,y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Solution {
	int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	int[][] arr;
	int n,m;
	int result;
	Solution(int n,int m){
		this.arr = new int[n][n];
		this.n = n;
		this.m = m;
		result = 0;
	}
	void BFS(int startX, int startY, int cnt) {
		Queue<Pair> q = new LinkedList<Pair>();
		int[][] log = new int[n][n];
		log[startX][startY] = 1;
		q.add(new Pair(startX,startY));
		cnt = arr[startX][startY] == 1 ? 1 : 0; //몇 집?
		int k = 0; 
		int num = n * n - 1;
		
		while(!q.isEmpty() && num >= 0) {
			k++;			
			int pay = k * k + (k - 1) * (k - 1);
			if(0 <= (m * cnt) - pay) 
				result = Math.max(result , cnt);			
			int size = q.size();
			for(int i = 0;i < size;i++) {
				Pair tmp = q.remove();
				for(int j = 0;j < 4;j++) {
					int x = tmp.x + dir[j][0];
					int y = tmp.y + dir[j][1];
					if(x < 0||y < 0||x >= n||y >= n)continue;
					if(log[x][y] == 0) {
						log[x][y] = 1;
						cnt = arr[x][y] == 1 ? cnt + 1 : cnt;
						num--;
						q.add(new Pair(x, y));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1;t <= test;t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			Solution s = new Solution(n, m);
			for(int i = 0;i < n;i++) 
				for(int j = 0;j < n;j++)
					s.arr[i][j] = sc.nextInt();
			
				for(int i = 0;i < n;i++) 
					for(int j = 0;j < n;j++)
						s.BFS(i, j, 0);
			
			System.out.println("#"+t+" "+s.result);
		}
	}
}
