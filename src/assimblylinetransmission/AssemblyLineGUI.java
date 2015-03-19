/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assimblylinetransmission;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AssemblyLineGUI extends JPanel {
    
    @Override
    public void paint(Graphics g) {
        
        
        
        
        /*
        inputs
        a is the time spent at Station S
        t is the time required to make a switch from a station on one line to the other
        e is the entry time of a chasis in a line
        x is the exit time of a complete car from a line
        n is total number of stations
        */
        int[][] a = {{1,2,3,4,5},{5,4,3,2,1}};
        int[][] t = {{1,1,1,1,1},{1,1,1,1,1}};
        int n=5;
        int[] e = {2,2};
        int[] x = {2,2};
        AssemblyLineTransmission cars = new AssemblyLineTransmission(a, t, e, x, n);
        int[] l = cars.FastestWay();
        
        // printing the output
//        for(int i=0;i<n;i++){
//            System.out.print(l[i]+" ");
//        }
        
        Graphics2D g2d = (Graphics2D) g;
        
        //g2d.drawString(1+"", 120, 40);
        Dimension size = getSize();
        g2d.drawString("Station 1", 10, 20);
        g2d.drawString("Station 2", size.width-80, 20);
        
        
        g2d.drawString("entry time: "+e[0], 10, 35);
        g2d.drawString("entry time: "+e[1], size.width-80, 35);
        
        
        g2d.drawString("exit time: "+x[0], 10, (n+1)*40+10);
        g2d.drawString("exit time: "+x[1], size.width-80, (n+1)*40+10);
        g2d.drawString("Total Time:  "+cars.f, size.width/2, (n+2)*40+10);
        for (int i=0;i<n;i++){
            
            
            
            g2d.setColor(Color.BLUE);
            g2d.fillRoundRect(10,40*(i+1) , 30, 30, 20,20);
            g2d.drawString(cars.a1[i]+"", 60, 40*(i+1)+20);
            
            g2d.setColor(Color.red);
            g2d.fillRoundRect(size.width-40,40*(i+1) , 30, 30, 20,20);
            g2d.drawString(cars.a2[i]+"", size.width-60, 40*(i+1)+20);
        
        
            
            if(l[i]==1){
                g2d.setColor(Color.MAGENTA);
                g2d.drawString(cars.f1[i]+"", 112, 40*(i+1)+20);
                g2d.draw(new Ellipse2D.Double(100, 40*(i+1), 30, 30));
            }
            else if (l[i] == 2){
                g2d.setColor(Color.pink);
                g2d.drawString(cars.f2[i]+"", size.width-102, 40*(i+1)+20);
                g2d.draw(new Ellipse2D.Double(size.width-112, 40*(i+1), 30, 30));
            }    
        }
        
    }
    

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Assembly Line Transmission");
        frame.add(new AssemblyLineGUI());
        frame.setSize(300, 300);
        frame.setVisible(true);        
     
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
