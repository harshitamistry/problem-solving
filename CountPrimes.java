/* 204 - Count the number of prime numbers less than a non-negative number, n */

class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n];
        
        // initalize everything as prime 
        for(int i=0;i<n-2;i++){
            notPrime[i] = false;
        }      
        
        // mark multiples of i as non prime
        for(int i=2;i<(n/2+1);i++){
            for(int j=2;i*j<=n;j++){
                notPrime[(i*j)-2] = true;
            }
        }  
              
        // get the final count
        for(int i=0;i<n-2;i++){
            if(notPrime[i] == false){
                count++;
            }
        }
        return count;
    }
}