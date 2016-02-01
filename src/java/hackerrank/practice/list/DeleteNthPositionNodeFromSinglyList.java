package hackerrank.practice.list;

public class DeleteNthPositionNodeFromSinglyList {
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
		
		Delete(n1, 2);
	}
	
	/*
	  Delete Node at a given position in a linked list 
	  Node is defined as 
	  struct Node
	  {
	     int data;
	     struct Node *next;
	  }
	*/
	private static Node Delete(Node head, int position)
	{
		Node nthNode = head;
		Node prevNode = null;
		int index = 0;
		
		if(head != null && position == 0)
		{
			head = head.next;
			return head;
		}else
		{
			while(index < position)
			{
				try 
				{
					index++;
					prevNode = nthNode;
					nthNode = nthNode.next;
				} catch (NullPointerException e) 
				{
					
				}
			}
			
			prevNode.next = nthNode.next;
				
			return head;
		}
		
		
	}
	
	private static final class Node
	{
		int data;
	    Node next;
	}
}
