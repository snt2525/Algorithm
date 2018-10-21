import java.util.*;
public class Main {
	static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	static int n,m;
	static int[][] arr;
	static int[][] log;
	static int result = 0;
	
	static void DFS(int cnt, int a, int b,int sum) {
		if(cnt == 4) {
			result = Math.max(result, sum);
			return;
		}		
		for(int i = 0;i<4;i++) {
			int tmpA = a + dir[i][0];
			int tmpB = b + dir[i][1];
			if(tmpA<0||tmpB<0||tmpA>=n||tmpB>=m) continue;
			if(log[tmpA][tmpB] == 0) {
				log[tmpA][tmpB] = 1;
				DFS(cnt+1, tmpA, tmpB, sum + arr[tmpA][tmpB]);
				log[tmpA][tmpB] = 0;
			}
		}
	}
	
	static void Leftover(int a,int b) {
		int sum = arr[a][b];
		int cnt = 0;
		for(int i =0;i<4;i++) {
			int tmpA = a + dir[i][0];
			int tmpB = b + dir[i][1];
			if(tmpA<0||tmpB<0||tmpA>=n||tmpB>=m) continue;
			sum += arr[tmpA][tmpB];
			cnt++;
		}
		if(cnt < 4)
			result = Math.max(sum, result);
		for(int i =0;i<4;i++) {
			int tmpA = a + dir[i][0];
			int tmpB = b + dir[i][1];
			if(tmpA<0||tmpB<0||tmpA>=n||tmpB>=m) continue;
			result = Math.max(sum - arr[tmpA][tmpB], result);
		}		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		log = new int[n][m];
		
		for(int i =0;i<n;i++)
			for(int j=0;j<m;j++)
				arr[i][j] = sc.nextInt();
		
		for(int i =0;i<n;i++) {
			for(int j=0;j<m;j++) {
				log[i][j] = 1;
				DFS(0, i, j, 0);
				Leftover(i, j);
				log[i][j] = 0;
			}
		}
		
		System.out.println(result);
	}
}
