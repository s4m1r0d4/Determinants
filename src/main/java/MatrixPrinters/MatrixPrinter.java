/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MatrixPrinters;

/**
 *
 * @author rc
 */
public class MatrixPrinter
{

    public static void printMatrix(int[][] matrix)
    {
	int n = matrix.length;
	int numLen = maxDigits(matrix);
	String format = String.format("%%%dd ", numLen);

	for (int i = 0; i < n; ++i) {
	    System.out.print("| ");
	    for (int j = 0; j < n; ++j) {
		System.out.printf(format, matrix[i][j]);
	    }
	    System.out.println("|");
	}
    }

    public static void printSystem(int[][] matrix, int[] vals)
    {
	int numLen1 = maxDigits(matrix);
	int numLen2 = maxDigits(vals);

	String format1 = String.format("%%%dd ", numLen1);
	String format2 = String.format("| | %%%dd |\n", numLen2);

	for (int i = 0; i < matrix.length; ++i) {
	    System.out.print("| ");
	    for (int j = 0; j < matrix[i].length; ++j) {
		System.out.printf(format1, matrix[i][j]);
	    }
	    System.out.printf(format2, vals[i]);
	}

    }

    public static int maxDigits(int[] arr)
    {
	int res = 0;

	for (int i = 0; i < arr.length; ++i) {
	    int ai = (arr[i] < 0) ? -arr[i] : arr[i];

	    int x = 0;
	    while (ai > 0) {
		++x;
		ai /= 10;
	    }
	    if (x == 0) x = 1;
	    if (arr[i] < 0) ++x;
	    
	    if (x > res) res = x;
	}

	return res;
    }

    public static int maxDigits(int[][] mat)
    {
	int numLen = 1;
	for (int i = 0; i < mat.length; ++i) {
	    numLen = Integer.max(numLen, maxDigits(mat[i]));
	}
	return numLen;
    }
}
