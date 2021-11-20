
package dot_matrix;

import javax.swing.*;
import java.awt.event.*;

public class UI extends JFrame implements ActionListener{
    JButton bSub;
    JTextField inp1;
    JTextField inp2;
    JTextField inK;
    
    UI(String str){
        super(str);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(800, 450);
        this.setLocationRelativeTo(null);
        
        inp1 = new JTextField("ACTTCGAAG",3);
        inp1.setBounds(200, 120, 500, 50);
        this.add(inp1);
        
        inp2 = new JTextField("CTTCGACATGG",3);
        inp2.setBounds(200, 220, 500, 50);
        this.add(inp2);
        
        inK = new JTextField("1");
        inK.setBounds(200, 30, 50, 50);
        this.add(inK);
        
        bSub = new JButton("Calculate");
        bSub.setBounds(300, 330, 150, 50);
        bSub.addActionListener(this);
        this.add(bSub);
        
        JLabel des1 = new JLabel("Input k-tupe:");
        des1.setBounds(100, 30, 150, 50);
        this.add(des1);
        
        JLabel des2 = new JLabel("Genome 1:");
        des2.setBounds(100, 120, 150, 50);
        this.add(des2);
        
        JLabel des3 = new JLabel("Genome 2:");
        des3.setBounds(100, 220, 150, 50);
        this.add(des3);
        
        
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        Object x = ae.getSource();
        if(x.equals(bSub)){
            String st1 = inp1.getText();
            String st2 = inp2.getText();
            String sel = inK.getText();
            
            Matrixer mat = new Matrixer(st1,st2,Integer.parseInt(sel));
            mat.kTuple();
        }
    }
    
    public static void main(String[] argz){
        UI ui = new UI("Dot Matrix Builder");
    }
}
