import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Manages the Decision Nodes.
 */
public class DecisionTree {
    private DecisionNode root;

    //Constructs a decision tree with an initial guess node containing Dog
    public DecisionTree(){
        this.root = new GuessNode("Dog"); 
    }

    //Constructs a decision tree with an initial guess node containing Dog
    public DecisionTree(File file) throws IOException {
        Scanner in = new Scanner(file);
        root = decisionTreeH(in);
        in.close();
    }

    //Implementing DecisionTreeHelper
    public static DecisionNode decisionTreeH(Scanner in){
        String newline;
        DecisionNode cur = null;
        if(in.hasNext()){
            newline = in.nextLine();
            if(!newline.startsWith("#")){
                cur = new GuessNode(newline); //Base Case
            }
            else{
                cur = new QuestionNode(newline.substring(1),
                        decisionTreeH(in),
                        decisionTreeH(in));  		//Recursive Call for decisionTreeH

            }
        }
        return cur;
    }

    //Returns a count of the number of objects this decision tree records
    public int countObjects(){
        return root.countObjects();
    }

    //Performs the guessing game starting or modify the decision tree when new information provided 
    public void guess(Scanner in){
        root.guess(in);
    }

    //Writes this decision tree in the serialized format
    public void write(FileWriter out) throws IOException {
        root.write(out);
    }
}
