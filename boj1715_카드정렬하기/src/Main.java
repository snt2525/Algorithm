import java.util.*;
public class Main {
	static PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i =0;i<num;i++)
			q.add(sc.nextInt());
		
		for(int i =0;i<num-1;i++) {
			int tmpA = q.remove();
			int tmpB = q.remove();
			result +=(tmpA + tmpB);
			q.add(tmpA + tmpB);
		}
		
		System.out.println(result);
	}
}
