import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class Block {
    public int num; 
    public int amount; 
    public Hash prevHash; 
    public long nonce;
    public Hash hash;

    //constructor of block without a nonce
    //mines for the hash with this information
    public Block (int num, int amount, Hash prevHash) throws NoSuchAlgorithmException {
        this.num = num;
        this.amount = amount;
        this.prevHash = prevHash;

        MessageDigest md = MessageDigest.getInstance("sha-256");
        long tempNonce = 0; //nonce being tested
        Hash tempHash =  new Hash(null); //hash being tested

        byte[] num_arr = ByteBuffer.allocate(4).putInt(num).array();
        byte[] amount_arr = ByteBuffer.allocate(4).putInt(amount).array();
        
        while(!tempHash.isValid()){ 
            byte[] nonce_arr = ByteBuffer.allocate(8).putLong(tempNonce).array();
            if(this.prevHash == null){ //check if there exists a previous hash
                byte[] Hash_arr = new byte[num_arr.length + amount_arr.length + nonce_arr.length];
                System.arraycopy(num_arr, 0, Hash_arr, 0, num_arr.length);
                System.arraycopy(amount_arr, 0, Hash_arr, num_arr.length, amount_arr.length);
                System.arraycopy(nonce_arr, 0, Hash_arr, num_arr.length + amount_arr.length, nonce_arr.length);
                md.update(Hash_arr);
            }
            else {//if there exists a previous hash
                byte[] prevHash_arr = prevHash.getData(); //hash contains a byte[] of data
                byte[] Hash_arr = new byte[num_arr.length + amount_arr.length + prevHash_arr.length+ nonce_arr.length];
                System.arraycopy(num_arr, 0, Hash_arr, 0, num_arr.length);
                System.arraycopy(amount_arr, 0, Hash_arr, num_arr.length, amount_arr.length);
                System.arraycopy(prevHash_arr, 0, Hash_arr, num_arr.length + amount_arr.length , prevHash_arr.length);
                System.arraycopy(nonce_arr, 0, Hash_arr, num_arr.length + amount_arr.length + prevHash_arr.length, nonce_arr.length);
                md.update(Hash_arr);
            }
            tempHash.data = md.digest();
            tempNonce++;
        }
        this.nonce = tempNonce - 1;
        this.hash = tempHash;

    }

    //constructor of block with a nonce
    //mines for the hash with this information
    public Block(int num, int amount, Hash prevHash, long nonce) throws NoSuchAlgorithmException{
        this.num = num;
        this.amount = amount;
        this.prevHash = prevHash;
        this.nonce = nonce;

        MessageDigest md = MessageDigest.getInstance("sha-256");
        byte[] num_arr = ByteBuffer.allocate(4).putInt(num).array();
        byte[] amount_arr = ByteBuffer.allocate(4).putInt(amount).array();
        byte[] prevHash_arr = prevHash.getData(); //hash contains a byte[] of data
        byte[] nonce_arr = ByteBuffer.allocate(8).putLong(nonce).array();
        
        if(this.prevHash == null){ //check if there exists a previous hash
            byte[] Hash_arr = new byte[num_arr.length + amount_arr.length + nonce_arr.length];
            System.arraycopy(num_arr, 0, Hash_arr, 0, num_arr.length);
            System.arraycopy(amount_arr, 0, Hash_arr, num_arr.length, amount_arr.length);
            System.arraycopy(nonce_arr, 0, Hash_arr, num_arr.length + amount_arr.length, nonce_arr.length);
            md.update(Hash_arr);
        }
        else{ //if there exists a previous hash
            byte[] Hash_arr = new byte[num_arr.length + amount_arr.length + prevHash_arr.length+ nonce_arr.length];
            System.arraycopy(num_arr, 0, Hash_arr, 0, num_arr.length);
            System.arraycopy(amount_arr, 0, Hash_arr, num_arr.length, amount_arr.length);
            System.arraycopy(prevHash_arr, 0, Hash_arr, num_arr.length + amount_arr.length , prevHash_arr.length);
            System.arraycopy(nonce_arr, 0, Hash_arr, num_arr.length + amount_arr.length + prevHash_arr.length, nonce_arr.length);
            md.update(Hash_arr);
        }
        this.hash = new Hash(md.digest());
    }

    //returns the block number
    public int getNum(){
        return this.num;
    }

    //returns the transaction amount
    public int getAmount(){
        return this.amount;
    }

    //returns the nonce of the block
    public long getNonce(){
        return this.nonce;
    }

    //returns the hash of the previous block
    public Hash getPrevHash(){
        return this.prevHash;
    }

    //returns the hash of the current block
    public Hash getHash(){
        return this.hash;
    }

    //returns a string containing all the information stored in a block
    public String toString(){
        String str = "Block " + num + " (Amount: " + amount + ", Nonce: " + nonce + ", prevHash " + prevHash + ", hash: " + hash + ")";
        return str;
    }
}
