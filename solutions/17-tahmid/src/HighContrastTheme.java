import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class HighContrastTheme extends Theme {
    Hashtable<Integer, JButton> integer_button_mapping = new Hashtable<Integer, JButton>();
    Font font;
    Container container;
    JPanel leftPanel;
    char move[][] = new char[3][3];


    HighContrastTheme(char[][] move, Hashtable<Integer, JButton> integer_button_mapping , Container container, JPanel leftPanel) {
        super(move,integer_button_mapping );
        this.move = move;
        this.integer_button_mapping = integer_button_mapping ;
        this.container = container;
        this.leftPanel = leftPanel;
    }

    public void applyTheme() {
        container.setBackground(Color.decode("#D3D3D3"));
        leftPanel.setBackground(Color.decode("#D3D3D3"));
        for (int i = 1; i <= 9; i++)
            integer_button_mapping.get(i).setBackground(Color.decode("#A9A9A9"));
    }

    public void applyThemeForPlayer(int move) {
        integer_button_mapping.get(move).setBackground(Color.BLACK);
    }

    public void applyThemeForAi(int move) {
        integer_button_mapping.get(move).setBackground(Color.white);
    }




}