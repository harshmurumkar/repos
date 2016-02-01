package hackerrank.practice.list;


public class CycleDetectionInSinglyList {
   
	public static void main(String[] args) {
		Node n1 = new Node();
		n1.data = 1;
		
		Node n2 = new Node();
		n2.data = 2;
		
		Node n3 = new Node();
		n3.data = 3;
		
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		
		System.out.println(hasCycle(n1));
	}
	
	/*
	  Detect cycle in the list
	  head pointer input could be NULL as well for empty list
	  Node is defined as 
	  class Node 
	  {
	     int data;
	     Node next;
	  }
	*/
	private static int hasCycle(Node head) 
	{
		Node tortoise = null;
		Node hare = null;
		
		tortoise = hare = head; 
		
		while(hare != null)
		{
			tortoise = tortoise.next;
			hare = hare.next;
			hare = hare != null ? hare.next : null;
			
			if(hare == tortoise)
				return 1;
		}
			
		return 0;
	}
	
	private static class Node
	{
		int data;
	    Node next;
	}

}
