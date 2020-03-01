/* My Complement

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode New = new SinglyLinkedListNode(data);
        if(head==null)
        {head = New ; return head ;}
        
        SinglyLinkedListNode tail = head ;
        while(tail.next!=null)
        {
            tail = tail.next;
        }
        tail.next = New ;
        
            
            
    return  head;}




*/

