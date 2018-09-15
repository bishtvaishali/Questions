

public class SortedList {
	
public class Node{	
  int val;
  Node next;
  
  Node(int x) { 
	val = x; 
  }
  
  public String toString() {	
  	return  "--> " + val;
  }
  
}

Node firstNode = null;
Node prevNode = null;

public Node add(int value) {
	Node node = new Node(value);
	if(firstNode == null) {
		firstNode = node;
	}else {
		prevNode.next = node; 
	}	
	prevNode = node;
	return node;
}

public int length() {
	int i =0;
	Node node =  firstNode;
	while(node != null) {
		node = node.next;
		i++;	
	}
	return i;
} 


	
public SortedList merge2SortedLists(SortedList l1, SortedList l2) {	
	
	SortedList mergedList = new SortedList();
	System.out.println("in merged");

	Node cur1 = l1.firstNode;
	Node cur2 = l2.firstNode;
	
	System.out.println(cur1 + "," + cur2);
	
	while(cur1!= null && cur2!= null) {
		if(cur1.val == cur2.val) {
			mergedList.add(cur1.val);
			mergedList.add(cur2.val);
			System.out.print("FinallList---");
			mergedList.printList();
			cur1 = cur1.next;
			cur2 = cur2.next;
			
			//System.out.println(cur1 + "," + cur2);	
		}else if(cur1.val < cur2.val) {
			mergedList.add(cur1.val);
			cur1 = cur1.next;
		}else {
			mergedList.add(cur2.val);
			cur2 = cur2.next;
		}
	}
	
	while(cur1!=null && cur2==null) {
		mergedList.add(cur1.val);
		System.out.print("2nd---");
		mergedList.printList();
		cur1= cur1.next;
		
	}
	while(cur2!=null && cur1==null) {
		mergedList.add(cur2.val);
		System.out.print("3rd---");
		System.out.println(cur1 + "," + cur2);
		cur2= cur2.next;
	}	
	
	return mergedList;
}

public void printList() {
	Node cur = firstNode;
	while(cur!=null) {	
		System.out.println("-->" + cur.val);
		cur = cur.next;
	}
	
}

public static void main(String[] args) {
//input: 1->2->4, 1->3->4
	
	SortedList  list1 = new SortedList();
	Node node1 = list1.add(1);
	Node node2 = list1.add(3);
	Node node3 = list1.add(4);
	list1.add(6);
	
	SortedList  list2 = new SortedList();
	Node node4 = list2.add(1);
	Node node5 = list2.add(3);
	Node node6 = list2.add(4);
	list2.add(5);
	list2.add(6);

	System.out.println(node1 + "," + node2 + "," + node3);
	//System.out.println(node1.next + "," + node2.next + "," + node3.next);
	
	list1.printList();
	list2.printList();
	
	System.out.println("length of List1:" + list1.length());

	
	SortedList  sl = new SortedList();

	sl.merge2SortedLists(list1, list2);
	

}

}
