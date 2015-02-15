# Ghost

Your challenge for this project is to implement the game of Ghost as a native iOS app. The overall design and aesthetics of this app are ultimately up to you, but we require that your app meet some requirements. All other details are left to your own creativity and interpretation.

Ghost is an inanely popular two-player wordgame. Our goal in this problem is to
implement an interactive Python program that allows two humans to play a game
of Ghost against each other. For those of you who are unfamiliar with the
rules, you may read all about it here at
[Wikipedia](http://en.wikipedia.org/wiki/Ghost_(game)). For this project,
please follow the following rules.

## Rules of Ghost

Players form a word by alternating turns saying a letter, which is added on to the end of the word fragment. There are two ways to lose Ghost:

* Forming a word longer than 3 letters ("PEA" is ok, but "PEAR" is not).
* Creating a fragment (of any size) which cannot become a word by adding more letters (for example, "QZ").

Winning Ghost is simply not losing! So, for example, game play proceeds like this:

* Player 1 says a letter. For example, 'P'.
* Player 2 says a letter. For example, 'E'.
* Player 1 says a letter. For example, 'A'. Player 1 has formed the word PEA, but that's okay because it is not longer than 3 letters.
* Player 2 says a letter. For example, 'F'.
* Player 1 says a letter. Player 1 must say 'O', because only one word starts with PEAF. If Player 1 says any other letter, for example 'A', he or she loses, because no word begins with PEAFA. Player 2 says a letter, which must be 'W'.
* Player 1 says a letter, which must be 'L'. Player 1 loses, because PEAFOWL is a word.

## Feature requirements

* The game must be interactive: At each step, it should say who the current player is and what the current word fragment is.

* The player should be asked to input a letter, and the program should make sure that it the input is valid (one alphabetic character only, but it may be uppercase or lowercase).

* The letter should be added to the word fragment and the updated word fragment should be displayed.

* The game should end if the current player has formed a word (longer than 3 characters) or no words can be formed.

* The game must have a choice of dictionaries: either Dutch or English.

* During game play, the user should be allowed to hit the MENU button on the
  Android device to cause a menu to appear and allow the user to reset the
  puzzle to a shuffled state, change the difficulty, or quit the current game
  and pick another image. This menu should only appear during game play and not
  during an image selection.

* If the user changes the language of the game it must cause game play to
  restart. The preference should survive if the user quits and re-opens the
  app. If no preference is set, the default language should be used.

* The game's state must survive if the user quits the app or other activities
  appear above it. The end result should be that a user can return to the game
  and continue playing where they left off even if the app is quit or the
  device is turned off.

* When a player has won, a new screen must appear that congratulates the user
  on their accomplishment. There must also be a button to return back
  to the list of images and allow the user to play another game.

* Immediately upon launch, gameplay must start (unless the app was simply
  backgrounded, in which case gameplay, if in progress prior to backgrounding,
  should resume).

* Your app's front side must display placeholders (e.g., hyphens) for
  yet-unguessed letters that make clear the word's length.

* Your app's front side must inform the user (either numerically or
  graphically) how many incorrect guesses he or she can still make before
  losing.

* Your app's front side must somehow indicate to the user which letters he or
  she has (or, if you prefer, hasn't) guessed yet.

* The user must be able to input guesses via an on-screen keyboard.

* Your app must only accept as valid input single alphabetical characters
  (case-insensitively). Invalid input (e.g., multiple characters, no
  characters, characters already inputted, punctuation, etc.) should be ignored
  (silently or with some sort of alert) but not penalized.

* Your app's front side must have a title (e.g., Hangman) or logo as well as
  two buttons: one that flips the UI around to the app's flipside, the other of
  which starts a new game.

* If the user guesses every letter in some word before running out of chances,
  he or she should be somehow congratulated, and gameplay should end (i.e., the
  game should ignore any subsequent keyboard input). If the user fails to guess
  every letter in some word before running out of chances, he or she should be
  somehow consoled, and gameplay should end. The front side's two buttons
  should continue to operate.

* On your app's flipside, a user must be able to configure two settings: the
  length of words to be guessed (the allowed range for which must be $$[1,
  n]$$, where $$n$$ is the length of the longest word in `words.plist`); and
  the maximum number of incorrect guesses allowed (the allowed range for which
  must be $$[1, 26]$$).

* When settings are changed, they should only take effect for new games, not
  one already in progress, if any.

## Platform integration requirements

* Your app's UI should be sized for an iPhone or iPod touch (i.e., 320 × 480
  points) with support for, at least, `UIInterfaceOrientationPortrait`.
  However, if you own an iPad and would prefer to optimize your app for it
  (i.e., 768 $$\times$$ 1024 points), you may, so long as you inform your TF
  prior to this project's deadline.

* Your app must come with default values for the settings. Anytime the user
  changes those settings, the new values should be stored immediately in
  `NSUserDefaults` (so that changes are not lost if the application is
  terminated).

    * On iOS, those defaults should be set in `NSUserDefaults` with `registerDefaults`.
    
    * On Android, those defaults should be set in `SharedPreferences` with `edit()`.

## Implementation details

* The logic of the wordgame itself should be implemented in a completely separate set of model classes that do not have any knowledge about the user interface implementation.

* You must use the contents of `words.plist` as your universe of possible
  words. You're welcome, but not required, to transform it into some other
  format (e.g., SQLite) when the app is first run.

* Your app must tolerate low-memory warnings (as by reloading views when
  needed).

* On iOS, your app must work with version 8.1 on both iPhones and iPads.

* On Android, your app must work with an SDK API level of 21 (Android 5) on both tablets and phone sizes.

* Under no circumstances should we be able to cause your program to crash at
  runtime.

* Your project's bundle identifier or package name should be: `nl.mprog.QuickWords`

* You must include your name and student ID in a comment atop every source file
  in the project.
