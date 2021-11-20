package dot_matrix;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Matrixer extends JFrame{
    String g1,g2;
    String[][] matrix;
    int lenX;
    int lenY;
    int k;
    
    JTable table;
    JScrollPane sp;
    DefaultTableModel model;
    
    Matrixer(String g1, String g2, int k){
        super("Dot Matrix");
        lenX = g1.length()+1;
        lenY = g2.length()+1;
        
        this.k = k;
        
        this.g1 = g1;
        this.g2 = g2;
        
        matrix = new String[lenY][lenX];
        matrix[0][0] = "";
        
        int x,y;
        Character z;
        
        for(x=1; x < lenX; x++){
            z = g1.charAt(x-1);
            matrix[0][x] = z.toString();
        }
        for(y=1; y < lenY; y++){
            z = g2.charAt(y-1);
            matrix[y][0] = z.toString();
        }
    }
    
    public void kTuple(){
        int x,y,z;
        boolean eq = false;
        for(y=1; y < lenY; y++){
            for(x=1; x < lenX; x++){    
                
                if( y + k - 1 > g2.length() || x + k - 1 > g1.length() ){
                    matrix[y][x] = "";
                    continue;
                }
                
                eq = true;
                for(z=0; z < k; z++){
                    if(g1.charAt(x-1+z) != g2.charAt(y-1+z))
                        eq = false;
                }
                if(eq == true)
                    matrix[y][x] = "*";
                else
                    matrix[y][x] = "";
                
            }
        }
        modelFill();
    }
    
    void modelFill(){
        Integer x;
        String[] num = new String[lenX];
        
        for(x=0; x < lenX; x=x+1){
            num[x] = x.toString();
        }
        
        
        model = new DefaultTableModel(matrix,num);
        tabler();
    }
    
    void tabler(){
        table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        sp = new JScrollPane(table);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setBounds(0, 20, 700, 400);
        
        this.setLayout(null);
        //this.setResizable(true);
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        this.add(sp);
        
        this.setVisible(true);
    }

}
