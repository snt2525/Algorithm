import java.util.*;
public class Main {
	static int n;
	static int[][] arr;
	static int[] min; //최대 값으로 해준다
	public static int dfs(int now, int cnt, int sum, int visit) {				
		if(visit == (1 << n) - 1) {
			min[0] =  Math.min(sum + arr[now][0],min[0]); 	
			return sum; 		
		}
		
		if(cnt > 0 && min[cnt-1]<sum )return sum;
		
		for(int i = 0;i < n;i++) {			
			if((visit & (1 << i)) == 0 && arr[now][i] != 0) {
				min[cnt] = Math.min(dfs(i, cnt + 1, sum + arr[now][i], visit | (1 << i)), min[cnt]);				
			}		
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][1 << n];
		min = new int[n];
		
		for(int i =0;i<n;i++) 
			for(int j=0;j<n;j++) 
				arr[i][j] = sc.nextInt();		
		Arrays.fill(min, Integer.MAX_VALUE);
		
		dfs(0, 0, 0, 1);	
		System.out.println(min[n-1]);
	}
}
