package algorithms;

public class Node {

	private char chr;
	private int value;
	private Node next;
	private Node prev;
	
	Node(int value){
		this.value = value;		
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setNext(Node next) {		
		
		this.next = next;
		
	}
	
	public Node getNext() {
		
		return this.next;
		
	}
	
	public void setPrev(Node prev) {
		
		this.prev = prev;
		
	}
	
	public Node getPrev() {
		
		return this.prev;
		
	}

	public char getChr() {
		return chr;
	}

	public void setChr(char chr) {
		this.chr = chr;
	}
	
}
