import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<String>> q = new ArrayList<ArrayList<String>>();
		for(int i=0;i<=200;i++)
			q.add(new ArrayList<String>());
		
		int n=sc.nextInt();
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int i=0;i<n;i++) {
			int a = sc.nextInt();
			String b = sc.next();
			min = Math.min(min,a);
			max = Math.max(max,a);
			q.get(a).add(b);
		}
		
		for(int i = min;i<=max;i++) {
			if(q.get(i).size()<=0)continue;
			int size = q.get(i).size();
			for(int j=0;j<size;j++) 
				System.out.println(i+" "+q.get(i).remove(0));		
		}
		
	}
}
