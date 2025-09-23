package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: There is something wrong here. A few things actually... 
 */
public class NaivePyramidSolver implements PyramidSolver {
    private long[][] cache;
    private boolean[][] computed;

    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        int rows = pyramid.getRows();
        cache = new long[rows][rows];
        computed = new boolean[rows][rows];

        return getTotalAbove(rows - 1, 0, pyramid);
    }

    private long getTotalAbove(int row, int column, Pyramid pyramid) {
        // Fixed the base condition to ensure the top row value is processed
        if (row == -1) return 0;

        // Use memoization to prevent exponential recursion growth and potential StackOverflowError
        if (computed[row][column]) return cache[row][column];

        int myValue = pyramid.get(row, column);
        long left = myValue + getTotalAbove(row - 1, column, pyramid);
        long right = myValue + getTotalAbove(row - 1, column + 1, pyramid);
        long max = Math.max(left, right);

        cache[row][column] = max;
        computed[row][column] = true;
        return max;
    }

}