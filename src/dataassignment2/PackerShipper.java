/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataassignment2;

import Queue.UnboundedQueueInterface;
import Queue.LinkedUnbndQueue;
import ArrayList.ArrayUnsortedList;
import ArrayList.ListInterface;
/*
 *  Group 7
 *   Adrian Paiva - 100864588
 *   Patrick Gomes Sanches - 100870148
 *   Laurence Elbo - 100542843
 *   Alexander Hau - 100843239
 */
public class PackerShipper implements Runnable {
    
    private int iterations;
    private UnboundedQueueInterface<Product> ProductionAssembly;
    private ListInterface<Product> shippingList;
    

    public PackerShipper(int iterations, UnboundedQueueInterface<Product> ProductionAssembly) {
        this.iterations = iterations;
        this.ProductionAssembly = ProductionAssembly;
        shippingList = new ArrayUnsortedList();
        
    }
    
    public void Pack()
    {
        Product p = ProductionAssembly.dequeue();
        System.out.println("Packing :: Pulled From Production Queue and Packed :: " + p.getName());
        
        shippingList.add(p); // add to final shipping list
        
        
    }
    public void Shipping()
    {
        System.out.println("");
        System.out.println("Shipment details :: shipment finished ");
        System.out.println("The following items are shipped: ");
        System.out.println("");
        
        System.out.println(shippingList);
        
    }
    

    @Override
    public void run() 
    {
      for(int n=1;n <= iterations ;n++){
            Pack();
            try{Thread.sleep(80);} catch (InterruptedException e){}
        }
      Shipping();
    }
}
