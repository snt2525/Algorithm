import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		PriorityQueue<String> q = new PriorityQueue<String>();
		Map<String,Boolean> a = new HashMap<String,Boolean>();
		for(int i = 0;i < n;i++) {
			String tmp = sc.next();
			a.put(tmp, true);
		}
		for(int j = 0;j < m;j++) {
			String tmp = sc.next();
			if(a.containsKey(tmp)) {
				q.add(tmp);
			}
		}
		int size = q.size();
		System.out.println(size);
		for(int i = 0;i < size;i++)
			System.out.println(q.remove());
	}
}
