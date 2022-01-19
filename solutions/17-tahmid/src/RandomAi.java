import java.util.Random;

public class RandomAi implements AI {
    char move[][]=new char[3][3];
    RandomAi(char[][] move){
        this.move=move;
    }
    @Override
    public int aiMove(int n) {
        Random rand1=new Random();
        Random rand2=new Random();
        while(true) {
            int column = rand1.nextInt(3);
            int row = rand2.nextInt(3);
            if (move[row][column] == '\0') {
                move[row][column] = 'O';
                return (3 * row + column + 1);
            }
        }

    }
}
