import java.util.*;

public class Main {
	static int[][] map; //����� -1�� ���� �صд�,
	static int[][] pSpace;
	static int[] log;
	static int n;
	static int max = 0;
	
	static void dfs(int now,int cnt) {
		max = Math.max(max, cnt);
		for(int i =0;i<n;i++) {
			if(map[now][i] == 1) { //������ �ִ�.
				
			}
		}
		
	}
	 //��ġ�� ������ �ִ��� �˻縦 �غ���.
	static boolean possible(int x,int y) {
		int xx = x; 
		int yy = y;
		while(xx>0&&yy>0) {
	 		if(map[xx][yy] == -1) return false;
			xx--; yy++;
		}
		xx = x;
		yy = y;
		while(xx>0&&yy>0) {
			if(map[xx][yy] == -1) return false; 
			xx--; y++;
		}		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		
		for(int i=0;i<n;i++) 
			for(int j=0 ;j<n;j++) 
				map[i][j] = sc.nextInt();			
		
		System.out.println(max);
	}
}
