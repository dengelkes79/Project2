/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import static project2.Project2.*;


/**
 *
 * @author denge
 */
public class LinkedString <T> implements LinkedStringInterface <T> {

    private class Node <T> {

        protected T data; // the value of the data itself
        protected Node <T> next;// // next current in the list
        protected Node <T> previous;  // link to previous current

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node <T> next) {
            this.next = next;
        }

        public Node  getPrevious() {
            return previous;
        }

        public void setPrevious(Node <T> previous) {
            this.previous = previous;
        }

        public Node(T value) {
            this.data = value;
            this.next = null;
            this.previous = null;
        }

        public Node(T value, Node newNext , Node newPrevious) {
            this.data = value;
            this.next = newNext;
            this.previous = newPrevious;
        }

        @Override
        public String toString() {

            return data.toString();
        }

    }

    private Node <T> last; // tail of list
    private Node <T> first; //head of list
    private int counter; // keep track number of elements in the linked list. 

    /**
     * constructors to initialize linklist counter to zero
     */
    public LinkedString() {
        counter = 0;
    }

    public LinkedString(char[] value)
    {
        for (int index = 0; index<value.length;index++)
        {this.addToEnd(value[index]);
        }
    }

    public LinkedString(String original){
        char [] tempArray = original.toCharArray();
        for (int index = 0; index <tempArray.length;index++)
        {this.addToEnd(tempArray[index]);
        // println("add to node "+tempArray[index]);
        }
       // counter=original.length();

    }
    public char charAt(int index)throws LinkedStringException{
        if (index <0 || index>length())
        {thowExeption(index);}
      Node <T> current = this.find(index);

     // char[] tempArray = toArray();
      return (char) current.data;
    }

    public LinkedString<T> concat(LinkedString str) throws LinkedStringException
    {
        if(isEmpty())
        {
            throw new LinkedStringException("List is Empty");
        }

        Node <T> current = first;
        String tempString1="";

        while (current!=null)
        {
            tempString1 = tempString1+current.data;
            current=current.next;
        }
        current = new Node(tempString1);

        Node <T> newNode = new Node(str);
         tempString1="";
        while(newNode!=null)
        {
            tempString1 = tempString1 +newNode.data;
            newNode=newNode.next;
        }
        newNode = new Node(tempString1);

        LinkedString<T> tempString = new LinkedString(current.toString() + newNode.toString());
               
        return tempString;
    }

    public LinkedString<T> substring(int beginIndex, int endIndex) throws LinkedStringException{
        if(isEmpty())
        {
            throw new LinkedStringException("Current List is empty.");

        }

        if (beginIndex<0)
        {
            thowExeption(beginIndex);
        }
        if (endIndex>length())
        {
            thowExeption(endIndex);
        }
        var current = this.find(beginIndex);
        String tempString2="";
        int tCounter=beginIndex;
        while (current!=null&&tCounter<endIndex+1)
        {
            tempString2 = tempString2 + current.data;
            current=current.next;
            tCounter++;
        }
        LinkedString str = new LinkedString(tempString2);
        return str;
    }

    /**
     * Puts value at the start of the list
     *
     * @param value Value to be added at the beginning of the list.
     */
        private void addToFirst(char value) {

               Node <T> current = new Node(value);
        if (isEmpty()) {
            first = last = current;
            first.previous=null;
            last.previous=null;
        } else {
            first.previous = current;
            current.next = first;
            first = current;
            first.previous = null;
        }
        
        counter++;
        
    
    }
    private void addToFirst(String value) {

        Node <T> current = new Node(value);
        if (isEmpty()) {
            first = last = current;
            first.previous=null;
            last.previous=null;
        } else {
            first.previous = current;
            current.next = first;
            first = current;
            first.previous = null;
        }

        counter++;


    }
    
    /**
     * Appends value to the end of the list
     *
     * @param value Value to be added at the end of the list.
     */
    private void addToEnd(char value) {

        Node node = new Node(value);
        if (isEmpty()) {
            first = last = node;
             first.previous=null;
             last.previous=null;
        } else {
            last.next = node;
            node.previous = last;
            last = node;
            last.next=null;
        }
        counter++;



    }
