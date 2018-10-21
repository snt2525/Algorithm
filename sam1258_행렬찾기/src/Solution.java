import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc =sc.nextInt();
		for(int test= 1;test<=tc;test++) {
			ArrayList<Integer> sort = new ArrayList<Integer>();
			int[][] num = new int[21][4];
			int n =sc.nextInt();
			int[][] array = new int[n][n];
			int[][] log = new int[n][n];
			int count=0; //ÃÑ ¼ö¿­ÀÇ ¼ö
			for(int i=0;i<n;i++) 
				for(int j=0;j<n;j++) 
					array[i][j]=sc.nextInt();					
			for(int i=0;i<n;i++) { 
				for(int j=0;j<n;j++) {
					if(array[i][j]!=0&&log[i][j]==0) {
						int a =0,b =0;
						int xx= i; int yy =j;
						int xxCount=0;int yyCount=0;
						while(true) {
							if(array[xx][yy++]==0)break;
							yyCount++;
						} yy =j;
						while(true) {
							if(array[xx++][yy]==0)break;
							xxCount++;
						}
						for(int k=0;k<xxCount;k++) {
							xx= i+k;
							for(int h=0;h<yyCount;h++) {
								yy = j+h;
								log[xx][yy]=1;
							}
						}						
						num[count][0]=xxCount;
						num[count][1]=yyCount;
						num[count++][2]=xxCount*yyCount;
						sort.add(xxCount*yyCount);				
					}
				}
			}			
			Collections.sort(sort);
			System.out.print("#"+test+" "+count+" ");
			for(int i=0;i<count;i++) {
				int temp=0;int min=0,jj=0;
				for(int j=0;j<count;j++) {
					if(sort.get(i)==num[j][2]&&num[j][0]>min&&num[j][3]==0) {
						min = Math.min(min, num[j][0]);	jj=j;
					}
				}
				num[jj][3]=1;
				System.out.print(num[jj][0]+" "+num[jj][1]+" ");
			}
			System.out.println();
		}
	}
}
