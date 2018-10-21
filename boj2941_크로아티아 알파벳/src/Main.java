import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] cro = {"c=","c-","d-","lj","nj","s=","z="};
		String[] tmp = sc.nextLine().trim().split("");
		int[] log = new int[tmp.length];
		int cnt=0;
		for(int i=0;i<tmp.length-1;i++) {
			String t = tmp[i]+tmp[i+1];
			if(log[i]==1||log[i+1]==1)continue;
			for(int j=0;j<cro.length;j++) {
				if(t.equals(cro[j])) {
					log[i] = log[i+1] = 1;
					cnt++;
				}
			}
		}
		for(int i=0;i<tmp.length-2;i++) {
			String t = tmp[i]+tmp[i+1]+tmp[i+2];
			if(log[i]==1)continue;
			if(t.equals("dz=")) {
				log[i] = log[i+1] = 1;
			}		
		}
		for(int i=0;i<tmp.length;i++)
			if(log[i]==0)cnt++;
		
		System.out.println(cnt);
	}
}
