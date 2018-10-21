import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] sum = new int[n+1];
		int num = 0;
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
			num += arr[i];
			sum[i] = num;
		}	
		
		int loop = sc.nextInt();
		for(int i=0;i<loop;i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt();
			System.out.println(sum[b] - sum[a]);
		}
		
	}
}
