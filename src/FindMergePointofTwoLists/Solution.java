

/** My complement

 static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        
        LinkedList<SinglyLinkedListNode> l1 = new LinkedList<SinglyLinkedListNode>() ;
        SinglyLinkedListNode  h1 = head1 ;

        SinglyLinkedListNode h2 = head2 ;

        while(h1 !=null )
        {
            l1.add(h1);
            h1 = h1.next ;
        }
        
        while(h2!=null)
        {
            if(l1.contains(h2))
                break;
            else 
            h2 = h2.next ;
        }
        
    return h2.data;}


*/