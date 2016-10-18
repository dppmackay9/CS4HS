Contains search algorithms written in Java

##Purpose of this Repository
In December 2015, I volunteered as an Outreach Assistant for a Google and Victoria University hosted event called CS4HS. 
The event's purpose was to inform teachers about some topics in computer science which could potentially be taught as an NCEA standard.
This program was written for a presentation. It contains methods which use different types of searching and sorting algorithms. 
Just note that the code written contains the fundamental ideas of the searching and sorting algorithms used. It has to be modified to suit 
your purpose. Feel free to fork or download this repository.

##Current Search Algorithms in Repository:
- Linear Search
- Binary Search
- Interpolation Search

##Current Sorting Algorithms in Repository
- Selection Sort
- Insertion Sort
- Merge Sort

## DESCRIPTION

### SEARCH ALGORITHMS

####Linear Search Description:

- Slowest form of searching algorithm
- Extremely simple to implement
- Searches all the elements one by one from the beginning of the array

####Binary Search Description:
- Looks at the mid point and keeps dividing the data in halves until it finds the item.
- Can only be implemented if the data is already sorted (otherwise it produces logic errors).

####Interpolation Search Description:
- Acts just like binary search
- Best implemented if the data is uniformly sorted
- Uses a constant "k" to calculate a rough location of the item you want
- k = (ITEM - Array[low]) / (Array[high] - Array[low])
- mid point = low + k* (high - low)

###SORTING ALGORITHMS

####Selection Sort Description:
- An in-place comparison sort
- Inefficient on large sets of data
- Noted for its simplicity

####Insertion Sort Description:
- Not efficient for large lists
- Best case is when the data is already sorted
- Best used when the data is almost sorted
- It's slightly quicker than selection sort due to its early exit.
- Stable sorting algorithm

####Merge Sort Description
- Stable sorting algorithm
- Halves the data and then merges the two halves together to sort them
- Constant complexity in all cases (halves and merges, no matter how large or small the data is)

## PERFORMANCE
The performance of the search algorithms will be represented by the Landau's symbol, otherwise known as the "Big O Notation". The Big O Notation is used to symbolse the complexity and performance of the algorithm in computer science and in mathematics, it is used to describe the asymptotic behaviour of functions. The big O notation tells you how fast the function grows or declines. 

If you want to know more information about the Big-O Notation, visit:
http://web.mit.edu/16.070/www/lecture/big_o.pdf

#### Performance of Linear Search

- Best Case: It found the item at the very first index of the array, O(1).
- Worst Case: The item is at the very last index of the array, O(n)
- Average Case: The item is in the middle of the array, O(n/2)

#### Performance of Binary Search
- Best Case: When the item you want is directly in the middle O(1)
- Worst Case: Binary search is searching for the item that is not in the list. It will keep dividing data in half until it doesn't have anything to divide anymore. O(log n)
- Average Case: Binary search is searching for something which is inside the list but it's not directly in the middle O(log n)

#### Performance of Interpolation Search
- Best Case: When the data is uniformly distributed O(log log n)
- Worst Case: data is not uniformly distributed O(n)
- Average Case: data is somewhat uniformly distributed O(log n)

#### Performance of Selection Sort:
- Best Case: O(n^2)
- Worst Case: O(n^2)
- Average Case: O(n^2)
It's the same for all cases because selection sort looks through the elements N * M times due to two loops used

#### Performance of Insertion Sort:
- Best Case: When data is already sorted; O(n)
- Worst Case: When data is reversed: O(n^2)
- Average Case: When the data is partially sorted O(n^2)

#### Performance of Merge Sort:
- Best Case: O(log n)
- Worst Case: O(log n)
- Average Case: O(log n)
It's the same for all cases because merge sort only halves and then merges the list no matter how big or small it is.
