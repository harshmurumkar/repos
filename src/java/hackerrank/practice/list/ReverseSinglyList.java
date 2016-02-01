package hackerrank.practice.list;

import java.util.Stack;

public class ReverseSinglyList {

	
	public static void main(String[] args) 
	{
		Node n1 = new Node();
		n1.data = 1;
		
		Node n2 = new Node();
		n2.data = 2;
		
		Node n3 = new Node();
		n3.data = 3;
		
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		
		reverse(n1);
	}
	
	/*
	  Reverse a linked list and return pointer to the head
	  The input list will have at least one element  
	  Node is defined as 
	  struct Node
	  {
	     int data;
	     struct Node *next;
	  }
	*/
	
	private static Node reverse(Node head)
	{
		Stack<Node> nodeStack = new Stack<Node>();
		Node tmp = head;
		
		while(tmp != null)
		{
			nodeStack.push(tmp);
			tmp = tmp.next;
		}
		head = tmp = null;
		Node n = null;
		
		while(!nodeStack.empty())
		{
			n = nodeStack.pop();
			n.next = null;
			if(head == null)
				head = tmp = n;
			else
			{
				if(tmp != null )tmp.next = n;
				tmp = tmp.next;
			}
				
		}
		
		return head;
	}
	
	private static final class Node
	{
		int data;
	    Node next;
	}
}
