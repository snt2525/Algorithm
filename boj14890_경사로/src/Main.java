import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int result=0;
		int N =sc.nextInt();
		int length = sc.nextInt();
		int[][] map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] =sc.nextInt();
			}
		}
		
		//세로 검사
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int now= map[j][i];
				int cnt = 0;
				int tmp = j;
				if(j+1>=N) { //벽일 때끝내기
					result++; break;
				}
				if(j==0&&now+1==map[j+1][i]&&length!=1)break; 
				boolean flag = false;
				if(map[j+1][i]==now)continue; //같으면 통과
				else if(map[j+1][i]==now+1) { //다음 길이 나보다 클떄
					int check = map[j+1][i];
					while(tmp<N) { //몇개인지 체크
						if(++tmp<N&&map[tmp][i]==check) cnt++;
						else break;
					}					
				}else if(map[j+1][i]==now-1) { //다음 길이 나보다 작을 때
					int check = map[j+1][i];
					while(tmp<N) { //몇개인지 체크
						if(++tmp<N&&map[tmp][i]==check) cnt++;
						else break;
					}
					flag = true;
				}
				int a = tmp;
				if(tmp>=N&&cnt>=length) {  //내리막길 성공하고, 마지막 벽일때 카운트
					result++;
					break;
				}else if((tmp<N&&tmp-1>=0&&((map[tmp][i]-1)==map[tmp-1][i])&&cnt>=length&&!flag)||
						(tmp<N&&tmp-1>=0&&((map[tmp][i])==map[tmp-1][i]+1)&&flag&&cnt>=(length*2))||
						(tmp<N&&tmp-1>=0&&((map[tmp][i]+1)==map[tmp-1][i])&&cnt>=length)) { //전에 내리막길이였는데 length *2 이후에 오르막길이면
					j = tmp-2;
					continue;
				}
				break; //이도저도 아닐 때						
			}
		}	
				
		for(int j=0;j<N;j++) {
			for(int i=0;i<N;i++) {
				int now= map[j][i];
				int cnt = 0;
				int tmp = i;
				if(i+1>=N) { //벽일 때끝내기
					result++;
					break;
				}
				if(i==0&&now+1==map[j][i+1]&&length!=1)break;
				boolean flag = false;
				if(map[j][i+1]==now)continue; //같으면 통과
				else if(map[j][i+1]==now+1) { //다음 길이 나보다 클떄
					int check = map[j][i+1];
					while(tmp<N) { //몇개인지 체크
						if(++tmp<N&&map[j][tmp]==check) cnt++;
						else break;
					}					
				}else if(map[j][i+1]==now-1) { //다음 길이 나보다 작을 때
					int check = map[j][i+1];
					while(tmp<N) { //몇개인지 체크
						if(++tmp<N&&map[j][tmp]==check) cnt++;
						else break;
					}
					flag = true;
				}
				if(tmp>=N&&cnt>=length) {  //내리막길 성공하고, 마지막 벽일때 카운트
					result++;
					break;
				}else if((tmp<N&&tmp-1>=0&&((map[j][tmp]-1)==map[j][tmp-1])&&cnt>=length&&!flag)||
						(tmp<N&&tmp-1>=0&&((map[j][tmp]+1)==map[j][tmp-1])&&cnt>=length)||
						(tmp<N&&tmp-1>=0&&((map[j][tmp])==map[j][tmp-1]+1)&&flag&&cnt>=(length*2))) { //전에 내리막길이였는데 length *2 이후에 오르막길이면
					i = tmp-2;
					continue;
				}
				break; //이도저도 아닐 때						
			}		
		}	
		System.out.println(result);
	}
}
