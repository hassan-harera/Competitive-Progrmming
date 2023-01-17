/* My Complement

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        
      
            SinglyLinkedListNode curr = head ;
            SinglyLinkedListNode prev = null ;
            SinglyLinkedListNode next = curr;
            if (head == null)
               return head;
            
            while(curr!=null)
            {
                next = curr.next ;
                curr.next = prev ;
                prev = curr ;
                curr = next;
            }
    return prev;}


*/