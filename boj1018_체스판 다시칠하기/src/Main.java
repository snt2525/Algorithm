import java.util.*;

public class Main {
	static String[][] map;
	static int n,m;
	static int cnt = Integer.MAX_VALUE;
	
	static void coloringChess(int a,int b,String now) {
		int tmpCnt = 0;
		for(int i = a;i < (a+8); i++) {
			for(int j = b;j < (b+8); j++) {
				if(!map[i][j].equals(now)) 
					tmpCnt++; 
				if(tmpCnt> cnt) return;
				if (now.equals("W") && j != b+7)
					now = "B";
				else if(j != b+7) now = "W";
			}
		}
		cnt = Math.min(cnt, tmpCnt);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt() ;
		m = sc.nextInt();
		map = new String[n][m];		
		
		for(int i = 0;i<n;i++)
			for(int j= 0;j<m;j++) 
				map[i][j] = sc.next();
		
		for(int i =0;i<=n-8;i++) {
			for(int j=0;j<=m-8;j++) {
				coloringChess(i,j,"W");
				coloringChess(i,j,"B");
			}
		}	
		
		System.out.println(cnt);
	}
}
