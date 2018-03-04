package com.LinkedList;

public class ReverseLinked {
	
	static Node head;
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	private Node reverse(Node head2) {
			
		Node prev = null;
		Node current = head2;
		
		while(current!=null){
			head2 = current.next;
			current.next = prev;
			prev = current;
			current = head2;
		}
		return prev;
	}
	
	private Node reverseKElement(Node head, int k) {
		
		Node prev=null,headnext;
		Node current = head;
		int c=0;
		while(c<k && current!=null){
			headnext = current.next;
			current.next = prev;
			prev = current;
			current = headnext;
			c++;
		}
		if(current!=null){
			head.next = reverseKElement(current, k);
		}
		return prev;
	}
	public static void main(String[] args) {
		
		ReverseLinked rl = new ReverseLinked();
		
		rl.head = new Node(1);
		rl.head.next = new Node(2);
		rl.head.next.next = new Node(3);
		rl.head.next.next.next = new Node(4);
		
		/*Node rev = rl.reverse(head);
		while(rev!=null){
			System.out.println(rev.data);
			rev = rev.next;
		}*/
		
		Node rev1 = rl.reverseKElement(head,2);
		while(rev1!=null){
			System.out.println(rev1.data);
			rev1= rev1.next;
		}
	}
}
