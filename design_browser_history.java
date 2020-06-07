/*
 * You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.

Implement the BrowserHistory class:

    BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
    void visit(string url) visits url from the current page. It clears up all the forward history.
    string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
    string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.

 */

import java.util.*;
class design_browser_history {
    String curr;
    Stack<String> ahead;
    Stack<String> backward;
    public design_browser_history(String homepage) {
        ahead = new Stack<>();
        curr = new String(homepage);
        backward = new Stack<>();
    }
    
    public void visit(String url) {
        backward.push(curr);
        curr = url;
        ahead = new Stack<>();
        
    }
    
    public String back(int steps) {
        if(backward.size()==0)
            return curr;
        ahead.push(curr);
        if(steps>backward.size()){
            while(backward.size()!=1){
                String x = backward.pop();
                ahead.push(x);
            }
            curr = backward.pop();
            // System.out.println(backward);
            // System.out.println(ahead);
            return curr;
            
        }else{
            while(steps>1){
                 String x = backward.pop();
                ahead.push(x);
                steps--;
            }
            curr = backward.pop();
            // System.out.println(backward);
            // System.out.println(ahead);
            return curr;
        }
    }
    
    public String forward(int steps) {
        if(ahead.size()==0)
            return curr;
        backward.push(curr);
        if(steps>ahead.size()){
            while(ahead.size()!=1){
                String x = ahead.pop();
                backward.push(x);
            }
            curr = ahead.pop();
            // System.out.println(backward);
            // System.out.println(ahead);
            return curr;
            
        }else{
            while(steps>1){
                 String x = ahead.pop();
                backward.push(x);
                steps--;
            }
            curr = ahead.pop();
            // System.out.println(backward);
            // System.out.println(ahead);
            return curr;
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
