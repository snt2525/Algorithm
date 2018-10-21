import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int what = sc.nextInt() - 1;
		Map<Integer,Integer> num = new HashMap<Integer,Integer>();
		int[][] arr = new int[n][4];
		for(int i = 0;i < n;i++)
			for(int j = 0;j<4;j++) 
				arr[i][j] = sc.nextInt();
		int cnt = 0;
		for(int i = 0;i<n;i++) {
			if(i == what) continue;
			if(arr[i][1]>=arr[what][1]) {
				if(arr[i][1]==arr[what][1]){
					if(arr[i][2]>=arr[what][2]) {
						if(arr[i][2]==arr[what][2]) {
							if(arr[i][3]>arr[what][3]) {
								cnt++;
							}		
						}else
							cnt++;
					}				
				}else
					cnt++;
			}
		}
		System.out.println(cnt + 1);
	}
}
