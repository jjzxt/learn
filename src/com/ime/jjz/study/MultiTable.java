package com.ime.jjz.study;

/**
 * @author jjz
 *	循环9次,输出
 */
public class MultiTable {
	public static void main(String[] args) {
		for(int i = 1;i <= 9;i++){
			for(int j = 1;j <= i;j++){
				String xx = (i*j) < 10 ? "  "+(i*j) : (i*j)+"";
				System.out.print(i+" x "+j +"="+xx+"  ");
			}
			System.out.println();
		}
	}
}
