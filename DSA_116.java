public class DSA_116 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
        public static ListNode reverseBetween(ListNode head, int left, int right) {
            if(head == null || right == left)return head;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;
            for(int i = 1; i < left; i++){
                prev = prev.next;
            }
            ListNode curr = prev.next;
            for(int i = 0; i < right-left; i++){
                ListNode temp = curr.next;
                curr.next = temp.next;
                temp.next = prev.next;
                prev.next = temp;
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
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        System.out.println("------ORIGINAL LINKED LIST-------");
        ListNode.PrintList(node);


        System.out.println("REVERSED LINKKED LIST");
        ListNode.PrintList(ListNode.reverseBetween(node, 2, 4));
    }
}
