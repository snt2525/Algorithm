import java.util.*;

class Pair{
	int x = 0;
	int cnt = 0;
	Pair(int a,int b){
		this.x = a;
		this.cnt = b;
	}
}

public class Main {
	static int[] map = new int[100001];
	static int n;
	static int k;
	
	static int bfs(){
		Queue<Pair> q= new LinkedList<Pair>();
		q.add(new Pair(n,0));
		map[n] = 1;
		
		while(!q.isEmpty()) {
			Pair tmp = q.remove();
			
			if(tmp.x == k) 
				return tmp.cnt;
			
			if(tmp.x+1>=0 && tmp.x+1<=100000 && map[tmp.x+1] == 0) {
				q.add(new Pair(tmp.x+1,tmp.cnt+1));
				map[tmp.x+1] = 1;
			}
			if(tmp.x-1>=0 && tmp.x-1<=100000 && map[tmp.x-1] == 0) {
				q.add(new Pair(tmp.x-1,tmp.cnt+1));
				map[tmp.x-1] = 1;
			}
			if(tmp.x*2>=0 && tmp.x*2<=100000 && map[tmp.x*2] == 0) {
				q.add(new Pair(tmp.x*2,tmp.cnt+1));
				map[tmp.x*2] = 1;
			}		
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		int result = bfs();
		System.out.println(result);
		
	}
}
