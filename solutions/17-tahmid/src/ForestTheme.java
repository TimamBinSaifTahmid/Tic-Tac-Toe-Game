import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class ForestTheme extends Theme {
    Hashtable<Integer, JButton> integer_button_mapping = new Hashtable<Integer, JButton>();
    Font font;
    Container container;
    JPanel leftPanel;
    char move[][] = new char[3][3];

    ImageIcon forestThemeImage1, forestThemeImage2;

    ForestTheme(char[][] move, Hashtable<Integer, JButton> integer_button_mapping , ImageIcon forestThemeImage1, ImageIcon forestThemeImage2, Container container, JPanel leftPanel) {
        super(move,integer_button_mapping );
        this.integer_button_mapping = integer_button_mapping ;
        this.forestThemeImage1 = forestThemeImage1;
        this.forestThemeImage2 = forestThemeImage2;
        this.container = container;
        this.leftPanel = leftPanel;
        this.move = move;
    }

    public void applyTheme() {
        container.setBackground(Color.decode("#006400"));
        leftPanel.setBackground(Color.decode("#006400"));
        for (int i = 1; i <= 9; i++)
            integer_button_mapping.get(i).setBackground(Color.decode("#90EE90"));
    }

    public void applyThemeForPlayer(int move) {

        integer_button_mapping.get(move).setIcon(forestThemeImage2);


    }

    public void applyThemeForAi(int move) {
        integer_button_mapping.get(move).setIcon(forestThemeImage1);

    }






}