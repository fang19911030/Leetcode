public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(queue1.isEmpty()){
            queue1.add(x);
            for(int i=0;i<queue2.size();i++){
                queue1.add(queue2.poll());
            }
        }else{
            queue2.add(x);
            for(int i=0; i<queue1.size();i++){
                queue2.add(queue1.poll());
            }
        }
        
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue1.isEmpty()){
            return queue2.poll();
        }else{
            return queue1.poll();
        }

    }
    
    /** Get the top element. */
    public int top() {
        if(queue1.isEmpty()){
            return queue2.peek();
        }else{
            return queue1.peek();
        }
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() & queue2.isEmpty();
    }
}