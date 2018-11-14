# Mad Libs

This project is less step-by-step than other projects in this course. Below, you'll find a description of the app that you're supposed to create, as well as some specific constraints and hints that you should employ while building it.


## Objectives

- Parse text files containing information for your app.
- Practice with the use of multiple controllers.
- Pass data between controllers.


## Fun with apps

"Mad Libs" are short stories that have blanks called placeholders to be filled in. In the non-computerized version of this game, you ask someone to fill in each of the placeholders without telling them anything about the overall story. Once all placeholders are filled in, you show them the resulting silly story.

The screenshots below indicate a possible flow of the UI for an app that implements this game. It has three screens: a "welcome" screen explaining the app, then a screen that repeatedly prompts the user to fill in placeholders. Once the user has typed in replacements for all these placeholders, the completed story is shown on the screen. Of course you don't need to exactly match our sample's UI, but it may give you ideas.

![](madlibs.png)

The text files represent placeholders as tokens that start and end with `<` `>` brackets, like `<adjective>` or `<proper-noun>`. Here is the text of **madlib1_tarzan.txt**, to give you an idea of the Mad Lib format:

    One of the most <adjective> characters in fiction is named "Tarzan of the
    <plural-noun> ." Tarzan was raised by a/an <noun> and lives in the
    <adjective> jungle in the heart of darkest <place> . He spends most of his
    time eating <plural-noun> and swinging from tree to <noun> . Whenever he
    gets angry, he beats on his chest and says, " <funny-noise> !" This is his
    war cry. Tarzan always dresses in <adjective> shorts made from the skin of
    a/an <noun> and his best friend is a/an <adjective> chimpanzee named
    Cheetah. He is supposed to be able to speak to elephants and <plural-noun>
    . In the movies, Tarzan is played by <person's-name> .

The code for reading the story text file, breaking it apart, looking for the placeholders, etc. is not part of the assignment. To make the assignment more manageable, we'll give you a file (see below) that you should use as a building block. If you add the `Story` class to your project, you can construct a `Story` object and it will read the text data from that source, break the text apart, and find the placeholders for you, etc. The `Story` class has other methods for filling in the placeholders later. By using this helper object, you can focus more on the important parts of this assignment and less on the string processing parts.


## Requirements

Your task is to build an app according to the description above. On top of that, there are some specific requirements to take into account:

- Your app should be built using the `Story` class.

- The user should be allowed to pick one of the stories before starting.

- Your app should properly display on devices of various dimensions.

- Your app should properly support rotation of the user interface.

- Your app should provide proper back navigation. In this case, when showing the final story, going "back" should immediately return to the start screen, instead of allowing to change words etc. In the concept of the game it makes no sense to be able to change the words.

- For back navigation in your app, your app must use the standard back button (Android).


## Getting started

1. Create a new project, using this pattern as a name: `studentname-pset2`.

2. Share your project on GitHub. 

3. Download the provided files ([Android](madlibs_android.zip)/[iOS](madlibs_ios.zip)) and import them into your project.

4. Carefully read the provided code. What does it do? What do you still need to implement? 

5. Remember to commit and push all important changes you make! 


## Android tips

<iframe src="https://player.vimeo.com/video/212705221?portrait=0" width="400" height="225" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>

- You can add the text files to your project using the following steps:

    - In the project browser, go to the "res" folder
    - Right click that folder and choose New -> Android Resource Directory
    - In the popup dialog, choose Resource type: **Raw** and press OK
    - In the Finder/Explorer, select the text files that you downloaded, and copy them using CTRL+C (Windows) or Cmd-C (Mac)
    - In Android Studio, select the Raw folder and paste using CTRL+V (Windows) or Cmd-V (Mac)
    - Allow Android Studio to copy the files

- When creating an instance of the `Story` class you should have already opened the appropriate text file (because this task belongs to the controller). Pass an `InputStream` object to the constructor of the `Story` class. You can create an input stream using the following example:

        InputStream is = getResources().openRawResource(R.raw.madlib0_simple);

- Use [Stack Overflow](http://stackoverflow.com/questions/27129353/android-back-navigation) to find out more about providing good back navigation.


## iOS tips

- To pass stuff around in your app, you can use the 'prepareForSegue' method. For back navigation in your app, you should use a navigation controller.

- When creating an instance of the `Story` class you should have already opened the appropriate text file. Pass a `String` object to the constructor of the `Story` class.

    let storyPath = Bundle.main.path(forResource: name, ofType: "txt")
    let text = try! String(contentsOfFile: storyPath, encoding: .utf8)

## Some ideas for extras

Try to make the filled-in words **bold** in the final text, like in the screen shot above.
