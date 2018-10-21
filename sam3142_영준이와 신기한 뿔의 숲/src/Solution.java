import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int test_case =1;test_case <= tc;test_case++) {
			int a = sc.nextInt(); //»ÔÀÇ ¼ö
			int b = sc.nextInt(); //µ¿¹°ÀÇ ¼ö
			
			for(int i=0;i<= b;i++) {
				int head = a -(2 * i); //ÃÑ »ÔÀÇ ¼ö -Æ®À©È¥ »ÔÀÇ ¼ö
				if(head<0)continue;
				int unicorn = head; //È®Á¤
				if((i+unicorn) != b)continue;
				System.out.println("#"+test_case+" "+unicorn+" "+i);
				break;
			}
			
		}
	}
}
