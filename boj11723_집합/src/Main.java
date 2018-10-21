import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder r = new StringBuilder();
		int loop = sc.nextInt();
		int bit = 0;
		
		for(int i=0;i<loop;i++) {			
			String tmp = sc.next();
			if(tmp.equals("add")){ 
				int num = sc.nextInt();
				bit |= (1<<num);
			}else if(tmp.equals("remove")){
				int num = sc.nextInt();
				bit &= ~(1<<num);
			}else if(tmp.equals("check")) {
				int num = sc.nextInt();
				if((bit | (1<<num)) == bit) 
					r.append("1\n");
				else
					r.append("0\n");
			}else if(tmp.equals("toggle")) {
				int num = sc.nextInt();
				bit ^= (1<<num);
			}else if(tmp.equals("all")) {
				bit |= (1 << 21) - 1;
			}else if(tmp.equals("empty")) {
				bit = 0;
			}
		}
        System.out.println(r);
	}
}
