package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: This is your 3rd task.
 * Please implement the class to satisfy the interface. *
 */
public class YourSolver implements PyramidSolver {

    /**
     * Iterative implementation of {@link PyramidSolver}
     *
     * <p>Calculates the maximum path sum in a pyramid by starting from the top row
     * and propagating the maximum achievable sums downward until reaching the bottom</p>
     */
    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        int rows = pyramid.getRows();

        // Stores the maximum path sums for each position in the current row
        long[] maxSums = new long[rows];

        // Initialize maxSums with the values from the top row
        for (int column = 0; column < rows; column++) {
            maxSums[column] = pyramid.get(0, column);
        }

        // Iterate through each row from top to bottom
        for (int row = 1; row < rows; row++) {
            // Iterate each element in the current row
            for (int column = 0; column < rows - row; column++) {
                int currentField = pyramid.get(row, column);
                long leftChild = maxSums[column];
                long rightChild = maxSums[column + 1];
                // Update with the maximum sum including the current value
                maxSums[column] = currentField + Math.max(leftChild, rightChild);
            }
        }

        // Final maximum path sum
        return maxSums[0];
    }
    
}
