import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/*
 *  Question 1: Social Network connectivity
 *  Given a social network containing n members and a log file 
 *  containing m timestamps at which times pairs of members formed 
 *  friendships, design an algorithm to determine the earliest time at which 
 *  all members are connected (ie, every members is a friend of a friend of a friend)
 *  Assume that the log file is sorted by timestamp and that friendship is an equivalence relation
 *  The running time of your algorithm should be mlogn or better and use extra space proportional to n
 * 
 * 
 * 
 * 
 * 
 */

public class SocialNetworkConnect {
	
	private QuickUnionUF uf;
	private int numberOfMembers;
	
	// define number of 
	public SocialNetworkConnect(int N) {
		// TODO Auto-generated constructor stub
		uf = new QuickUnionUF(N);
		numberOfMembers = N;
		
	}
	
	public void addFriend(int p, int q) {
			if (!uf.connected(p, q)) this.numberOfMembers--;
			uf.union(p, q);
			
	}
	
	
	public boolean early() {
		return this.numberOfMembers == 1;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		File log = new File("/home/han/Documents/eclipse/Union-Find/src/log.txt");
		Scanner sc = new Scanner(log);
		SocialNetworkConnect so = new SocialNetworkConnect(3);
		QuickUnionUF uf = so.uf;
		System.out.println("member = " + so.numberOfMembers);
		
		while(sc.hasNextLine()) {
			
			String line = sc.nextLine();
			String[] lineSeperate = line.split(" ");
			int p = 0,q = 0;
			String time = "";
			for(String c: lineSeperate) {
				if (c.length() == 1) {
					//System.out.println("c = " + c);
					if( p == 0) { p = Integer.parseInt(c);}
					else { q = Integer.parseInt(c); }
					
				}else if (c.length() == 3) {
					time = c;
					
				}
				
			}
			//System.out.println("p = " + p + ", q = " + q);
			so.addFriend(p, q);
			//System.out.println("member = " + so.numberOfMembers);
			//System.out.println("member max = " + uf.find(p));
			if (so.early()) {
				System.out.println("time = " + time);
				break;
			}
			
			
 			//System.out.println("line = " + line);
		}
		

	}

}
