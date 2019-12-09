import java.util.Scanner;

public class Matrix {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("ooo");
		int m=sc.nextInt();
		int n=sc.nextInt();
		int m1[][]= new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				m1[i][j]=sc.nextInt();
			}
		}
		Sol s=new Sol();
		System.out.println(s.trans(m1,m,n));
		
		
		
		/*for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.println(m1[j][i]+ "\t");
			}
		}*/
	}
}
	
		