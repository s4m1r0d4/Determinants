/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MatrixSolvers;

import static MatrixPrinters.MatrixPrinter.printMatrix;

/**
 *
 * @author rc
 */
public class DeterminantSolver
{

    public static double[] solve(int[][] mat, int[] vals)
    {
	int n = mat.length;
	if (n == 1) {
	    return new double[]{(double) vals[0]};
	}
	
	int det = determinant(mat);
	if (det == 0) {
	    System.out.println("[ERROR] Determinant of matrix equals to zero");
	    return null;
	}

	var res = new double[n];

	for (int col = 0; col < n; ++col) {
	    var matN = new int[n][n];
	    // create a copy of mat with current col substituted with vals
	    for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
		    if (j == col) {
			matN[i][j] = vals[i];
		    } else {
			matN[i][j] = mat[i][j];
		    }
		}
	    }

	    int detN = determinant(matN);
	    res[col] = (double) detN / (double) det;
	}

	return res;
    }

    public static int determinant(int[][] a)
    {
	int n = a.length;
	// Base case
	if (n == 2) {
	    return a[0][0] * a[1][1] - a[0][1] * a[1][0];
	}

	// generate lower order matrix
	int sign = 1;
	int res = 0;

	for (int pivotCol = 0; pivotCol < n; ++pivotCol) {
	    int[][] sub = new int[n - 1][n - 1];
	    int subRow = 0, subCol;

	    for (int row = 1; row < n; ++row) {
		subCol = 0;
		for (int col = 0; col < n; ++col) {
		    if (col == pivotCol) {
			continue;
		    }
		    sub[subRow][subCol] = a[row][col];
		    ++subCol;
		}
		++subRow;
	    }

	    res += sign * a[0][pivotCol] * determinant(sub);

	    sign *= -1;
	}

	return res;
    }

}
