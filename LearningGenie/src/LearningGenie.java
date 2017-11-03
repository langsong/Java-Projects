import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * LearningGenie is the engine for the guessing game.
 */
public class LearningGenie {
    public static void main(String[] args) throws IOException{
        
        File file = new File("src/exampleTest.txt");
        DecisionTree tree = new DecisionTree(file);
        introMessage(tree);
        FileWriter fw = new FileWriter(file, false);
        boolean cont = true;
        
        while(cont) {
            System.out.println();
            System.out.println("Think of an object!");
            Scanner in = new Scanner(System.in);
            tree.guess(in);
            cont = continuePlaying(in);
        }
        tree.write(fw);
        fw.close();
    }
    
    /*
     * continuePlaying returns true if the user replies yes to "Do you want to contine?"
     * and false if the user replies no. It is case insensitive.
     */
    private static boolean continuePlaying(Scanner in) {
        System.out.print("Do you want to continue? ");
        String response = in.next().toLowerCase();
        in.nextLine();
        while(true) {
            if(response.equals("no")) {
                return false;
            } else if (response.equals("yes")) {
                return true;
            } else {
                System.out.println("Valid responses are Yes or No.");
                response = in.next().toLowerCase();
            }
        }
    }

    /*
     * introMessage prints out the preliminary information the user should know about the game.
     */
    private static void introMessage(DecisionTree tree) {
        System.out.println("I am the learning genie!");
        System.out.println("I can figure out whatever you are thinking of by asking questions.");
        int count = tree.countObjects();
        if(count == 1) {
            System.out.println("I know 1 thing!");
        } else { //count is greater than 1
            System.out.println("I know " + count + " things!");
        }
    }
}
