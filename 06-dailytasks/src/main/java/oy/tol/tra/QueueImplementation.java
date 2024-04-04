package oy.tol.tra;

public class QueueImplementation<E> implements QueueInterface<E> {

	private Object[] itemArray;
	private int capacity;
	private int head;
	private int tail;
	private int size = 0;
	private static final int DEFAULT_QUEUE_SIZE = 10;

    public QueueImplementation(int capacity) throws QueueAllocationException {
		if (capacity < 1) {
			throw new QueueAllocationException("Invalid capacity");
		}
		itemArray = new Object[capacity];
		this.capacity = capacity;
		head = tail = -1;
	}

	public QueueImplementation() throws QueueAllocationException {
		this(DEFAULT_QUEUE_SIZE);
	}

	@Override
	public int capacity() {
		return capacity;
	}

	@Override
	public void enqueue(E element) throws QueueAllocationException, NullPointerException {
		if (element == null) {
			throw new NullPointerException("Element cannot be NULL");
		}
		if (size == capacity) {
		 relocate();
		}
		if (isEmpty()) {
			head = tail = 0;
		} else {
			tail = (tail + 1) % capacity;
		}
		itemArray[tail] = element;
		size++;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E dequeue() throws QueueIsEmptyException {
		if (isEmpty()) {
			throw new QueueIsEmptyException("Queue is empty");
		}
		E element = (E) itemArray[head];
		size--;
		if (head == tail) {
			head = tail = -1;
		} else {
			head = (head + 1) % capacity;
		}
		return element;
	}

    private void relocate() throws QueueAllocationException {
		int newCapacity = capacity * 2;
		Object[] newArray = new Object[newCapacity];
		if (head <= tail) {
			for (int i = 0; i < capacity; i++) {
				newArray[i] = itemArray[i];
			}
		} else {
			int j = 0;
			for (int i = head; i < capacity; i++) {
				newArray[j++] = itemArray[i];
			}
			for (int i = 0; i <= tail; i++) {
				newArray[j++] = itemArray[i];
			}
		}
		itemArray = newArray;
		head = 0;
		tail = capacity - 1;
		capacity = newCapacity;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E element() throws QueueIsEmptyException {
		if (isEmpty()) {
			throw new QueueIsEmptyException("Queue cannot be empty");
		}
		return (E) itemArray[head];
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
	public void clear() {
		head = tail = -1;
		size = 0;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		if (!isEmpty()) {
			if (head <= tail) {
				for (int i = head; i <= tail; i++) {
					builder.append(itemArray[i]);
					if (i < tail) {
						builder.append(", ");
					}
				}
			} else {
				for (int i = head; i < capacity; i++) {
					builder.append(itemArray[i]);
					builder.append(", ");
				}
				for (int i = 0; i <= tail; i++) {
					builder.append(itemArray[i]);
					if (i < tail) {
						builder.append(", ");
					}
				}
			}
		}
		builder.append("]");
		return builder.toString();
	}

}