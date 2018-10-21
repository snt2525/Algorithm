import java.util.*;
public class Main {
	static int n,m;
	static String[][] map;
	static void dfs() {
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new String[n][m];
		String[] tmp = sc.nextLine().trim().split("");
		for(int i=0;i<n;i++) {
			tmp = sc.nextLine().trim().split("");
			for(int j=0;j<m;j++) {
				map[i][j] = tmp[j];
			}
		}
		
		
	}
}
