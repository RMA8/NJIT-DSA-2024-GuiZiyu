package oy.tol.tra;

public class QueueImplementation<E> implements QueueInterface<E> {
    private Object[] itemArray;
    private int capacity;
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    public QueueImplementation() {
        itemArray = new Object[capacity];
        this.capacity = capacity;
    }

    /**
    * Add an element to the queue.
    * @param element The element to add, must not be null.
    * @throws QueueAllocationException If the reallocation for the queue failed in case queue needs reallocation.
    * @throws NullPointerException If the element is null.
    */
    public void enqueue(E element) throws QueueAllocationException, NullPointerException{
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
        if (size == capacity) {
            int newCapacity = capacity * 2; 
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(itemArray, 0, newArray, 0, capacity);
            itemArray = newArray;
            capacity = newCapacity; 
        }
        itemArray[tail] = element;
        tail = (tail + 1) % itemArray.length;
        size++;
    }

    /**
    * Removes an element from the queue.
    * @return The element from the head of the queue.
    * @throws QueueIsEmptyException If the queue is empty.
    */
    public E dequeue() throws QueueIsEmptyException{
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty");
        }
        E element = (E) itemArray[head];
        itemArray[head] = null;
        head = (head + 1) % itemArray.length;
        size--;
        return element;
    }

    /**
    * Returns the element at the head of the queue, not removing it from the queue.
    * @return The element in the head of the queue.
    * @throws QueueIsEmptyException If the queue is empty.
    */
    public E element() throws QueueIsEmptyException{
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty");
        }
        E element = (E) itemArray[head];
        return element;
    }


    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear(){
    head = tail = 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            StringBuilder builder1 = new StringBuilder("[]");
            return builder1.toString();
        }
        StringBuilder builder2 = new StringBuilder("[");
        for (var index = 0; index <= size; index++) {
            builder2.append(itemArray[index].toString());
            if (index < size) {
                builder2.append(", ");
            }
        }
        builder2.append("]");
        return builder2.toString();
    }
}