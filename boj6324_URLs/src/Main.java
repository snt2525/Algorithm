import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		String[] s = sc.nextLine().trim().split("");
		for(int q=0;q<tc;q++) {
			s = sc.nextLine().trim().split("");
			System.out.println("URL #"+(q+1));
			int cnt=0; //어디서 끊었는지 체크
			
			//Protocol
			String t1 = "";boolean flag = false;
			for(int i=0;i<s.length-2;i++) {
				String temp = s[i]+s[i+1]+s[i+2];
				if(i+2<s.length&&temp.equals("://")) {
					cnt = (i + 3); //위치 저장
					flag = true;
					System.out.println("Protocol = "+t1);
					break;
				}else
					t1 += s[i];
			}
			if(!flag) 
				System.out.println("Protocol = <default>");

			//Host
			flag = false; t1 ="";
			if((cnt-1>0&&cnt-1<s.length)&&!s[cnt-1].equals(":")) flag = false; 
			for(int i=cnt;i<=s.length;i++) {  
				if(i>=s.length||s[i].equals(":")||s[i].equals("/")) {
					cnt = i+1;
					flag = true;
					System.out.println("Host     = " + t1);
					break; 
				}else
					t1 += s[i];
			}
			if(!flag) 
				System.out.println("Host     = <default>");		

			//Port
			flag = false; t1 ="";
			if((cnt-1>0&&cnt-1<s.length)&&!s[cnt-1].equals(":")) flag = false; 
			else {
				for(int i=cnt;i<=s.length;i++) {  
					if(i>=s.length||s[i].equals("/")) {
						cnt = i+1;
						flag = true;
						System.out.println("Port     = " + t1);
						break; 
					}else
						t1 += s[i];
				}
			}
			if(!flag) 
				System.out.println("Port     = <default>");		
			
			//Path
			flag = false; t1 ="";
			for(int i=cnt;i<s.length;i++) {
				t1 += s[i];
				flag = true;
			}
			if(!flag) 
				System.out.println("Path     = <default>");	
			else
				System.out.println("Path     = " + t1);		
			
			System.out.println();
		}		
	}
}
