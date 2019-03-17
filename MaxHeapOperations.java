/*
 * Max heap: Insert and Remove
 */

import java.util.*;

public class MaxHeapOperations{
  
  static List<Integer> heap = new ArrayList<Integer>();
  
  public static void insert(int val){
    
    //insert at the end of the List
    heap.add(val);
    bubbleUp(heap.size()-1);
  }
  
  public static void bubbleUp(int idx){
    int childIdx = idx;
    int parentIdx = getParent(childIdx);
    while(childIdx < heap.size() && parentIdx >= 0 && heap.get(childIdx) > heap.get(parentIdx)){      
      swap(childIdx, parentIdx);
      childIdx = parentIdx;
      parentIdx = getParent(childIdx);
    }
  }
  
  public static void swap(int idx1, int idx2){
    int temp = heap.get(idx1);
    heap.set(idx1, heap.get(idx2));
    heap.set(idx2, temp);    
  }

  public static void bubbleDown(int idx){
    int parentIdx = idx;
    int childIdx = getChild(parentIdx);
    
    while(childIdx < heap.size() && heap.get(childIdx) > heap.get(parentIdx)){
      swap(childIdx, parentIdx);
      parentIdx = childIdx;
      childIdx = getChild(parentIdx);
    }
  }
  
  public static int getParent(int childIdx){
    if(childIdx > 0){
      
      //check if it is a left child or a right child
      if(childIdx%2 == 0){
        return (childIdx - 2)/2; //Right child
      }else{
        return (childIdx - 1)/2; //Left child
      }
    }
    return childIdx;
  }
  
  public static int getChild(int parentIdx){
    int child1 = (2 * parentIdx) + 1;
    int child2 = (2 * parentIdx) + 2;
    
    if(child1 >= heap.size()){
      return child1;
    }else if(child2 >= heap.size()){
      return child1;
    }else if(heap.get(child1) > heap.get(child2)){
      return child1;
    }else{
      return child2;
    }
  }
  
  public static void remove(int val){
    for(int i=0;i<heap.size();i++){
      if(val == heap.get(i)){

        //swap element at the end of the heap
        swap(i, heap.size()-1);
        heap.remove(heap.size()-1);
        
        bubbleDown(i);
        bubbleUp(i);
        break;
      }
    }
  }
  
  public static void printMaxHeap(){
    System.out.println(heap);
  }
  
  public static void main(String args[]){
      insert(1);
      insert(4);
      insert(3);
      insert(7);
      insert(8);
      insert(9);
      insert(10);
      printMaxHeap();
      remove(1);
      printMaxHeap();  
  }
}