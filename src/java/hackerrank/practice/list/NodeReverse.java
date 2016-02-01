package hackerrank.practice.list;

public class NodeReverse
{

    public static void main(String[] args)
    {
        /*
         * Node n_5 = new Node(); n_5.data = 5; Node n_7 = new Node(); n_7.data = 7; Node
         * n_2 = new Node(); n_2.data = 2; Node n_1 = new Node(); n_1.data = 1; n_2.next =
         * n_5; n_2.prev = n_1;
         * 
         * n_1.next = n_2; n_5.prev = n_2; n_5.next = n_7; n_7.prev = n_5;
         */
        Node n_1 = new Node();
        n_1.data = 11;
        System.out.println(SortedInsert(n_1, 3));
    }


    static int FindMergeNode(Node headA, Node headB)
    {
        Node n1 = headA;
        Node n2 = headB;
        while (n1 != n2)
        {
            if (n1.next == null)
            {
                n1 = headB;
            }
            else
            {
                n1 = n1.next;
            }
            if (n2.next == null)
            {
                n2 = headA;
            }
            else
            {
                n2 = n2.next;
            }
        }
        return n2.data;
    }


    static Node SortedInsert(Node head, int data)
    {
        if (head == null)
        {
            Node node = new Node();
            node.prev = null;
            node.next = null;
            node.data = data;
            return node;
        }
        else
        {
            Node tmpNode = head;
            Node node = new Node();
            node.data = data;
            while (tmpNode != null)
            {
                if (tmpNode.data > data)
                // it should be filled before current.
                {
                    if (tmpNode.prev != null)
                    {
                        tmpNode.prev.next = node;
                        node.prev = tmpNode.prev;
                    }
                    tmpNode.prev = node;
                    node.next = tmpNode;
                    break;
                }
                // it should be filled after the current
                else
                {
                    /*
                     * if(tmpNode.next != null) { tmpNode.next.prev = node; node.next =
                     * tmpNode.next; } tmpNode.next = node; node.prev = tmpNode; break;
                     */
                    tmpNode = tmpNode.next;
                }
            }
            if (tmpNode == head)
            {
                node.next = tmpNode;
                tmpNode.prev = node;
                head = node;
            }
            return head;
        }
    }

    private static class Node
    {

        public Node()
        {
            this.data = -1;
            this.next = null;
            this.prev = null;
        }


        public Node(int data, Node prev, Node next)
        {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        int data;
        Node next;
        Node prev;
    }
}
