/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataassignment2;

import Queue.UnboundedQueueInterface;
import Queue.LinkedUnbndQueue;



/*
 *  Group 7
 *   Adrian Paiva - 100864588
 *   Patrick Gomes Sanches - 100870148
 *   Laurence Elbo - 100542843
 *   Alexander Hau - 100843239
 */

public class DataAssignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        int iterations = 10; // how many random products to generate
        
        UnboundedQueueInterface<Product> OrderDesign = new LinkedUnbndQueue<>();
        UnboundedQueueInterface<Product> ProductionAssembly = new LinkedUnbndQueue<>();
        
        Runnable OrderGeneratorR = new OrderGenerator(iterations, OrderDesign);
        Runnable AssemblerR = new Assembler(iterations, OrderDesign, ProductionAssembly);
        Runnable PackerShipperR = new PackerShipper(iterations,ProductionAssembly);
        
        Thread OrderGeneratorT = new Thread(OrderGeneratorR);
        Thread AssemblerT = new Thread(AssemblerR);
        Thread PackerShipperT = new Thread(PackerShipperR);
        
        OrderGeneratorT.start();// start threads
        AssemblerT.start();
        PackerShipperT.start();
        
        
        
        
        
        
        
       try
       {
           OrderGeneratorT.join(); 
           AssemblerT.join(); 
           PackerShipperT.join(); 
           
       } 
       catch (InterruptedException e)
        {
            
        }
        
    }
    
}
