import java.util.*;
class Pair{
	int x,y;
	int cnt;
	Pair(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
public class Solution {
	static int[][] dir = {{0,1},{-1,0},{1,0},{0,-1}};
	static int [][]map;
	static int destory;
	static int n,m;
	static int min;
	static void DFS(int cnt, int now, int[] order) {
		if(cnt == destory) {
			min = Math.min(min, break_wall(order));
			return;
		}
		
		for(int i = 0;i < m;i++) {
			order[cnt] = i;
			DFS(cnt + 1, i, order);
			if(min == 0) return;
		}
	}
	
	static int break_wall(int[] order){
		int remain = 0;
		LinkedList<LinkedList<Integer>> q = new LinkedList<LinkedList<Integer>>();
		for(int i = 0;i < m;i++) { 
			q.add(new LinkedList<Integer>());
			for(int j = 0;j < n;j++) 
				q.get(i).addFirst(map[j][i]);			
		}

		for(int i = 0;i < destory;i++) {
			int[][] log = new int[m][n]; //뭐가 터지는 지
			if(destory_wall(order[i], log, q)) {
				for(int j = 0;j < m;j++) { //터진거 지우기
					for(int k = n - 1;k >= 0;k--) { 
						if(log[j][k] == 0) continue;
						q.get(j).remove(k);
						q.get(j).addLast(0);
					}
				}
			}
		}		
		return remain_wall(q);
	}	
	//벽돌깨기(터트릴 돌, 뭐 터트릴지, 맵)
	static boolean destory_wall(int index, int[][] log, LinkedList<LinkedList<Integer>> q) {		
		for(int i = n - 1;i >= 0;i--) {
			int tmp = q.get(index).get(i);
			if(tmp == 0)continue;
			if(tmp == 1) { //1이면 그냥 터트리기
				q.get(index).remove(i);
				q.get(index).addLast(0);
				return false;
			}else {
				Queue<Pair> wall = new LinkedList<Pair>();
				wall.add(new Pair(index, i, tmp));
				while(!wall.isEmpty()) {
					Pair a = wall.remove();
					log[a.x][a.y] = 1;
					for(int j = 0 ;j < 4;j++) {
						int tmpX = a.x;
						int tmpY = a.y;
						for(int k = 0;k < a.cnt - 1;k++) {
							tmpX += dir[j][0];
							tmpY += dir[j][1];
							if(tmpX < 0 || tmpY < 0|| tmpX >= m|| tmpY >= n)continue;
							if(q.get(tmpX).get(tmpY) == 1) {
								log[tmpX][tmpY] = 1;
							}else if(q.get(tmpX).get(tmpY) > 1 && log[tmpX][tmpY] == 0) {
								wall.add(new Pair(tmpX, tmpY, q.get(tmpX).get(tmpY)));
								log[tmpX][tmpY] = 1;
							}
						}
					}
				}
			}
			break;
		}
		return true;
	}	
	//벽돌이 몇개 남았는 지?
	static int remain_wall(LinkedList<LinkedList<Integer>> q) {
		int cnt = 0;
		for(int i = 0;i < m;i++) 
			for(int j = 0;j < n;j++) {
				if(q.get(i).get(j) == 0)break;
				cnt ++;
			}		
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1;t <= test;t++) {
			destory = sc.nextInt();
			min = Integer.MAX_VALUE;
			m = sc.nextInt();
			n = sc.nextInt();
			map = new int[n][m];
			for(int i = 0;i < n;i++)
				for(int j = 0;j < m;j++)
					map[i][j] = sc.nextInt();
			int[] order = new int[destory];
			DFS(0, 0, order);
			System.out.println("#"+t+" " +min);
		}
	}
}
