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
		
		//���� �˻�
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int now= map[j][i];
				int cnt = 0;
				int tmp = j;
				if(j+1>=N) { //���� ��������
					result++; break;
				}
				if(j==0&&now+1==map[j+1][i]&&length!=1)break; 
				boolean flag = false;
				if(map[j+1][i]==now)continue; //������ ���
				else if(map[j+1][i]==now+1) { //���� ���� ������ Ŭ��
					int check = map[j+1][i];
					while(tmp<N) { //����� üũ
						if(++tmp<N&&map[tmp][i]==check) cnt++;
						else break;
					}					
				}else if(map[j+1][i]==now-1) { //���� ���� ������ ���� ��
					int check = map[j+1][i];
					while(tmp<N) { //����� üũ
						if(++tmp<N&&map[tmp][i]==check) cnt++;
						else break;
					}
					flag = true;
				}
				int a = tmp;
				if(tmp>=N&&cnt>=length) {  //�������� �����ϰ�, ������ ���϶� ī��Ʈ
					result++;
					break;
				}else if((tmp<N&&tmp-1>=0&&((map[tmp][i]-1)==map[tmp-1][i])&&cnt>=length&&!flag)||
						(tmp<N&&tmp-1>=0&&((map[tmp][i])==map[tmp-1][i]+1)&&flag&&cnt>=(length*2))||
						(tmp<N&&tmp-1>=0&&((map[tmp][i]+1)==map[tmp-1][i])&&cnt>=length)) { //���� ���������̿��µ� length *2 ���Ŀ� ���������̸�
					j = tmp-2;
					continue;
				}
				break; //�̵����� �ƴ� ��						
			}
		}	
				
		for(int j=0;j<N;j++) {
			for(int i=0;i<N;i++) {
				int now= map[j][i];
				int cnt = 0;
				int tmp = i;
				if(i+1>=N) { //���� ��������
					result++;
					break;
				}
				if(i==0&&now+1==map[j][i+1]&&length!=1)break;
				boolean flag = false;
				if(map[j][i+1]==now)continue; //������ ���
				else if(map[j][i+1]==now+1) { //���� ���� ������ Ŭ��
					int check = map[j][i+1];
					while(tmp<N) { //����� üũ
						if(++tmp<N&&map[j][tmp]==check) cnt++;
						else break;
					}					
				}else if(map[j][i+1]==now-1) { //���� ���� ������ ���� ��
					int check = map[j][i+1];
					while(tmp<N) { //����� üũ
						if(++tmp<N&&map[j][tmp]==check) cnt++;
						else break;
					}
					flag = true;
				}
				if(tmp>=N&&cnt>=length) {  //�������� �����ϰ�, ������ ���϶� ī��Ʈ
					result++;
					break;
				}else if((tmp<N&&tmp-1>=0&&((map[j][tmp]-1)==map[j][tmp-1])&&cnt>=length&&!flag)||
						(tmp<N&&tmp-1>=0&&((map[j][tmp]+1)==map[j][tmp-1])&&cnt>=length)||
						(tmp<N&&tmp-1>=0&&((map[j][tmp])==map[j][tmp-1]+1)&&flag&&cnt>=(length*2))) { //���� ���������̿��µ� length *2 ���Ŀ� ���������̸�
					i = tmp-2;
					continue;
				}
				break; //�̵����� �ƴ� ��						
			}		
		}	
		System.out.println(result);
	}
}
