/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdsimulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author steventhompson
 */

    public class Particle {
   
    double rx;
    double ry;
    double vx;
    double vy;
    double mass;
    double radius;
    int r;
    int g;
    int b;
    
   double[] values = new double[9];
    
    
    public Particle(double rx, double ry, double vy, double vx,double mass, double radius, double r,
           double g, double b)
    { 
        
    
        this.rx = rx;
        this.ry = ry;
        this.vx = vx;
        this.vy = vy;
        this.mass = mass;
        this.radius = radius;
        this.r = (int)r;
        this.g = (int)g;
        this.b = (int)b;
        
        //System.out.println(rx);
        
        values[0] = rx;
        values[1] = ry;
        values[2] = vx;
        values[3] = vy;
        values[4] = mass;
        values[5] = radius;
        values[6] = (int)r;
        values[7] = (int)g;
        values[8] = (int)b;
      //for (int row = 0; row < values.length; row++)
         //System.out.print(values[row] + " ");
  
    //System.out.println(" ");
       
    }
    
    public void main(){
     
        
    }
    
}

