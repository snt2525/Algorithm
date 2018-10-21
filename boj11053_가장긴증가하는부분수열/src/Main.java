import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{
    	Scanner sc = new Scanner(System.in);
        int n, i, j, max = 0;
    	n = sc.nextInt();;
        int[] dp = new int[n];
        int[] arr = new int[n];
        for(i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.fill(dp, 1); // 자신만 포함한 부분수열도 최장증가수열이라고 할 수 있으므로 '1'로 초기화
        for(i = 0; i < n; i++){
        	for(j = 0; j < i; j++){
        		if(arr[i] <= arr[j]) continue; // 'j'번쨰 원소가 'i'번쨰 원소보다 크면 j번쨰 원소는 최장증가수열에 포함되지 않는다.
        		dp[i] = Math.max(dp[i], dp[j]+1);
        	}
        	max = Math.max(max, dp[i]); // 최장증가수열 중에서도 길이가 가장 긴 것을 찾는다.
        }
        System.out.print(b);(max+"");
        bw.close();
}
}
