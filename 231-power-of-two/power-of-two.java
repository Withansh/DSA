class Solution {
    public boolean isPowerOfTwo(int n) {
        //base case 
        if( n<=0){
            return false;
        }
        //continue dividing as long as number is even
        while (n %2 == 0){
            n = n/2;
        }

        //if power of two we will be left exactly with 1
        return n == 1;
    }
}        
   