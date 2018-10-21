import java.util.*;
public class Solution {
	int[] cal = new int[10];
	int num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int t =sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			Solution s = new Solution();
			for(int i=1;i<10;i++)
				s.cal[i]=sc.nextInt();
			s.num=sc.nextInt();
			//모든 경우의 수
			
			//조합 해서 최소
			System.out.println("#"+tc+" ");
		}
	}
}
