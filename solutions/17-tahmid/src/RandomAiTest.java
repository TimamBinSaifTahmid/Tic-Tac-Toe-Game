import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomAiTest {
    @Test
    void movetest(){
       boolean check=true;
        boolean check2=false;
          GamePanel gamePanel=new GamePanel();
          GameState gameState=new GameState();
          RandomAi randomAi=new RandomAi(gameState.move);
          gameState.playerMove(0,0);
        gameState.playerMove(0,1);
        gameState.playerMove(0,2);
        gameState.playerMove(1,0);
        gameState.playerMove(1,1);
        gameState.playerMove(1,2);
       int randomMove1= randomAi.aiMove(3);
       int flag=0;
       for(int i=0;i<2;i++){
           for(int j=0;j<3;j++){
               if(gamePanel.arrayIndexMappingWithButton(i,j)==randomMove1){
                   flag=1;
                   break;
               }
           }
           if(flag==1)break;
       }
       if(flag==1||randomMove1>9)check=false;
        Assertions.assertEquals(true,check);


    }
}
