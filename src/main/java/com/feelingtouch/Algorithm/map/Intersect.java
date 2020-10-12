package com.feelingtouch.Algorithm.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * @author admin
 *
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] numsSmall = (nums1.length < nums2.length) ? nums1 : nums2;
        int[] numsBig = (numsSmall == nums1)? nums2: nums1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: numsSmall){
            int cnt = map.getOrDefault(num, 0);
            map.put(num, ++cnt);
        }

        int[] result = new int[numsBig.length];
        int i = 0;
        for(int num: numsBig){
            Integer cnt = map.get(num);
            if(cnt != null && cnt != 0){
                result[i++] = num;
                map.put(num, --cnt);
            }
        }
        return Arrays.copyOfRange(result, 0, i);
    }
    
    public static void main(String[] args) {
    	int[] a = new int[]{1,2,2,3,0,5};
    	int[] b = new int[]{6,2,2,5,7,9};
    	Intersect s = new Intersect();
    	int [] c = s.intersect(a, b);
    	System.out.println(c);
    }
    
}