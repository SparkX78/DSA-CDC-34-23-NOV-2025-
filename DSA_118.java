public class DSA_118 {
    static class ListNode{
        ListNode next;
         int val;
         ListNode(int val){
            this.val = val;
            this.next = null;
         }
    
    
        public static ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;

                if(slow == fast){
                    break;
                }
            }
            if(fast == null || fast.next == null) return null;
        
            slow = head;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;

        }

    public static void PrintList(ListNode head){
        ListNode temp = head;
        int count = 0; // prevent infinite loop
        while(temp != null && count < 20){
            System.out.print(temp.val + "->");
            temp = temp.next;
            count++;
        }
        System.out.println("...");
    }

    }
    public static void main(String[] args){
    ListNode node = new ListNode(4);
    node.next = new ListNode(3);
    node.next.next = new ListNode(2);
    node.next.next.next = new ListNode(1);

    // Creating cycle: 1 -> 3
    node.next.next.next.next = node.next;

    System.out.println(ListNode.detectCycle(node).val);
}

}

