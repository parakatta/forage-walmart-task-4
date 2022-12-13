import java.util.*;
import java.lang.*;
import java.io.*;
public class PriorityHeap{
        public int capacity;
        public int[] heap;
        public static int size;
        
        public PriorityHeap(int capacity){
            size=0;
            capacity= (int)Math.pow(2,capacity);
            heap=new int[capacity+1];
            Arrays.fill(heap,-1);
        }
        
        public boolean isEmpty(){
            return size==0;
        }
        public boolean isFull(){
            return size==heap.length;
        }
        public void swap(int i, int j){
            int temp=i;
            i=j;
            j=temp;
        }
        public void heapify(int[] heap, int size, int i){
            int largest=i;
            int left= 2*i + 1;
            int right= 2*i + 2;
            if(left < size && heap[i]< heap[left]){
                largest = left;
            }
            if( right < size && heap[largest] < heap[right]){
                largest = right;
            }
            if ( largest != i){
                swap(heap[i], heap[largest]);
                heapify(heap, size,largest);
            }
        }
        
        public void insert(int element){
            if(isFull()){
                System.out.println("Full Heap");
                System.exit(0);
            }
            heap[size++]= element;
            for(int i=(size/2)-1;i>=0;i--){
                heapify(heap,size,i);
            }
            
            
        }
        public void pop(int element){
            if(isEmpty()){
                System.out.println("Empty Heap");
                System.exit(0);
            }
            int key = heap[element];
            heap[element]=heap[size-1];
            size--;
            for(int i=(size/2)-1;i>=0;i--){
                heapify(heap,size,i);
            }
            
        }
        public void printHeap()
        {
            System.out.print("Heap = ");
            for (int i = 0; i < size; i++)
                System.out.print(heap[i] +" ");
            System.out.println();
        }
        
        
    
	public static void main(String[] args) {
		System.out.println("Hello World");
		PriorityHeap heap = new PriorityHeap(4);
		heap.insert(5);
		heap.insert(4);
		heap.insert(3);
		heap.insert(5);
		heap.insert(8);
		heap.pop(1);
		heap.printHeap();
		
	}
}