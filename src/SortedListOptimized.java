

public class SortedListOptimized {
 
	
	ListNode root = null;
	
	public class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int x) { 
			val = x; 
		}
		
		
		public String toString() {	
			return Integer.toString(val);
		}
	}

public static void printList(ListNode root) {
	ListNode cur = root;
	System.out.print("\n[" + root);
	
	while(cur!= null && cur.next!=null) {		
		cur = cur.next;
		System.out.print("-->"+ cur);	
	}
	System.out.println("]");
}


public ListNode add(int val) {
	ListNode newNode = new ListNode(val);
	
	if(root == null) {
		root = newNode;
	}else {
		ListNode cur = root;
		while(cur.next!=null) {
			cur = cur.next;
		}	
		
		cur.next = newNode;	
	}
	
	
	return newNode;
}




public ListNode merge2SortedLists(ListNode l1, ListNode l2) {		
	ListNode cur1 = l1;
	ListNode cur2 = l2;
	
	ListNode start = null;
	ListNode root = null;

	
	if(l1 == null && l2 != null) {
		root = l2;
	}else if( l1 != null && l2 == null) {
		root = l1;
	}else {
		
		while(cur1!= null && cur2!= null) {
			if(cur1.val <= cur2.val) {		
				if(root == null) {
					start = cur1;
					root = start;
					cur1 = cur1.next;
					start.next = null;
				}else {
					start.next = cur1 ;
					cur1 = cur1.next;		
					start = start.next;
					start.next = null;			
				}
			}else {
				if(root == null) {
					start = cur2;
					root = start;
					cur2 = cur2.next;
					start.next = null;
				}else {
					start.next = cur2;
					cur2 = cur2.next;
					start = start.next;
					start.next = null;
					
				}
				
			}
		}
			
		if(cur1!=null && cur2 ==null) {
			start.next = cur1 ;
		//	System.out.println("If1:" );
			//printList(l1);
		}else if (cur2!=null && cur1==null) {
			start.next = cur2 ;
			//System.out.println("If2:" );
			//printList(l1);
		}		
	}
	
	
	return root;	  
}


public static void main(String[] args) {
	
	SortedListOptimized l1 = new SortedListOptimized();
		l1.add(2);
//		l1.add(2);
//		l1.add(3);
//		l1.add(7);
		System.out.print("list1:");
		printList(l1.root);		
		
		SortedListOptimized l2 = new SortedListOptimized();
//		l2.add(1);
//		l2.add(3);
//		l2.add(4);
//		l2.add(5);
//		l2.add(6);
//		l2.add(8);
		System.out.print("list2:");
		printList(l2.root);
		
		
		SortedListOptimized l3 = new SortedListOptimized();
		
		printList(l3.merge2SortedLists(l1.root, l2.root));
}

}


