package com.datastructures.algorithms;

/**
 * Hello world!
 *
 */
public class Algorithms 
{
    public static void main(String[] args )
    {
       SingleLinkedList sll=new SingleLinkedList();
       sll=SingleLinkedList.insert(sll, 2);
       sll=SingleLinkedList.insert(sll, 3);
       
       SingleLinkedList.printList(sll);
    }
}
