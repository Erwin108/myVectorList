import java.util.Arrays;
public class MyVector<E> extends MyAbstractList<E> implements MyList<E> {
    // Instance variables
    private E array[];
    private int increment;

    // No-arg constructor

    @SuppressWarnings("unchecked")
    public MyVector() {
        array = (E[]) new Object[10];
        size = 0;
        increment = 0;
    }

     // constructor with parameters

    @SuppressWarnings("unchecked")
    public MyVector(int initCapacity) {
        array = (E[]) new Object[initCapacity];
        size = 0;
        increment = 5;
    }

    //constructor with parameters.

    @SuppressWarnings("unchecked")
    public MyVector(int initCapacity, int capIncrement) {
        array = (E[]) new Object[initCapacity];
        size = 0;
        increment = capIncrement;
    }

     // This method returns the string "Program 6, FullNameHere".

    public String getId() {
        return "Program 6, Erwin Frutos";
    }

     // This method returns the capacity of the internal array

    public int getCapacity() {
        return array.length;
    }

     //returns the capacity incremented in the vector

    public int getIncrement() {
        return increment;
    }

     //Puts the  element at the end of this list.

    @Override
    public boolean add(E data) {
        return add(size, data);
    }

     // puts element into needed position in the list.
     // Shifts the element currently at that position (if any) and any subsequent
     // elements by adding one to their indices.

    @Override
    public boolean add(int index, E data) {
        // Check if index is valid
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index out of bounds: " + index + ", size: " + size);
        // Get capacity
        int capacity = getCapacity();
        // Check if array requires expanding
        if (size >= capacity) {
            // Use capacity increment to create a new array , if it is set then
            // the new capacity will be (array.length + increment). If capacity
            // increment is not set then the new capacity will be double the
            // current capacity
            // Check whether capacity increment is set
            if (increment == 0)
                array = Arrays.copyOf(array, array.length * 2);
            else
                array = Arrays.copyOf(array, array.length + increment);
        }
        // Shift the elements at index and any subsequent elements by 1
        // position
        for (int i = size - 1; i >= index; i--)
            array[i + 1] = array[i];
        // Set data at index
        array[index] = data;
        // Increment size by 1
        size += 1;
        return true;
    }

    // Removes all elements from list

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        // Get capacity of the current array
        int capacity = getCapacity();
        // To clear vector, initialize array using the new keyword
        array = (E[]) new Object[capacity];
        // Set size to zero
        size = 0;
    }

     // True if this list contains the element in question

    @Override
    public boolean contains(E data) {
        // Iterate array to find data
        for (int i = 0; i < size; i++) {
            // Check if element at ith index is same as data
            if (array[i].equals(data))
                return true;
        }
        // Default return
        // If data is not found in the above iteration then return false
        return false;
    }

     //Returns the element at the specified position in this list

    @Override
    public E get(int index) {
        return array[index];
    }

     // Returns the index of the first occurrence of the specified element in
     // this list Return, or -1 if this list does not contain the element

    @Override
    public int indexOf(E data) {
        // Iterate array to find the first occurrence of data
        for (int i = 0; i < size; i++) {
            // Check if element at ith index is same as data
            if (array[i].equals(data))
                return i;
        }
        // Default return
        // If data is not found in the above iteration then return -1
        return -1;
    }

     // checks for index of the last match of the element in this list or
     // -1 if no match

    @Override
    public int lastIndexOf(E data) {
        // Iterate array to find the last occurrence of data
        for (int i = size - 1; i >= 0; i--) {
            // Check if element at ith index is same as data
            if (array[i].equals(data))
                return i;
        }
        // Default return
        // If data is not found in the above iteration then return -1
        return -1;
    }

    // true if list contains no elements

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    // Removes the element in question from list. Shifts any
    // elements that come after by taking away 1 from indices.

    @Override
    public E remove(int index) {
        // Check if index is valid
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index out of bounds: " + index + ", size: " + size);
        // Get data at index
        E data = array[index];
        // Shift any subsequent elements after index by 1 position
        for (int i = index; i < size - 1; i++)
            array[i] = array[i + 1];
        // Set data at (size)th index as null
        array[size] = null;
        // Decrement size by 1
        size -= 1;
        // Return data removed
        return data;
    }

     // Trims MyVector to match the list's current size.

    @Override
    public void trimToSize() {
        // Check if size is less than capacity
        if (size < getCapacity()) {
            // Create a new array using the current size
            array = Arrays.copyOf(array, size);
        }
    }

     // Returns elements in list

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public String toString(){
        String output = "[";
        for(int i = 0; i < size; i++){
            if(i == size -1) {
                output += array[i] + "]";
            }
             else {
                 output += array[i] + ", ";
            }
        }
        return output;
    }
}
