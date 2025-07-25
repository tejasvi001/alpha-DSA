package patterns;

import java.util.Scanner;

public class Pattern {
	private static Scanner input;
	static {
		input=new Scanner(System.in);
	}
	public static void pattern1() {
		System.out.println("Enter No. of lines you want in your Pattern");
		int n=input.nextInt();
//		*
//		**
//		***
//		****
		for(int line=1;line<=n;line++) {
			for(int star=1;star<=line;star++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
	}
	public static void pattern2() {
		System.out.println("Enter No. of lines you want in your Pattern");
		int n=input.nextInt();
//		****
//		***
//		**
//		*
		for(int line=n;line>=1;line--) {
			for(int star=line;star>=1;star--) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
	}
	public static void pattern3() {
		System.out.println("Enter No. of lines you want in your Pattern");
		int n=input.nextInt();
//			* 
//		   * * 
//		  * * * 
//		 * * * * 
		for(int line=1;line<=n;line++) {
			for(int space=n-line;space>0;space--) {
				System.out.print(" ");
			}
			for(int star=1;star<=line;star++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
	}
	public static void pattern4() {
		System.out.println("Enter No. of lines you want in your Pattern");
		int n=input.nextInt();
//			*
//		   **
//		  ***
//		 ****
		for(int line=1;line<=n;line++) {
			for(int space=n-line;space>0;space--) {
				System.out.print(" ");
			}
			for(int star=1;star<=line;star++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	public static void pattern5() {
		System.out.println("Enter No. of lines you want in your Pattern");
		int n=input.nextInt();
//		****
//		 ***
//		  **
//		   *
		for(int line=n;line>=1;line--) {
			for(int space=n-line;space>0;space--) {
				System.out.print(" ");
			}
			for(int star=line;star>=1;star--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	public static void pattern6() {
		System.out.println("Enter No. of lines you want in your Pattern");
		int n=input.nextInt();
//		* * * * 
//		 * * * 
//		  * * 
//		   * 
		for(int line=n;line>=1;line--) {
			for(int space=n-line;space>0;space--) {
				System.out.print(" ");
			}
			for(int star=line;star>=1;star--) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
	}
	public static void pattern7() {
		System.out.println("Enter No. of lines you want in your Pattern");
		int n=input.nextInt();
//		A
//		BC
//		DEF
//		GHIJ
		char a='A';
		for(int line=1;line<=n;line++) {
			for(int star=1;star<=line;star++) {
				System.out.print(a);
				a++;
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pattern1();
		pattern2();
		
		pattern4();
		pattern5();
		
		pattern3();
		pattern6();
		pattern7();
	}

}
