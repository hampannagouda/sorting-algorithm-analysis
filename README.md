🧮 Sorting Algorithm Analysis (Java)

This project demonstrates and compares the performance of five popular sorting algorithms implemented in Java — Bubble Sort, Insertion Sort, Selection Sort, Merge Sort, and Quick Sort.
It also includes a combined analysis program that measures the execution time of each algorithm for the same input.

📂 Project Structure
SortingAlgorithmAnalysis/
│
├── bubble_sort.java
├── insertion_sort.java
├── selection_sort.java
├── merge_sort.java
├── quick_sort.java
├── SortingAnalysis.java
└── README.md

🚀 How to Run Each Sorting Program
Step 1: Compile
javac bubble_sort.java

Step 2: Run
java bubble_sort

Example Input:
5
64 25 12 22 11

Output:
11 12 22 25 64


Repeat the same for all other sorting files.

⚙️ Combined Analysis Program

The main file — SortingAnalysis.java — allows you to:

Input your own array

Choose which sorting algorithm to apply

Compare all sorting algorithms and see their execution times (in nanoseconds)

🧠 Example Run
javac SortingAnalysis.java
java SortingAnalysis

Example Input:
Enter number of elements: 6
Enter array elements:
50 20 10 40 30 60
Choose an option:
6

Example Output:
Comparing all algorithms...

Algorithm        Time (ns)
-----------------------------------
Bubble Sort      16800
Insertion Sort   15200
Selection Sort   14500
Merge Sort        9800
Quick Sort        8700

✅ All algorithms produced the same sorted result: [10, 20, 30, 40, 50, 60]

🧩 Algorithms Implemented
Algorithm	     Best Case	Average Case	Worst Case	Space	Stable
Bubble Sort   	O(n)	      O(n²)	        O(n²)   	O(1)	✅ Yes
Insertion Sort	O(n)       	O(n²)	        O(n²)	    O(1)	✅ Yes
Selection Sort	O(n²)	      O(n²)	        O(n²)	    O(1)	❌ No
Merge Sort	    O(n log n)	O(n log n)	  O(n log n)O(n)	✅ Yes
Quick Sort	    O(n log n)	O(n log n)	  O(n²)	    O(log n)	❌ No
📊 Key Learnings

Understanding the working of different sorting algorithms.

Measuring and comparing real-time performance.

Analyzing algorithm efficiency in practical scenarios.

Clean and modular Java programming design.

🧠 Future Enhancements

Add graph visualization of sorting times.

Create a GUI using JavaFX.

Add Heap Sort and Counting Sort for extended comparison.

Export results as CSV or JSON.

💻 Technologies Used

Language: Java

IDE: VS Code

Version Control: Git & GitHub