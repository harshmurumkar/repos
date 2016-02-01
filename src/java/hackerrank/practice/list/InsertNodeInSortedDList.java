/**
 * 
 */
package hackerrank.practice.list;


/**
 * @author hmurumkar
 *
 */
public class InsertNodeInSortedDList {


	static Node SortedInsert(Node head, int data) 
	{
		if(head == null)
		{
			Node n = new Node();
			n.data = data;
			return n;
		}
			
		Node prev = null;
		Node current = head;
		while(current != null)
		{
			if(data >= current.data)
			{
				prev = current;
			}else
			{
				Node n = new Node();
				n.data = data;
				n.prev = prev;
				n.next = current;
				current.prev = n;
				break;
			}
			
			current = current.next;
		}
		
		if(prev != null)
		{
			Node n = new Node();
			n.data = data;
			n.next = prev.next;
			n.prev = prev;
			prev.next = n;
			
			if(n.next != null)
				n.next.prev = n;
		}
		
		if(head.prev != null)
			head = head.prev;
		return head;
	}

	private static class Node 
	{
		int data;
		Node next;
		Node prev;
	}
	
	public static void main(String[] args) {
		Node n = null;
		Node n3 = null;
		Node n1 = null;
		Node n2 = null;
		Node n4 = null;
		
		n = new Node();
		n.data = 5;
		n.prev = n1;
		
		n1 = new Node();
		n1.data = 4;
		n1.next = n;
		n1.prev = n2;
		
		n2 = new Node();
		n2.data = 3;
		n2.next = n1;
		n2.prev = n3;
		
		n3 = new Node();
		n3.data = 2;
		n3.next = n2;
		n3.prev = n4;
		
		n4 = new Node();
		n4.data = 1;
		n4.next = n3;
		n4.prev = null;
		
		SortedInsert(n4, 3);
	}
}
