import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int testCase = 1;testCase <= tc;testCase++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			for(int i =0;i<n;i++)
				arr[i] = sc.nextInt();
			Arrays.sort(arr);
			int result = 0;
			for(int j = arr.length-1;j>=arr.length-k;j--){
				result += arr[j];
			}
			System.out.println("#"+testCase+" "+result);
		}
	}
}
