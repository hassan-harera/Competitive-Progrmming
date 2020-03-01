/* My Complement

    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        
        
        SinglyLinkedListNode previous = head ;
        SinglyLinkedListNode next = head ;
        
        if(position == 0)
        {
            head=head.next;
            
        }
        
         for (int i = 0 ; i < position-1 ; i++)
         {
             previous = previous.next;
         }
         next = previous.next.next;
         previous.next = next ;
         
         
         
    return head;}


*/