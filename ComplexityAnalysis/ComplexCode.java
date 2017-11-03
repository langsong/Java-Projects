
public class ComplexCode {

    private static final Exception IllegalArgumentException = null;

    // returns true if there is an element d_2 in the array arr such that |d_1 - d_2| < eps
    public static boolean contains(double[] arr, double eps, double d_1) {
        for(int i = 0; i < arr.length; i++) {
            if(Math.abs(d_1 - arr[i]) < eps) {
                return true;
            }
        }
        return false; 
    }

    // returns x^y (does not work for negative values of y) 
    public static int fastExp(int x, int y){
        if(y == 0){
            return 1; 
        } else {
            if(y % 2 == 0) {
                return fastExp(x*x, (y/2));
            } else {
                return x * fastExp(x*x, (y-1)/2);
            }
        }
    }

    // returns all possible pairs of elements from the input array in a new array
    public static Pair[] allPairs(int[] arr) throws Exception {
        if (arr == null) throw IllegalArgumentException; 
        Pair[] ret = new Pair[arr.length * arr.length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                ret[j + (arr.length * i)] = new Pair(arr[i], arr[j]);
            }
        }
        return ret;
    }

    // returns a single string that is the result of replicating them all n times 
    // and then concatenating them all together
    public static String concatAndReplicateAll(String[] arr, int n) throws Exception {
        if(arr == null) {
            throw IllegalArgumentException; 
        } else {
            String ret = "";
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < n; j++) {
                    ret += arr[i];
                }
            }
            return ret; 
        }
    }

    // returns an array that is the result of interleaving the first array with the second
    public static int[] interleave(int[] arr1, int[] arr2){
        int total = arr1.length + arr2.length;
        int alternating = Math.min(arr1.length, arr2.length);
        int[] ret = new int[total];
        for (int i = 0; i < alternating; i++){
            ret[2 * i] = arr1[i];
            ret[(2 * i) + 1] = arr2[i];
        }
        for (int i = alternating; i < arr1.length; i ++) {
            ret[alternating + i] = arr1[i];
        }
        for (int i = alternating; i < arr2.length; i ++) {
            ret[alternating + i] = arr2[i];
        }
        return ret; 
    }

}
