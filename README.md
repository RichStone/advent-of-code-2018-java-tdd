
# Advent of Code 2018 Solutions in Java 
> exercising TDD

Short notes about initial design/thoughts about how to solve the riddle, followed by things I might have tried and the 
final weapon of choice to finish a riddle off.

## Installation
It's a java gradle project, so gradle it! ;) or ask if you need any help.

## Day 1
##### Part 2  
Concepts tried: Recursion(StackOverflow)  
Solution: input to LinkedList - reset ListIterator if list walked through

## Day 2
##### Part 1
First idea: HashMap with the counts
Then: decided to solve algorithmically by sorting the String

##### Part 2
FIRST IDEAS: Some kind of tree structure? / Levenshtein algorithm   

THEN: decided to try out the runtime first with a mild brute force approach first  
RESULT: O(N) runs in a few milliseconds on the 250 entities input.

## Day 3
### Part 1
**1st Idea**
Use a variable size 2D array with ints to represent the field being 0 - empty, 
1 - used once, 2 - used twice, etc.
**2nd Idea**
We don't care about the actual field only about the intersections between ... integer arrays? 
-> Try with HashMap of field combo strings to integer.

## Meta
Richard – [@YourTwitter](https://twitter.com/gocloudgreen)
