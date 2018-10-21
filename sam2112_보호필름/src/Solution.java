import java.util.*;
public class Solution {
	int[]visit;
	int n, m, d;
	int min = Integer.MAX_VALUE;
	Solution(int n,int m,int d){
		visit = new int[n];
		this.n = n;
		this.m = m; 
		this.d = d; //연속 d개가 같아야한다.
	}
	void DFS(int cnt, int change) {
		if(change >= min) return;
		if(cnt == n) {
			if(check()) min = Math.min(min, change);
			return;		
		}
		DFS(cnt + 1, change);			
		int save = visit[cnt];		
		visit[cnt] = 0;
		DFS(cnt + 1, change + 1); //B 채우기
		visit[cnt] = (1 << m) - 1;
		DFS(cnt + 1, change + 1); //A 채우기
		visit[cnt] = save;
	}
	boolean check() {
		for(int i = 0 ;i < m;i++) {			
			int cnt = 1;
			for(int j = 1; j < n;j++) {				
				if(((visit[j] & (1 << i)) == 0 && (visit[j - 1] & (1 << i)) == 0) ||
						((visit[j] & (1 << i)) != 0 && (visit[j - 1] & (1 << i)) != 0)) { 					
					cnt++;
				}else 
					cnt = 1;	
				if(cnt == d)break;
			}	
			if(cnt != d) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1;t <= test;t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int d = sc.nextInt();
			Solution s = new Solution(n, m, d);
			Arrays.fill(s.visit, 0);
			for(int i = 0 ;i < n;i++)
				for(int j = 0 ;j < m;j++)
					if(sc.nextInt() == 1)
						s.visit[i] |= (1 << j);
			s.DFS(0, 0);
			System.out.println("#"+t+" "+s.min);			
		}
	}
}
