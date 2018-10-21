import java.util.*;
class Pair{
	int a;
	int b;
	Pair(int a,int b){
		this.a = a;
		this.b = b;
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1;tc<=t;tc++) {
			int n = sc.nextInt();
			int result = 0;
			Queue<Pair> q= new LinkedList<Pair>();
			int[] arr = new int[n];
			for(int i = 0;i<n;i++) 
				arr[i] = sc.nextInt();
			
			int remove = 0;
			for(int i = 1;i<n;i++) {
					int size = q.size();
					boolean flag = false;
					for(int j=0;j<size;j++) {
						Pair tmp = q.remove();
						if(tmp.a + tmp.b == arr[i]) {
							q.add(new Pair(tmp.a,arr[i]));
							flag = true;
							break;
						}else {
							if(tmp.a+tmp.b<arr[i]) {
								remove++;
								continue;
							}
							q.add(tmp);
						}
					}
					if(!flag) 
						q.add(new Pair(arr[i]-1,arr[i]));
					result = Math.max(q.size()+remove,result);	
				}
				
				System.out.println("#"+tc+" "+result);
			}	
	}
}

