# Ghost

You need to understand this game by the start of Week 2. Be sure to write down any questions you may have about the game and take them to class.

## Summary

Your challenge for this project is to implement the game of Ghost as a native app. The overall design and aesthetics of this app are ultimately up to you, but we require that your app meet some requirements. All other details are left to your own creativity and interpretation.

Ghost is an inanely popular two-player wordgame. Our goal in this problem is to
implement an interactive program that allows two humans to play a game
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

* Before the game actually starts, it must ask the users for their respective names. If the game has been played before, *all* previously used names should be provided by the app to choose from.

* The game must be interactive: at each step, it should say who the current player is and what the current word fragment is.

* The player must be able to input a letter guess via an on-screen keyboard.

* Your app must only accept as valid input single alphabetical characters
  (case-insensitively). Invalid input (e.g., multiple characters, no
  characters, characters already inputted, punctuation, etc.) should be ignored
  (silently or with some sort of alert) but not penalized.

* The letter should be added to the word fragment and the updated word fragment should be displayed.

* The game should end if the current player has formed a word (longer than 3 characters) or no words can be formed.

* The game must have a choice of dictionaries: either Dutch or English.

* During game play, the user should be allowed to hit a menu button to cause
  some form of menu to appear and allow the user to restart the current round or
  change the language.

* If the user changes the language of the game it must cause game play to
  restart. The preference should survive if the user quits and re-opens the
  app. If no preference is set, the default language should be used.

* The game's state must survive if the user quits the app or other activities
  appear above it. The end result should be that users can return to the game
  and continue playing where they left off even if the app is quit or the
  device is turned off.

* When a player has won, a new screen must appear that congratulates the winner
  on their accomplishment and state the reason for winning.
  
* Then, the player should be shown their place in the high score list, where
  each game that is won counts towards the score.
  
* Finally, there must also be a way to immediately start a new game or change
  the player's names.

## Platform integration requirements

* On iOS, your app must work with iOS version 8.1.

* On Android, your app must work with an SDK API level of 21 (Android 5).

* The layout of your user interface should work on both tablets and phones, but you do not have to support landscape mode.

* Your app must come with default values for the settings. Anytime the user
  changes those settings, the new values should be stored immediately in
  `NSUserDefaults` (so that changes are not lost if the application is
  terminated).

    * On iOS, those defaults should be set in `NSUserDefaults` with `registerDefaults`.
    
    * On Android, those defaults should be set in `SharedPreferences` with `edit()`.

## Implementation details

* The logic of the wordgame itself should be implemented in a completely separate set of model classes that do not have any knowledge about the user interface implementation.

* You must use the contents of two dictionary files as your universe of
  possible words. You're welcome, but not required, to transform it into some
  other format (e.g., SQLite) when the app is first run.

* Your app must tolerate low-memory warnings (as by reloading views when
  needed).

* Under no circumstances should we be able to cause your program to crash at
  runtime.

* Your project's bundle identifier or package name should be: `nl.mprog.Ghost`

* You must include your name and student ID in a comment atop every source file
  in the project.
