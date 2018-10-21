import java.util.*;
public class Main {
	static int[] number = {1,2,3,5,7,9,0};

	static int n;
	static void dfs(int cnt,int num) {
		if(cnt == n) {
			System.out.println(num);
			return;
		}		
		
		for(int i =0;i<7;i++) {
			if(cnt==0&&(i==6||i==0||i==5))continue; //ù�ڸ��� 0�϶�
			int tmpNum = (num * 10) + number[i] ;
			if(!check(tmpNum,cnt)) continue;  // �Ҽ����� �ƴ���
			dfs(cnt+1, tmpNum);		
		}
	}
	
	static boolean check(int tmpNum,int cnt) {	
		if(cnt == 0) return true;
		  for(int i = 2; i < tmpNum - 1; i++) {
		      int r = tmpNum % i;
		      if(r == 0) return false;      // 0  �Ҽ� �ƴ�
		   }
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dfs(0,0);
	}
}
