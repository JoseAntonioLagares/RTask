RTask
=====

A short example of the combination of RServe and JAVA

Items
=====
	exe.R
		Full script write in R. Fully working.

	RTask
		Full Project. Developed using Netbeans. Inside the latest version of Rserve library and a copy of exe.R are included.
		
Code
====
Inside the source code you might see 2 class:

	RTask.java
		The main class.
	Utils.java
		Contains useful methods inorder to resolve the task.
		
Inside utils.java there are 2 ways or function to solve the problem:

	path1
		A complete way to solve the problem using function "eval" and the text of exe.R script. By default, this option is selected.
	path2
		A different operation is done in this method. The method tries to load the full exe.R script. This method return an exception when the script is loading. Nevertheless, this method is included in order to clarify and show the proficiency in R challenges.
	


		
DataSet 
======= 
The well known dataset of Iris is used[1]. This data is loaded using the following sentences in the script:

	library(class)
	data(iris)

The data set contains 3 classes in 45 instances, where each class refers to a type of iris plant. One class is linearly separable from the other 2; the latter are not linearly separable from each other. Furthermore, the predicted attribute is the class of iris plant. 

Bibliography
============
	[1]Fisher,R.A. "The use of multiple measurements in taxonomic problems" Annual Eugenics, 7, Part II, 179-188 (1936); also in "Contributions to Mathematical Statistics" (John Wiley, NY, 1950).
	
Authors 
=======
José Antonio Lagares Rodriguez - 2014. Feel free to fork it ;)
