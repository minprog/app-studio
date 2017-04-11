# Watch List

*First deadline: Tuesday, 28 February, during class (2 points).*  
*Second deadline: Tuesday, 7 March, during class (1 point).*

## Objectives

- Practice with user interface design.
- Practice with online APIs.

## Preparation

- On Android:
	- Watch the [AsyncTask](/android/asynctask) demo.
	- Read about [Persistence](/android/persistence) and [Lists](/android/lists).
- On iOS:
	- Watch the [demo](/ios/table-views).
	- Read about [Table Views](/ios/table-views).

## Assessment

Your work on this problem set will be checked for full completion of the assignment and consideration of all requirements. Demo your application during office hours.

All students must ordinarily submit this and all other projects to be eligible for a satisfactory grade unless granted an exception in writing by the course's heads.

## Helpful reminders

Remember that movie? It came out last year and you really really wanted to see it, and up until now, you totally forgot to watch it. A perfect problem to tackle with a small but powerful app!

Create an app that will help users remember which movies to watch and present this in a simple, elegant user interface. Users should be able to search for movies, read descriptions and view poster art, as well as add such titles to a list of movies to watch. And of course, they should be able to remove titles from the list as well!

![](watch.png)

But where do you get these movie titles, descriptions and poster art? There's a great resource for that: the [OMDb API](http://omdbapi.com). Make sure your app works by getting information from this API. Be creative and make use of the information provided by the API (actors, director, year, rating etc.)!

## Designing the user interface

How do you create a UI that fits well into the platform you're using? Peruse the interface guidelines and see:

- For iPhone, check out the [iOS Human Interface Guidelines](https://developer.apple.com/ios/human-interface-guidelines/)

- For Android, check out the [Material Design Documentation](https://developer.android.com/design/index.html)
	- especially [the components section](https://material.google.com/components/bottom-navigation.html) (find more about lists, for example, in the sidebar)
	- and [the patterns section](https://material.google.com/patterns/confirmation-acknowledgement.html) (find more about navigation, for example, in the sidebar)

Each of these guides provides clear recommendations of how apps are supposed to look and behave for users. If apps behave consistently with other apps, this makes them easier to learn for the user. Make sure you use these guides to choose appropriate user interface elements; for example, how should a search function normally work on your platform?

## Requirements

Your task is to build an app according to the description above. On top of that, there are some specific requirements to take into account:

- Your app should support rotation of the user interface.

- Your app should use standard list views combined with an adapter (Android) or delegation (iOS).

- Your app should save and persist the list of movies using `SharedPreferences` (Android) or `NSUserDefaults` (iOS).

- The app's back navigation should always be simple.

- No need to use the API in an efficient manner. Normally, you would cache all data that you get from the API, so not to overload it with duplicate requests as your user browses the app. For now, you can simply request the data again whenever you need it!

## Getting started

1. For iOS: create an empty [GitHub](https://www.github.com/) repository to manage your code.

2. Create a new project, using this pattern as a name: `studentname-pset3`.

3. Share your project on GitHub. 

4. Remember to commit and push all important changes you make! 

## Tips (Android)

To pass stuff around in your app, you should use an `Intent`. The Android documentation provides a brief tutorial on this. For back navigation in your app, you should use the hardware back button, not implement one in the UI.

## Tips (iOS)

To pass stuff around in your app, you can use the `prepare(for segue: UIStoryboardSegue, sender: Any?)` method. For back navigation in your app, you should use a navigation controller.

You can learn more about basic networking by reading chapter 24 of "Programming iOS 9" by Matt Neuburg (you can find this book on the shelf in A1.16).

Read more about [loading images from an URL](http://stackoverflow.com/questions/24231680/loading-image-from-url) and [Grand Central Dispatch](https://developer.apple.com/library/ios/documentation/Performance/Reference/GCD_libdispatch_Ref/index.html).

Learn more about [guards in Swift](http://ericcerney.com/swift-guard-statement/).

Converting HTTP to HTTPS (when supported by the server) can be done by inserting an 's' into the string.

## How to submit

1. Add a `README.md` with screenshot and a brief description. Use Markdown to format your README, as supported by GitHub. The screenshot must be uploaded to your GitHub repository first! Do that nice and clean in a separate folder called `doc`.

2. Commit and push one last time (hopefully!).

3. Check if your project actually works for other developers! Go to the GitHub webpage for your repository and use the "Download zip" button. Unpack that zip somewhere unusual (your Desktop maybe?) and try to open and run the project.

4. When all is set, paste the GitHub repo URL in the textbox, below!
