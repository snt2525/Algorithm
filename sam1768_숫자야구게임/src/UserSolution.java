import javax.management.Query;

class UserSolution {
     public final static int N = 4;
     public void doUserImplementation(int guess[]) {
    	 Solution s = new Solution();  
         int [] number = new int[10];
    	 int[] guessG = new int[4]; 
    	 int[][] findNum = new int[4][2]; //����� ã������
    	 int guessCnt =1;
    	 int findCnt=0;
    	 int possibleCnt =10;
    	 Solution.Result resultT = new Solution.Result();
    	 Solution.Result result = new Solution.Result();
    	 while(true) { 
    		 int count=0,i=0; //���� 4�� ����, i�� ����� �����ؼ� �־������ 
    		 while(count<4) {  //���ڸ� �����Ѵ�
    			 if(findNum[count][1]==1) {
    				 count++;
    				 continue;
    			 }else if(number[i]==0)  
    				 guessG[count++]= i;      			 
    			 if(i>=10) i=0;
    			 else i++;
    		 }
    		 result = s.query(guessG);
    		 if(result.ball==0&&result.strike==0){
    			 for(int j=0;j<4;j++) { 
    				 possibleCnt--;
    				 number[guessG[j]]=1;
    			 }
    			continue;    			 
    		 }else {
    			 for(int j=i;j<=9;j++) {
    				 for(int k=0;k<4;k++) {
    					 if(possibleCnt<=(4-findCnt)||findCnt==4||s.query(guessG).strike==4) { //���� �ϰų� �̹� ã�Ұų�
        					 for(int h=0;h<4;h++) guess[h] = guessG[h];
        					 result  = s.query(guess);
        					 if(findCnt==4||result.strike==4) return; //��Ʈ����ũ�� 4���� ���� retrun;
        					 while(result.strike!=4) {//������ �ؾ��ϴ� ���
        						 int[] real = new int[4];
        						 for(int q=0;q<4;q++)real[q]=findNum[q][1];
    	    					 for(int t=0;t<3;t++) {
    	    						 if(real[t]==1)continue;
    	    						 for(int g =t+1;g<4;g++) {
    	    							 if(real[g]!=1) {
    		    							 swap(guess,t,g);
    		    							 resultT = s.query(guess);
    		    							 if(resultT.strike==4){ //ã������
    		    								 return; 
    		    							 }else if(resultT.strike==result.strike+2) { //2������
    		    								 real[g]=real[t]=1;
    		    								 break;
    		    							 }else if(resultT.strike==result.strike-2) { //2�� ����
    		    								 swap(guess,g,t);
    		    								 real[g]=real[t]=1;
    		    								 break;
    		    							 }
    		    							 swap(guess,g,t); 
    	    							 }
    	    						 }
    	    					 }
    	    						result  = s.query(guess); 
        					 }
        				 }else if(findNum[k][1]!=1&&number[j]==0) {
	    					 int temp = guessG[k];
	    					 guessG[k]=j;
	    					 resultT = s.query(guessG);
	    					 if(resultT.strike>result.strike) { //strick�� �þ��.
	    						 if(resultT.ball==result.ball) {
	    							 number[temp]=1; // ����ġ��
		    						 possibleCnt--;
	    						 }
	    						 findNum[k][1]=1;
	    						 findNum[k][0]=j;
	    						 number[j]=1; // ����ġ��
	    						 findCnt++;
	    						 possibleCnt--;
	    						 result.ball=resultT.ball;
	    						 result.strike=resultT.strike;
	    						 break;
	    					 }else if((resultT.strike==result.strike&&resultT.ball==result.ball-1)) { //strick�� �ٰ� ,ball�� �ٸ�
	    						 number[j]=1; // ����ġ��
	    						 possibleCnt--;
	    						 guessG[k]=temp; //���� ����
	    						 break;
	    					 }else if(resultT.strike==result.strike-1){ //��Ʈ����ũ �ٰ�, ���� �ö󰣴�.
	    						 if(resultT.ball==result.ball) number[j]=1; // ����ġ��
	    						 findNum[k][1]=1;
	    						 findNum[k][0]=temp;
	    						 number[temp]=1; // ����ġ��
	    						 findCnt++;
	    						 possibleCnt--;
	    						 guessG[k]=temp; //���� ����   			
	    						 continue;
	    					 }
	    					 guessG[k]=temp; //���� ����
    					 }
    				 }
    			 }
    			 
    		 }
    	 }  	 
     }
     public void swap(int[] guess, int a,int b) {
    	 int temp = guess[a];
    	 guess[a]= guess[b];
    	 guess[b] = temp;
     }    
 }