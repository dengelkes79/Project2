/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author denge
 */
public interface LinkedStringInterface <T> {
       public char[] toArray() throws LinkedStringException;//  converts linklist to an array   throws an exception if an array is empty
    
    /*
    returns true if an element is found in the array
    */
    public boolean contains(T value);

    /**
     *
     * @return converts value to string
     */
  
    public boolean isEmpty();  // returns true if empty and false if not empty
    public int length(); //returns the size of the list.
    //public void removeAll();//clears the entire link list.
    public Object get(int index);// gets the value of an item at given location
    //may throw an exception if the index is out of bounds with the list. 
    public LinkedString concat(LinkedString str);
    public LinkedString substring(int beginIndex, int endIndex);
    public char charAt(int index);
}
