# Mr. Potatohead

*Due: Sunday night, April 17, 2016.*

## Objectives

- Practice with Git.
- Create a first app!
- Use layouts to design your user interface.
- Connect the user interface to your code.
- Support multiple screen orientations in your app.

## Preparation

- TODO Link to iOS week 1 information page
- TODO Link to Android week 1 information page

## Assessment

Your work on this problem set will be evaluated along four axes primarily.

Scope
: To what extent does your code implement the features required by our specification?

Correctness
: To what extent is your code consistent with our specifications and free of bugs?

Design
: To what extent is your code written well (i.e., clearly, efficiently, elegantly, and/or logically)?

Style
: To what extent is your code readable (i.e., commented and indented with variables aptly named)?

All students must ordinarily submit this and all other problem sets to be eligible for a satisfactory grade unless granted an exception in writing by the course’s heads.

## A first app

![Screenshot of Mr. Potato Head](potato.png){:.inline}

Imagine an app that displays a "Mr. Potato Head" toy on the screen. The toy has several accessories and body parts that can be placed on it, such as eyes, nose, mouth, ears, hat, shoes, and so on.

Initially your app should display only the toy's body, but if the user checks/unchecks any of the checkboxes below the toy, the corresponding body part or accessory should appear/disappear.

The way to display the various body parts is to create a separate view for each part, and lay them out so that they are superimposed on top of each other. The checkboxes should align themselves into a grid of rows and columns.

(thanks to Victoria Kirst for original assignment idea and images!)

## Requirements

Your task is to build an app according to the description above. On top of that, there are some specific requirements to take into account:

- You should design the layout of your app using several nested views, in order to achieve a visually pleasant user interface.

- Your app should support rotation of the user interface! Most phones support portrait as well as landscape. Users expect most apps to work in either orientation. Make sure that you accomodate this by positioning the user interface elements correctly in both orientations.

## Getting started

1. To get started, you'll make a Git repository to manage your code. ...

2. Start Android/Xcode.

3. New project - name: martijn-week1

4. We will provide you with [image files](mr-potato-head-images.zip) for each body part and accessory, such as **body.png**, **ears.png**, **hat.png**, and so on.

## Implementation details (Android)

You can set whether or not an image (or any other widget) is visible on the screen by setting its `android:visibility` property in the XML, and/or by calling its `setVisibility` method in your Java code. The `setVisibility` method accepts a parameter such as `View.VISIBLE` or `View.INVISIBLE`. There is also a `getVisibility` method if you need to check whether a widget is currently visible.

## Implementation details (iOS)

You can set whether or not an image (or any other view) is visible on the screen by setting its `hidden` property in the Xcode designer, and/or by calling its `hidden` property in your Swift code. The `hidden` property accepts a boolean.

## How to submit

1. Add README with screenshot and a brief description (markdown).
2. Commit and push.
3. Download zip file from GitHub and check if it still works.
4. Paste the GitHub repo URL below, in the textbox!

Julian moet zijn Git video nog losknippen.
