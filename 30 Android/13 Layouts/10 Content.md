# Layouts

First some terminology of **graphical user interfaces** in Android:

- An **activity** is a single screen that appears in your app. Essentially, these are the fundamental units into which developers decompose their application ideas.

- Activities are composed of **view**s:
    - **controls**: views that the user can interact with, like buttons
    - **layouts**: invisible view that manages the positions of other views

- When our users interact with controls, **events** may trigger, representing for example key presses, mouse clicks or scrolling actions. Some controls have very specific types of **events**. You can attach **event handers** to specific events. This makes a connection between the layout and your code.

- Two widgets that are not so common on other operating systems, but use often on Android:
    - **action bars**: the menu near the top of the screen that allows for common actions
    - **notification areas**: the small menu at the very top of the screen, managed by the system

<iframe src="https://player.vimeo.com/video/211268580" width="320" height="200" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>

## Tutorials to get you started

- Read all about [layouts](https://developer.android.com/guide/topics/ui/declaring-layout.html) on the Android website.

- This [Android Basic Layout](http://www.journaldev.com/9495/android-layout-linearlayout-relativelayout-example-tutorial) tutorial covers all basic types of layout and offers you some sample code to experiment with. Try to fully understand what you are using, don't just blindly copy the contents!

## Situational layouts

Your app can use different layouts in different situations:

- different device type (tablet vs phone vs watch)
- different screen size
- different orientation (portrait vs. landscape)
- different country or locale (language, etc.)

For example, to create a different layout in landscape mode, you can add a new layout XML file:

- create a folder in your project called `res/layout-land`
- place a copy of your activity's layout XML file there
- modify it as needed to represent the differences

![Screen shot of adding layout XML file](layoutxml.png)

## Action bar

![Android Action Bar](https://developer.android.com/images/training/appbar/appbar_sheets.png)

In addition to layouts, the Android Action Bar (also: *App Bar*) is an important part of the GUI. For a better understanding of the App Bar, follow the steps in this short [Action Bar](http://www.journaldev.com/9357/android-actionbar-example-tutorial) tutorial.
