/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze.solver;

import javax.swing.SwingUtilities;

/**
 *
 * @author aravindcz
 */
public class MazeSolver {
    
        public static void main(String[] args){
    
        SwingUtilities.invokeLater(new Runnable(){
        
            @Override
            public void run(){
            
            UserInterface view = new UserInterface();
            view.setVisible(true);
            
            }
        
        });
}
    
}
