package hackerearth.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


class FizzBuzz
{

    public static void main(String[] args) throws Exception
    {
        /*// input reading
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestcases;
        String inputNumbers;
        
        try
        {
           numOfTestcases = Integer.parseInt(reader.readLine());    // first input which is a Test-case Number
        }
        catch (NumberFormatException e)
        {
            throw new Exception("Provided Test Case Numbers Input is incorrect, please correct...");
        }
        
        // executing actual business logic
        inputNumbers = reader.readLine();
        
        if(inputNumbers.isEmpty())
            throw new Exception("Provided numbers input is incorrect, it can't be empty");
        else
        {
            String[] numStrArr = inputNumbers.split(" ");
            for (int i = 0; numStrArr != null && i < numStrArr.length; i++)
            {
                try
                {
                    long number = Long.parseLong(numStrArr[i]);
                    for (int j = 1; j <= number; j++)
                    {
                        boolean fizz = j%3 == 0;
                        boolean buzz = j%5 == 0;
                        if( fizz && buzz )
                            System.out.println("FizzBuzz");
                        else if( fizz )
                            System.out.println("Fizz");
                        else if( buzz )
                            System.out.println("Buzz");
                        else
                            System.out.println(j);
                    }
                }
                catch (NumberFormatException e)
                {
                    throw new Exception("Provided Input is incorrect, please correct...");
                }
            } 
        }*/
        
        String a = "foo";
        String b = "foo".substring(0, 3);
        String c = b.intern();
        
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        if (a.equals(b)) {
            if (a == b) {
                System.out.println("1");
            } else if (a == c) {
                System.out.println("2");
            } else {
                System.out.println("3");
            }
        } else {
            System.out.println("4");
        }
    }
}
