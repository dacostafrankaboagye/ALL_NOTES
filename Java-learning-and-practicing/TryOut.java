
class ListNode {
    int val;
    ListNode next;
    
    ListNode(){}

    ListNode(int val){
        this.val = val;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next= next;
    }
}

public class TryOut {

    public static void printOut(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println(" null ");
    }

    public static int getDecimalValue1(ListNode head){
        ListNode current = head;
        int ans = 0;
        while(current != null){
            ans = (ans * 2 )+ current.val;
            current = current.next;
        }
        return ans;

    }
    public static int getDecimalValue(ListNode head){
        ListNode current = head;
        String strAns = "";
        while(current != null){
            strAns = strAns + Integer.toString(current.val);
            current = current.next;
        }
        return Integer.parseInt(strAns, 2);

    }

    

    public static void main(String[] args) {

        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;

        // printOut(a);

        System.out.println(getDecimalValue(a));
        


  
         
  

    }
}