import java.security.NoSuchAlgorithmException;


public class BlockChain {

    public Node first; //first node in blockchain
    public Node last;   //last node in blockchain

    //class of Node
    public static class Node{
        public Block element;
        public Node next;
        //constructor of Node, containing a block and a pointer to next
        public Node(Block element, Node next){
            this.element = element;
            this.next = next;
        }
    }

   //constructor of BlockChain, setting next to null because there is only one block present
   public BlockChain(int initial) throws NoSuchAlgorithmException{
        this.first = new Node(new Block(0, initial, null), null);
        this.last = first;
    }
  
   //returns a Block that contains the nonce and hash
    public Block mine(int amount) throws NoSuchAlgorithmException{
        Block blk = new Block(last.element.num + 1, amount, last.element.hash);
        return new Block(last.element.num + 1, amount, last.element.hash, blk.getNonce());
    }
    
    //returns how many blocks there are in the blockchain
    public int getSize(){
        return last.element.getNum() + 1;
    }
    
    //adds a given block to the back of the blockchain
    public void append(Block blk) throws NoSuchAlgorithmException{
        if (isValidBlockChain()){
            Node temp = new Node(blk, null);
            this.last.next = temp;
            this.last = temp;
        } 
    }
    
    //removes the last block in the blockchain--returns false if it can't
    public boolean removeLast(){
        if (last.element.getNum() == 0){
            return false;
        }else{
            Node temp = first;
            while (temp.next != last){
                temp = temp.next;
            }
            temp.next = null;
            last = temp;
            return true;
        }
    }
    
    //gets the hash of the last block
    public Hash getHash(){
        return last.element.getHash();
    }
    
    //checks that aliceAccount and bobAccount are never negative
    public boolean isValidBlockChain(){
        int aliceAccount = first.element.getAmount();
        int bobAccount = 0;
        Node temp = first.next;
        while(temp != null){
            if(aliceAccount + temp.element.getAmount() < 0){
                return false;
            }
            else if(bobAccount - temp.element.getAmount() < 0){
                return false;
            }
            else if(!temp.element.getHash().isValid()){
                return false;
            }
            else{
                aliceAccount += temp.element.getAmount();
                bobAccount -= temp.element.getAmount();
                temp = temp.next;
            }
        }
        return true;
    }
    
    //prints how much alice and bob have
    public void printBalances(){
        int aliceAccount = first.element.getAmount();
        int bobAccount = 0;
        Node temp = first.next;
        while(temp != null){
            aliceAccount += temp.element.getAmount();
            temp = temp.next;
        }
        bobAccount = first.element.amount - aliceAccount;
        System.out.println("Alice: " + aliceAccount + ", Bob: " + bobAccount);
    }
    
    //returns a string representation of the entire blockchain
    public String toString(){
        String str = "";
        Node temp = first;
        int count = 0;
        while(count < this.getSize()){
            str = str + temp.element.toString() + "\n";
            temp = temp.next;
            count++;
        }
        return str;
    }
}
