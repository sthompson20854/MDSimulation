/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdsimulation;

import java.util.PriorityQueue;
import java.util.Comparator;

/**
 *
 * @author steventhompson
 */
public class Event implements Comparable<Event> {
    
   double time_event;
   double delta_t;
   Particle particle;
   Particle other; 
   double event_xp; //particles x at event
   double event_yp; //particles y at event
   double event_xo;//others x at event
   double event_yo;//others y at event
  
    
   
  
   
   public Event(double time_event, Particle particle, Particle other,double delta_t)
   {
      this.delta_t = delta_t;
       this.particle = particle;
       this.other = other;
       this.time_event = time_event;
       
      
   }
   
   public double get_time(){
       return time_event;
   }

    @Override
    public int compareTo(Event o) {
      return(int)(this.time_event - o.time_event);
      
    }
   

}
    

