package com.feelingtouch.Algorithm.sort;

/**
 * 数组的快速排序
 * 
 * @author admin
 *
 */
public class QuickSort {

	
	public void quickSort(int[] a) {
		int n = a.length;
		quickSort_c(a, 0, n-1);
	}
	
	/**
	 * 对下标p到r区间的a进行快排
	 * @param a
	 * @param p
	 * @param r
	 */
	private void quickSort_c(int[] a, int p, int r){
		if(p >= r){
			return;
		}
		
		int q = partition(a, p, r);		// 分区点
		quickSort_c(a, p, q-1);
		quickSort_c(a, q, r);
	}
	
	/**
	 * 在p和r两个下标间，找到a的分区点
	 * @param a
	 * @param p
	 * @param r
	 * @return
	 */
	private int partition(int[] a, int p, int r){
		int pivot = a[r];
		int i = p;		// i是未处理区间的头，即已处理区间和未处理区间的分隔点
		
		for(int j=p; j<=r-1; j++){
			if(a[j] < pivot){
				
				// 如果发现未处理区间的元素比pivot小，则与未处理区间第一个元素交换
				// 交换a[i]和a[j]
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				i ++;
			}
		}
		
		// 交换pivot和a[i]
		a[r] = a[i];
		a[i] = pivot;
		
		return i;
	}
	
	public static void main(String[] args){
		int[] a = {2,5,8,3,9,1,7,6,0,4};
		QuickSort qs = new QuickSort();
		
		qs.quickSort(a);
		System.out.println(a);
	}
	
}
