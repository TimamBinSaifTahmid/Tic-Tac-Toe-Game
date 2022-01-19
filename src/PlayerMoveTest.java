import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerMoveTest {
    @Test
    void movetest(){
        GamePanel gamePanel=new GamePanel();
        GameState gameState=new GameState();
       boolean bol= gameState.playerMove(2,1);
       boolean bol2=gameState.playerMove(2,1);
        Assertions.assertEquals(true,bol);
        Assertions.assertEquals(false,bol2);

    }
}
