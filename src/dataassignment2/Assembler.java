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
public class Assembler implements Runnable{
    
    private int iterations;
    private UnboundedQueueInterface<Product> OrderDesign;
    private UnboundedQueueInterface<Product> ProductionAssembly;
    

    public Assembler(int iterations, UnboundedQueueInterface<Product> OrderDesign, UnboundedQueueInterface<Product> ProductionAssembly) {
        this.iterations = iterations;
        this.OrderDesign = OrderDesign;
        this.ProductionAssembly = ProductionAssembly;
        
    }
    
    public void Assemble()
    {
           
            Product i = OrderDesign.dequeue();
           // System.out.println("Assembler ::  Pulled from queue :: Name :: " + i.getName() + " :: Price :: " + i.getPrice());
            System.out.println("Production -- phase A ::  Pulled from Order queue :: Name :: " + i.getName());
            
            ProductionAssembly.enqueue(i);
            System.out.println("Production -- phase B ::  Inserted Into Production Queue :: Name :: " + i.getName());
    }
    @Override
    public void run(){
        for(int n=1;n <= iterations;n++){
            Assemble();
            try{Thread.sleep(20);} catch (InterruptedException e){}
        }
    }
}
