/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdsimulation;
import java.io.File;
import java.util.*;

/**
 *
 * @author steventhompson
 */
public class Simulation {
    
    public static Particle[] particles;
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
   
   double event_xp; //particles x at event
   double event_yp; //particles y at event
   double event_xo;//others x at event
   double event_yo;//others y at event
   
   double current_time = 0;
   double event_time;
   double delta_t;
   
   double total_radius; //sigma
   
   double d;
   Particle particle;
   Particle other; 
   public static double[][] array;
   public static int dimension1, dimension2;
 public PriorityQueue<Event> pq1 = new PriorityQueue<Event>();
    
    
    public Simulation(Particle[] particles)
    {
       while(true){ 
        this.particles = particles;
         
        for(int i = 1; i < particles.length; i++)
        {
           particle = particles[i]; 
            other = particles[0];
           
           delta_t = y_wall(particle);
           event_time = current_time + delta_t;
          
       if(event_time < 99999999 && event_time > 0){
       
       
     Event a = new Event(event_time, particle, other, delta_t);
      pq1.add(a);
       }
            
       delta_t = x_wall(particle);
              event_time = current_time + delta_t;
       if(event_time < 99999999 && event_time > 0){
       //System.out.println("returned ex =  " + event_time);
       
     Event a = new Event(event_time, particle, other, delta_t);
      pq1.add(a);
       }
            for(int j = i+1; j< particles.length; j++)
         {
         
         other = particles[j];
       delta_t = Math(particle, other);
      
      
       event_time = current_time + delta_t;
       if(event_time < 99999999){
       System.out.println("returned e =  " + event_time);
       
     Event a = new Event(event_time, particle, other, delta_t);
      pq1.add(a);
       }
        }
              
      }
         for(Event a:pq1){
            System.out.println(a.get_time());
        }
        
         Event e;
          e = pq1.poll();
          if(e.other.rx == 0)
          {
            wall_math(e.delta_t, e.particle);
          }
          else
         event_math(e.delta_t, e.particle, e.other);
          
      
        current_time++;
        System.out.println(current_time + "/n");
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
      //System.out.println((long)Double.POSITIVE_INFINITY + "this is a problem");
     // System.out.println( -(v_r + Math.sqrt(d)) / v_v);
      return -(v_r + Math.sqrt(d)) / v_v;  //if they hit, delta T
     
           }
     
     public double y_wall (Particle particle){
         this.particle = particle;
         if(particle.vy > 0)
          return((1-particle.radius-particle.ry)/particle.vy);
         
         if(particle.vy < 0)
             return((particle.radius - particle.ry)/particle.vy);
         
             return Double.POSITIVE_INFINITY;
     }
     
       public double x_wall (Particle particle){
         this.particle = particle;
         
         if(particle.vx > 0)
          return((1-particle.radius-particle.rx)/particle.vx);
         
         if(particle.vy < 0)
             return((particle.radius - particle.rx)/particle.vx);
         
             return Double.POSITIVE_INFINITY;
     }
       
       public void event_math(double delta_t, Particle particle, Particle other)
       {
           this.particle = particle;
           this.other = other;
           v_r =(delta_vx)*(delta_x) + delta_vy *delta_y;
           delta_x = (particle.rx - other.rx); //distance apart in x 
           delta_y = (particle.ry - other.ry); // distance apart in y
           delta_vx = (particle.vx - other.vx); //diffrecne in particles x velocity
           delta_vy = (particle.vy - other.vy); //diffrecne in particles y velocity;
           total_radius = particle.radius + other.radius;
           
           particle.rx = particle.rx + delta_t*particle.vx;
           particle.ry = particle.ry + delta_t*particle.vy;
           other.rx = other.rx + delta_t*other.vx;
           other.ry = other.ry + delta_t*other.vy;
           
           double j = (2*particle.mass*other.mass*v_r)/(total_radius*(particle.mass+other.mass));
           double jx = (j*delta_x)/total_radius;
           double jy = (j*delta_y)/total_radius;
           
           particle.vx = (particle.vx+jx)/particle.mass;
           particle.vy = (particle.vy+jy)/particle.mass;
           
            other.vx = (other.vx-jx)/other.mass;
            other.vy = (other.vy-jy)/other.mass;
           
           
           
           
       }
        public void wall_math(double delta_t, Particle particle)
        {
            this.particle = particle;
           particle.rx = particle.rx + delta_t*particle.vx;
           particle.ry = particle.ry + delta_t*particle.vy;
            
            
        }
    
     
    }
   
 
    

