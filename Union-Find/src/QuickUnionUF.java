/**
 * 
 */

/**
 * @author han
 * Quick-union: Java implementation
 */

public class QuickUnionUF {

	/**
	 * 
	 */
	private int[] id;
	private int[] large;
	
	public QuickUnionUF(int N) {
		// TODO Auto-generated constructor stub
		id = new int[N];
		large = new int[N];
		System.out.println("N = " + N);
		for( int i = 0; i < N; i++) 
			{
					id[i] = i;
					large[i] = i;
			}
	} 
// chase till get to the root
	private int root(int i) {
//		System.out.println("i = ng =" + i);
//		System.out.println("id[i] = ng =" + id[i]);
		while( i != id[i]) {
			// flatten the tree
			//id[i] = id[id[i]];
			i = id[i];
//			System.out.println("i = " + i);
//			System.out.println("id[i] = " + id[i]);
		}
		
		return i;
	}
	
	public boolean connected(int p, int q) {
//		System.out.println("root(p) = " + root(p));
//		System.out.println("root(q) = " + root(q));
		return root(p) == root(q);
		
	}
	
	/*
	 * Question 2: Union-find with specific canonical element. Add a method find to the union-find data 
	 * type so that find(i) returns the largest element in the connected component containing i. The operations,
	 * union(), connected(), and find() should take all logarithmic time or better
	 * 
	 * 
	 */
	
	public int find( int i) {
		return large[root(i)];
	}
	
	public void remove(int i) {
		
	}
	
	public void union(int p, int q) {
		int rootp = root(p);
		int rootq = root(q);
		int maxp = large[rootp];
		int maxq = large[rootq];
		if ( maxp < maxq) {
			large[rootp] = maxq;
		}else {
			large[rootq] = maxp;
		}
		id[p] = rootq;
	}
	
}
