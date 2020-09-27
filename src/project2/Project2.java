/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

//import java.util.LinkedList;
//import java.util.Scanner;
import java.util.*;

/**
 *
 * @author denge
 */
public class Project2 {

    /**
     * Prints out to the console with a newline character. 
     * @param x
     */
    public static final void println(Object x) { System.out.println(x); }
    
    /**
     * Method prints a blank line. 
     */
    public static final void println() { System.out.println(); }

    /**
     * Printing out to the console. 
     * @param x data that needs to be printed out
     */
    public static final void print(Object x) { System.out.print(x); }
    public static void main(String[] args) {
                
        Scanner input = new Scanner(System.in);

        int index = 0;
        char[] data = {'S','u','p','e','r'};
        char[] data2 = {'B','o','y'};
        LinkedString <Character[]> secondCList = new LinkedString<>(data2);
        LinkedString <Character[]>  firstCList  = new LinkedString(data);
        LinkedString <String> firstSList = new LinkedString("Wonder");
        LinkedString <String> secondSList = new LinkedString("Woman");
        LinkedString <String> tempList = new LinkedString<>();
        tempList = firstSList.concat(secondCList);

        //Character newC = new Character('d');
        println("----Printing out table testing out length method--------");

        println("LinkedList Names        Contents          Length");
        println("------------------------------------------------");
        println("firstCList\t\t\t\t" +  firstCList.toString()+"\t\t\t\t"+firstCList.length());
        println("secondCList\t\t\t\t" +  secondCList.toString()+"\t\t\t\t\t"+secondCList.length());
        println("firstSList\t\t\t\t" +  firstSList.toString()+"\t\t\t\t"+firstSList.length());
        println("secondSList\t\t\t\t" +  secondSList.toString()+"\t\t\t\t"+secondSList.length());
        println("tempList(concat)\t\t" +  tempList.toString()+"\t\t\t"+tempList.length());

        println("------testing out charAt method----------");
        println("\nThe 3 character of firstCList = "+ firstCList.charAt(2));
        println("The 2 character of firstSList = "+ firstSList.charAt(1));

        println("\n----testing out conatenation method -----------");

        println("Concatenating firstCList with secondCList " + firstCList.concat(secondCList));
        println("Concatenating firstSList with secondSlist " + firstSList.concat(secondSList));
        println("Concatenating firstSList with secondCList " + firstSList.concat(secondCList));
        println("Concatenating firstClist with secondSList " + firstCList.concat(secondSList));

        println("\n---Testing out Substring Method----");
        println("Printing the 2nd to 3rd character from firstCList: "+firstCList.substring(1,2));
        println("Printing the 1st to 3rd character from firstSList: "+firstSList.substring(0,2));
        println("Printing the 2 to 7 character from tempList: "+tempList.substring(1,6));


        println("\nNow testing to see if the exception handling is working. clearing out firstCList");
        println("Is firstCList empty: " + firstCList.isEmpty());
        println();
        firstCList.removeAll();
        println("Cleared firstCList. Is firstCList empty: " + firstCList.isEmpty());
        println();
        try{
            firstCList.length();
        }

        catch (LinkedStringException ex)
        {
            println("Exception handling is working. " + ex.getMessage());
        }

        firstCList  = new LinkedString(data);
        try{
            println("Printing the 2 and 3 character from firstCList: "+firstCList.substring(1,10));
        }
        catch (LinkedStringException ex)
        {
            println("Exception handling is working. " + ex.getMessage());
        }

        try{
            println("Printing the 2 and 3 character from firstCList: "+firstCList.substring(-1,10));
        }
        catch (LinkedStringException ex)
        {
            println("Exception handling is working. " + ex.getMessage());
        }







    }
}
