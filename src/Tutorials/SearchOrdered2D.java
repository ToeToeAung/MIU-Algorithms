package Tutorials;
public class SearchOrdered2D {
	public static void printLocation(int row, int col) {
		System.out.println("Key is at (" + row + "," + col + ")");
	}
	public static boolean search(int[][] M, int lr, int hr, int lc, int hc, int key) {
		boolean found = false; 
		if (lr == hr && lc == hc) {
			if (M[lr][lc] == key) {
				printLocation(lr, lc);
			    return true;
			}
		}
		else if (lr == hr) {
			int mc = (lc + hc)/2;
			if (M[lr][mc] == key) {
				printLocation(lr, mc);
			    return true;
			} else if (M[lr][mc] < key) {
				return search(M, lr, hr, mc + 1, hc, key);
			} else 
				return search(M, lr, hr, lc, mc, key);
		}
		
		else if (lc == hc) {
			int mr = (lr + hr)/2;
			if (M[mr][lc] == key) {
			printLocation(mr, lc);
		    return true;
			} else if (M[mr][lc] < key) {
			return search(M, mr + 1,  hr, lc, hc, key);
		} else 
			return search(M, lr, mr, lc, hc, key);
		}
		else {
			int mc = (lc + hc)/2;
			int mr = (lr + hr)/2;
			if (M[mr][mc] == key) {
				printLocation(mr, mc);
			    return true;
			} else if (M[mr][mc] < key) { 	
				found = search(M, mr + 1, hr , lc, mc, key);
				if (!found) found = search(M, lr, mr, mc + 1, hc, key);
				if (!found) found = search(M, mr + 1, hr , mc + 1, hc, key);
				return found;
			}
			else if (M[mr][mc] > key) { 	
				found = search(M, mr + 1, hr , lc, mc, key);
				if (!found) found = search(M, lr, mr, mc + 1, hc, key);
				if (!found) found = search(M, lr , mr, lc, mc, key);
				return found;
			}
		}	
		return found;
	}
	
	public static void main(String[] args) {
		int nRows = 5;
		int nCols = 6;
		int[][] matrix = {	{1,  3,   4,  10, 21, 22},
							{2,  5,   9,  11, 31, 41},
							{6,  8,   12, 15, 51, 52},
							{7,  13,  14,  16, 65, 70},
							{17, 18,   19, 20, 66, 71}}; 
		int keyValue = 70;
		boolean found = search(matrix, 0, nRows-1, 0, nCols-1, keyValue);
		if (!found) System.out.println("Key not found");
	}
}