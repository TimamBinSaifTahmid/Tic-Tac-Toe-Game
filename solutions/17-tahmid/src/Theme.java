import javax.swing.*;
import java.util.Hashtable;

public class Theme {
    char move[][] = new char[3][3];
    Hashtable<Integer, JButton> integer_button_mapping = new Hashtable<Integer, JButton>();
    Theme(char[][] move,Hashtable<Integer, JButton> integer_button_mapping){
        this.move=move;
        this.integer_button_mapping =integer_button_mapping;
    }
    void applyTheme(){

        }
    void applyThemeForPlayer(int move){

        }
    void applyThemeForAi(int move){

        }

    public void previousMoveThemeset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (move[i][j] != '\0') {
                    if (move[i][j] == 'X') {
                        int move1 = arrayIndexMappingWithButton(i, j);
                        applyThemeForPlayer(move1);
                    } else {
                        int move2 = arrayIndexMappingWithButton(i, j);
                        applyThemeForAi(move2);
                    }
                }
            }
        }
    }
    int arrayIndexMappingWithButton(int x, int y) {
        return 3 * x + y + 1;
    }
    public void reloadTheme() {
        for (int i = 1; i <= 9; i++) {
            integer_button_mapping.get(i).setText("");
            integer_button_mapping.get(i).setIcon(null);
            integer_button_mapping.get(i).setBackground(null);
        }
    }
}
