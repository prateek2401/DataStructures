package com.datastructures.algorithms;

import java.util.Stack;

class SingleLinkedList {
	
	Node head;//head of the List

    // Linked list Node. 
    // This inner class is made static 
    // so that main() can access it
	static class Node{
		int data;
		Node next;
	
	Node(int d){
		this.data=d;	
		}
	}
	public static SingleLinkedList insert(SingleLinkedList list, int data) 
    {
		Node new_Node=new Node(data);
		new_Node.next=null;
		if(list.head==null){
			list.head=new_Node;
		}else{
			Node last=list.head;
			while(last.next!=null)
				last=last.next;
			last.next=new_Node;		
		}
		return list; 

    }
		
	public static void printList(SingleLinkedList list){
		Node currNode=list.head;
		while(currNode!=null){
			System.out.print(currNode.data);
			currNode=currNode.next;
		}
	}
	
	public static SingleLinkedList deleteByKey(SingleLinkedList list, int key) 
    { 
		Node currNode=list.head;
		Node prev=null;
		//If head node itself hold the key
		if(currNode!=null && currNode.data==key){
			list.head=currNode.next;
			System.out.println("Key "+ key +"found and deleted");
		}
		//If key is other than head 
		while(currNode!=null && currNode.data !=key ){
			prev=currNode;
			currNode=currNode.next;
		}
		if(currNode!=null){
			prev.next=currNode.next;
			System.out.println("Key "+key+"Found and deleted");
		}
		if(currNode==null){
			System.out.println(key+" Not found");
		}
	return list;
    }
	
	static boolean isPalindrome(Node head) 
    {
		Node slow=head;
		boolean isPalin=true;
		Stack<Integer> stack= new Stack<Integer>();
		while(slow!=null){
			stack.push(slow.data);
			slow=slow.next;
		}
		
		while(head!=null){
			int i=stack.pop();
			if(i==head.data)
				isPalin=true;
			else{
				isPalin=false;	
				break;
			}
			head=head.next;
		}
		return isPalin;
		}
	
	void printMiddle() 
    { 
		Node slowPtr=head;
		Node fastPtr=head;
		if(head!=null)
		{
			while(fastPtr!=null && fastPtr.next!=null){
				fastPtr=fastPtr.next.next;
				slowPtr=slowPtr.next;
			}
		}
		System.out.println("The midle data element is "+slowPtr.data);
		
    }
	
	void removeDuplicates() 
    {
		Node curr=head;
		
		while(curr!=null){
			Node temp=curr;
			
			if(temp!=null && temp.data==curr.data)
				temp=temp.next;
			curr.next=temp;
			curr=curr.next;
		}
    }
	
	int detectLoop(){
		Node slwPtr=head;
		Node fastPtr=head;
		
		while(slwPtr!=null && fastPtr!=null && fastPtr.next!=null){
			slwPtr=slwPtr.next;
			fastPtr=fastPtr.next.next;
			if(slwPtr==fastPtr)
			{
				System.out.print("Loop detected");
				return 1;
			}
		}
		return 0;
	}
	
	Node reverse(Node head) 
    { 
		Node curr=head;
		Node prev=null;
		Node next=null;
		while(curr!=null){
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head=prev;

		return head;
    }
	
	static boolean isCircular( Node head) 
	{ 
		if(head==null)
			return true;
		Node node=head.next;
		while(node!=null && node!=head){
			node=node.next;
		}
		return (head==node);
	}

}
