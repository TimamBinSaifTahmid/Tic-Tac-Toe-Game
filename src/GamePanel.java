import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class GamePanel extends JFrame {

    JButton button1=new JButton();
    JButton button2=new JButton();
    JButton button3=new JButton();
    JButton button4=new JButton();
    JButton button5=new JButton();
    JButton button6=new JButton();
    JButton button7=new JButton();
    JButton button8=new JButton();
    JButton button9=new JButton();
    AI ai;
    Theme theme;
    GameState gameState=new GameState();
    JPanel leftPanel,rightPanel;
    Container container;
    ImageIcon forestThemeImage1,forestThemeImage2;
    JLabel lebel1=new JLabel("Theme:");
    JRadioButton radio1=new JRadioButton("Classic");
    JRadioButton radio2=new JRadioButton("Forrest");
    JRadioButton radio3=new JRadioButton("High Contrast");
    ButtonGroup buttonGroup =new ButtonGroup();
    JButton aiButton1 =new JButton("Start With Random AI");
    JButton aiButton2 =new JButton("Start With Defensive AI");
    int winner=0;
    public Font font=new Font("Arial",Font.BOLD,20);
    Hashtable<Integer, JButton> integer_button_map =
            new Hashtable<Integer, JButton>();
    Hashtable<JButton, Integer> ht2 =
            new Hashtable<JButton, Integer>();

    public GamePanel(){
        this.setBounds(650,200,700, 400);
        this.setTitle("Tic_Tac_Toe_Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mappingIntegerWithButton();
        radio1.setSelected(true);
        startWithAI();
        container=this.getContentPane();
        container.setLayout(new GridLayout(1,2,2,2));
        container.setBackground(Color.BLACK);
         leftPanel=new JPanel();
        leftPanel.setLayout(new GridLayout(3,9,2,2));
        leftPanel.setBackground(Color.BLACK);
        forestThemeImage1=new ImageIcon("D:\\java\\tic-tac-toe-swe-18\\solutions\\17-tahmid\\src\\lichi.png");
        forestThemeImage2=new ImageIcon("D:\\java\\tic-tac-toe-swe-18\\solutions\\17-tahmid\\src\\Rose1.png");
        leftPanel.add(button1);
        leftPanel.add(button2);
        leftPanel.add(button3);
        leftPanel.add(button4);
        leftPanel.add(button5);
        leftPanel.add(button6);
        leftPanel.add(button7);
        leftPanel.add(button8);
        leftPanel.add(button9);
        container.add(leftPanel);
        rightPanel=new JPanel();
        rightPanel.setLayout(new GridLayout(6,1,9,9));
        lebel1.setFont(font);
        buttonGroup.add(radio1);
        buttonGroup.add(radio2);
        buttonGroup.add(radio3);
        radio1.setFont(font);
        radio2.setFont(font);
        radio3.setFont(font);
        rightPanel.add(lebel1);
        rightPanel.add(radio1);
        rightPanel.add(radio2);
        rightPanel.add(radio3);
        aiButton1.setFont(font);
        aiButton2.setFont(font);
        rightPanel.add(aiButton1);
        rightPanel.add(aiButton2);
        container.add(rightPanel);
          theme=new ClassicTheme(gameState.move, integer_button_map,font,container,leftPanel);
       theme.applyTheme();
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
        applyMove(0,0);
            }
        });
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                applyMove(0,1);
            }

        });
        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                applyMove(0,2);
            }

        });
        button4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                applyMove(1,0);
            }

        });
        button5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
          applyMove(1,1);
            }

        });
        button6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
          applyMove(1,2);
            }

        });
        button7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
   applyMove(2,0);
            }

        });
        button8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {

                applyMove(2,1);
            }

        });
        button9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
            applyMove(2,2);
            }

        });
        radio1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               theme=new ClassicTheme(gameState.move, integer_button_map,font,container,leftPanel);
               theme.reloadTheme();
                theme.applyTheme();
                theme.previousMoveThemeset();

            }

        });
        radio2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                theme=new ForestTheme(gameState.move, integer_button_map,forestThemeImage1,forestThemeImage2,container,leftPanel);
               theme.reloadTheme();
                theme.applyTheme();
               theme.previousMoveThemeset();
            }

        });
        radio3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                theme=new HighContrastTheme(gameState.move, integer_button_map,container,leftPanel);
                theme.reloadTheme();
               theme.applyTheme();
              theme.previousMoveThemeset();

            }

        });

    }

    private void mappingIntegerWithButton() {
       integer_button_map.put(1,button1);
       integer_button_map.put(2,button2);
       integer_button_map.put(3,button3);
       integer_button_map.put(4,button4);
       integer_button_map.put(5,button5);
       integer_button_map.put(6,button6);
       integer_button_map.put(7,button7);
       integer_button_map.put(8,button8);
       integer_button_map.put(9,button9);
    }

    private void startWithAI() {
    disableButton(9);
        aiButton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                ai=new RandomAi(gameState.move);
                reloadGameConsole(9);
           enableButton(9);
            }

        });
        aiButton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                ai=new DefensiveAi(gameState.move);
                reloadGameConsole(9);
                enableButton(9);
            }

        });
    }

    private void disableButton(int n) {
        for(int i=1;i<=n;i++){
            integer_button_map.get(i).setEnabled(false);
        }
    }
    private void enableButton(int n) {
        for(int i=1;i<=n;i++){
            integer_button_map.get(i).setEnabled(true);
        }
    }

    void reloadGameConsole(int n){
        for(int i=1;i<=n;i++){
            integer_button_map.get(i).setText("");
            integer_button_map.get(i).setIcon(null);
            integer_button_map.get(i).setBackground(null);
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                gameState.move[i][j]='\0';
            }
        }
        theme.applyTheme();
    }


   void endingResultShow(){
            disableButton(9);
            winner = gameState.winner;
            if (winner == 1) {
                JOptionPane.showMessageDialog(null, "PLAYER WIN");
            } else if (winner == 2) {
                JOptionPane.showMessageDialog(null, "AI WIN");
            } else if (winner == 3) {
                JOptionPane.showMessageDialog(null, "DRAW!");
            }
        }


   void applyMove(int x,int y){
       boolean playerMoves = gameState.playerMove(x, y);
       if (playerMoves == true){
           int move=arrayIndexMappingWithButton(x,y);
           theme.applyThemeForPlayer(move);
           boolean endingChecker= gameState.endingCheck(3);
           if(endingChecker==false) {
               int aimMves = ai.aiMove(3);
               if (aimMves != -1) {
                   theme.applyThemeForAi(aimMves);
               }
               boolean endingCheker2= gameState.endingCheck(3);
               if(endingCheker2==true)
                   endingResultShow();
           }
           else {
               endingResultShow();
           }

       }
   }
    int arrayIndexMappingWithButton(int x,int y) {
        return 3*x+y+1;
    }

    public static void main(String[] args) {
        GamePanel panel=new GamePanel();
        panel.setVisible(true);
    }

}
