# Mr. Potatohead

## Objectives

- Create a first app!
- Practice with Git.
- Use layouts to design your user interface.

## Preparation

- [Learn Java and get started with Android Studio](/android/getting-started), read about [Layouts](/android/layouts) and [State](/android/state). And, learn about [Git](/android/git)

## Assessment

Your work on this problem set will be checked for full completion of the assignment and consideration of all requirements. Demo your application during office hours.

All students must ordinarily submit this and all other projects to be eligible for a satisfactory grade unless granted an exception in writing by the course's heads.

## Background

![Screenshot of Mr. Potato Head](potato.png)

Imagine an app that displays a "Mr. Potato Head" toy on the screen. The toy has several accessories and body parts that can be placed on it, such as eyes, nose, mouth, ears, hat, shoes, and so on.

Initially your app should display only the toy's body, but if the user checks/unchecks any of the checkboxes below the toy, the corresponding body part or accessory should appear/disappear.

The way to display the various body parts is to create a separate view for each part, and lay them out so that they are superimposed on top of each other. The checkboxes should align themselves into a grid of rows and columns.

(thanks to Victoria Kirst for the original assignment idea and images!)

## Requirements

Your task is to build an app according to the description above. Besides that, there are some specific requirements to take into account:

- You should design the layout of your app using several nested views, in order to achieve a visually pleasant user interface. You must use `LinearLayout`s.

- Your app should support rotation of the user interface! Most phones support portrait as well as landscape. Users expect most apps to work in either orientation. Make sure that you accommodate this by positioning the user interface elements correctly in both orientations.

- Upon rotation, user's data must be preserved. If the user has enabled, for example, the nose, it should still be enabled after rotating.

## Creating your first project

<iframe src="https://player.vimeo.com/video/211268587" width="320" height="200" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>

## Getting started

1.  Create a new Android studio project, using these settings:
    - Choose API 24 (Nougat) unless your own phone has an older operating system
    - Start with an Empty Activity which is called `MainActivity`
    - Leave all other settings unchanged

2.  Create a new, empty repository on the Github website. Name your repository `Mr Potatohead`.

3.  Now, add a git repository to the project on your computer. Go to Android Studio, and in the menu choose **VCS -> Enable Version Control Integration**. Choose **git** as the type and confirm. This will not change much, but sets us up for the next steps.

    Note: if you get a popup to ask whether you would like to add some file to the repository, answer "No" for now. If you answer "Yes", things may get complicated later on.

4.  Link the local repository to your Github project. Choose **VCS -> Git -> Remotes...**. Add a remote with name "origin". You can find the URL on the Github project you just created:

    ![find the git url on the github website for the project you just created](git-url.png)

5.  Android Studio has generated quite a few files for your project already. To add these, let's **commit** and **push** those files to Github. Press **Cmd-K** or **Ctrl-K** to show the Commit Changes screen. There, you should see a long list of "unversioned files". Make sure all checkboxes are selected, enter a commit message `Initial project` and then press the **commit** button. Turn off code analysis.

6.  Press **Cmd-Shift-K** or **Ctrl-Shift-K** to show the Push Commits dialog. Press the **Push** button to send everything to Github.

Your project files should now be visible on Github like in the picture below. If not, ask for help!

![](git-files.png)


## Really getting started

For this project, we'll only work with the two most important files in your Android project: `MainActivity.java`, which contains the back-end code for your main screen; and `activity_main.xml`, which contains the definition of what the main screen looks like. You'll find them in the project sidebar:

![](file-browser.png)

No need to create original art! Here's [image files](mr-potato-head-images.zip) for each body part and accessory, such as **body.png**, **ears.png**, **hat.png**. Let's add those to the project.

1. Just for a second, switch to the Project View using this dropdown:

    ![](project-view.png)

2. Navigate to app -> src -> main -> res -> drawable. Now, drag the downloaded image files into that `drawable` folder. Android Studio will offer to move/copy them, and then to add them to your local git repository. That's all fine.

3. Jump back to the Android View using the same dropdown as in step 1. You can now use the images from your app.

## Creating the user interface

Let's now design the interface. We will try to mimic the picture at the top of this assignment as closely as possible.

1.  Double-click `activity_main.xml` in the project browser to open it. 

2.  Your view currently contains a `Label` with the text `Hello World!`. Click it and press delete to remove it from the screen.

3.  Now go to the Palette (remember where? it was in the video!). Drag an `ImageView` from the Palette to the screen layout. Immediately, a dialog pops up, allowing you to choose one of the `.png` files that you just added to the project. Start with the body!

4.  The image will resize to take up more of the screen. Reposition it to make it look right. Make sure to allow a bit of space along the borders. Android Studio should help you a little to keep nice margins.

5.  Make sure all the images are the same size and positioned right on top of each other. Currently, you can see all of them, but we'll make sure they are invisible when the app starts. Find the Attributes sidebar like in the screen shot below:

    ![](attributes.png)

    For each of the images, set the `visibility` attribute to `invisible`. It is probably listed under "favorite attributes", but if you can't find it, choose "View all attributes" all the way down the Attributes sidebar.



## Android tips

- You can set whether or not an image (or any other control) is visible on the screen by setting its `android:visibility` property in the XML, and/or by calling its `setVisibility` method in your Java code. The `setVisibility` method accepts a parameter such as `View.VISIBLE` or `View.INVISIBLE`. There is also a `getVisibility` method if you need to check whether a widget is currently visible.

- You can preserve user data by using the `onSaveInstanceState()` method. 

## How to submit

1. Add a `README.md` with screenshot and a brief description. Use Markdown to format your README, as supported by GitHub. The screenshot must be uploaded to your GitHub repository first! Do that nice and clean in a separate folder called `doc`.

2. Commit and push your code [per the instructions](/android/git).

3. Check if your project actually works for other developers! Go to the GitHub webpage for your repository and use the "Download zip" button. Unpack that zip somewhere unusual (your Desktop maybe?) and try to open and run the project.

4. When all is set, paste the GitHub repo URL in the textbox, below!
