import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[5];
		for(int i=0;i<5;i++)
			num[i] = sc.nextInt();
		int cnt = 1;
		while(cnt != 0) {
			cnt = 0;
			for(int i=0;i<4;i++) {
				if(num[i]>num[i+1]) {
					cnt++;
					swap(num,i,i+1);
				}
			}
		}
		
	}
	
	static void swap(int[] num, int a,int b) {
		int tmp = num[a];
		num[a] = num[b];
		num[b] = tmp;
		
		for(int i=0;i<5;i++)
			System.out.print(num[i]+" ");
		System.out.println();
	}
}
