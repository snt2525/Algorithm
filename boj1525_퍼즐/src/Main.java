import java.util.*;
class Pair{
	int x;
	String order;
	Pair(int x, String order){
		this.x = x;
		this.order = order;
	}
}
public class Main {
	static int[] dir = {-1,1,3,-3};
	static int[][] map = new int[3][3];
	static int min = Integer.MAX_VALUE;
	static HashMap<String,Integer> log = new HashMap<String,Integer>();
	static void bfs(int sx, String start) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(sx, start));
		log.put(start, 0);
		int time = 1;
		if(start.equals("123456780")) {
			min = 0;
			return;
		}
		while(!q.isEmpty()) {
			int s = q.size();
			for(int j = 0;j < s;j++) {
				Pair tmp = q.remove();
				String[]tmps = tmp.order.split("");
				for(int i = 0;i < 4;i++) {
					if((tmp.x == 2 || tmp.x == 5) && i == 1)continue;
					if((tmp.x == 3 || tmp.x == 6) && i == 0)continue;
					int x = tmp.x + dir[i];
					if( x < 0 || x >= 9) continue;
					//만들어 본다 String으로 
					String next = "";
					for(int k = 0;k < 9;k++) {
						if(k == x) {
							next += tmps[tmp.x];
						}else if(k == tmp.x) {
							next += tmps[x];
						}else
							next += tmps[k];
					}
					if(next.equals("123456780")) {
						min = time;
						return;
					}else if(!log.containsKey(next)) {
						log.put(next, time);
						q.add(new Pair(x, next));
					}
				}
			}
			time++;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sx = 0;
		String start = "";
		int cnt = 0;
		for(int i = 0;i < 3;i++) {
			for(int j = 0;j < 3;j++) {
				String tmp = sc.next();
				start += tmp;
				if(tmp.equals("0"))	sx = cnt;
				cnt++;
			}
		}
		bfs(sx, start);
		if(min == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(min);
	}
}
