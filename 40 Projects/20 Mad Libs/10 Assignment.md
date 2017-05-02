# Mad Libs

*2-point deadline: Tuesday, 18 April, during class.*  
*1-point deadline: Thursday, 20 April, during class.*

## Objectives

- Parse text files containing information for your app.
- Practice with the use of multiple controllers.
- Pass data between controllers.

## Preparation

- On Android: Practice [Java](/android/java) and read about [Multiple Activities](/android/multiple-activities).
- On iOS: Practice [Swift](/ios/swift) and read about [Multiple Controllers](/ios/multiple-controllers).

## Assessment

Your work on this problem set will be checked for full completion of the assignment and consideration of all requirements. Demo your application during office hours.

All students must ordinarily submit this and all other projects to be eligible for a satisfactory grade unless granted an exception in writing by the course's heads.

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

- Your app should properly display on devices of various dimensions.

- Your app should properly support rotation of the user interface.

- Your app should provide proper back navigation. In this case, when showing the final story, going "back" should immediately return to the start screen, instead of allowing to change words etc. In the concept of the game it makes no sense to be able to change the words.

- For back navigation in your app, your app must use the standard back button (Android) or a navigation controller (iOS).

## Getting started

1. For iOS: create an empty [GitHub](https://www.github.com/) repository to manage your code.

2. Create a new project, using this pattern as a name: `studentname-pset2`.

3. Share your project on GitHub. 

4. Download the provided files ([Android](madlibs_android.zip)/[iOS](madlibs_ios.zip)) and import them into your project.

5. Carefully read the provided code. What does it do? What do you still need to implement? 

6. Remember to commit and push all important changes you make! 

## Android tips

- To pass stuff around in your app, you should use an `Intent`. The Android documentation provides a brief tutorial on this.

- When creating an instance of the `Story` class you should have already opened the appropriate text file (because this task belongs to the controller). Pass a `Scanner` object to the constructor of the `Story` class.

- On top of that, when going "back" from the final screen, the user should find herself all the way back at the start screen. Use [Stack Overflow](http://stackoverflow.com/questions/27129353/android-back-navigation) to find out how.

## iOS tips

- To pass stuff around in your app, you can use the 'prepareForSegue' method. For back navigation in your app, you should use a navigation controller.

- When creating an instance of the `Story` class you should have already opened the appropriate text file (because this task belongs to the controller). Pass a `String` object to the constructor of the `Story` class.

- On top of that, when going "back" from the final screen, the user should find herself all the way back at the start screen. Use [the Apple docs](https://developer.apple.com/library/content/documentation/WindowsViews/Conceptual/ViewControllerCatalog/Chapters/NavigationControllers.html) to find out how.

## How to submit

1. Add a `README.md` with screenshot and a brief description. Use Markdown to format your README, as supported by GitHub. The screenshot must be uploaded to your GitHub repository first! Do that nice and clean in a separate folder called `doc`.

2. Commit and push one last time (hopefully!).

3. Check if your project actually works for other developers! Go to the GitHub webpage for your repository and use the "Download zip" button. Unpack that zip somewhere unusual (your Desktop maybe?) and try to open and run the project.

4. When all is set, paste the GitHub repo URL in the textbox, below!
