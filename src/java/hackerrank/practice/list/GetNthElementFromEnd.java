/**
 * 
 */
package hackerrank.practice.list;

import java.util.Stack;

/**
 * @author hmurumkar
 *
 */
public class GetNthElementFromEnd {

	private static int GetNode(Node head,int n) {
		
		Stack<Integer> stck = new Stack<Integer>();
		while(head != null)
		{
			stck.push(head.data);
			head = head.next;
		}
		
		for (int i = 0; i < n; i++) {
			stck.pop();
		}
		return stck.pop();
	}
	
	private static class Node 
	{
		int data;
		Node next;
	}
}
