# GraphingCalculator
A simple graphing calculator.
## Requirements
This program requires Java 20, Python 3.10 and Matplotlib 3.8.1 to run.
## Supported operations
This program supports the following operations:
* Sum (+)
* Difference (-)
* Multiplication (*)
* Division (/)
* Power (^)
## Supported functions
This program supports the following functions:
* Sine (sin)
* Cosine (cos)
* Tangent (tan)
* Natural logarithm (ln)
* Exponent (exp)
* Square root (sqrt)
## Running the program
To run the program, execute it with the following command:
```
java -jar GraphingCalculator.jar
```
![running_example](screenshots/running.png)
## Tree example
This program parses a mathematical expression into a syntax tree. Below is an example of a syntax tree for expression 2*x*sin(x - 1) + ln(x + 2) generated with [graphviz](https://dreampuf.github.io/GraphvizOnline).
![tree_example](screenshots/tree.png)
## Plot example
The picture below shows a plot for expression 2*x*sin(x - 1) + ln(x + 2).
![plot_example](screenshots/plot.png)
## Error examples
This program can show error popups, there are some examples below.
![error_bad_double](screenshots/error_bad_double.png)
![error_bad_limit](screenshots/error_bad_limit.png)
![error_unresolved_function](screenshots/error_unresolved_function.png)
