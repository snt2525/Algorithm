import java.util.*;
import java.io.FileInputStream;

class Solution{
	int maxTime = 1000000000;
	int[] time;
	int n,m;
	long sec=Integer.MAX_VALUE;
	int person =0;
	Solution(int n,int m){
		this.n = n; //�ɻ���� ��
		this.m = m;  //�Ա� �ɻ� ��� �ο�
		time = new int[n]; //�Ա� �ɻ�븶�� �ɸ��� �ð�
	}
	void checkTime() {		
		long left = 1;
		long right = maxTime;
		
		while(left<=right) {
			long mid = (left+right)/2;
			person = 0;
			for(int i=0;i<n;i++) 
				person += (mid / time[i]);		 		 			 
			if(person>=m) {
				 if(person >= m)  
					sec =  Math.min(mid,sec);
				 right =mid - 1;
			}else if(person<m) {
				 left = mid + 1; 
			}						 
		}
	}
	
	public static void main(String args[]) throws Exception{		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();		
		for(int test_case = 1; test_case <= T; test_case++){
			int n = sc.nextInt();  //�ɻ���� ��
			int m = sc.nextInt();  //�Ա� �ɻ� ��� �ο�
			Solution s = new Solution(n,m);
			for(int i=0;i<n;i++)
				s.time[i]=sc.nextInt();
			s.checkTime();
			System.out.println("#"+test_case+" "+s.sec);
		}
	}
}