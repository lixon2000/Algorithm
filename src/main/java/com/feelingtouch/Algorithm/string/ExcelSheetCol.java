package com.feelingtouch.Algorithm.string;

/**
 * 171. Excel表列序号
 * 
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * @author admin
 *
 */
public class ExcelSheetCol {
    public int titleToNumber(String s) {
    	int num = 0;
    	for(char c: s.toCharArray()){
    		num = num * 26 + c - 'A' + 1;
    	}
    	return num;
    }
    
	public static void main(String[] args) {
       String s = "AB";
       ExcelSheetCol e = new ExcelSheetCol();
       int a = e.titleToNumber(s);
       System.out.println(a);
	}
	
}
