/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introductiontoarrays;

import apcscvm.CVMProgram;
import apcscvm.DefaultControl;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DSTIGANT
 */
public class IntroductionToArrays
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
//        arrayBasicsDemo();
//        runNameAgeFavoriteColorTableWithArrays();
        runBarGraphBasicTest();
        //runSinBarGraph();
        //runWarAndPeaceLetterFrequency();
        //runWarAndPeaceWordLengthFrequency();
        //runDiceDistribution();
    }
    
    public static void arrayBasicsDemo()
    {
        // an array is a group of values with the same basic name and each value has its own id number
        // think of it like declaring a bunch of variables all at once
        
        // an array variable is declared similarly to non-array variables.  
        // the type is whatever type of thing is to be contained in the array plus []:
        int [] intArray;        // a variable to hold a bunch of ints
        double [] dblArray;     // a variable to hold a bunch of doubles
        boolean [] boolArray;   // a variable to hold a bunch of booleans
        String [] strArray;     // a variable to hold a bunch of Strings
        
        // there are two ways to create/initialize an array:
        
        // static - explicitly list out the values to be contained:
        int [] jenny = {8, 6, 7, 5, 3, 0, 9 };
        String [] names = { "David", "Stephanie", "Megan" };
        
        //dynamically - use new and indicate how many spaces to set aside.
        //each space will be initialized to the default value for the type (0, 0.0, false, null):
        intArray = new int[5];      // creates an array which can hold 5 ints (currently all are set to 0)
        strArray = new String[4];   // creates an array which can hold 4 Strings (currently all are set to null)
        
        // if you create the array dynamically, none of the entries have been initialized.
        // think of each entry as a different variable.  They all have the same "family" name,
        // but each has a different number (starting with 0).  You can manipulate individual entries:
        intArray[0] = 42;
        intArray[1] = 83;
        intArray[2] = 0;
        intArray[3] = 5 + intArray[0]*intArray[1];
        
        // the index can be any expression that results in a (non-negative) int:
        intArray[2 + 2] = intArray[3] - intArray[1];
        
        // and the index should be less than the length of the array:
        // intArray[5] = 7;         // this line causes an error... there are only 5 entries in intArray
                                    // numbered 0 ... 4.
        // intArray[-1] = 7;        // this line causes an error because the index is less than 0
        
        // for loops are good for manipulating arrays.  Because the index can be ANY expression
        // that results in an int, you can use a variable to choose which entry/variable you're working with/on:
        // Also, the length of the array is stored in the length field of the array:
//        for ( int i = 0; i < intArray.length; i++ )
//        {
//            System.out.println( "intArray[" + i + "] = " + intArray[i] );
//        }
        
        // *****************
        // EXERCISE IN CLASS
        // *****************
        // write a for loop to initialize the ith element of strArray to be "string<i>"
        // for example, strArray[0] should be "string0"
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = "string" + i;
        }
        
        // remember that the individual entries have the properties of a non-array variable of that type
        // that is, the elements of strArray, for example, are Strings.  Anything you can do with a normal
        // String is available via strArray[i], and individual elements of an int array can be used as int variables:
        for ( int i = 0; i < intArray.length; i++ )
        {
            intArray[i]++;
        }
        
