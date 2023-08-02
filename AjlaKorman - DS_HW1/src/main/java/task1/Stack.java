package task1;

import task1.Queue;
import java.util.EmptyStackException;

public class Stack<Item> {
    private Queue<Item> q1;
    private Queue<Item> q2;


    public Stack() {
        q1 = new Queue<Item>();
        q2 = new Queue<Item>();
    }

    public void push(Item data) { //This is the function for adding elements to q2 from q1, and then swap q2 and q1
        q2.enqueue(data);         //Adding new element to the stack, that is queue 2

        int size = q1.size();
        for(int i =0; i < size; i++){
            q2.enqueue(q1.dequeue());
        }
            /*This for loop, will go through the whole queue 1 and all elements from it will be dequeued(removed)
            by the rule FIFO, and will be enqueued(added) to the queue 2.
            Process will be repeated dependently on the number of elements in queue 1
            After this process, queue 2 will have all elements and queue 1 will be empty
             */

        Queue<Item> helpQueue = q1;
        q1 = q2;
        q2 = helpQueue;
        //This part here will swap q1 and q2, however in order to do that, a new help variable will be created
        //And now, q2 will be empty and q1 will have all elements.

    }

    public Item pop()  {
        if (isEmpty()) {
            throw new EmptyStackException();
        } //If the stack is empty, an appropriate message will be shown

        return q1.dequeue();
        //Since we did the swapping part in the push method, all elements are now located in the q1, and q2 is empty
        //This means that we will just remove an element from q1
    }

    public Item peek()  {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Item helpVariable = q1.dequeue();
        q2.enqueue(helpVariable);
        //first value, or head is also the top of the queue, and its value will also be stored in a temporary, helping variable
        // it wll also be added as a first element of the q2

        while(q1.isEmpty() == false){     //while q1 has elements, this while loop will be executed
            q2.enqueue(q1.dequeue());
        }
        //here, all remaining elements are now removed from q1 and added to the end of q2

        Queue<Item> helpQueue = q1;
        q1 = q2;
        q2 = helpQueue;
        //now, the two queues are again swapped, so the q1 still stays with all of its elements

        return helpVariable;
        //just the top element from the q1 will be returned, but it will not be removed because of the implementation of q2 and swapping
    }



    public int size() {
        return q1.size();
        //the size of q1 will be returned, since q2 is just a helping queue which stores the values during the push, but then swaps with q1 and q2 becomes empty
    }


    public boolean isEmpty() {
        return q1.isEmpty();
        //same principle as with function size(), q2 is a helping queue, which only stores values during a push process, but after it, q2 becomes empty
        //So, this means, q2 will always be empty but the q1 doesn't have to be (it depends on the operations performed)
    }


}

