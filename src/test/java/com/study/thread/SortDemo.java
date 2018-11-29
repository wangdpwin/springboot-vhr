package com.study.thread;

public class SortDemo {

  public static void main(String[] args) {
    int[] arr = {1,6,5,2,2,2,4,8,9};
    for (int i=0;i<arr.length;i++){
        new Thread(new SortThread(i,arr[i])).start();
    }
  }

}

class SortThread implements Runnable{

    private int index;

    private int number;

    public SortThread(int index,int number){
        this.index = index;
        this.number = number;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(number * 1000L);
            System.out.println("index  " + (index+1) + " number  " + number);
        } catch (InterruptedException e) {
            //no logger
        }
    }
}