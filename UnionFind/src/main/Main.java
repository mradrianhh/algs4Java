/**
 * 
 */
package main;

import main.WQUFPC;

/**
 * @author Adrian Hardy Hansen
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WQUFPC qu = new WQUFPC(10);
		System.out.println(qu.connected(0, 9));
		qu.union(0, 9);
		System.out.println(qu.connected(0, 9));
	}

}
