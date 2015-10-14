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
public class Product {
    
    private String name;
    private float price;
    
     public Product(String n, float p){
        name = n;
        price = p;
      }
     public String toString(){
         
           return "Name : " + name + " : Price : " + price ;     
      }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
     
}
