import java.math.BigInteger;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
		for(int tc = 1; tc<=loop; tc++) {
			BigInteger n = sc.nextBigInteger();
			BigInteger m = sc.nextBigInteger();
			BigInteger result = n.pow(2).divide(m.pow(2));
			System.out.println("#"+ tc + " " + result);
		}
	
	}
}

