
## Implementation details

* The layout of your user interface should work on both tablets and phones, in portrait and landscape modes.

* You must use the contents of `words.plist` (iOS) or `words.xml` (Android) as your universe of possible words. You're welcome, but not required, to transform it into some other format (e.g., SQLite).

* You must implement your app's two strategies for gameplay (evil and non-evil) in two separate model classes called EvilGameplay and GoodGameplay (in files called EvilGameplay.{h,m} and GoodGameplay.{h,m}, respectively) both of which must implement a protocol called GameplayDelegate (which must be declared in a file called GameplayDelegate.h). In other words, based on whether evil is enabled or disabled, your app should pass messages to an instance of one class or the other.

* You must implement your app's two strategies for gameplay (evil and non-evil) in two separate model classes called EvilGame and GoodGame, both of which must implement a protocol/interface called GameplayDelegate. In other words, based on whether evil is enabled or disabled, your app should pass messages to an instance of one class or the other.

* Your app must come with default values for the app's three settings; those defaults should be set through a PreferenceActivity.

* Your app must come with default values for the flipside's two settings; those defaults should be set in NSUserDefaults with registerDefaults:. Anytime the user changes those settings, the new values should be stored immediately in NSUserDefaults (so that changes are not lost if the application is terminated).

* On iOS, those defaults should be set in `NSUserDefaults`. On Android, those defaults should be set in `SharedPreferences`.

* You must implement each of the flipside's numeric settings with a UISlider. Each slider should be accompanied by at least one UILabel that reports its current value (as an integer).

* You must implement the flipside's evil toggle with a UISwitch.

* You must obtain a user's guesses via a UITextField (and the on-screen keyboard that accompanies it). For the sake of aesthetics, you are welcome, but not required, to keep that UITextField hidden (so long as the on-screen keyboard works). You are also welcome, but not required, to respond to user's keypresses instantly, without waiting for them to hit return or the like, in which case textField:shouldChangeCharactersInRange:replacementString in the UITextFieldDelegate protocol might be of some interest.

* You must implement the display of high scores in a UIViewController called HistoryViewController (in files called HistoryViewController.{h,m,xib}) that presents itself at game's end via a UIModalTransitionStyleCoverVertical transition. You must also declare a HistoryViewControllerDelegate protocol (in HistoryViewController.h) that MainViewController implements, much like FlipsideViewController.h declares FlipsideViewControllerDelegate.

* You must implement methods with which to store and retrieve high scores in a model called History(asbycreatingHistory.{h,m}files). Youmuststorehighscorespersistently,as in a property list (other than words.plist) or in some other format (e.g., SQLite).

* You must implement unit tests for your models.

* Your app must work within the iPhone 5.1 Simulator; you need not test it on
  actual hardware. However, if you or your partner owns an iPad, iPhone, or
  iPod touch, and you'd like to install your app on it, see
  https://manual.cs50.net/iOS for instructions.

# Design document #



This milestone consists of delivering a technical design for your app. It
should convey the way your app fits into the platform you are building on, and
the specific design choices you make.

> Don't get involved in partial problems, but always take flight to where there is a free view over the whole single great problem, even if this view is still not a clear one. --- Wittgenstein, journal entry (1 November 1914)

The design document should somehow capture any and all design decisions that
you make before (or while) implementing your app. Reasonable to incude in your
design doc might be:

* Consolidated sketches of each "screen" in the application, along with the name of the controller that will manage each screen (each sketch should be a separate PNG).

    The idea is that there is one sketch for each controller of the app. This time, interactions are not relevant, but more so the specific controls that are needed on each screen, including tabs, menus, etc..

* An overview of model classes, private data for each class, and *public* methods (and their return types and/or arguments) that you've decided to implement. See [this page](http://www.agilemodeling.com/artifacts/classDiagram.htm) for a head start!

* A list of any APIs and frameworks that have not yet been named in the above, along with a description of what these will be used for. What kind of APIs do you need in the model classes? Maybe for persistence?

Be sure to update your README if you have made some incompatible decisions in
your design document. During the course, you can update all documentation at any time.

Add the design doc to your project on GitHub in a directory named `doc`. Like
the README, the design doc should be written in Markdown, so check out the
[syntax] again if needed. Put images in the same directory and embed them in your document.

[syntax]: http://daringfireball.net/projects/markdown/syntax
