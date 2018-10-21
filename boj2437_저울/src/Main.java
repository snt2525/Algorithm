import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];		
		int result = 0;
		
		for(int i = 0 ;i<n;i++) 
			arr[i] = sc.nextInt();					
		Arrays.sort(arr); //오름 차순으로 정렬
		for(int i =0;i < n;i++) {
			if(arr[i] > result + 1) {
				System.out.println(result + 1);
				return;		
			}
			result += arr[i];
		}
		
		System.out.println(result + 1);
	}
}
