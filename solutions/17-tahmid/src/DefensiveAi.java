public class DefensiveAi implements AI {
 char move[][]=new char [3][3];
    DefensiveAi(char [][] move){
    this.move=move;
}
    @Override
    public int aiMove(int n) {
        int  defensiveAiMove= defensiveAiVerticalCheck(n);
        System.out.println("vert"+defensiveAiMove);
        if(defensiveAiMove==-1){
            defensiveAiMove=defensiveAiHorizontalCheck(n);
        }
        System.out.println("horit"+defensiveAiMove);
        if(defensiveAiMove==-1){

            defensiveAiMove=defensiveAiDiagonalCheck(n);
        }
        System.out.println("diag"+defensiveAiMove);
        if(defensiveAiMove==-1){
            RandomAi randomAi=new RandomAi(move);
            defensiveAiMove=randomAi.aiMove(3);
        }
        return defensiveAiMove;
    }
    private int defensiveAiVerticalCheck(int n) {
        for(int i=0,j=0;j<n;j++){
            for(int k=i;k<n-1;k++){
                for(int l=k+1;l<n;l++){
                    if(move[k][j]==move[l][j] && move[k][j]!='\0' && move[l][j]!='\0'){
                        int temp=(n)-(k+l);
                        if(move[temp][j]=='\0') {
                            move[temp][j] = 'O';
                            return arrayIndexMappingWithButton(temp, j);
                        }

                    }
                }
            }
        }
        return -1;
    }
    private int defensiveAiHorizontalCheck(int n) {
        for(int i=0,j=0;i<n;i++){
            for(int k=j;k<n-1;k++){
                for(int l=k+1;l<n;l++){
                    if(move[i][k]==move[i][l] && move[i][k]!='\0' && move[i][l]!='\0'){
                        int temp=(n)-(k+l);
                        if(move[i][temp]=='\0') {
                            move[i][temp] = 'O';
                            return arrayIndexMappingWithButton(i,temp);
                        }
                    }
                }
            }
        }
        return -1;
    }
    private int defensiveAiDiagonalCheck(int n) {
        for(int i=0,j=0;i<n-1;i++,j++){
            for(int k=i,m=j;k<n-1;k++,m++){
                for(int l=k+1,o=m+1;l<n;l++,o++){
                    if(move[k][m]==move[l][o] && move[k][m]!='\0' && move[l][o]!='\0'){
                        int temp1=(n)-(k+l);
                        int temp2=(n)-(m+o);
                        System.out.println(temp1);
                        System.out.println(temp2);
                        if(move[temp1][temp2]=='\0') {
                            move[temp1][temp2] = 'O';
                            return arrayIndexMappingWithButton(temp1,temp2);
                        }
                    }
                }
            }
        }
        for(int i=0,j=n-1;i<n-1;i++,j--){
            for(int k=i,m=j;k<n-1;k++,m--){
                for(int l=k+1,o=m-1;l<n;l++,o--){
                    if(move[k][m]==move[l][o] && move[k][m]!='\0' && move[l][o]!='\0'){
                        int temp1=(n)-(k+l);
                        int temp2=(n)-(m+o);
                        if(move[temp1][temp2]=='\0') {
                            move[temp1][temp2] = 'O';
                            return arrayIndexMappingWithButton(temp1,temp2);
                        }
                        else return -1;

                    }
                }
            }
        }
        return -1;
    }
    int arrayIndexMappingWithButton(int x,int y) {
        return 3*x+y+1;
    }
}
