/**
 * 
 */
package hackerrank.practice.list;

/**
 * @author hmurumkar
 *
 */

public class CheckListSimilarity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/*
	Compare two linked lists A and B
	Return 1 if they are identical and 0 if they are not. 
	Node is defined as 
	class Node {
	   int data;
	   Node next;
	}
	*/
	int CompareLists(Node headA, Node headB) {
	    if(headA == null && headB == null)
				return 1;
			else if(headA == null && headB != null)
				return 0;
			else if(headA != null && headB == null)
				return 0;
	        else if(headA.data != headB.data)
	            return 0;
	        
	        return CompareLists(headA.next, headB.next);   
	}

	
	private class Node {
		   int data;
		   Node next;
		}

}
