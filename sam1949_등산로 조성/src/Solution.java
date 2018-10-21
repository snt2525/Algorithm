import java.util.*;
class Pair{
	int x;
	int y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	int[][] arr;
	int[][] log;
	int n;
	int m;
	int max;
	Solution(int n, int m){
		this.arr = new int[n][n];
		this.log = new int[n][n];
		this.n = n;
		this.m = m;
		this.max = 0;
	}
	
	void BFS(int x, int y, int cnt, int dig) {
		log[x][y] = 1;
		max = Math.max(max , cnt);
		
		for(int i = 0;i < 4;i++) {
			int tmpX = x + dir[i][0];
			int tmpY = y + dir[i][1];
			if(tmpX < 0||tmpY < 0||tmpX >= n||tmpY >= n)continue;
			
			if(arr[x][y] > arr[tmpX][tmpY] && log[tmpX][tmpY] == 0) {
				BFS(tmpX, tmpY, cnt + 1, dig);
				log[tmpX][tmpY] = 0;
			}else if(arr[x][y] <= arr[tmpX][tmpY] && dig == 0 && log[tmpX][tmpY] == 0) { 
				for(int j = 1;j <= m;j++) {
					if(arr[x][y] > arr[tmpX][tmpY] - j) {
						arr[tmpX][tmpY] -= j;
						BFS(tmpX, tmpY, cnt + 1, 1);
						arr[tmpX][tmpY] += j;
					}
					log[tmpX][tmpY] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int i = 1; i <= test; i++) {
			int n = sc.nextInt(); 
			int m = sc.nextInt(); //몇개까지 
			
			Solution s = new Solution(n, m);
			int max = 0;
			Queue<Pair> high = new LinkedList<Pair>();
			for(int j = 0; j < n;j++) {
				for(int k = 0; k < n;k++) {
					s.arr[j][k] = sc.nextInt();
					if(s.arr[j][k] >= max) {
						if(s.arr[j][k] > max) 
							high = new LinkedList<Pair>();						
						max = s.arr[j][k];
						high.add(new Pair(j, k));
					}
				}
			}
			
			int size = high.size();
			for(int j = 0;j < size;j++) {
				Pair tmp = high.remove();
				s.BFS(tmp.x, tmp.y, 1, 0);
				s.log[tmp.x][tmp.y] = 0;
			}
			
			System.out.println("#"+i+" "+s.max);	
		}
		
	}
}
