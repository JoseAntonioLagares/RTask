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
		
Inside utils.java there are 2 ways or functions to solve the problem:

	"path1"
		A complete way to solve the problem using function "eval" and the text of exe.R script. By default, this option is selected.
	"path2"
		A different operation is done in this method. The method tries to load the full exe.R script. This method return an exception when the script is loading. Nevertheless, this method is included in order to clarify and show the proficiency in R challenges.

Method
======
The novel KNN algorithm is used to solve the problem. Moreover, so as to create a fully scalable program, 3 values are ajustable. These values are:

	X	Percent of the dataset destined to training. Default in 0.7 (70%).
	Y	Number of the column corresponding to the class (5,see next section for a full explanation of the dataset)
	Z	Number of neighbours considered. By default: 3.
		
DataSet 
======= 
The well known dataset of Iris is used[1]. This data is loaded using the following sentences in the script:

	library(class)
	data(iris)

The data set contains 3 classes in 45 instances, where each class refers to a type of iris plant. One class is linearly separable from the other 2; the latter are not linearly separable from each other. Furthermore, the predicted attribute is the class of iris plant. 

This dataset has 5 column

	1-Sepal Width
	2-Sepal Length
	3-Petal Width
	4-Petal Length
	5-Class
	
Bibliography
============
	[1]Fisher,R.A. "The use of multiple measurements in taxonomic problems" Annual Eugenics, 7, Part II, 179-188 (1936); also in "Contributions to Mathematical Statistics" (John Wiley, NY, 1950).
	
Authors 
=======
José Antonio Lagares Rodriguez - 2014. Feel free to fork it ;)
