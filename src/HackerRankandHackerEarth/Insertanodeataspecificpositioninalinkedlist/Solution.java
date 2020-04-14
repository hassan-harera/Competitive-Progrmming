/* My Complement


    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode New = new SinglyLinkedListNode(data);
        if (head == null)
        {head = New ; return head ; }
        
        SinglyLinkedListNode h = head ;
        int i = 0 ;
        while (i<position-1)
        {
            h = h.next;
            i++;
        }
        New.next = h.next ;
        h.next = New ;
    return head ;}




*/