//import edu.princeton.cs.algs4.QuickFindUF;
/*
 *  Question 3: Successor with delete
 *  
 *  Given a set of N integers S={0,1,2..n-1} and a sequence of requests
 *  of the following forms:
 *  - Remove x from S
 *  - Find the successor of x: the smallest y in S such that y >= x
 *  
 *  Design a data types so that all operations (except construction) should 
 *  take logarithmic time or better
 *
 * 
 * 
 */

public class SucessorDeleteElement {
	
	private QuickUnionUF uf;

	public SucessorDeleteElement(int N) {
		// TODO Auto-generated constructor stub
		uf = new QuickUnionUF(N);
	}
	
	
	public void remove(int x) {
		uf.union(x, x+1);
	}
	
	public int succesor(int x) {
		return uf.find(x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = 50;
		SucessorDeleteElement sd = new SucessorDeleteElement(50);
		System.out.println(sd.succesor(10));
//		sd.remove(11);
//		sd.remove(13);
//		sd.remove(12);
		sd.remove(10);
//		sd.remove(9);
//		sd.remove(15);
		System.out.println(sd.succesor(10));
		System.out.println(sd.succesor(8));
		System.out.println(sd.succesor(9));
		System.out.println(sd.succesor(48));
	}

}
