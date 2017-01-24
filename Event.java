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
   
   public Event(long time_event, Particle particle, Particle other, double event_x, double event_y)
   {
       this.event_x = event_x;
       this.event_y = event_y;
       this.particle = particle;
       this.other = other;
       this.time_event = time_event;
       
   }
    
}
