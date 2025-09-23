# Project structure description
All the classes can be found in `com.ncr.test.pyramid` package and its subpackages

`com.ncr.test.pyramid` contains main classes for running Our and Your solution

## Subpackage description
- data : contain data model class and appropriate factory class. (impl contains implementation of interfaces)
- solver : contains solution classes to the given task
- utils : utility classes - nothing you have worry about

## Test part of the project keeps the same logic
- For Task 1: files to apply and possibly fix build.gradle, settings.gradle
- For Task 2: class to fix  `com.ncr.test.pyramid.solver.impl.NaivePyramidSolver`
- For Task 3: class for your solution `com.ncr.pyramid.solver.impl.YourSolver`

## Benchmarking with JMH
- Benchmarks are located in `src/jmh/java`
- Use `./gradlew jmh` to run performance tests
- You can adjust benchmark parameters via the Gradle `jmh` task in `build.gradle`

### *Additional Material*
*The original test description is provided in* [`Software_Engineer_Qualification_Test.pdf`](docs/Software_Engineer_Qualification_Test.pdf)