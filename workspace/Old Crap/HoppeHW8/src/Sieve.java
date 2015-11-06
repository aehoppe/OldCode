import java.util.ArrayList;

/**
 * This class implements Eratosthenes' Sieve algorithm for finding prime numbers
 * @author Alexander Hoppe
 * @version 12/3/14
 */
public class Sieve {
    
    /**
     * This method returns all of the prime numbers below num as an ArrayList of Integers 
     * @param num The max number to test if prime
     * @return All primes under num as an ArrayList<Integer>
     */
    public static ArrayList<Integer> findPrimes(int num){
        if(num < 2) throw new IllegalArgumentException("Input must be greater than 1");
        ArrayList<Integer> raw = new ArrayList<Integer>();
        fill(raw, 2, num);                   //fills the raw list from 2 to max
        ArrayList<Integer> primes = new ArrayList<Integer>();
        removePrimeMultiples(Math.sqrt(num), raw, primes);  //recursive method to do the first part of the algorithm     
        for(Integer i: raw)
            primes.add(i); //add the rest of the numbers left in raw to the result
        return primes;
    }
    
    /**
     * This method is a helper method to findPrimes, filling an ArrayList with 
     * all of the Integer values from min to max, inclusive
     * @param a The ArrayList<Integer> to be filled
     * @param min The first integer to be added
     * @param max The maximum integer value to be added
     * @return all the integers from min to max as an ArrayList
     */
    private static ArrayList<Integer> fill(ArrayList<Integer> a, int min, int max){
        for (int i = min; i <= max; i++){
            a.add(i); //fill the list with integers
        }
        return a;
    }
    
    /**
     * This recursive method adds a prime to the primes ArrayList, removes all 
     * of its multiples from the raw ArrayList, then calls itself on the next 
     * prime, until it reaches the base case of the prime being greater than or 
     * equal to the double max.
     * @param max The max value to be tested
     * @param raw The input ArrayList of Integers
     * @param primes The output ArrayList of Integers
     */
    private static void removePrimeMultiples(double max, ArrayList<Integer> raw,
            ArrayList<Integer> primes){
        int prime = raw.get(0);
        if(prime - max > 0.0000001){
            return; //base case, will be the square root in the method call
        }
        primes.add(raw.remove(0)); //add the first value
        for(int i = 0; i < raw.size(); i++){
            if (raw.get(i) % prime == 0){ //remove all multiples of that value
                raw.remove(i);
                i--; //step back, b/c that's how ArrayLists roll
            }
        }
        removePrimeMultiples(max, raw, primes); //call on the next prime
    }
}
