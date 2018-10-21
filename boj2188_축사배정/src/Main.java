import java.util.*;
public class Main {
	static int n,m;
	static boolean[][] arr;
	static int[] log;
	static int[] PARENT;
	
	public static boolean dfs(int from) {
        for (int to = 1; to <= m; to++) {
            if (log[to] == 0 && arr[from][to]) {
                log[to] = 1;                
                if (PARENT[to] == 0 || dfs(PARENT[to])) {
                    PARENT[to] = from;                    
                    return true;
                }
            }
        }
         
        return false;
    }
	public static void main(String[] args) throws Exception {		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();		
		arr = new boolean[n + 1][m + 1];
		log = new int[m + 1];
		PARENT = new int[m + 1];
		
		for (int i = 1; i <= n; i++) {
			int m = sc.nextInt();			
			for (int j = 1; j <= m; j++) {
				int job = sc.nextInt();				
				arr[i][job] = true;
			}
		}
		
		int count = 0;		
		for (int i = 1; i <= n; i++) {
			Arrays.fill(log, 0);			
			if (dfs(i)) 
				count++;
		}
		
		System.out.println(count);
	}
}