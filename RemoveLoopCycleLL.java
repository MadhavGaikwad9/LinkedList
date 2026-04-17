public class RemoveLoopCycleLL {
      public static class Node{
         int data;
         Node next;

         public Node(int data){ 
            this.data = data;
            this.next = null;
         }
   }

   public static Node head,temp;

   // detect method
   public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;      // +1 step
            fast = fast.next.next; // +2 steps
            if(slow == fast){
                return true;  // cycle exists
            }
        }
        return false; // cycle doesn't exist
   }

   public static void removeCycle(){
      // detect cycle
      Node slow = head;
      Node fast = head;
      boolean cycle = false;

      while(fast != null && fast.next != null){
         slow = slow.next;
         fast = fast.next.next;
         if(fast == slow){
            cycle = true;
            break;
         }
      }

      if(cycle == false){
         return;
      }

      slow = head;
      Node prev = null;

      // special case: cycle starts at head
      if(slow == fast){
         while(fast.next != slow){
            fast = fast.next;
         }
         fast.next = null;
         return;
      }

      while(slow != fast){
         prev = fast;
         slow = slow.next;
         fast = fast.next;
      }

      prev.next = null;
   }

   public static void main(String[] args){
      head = new Node(1);
      head.next = new Node(2);
      
      head.next.next = new Node(3);
      head.next.next.next = head;

      System.out.println(isCycle());
      removeCycle();
      System.out.println(isCycle());
   }
}