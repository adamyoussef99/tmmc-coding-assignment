Vertical Line Counter by Adam Youssef for TMMC

This program counts the number of vertical black lines in an image by
scanning pixels along the horizontal midpoint of the image.

Compiling:

From the project root directory:

    javac src/Main.java

Running:

    java -cp src Main some\example\path\to\img.jpg

Replace the path with the absolute path to your image file.

The program accepts exactly one argument: the path to an image file.
It outputs the number of vertical lines.
