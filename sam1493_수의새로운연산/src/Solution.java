import java.util.*;
public class Solution {
	int[] dir = {-1,1};
	int[][] num = new int[40000][2];
	int[] num2 = new int[40000];
	int count=2;
	void number() {
		num[1][0]=1; num[1][1]=1;
		num2[1]=1;
		int temp=2;
		int x = 2,y=1;
		while(count<35000) {
			for(int i =1;i<=temp;i++) {	
				if(i==temp)num2[temp]=count;
				num[count][0]=x;
				num[count++][1]=y;		
				x+=dir[0]; y+=dir[1];
			}
			temp++;
			x = temp; y = 1;
		}				
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		Solution s = new Solution();
		s.number();
		for(int testCase =1;testCase <= tc;testCase++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int addY = (s.num[a][0]+s.num[b][0]);
			int addX = (s.num[a][1]+s.num[b][1]);		
			int result=s.num2[addX];
			for(int i=0;i<addY-1;i++) result += (addX+i);			
			System.out.println("#"+testCase+" "+result);
		}

	}
}