private void thowExeption(int index)
{
    if (index<0)
    {
        throw new LinkedStringException("Beginning Index can not be less than 0. Beginning index provided " + index);
    }
    if (index>length())
    {
        throw new LinkedStringException("Ending Index can not be greater than " + length() +". Ending index provided " + index);
    }

}

    /**
     * Searches the entire list to check to see if value is in the list.
     *
     * @param value The data is be compared with each item in the list.
     * @return Returns true if value of the data exists in the list. Returns
     * false if the value provided does not exists in the list.
     *
     */
    @Override

    public boolean contains(T value) {

        Node <T> current = first;
        boolean isFound = true;
        /*try {
            indexOf(value);
        } catch (LinkedStringException ex) {
            isFound = false;
        }*/

//        while (current != null) {
//            if (current.data == value) {
//                isFound = true;
//                return isFound;
//            }
//            current = current.next;
//        }
        return isFound;
    }


       
    private Node getPrevious(Node <T> node) {
        var current = first;
        while (current != null) {
            if (current.next == node) {
                return current;
            } // end if statement             
            current = current.next;
        } // end of while loop

        return null;

    }

    /**
     * Method converts the list to an Array. 
     * @return Returns an char Array of values
     */
    @Override
     public char[] toArray() throws LinkedStringException {
        //  converts linklist to an array
       
        int index;
        var current = first;

        if (isEmpty()) {
            throw new LinkedStringException("List is empty");

        }
        String tempString = current.getData().toString();
        char[] array = new char[tempString.length()];
        array = tempString.toCharArray();
        
        

        return array;
    }
    /**
     * Prints out the items of the linked list.
     */
    public void printList() {
        println("\n-------------------Printing in the Forward direction------------------");
        var current = first;
        println("Number of Items that are in the list: " + length());
        //println("first -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" ");
            current = current.next;

        }
        println();
          println("\n-------------------Printing in the reverse direction------------------");
         current = last;
        println("Number of Items that are in the list: " + length());
        //println("first -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" ");
            current = current.previous;

        }
        println();
    }
    public String toString(String direction){
        String printedList="";
     
     if (direction.equalsIgnoreCase("forward")){
         var current=first;
     while(current!=null)
     {
     printedList = printedList + current.toString() + " ";
     current = current.next;
     }}
     
        if (direction.equalsIgnoreCase("reverse")){
            var current=last;
     while(current!=null)
     {
     printedList = printedList + current.toString() + " ";
     current = current.previous;
     }}
     
     
return printedList;
        
    
    }
    
   
    
    @Override
    public String toString(){
     String printedList="";
     var current=first;
     while(current!=null)
     {
     printedList = printedList + current.toString();
     current = current.next;
     }
     
return printedList;
}

    /**
     *
     * @return Returns True if linked list is empty
     */
    @Override
    public boolean isEmpty() {

// returns true if empty and false if not empty
        return counter == 0;

    }




    /**
     * Returns number of items in the list. For example if the list contains 3 2
     * 1 0 the return value is 4
     *
     * @return Size of the list.
     */
    @Override
    public int length() throws LinkedStringException {
if (isEmpty()){
    throw new LinkedStringException("List is empty.");
}


        return (counter);
    }

    /**
     * Clears out entire content of the array.
     */

    public void removeAll() {
        if (isEmpty() == false) {
            first = last = null;
            counter = 0;
        }
    }//clears the entire link list. 

    /**
     * @throws LinkedStringException Throws an exception if index provided is Out of
     * Bounds or out of range.
     * @param index Where in the list to retrieve the data.
     * @return Returns the data store at a given index.
     *
     */
    @Override
    public Object get(int index) throws LinkedStringException {
        if (index < 0 || index >= counter) {
            thowExeption(index);
        }
      var current = find(index);
      
        return current.data;
    }

    /**
     * Returns the first value of the linked list.
     *
     * @return
     */

    private Node find(int index) {
        var current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    /**
     * Compares the Values of two list. 
     * 
     * @param List Second list to be compared. 
     * @return
     * Returns true is both lists are the sames size all and values are equal to 
     * each other.  If one sets of data are not equal then method will return false.
     */
    public boolean equals (LinkedString List) throws LinkedStringException
    {
        if (this.isEmpty()&&List.isEmpty())
        {
        throw new LinkedStringException("Unable to Compare due to both Lists being empty.");
        }
        if(this.isEmpty())
        {
      
        throw new LinkedStringException("Unable to Compare due to an first list being empty.");
        }
       if (List.isEmpty())
       {
           throw new LinkedStringException("Unable to Compare due to an Second list being empty.");}
        
        println("Comparing two link lists.");
        var current = first;
        var tempCurrent = List.first;
      
        if (this.counter != List.counter)
        {
        return false;
        }
        while (current!=null){
             println(current + " " + tempCurrent );

          if (current.data != tempCurrent.data)
         {   
             return false;}
             current = current.next;
             tempCurrent=tempCurrent.next;
         } 
    return true;
    }

}
