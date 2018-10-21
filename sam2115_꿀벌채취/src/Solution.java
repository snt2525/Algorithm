import java.util.*;
public class Solution {
	static int n,m,c;
	static int[][] map;
	static int[][] memo;
	static int[][] log;
	static int max;
	static int sx,sy;
	static int result = 0;
	static void visit() {
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < n - (m - 1);j++) {
				max = 0; sx = i; sy = j;
				DFS1(0, 0, 0);				
			}
		}
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < n - (m - 1);j++) {
				log = new int[n][n];
				for(int k = j;k < j + m;k++)
					log[i][k] = 1;
				//여기서 가능한 다음 꿀통을 찾아서
				for(int h = i;h < n;h++) { //첫줄에서 찾기
					if(h == i) {
						for(int a = j + m;a < n - (m - 1);a++) {
							if(log[h][a] == 1)continue;
							result = Math.max(result, memo[i][j] + memo[h][a]);							
						}
					}else {
						for(int a = 0;a <n - (m - 1);a++) 
							result = Math.max(result, memo[i][j] + memo[h][a]);
					}	
				}
			}
		}
			
	}
	//cnt: 몇 개를 더했는지? add:총합
	static void DFS1(int cnt, int sum, int add) {
		if(cnt == m) {
			memo[sx][sy] = Math.max(memo[sx][sy], add);
			return;
		}
		
		for(int i = sy;i < sy + m;i++) {
			if(log[sx][i] == 0) {
				log[sx][i] = 1;
				if(sum + map[sx][i] <= c)
					DFS1(cnt + 1,sum + map[sx][i], add + (map[sx][i] *  map[sx][i]));
				else
					DFS1(cnt + 1, sum, add);
				log[sx][i] = 0;
			}
		}		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1;t <= test;t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			c = sc.nextInt();
			log = new int[n][n];
			map = new int[n][n];
			memo = new int[n][n];
			result = 0;
			for(int i = 0;i < n;i++)
				for(int j = 0;j < n;j++) 
					map[i][j] = sc.nextInt();
			visit();	
			System.out.println("#"+t+" "+result);
		}
	}
}
