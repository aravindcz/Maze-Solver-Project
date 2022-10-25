/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze.solver;

import java.util.List;

/**
 *
 * @author aravindcz
 */
public class DFS {
    
    public static boolean searchPath(int[][] maze,int x,int y,List<Integer> path){
        
        if((x<0)||(y<0)||(x>maze.length-1)||(y>maze[x].length-1))
            return false;
        
        if(maze[x][y]==9){
        path.add(y);
        path.add(x);
        return true;
        }
        
        if(maze[x][y]==0){
        maze[x][y]=2;
        
        int dx = -1;
        int dy = 0;
        if(searchPath(maze,x+dx,y+dy,path)){
        path.add(y);
        path.add(x);
        return true;
        }
        
        dx=1;
        dy=0;
        if(searchPath(maze,x+dx,y+dy,path)){
        path.add(y);
        path.add(x);
        return true;
        }
        
        dx=0;
        dy=1;
        if(searchPath(maze,x+dx,y+dy,path)){
        path.add(y);
        path.add(x);
        return true;
        }
        
        dx=0;
        dy=-1;
        if(searchPath(maze,x+dx,y+dy,path)){
        path.add(y);
        path.add(x);
        return true;
        }
        
        
        }
        
        return false;
    }
    
    
}
