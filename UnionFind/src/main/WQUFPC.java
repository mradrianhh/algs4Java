/**
 * 
 */
package main;

/**
 * @author Adrian Hardy Hansen
 *
 * Weighted quick union find with path compression.
 * Best approach. Keeps all the trees in the forest nearly flat.
 *
 */
public class WQUFPC implements UnionFind {

	private int[] id;
	private int[] sz;
	
	public WQUFPC(int N) {
		id = new int[N];
		sz = new int[N];
		
		for(int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	private int root(int i) {
		while(i != id[i]) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return id[i];
	}

	@Override
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	@Override
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if(i == j) {
			return;
		}
		if(sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		}
		else {
			id[j] = i;
			sz[i] += sz[j];
		}
	}

}
