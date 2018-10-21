import java.util.*;
import java.io.FileInputStream;

class Solution{
	int maxTime = 1000000000;
	int[] time;
	int n,m;
	long sec=Integer.MAX_VALUE;
	int person =0;
	Solution(int n,int m){
		this.n = n; //심사대의 수
		this.m = m;  //입국 심사 대기 인원
		time = new int[n]; //입국 심사대마다 걸리는 시간
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
			int n = sc.nextInt();  //심사대의 수
			int m = sc.nextInt();  //입국 심사 대기 인원
			Solution s = new Solution(n,m);
			for(int i=0;i<n;i++)
				s.time[i]=sc.nextInt();
			s.checkTime();
			System.out.println("#"+test_case+" "+s.sec);
		}
	}
}