/* My complement




    public static Boolean hasCycle(SinglyLinkedListNode head)
    {
        
        Stack<SinglyLinkedListNode> s = new Stack<SinglyLinkedListNode>();
        while(head!=null)
        {
            if(s.contains(head))
            {return true ;}
            s.add(head);
            head = head.next;
        }
        
        
    return false ;}


*/