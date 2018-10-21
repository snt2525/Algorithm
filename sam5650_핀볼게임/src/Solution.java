import java.util.LinkedList;
import java.util.*;
class Pair{
	int x,y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
class Pair2{
	int x,y;
	int d;
	int cnt;
	Pair2(int x, int y,int d,int cnt){
		this.x = x;
		this.y = y;
		this.d = d;
		this.cnt = cnt;
	}
}
public class Solution {
	static Queue<Pair> start = new LinkedList<Pair>();  //빈공간
	static int[][] changeD = {{0,0,0,0},{1,3,0,2},{3,0,1,2},{2,0,3,1},{1,2,3,0},{1,0,3,2}}; //방향바꾸기
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; //상, 하, 좌, 우
	static int[][] map; 
	static int[][] holl;
	static int result;
	static int n;
	static void BFS(int startX, int startY) {
		Queue<Pair2> q = new LinkedList<Pair2>(); 
		q.add(new Pair2(startX, startY, 0, 0));
		q.add(new Pair2(startX, startY, 1, 0));
		q.add(new Pair2(startX, startY, 2, 0));
		q.add(new Pair2(startX, startY, 3, 0));
		while(!q.isEmpty()) {
			Pair2 tmp = q.remove();
			int x = tmp.x;
			int y = tmp.y;
			for(int i = 0;i < n;i++) { //쭈욱 가기!
				x = x + dir[tmp.d][0];
				y = y + dir[tmp.d][1];
				if(x < 0 || y < 0 || x >= n || y >= n) { //벽 부딪힘
					q.add(new Pair2(x, y, changeD[5][tmp.d], tmp.cnt + 1));
					break;
				}else if(map[x][y] == -1 || (x == startX && y == startY)) { //게임 끝남
					result = Math.max(tmp.cnt, result);
					break;
				}else if(map[x][y] == 0) continue;
				else if(map[x][y] >= 1 && map[x][y] <= 5) {  //1-5
					q.add(new Pair2(x, y, changeD[map[x][y]][tmp.d], tmp.cnt + 1));
					break;
				}else if(map[x][y] >= 6 && map[x][y] <= 10) {  //블록
					if(holl[map[x][y]][0] == x && holl[map[x][y]][1] == y) {
						q.add(new Pair2(holl[map[x][y]][2], holl[map[x][y]][3], tmp.d, tmp.cnt));
					}else {
						q.add(new Pair2(holl[map[x][y]][0], holl[map[x][y]][1], tmp.d, tmp.cnt));
					}
					break;
				}
			}			
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1;t <= test;t++) {
			result = 0;
			n = sc.nextInt();
			holl = new int[11][4];
			map = new int[n][n];
			for(int i = 6;i <= 10;i++)
				for(int j = 0;j < 4;j++) 
					holl[i][j] = -1;
			
			for(int i = 0;i < n;i++) {
				for(int j = 0;j < n;j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 0) start.add(new Pair(i, j));
					else if(map[i][j] >= 6) {
						if(holl[map[i][j]][0] != - 1) {
							holl[map[i][j]][2] = i;
							holl[map[i][j]][3] = j;
						}else {
							holl[map[i][j]][0] = i;
							holl[map[i][j]][1] = j;
						}
					}
				}
			}
			int size = start.size();
			for(int i = 0;i < size;i++) {
				Pair tmp = start.remove();
				BFS(tmp.x, tmp.y);
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
}
