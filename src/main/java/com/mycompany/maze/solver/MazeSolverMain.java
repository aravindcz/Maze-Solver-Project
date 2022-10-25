
package com.mycompany.maze.solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author aravindcz
 */
public class MazeSolverMain extends JFrame {

private int [][] maze=
    {{0,0,0,0,0,0,0,0,0,0,0,0,0},
          {1,0,1,0,1,0,1,0,0,0,0,0,1},
          {1,0,1,0,0,0,1,0,1,1,1,0,1},
          {1,0,0,0,1,1,1,0,0,0,0,0,1},
          {1,0,1,0,0,0,0,0,1,1,1,0,1},
          {1,0,1,0,1,1,1,0,1,0,0,0,1},
          {1,0,1,0,1,0,0,0,1,1,1,0,1},
          {1,0,1,1,1,1,1,1,1,0,1,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,9,1},
          {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

private List<Integer> path = new ArrayList<>();
    
    MazeSolverMain(){
    setTitle("Mazer Solver");
    setSize(800,500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    DFS.searchPath(maze, 0, 0, path);
    System.out.println(path);
            }
    
    @Override
    public void paint(Graphics g){
    super.paint(g);
    g.translate(50, 50);
    

   
    
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
    g.fillRect(40*x, 40*y, 40, 40);
    g.setColor(Color.BLACK);
    g.drawRect(40*x, 40*y, 40, 40);
    }
    
    }
    
    public static void main(String[] args){
    
        SwingUtilities.invokeLater(new Runnable(){
        
            @Override
            public void run(){
            
            MazeSolverMain view = new MazeSolverMain();
            view.setVisible(true);
            
            }
        
        });
        
        
    }
    
}
