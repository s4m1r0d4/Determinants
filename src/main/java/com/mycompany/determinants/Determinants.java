/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.determinants;

import static MatrixPrinters.MatrixPrinter.printSystem;
import MatrixSolvers.DeterminantSolver;
import java.util.Scanner;

/**
 *
 * @author rc
 */
public class Determinants
{

    static int[][] matrix;
    static int[] vals;

    public static void main(String[] args)
    {
	readMatrix();

	System.out.println("System read:");
	printSystem(matrix, vals);

	var results = DeterminantSolver.solve(matrix, vals);
	if (results == null) {
	    return;
	}

	for (int i = 0; i < results.length; ++i) {
	    System.out.printf("a%d = %f\n", i + 1, results[i]);
	}
    }

    public static void readMatrix()
    {
	System.out.println("Please enter the number variables in the system of equations: ");
	Scanner scanner = new Scanner(System.in);
	int n = scanner.nextInt();

	matrix = new int[n][n];
	vals = new int[n];

	System.out.println("\nPlease enter %d distinct equations ");

	for (int i = 0; i < n; ++i) {
	    for (int j = 0; j <= n; ++j) { // we read n+1 numbers because we are reading the vals n*1 matrix
		int x = scanner.nextInt();
		if (j == n) {
		    // read value in vals matrix
		    vals[i] = x;
		    continue;
		}
		// read value in the regular matrix
		matrix[i][j] = x;
	    }
	}
    }

}