//        for ( int i = 0; i < intArray.length; i++ )
//        {
//            System.out.println( "intArray[" + i + "] = " + intArray[i] );
//        }
        
        // *****************
        // EXERCISE IN CLASS
        // *****************
        
        // write a nested for loop which will print out all the strings in strArray in reverse order in reverse
        // ie the output should be 
        //
        // 3gnirts
        // 2gnirts
        // 1gnirts
        // 0gnirts
        
        
        for (int i = strArray.length - 1; i >= 0; i--) {
            String temp = "";
            for (int j = strArray[i].length() - 1 ; j >=0; j-- )
                temp += strArray[i].charAt(j);
//            System.out.println(temp);
        }
        
        
        // *****************
        // EXERCISE IN CLASS
        // *****************
        
        // write a for loop which appends "Dave" to the end of each of the Strings in strArray
        for (String e : strArray)
            e += "Dave";
        // and then a for loop to print out the Strings in strArray to see if it worked
        for (String e : strArray)
            System.out.println(e);
    }
    
    public static void runNameAgeFavoriteColorTableWithArrays()
    {
        Scanner sc = new Scanner(System.in);
        // This program is just like the table with three rows
        // but now you need to prompt the user for how many family members
        // they would like to include in the table.
        
        // Since you no longer know how many family members, you can't just
        // use 3 variables to store the names (or ages or favorite colors).
        // You'll need arrays.
        
        // prompt the user for how many family members and read in their answer
        // from the keyboard
        System.out.println("How many family members?");
        int peopleNumber = sc.nextInt();
        
        // create three arrays to hold the names (Strings), ages (ints), and favorite colors (Strings)
        String[] names = new String[peopleNumber];
        int[] ages = new int[peopleNumber];
        String[] colors = new String[peopleNumber];
        String t = "\t\t";
        
        // use a loop to prompt the user for each person's name, age and favorite color
        for (int i = 0; i <peopleNumber; ++i) {
            
            System.out.println( "Enter family member number " + (i+1) + "'s name:");
            names[i] = sc.next();
            
            System.out.println( "Enter " + names[i] + "'s age:");
            ages[i] = sc.nextInt();
            
            System.out.println( "Enter " + names[i] + "'s favourite color:");
            colors[i] = sc.next();
        }
        
        // print out the table headers
        System.out.println( "Name" +t+ "Age" +t+ "Favorite Color \n"
                + "=====================================================");
        // use a loop to print out the table
        for (int j = 0; j<peopleNumber; ++j) {
            System.out.println( names[j] +t+ ages[j] +t+ colors[j]);
        }
    }
    
    public static void runBarGraphBasicTest()
    {
        // declare and create an array of 20 ints.  The even-indexed entries
        // should increase from left to right from 1 to 19.  The odd-indexed
        // entries should decrease from left to right from 20 to 2
        // That is the first few entries should be 1, 20, 3, 18, 5, 16 ...
        int[] bars = new int[20];
//        System.out.print("{ ");
        for (int i = 0; i < 20; i++) {
            if (i%2 == 0) 
                bars[i] = i+1;
            else bars[i] = 21 - i;
//            if (i == 19) System.out.print(evenOddArray[i]);
//            else System.out.print(evenOddArray[i] + ", ");
        }
//        System.out.println(" }");
        // declare and create an array of 20 Strings.  The strings should be
        // the numbers from 0 to 19 ("0", "1", etc)
        String[] labels = new String[20];
        for (int i = 0; i < 20; i++) 
            labels[i] = Integer.toString(i);
        // uncomment these lines when you have done everything above
        BarGraph bg = new BarGraph( bars, labels );
        new CVMProgram( "Bar Graph Basic Test", 800, 600, new DefaultControl<>(), new BarGraphView(), bg ).start();
        
        // uncomment this line when you have done the cummulative exercise        
        //runCummulative( "Bar Graph Basic Test", bg );
                
    }
    
    public static void runSinBarGraph()
    {
        // create an array of 50 ints.  all of them should be 1.
        
        
        // create an array of 50 Strings.  All of them should be "";
        
        
        // uncomment when you have done the above
        //BarGraph bg = new BarGraph( bars, labels );
        //new CVMProgram( "Sine Wave", 800, 600, new SineWaveBarGraphController(), new BarGraphView(), bg ).start();
        
        // uncomment if you have done the cummulative bonus exercise
        //runCummulative( "Sine Wave", bg );
    }
    
    public static void runWarAndPeaceLetterFrequency() 
    {
        try
        {
            // open an input stream to the war and peace file
            Scanner wap = new Scanner( new File( "War and Peace.txt" ) );
            
            // create an array of 26 ints.  Leave each one set to 0
            
            // use a for loop to read words from WAP
            for ( ; wap.hasNext(); )
            {
                // get the next word from the file
                
                // traverse the letters in the word.  If you see an 'a' or an 'A'
                // increase the first entry in letterFreqs by 1.  If you see a 'b' or a 'B'
                // increase the second entry etc.
                // Hint:  You only need a couple of lines to do this.  You can subtract characters
                // to get the index of the entry that you need to increase.  
                // For example 'D' - 'A' = 3
                // You DO need to check if the character is a letter and whether it's upper or lower case
                // (there are functions in the Character class that accomplish these tasks)
                
            }
            
            // declare and create and initialize an array of 26 Strings.  The first entry should be "A"
            // the second should be "B" etc.
            
            
            // uncomment the block below when you have done everything above
            /*
            BarGraph bg = new BarGraph( letterFreqs, labels );
            
            new CVMProgram( "War and Peace Letter Frequencies", 800, 600,
                    new DefaultControl<>(),
                    new BarGraphView(),
                    bg
            ).start();
            */
            
            // uncomment the line below when you have done the cummulative exercise
            // runCummulative( "War and Peace Letter Frequencies", bg );
        } 
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(IntroductionToArrays.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void runWarAndPeaceWordLengthFrequency()
    {
        try
        {
            // open an input stream to the war and peace file
            Scanner wap = new Scanner( new File( "War and Peace.txt" ) );
            
            // find the length of the longest word in the file
            // Hint: this is an accumulator style for loop
            
            // declare and create an array to hold frequencies of word lengths
            // it should have an entry for every possible word length in the file
            // (1 ... maxWordLength)
            
            // create a new scanner so you can re-scan the file
            
            // run through all the words again, counting how many of each length word there are
            // That is, at the end of this loop wordLengthFreqs[0] should contain the number
            // of words that had length 1, wordLengthFreqs[1] should contains the number
            // of words that had length 2 etc.
            
            // create an array of Strings to label your bars (the first entry should be "1",
            // the second should be "2" etc.)

            // uncomment the block below when you have done everything above
            /*
            BarGraph bg = new BarGraph( wordLengthFreqs, labels );
            new CVMProgram( "War and Peace Letter Frequencies", 800, 600,
                    new DefaultControl<>(),
                    new BarGraphView(),
                    bg
            ).start();
            */
            
            // uncomment if you have done the cummulative bonus exercise
            //runCummulative( "War and Peace Letter Frequencies", bg );
        } 
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(IntroductionToArrays.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void runDiceDistribution()
    {
        // create an array of ints with 16 entries.
        
        // roll 3 dice 10000 times.  Use the frequencies array to keep track of how often
        // each sum (3 - 18) is rolled.
        // To roll a die, use (int)(Math.random() * 6 + 1)
        
        
        // create an array of 16 Strings to label the graph. ("3" ... "18")
        
        
        // uncomment the lines below when you have done everything above
        //BarGraph bg = new BarGraph( rollFreqs, labels );
        //new CVMProgram( "3 Dice Sum Frequencies", 800, 600, new DefaultControl(), new BarGraphView(), bg ).start();
        
        // uncomment if you have done the cummulative exercise
        //runCummulative( "3 Dice Sum Frequencies", bg );
    }
    
    public static void runCummulative( String s, BarGraph bg )
    {
        new CVMProgram( "Cummulative for " + s, 800, 600, new DefaultControl<>(), new BarGraphCummulativeView(), bg ).start();
    }
}
