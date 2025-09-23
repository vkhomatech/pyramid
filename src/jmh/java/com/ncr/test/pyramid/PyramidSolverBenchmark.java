package com.ncr.test.pyramid;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.data.impl.RandomPyramidGenerator;
import com.ncr.test.pyramid.solver.PyramidSolver;
import com.ncr.test.pyramid.solver.impl.NaivePyramidSolver;
import com.ncr.test.pyramid.solver.impl.YourSolver;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class PyramidSolverBenchmark {
    private static final int MAX_DEPTH = 5_000;
    private Pyramid demoPyramid;
    private PyramidSolver recursiveSolver;
    private PyramidSolver iterativeSolver;

    @Setup(Level.Iteration)
    public void setup() {
        var pyramidGenerator = new RandomPyramidGenerator(MAX_DEPTH, 1000);
        int[][] data = pyramidGenerator.generatePyramid().getData();
        demoPyramid = new Pyramid(data);
        recursiveSolver = new NaivePyramidSolver();
        iterativeSolver = new YourSolver();
    }

    @Benchmark
    public long recursive() {
        return recursiveSolver.pyramidMaximumTotal(demoPyramid);
    }

    @Benchmark
    public long iterative() {
        return iterativeSolver.pyramidMaximumTotal(demoPyramid);
    }

}