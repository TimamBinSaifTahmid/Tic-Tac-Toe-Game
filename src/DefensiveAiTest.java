import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DefensiveAiTest {
    @Test
    void DefensiveAiVerticaltest(){
        GamePanel gamePanel=new GamePanel();
        GameState gameState=new GameState();
        gameState.playerMove(1,0);
        gameState.playerMove(1,2);
        DefensiveAi defensiveAi=new DefensiveAi(gameState.move);
       int horizontalDefensiveAiMoves= defensiveAi.aiMove(3);
       int expectedResult=gamePanel.arrayIndexMappingWithButton(1,1);
        Assertions.assertEquals(expectedResult,horizontalDefensiveAiMoves);



    }
    @Test
    void DefensiveAiHorizontaltest(){
        GamePanel gamePanel2=new GamePanel();
       GameState gameState2=new GameState();
        gameState2.playerMove(0,0);
        gameState2.playerMove(1,0);
        DefensiveAi defensiveAi2=new DefensiveAi(gameState2.move);
        int verticalDefensiveAiMoves= defensiveAi2.aiMove(3);
        int expectedResult2=gamePanel2.arrayIndexMappingWithButton(2,0);
        Assertions.assertEquals(expectedResult2,verticalDefensiveAiMoves);
    }
    @Test
    void DefensiveAiDiagonaltest(){
        GamePanel gamePanel3=new GamePanel();
        GameState gameState3=new GameState();
        gameState3.playerMove(0,0);
        gameState3.playerMove(1,1);
        DefensiveAi defensiveAi3=new DefensiveAi(gameState3.move);
        int diagonalDefensiveAiMoves= defensiveAi3.aiMove(3);
        int expectedResult3=gamePanel3.arrayIndexMappingWithButton(2,2);
        Assertions.assertEquals(expectedResult3,diagonalDefensiveAiMoves);
    }
}
