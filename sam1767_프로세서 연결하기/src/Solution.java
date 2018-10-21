import java.util.*;
class Pair{
	int x = 0;
	int y = 0;
	Pair(int a,int b){
		this.x = a;
		this.y = b;
	}
}

public class Solution {
	static LinkedList<Pair> q;
	static int[][] dir = {{1,0},{0,1},{0,-1},{-1,0}};
	static int[][] map;
	static int[] log;
	static int n;
	static int min = Integer.MAX_VALUE;
	static int size = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int testCase = 1; testCase<=tc;testCase++) {
		    q= new LinkedList<Pair>();
			n = sc.nextInt();
			map = new int[n][n];
			min = Integer.MAX_VALUE;
			for(int i =0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 1) q.add(new Pair(i,j));
				}
			}
			size = q.size();
			log = new int[size];
			
			System.out.println("#"+testCase+" "+min);
		}

	}
}
