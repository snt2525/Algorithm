import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int test_case =1;test_case <= tc;test_case++) {
			int a = sc.nextInt(); //���� ��
			int b = sc.nextInt(); //������ ��
			
			for(int i=0;i<= b;i++) {
				int head = a -(2 * i); //�� ���� �� -Ʈ��ȥ ���� ��
				if(head<0)continue;
				int unicorn = head; //Ȯ��
				if((i+unicorn) != b)continue;
				System.out.println("#"+test_case+" "+unicorn+" "+i);
				break;
			}
			
		}
	}
}
