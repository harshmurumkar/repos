/**
 * 
 */
package hackerrank.practice;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * @author harsh.murumkar
 * @since
 */
public class Solution
{
    private static int numberOfElements;
    private static int numberOfCases;
    private static MyNode head;
    private static MyNode tail;
    private static List<TestCase> testCases = new ArrayList<TestCase>();
    //private static Map<Integer, MyNode> nodeMap = new HashMap<Integer, MyNode>();
    /**
     * @param args
     */
    public static void main(String[] args) {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputString = null;
            String[] arr = null;
            
            // reading input parameter
            inputString = reader.readLine();
            arr = inputString.split(" ");
            
            numberOfElements = Integer.parseInt(arr[0]);
            numberOfCases = Integer.parseInt(arr[1]);
            
            // reading element array
            inputString = reader.readLine();
            
            if(inputString != null)
            {
                arr = inputString.split(" ");
                MyNode tempNode = null;
                for (int index = 0; index < arr.length; index++)
                {
                    int element = Integer.parseInt(arr[index]);
                    MyNode node = new MyNode(element);
                    if(tempNode != null)
                    {
                        tempNode.next = node;
                        node.previous = tempNode;
                        tempNode = node;
                        tail = node;
                    }else
                    {
                        tempNode = new MyNode(element);
                        head = tempNode;
                    }
                    
                    //nodeMap.put(element, node);
                }
            }
            
            inputString = null;
            //nodeMap = new HashMap<Integer, MyNode>();
            
            for(int i = 0; i < numberOfCases; i++)
            {
                // reading TestCase
                inputString = reader.readLine();
                String[] tokens = inputString.split(" ");
                testCases.add(new TestCase(tokens[0].equals("1") ? DirectionEnum.START : DirectionEnum.END, tokens[1], tokens[2]));
            }
            
            
            // run Test Cases
            for (TestCase test : testCases)
            {
                test.doTest();
            }
            
            System.out.println(Math.abs(head.data - tail.data));
            print(head);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    private static void print(MyNode node)
    {
        while(node != null && node.next != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.print(node != null ? node.data : "");
    }


    private enum DirectionEnum{
        START, END;
    }
    
    private final static class TestCase
    {
        final private DirectionEnum direction;
        final private int startIndex;
        final private int endIndex;
        
        private TestCase(DirectionEnum arg1, String arg2, String arg3)
        {
            this.direction = arg1;
            this.startIndex = Integer.parseInt(arg2);
            this.endIndex = Integer.parseInt(arg3);
        }
        
        @Override
        public String toString()
        {
            return "(direction = " + this.direction + ", startIndex = " + this.startIndex + ", endIndex = " + this.endIndex + ")";
        }
        
        private void doTest()
        {
            try
            {
                int counter = 1;
                MyNode node = null;
                MyNode fromNode = null;
                MyNode toNode = null;
                
                node = head;
                while(node != null)
                {
                    if(counter == startIndex)
                    {
                        fromNode = node;
                    }if(counter == endIndex)
                    {
                        toNode = node;
                    }
                    
                    counter++;
                    node = node.next;
                }
                
                //System.out.println("from [" + startIndex + "] to [" + endIndex + "]");
                
                
                if(this.direction == DirectionEnum.START)
                {
                    if(toNode == tail)
                    {
                        fromNode.previous.next = null;
                        
                        toNode.next = head;
                        head.previous = toNode;
                    }else if(fromNode == head)
                    {
                        
                    }
                    else
                    {
                        fromNode.previous.next = toNode.next;
                        toNode.next.previous = fromNode.previous;
                        
                        toNode.next = head;
                        head.previous = toNode;
                    }
                    
                    fromNode.previous = null;
                    head = fromNode;
                    
                }else // END Direction
                {
                    if(fromNode == head)
                    {
                        head = toNode.next;
                        toNode.next.previous = null;
                        
                        tail.next = fromNode;
                        fromNode.previous = tail;
                    }
                    else if(toNode == tail)
                    {
                        
                    }else
                    {
                        fromNode.previous.next = toNode.next;
                        toNode.next.previous = fromNode.previous;
                        tail.next = fromNode;
                        fromNode.previous = tail;
                    }
                   
                    toNode.next = null;
                    tail = toNode;
                }
            }
            catch (Exception e)
            {
                System.out.println("TEST CASE : " + toString());
                e.printStackTrace();
            }
        }
            
    }
    
    private final static class MyNode
    {
        private final int data;
        private MyNode next;
        private MyNode previous;
        
        public MyNode(final int inputData, final MyNode nextNode, final MyNode previousNode)
        {
            data = inputData;
            next = nextNode;
            previous = previousNode;
        }
        
        public MyNode(final int inputData)
        {
            this(inputData, null, null);
        }
        
        @Override
        public String toString()
        {
            return ""+data;
        }
    }
}

