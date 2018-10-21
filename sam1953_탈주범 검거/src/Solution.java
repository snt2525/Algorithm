import java.util.*;
class Pair{
	int x;
	int y;
	Pair(int a,int b){
		this.x = a;
		this.y = b;
	}
}
public class Solution {
	int[][] move = {{1,2,5,6},{1,2,4,7},{1,3,4,5},{1,3,6,7}};
	int[][] moveDIR = {
			{0,0,0,0},{0,1,2,3},{0,1,-1,-1},{-1,-1,2,3},  //상, 하 , 좌, 우
			{0,-1,-1,3},{-1,1,-1,3},{-1,1,2,-1},{0,-1,2,-1}};
	int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	int[][] arr;
	int[][] log;
	int n;
	int m;
	Solution(int n, int m){
		this.m = m;
		this.n = n;
		this.log = new int[n][m];
		this.arr = new int[n][m];
	}
	int BFS(int startX, int startY, int time) {
		int cnt = 1;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(startX, startY));
		log[startX][startY] = 1;
		while(!q.isEmpty() && time > 0) {
			int size = q.size();
			for(int i = 0;i < size;i++) {
				Pair tmp = q.remove();
				int now = arr[tmp.x][tmp.y];
				for(int j = 0;j < 4;j++) {
					int x = tmp.x + dir[j][0];
					int y = tmp.y + dir[j][1];
					if(x < 0||y < 0||x >= n||y >= m || moveDIR[now][j] == -1 || log[x][y] == 1) continue;
					for(int k = 0;k < 4;k++) { 
						if(move[moveDIR[now][j]][k] == arr[x][y]) { //다음 놈이 갈 수 있는 놈이다.
							cnt++;
							q.add(new Pair(x, y));
							log[x][y] = 1;
							break;
						}
					}
				}
			}
			time--;
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int i = 1;i <= test; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int r = sc.nextInt();
			int c = sc.nextInt();
			int time = sc.nextInt();
			Solution s = new Solution(n, m);
			for(int j = 0; j < n;j++) 
				for(int k = 0; k < m;k++)
					s.arr[j][k] = sc.nextInt();
			int result = s.BFS(r, c, time - 1);
			System.out.println("#"+i+" "+result);
		}
	}
}
