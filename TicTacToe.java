 import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 

 public class TicTacToe  extends JPanel 
 implements ActionListener {


int n=3;//the size of the playing board
static int count=0;

JButton[][] buttons = new JButton[n][n];
JButton reset=new JButton ("Restart Game");
JLabel player= new JLabel(""); 
char[][] state = new char[n][n];
boolean check=false;
boolean end=false;

public TicTacToe(){
       super(new BorderLayout());
       
       JPanel board= new JPanel(new GridLayout(n,n));
      
       
     
      for(int i=0;i<n;i++){
        for (int j=0;j<n ;j++ ){
       
       buttons[i][j]= new JButton("");
       board.add(buttons[i][j]);
       buttons[i][j].setPreferredSize(new Dimension(150,150));
       buttons[i][j].addActionListener(this);
       state[i][j]='B';
         }
      }
        
        reset.addActionListener(this);
        reset.setPreferredSize(new Dimension(450,50));
        reset.setFont(new Font("Arial", Font.PLAIN, 40));
        add(board, BorderLayout.CENTER);
        add(reset,BorderLayout.PAGE_END);
        add(player,BorderLayout.PAGE_START);
        
       
}

  public void actionPerformed(ActionEvent e){
     
     if(count%2==0){//displaying whose turn
        player.setText("Player ones turn");
        player.setHorizontalAlignment(SwingConstants.CENTER);}
     else{
        player.setText("Player twos turn");
        player.setHorizontalAlignment(SwingConstants.CENTER);}

     for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
       if(check==true && e.getSource()!=reset ){//if somehas one already
            JOptionPane.showMessageDialog(null, "Restart to play again","Message", JOptionPane.ERROR_MESSAGE);
            break;
            }
     
     if(e.getSource() == buttons[i][j]){
    if(count%2==0 && state[i][j]=='B'){
        state[i][j]='X';
        buttons[i][j].setText("X");
        buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 100));
        buttons[i][j].setForeground(Color.BLACK);
        count++; 
        }
    else if(count%2!=0  && state[i][j]=='B'){
        state[i][j]='O';
        buttons[i][j].setText("O");
        buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 100));
        buttons[i][j].setForeground(Color.WHITE);
        count++; 
        }

        else{
            JOptionPane.showMessageDialog(null, "Button already in use","Message", JOptionPane.ERROR_MESSAGE);
        }
        game(i,j,state[i][j]);
        }
      
    }if(check==true)
    break;
}
    if(e.getSource() ==reset){//if we want to restart the game
        for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
               buttons[i][j].setText("");
               state[i][j]='B';
               check=false;
               end=false;
             }
        }
                    count=0;

        }
     
  }
  public void game(int x,int y,char s){

       
    for(int i = 0; i < n; i++){//win by completing row
            if(state[x][i] != s)
                break;
            if(i==n-1 && count%2!=0){
                JOptionPane.showMessageDialog(null, "Player one wins","Message", JOptionPane.PLAIN_MESSAGE);
            check=true;
            }
            if(i == n-1 && count%2==0){
                JOptionPane.showMessageDialog(null, "Player two wins","Message", JOptionPane.PLAIN_MESSAGE);
                check=true;
            }
        }

    for(int i = 0; i < n; i++){//win by completing column
            if(state[i][y] != s)
                break;
            if(i==n-1 && count%2!=0){
                JOptionPane.showMessageDialog(null, "Player one wins","Message", JOptionPane.PLAIN_MESSAGE);
             check=true;
            }
            if(i == n-1 && count%2==0){
                JOptionPane.showMessageDialog(null, "Player two wins","Message", JOptionPane.PLAIN_MESSAGE);
              check=true;
            }
        }

    if(x == y){//win by completing diagnol
            
            for(int i = 0; i < n; i++){
                if(state[i][i] != s)
                    break;
                if(i==n-1 && count%2!=0){
                JOptionPane.showMessageDialog(null, "Player one wins","Message", JOptionPane.PLAIN_MESSAGE);
                check=true;
            }
            if(i == n-1 && count%2==0){
                JOptionPane.showMessageDialog(null, "Player two wins","Message", JOptionPane.PLAIN_MESSAGE);
                check=true;
            }
            }
        }
        for(int i = 0;i<n;i++){//win by completing anti diagnol
            if(state[i][(n-1)-i] != s)
                break;
            if(i==n-1 && count%2!=0){
                JOptionPane.showMessageDialog(null, "Player one wins","Message", JOptionPane.PLAIN_MESSAGE);
                check=true;
            }
            if(i == n-1 && count%2==0){
                JOptionPane.showMessageDialog(null, "Player two wins","Message", JOptionPane.PLAIN_MESSAGE);
               check=true;
            }
        }
     
        if(count == (n*n) && check==false)//when draw
            JOptionPane.showMessageDialog(null, "Draw","Message", JOptionPane.PLAIN_MESSAGE);
     }   
  

 public static void main(String [] args){
        //Create and set up the window.
        JFrame frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new TicTacToe();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
       } }  
     
