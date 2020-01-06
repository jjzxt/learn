package com.ime.jjz.study;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.plaf.synth.SynthDesktopIconUI;

/**
 * @author jjz
 * 1,金字塔每层为基数个"*"
 * 2,每层的个数为: index = 2n-1
 * 3,每层"*"左边的空格数为: 层数-index
 */
public class Pyramid extends JFrame{
	public  static void  main(String[] args){
		Scanner in = new Scanner(System.in); 
		int max = in.nextInt();
		for(int i = 1;i <= max;i++){
			for(int m= 1;m <= max-i;m++){
				System.out.print("  ");
			}
			for(int n =1;n <= 2*i-1;n++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
