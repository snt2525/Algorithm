import java.util.*;
public class Main {
	static LinkedList<Integer> q= new LinkedList<Integer>();
	static int n,m;
	static int[] num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		num = new int[m];
		int min = Integer.MAX_VALUE;
		for(int i =0;i<n;i++) q.add(i);
		
		for(int i =0;i<m;i++) {
			int tmp = sc.nextInt();
			if(tmp == 1) {
				min = Math.min(min, q.remove());
			}else if(tmp == 2) {
				int t = q.remove();
				q.add(t);
			}else if(tmp == 3) {
				int t = q.removeLast();
				q.addFirst(t);
			}
		}
		System.out.println(min);
	}
}
