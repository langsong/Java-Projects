import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class BlockChainDriver {
    public static void main(String[] args) throws NoSuchAlgorithmException{
        if(args.length!=1){ //print an error message when wrong number of arguments are given
            System.out.println("Wrong number of arguments given!");
        }
        else{
            int initialAmount = Integer.parseInt(args[0]); //takes in an arguement
            BlockChain chain = new BlockChain(initialAmount); //creates a new blockchain
            System.out.print(chain.toString());
            System.out.print("Command? ");
            Scanner in = new Scanner(System.in);
            String response = in.nextLine();
            while (!response.equals("quit")){
                //mine
                if (response.equals("mine")) {
                    System.out.print("Amount transferred? ");
                    int amount = Integer.parseInt(in.nextLine());
                    mine(chain, amount);
                }
                //append
                else if (response.equals("append")) {
                    System.out.print("Amount transferred? ");
                    int amount = Integer.parseInt(in.nextLine());
                    System.out.print("Nonce? ");
                    long nonce = Long.parseLong(in.nextLine());
                    append(chain, amount, nonce);
                }
                //remove
                else if (response.equals("remove")) {
                    remove(chain);
                }
                //check
                else if (response.equals("check")) {
                    check(chain);
                }
                //report
                else if (response.equals("report")) {
                    report(chain);
                }
                //help
                else if (response.equals("help")) {
                    help();
                }
                //if invalid input
                else{
                    System.out.println("Invalid input. Type help for acceptable input.");
                }
                System.out.println();
                System.out.print(chain.toString());
                System.out.print("Command? ");
                response = in.nextLine();
            }
        }
    }
    
    //lists all possible input
    public static void help(){
        System.out.println("Valid commands:");
        System.out.println("    mine: discovers the nonce for a given transaction");
        System.out.println("    append: appends a new block onto the end of the chain");
        System.out.println("    remove: removes the last block from the end of the chain");
        System.out.println("    check: checks that the block chain is valid");
        System.out.println("    report: reports the balances of Alice and Bob");
        System.out.println("    help: prints this list of commands");
        System.out.println("    quit: quits the program");
    }
    
    //discovers a nonce for the given amount
    public static void mine(BlockChain chain, int amount) throws NoSuchAlgorithmException{
        System.out.println("Amount = " + amount + ", Nonce = " + chain.mine(amount).getNonce());
    }
    
    //adds a block to the current blockchain
    public static void append(BlockChain chain, int amount, long nonce) throws NoSuchAlgorithmException {
        int num = chain.last.element.getNum() + 1;
        Hash prevHash = chain.last.element.getHash();
        Block blk = new Block(num, amount, prevHash, nonce);
        chain.append(blk);
    }
    
    //removes the last block in the blockchain
    public static void remove(BlockChain chain) {
        if (chain.removeLast()) {
            chain.removeLast();
        }
        else {
            System.out.println("Cannot remove last element of this list");
        }
    }
    
    //checks if the blockchain is valid
    public static void check(BlockChain chain) {
        if (chain.isValidBlockChain()) {
            System.out.println("Chain is valid!");
        }
        else {
            System.out.println("Chain is NOT valid!");
        }
    }
    
    //prints the balance of alice and bob
    public static void report(BlockChain chain){
        chain.printBalances();
    }
}