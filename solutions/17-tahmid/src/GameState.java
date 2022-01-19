public class GameState {
    char [] [] move=new char[3][3];
    int winner;

    boolean endingCheck(int n){

        boolean b1,b2,b3,b4;
        b1= verticalEndingCheck(n);
        b2= horizontalEndingCheck(n);
        b3= diagonalEndingCheck(n);

        if(b1==true||b2==true||b3==true)
            return true;
        else {
            b4=drawCheck(n);
            if(b4==true)
                return true;
        }
        return false;
    }
    private boolean verticalEndingCheck(int n) {
        int flag=1,i,j;
        for(j=0;j<n;j++){
            flag=1;
            for( i=0;i<n-1;i++){
                if(move[i][j]!=move[i+1][j] || move[i][j]=='\0' || move[i+1][j]=='\0'){
                    flag=0;
                    break;
                }
            }
            if(flag==1){
                if(move[i][j]=='X') {
                    System.out.println("player win");
                    winner=1;
                }
                else {
                    winner=2;
                    System.out.println("Ai win");
                }

                return true;
            }
        }
        return false;
    }
    private boolean horizontalEndingCheck(int n) {
        int flag=1,i,j;
        for(i=0;i<n;i++){
            flag=1;
            for(j=0;j<n-1;j++){
                if(move[i][j]!=move[i][j+1] || move[i][j]=='\0' || move[i][j+1]=='\0'){
                    flag=0;
                    break;
                }
            }
            if(flag==1){
                if(move[i][j]=='X') {
                    System.out.println("player win");
                    winner=1;
                }
                else {
                    System.out.println("Ai win");
                    winner=2;
                }
                return true;
            }
        }
        return false;
    }
    private boolean diagonalEndingCheck(int n) {
        int flag=1,i,j;
        for(i=0, j=0 ; i<n-1 && j<n-1 ; i++,j++){
            if(move[i][j]!=move[i+1][j+1] || move[i][j]=='\0' || move[i+1][j+1]=='\0'){
                flag=0;
                break;
            }
        }
        if(flag==1){
            if(move[i][j]=='X') {
                System.out.println("player win");
                winner=1;
            }
            else {
                System.out.println("Ai win");
                winner=2;;
            }
            return true;
        }
        flag=1;
        for(i=0, j=n-1 ; i<n-1 && j>0 ; i++,j--){
            if(move[i][j]!=move[i+1][j-1] || move[i][j]=='\0' || move[i+1][j-1]=='\0'){
                flag=0;
                break;
            }
        }
        if(flag==1){
            if(move[i][j]=='X') {
                System.out.println("player win");
                winner=1;
            }
            else {
                System.out.println("Ai win");
                winner=2;
            }
            return true;
        }
        return false;
    }
    private boolean drawCheck(int n) {
        int flag=1,i,j;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(move[i][j]=='\0'){
                    flag=0;
                    break;
                }
            }
        }
        if(flag==1) {
            System.out.println("Draw!");
            winner=3;
            return true;
        }
        return false;
    }
    boolean playerMove(int x,int y){
        System.out.println(move[x][y]);
        if(move[x][y]=='\0') {
            move[x][y]='X';
            return true;
        }
        return false;
    }
}
