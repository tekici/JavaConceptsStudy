package algorithms;

import java.util.ArrayList;

public class LinkedListAlgorithms {
Node head;
	
	public void printLinkedList () {

		Node next;
		
		if (head == null)
		{
			System.out.println("First element of linked list is null");
			return;
		}
		
		System.out.print("[");
		next = head;
		do {			
			System.out.print(next.getValue() + " ");			
			next = next.getNext();
		}while (next != null);
		
		System.out.println("]");
	}
	
	public void insertOneWay(Node newNode) {
		
		Node check ;
		check = head;
		System.out.println("Inserting node with value : " + newNode.getValue());
		
		if (head == null || newNode.getValue()<head.getValue())
		{
			System.out.println("Setting new node as head node");
			if (head != null)
			{
				newNode.setNext(head);
			}
			head = newNode;
			return;
		}
		
		while (check.getNext() != null && check.getNext().getValue()<newNode.getValue()) { 			
			check = check.getNext();
		}
		
		System.out.println("Stopped at the node : " + check.getValue());
		if (check.getNext() == null)
		{
			System.out.println("Adding new node to the end.");
			check.setNext(newNode);
		}else
		{
			System.out.println("Adding new node between " + check.getValue() + " and " + check.getNext().getValue());
			newNode.setNext(check.getNext());
			check.setNext(newNode);
		}		
	}
	
	public void insertNewNodeAscending(Node newNode) {
		if (newNode == null)
		{
			System.out.println("node to insert is null, returning from function");
			return;
		}
		
		if (head == null ) {
			System.out.println("first node is null, returning from function");
			head = newNode;
			return;
		}
		
		System.out.println("Inserting node with value : " + newNode.getValue());
		Node check = head;
		
		do
		{
			System.out.println("Checking with the next list item : " + check.getValue());
			if (newNode.getValue() < check.getValue() )//New element is smaller than checking
			{
				if (check.getPrev() != null)//If the checking element is not the first element, than set the new element between 
				{//Making the connection of the new item with the previous one.
					System.out.println("Inserting between : " + check.getPrev().getValue() + " and : " + check.getValue() );
					check.getPrev().setNext(newNode);
					newNode.setPrev(check.getPrev());
				}else {//Checking element is the first element, changing the head with new item
					head = newNode;
				}
				//Making the connection of the new item with the current checking element
				newNode.setNext(check);
				check.setPrev(newNode);
				break; //quiting from loop 
			}
			
			// in case this was the last element and still not bigger than new element
			if (check.getNext() == null)
			{
				System.out.println("Inserting the node to end of list: " + newNode.getValue());
				newNode.setPrev(check);
				check.setNext(newNode);
				break;
			}
			
			check = check.getNext();			
			
		}while (true);
		
	}
	
	public void createLinkedList(int... values) {
		if (values == null || values.length < 1)
		{
			System.out.println("Requested Values list is null or empty");
			return ;
		}
		
		int firstValue = values[0];
		head = new Node(firstValue);
		for(int i = 1 ; i< values.length ; ++i){
			
			Node newNode = new Node(values[i]);
			//insertNewNodeAscending(newNode);
			insertOneWay(newNode);
			printLinkedList();
			
		}
	}

	public void removeNode(Node node) {
		Node check;
		
		if (head == null)
		{ System.out.println("Head node is null, returning function"); return;}
		
		if (head.getValue() == node.getValue())
		{
			head = head.getNext();
		}
		
		
		check = head;
		while (check.getNext() != null && check.getNext().getValue() != node.getValue()) {			
			check = check.getNext();			
		}
		
		if (check.getNext() == null) {
			System.out.println("The requested node could not be found on list.");
		}else {
			System.out.println("The item found on the list, will be removed.");			
			check.setNext(check.getNext().getNext());
		}
		printLinkedList();
	}
	
	
	public static void main (String... trg) {
		
		System.out.println("initiated");
		LinkedListAlgorithms lla = new LinkedListAlgorithms();
		
		lla.createLinkedList(10, 5, 2, 7, 11);		

		Node toRemove = new Node(11);
		lla.removeNode(toRemove);
		
		
		
	}
	
	
}
