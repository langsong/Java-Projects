import java.util.Arrays;


public class Hash {
    public byte[] data;
    
    //constructor for hash takes in a byte array
    public Hash(byte[] data){
        this.data = data;
    }
    
    //getData returns the data of the Hash object
    public byte[] getData(){
        return this.data;
    }

    //isValid returns true if the first three bytes of the Hash are zero
    public boolean isValid(){
        if (this.data == null){
            return false;
        }
        for(int i = 0; i < 3; i++){
            if (this.data[i] != 0){
                return false;
            }
        }
        return true;
    }

    //toString constructs a string containing the Hash
    public String toString(){
        String str = "";
        for (int i = 0; i < this.data.length; i++){
            str = str + String.format("%02x", Byte.toUnsignedInt(this.data[i]));  
        }
        return str;
    }

    //equals checks if a given Object is equal to the Hash
    public boolean equals(Object other){
        if (other instanceof Hash){
            Hash o = (Hash) other;
            return Arrays.equals(o.data, this.data);
        } else {
            return false;
        }
    }
}
