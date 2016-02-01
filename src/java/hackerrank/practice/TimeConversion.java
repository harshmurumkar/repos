package hackerrank.practice;

import java.util.Scanner;

public class TimeConversion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        String arr[] = null;
        if(time.endsWith("PM")){
            arr = time.split(":");
            if(arr[0].equals("12"))
                System.out.print("12"+":"+arr[1]+":"+arr[2].split("P")[0]);
            else    
                System.out.print((Integer.parseInt(arr[0])+12)+":"+arr[1]+":"+arr[2].split("P")[0]);
        }
        else if(time.endsWith("AM")){
            arr = time.split(":");
            if(arr[0].equals("12"))
                System.out.print("00"+":"+arr[1]+":"+arr[2].split("A")[0]);
            else
                System.out.print(time.split("A")[0]);
        }
    }
    
}