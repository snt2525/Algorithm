import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int people = 0;
		int result = 0;
		for(int i = 0 ;i<4;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			people = people + b - a;
			result = Math.max(people, result);
		}	
		System.out.println(result);
	}
}
