import java.util.*;

public class Solution {
	int[][] log;
	int[] number;
	int size,numInt,t;
    int tempNum,max = 0;
	Solution(int n,int t){
		this.log = new int[t][1000000];
		this.numInt = n;
		this.t= t;
	}
	
	void init(){
		String[] temp = Integer.toString(numInt).split("");
		size = temp.length;
		number = new int[size];
		for(int i=0;i<size;i++)
			number[i] = Integer.parseInt(temp[i]);
	}
	
	void dfs(int count, int[] num, int a) { 
		if(count==t) {		
			if(a>max) max = a; 
			return;
		}
		for(int i=0;i<size-1;i++) {
			for(int j=i+1;j<size;j++) {
				int[] numTemp = Arrays.copyOf(num, num.length);
				a = swap(numTemp,i,j);
				if(log[count][a]==1)continue;				
				log[count][a]=1;				
				dfs(count+1, numTemp, a);
			}
		}		
	}
	
	int swap(int[] num,int i,int j) {
		int temp = num[i];
		num[i] =num[j];
		num[j]= temp;	
		tempNum = num[size-1];
		for(int k=0;k<size-1;k++)
			tempNum += num[k] * Math.pow(10,size-(k+1));		
		return tempNum;
	}	
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);	
		int testCase = sc.nextInt();		
		for(int tc = 1; tc <= testCase; tc++) {
			int num = sc.nextInt();
			int t = sc.nextInt();		
			Solution s = new Solution(num,t);		
			s.init();
			s.dfs(0,s.number,num);		
			System.out.println("#"+tc+" "+s.max);
		}		
	}
}