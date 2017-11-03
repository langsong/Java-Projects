import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Interface for the nodes of a DecisionTree (GuessNode and Question node).
 */
public interface DecisionNode {
    public int countObjects();
    public DecisionNode guess(Scanner in);
    public void write(FileWriter out) throws IOException;
}
