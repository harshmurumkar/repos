/**
 * 
 */
package hackerrank.practice.list;

/**
 * @author hmurumkar
 *
 */
public class RemoveDuplicatesInList {

	static Node RemoveDuplicates(Node head) {
		
		if(head == null)
			return null;
		java.util.Set<Integer> set = new java.util.HashSet<Integer>();
		Node prev = null;
		Node current = head;
		while(current != null)
		{
			if(!set.add(current.data) && prev != null)
			{
				prev.next = current.next;
			}
			else
				prev = current;
			current = current.next;
		}
		return head;
	}

	private static class Node 
	{
		int data;
		Node next;
	}
	
	public static void main(String[] args) 
	{
		/*Node n = new Node();
		n.data = 1;
		
		Node n1 = new Node();
		n1.data = 2;
		n1.next = n;
		
		Node n2 = new Node();
		n2.data = 1;
		n2.next = n1;*/
		
		Node n3 = new Node();
		n3.data = 1;
		n3.next = null;
		
		Node n4 = new Node();
		n4.data = 3;
		n4.next = n3;
		
		RemoveDuplicates(n4);
		System.out.println(n4);
	}
}
