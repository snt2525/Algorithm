import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1; t <= test;t++) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			int[] map = new int[n];
			for(int i = 1;i <= q;i++) {
				int start = sc.nextInt() - 1;
				int last = sc.nextInt();
				for(int j = start;j < last;j++)
					map[j] = i;
			}
			System.out.print("#"+t);
			for(int i = 0;i < n;i++)
				System.out.print(" "+map[i]);
			System.out.println();
		}
	}
}
