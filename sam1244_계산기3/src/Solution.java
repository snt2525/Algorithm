import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int testCase =1;testCase <= tc;testCase++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int resultb=0;
			int count = 1;
			if(a%b==0||b%a==0) {
				System.out.println("#"+testCase+" -1");
				continue;
			}
			while(true) {
				int temp = (a * count) -1;
				int t = temp%b;
				if(temp%b==0&&temp>=b) {
					a = count;
					resultb = -(temp/b);
					System.out.println("#"+testCase+" "+a+" "+resultb);
					break;
				}
				count++;
			}
		}
	}
}
