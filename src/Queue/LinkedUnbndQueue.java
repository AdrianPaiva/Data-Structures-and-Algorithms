/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Queue;

/*
 *  Group 7
 *   Adrian Paiva - 100864588
 *   Patrick Gomes Sanches - 100870148
 *   Laurence Elbo - 100542843
 *   Alexander Hau - 100843239
 */
public class LinkedUnbndQueue <T> implements UnboundedQueueInterface<T> {
    
    protected LLNode<T> front;
    protected LLNode<T> rear;
    
    

    public LinkedUnbndQueue() {
        front = null;
        rear = null;
    }
    
    
    @Override
    public synchronized void enqueue(T element) {
        
        LLNode<T> newNode = new LLNode<>(element);
        if(rear == null)
            front = newNode;
        else
            rear.setLink(newNode);
        rear = newNode;
        
        notifyAll();
    }

    @Override
    public synchronized T dequeue() throws QueueUnderflowException {
        
        
        while (isEmpty()){
            try {
                wait();
            } 
        
            catch (InterruptedException e) 
            {
                
            }
        } 
        
        if(isEmpty())
            throw new QueueUnderflowException("Dequeue attempted on empty queue");
        else
        {
            
            T element;
            element = front.getInfo();
            front = front.getLink();
            if(front == null)
                rear = null;
            notifyAll();
            return element;
        }
        
    }

    @Override
    public boolean isEmpty() {
        
        if(front == null)
            return true;
        else
            return false;
        
    }
    
}
