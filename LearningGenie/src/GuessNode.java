import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * GuessNode is a Decision Node that contains a value which Learning Genie will prompt as the user's solution.
 */
public class GuessNode implements DecisionNode {
    private String value;

    /*
     * Constructor for GuessNode
     */
    public GuessNode(String val){
        this.value = val;
    }

    /*
     * countObjects is called recursively by QuestionNodes. As it is only one guess,
     * it returns one as it's own contribution to the total count.
     */
    public int countObjects() {
        return 1;
    }

    /*
     * guess returns a node after prompting the user if this GuessNode.value is their solution.
     * If the node was valid guess returns the GuessNode as it was originally, otherwise it will return a 
     * new node that has the userprovided correct solution and leading question. 
     */
    public DecisionNode guess(Scanner in) {
        System.out.print("Are you thinking of " + value + "? ");
        String res = in.next().toLowerCase();
        in.nextLine();
        while(!res.equals("yes") && !res.equals("no")){
            System.out.println("Valid responses are Yes or No.");
            res = in.nextLine();
        }
        if(res.equals("no")){ 
            System.out.println("Oh no, I was wrong!");
            System.out.print("What movie are you thinking of? ");
            String answer = in.nextLine();
            System.out.println("What is a yes/no question that distinguishes a " + value + " from a " + answer + "?");
            System.out.print("(Yes corresponds to " + value + "; No corresponds to " + answer +") ");
            String question = in.nextLine();
            System.out.println("Thanks! I'll learn from this experience!");
            return new QuestionNode(question, new GuessNode(value), new GuessNode(answer));
        } else {
            System.out.println("Excellent, thanks!");
            return this;
        }
    }

    /*
     * write, writes or serializes the GuessNode value using out.
     */
    public void write(FileWriter out) throws IOException {
        out.write(value + "\n");
    }
}
