package com.LinkedList;

public class RotateLinked {
	
	static Node head;
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	private static Node rotateLinked(Node head1,int rot) {
		Node current = head1;
		Node prev = head1;
		while(rot!=0){
			current = current.next;
			while(current.next!=null){
			current = current.next;
			prev = prev.next;
			}
			current.next = head1;
			head1 = current;
			prev.next = null;
			prev = head1;
			rot--;
		}
		return head1;
	}
	public static void main(String[] args) {

		 RotateLinked rl = new RotateLinked();
		 
		 rl.head = new Node(3);
		 rl.head.next = new Node(4);
		 rl.head.next.next = new Node(5);
		 rl.head.next.next.next = new Node(6);
		
		 
		 Node rotate = rotateLinked(head,3);
		while(rotate!=null){
			System.out.println(rotate.data);
			rotate = rotate.next;
		}
	}

}
