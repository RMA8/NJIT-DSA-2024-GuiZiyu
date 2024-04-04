package oy.tol.tra;

public class QueueImplementation<E> implements QueueInterface<E> {
    private Object[] itemArray;
    private int capacity;
    private int size = 0;
    private int head = 0;
    private int tail = 0;
    private static final int DEFAULT_QUEUE_SIZE = 10;

    public QueueImplementation(int capacity) {
        if (capacity < 1) {
			throw new QueueAllocationException("Invalid capacity");
		}
        itemArray = new Object[capacity];
        this.capacity = capacity;
        head = tail = -1;
    }

    public QueueImplementation(){
        this(DEFAULT_QUEUE_SIZE);
    }

    /**
    * For querying the current capacity of the queue.
    @return The number of elements the queue can currently hold.
    */
    public int capacity(){
        return capacity;
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
            reallocate();
        }
        if (isEmpty()) {
			head = tail = 0;
		} else {
			tail = (tail + 1) % itemArray.length;
		}
        itemArray[tail] = element;
        size++;
    }

    private void reallocate() {
        int newCapacity = capacity * 2;
        Object[] newArray = new Object[newCapacity];
        if (head <= tail) {
            for (int i = 0; i < size; i++) {
                newArray[i] = itemArray[(head + i) % capacity];
            }
        }else{
            int j = 0;
			for (int i = head; i < capacity; i++) {
				newArray[j++] = itemArray[i];
			}
			for (int i = 0; i <= head; i++) {
				newArray[j++] = itemArray[i];
			}
        }
        itemArray = newArray;
        head = 0;
        tail = size;
        capacity = newCapacity;
    }

    /**
    * Removes an element from the queue.
    * @return The element from the head of the queue.
    * @throws QueueIsEmptyException If the queue is empty.
    */
    @SuppressWarnings("unchecked")
    @Override
    public E dequeue() throws QueueIsEmptyException{
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty");
        }
        E element = (E) itemArray[head];
        if (head == tail) {
			head = tail = -1;
		} else {
			head = (head + 1) % capacity;
		}
        size--;
        return element;
    }

    /**
    * Returns the element at the head of the queue, not removing it from the queue.
    * @return The element in the head of the queue.
    * @throws QueueIsEmptyException If the queue is empty.
    */
    @SuppressWarnings("unchecked")
    @Override
    public E element() throws QueueIsEmptyException{
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty");
        }
        E element = (E) itemArray[head];
        return element;
    }

    @Override
    public int size() {
        if (isEmpty()) {
			return 0;
		}
		return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear(){
        for (int i = 0; i < capacity; i++) {
            itemArray[i] = null;
        }
        head = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty()) {
			if (head <= tail) {
				for (int i = head; i <= tail; i++) {
					sb.append(itemArray[i]);
					if (i < tail) {
						sb.append(", ");
					}
				}
			} else {
				for (int i = head; i < capacity; i++) {
					sb.append(itemArray[i]);
					sb.append(", ");
				}
				for (int i = 0; i <= tail; i++) {
					sb.append(itemArray[i]);
					if (i < tail) {
						sb.append(", ");
					}
				}
			}
		}
        sb.append("]");
        return sb.toString();
    }
}