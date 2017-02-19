import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class Flip extends JPanel 
    {
    private static JPanel table= new JPanel(new GridLayout(9,4));
private static JLabel[][] labels = new JLabel[8][3];
private static JButton [] button=new JButton[8];

 

    public Flip() {
       super(new BorderLayout());

         JLabel symbol= new JLabel("Symbol");
         JLabel name= new JLabel("Name");
         JLabel price= new JLabel("Price");
         JLabel details=new JLabel("Details");
         table.add(symbol);
         table.add(name);
         table.add(price);
         table.add(details);
        
      for(int i=0;i<8;i++){
        for (int j=0;j<4 ;j++ ){
       if(j==3){
        button[i]=new JButton("");
        button[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table.add(button[i]);
        break;
       }
       labels[i][j]= new JLabel("");
       labels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
       table.add(labels[i][j]);

       }
      setPreferredSize(new Dimension(500,500));
         add(table,BorderLayout.CENTER); 
} 
      
     labels[0][0].setText("FB");
     labels[1][0].setText("VRTU");
     labels[2][0].setText("MSFT");
     labels[3][0].setText("GOOGL");
     labels[4][0].setText("YHOO");
     labels[5][0].setText("XLNX");
     labels[6][0].setText("TSLA");
     labels[7][0].setText("TXN");


     labels[0][1].setText("Facebook");
     labels[1][1].setText("Virtusa Corporation - common stock");
     labels[2][1].setText("Microsoft Corporation - Common Stock");
     labels[3][1].setText("Google Inc. - Class C Capital Stock");
     labels[4][1].setText("Yahoo! Inc. - Common Stock");
     labels[5][1].setText("Xilinx");
     labels[6][1].setText("Tesla Motors");
     labels[7][1].setText("Texas Instruments Incorporated - Common Stock");}

  
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void main(String [] args){
        //Create and set up the window.
        JFrame frame = new JFrame("Click to Flip (On--Off)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new Flip();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }    
}