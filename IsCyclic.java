package com.LinkedList;

public class IsCyclic {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private static boolean detectLoopAndRemove(Node head) {
		Node slow_ptr = head;
		Node fast_ptr = head;

		slow_ptr = slow_ptr.next;
		fast_ptr = fast_ptr.next.next;
		boolean flag = false;
		while (fast_ptr != null && fast_ptr.next != null) {

			if (fast_ptr == slow_ptr) {
				flag = true;
				break;
			}
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
		}
		if (slow_ptr == fast_ptr) {
			slow_ptr = head;
			while (slow_ptr.next != fast_ptr.next) {
				slow_ptr = slow_ptr.next;
				fast_ptr = fast_ptr.next;
			}
			fast_ptr.next = null;
		}
		return flag;
	}

	public static void main(String[] args) {

		IsCyclic ic = new IsCyclic();
		ic.head = new Node(1);
		ic.head.next = new Node(2);
		ic.head.next.next = new Node(3);
		ic.head.next.next.next = new Node(4);
		ic.head.next.next.next.next = new Node(5);
		ic.head.next.next.next.next.next = new Node(6);
		ic.head.next.next.next.next.next.next = new Node(7);

		ic.head.next.next.next.next.next.next.next = ic.head.next.next;

		boolean flag = detectLoopAndRemove(head);
		if (flag) {
			System.out.println("cyclic hai");
		} else {
			System.out.println("cyclic nahi hai");
		}
		while (head != null) {
			System.out.println(head.data + " " + head.next);
			head = head.next;
		}
	}
}
