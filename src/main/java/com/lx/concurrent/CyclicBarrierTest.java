package com.lx.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	
	private CyclicBarrier cb = new CyclicBarrier(5);
	
	private class Student implements Runnable{

		@Override
		public void run() {
			try {
				Thread.sleep(2000);
				cb.await();
				System.out.println("one student ready");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void begin(){
		for(int i=0; i<5; i++){
			new Thread(new Student()).start();
		}
		
		System.out.println("All students go");
	}
	
	
	public static void main(String[] args){
		CyclicBarrierTest t = new CyclicBarrierTest();
		t.begin();
		
		int [][] matrix = new int[0][0];
		t.searchMatrix(matrix, 1);
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int colomn = 0;
        while(row >=0 && colomn < matrix[0].length){
            int value = matrix[row][colomn];
            if(value == target){
                return true;
            } else if(value > target){
                row -- ;
            } else if(value < target){
                colomn ++;
            }
        }

        return false;
    }

}
