import java.util.*;
public class Solution {
	static LinkedList<LinkedList<Integer>> q;
	static int result = 0;
	static int num, m;
	static void dfs(int cnt, int state) {
		if(cnt ==  num + 1) {
			result++;
			return;
		}
		dfs(cnt + 1, state);
		boolean flag = true;
		for(int i : q.get(cnt)) {
			if((state & (1 << i)) != 0){
				flag = false;
				break;
			}
		}
		if(flag) 
			dfs(cnt + 1, state | (1 << cnt));		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1;t <= test;t++) {
			result = 0; 
			num = sc.nextInt();
			m = sc.nextInt();
			q = new LinkedList<LinkedList<Integer>>();
			for(int i = 0;i < num + 1;i++) 
				q.add(new LinkedList<Integer>());
			
			for(int i = 0;i < m;i++) {
				int a = sc.nextInt();				
				int b = sc.nextInt();
				q.get(a).add(b);
				q.get(b).add(a);
			}
			dfs(1, 0);
			System.out.println("#" + t + " " + result);
		}
	}
}
