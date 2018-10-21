import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc= sc .nextInt();
		Main m =  new Main();		
		String[] str = sc.nextLine().trim().split(" ");
		int[] tmp = new int[101];
		int size=0;
		for(int i =0;i<tc;i++) {
			str = sc.nextLine().trim().split(" "); //여우소리
			while(true) {
				String[] str2 = sc.nextLine().trim().split(" ");
				if(str2[1].equals("goes")) {
					for(int k=0;k<str.length;k++)
						if(str2[2].equals(str[k])) tmp[k]=1;
				}else {				
					for(int k=0;k<str.length;k++)
						if(tmp[k]==0) System.out.print(str[k]+" ");
					System.out.println();					
					break;
				}								
			}			
		}
	}
}
