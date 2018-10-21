import java.util.*;
public class Solution {
	static int[] a;
	static int[] b;
	static int[] c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1;t <= test;t++) {
			int result = Integer.MAX_VALUE;
			int n = sc.nextInt();
			int m = sc.nextInt();
			a = new int[n]; //w
			b = new int[n]; //b
			c = new int[n]; //r
			Arrays.fill(a, m);
			Arrays.fill(b, m);
			Arrays.fill(c, m);
			
			String[] tmp = sc.nextLine().trim().split("");
			for(int i = 0;i < n;i++) {
				tmp = sc.nextLine().trim().split("");
				for(int j = 0;j < m;j++) {
					if(tmp[j].equals("W")) {
						a[i]--;
					}else if(tmp[j].equals("B")) {
						b[i]--;
					}else if(tmp[j].equals("R")){
						c[i]--;
					}
				}
			}
			int s1 = 0;
			for(int i = 0;i < n - 2;i++) {
				s1 += a[i];
				int s2 = 0;
				for(int j = i + 1;j < n - 1;j++) {
					s2 += b[j];
					int s3 = 0;
					for(int k = j + 1;k < n;k++) {
						if(s1 + s2 + s3 > result)break;
						s3 += c[k];
					}
					result = Math.min(result, s1 + s2 + s3);
				}
			}
			System.out.println("#"+t+" "+result);
		}

	}
}
