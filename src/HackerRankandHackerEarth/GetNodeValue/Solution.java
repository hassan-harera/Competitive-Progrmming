/* My Complement

    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        
        SinglyLinkedListNode h = head;
        int size = 0;
        while (h!=null)
        {
            h = h.next;
            size++;
        }
        positionFromTail = size-1 - positionFromTail;
        
        while (positionFromTail > 0)
        {
            head = head.next ;
            positionFromTail--;
        }
    return head.data;}


**/