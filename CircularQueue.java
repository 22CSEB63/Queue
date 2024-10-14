/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package circularqueue;

/**
 *
 * @author Sys
 */
public class CircularQueue {
    
    private int size= 5;
    private int[] items;
    private int front,rear;
    
    public CircularQueue(){
        items = new int[size];
        front=-1;
        rear=-1;
    }
    public boolean isFull(){
        return (front==0 && rear==size-1) || (rear+1)%size==front;
    }
    public boolean isEmpty(){
        return front==-1;
    }
    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }
        if(front==-1){
            front=rear=0;
        }
        else if(rear==size-1 && front!=0){
            rear=0;
        }
        else{
            rear++;
        }
        items[rear]=data;
        System.out.println("Enqueued Data:"+data);
    }
    public int dequeue() {
    if (isEmpty()) {
        System.out.println("Queue is empty");
        return -1;
    }
    int data = items[front];
    items[front] = -1;
    if (front == rear) { // Queue is empty after removal
        front = rear = -1;
    } else if (front == size - 1) {
        front = 0; // Wrap around
    } else {
        front++;
    }
    return data;
}


    public void printQueue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Front <--");
        if(rear>=front)
        {
            for(int i= front;i<=rear;++i)
            {
                System.out.print("|"+items[i]+"|");
            }
            
        }
        else{
            for(int i=front;i<size;++i){
                System.out.print("|" + items[i] +"|");
            }
            for(int i=0;i<=rear;++i){
                System.out.print("|" + items[i] +"|");
            }
        }
        System.out.print("--> rear  ");
           
    }
    
        

    
    public static void main(String[] args) {
        CircularQueue cq= new CircularQueue();
        cq.printQueue();
        
        
        cq.enqueue(5);
        cq.enqueue(6);
        cq.enqueue(7);
        cq.enqueue(8);
        cq.enqueue(9);
        
        
        cq.printQueue();
        
        cq.dequeue();
        
        cq.printQueue();
        cq.enqueue(5);
        
        cq.printQueue();
        
        
        
    }

   
    
}
