## Access modifiers in Android

We have seen three types of modifiers related to the way variables are accessed. Each of these concepts came with its own keywords.

- The location from which classes, variables or methods can be accessed it determined through the absence of a keyword, `public`, `protected` or `private`. 

- Determining whether a variable is an instance variable or belongs to the class as a whole is done using the `static` keyword.

- Denoting a constant is done using the `final` keyword, which makes the variable immutable and comes with its own naming conventions.  

 These three can be combined to fit your specific needs. This for example, is valid syntax:

        public static final String UNIVERSITY_NAME = "University of Amsterdam";

We also saw that to define multiple constants, the `enum` is an elegant solution that helps avoid wrong assignments, simplifies iteration of the possible values and is easy to use inside a `Switch` statement. 

All above concepts are applicable in Android Studio as well. Most auto-generated classes and methods have some kind of access modifier specified. 
A specific error related to this that you might see in Android studio is:

"Non-static method cannot be referenced from a static context"

This means that you are probably invoking a method as if it were a static method, but it is actually an instance method instead! This is clearly illustrated by the following example that would invoke this error:

    TextView.setText("nice");

While `setText()` can indeed be called on objects of the type `TextView`, the above line of code does not refer to an instance of `TextView`, but rather to the class as a whole. It does not know what `TextView` in the layout you are referring to at all. Invocations of this kind and similar cause the error above. So when using methods associated with a certain class, pay attention to whether you are using an instance method or a static method!

Another things that you need to pay attention to is the location of your files. When working with your own classes in Android, it's important that you place them in the same package as the rest of your code for ease of access. Your Java files will be contained in the directory located under `app > java > com.example.yourname.yourappname`. This is where your `Activity` Java files are located, but model classes like `Student` can be placed here as well! This directory is also visible in Android studio in the menu on the left:

![An image depicting the file tree as shown in Android Studio, with the package folder highlighted](Images/paste-location.png)

The IDE allows for different depictions of the files representing your app. If yours does look different, try switching the mode to 'Android' instead by using the dropdown in the top left corner as shown in the image above. 

When right clicking this directory, you can easily create a new Java class, which after allows you to to select `enum` in a dropdown as well. For activities however, it's best to go with `New > Activity > Empty Activity` since this also generates the required layout files and standard methods for you. 
