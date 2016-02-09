# Layouts

The purpose of this assignment is to practice more advanced graphical layouts
than you did last week, as well as using more kinds of views in a graphical
user interface.

If you'd like, feel free to improve on the app, as long as the layout stays at least as complicated as described below!

![Screenshot of Mr. Potato Head](potato.png){:.inline}

(thanks to Victoria Kirst for original assignment idea and images!)

Write an app that displays a "Mr. Potato Head" toy on the screen as an
`ImageView`. The toy has several accessories and body parts that can be placed
on it, such as eyes, nose, mouth, ears, hat, shoes, and so on. We will provide
you with [image files](mr-potato-head-images.zip) for each body part and
accessory, such as **body.png**, **ears.png**, **hat.png**, and so on.
Initially your image view should display only the toy's body, but if the user
checks/unchecks any of the check boxes below the toy, the corresponding body
part or accessory should appear/disappear.

The way to display the various body parts is to create a separate ImageView for
each part, and lay them out so that they are superimposed on top of each other.
You can achieve this with a **RelativeLayout** (Android) or **StackView**s
(iOS) in which you give every image the same position, though you should
probably nest it in some other overall layout for the screen. The check boxes
should align themselves into a grid of rows and columns.

On *Android*, you can set whether or not an image (or any other widget) is
visible on the screen by setting its `android:visibility` property in the XML,
and/or by calling its `setVisibility` method in your Java code. The
`setVisibility` method accepts a parameter such as `View.VISIBLE` or
`View.INVISIBLE`. There is also a `getVisibility` method if you need to check
whether a widget is currently visible.

On *iOS*, you can set whether or not an image (or any other view) is visible on
the screen by setting its `hidden` property in the Xcode designer, and/or by
calling its `hidden` property in your Swift code. The `hidden` method accepts a
boolean.

*Requirement*: your app has to support rotation of the user interface! Most phones support portrait as well as landscape orientation. Make sure that you accomodate this by positioning the user interface elements correctly in both orientations.
