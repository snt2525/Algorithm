import java.util.*;

class Pair{
	int x = 0;
	int time = 0;
	Pair(int x,int time){
		this.x =x;
		this.time = time;
	}
}

public class Main {
	final static int SIZE = 100001;
	static int[] map = new int[SIZE];
	static int[] log = new int[SIZE];
	static int[] time = new int[SIZE];
	static int min = Integer.MAX_VALUE;
	
	static void bfs(int start, int find) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(start,0));
		while(!q.isEmpty()) {
			int size = q.size();
			for(int j = 0;j<size;j++) {
				Pair tmp = q.remove();
				log[tmp.x] = 1;
				
				if(tmp.x == find) 
					min = Math.min(min,tmp.time);										
				
				if(tmp.x + 1 >= 0 && tmp.x + 1 <= 100000 && log[tmp.x + 1] == 0)  //1칸 앞으로
					q.add(new Pair(tmp.x + 1,tmp.time + 1));		
				if(tmp.x - 1 >= 0 && tmp.x - 1 <= 100000 && log[tmp.x - 1] == 0)  //1칸 뒤로
					q.add(new Pair(tmp.x -1, tmp.time + 1));	
				if(tmp.x * 2 >= 0 && tmp.x * 2 <= 100000 && log[tmp.x * 2] == 0)  //*2칸 앞으로
					q.add(new Pair(tmp.x * 2,tmp.time));									
			}		
        }
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //수빈이의 위치
		int m = sc.nextInt();  //동생이 있는 위치
		bfs(n,m);
		System.out.println(min);
	}
}
