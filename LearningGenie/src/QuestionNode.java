import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * QuestionNode is a DecisioinNode that provides a question(value) and right and wrong GuessNodes (answers)
 * which the user will use to reach their solution.
 */
public class QuestionNode implements DecisionNode {
    private String value;
    public DecisionNode right;
    public DecisionNode wrong;

    /*
     * QuestionNode constructor
     */
    public QuestionNode(String val, DecisionNode right, DecisionNode wrong){
        this.value = val;
        this.right = right;
        this.wrong = wrong;
    }

    /*
     * countObjects returns the sum of all the counted objects of it's children,
     * individually a QuestionNode is not a Guess so it is not a part of the count.
     */
    public int countObjects() {
        return right.countObjects() + wrong.countObjects();
    }

    /*
     * guess prints out the question of this QuestionNode (value) and then makes guess calls on
     * the right and wrong DecisionNode children of the current node. 
     */
    public DecisionNode guess(Scanner in) {
        System.out.print(value + " ");
        String res = in.next().toLowerCase();
        while ((!res.equals("yes")) && (!res.equals("no"))){
            System.out.println("Valid response is Yes or No");
            res = in.next();
        }
        if (res.equals("yes")){
            right = right.guess(in);
            return this;
        }else{
            wrong = wrong.guess(in);
            return this;
        }
    }

    /*
     * write, writes or serializes the QuestionNode question and children DecisionNodes using out.
     */
    public void write(FileWriter out) throws IOException {
        out.write("#" + value + "\n");
        right.write(out);
        wrong.write(out);
    }

}
