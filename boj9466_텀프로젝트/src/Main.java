import java.util.*;
public class Main {
	Queue<Integer> q = new LinkedList<Integer>();
	int[] arr;
	int[] log; //사이클
	int[] visit; //그냥 방문한곳
	int N, people;
	boolean dfs(int now,int start,int[] tmp) {
		boolean flag = false;
		if(now == start) return true;
		int num = arr[now];
		if(log[num] == 1 || visit[num] == 1 || tmp[num] == 1) return false;
		tmp[num] = 1;
		q.add(num);
		flag = dfs(num, start, tmp);
		return flag;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
		for(int i =0;i<loop;i++) {
			int result = 0;
			Main m = new Main();
			m.N = sc.nextInt();
			m.arr = new int[m.N + 1];
			m.log = new int[m.N + 1];
			m.visit = new int[m.N + 1];
			for (int j =1;j <= m.N;j++) {
				m.arr[j] = sc.nextInt();
				if(j == m.arr[j]) m.log[j] = 1;
			}
			
			for(int j = 1;j <= m.N;j++) {
				int[] tmp = new int[m.N + 1];
				if(m.log[j] == 0 || m.visit[j] == 0) {
					if(m.dfs(m.arr[j], j, tmp)) {
						m.log[j] = 1;
						for(int k = 1; k <= m.q.size();k++)
							m.log[m.q.remove()] = 1;
					}
					m.visit[j] = 1;
					m.q.clear();
				}
			}	
			
			for(int j =0;j < m.log.length;j++)
				if(m.log[j] == 1) result++;
			System.out.println(result);
		}
	}
}
