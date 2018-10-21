import java.util.*;

class A{
	int x;
	int y;
	public A(int x,int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		A[] num = new A[n];
		
		for(int i=0;i<n;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			num[i] =new A(a,b);
		}
		
		Arrays.sort(num,new Comparator<A>() {
            @Override
            public int compare(A o1,A o2) {
               if(o1.y>o2.y) return 1;
               else if(o2.y>o1.y) return -1;
               else {
            	   return o1.x-o2.x;
               }
            }
        });
		
		for(int i=0;i<n;i++)
			System.out.println(num[i].x+" "+num[i].y);
	}
}
