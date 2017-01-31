/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdsimulation;



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
  
    }
    
  
    
}

