package oy.tol.tira.books;

public interface BookInterface<E> {
   
   /**
    * @param element The element to add, must not be null.
    * @throws NullPointerException If the parameter element is null.
    * @throws LinkedListAllocationException If failed to allocate a new list element.
    */
   public void add(E element) throws NullPointerException, AllocationException;

   /**
    * @param index The index where to add the element, must be 0...count().
    * @param element The element to add, must not be null.
    * @throws NullPointerException If the parameter element is null.
    * @throws LinkedListAllocationException If failed to allocate a new list element.
    * @throws IndexOutOfBoundsException If the specified index to the list is out of bounds.
    */
    public void add(int index, E element) throws NullPointerException, AllocationException, IndexOutOfBoundsException;

   /**
    * @return True if element was found and removed, false otherwise.
    * @throws NullPointerException If the parameter element is null.
    */
    public boolean remove(E element) throws NullPointerException;

   /**
    * @param index The index of the element to remove.
    * @return Returns the element which was found and removed, null otherwise.
    * @throws IndexOutOfBoundsException If the specified index to the list is out of bounds.
    */
    public E remove(int index) throws IndexOutOfBoundsException;

    /**
    * @return The element in the specified index.
    * @throws IndexOutOfBoundsException If the specified index to the list is out of bounds.
    */
   public E get(int index) throws IndexOutOfBoundsException;

   /**
    * @param element The element to search for, must not be null.
    * @return The index of the element, or -1 if it was not found.
    * @throws NullPointerException If the parameter element is null.
    */
   public int indexOf(E element) throws NullPointerException;
   /**
    * @return Count of elements in the list.
    */
   public int size();

   public void clear();
   
   public void reverse();
}