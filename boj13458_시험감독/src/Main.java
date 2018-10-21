import java.util.*;
public class Main {
	static int n;
	static int[] arr;
	static int[] memo = new int[1000001]; //데이터 저장
	static int[] person = new int[2];
	static long result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];

		for(int i = 0;i<n; i++)
			arr[i] = sc.nextInt();
		
		person[0] = sc.nextInt();
		person[1] = sc.nextInt();
		
		for(int i = 0;i < n ;i++) {
			if(memo[arr[i]] == 0) {
				int a = 1, tmp = (arr[i] - person[0]);
				if(tmp > 0 && tmp % person[1] == 0) 
					a += tmp / person[1];
				else if(tmp > 0)
					a += tmp/ person[1] + 1;						
				memo[arr[i]] = a;
			}
			result += memo[arr[i]];
		}
		System.out.println(result);
	}
}
