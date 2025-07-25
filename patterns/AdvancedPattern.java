package patterns;

import java.util.Scanner;

public class AdvancedPattern {
	private static Scanner input;
	static {
		input=new Scanner(System.in);
	}
//	*****
//	*   *
//	*   *
//	*****
	public void hollowRectangle() {
		System.out.println("Enter Length");
		int b=input.nextInt();
		System.out.println("Enter Breadth");
		int l=input.nextInt();
		for(int i=0;i<l;i++) {
			for(int j=0;j<b;j++) {
				if(i==0||i==l-1||j==0||j==b-1) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	public void invertedPyramidwithnumbers() {
		System.out.println("Enter No. of lines you want in your Pattern");
		int n=input.nextInt();
//		54321
//		4321
//		321
//		21
//		1
		for(int line=n;line>=1;line--) {
			int a=1;
			for(int star=line;star>=1;star--) {
				System.out.print(a);
				a++;
			}
			System.out.println();
		}
		
	}
//	1 
//	2 3 
//	4 5 6 
//	7 8 9 10 
//	11 12 13 14 15 
	public void floydsTriangle() {
		System.out.println("Enter the number of lines");
		int n=input.nextInt();
		int a=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(a+" ");
				a++;
			}
			System.out.println();
		
		}
	}
//	1 
//	0 1 
//	1 0 1 
//	0 1 0 1 
//	1 0 1 0 1
	public void the_01_triangle() {
		System.out.println("Enter the number of lines");
		int n=input.nextInt();
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<=i;j++) {
				if((i+j)%2==0)
					System.out.print(1+" ");
				else
					System.out.print(0+" ");
				
			}
			System.out.println();
		}
	}
//    	  *****
//   	 *****
//  	*****
//	  *****
//	*****
	public void solid_rhombus() {
		System.out.println("Enter the number of lines of rhombus");
		int n=input.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=i;j<n;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=n;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
// 	      *****
//  	 *   *
//      *   *
//     *   *
//    *****
	public void hollowrhombus() {
		System.out.println("Enter no. of lines in hollow rhombus");
		int n=input.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=i;j<n;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=n;k++) {
				if(i==1||i==n||k==1||k==n)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
//    1 
//   2 2 
//  3 3 3 
// 4 4 4 4 
//5 5 5 5 5 
	public void numberPyramid() {
		System.out.println("Enter the number of lines");
		int n=input.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=i;j<n;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	public void butterflypattern() {
		System.out.println("Enter n: ");
		int n=input.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(j<=i) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			for(int space=n-i;space>1;space--) {
				System.out.print(" ");
			}
			for(int star=0;star<=i;star++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0;i<n;i++) {
			for(int k=0;k<n;k++) {
				if((i+k)<n) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			for(int j=0;j<n;j++) {
				if(i<=j) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	public void diamondpattern() {
		System.out.println("Enter n: ");
		int n=input.nextInt();
		for(int i=0;i<n;i++) {
			
			for(int space=n-i;space>1;space--) {
				System.out.print(" ");
			}
			for(int star=0;star<=i;star++) {
				System.out.print("*");
			}
			for(int j=0;j<n;j++) {
				if(j<=i) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<n;j++) {
				if(i<=j) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			for(int k=0;k<n;k++) {
				if((i+k)<n) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	public void butterflyPattern2() {
		System.out.println("Enter n: ");
		int n=input.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			for(int k=1;k<=(2*(n-i));k++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=n;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			for(int k=1;k<=(2*(n-i));k++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void diamondpattern2() {
		System.out.println("Enter n:");
		int n=input.nextInt();
		for(int i=1;i<=n;i++) {
			
			for(int k=1;k<=(n-i);k++) {
				System.out.print(" ");
			}
			for(int j=1;j<2*i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=n;i>0;i--) {
			for(int k=1;k<=(n-i);k++) {
				System.out.print(" ");
			}
			for(int j=1;j<2*i;j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdvancedPattern obj=new AdvancedPattern();
//		obj.hollowRectangle();
//		obj.invertedPyramidwithnumbers();
//		obj.floydsTriangle();
//		obj.the_01_triangle();
//		obj.solid_rhombus();
//		obj.hollowrhombus();
//		obj.numberPyramid();
//		obj.butterflypattern();
//		obj.diamondpattern();
//		obj.butterflyPattern2();
		obj.diamondpattern2();
	}

}
