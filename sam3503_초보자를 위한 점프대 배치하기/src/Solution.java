import java.util.*;
public class Solution {
	static int n;
	static int[] arr;
	static int[] log;
	static int min;
	static void dfs(int start, int max, int cnt,int pre) {
		if(min < max) return;		
		if(cnt == n) { 
			max = Math.max(max, Math.abs(arr[pre] - arr[start]));
			min = Math.min(min, max);
			return;
		}
		
		for(int i = 0; i<n; i++) {
			if(log[i] == 0) {
				log[i] = 1;
				int now = i;
				int tmpMax = Math.max(max, Math.abs(arr[pre] - arr[now]));
				if(cnt == 0)
					dfs(now, tmpMax , cnt + 1, now);
				else
					dfs(start, tmpMax , cnt + 1, now);
				log[i] = 0;
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int testCase = 1;testCase <= tc ;testCase++) { 
			min = Integer.MAX_VALUE;
			n =sc.nextInt();
			arr = new int[n];
			log = new int[n];
			
			for(int i =0;i<n;i++) 
				arr[i] = sc.nextInt();
			
			dfs(0,0,0,0);

			System.out.println("#"+testCase+" "+ min);
		}	
	}
}
