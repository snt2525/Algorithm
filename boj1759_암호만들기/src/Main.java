import java.util.*;
public class Main {
	static int n;
	static int m;
	static String[] arr;
	static int[][] visit;
	static int cnt = 0;
	
	static void print(int[] log) {
		for(int j=0;j<m;j++) { 
			if(log[j]==1) { 
				visit[cnt][j] = 1;
				System.out.print(arr[j]);
			}
		}
		cnt++;
		System.out.println();
	}
	
	static void dfs(int current,int[] log,int length,int cnt1,int cnt2) {
		if(length == n && cnt1 >= 1 && cnt2 >= 2 ) {
			boolean flag = false;
			for(int i=0;i<cnt;i++) {
				flag = true;
				for(int j=0;j<m;j++) {
					if(log[j] != visit[i][j]) {
						flag = false;
						break;
					}
				}
				if(flag) break;
			}
			if(!flag) print(log);
			return;
		}
		
		for(int i=current;i<m;i++) {
			if(log[i] != 1) {
				log[i] = 1;
				if(arr[i].equals("a")||arr[i].equals("e")||arr[i].equals("i")
						||arr[i].equals("o")||arr[i].equals("u")){
					dfs(i,log,length+1,cnt1+1,cnt2);
				}else
					dfs(i,log,length+1,cnt1,cnt2+1);
				log[i] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new String[m];
		visit = new int[500][m];
		int[]log = new int[m];
		
		for(int i=0;i<m;i++)
			arr[i] = sc.next();
		Arrays.sort(arr);
		
		dfs(0,log,0,0,0);	
	}
}
