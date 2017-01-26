/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdsimulation;
import java.util.*;

/**
 *
 * @author steventhompson
 */
public class Simulation {
    
    Particle[] particles;
    long total_distant;
     double delta_x;
   double delta_y;
   double[] total_distance = new double[2];
   
   double delta_vx;
   double delta_vy;
   double[] diffrence_velocity = new double[2];;
   
   double r_r;
   double v_v;
   double v_r;
   
   double total_radius; //sigma
   
   double d;
   Particle particle;
   Particle other; 
    
    PriorityQueue<Double> pq1 = new PriorityQueue<Double>();
    
    public Simulation(Particle[] particles)
    {
        this.particles = particles;
         
        for(int i = 0; i < particles.length; i++)
        {
            for(int j = i+1; j< particles.length; j++)
         {
         particle = particles[i];
         other = particles[j];
         Math(particle, other);
         
        }
              
      }
    }
    
     public double Math (Particle particle, Particle other)
    {
        this.particle = particle;
        this.other = other;
         
         delta_x = (particle.rx - other.rx); //distance apart in x 
       delta_y = (particle.ry - other.ry); // distance apart in y
       total_distance[0] = (delta_x);
       total_distance[1] = (delta_y);
       
       delta_vx = (particle.vx - other.vx); //diffrecne in particles x velocity
       delta_vy = (particle.vy - other.vy); //diffrecne in particles y velocity;
      diffrence_velocity[0] = (delta_vx);
      diffrence_velocity[1] = (delta_vy);
      
      r_r = (delta_x)*(delta_x) + delta_y *delta_y ;
      v_v = (delta_vx)*(delta_vx) + delta_vy *delta_vy ;
      v_r =(delta_vx)*(delta_x) + delta_vy *delta_y;
      
      total_radius = particle.radius + other.radius;
      
      d = (v_r * v_r) - (v_v) * (r_r - (total_radius *total_radius));
      
      if(particle == other)   //same particle
        return Double.POSITIVE_INFINITY;
      
      if(v_r > 0)  //dont hit again
          return Double.POSITIVE_INFINITY;
      
      if(d < 0)  //dont hit agina
          return Double.POSITIVE_INFINITY;
      System.out.println( -(v_r + Math.sqrt(d)) / v_v);
      return -(v_r + Math.sqrt(d)) / v_v;  //if they hit, delta T
     
           }
     
    }
   
 
    

