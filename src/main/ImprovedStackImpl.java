package src.main;

/**
 * Implementation of the ImprovedStack interface. It's dependant on the {@see StackImpl} implementation
 * as a field to inherit the methods from {@see Stack}, which itself use a {@see List} as the 
 * underlying data structure to store the elements in the stack. 
 * 
 * @author federico bartolomei (bbk-pij-2014-21)
 */
public class ImprovedStackImpl implements ImprovedStack {
    private StackImpl stack;
    /**
     * The constructor take an implementation of interface {@see List} as a parameter
     * passing it down to initialize the field stack.
     * This implementation does not check whether the provided list is null.
     * Please note also that changes on this ImprovedStackImpl will affect the original List provided with 
     * this constructor.
     * 
     * @param list the data structure behind the stack.
     */
    public ImprovedStackImpl(List list) {
        stack = new StackImpl(list);
    }
    /**
     * If no parameter is passed with the constructor, an empty stack will be created
     * with an empty {@see LinkedList} as underlying data structure.
     *   
     */
    public ImprovedStackImpl() {
        List emptyList = new LinkedList();
        stack = new StackImpl(emptyList);
    }
    /**
     * {@inheritDoc}
     * 
     * This method copies the internalList elements if the caller class on reverse order
     * into a {@see LinkedListImpl}.
     *
     * @return a new ImprovedStack with a LinkedList as internal data structure, either empty
     * (if the original ImprovedStack was empty) or with a copy of its elements on reverse order.
     * Changes made on this newly created ImprovedStackImpl will not affect the original stack.
     */
    @Override
    public ImprovedStack reverse() {
        List copy = new LinkedList();
        if(!stack.isEmpty()) {
            for(int i=stack.internalList.size()-1; i>=0; i--) {
                copy.add(stack.internalList.get(i).getReturnValue());
            }
        }
        ImprovedStack reversed = new ImprovedStackImpl(copy);
        return reversed;
    }
    /**
     * {@inheritDoc}
     * 
     * This method calls the methods implemented for the underlying data structure {@see List}
     * which already do their own internal checking and resizing.
     *
     */
    @Override
    public void remove(Object object) {
        for(int i=0; i<stack.internalList.size(); i++) {
            if(stack.internalList.get(i).getReturnValue().equals(object)) {
                stack.internalList.remove(i);
                i--;
            }
        }
    }
    /**
     * {@inheritDoc}
     *
     * Method from interface {@see Stack} return the method from the implementation {@see StackImpl}
     * which itself calls the method implemented by the list set up with the constructor.
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
     /**
     * {@inheritDoc}
     *
     * Method from interface {@see Stack} return the method from the implementation {@see StackImpl}
     * which itself calls the method implemented by the list set up with the constructor.
     */
    @Override
    public int size() {
        return stack.size();
    }
    /**
     * {@inheritDoc}
     *
     * Method from interface {@see Stack} return the method from the implementation {@see StackImpl}
     * which itself calls the method implemented by the list set up with the constructor.
     */
    @Override
    public void push(Object item) {
        stack.push(item);
    }
    /**
     * {@inheritDoc}
     *
     * Method from interface {@see Stack} return the method from the implementation {@see StackImpl}
     * which itself calls the method implemented by the list set up with the constructor.
     */
    @Override
    public ReturnObject top() {
        return stack.top();
    }
    /**
     * {@inheritDoc}
     *
     * Method from interface {@see Stack} return the method from the implementation {@see StackImpl}
     * which itself calls the method implemented by the list set up with the constructor.
     */
    public ReturnObject pop() {
        return stack.pop();
    }
    
}
