public class DSA_117 {

    static class ListNode{
        ListNode next;
        int val;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
     
        public static ListNode sortList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode mid = getMid(head);
            ListNode right = mid.next;
            mid.next = null;

            ListNode leftSorted = sortList(head);
            ListNode rightSorted = sortList(right);

            return merge(leftSorted, rightSorted);


        }
        private static ListNode getMid(ListNode head){
            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        private static ListNode merge(ListNode a , ListNode b){
            ListNode dummy = new ListNode(0);
        
            ListNode curr = dummy;
            while(a != null && b != null){
                if(a.val < b.val){
                    curr.next = a;
                    a = a.next;
                }
                else{
                    curr.next = b;
                    b = b.next;
                }
                curr = curr.next;

                if(a != null)curr.next = a;
                if(b != null)curr.next = b;
            }
            
            return dummy.next;
        }

        public static void PrintList(ListNode head){
            ListNode temp = head;
            while(temp != null){
                System.out.print(temp.val + "->");
                temp = temp.next;
            }
            System.out.println("null");
        }

    }
    
    public static void main(String[] args){
        ListNode node = new ListNode(4);
        node.next = new ListNode(3);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);

        System.out.println("ORIGINAL LINKED LIST-----");
        ListNode.PrintList(node);

        System.out.println("SORTED MERGED LINKED LIST---");
        ListNode.PrintList(ListNode.sortList(node));
    }
}
