package uvg.edu.gt;
import java.util.ArrayList;

public class MyStack<E> implements UVGStack<E> {
    
    protected ArrayList<E> stack = new ArrayList<E>(); 


    @Override
    public void push(E item) {
        stack.add(item);
    }

    @Override
    public E pop() throws Exception {
        if(stack.size()>=0){
            return stack.remove(stack.size()-1);
        }else{
            throw new Exception("Stack vacio");
        }
        
    }

    @Override
    public E top() throws Exception {
        if(stack.size()>=0){
            return stack.get(stack.size()-1);
        }else{
            throw new Exception("Stack vacio");
        }
            
    }

    @Override
    public boolean empty(){
        return stack.isEmpty();
    }

    @Override
    public int size(){
        return stack.size();
    }
}
