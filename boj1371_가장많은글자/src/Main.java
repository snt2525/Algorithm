import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tmp;
		int[] cnt = new int[123];
		int max = 0;
		
		while(sc.hasNextLine()) {
			tmp  = sc.nextLine();
			char[] c = tmp.toCharArray();
			int size = c.length;
			for(int i=0;i<size;i++) {
				int a = c[i];
				if(a<97||a>=122) continue;
				cnt[a]++;
				max = Math.max(max, cnt[a]);
			}			
		}
		
		for(int i=97;i<=122;i++) {
			if(cnt[i]==max) {
				System.out.print((char)i);
			}
		}

	}
}
