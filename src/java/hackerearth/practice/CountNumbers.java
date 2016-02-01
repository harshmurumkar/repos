/**
 * 
 */
package hackerearth.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @author hmurumkar
 *
 *
 *Input
     First line: K and T. 
     Second line: K primes.
     Next T lines, each contain Ai, Bi. 

  Output
     Print T lines, denoting the answer to each of the T queries.

  Constraints
     1 ≤ K ≤ 10 
     1 ≤ T ≤ 100 
     1 ≤ A ≤ B ≤ 10 9 
     Each prime ≤ 10 7
 */
public class CountNumbers
{
    final static double MAX_VALUE_A_OR_B = Math.pow(10, 9);
    final static double MAX_VALUE_PRIME = Math.pow(10, 7);
    
    private static byte numberOfPrimes = 0;
    private static byte numberOfTests = 0;
    
    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        validateFirstRow(reader.readLine());
        String[] primes = validateSecondRow(numberOfPrimes, reader.readLine());
        
        String testLine = null;
        int count = 0;
        //while((testLine = reader.readLine()) != null)
        {
            count = count + getPrimeCount(primes, reader.readLine());
        }
        System.out.println(count);
    }

    private static String[] validateSecondRow(byte k, String secondLine) throws Exception
    {
        String[] kAndT = new String[k];
        String temp;
        try
        {
            StringTokenizer token = new StringTokenizer(secondLine, " ");
            
            if( token.countTokens() != k)
                throw new Exception(" Numer of Prime should be match with first row's k part");
            for (int i = 0; i < kAndT.length; i++)
            {
                temp = token.nextToken();
                if( (Long.parseLong(temp) > MAX_VALUE_PRIME))
                    throw new NumberFormatException("Invalid Primes");
                kAndT[i] = temp;
            }
        }
        catch (NumberFormatException e)
        {
            throw new Exception("Invalid Input for first line K and T should be specified in predefined manner");
        }
        return kAndT;
    }

    private static void validateFirstRow(String firstRow) throws Exception
    {
        try
        {
            StringTokenizer token = new StringTokenizer(firstRow, " ");
            numberOfPrimes = Byte.parseByte(token.nextToken());
            numberOfTests = Byte.parseByte(token.nextToken());
            
            if( !(numberOfPrimes >= 1 && numberOfPrimes <= 10) || !(numberOfTests >= 1 && numberOfTests <= 100))
                throw new NumberFormatException("Invalid Input");
        }
        catch (NumberFormatException e)
        {
            throw new Exception("Invalid Input for first line K and T should be specified in predefined manner");
        }
    }
    
    private static int getPrimeCount(String[] primes, String testLine) throws Exception
    {
        try
        {
            String[] aANDb = testLine.split(" ");
            int count = 0;
            long multiply = 1;
            
            for (String string : primes)
            {
                multiply = multiply * Long.parseLong(string);
            }
            
            for (long i = Long.parseLong(aANDb[0]); i <= Long.parseLong(aANDb[1]); i++)
            {
                for (String string : primes)
                {
                    if(i % multiply == 0)
                        count++;
                    else if(i % (Long.parseLong(string)) == 0)
                        count++;
                }
            }
            
            return count;
        }
        catch (NumberFormatException e)
        {
            throw new Exception(e.getLocalizedMessage() + " Exception while calculating prime count");
        }
    }
}
