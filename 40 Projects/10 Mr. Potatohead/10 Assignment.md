# Mr. Potatohead

*2-point deadline: Tuesday, 11 April, during class.*  
*1-point deadline: Thursday, 13 April, during class.*

## Objectives

- Create a first app!
- Practice with Git.
- Use layouts to design your user interface.

## Preparation

- On Android: [Learn Java and get started with Android Studio](/android/getting-started) and read about [Layouts](/android/layouts).
- On iOS: [Learn Swift](/ios/getting-started) and get familiar with [Layouts](/ios/layouts).

## Assessment

Your work on this problem set will be checked for full completion of the assignment and consideration of all requirements. Demo your application during office hours.

All students must ordinarily submit this and all other projects to be eligible for a satisfactory grade unless granted an exception in writing by the course's heads.

## A first app

![Screenshot of Mr. Potato Head](potato.png)

Imagine an app that displays a "Mr. Potato Head" toy on the screen. The toy has several accessories and body parts that can be placed on it, such as eyes, nose, mouth, ears, hat, shoes, and so on.

Initially your app should display only the toy's body, but if the user checks/unchecks any of the checkboxes below the toy, the corresponding body part or accessory should appear/disappear.

The way to display the various body parts is to create a separate view for each part, and lay them out so that they are superimposed on top of each other. The checkboxes should align themselves into a grid of rows and columns.

(thanks to Victoria Kirst for the original assignment idea and images!)

## Requirements

Your task is to build an app according to the description above. Besides that, there are some specific requirements to take into account:

- You should design the layout of your app using several nested views, in order to achieve a visually pleasant user interface. On iOS, you must use `UIStackView`s, and on Android, you must use `LinearLayout`s.

- Your app should support rotation of the user interface! Most phones support portrait as well as landscape. Users expect most apps to work in either orientation. Make sure that you accomodate this by positioning the user interface elements correctly in both orientations.

- Upon rotation, user's data must be preserved. If the user has enabled, for example, the nose, it should still be enabled after rotating.

## Getting started

1. Create a new project, using this pattern as a name: `studentname-pset1`.

2. No need to create original art! Here's [image files](mr-potato-head-images.zip) for each body part and accessory, such as **body.png**, **ears.png**, **hat.png**.

3. Remember to commit and push all important changes you make! 

## Android tips

- You can set whether or not an image (or any other control) is visible on the screen by setting its `android:visibility` property in the XML, and/or by calling its `setVisibility` method in your Java code. The `setVisibility` method accepts a parameter such as `View.VISIBLE` or `View.INVISIBLE`. There is also a `getVisibility` method if you need to check whether a widget is currently visible.

- You can preserve user data by using a `savedInstanceState` object.

## iOS tips

- You can set whether or not an image (or any other control) is visible on the screen by setting its `hidden` property in the Xcode designer, and/or by calling its `hidden` property in your Swift code. The `hidden` property accepts a boolean.

## How to submit

1. Add a `README.md` with screenshot and a brief description. Use Markdown to format your README, as supported by GitHub. The screenshot must be uploaded to your GitHub repository first! Do that nice and clean in a separate folder called `doc`.

2. Commit and push one last time (hopefully!).

3. Check if your project actually works for other developers! Go to the GitHub webpage for your repository and use the "Download zip" button. Unpack that zip somewhere unusual (your Desktop maybe?) and try to open and run the project.

4. When all is set, paste the GitHub repo URL in the textbox, below!
