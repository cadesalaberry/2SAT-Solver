#SATSolver
=============

## COMP251

### Winter 2013

#### Homework 2


#### Question 1 ~ __/20

Your tasks is to process an input 2SAT problem and output “yes” or “no” depending on whether it is
solveable or not. Do the following:


(a) **5** Implement a brute force solution to 2SAT.

(b) **10** Implement the first 2 steps (i and ii) of the above, more efficient solution based on computing the SCC of an implication graph. Note that you only need to determine whether a solution exists or not, you do not need to actually output the assignment (ie the last 3 steps of the algorithm description are optional).

(c) **5** Under what conditions is your brute force solution better in practice than your more efficient one? Give appropriate evidence. Note that for this you will need to do some experimentation, varying both the number of variables under consideration as well as the number of disjunctions.

> The bruteforce method will be faster if a valid combination is found among the first tries, or if the sample to test has really few variables. The "smart" algorithm will take more time to process the input for it uses more lines of code.
Here as the sample csv files to graph:

		variables,	bruteforce,	smart
		5,		30,		19
		10,		41,		18
		15,		50,		30
		20,		59,		28
		25,		66,		34
		30,		74,		37
		35,		81,		42
		40,		89,		48


A program for generating arbitrary sample 2SAT instances is available in *MyCourses*, as is a basic template code for reading that output that you can use as a template for your implementations. The template allows for branching based on a *-nobrute* flag, so you can use the same codebase for both solutions.


#### Question 2 ~ __/20


A basic queue has 3 operations: *makeQueue*, *enqueue* and *dequeue*. Queues maintain a FIFO property—
first-inserted, first-out.
Suppose you want to implement a queue, but have only available a stack. Recall, a stack supports 3 operations, *makeStack*, *push* and *pop*, and acts in a LIFO (last-in, first-out) manner. Each stack operation is O(1).


(a) **10** Describe in pseudo-code an implementation of a queue based on using 2 stacks. You may use an additional O(1) space if you need. Note that you do not need to actually implement this!

> In this solution, dequeue() is designed to be the simplest possible.

	makeQueue() {
		in.makeStack()
		out.makeStack()
	}
	enqueue(E element) {
		in.push(x);
	}
	E dequeue(){
		if(out.isEmpty()) {
			while(!in.isEmpty()) {
				out.push(in.pop());
			}
		}
		return out.pop();
	}

(b) **10** The time bounds in your analysis can be improved by amortization. Come up with an appropriate potential function and prove that your implementation enables each queue operation to be performed in O(1) amortized time.

> dequeue is not O(1) worst-case because **out** might be empty and **in** may have lots of items.
Each and every element of the stack will go through 4 different steps:
* 1 *push* onto **in**,
* 1 *pop* off of **in**,
* 1 *push* onto **out**,
* 1 *pop* off of **out**

enqueue represents 1 unit of work (push) whereas dequeue represents 3 (pop, push, pop).
let *s* be the number of object in a stack.
> T_amortized(enqueue) = 1 + 1*(4 - 3) = 2
T_amortized(dequeue)   = 3 + 1*(0 - 2) = 2

The time taken while dequeuing will depend on when the last dequeue was. If dequeue and enqueue are used evenly over time, the dequeue method will take close to O(1).



#### Question 3 ~ __/10


Suppose you have an undirected graph *G* = ( *V*, *E* ), where *n* = | *V* |, and *n* is even. Prove that for all *n* ≥ 2, if every *v* ∈ *V* has *degree(v)* ≥ *n*/2 then *G* is necessarily connected.

> Assume *H* is an undirected and not connected graph with *n* = | *H* |, and *n* is even. Then we can separate *H* into two separate sets *M* and *K* that are not connected to each other with | *M* | = | *K* | = *n*/2.
Each node of *M* will be able to connect to a maximum *n*/2-1 other nodes (it cannot connect to itself). Therefore *degree(m)* < *n*/2-1.
Similarly, *degree(k)* < *n*/2-1.

>Using the **proof by contradiction**, we see that if *degree(m)* ≥ *n*/2 then *H* = ( *M*, *K* ) has to be connected.


