# Inheritance

Sometimes classes of things overlap. Consider biological taxonomies: in one particular taxonomy, Metazoa is a class containing almost all animals. Eumetazoa can be subdivided into Radiata and Bilateria, where Radiata are radially symmetric animals (such as jellyfish) and Bilateria are bilaterally symmetric animals (such as tigers). However, both classes of animals share their basic cell structure, which, among other things, includes a cell nucleus. In other words, both classes *inherit* a property from a superclass.


## Exercises

- Download [AnimalTest.java](AnimalTest.java) and [StarWars.java](StarWars.java).

- Complete the exercises in [this PDF](q11.pdf).


## Tips

- To compile your java file to a `.class` file, use this command on the terminal:

        javac YourJavaFileName.java

- You can run your program using:

        java YourJavaFileName

- If you have trouble getting your Java programs to run in the IDE, try:

        sudo apt-get update
        sudo apt-get install default-jdk
