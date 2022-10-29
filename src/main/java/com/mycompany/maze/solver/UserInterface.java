
package com.mycompany.maze.solver;

import com.mycompany.maze.solver.Algorithm.DFS;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author aravindcz
 */
public class UserInterface extends JFrame implements ActionListener,MouseListener {
    
 
    JButton submitBtn,clearBtn;
    
    Point start = new Point(-1,-1);
    
    Point end = new Point(-1,-1);
    
    
    

private int [][] maze=
    {{0,0,0,0,0,0,0,0,0,0,0,0,0},
          {1,0,1,0,1,0,1,0,1,1,1,0,1},
          {1,0,1,0,0,0,1,0,1,1,1,0,1},
          {1,0,0,0,1,1,1,0,0,0,0,0,1},
          {1,0,1,0,0,0,0,0,1,1,1,0,1},
          {1,0,1,0,1,1,1,0,1,0,0,0,1},
          {1,0,1,0,1,0,0,0,1,1,1,0,1},
          {1,0,1,1,1,1,1,1,1,0,1,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,1},
          {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

private List<Integer> path = new ArrayList<>();
    
    UserInterface(){
    setLayout(null);
    setTitle("Mazer Solver");
    setSize(800,500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    addMouseListener(this);
    
    
    
    
    submitBtn = new JButton("Submit");
    submitBtn.addActionListener(this);  
    submitBtn.setBounds(200,425,80,30);
    add(submitBtn);
    
    clearBtn = new JButton("Clear");
    clearBtn.addActionListener(this);  
    clearBtn.setBounds(300,425,80,30);
    add(clearBtn);
    
            }
    
    @Override
    public void paint(Graphics g){
    super.paint(g);
    g.translate(40, 40);
    

   
    
    for(int row=0;row<maze.length;row++){
    for(int col=0;col<maze[0].length;col++){
    Color color;
    color = switch (maze[row][col]) {
            case 1 -> Color.BLACK;
            case 9 -> Color.RED;
            default -> Color.WHITE;
        };
    g.setColor(color);
    
    g.fillRect(40*col, 40*row, 40, 40);
    g.setColor(Color.BLACK);
    g.drawRect(40*col, 40*row, 40, 40);
    }
    }
    

          
    
 
   
    
    for(int i=0;i<path.size();i+=2){
    int x = path.get(i);
    int y = path.get(i+1);
    
    g.setColor(Color.GREEN);
    g.fillRect(x*40, y*40, 40, 40);
    g.setColor(Color.BLACK);
    g.drawRect(x*40, y*40, 40, 40);
    }
    
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
    
        if(event.getSource()== submitBtn){
            if(start.x!=-1 && end.x!=-1){
                
                System.out.println(start+"=>"+end);
                DFS.searchPath(maze, start.x, start.y, path);

                repaint();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select start and end cell in grid");
                return;
            }
            
        }
        
        if(event.getSource() == clearBtn){
            
            if(end.x!=-1){
            maze[end.x][end.y]=0;
            }
            start = new Point(-1,-1);
            end = new Point(-1,-1);
            for(int row=0;row<maze.length-1;row++){
            for(int col=0;col<maze[row].length-1;col++){
                if(maze[row][col]==2||maze[row][col]==9)
                    maze[row][col]=0;
            }
            }
            path.clear();
            repaint();
            
        }
    
    }
    
    
@Override
     public void mouseClicked(MouseEvent e) {  
       if(e.getX()>=50 && e.getX()<=570 && e.getY()>=50 && e.getY()<=450){
          int x = e.getX()/40;
          int y = e.getY()/40;
          
         if(maze[y-1][x-1]==1){
         JOptionPane.showMessageDialog(null, "You cannot select that cell as it is a dead end");
         return;
         }
         
         if(start.x==-1){
         start = new Point(y-1,x-1);
         }
         else
             if(end.x==-1){
             end = new Point(y-1,x-1);
             maze[y-1][x-1]=9;
             }
                 
             else{
                 JOptionPane.showMessageDialog(null, "Already selected start and end . Please complete the current maze problem or choose to clear and start fresh");
         return;
             }
          
           Graphics g=getGraphics();
          
          g.setColor(Color.RED);
          g.fillRect(40*x, 40*y, 40, 40);
          g.setColor(Color.BLACK);
          g.drawRect(40*x, 40*y, 40, 40);
          
          
          
          
      }  
  
         }     

     @Override 
    public void mouseEntered(MouseEvent e){
        
    }
    @Override 
    public void mouseExited(MouseEvent e){
        
    }
    @Override 
    public void mousePressed(MouseEvent e){
        
    }
    @Override 
    public void mouseReleased(MouseEvent e){
        
    }
      

}
        
        
    
