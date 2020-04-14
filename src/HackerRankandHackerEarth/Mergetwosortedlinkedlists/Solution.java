/* My Complement



    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        
        SinglyLinkedListNode n = new SinglyLinkedListNode(0);
        SinglyLinkedListNode h = n ;
            
        while (head1 != null || head2 != null)
        {
            if (head1 == null)
            {
                h.next = head2 ;
                head2 = head2.next ;
            }
            else if (head2 == null)
            {
                h.next = head1;
                head1 = head1.next ;
            }
            else
            {
            if(head1.data  <= head2.data)
            {
                h.next = head1 ;
                head1 = head1.next;
            }
            else
            {
                h.next = head2 ;
                head2 = head2.next ;
            }
            }
            h = h.next ;
        }


    return n.next;}





*/