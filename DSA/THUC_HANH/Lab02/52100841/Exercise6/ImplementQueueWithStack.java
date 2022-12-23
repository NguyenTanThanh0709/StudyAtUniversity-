
import java.util.NoSuchElementException;

public class ImplementQueueWithStack<E> implements QueueInterface<E> {
    MyStack<E> stack1 ; 
    MyStack<E> stack2 ;
    int countElement;

    public ImplementQueueWithStack(){
        stack1 =  new MyStack<>();
        stack2 =  new MyStack<>();
        countElement = 0;
    }

    @Override
    public void enQueue(E item) {
        // TODO Auto-generated method stub
        stack1.push(item);
        countElement++;
        
    }

    @Override
    public E deQueue() {
        if(stack2.isEmpty()){
            while(stack1.size()!=1){
                stack2.push(stack1.pop());
            }
        }else{
            return stack2.pop();
        }
        countElement--;
        return stack1.pop();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return countElement;
    }

    @Override
    public boolean containss(E item) {
        
        return stack1.contains(item) || stack2.contains(item);
    }


    @Override
    public void print() {

        
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return countElement == 0;
    }

    @Override
    public E getFront() {
        // TODO Auto-generated method stub
        
        return null;
    }

}
