import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameEndingCheckTest {
    @Test
    void virticalGameEndingtest(){
        GamePanel gamePanel=new GamePanel();
        GameState gameState=new GameState();

        gameState.playerMove(0,0);
        gameState.playerMove(0,1);
        gameState.playerMove(0,2);
       boolean horizontalEndChecker= gameState.endingCheck(3);
        Assertions.assertEquals(true,horizontalEndChecker);
    }
    @Test
    void horizontalGameEndingtest(){
        GamePanel gamePanel2=new GamePanel();
        GameState gameState2=new GameState();
        gameState2.playerMove(0,0);
        gameState2.playerMove(1,0);
        gameState2.playerMove(2,0);
        boolean verticalEndChecker= gameState2.endingCheck(3);
        Assertions.assertEquals(true,verticalEndChecker);
    }
    @Test
    void diagonalGameEndingtest(){
        GamePanel gamePanel3=new GamePanel();
        GameState gameState3=new GameState();
        gameState3.playerMove(0,0);
        gameState3.playerMove(1,1);
        gameState3.playerMove(2,2);
        boolean diagonalEndChecker= gameState3.endingCheck(3);
        Assertions.assertEquals(true,diagonalEndChecker);
    }
    @Test
    void drawGameEndingtest(){
        GamePanel gamePanel4=new GamePanel();
        GameState gameState4=new GameState();
        DefensiveAi defensiveAi=new DefensiveAi(gameState4.move);
        gameState4.playerMove(0,0);
        gameState4.playerMove(0,1);
        gameState4.playerMove(1,1);
        gameState4.playerMove(1,2);
        gameState4.playerMove(2,0);
        defensiveAi.aiMove(3);
        defensiveAi.aiMove(3);
        defensiveAi.aiMove(3);
        defensiveAi.aiMove(3);
        boolean drawEndChecker= gameState4.endingCheck(3);
        Assertions.assertEquals(true,drawEndChecker);
    }

}
