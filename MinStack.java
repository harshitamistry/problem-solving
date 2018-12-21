/* 155 - Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.*/

class MinStack {
    
    class Node{
        int val;
        int min;
        Node prev;
    }
    
    Node curr;

    public MinStack() {
        
    }
    
    // update the value of min node when pushing new element to the list
    public void push(int x) {
        Node node = new Node();
        node.val = x;
        node.min = x;
        if(curr == null){
            curr = node;
        }else{
            node.prev = curr;
            if(curr.min<x){
                node.min = curr.min;
            }
            curr = node;
        }
    }
    
    public void pop() {
        curr = curr.prev;
    }
    
    public int top() {
        return curr.val;
    }
    
    public int getMin() {
        return curr.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */