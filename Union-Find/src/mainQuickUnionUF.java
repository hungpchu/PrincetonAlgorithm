
public class mainQuickUnionUF {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QuickUnionUF qu = new QuickUnionUF(10);
		
		// 1 will be the parent of 0
		qu.union(0,1);
		// 0 will be  the parent of 2
		qu.union(2,0);
		
		
		System.out.println(qu.connected(2, 0));
		

	}

}
