import java.util.*;


public class Main {
	final static int MAX = 5;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static String[][] map = new String[MAX][MAX];
	static int[][] log = new int[MAX][MAX];
	static int result = 0;
	
	static void dfs(int a,int b) {
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i =0;i<MAX;i++) {
			String[] s = sc.nextLine().trim().split("");
			for(int j=0;j<MAX;j++) {
				map[i][j] = s[j];
			}
		}
		
		for(int i =0;i<MAX;i++) {
			for(int j=0;j<MAX;j++) {
				dfs(i,j);
				System.out.println(i+","+j+":"+result);
			}
		}
		
		System.out.println(result);
	}
}
