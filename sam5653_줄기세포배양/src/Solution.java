import java.util.*;
class Pair implements Comparable<Pair>{
	int x,y;
	int time = 0;
	int time2 = 0;
	Pair(int x, int y, int time, int time2){
		this.x = x;
		this.y = y;
		this.time = time;
		this.time2 = time2;
	}
	public int compareTo(Pair arg0) {
		if(this.time2 < arg0.time2) 
			return 1;
		else if(this.time2 > arg0.time2)
			return -1;
		else
			return 0;
	}
}
public class Solution {
	static List<Integer>alive;
	static List<Pair> q;
	static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	static int[][] map;
	static int result;
	static int n, m, k;
	static void BFS() {
		alive = new LinkedList<Integer>();
		int time = k;
		while(!q.isEmpty() && time > 0){			
			int size = result = q.size();
			Collections.sort(q);
			int aliveS = alive.size();
			for(int i = 0;i < aliveS;i++) {
				int tmp = alive.remove(0);
				if(tmp - 1 != 0)
					alive.add(tmp - 1);
			}
			for(int k = 0;k < size;k++) {
				Pair tmp = q.remove(0);
				if(tmp.time != 0) {
					q.add(new Pair(tmp.x, tmp.y, tmp.time - 1, tmp.time2));
				}else {
					if(tmp.time2 - 1 != 0)  //활성화 된  세포 수
						alive.add(tmp.time2 - 1);					
					for(int i = 0;i< 4;i++) {
						int x = tmp.x + dir[i][0];
						int y = tmp.y + dir[i][1];
						if(map[x][y] == 0) {
							result++;
							map[x][y] = tmp.time2;
							q.add(new Pair(x, y, tmp.time2, tmp.time2));
						}
					}
				}
			}
			
			time--;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1;t <= test;t++) {
			q = new LinkedList<Pair>();
			map = new int[800][800];
			result = 0;
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			for(int i = 0;i < n;i++) {
				for(int j = 0;j < m;j++) {
					int tmp = sc.nextInt();
					map[310 + i][310 + j] = tmp;
					if(tmp != 0) {
						q.add(new Pair(310 + i, 310 + j, tmp, tmp));
					}
				}
			}			
			BFS();	
			System.out.println("#"+t+" "+(q.size() + alive.size()));
		}
	}
}