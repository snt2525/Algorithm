import java.util.*;
public class Solution {
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static String[][] map;
	static HashMap<String,Integer> hash;
	static int cnt;
	static void dfs(int x, int y, int t, String word) {
		if(t == 7) {
			if(!hash.containsKey(word)) {
				hash.put(word, 1);
				cnt++;
			}
			return;
		}
		
		for(int i = 0;i < 4;i++) {
			int xx = x + dir[i][0];
			int yy = y + dir[i][1];
			if(xx < 0||yy < 0||xx >= 4||yy >= 4)continue;
				dfs(xx, yy, t + 1, word + map[xx][yy]);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1;t <= test;t++) {
			hash = new HashMap<String, Integer>();
			map = new String[4][4];
			cnt = 0;
			for(int i = 0;i < 4;i++) 
				for(int j = 0;j < 4;j++)
					map[i][j] = sc.next();
			
			for(int i = 0;i < 4;i++)  
				for(int j = 0;j < 4;j++) 
					dfs(i ,j , 1, map[i][j]);
	
			System.out.println("#"+t+" "+cnt);
		}
	}
}
