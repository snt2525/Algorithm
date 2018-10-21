import java.util.*;
public class Solution {
	static int[][] map = new int[142][501];
	static int result;
	static void init_map() {
		int cnt = 1;
		for(int i = 0;i <= 140; i ++) {
			for(int j = 250 - i;j <= 250 + i;j += 2) {
				map[i][j] = cnt++;
				if(cnt > 10000) return;
			}
		}
	}
	static void print() {
		for(int i = 0;i <= 141;i++) {
			for(int j = 100;j<= 420;j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		init_map();
		print();
		int test = sc.nextInt();
		for(int t = 1;t <= test; t++) {
			result = 0;
			System.out.println("#"+t+" ");
		}
	}
}
