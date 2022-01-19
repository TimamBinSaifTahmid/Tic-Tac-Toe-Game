import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class ClassicTheme extends Theme {
    Hashtable<Integer, JButton> integer_button_mapping = new Hashtable<Integer, JButton>();
    Font font;
    Container container;
    JPanel leftPanel;
    char move[][] = new char[3][3];

    ClassicTheme(char[][] move, Hashtable<Integer, JButton> integer_button_mapping , Font font, Container container, JPanel leftPanel) {
        super(move,integer_button_mapping );
        this.integer_button_mapping = integer_button_mapping ;
        this.font = font;
        this.container = container;
        this.leftPanel = leftPanel;
        this.move = move;
    }

    public void applyTheme() {
        container.setBackground(Color.black);
        leftPanel.setBackground(Color.black);
        for (int i = 1; i <= 9; i++)
            integer_button_mapping.get(i).setBackground(Color.white);
    }

    public void applyThemeForPlayer(int move) {

        integer_button_mapping.get(move).setText("X");
        integer_button_mapping.get(move).setFont(font);


    }

    public void applyThemeForAi(int move) {

        integer_button_mapping.get(move).setText("O");
        integer_button_mapping.get(move).setFont(font);


    }





}