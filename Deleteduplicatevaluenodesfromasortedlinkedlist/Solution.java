/* My Complement



      static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        
        SinglyLinkedListNode h = head;
        SinglyLinkedListNode t = h.next;
        
        while(t != null)
        {
            if(h.data == t.data)
            {
                h.next = t.next ;
                t = t.next ;
            }
            else {
            h = h.next ;
            t = t.next ;
            }
        }

    return head;}




 */

