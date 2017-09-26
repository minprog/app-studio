# Track List

## Objectives

- Practice with user interface design.
- Practice with asynchronous code.
- Practice with online APIs.

## Preparation

- On Android: [AsyncTask](/android/asynctask), [Persistence](/android/persistence) and [Lists](/android/lists).


## Assessment

Your work on this problem set will be checked for full completion of the assignment and consideration of all requirements. Demo your application during office hours.

All students must ordinarily submit this and all other projects to be eligible for a satisfactory grade unless granted an exception in writing by the course's heads.


## What to do
Create an app that will help users remember which songs to listen to and present this in a simple, elegant user interface. Users should be able to search for songs, read other information about the song such as artist, album, as well as add such songs to a list of songs to listen to. And of course, they should be able to remove songs from the list as well!


## API

How are we going to get a list of songs? To get this information, we will make use of the Last FM API. To use this API, you will first have to [register](https://www.last.fm/api/account/create), so that you can obtain an API key: 

The documentation for the API can be found [here](https://www.last.fm/api/intro). For example, the artist search and track search could be of interest to you! No need to perform any user authentication.

A typical API request might look like this: `http://ws.audioscrobbler.com/2.0/?method=track.search&track=Believe&api_key=YOUR_API_KEY&format=json`. Keep in mind we have to specify the JSON format as we are parsing JSON in our asynctask, as the standard return format of this API is XML, not JSON.

Note: no need to use the API in an efficient manner. Normally, you would cache all data that you get from the API, so not to overload it with duplicate requests as your user browses the app. For now, you can simply request the data again whenever you need it! Do try to not overload the API with requests though, as this might get you blocked from usage.


## Designing the user interface

How do you create a UI that fits well into the platform you're using? Peruse the interface guidelines and see. For Android, check out the [Material Design Documentation](https://developer.android.com/design/index.html)
	- especially [the components section](https://material.google.com/components/bottom-navigation.html) (find more about lists, for example, in the sidebar)
	- and [the patterns section](https://material.google.com/patterns/confirmation-acknowledgement.html) (find more about navigation, for example, in the sidebar)

Each of these guides provides clear recommendations of how apps are supposed to look and behave for users. If apps behave consistently with other apps, this makes them easier to learn for the user. Make sure you use these guides to choose appropriate user interface elements; for example, how should a search function normally work on your platform?


## Requirements

Your task is to build an app according to the description above. On top of that, there are some specific requirements to take into account:

- Your app should properly display on devices of various dimensions.

- Your app should properly support rotation of the user interface (no data loss).

- Your app's back navigation should always be simple.

- Your app should use standard list views combined with an adapter.

- Your app should save and persist the list of movies using `SharedPreferences`.

- Listeners may not be anonymous as of now, see the exercise about Listeners.

- Users should be able to search for songs as well as artists.

- Your "to listen" list may not allow users to add duplicate songs and must notify the user elegantly. 


## Getting started

1. Create an empty [GitHub](https://www.github.com/) repository to manage your code.

2. Create a new project, using this pattern as a name: `studentname-pset3`.

3. Share your project on GitHub. 

4. Remember to commit and push all important changes you make! 


## Tips (Android)

- If you need to handle events other than `onClick`, you might need to implement a listener class. Do not use an anonymous listener class (as is often used on Stack Overflow)! Instead, use a named listener class. [Here's an example](http://www.fredosaurus.com/notes-java/GUI/events/inner_class_listener.html).


## How to submit

1. Add a `README.md` with screenshot and a brief description. Use Markdown to format your README, as supported by GitHub. The screenshot must be uploaded to your GitHub repository first! Do that nice and clean in a separate folder called `doc`.

2. Commit and push one last time (hopefully!).

3. Check if your project actually works for other developers! Go to the GitHub webpage for your repository and use the "Download zip" button. Unpack that zip somewhere unusual (your Desktop maybe?) and try to open and run the project.

4. When all is set, paste the GitHub repo URL in the textbox, below!
