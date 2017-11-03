import java.io.*;
import java.util.Scanner;


public class WordGenerator {
    Scanner sc; //declare a public global scanner so that this can be used to read the file using all methods
    int wordCount=0; //count the number of words
    int sentenceCount = 0; //count the number of sentences
	
    public WordGenerator(String fname) throws IOException{ //constructor
        sc=new Scanner(new File(fname));
    }

    public boolean hasNext(){ //checks if the file has another token next to the curson
        return sc.hasNext();
    }
	
    public String next(){ //returns the next token in the file after the cursor
        wordCount++;
        String nxt = sc.next();
        if(nxt.charAt(nxt.length()-1)=='.' || nxt.charAt(nxt.length()-1)=='!' || nxt.charAt(nxt.length()-1)=='?'){
            sentenceCount++;
        }
        return nxt;
    }
	
    public int getWordCount(){ //returns the wordcount
        return wordCount;
    }
	
    public int getSentenceCount(){ //reuturns the sentencecount
        return sentenceCount;
    }
}
