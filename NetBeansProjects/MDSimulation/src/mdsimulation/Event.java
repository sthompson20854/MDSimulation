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
public class Event {
    
   long time_event;
   Particle particle;
   Particle other; 
   double event_x;
   double event_y;
   
   double delta_x;
   double delta_y;
   double[] total_distance;
   
   double delta_vx;
   double delta_vy;
   double[] diffrence_velocity;
   
   double r_r;
   double v_v;
   double v_r;
   
   double total_radius; //sigma
   
   double d;
   
   public Event(long time_event, Particle particle, Particle other, double event_x, double event_y)
   {
       this.event_x = event_x;
       this.event_y = event_y;
       this.particle = particle;
       this.other = other;
       this.time_event = time_event;
       
       
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
   }
   

    
}
