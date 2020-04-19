public interface MyList<E> {

     // Puts the  element at the end of this list.

    public boolean add(E data);

     // puts element into needed position in the list.
     // Shifts the element currently in the position and any
     // elements after by adding one to their indices.

    public boolean add(int index, E data);

    //removes elements from the list.

    public void clear();

    //returns true when element is found.

    public boolean contains(E data);

     //Returns the element at the position needed in this list.

    public E get(int index);

     //Returns the index of the first occurrence of the specified element in
     //this list Return, or -1 if this list does not contain the element

    public int indexOf(E data);

     //Returns the index of the last matching of the element in this list Return

    public int lastIndexOf(E data);

     // Returns true if this list contains no elements

    public boolean isEmpty();

    // Removes the element in question from list. Shifts any
    // elements that come after by taking away 1 from indices.

    public E remove(int index);

     // Matches list's current size with current vector capacity.

    public void trimToSize();

    // Returns list's number of elements.

    public int size();
}
