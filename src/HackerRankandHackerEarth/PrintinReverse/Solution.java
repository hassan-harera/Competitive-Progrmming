/* My Complement



    static void reversePrint(SinglyLinkedListNode head) {
        
        Stack s = new Stack();
        while (head != null)
        {
            s.add(head.data);
            head = head.next ;
        }
        
        while (!s.isEmpty())
        {
            System.out.println(s.pop());
        }
    }

*/