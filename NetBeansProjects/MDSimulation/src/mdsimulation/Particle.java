/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdsimulation;

import java.io.File;
import java.io.FileNotFoundException;
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
    public Particle(double rx, double ry, double vy, double vx,double mass, double radius, int r,
            int g, int b)
    {
        this.rx = rx;
        this.ry = ry;
        this.vx = vx;
        this.vy = vy;
        this.mass = mass;
        this.radius = radius;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public void main(){
     
        
    }
    
}

