import java.util.*;
public class Solution {
	static int[] payment = new int[4];
	static int[] month = new int[12];
	static int result;
	static void DFS(int cnt,int pay) {
		if(pay > result) return;
		if(cnt == 12) {
			result = Math.min(pay, result);
			return;
		}
		
		if(month[cnt] == 0) {
			DFS(cnt + 1, pay);
		}else {
			//1일권
			DFS(cnt + 1, pay + (month[cnt] * payment[0]));			
			//1달권
			DFS(cnt + 1, pay + payment[1]);			
			//3달권
			int tmp = cnt;
			for(int j = 0; j < 2;j++) {
				if(tmp == 11) break;
				tmp++;
			}
			DFS(tmp + 1, pay + payment[2]);			
		}		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1;t <= test;t++) {
			for(int i = 0;i < 4;i++)
				payment[i] = sc.nextInt();
			result = payment[3];
			for(int j = 0;j < 12;j++)
				month[j] = sc.nextInt();
			int[] log = new int[12];
			DFS(0, 0);
			System.out.println("#"+t+" "+result);
		}
	}
}
