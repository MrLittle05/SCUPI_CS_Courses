/**
  Program to test out singly linked-list ADT
*/

import stores.*;

public class CS0445A3
{
    public static void main(String[] args)
    {
        String name = "";
        String name2 = "";
        
        if (args == null | args.length < 1) {
          name = "My first name here!";
          name2 = "My second name here!";
        } else if (args.length > 1) {
          name = args[0];
          name2 = args[1];
          MyLinkedList<String> list = new MyLinkedList<>();
          System.out.println(list.toString());
          list.add(name);
          System.out.println(list.toString());
          list.addToTail(name2);
          System.out.println(list.toString());
          list.removeFromHead();
          System.out.println(list.toString());
          /*
           * INCOMPLETE (Exercise 3)
           * - Perform Exercise 2 (Print the list before and after adding "name" to the list)
           * - Add name2 using addToTail()
           * - Print out the linked list
           * - Remove an element from the head
           * - Print out the linked list
           */
        } else {
          name = args[0];
          name2 = "My name here!";
          MyLinkedList<String> list = new MyLinkedList<>();
          System.out.println(list.toString());
          list.add(name);
          System.out.println(list.toString());
          // INCOMPLETE (Exercise 2) - Print the list before and after adding "name" to the list
        }

    }
}
