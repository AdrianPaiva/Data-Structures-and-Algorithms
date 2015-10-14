/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataassignment2;

/*
 *  Group 7
 *   Adrian Paiva - 100864588
 *   Patrick Gomes Sanches - 100870148
 *   Laurence Elbo - 100542843
 *   Alexander Hau - 100843239
 */
import Queue.UnboundedQueueInterface;
import Queue.LinkedUnbndQueue;





public class OrderGenerator implements Runnable {

    private Product[] products;
    
    private int iterations;
    private UnboundedQueueInterface<Product> OrderDesign;
    
    public OrderGenerator(int iterations, UnboundedQueueInterface OrderDesign) {
        
        this.iterations = iterations;
        this.OrderDesign = OrderDesign;
        
        products = new Product[10]; // list of products
        
        products[0] = new Product("dish washer", 450.00f);
        products[1] = new Product("vacuum cleaner", 85.50f);
        products[2] = new Product("electric oven", 399.99f);
        products[3] = new Product("tabletop oven", 120.00f);
        products[4] = new Product("washing machine", 499.99f);
        products[5] = new Product("microwave oven", 150.99f);
        products[6] = new Product("alarm clock", 15.99f);
        products[7] = new Product("blender", 39.99f);
        products[8] = new Product("toaster oven", 61.99f);
        products[9] = new Product("rice cooker", 34.00f);
    }
    public void GenerateOrder()
    {
         
            int index = (int)(Math.random()* products.length); // Generate random array index to select random product
            Product P = products[index];
            OrderDesign.enqueue(P);// add product to order design queue
            
            //System.out.println("Order Generator :: Inserted into Order-Design queue :: Name :: " + P.getName() + " :: Price :: " + P.getPrice());
             System.out.println("Orders :: Inserted into Orders queue :: Name :: " + P.getName() );
            
    }
    
    @Override
    public void run() 
    {
      for(int n=1;n <= iterations ;n++){
            GenerateOrder();
            try{Thread.sleep(5);} catch (InterruptedException e){}
        }
    }
    
}
