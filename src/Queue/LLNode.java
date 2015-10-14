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
public class LLNode<T> {
    
    private LLNode link;
    private T info;

    public LLNode(T info) {
        link = null;
        this.info = info;
    }

    public LLNode getLink() {
        return link;
    }

    public void setLink(LLNode link) {
        this.link = link;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
    
    
}
