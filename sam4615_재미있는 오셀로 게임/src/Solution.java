import java.util.*;
class Pair{
	int x,y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Solution{
	static Queue<Pair> black;
	static Queue<Pair> white;
	static int[][] map;
	static int n;
	

	public void game(int turn) {
		
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1; t <= test;t++) {
			n = sc.nextInt();
			map = new int[n][n];
			int m = sc.nextInt();
			for(int i = 0;i < m;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
			}
			
			black = new LinkedList<Pair>();
			white = new LinkedList<Pair>();
		}
		
		
	}
}
