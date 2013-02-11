#SATSolver
=============

## COMP251

### Winter 2013

#### Homework 2


#### Question 1 (**20**)

Your tasks is to process an input 2SAT problem and output “yes” or “no” depending on whether it is
solveable or not. Do the following:


(a) **5** Implement a brute force solution to 2SAT.

(b) **10** Implement the first 2 steps (i and ii) of the above, more efficient solution based on computing the SCC of an implication graph. Note that you only need to determine whether a solution exists or not, you do not need to actually output the assignment (ie the last 3 steps of the algorithm description are optional).

(c) **5** Under what conditions is your brute force solution better in practice than your more efficient one?
Give appropriate evidence. Note that for this you will need to do some experimentation, varying both the number of variables under consideration as well as the number of disjunctions.

A program for generating arbitrary sample 2SAT instances is available in *MyCourses*, as is a basic template code for reading that output that you can use as a template for your implementations. The template allows for branching based on a *-nobrute* flag, so you can use the same codebase for both solutions.


#### Question 2 (**20**)


A basic queue has 3 operations: *makeQueue*, *enqueue* and *dequeue*. Queues maintain a FIFO property—
first-inserted, first-out.
Suppose you want to implement a queue, but have only available a stack. Recall, a stack supports 3 operations, *makeStack*, *push* and *pop*, and acts in a LIFO (last-in, first-out) manner. Each stack operation is O(1).


(a) **10** Describe in pseudo-code an implementation of a queue based on using 2 stacks. You may use an additional O(1) space if you need. Note that you do not need to actually implement this!

> In this solution, dequeue() is designed to be the simplest possible.

	makeQueue() {
		stack.makeStack()
	}	
	dequeue() {
		return stack.pop()
	}
	enqueue(element){
		// Initializes a temporary stack.
		tmpStack.makeStack()
		
		// Empties the stack.
		while ( !stack.isEmpty() ){
			tmpStack.push( stack.pop() )
		}
		
		// Pushes the element to enqueue.
		tmpStack.push(element)
		
		// Pushes back the values on the stack.
		while ( !tmpStack.isEmpty() ) {
			stack.push( tmpStack.pop() )
		}
	}




(b) **10** The time bounds in your analysis be improved by amortization. Come up with an appropriate potential function and prove that your implementation enables each queue operation to be performed in O(1) amortized time.


#### Question 3 (**10**)


Suppose you have an undirected graph *G* = ( *V*, *E*), where *n* = | *V*|, and *n* is even. Prove that for all *n* ≥ 2, if every *v* ∈ *V* has *degree(v)* ≥ *n*/2 then *G* is necessarily connected.

> Mannnnn I have no clue !


