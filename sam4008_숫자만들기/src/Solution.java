import java.util.*;
public class Solution {
	static int n;
	static int[] arr = new int[4]; //더하기, 빼기, 곱하기, 나누기
	static int[] num;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	static void dfs(int cnt,int sum) {
		if(cnt == n-1) { 
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
			
		for(int j=0;j<4;j++) {
			if(arr[j]>0&&j==0) {
				arr[j]--;
				dfs(cnt+1,sum+(num[cnt+1]));
				arr[j]++;
			}else if(arr[j]>0&&j==1) {
				arr[j]--;
				dfs(cnt+1,sum-(num[cnt+1]));	
				arr[j]++;
			}else if(arr[j]>0&&j==2) {
				arr[j]--;
				dfs(cnt+1,sum*(num[cnt+1]));
				arr[j]++;
			}else if(arr[j]>0&&j==3) {
				arr[j]--;
				dfs(cnt+1,sum/(num[cnt+1]));
				arr[j]++;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int testCase = 1;testCase<=tc;testCase++) {
			n = sc.nextInt();
			num = new int[n];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			for(int i =0;i<4;i++) 
				arr[i] = sc.nextInt();	
			for(int i=0;i<n;i++) 
				num[i] = sc.nextInt();	
			
			dfs(0,num[0]);
			System.out.println("#"+testCase+" "+ (max - min));
		}
	}
}
