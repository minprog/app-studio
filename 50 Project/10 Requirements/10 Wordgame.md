# Ghost

You need to understand this game playing it a couple of times with friends or classmates. Be sure to write down any questions you may have about the game and discuss them, so you're sure that you're making a correct game!

## Summary

Your challenge for this project is to implement the game of *Ghost* as a native app. The overall design and aesthetics of this app are ultimately up to you, but we require that your app meet some requirements. All other details are left to your own creativity and interpretation.

Ghost is an inanely popular (well, in the US) two-player wordgame. Our goal in
this problem is to implement an interactive program that allows two humans to
play a game of Ghost against each other. For those of you who are unfamiliar
with the rules, you may read all about it here at
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

## Requirements

* Before the game actually starts, it must ask the users for their respective names. If the game has been played before, *all* previously used names should be provided by the app to choose from.

* The game must be interactive: two players take turns in adding a letter to the word. The user interface must make clear who the current player is.

* The player must be able to input a letter guess via a standard on-screen keyboard.

* Your app must only accept as valid input single alphabetical characters
  (case-insensitively). Invalid input (e.g., multiple characters, no
  characters, characters already inputted, punctuation, etc.) should be ignored
  (silently or with some sort of alert) but not penalized.

* The letter should be added to the word fragment and the updated word fragment should be displayed.

* The game must have a choice of dictionaries: either Dutch or English.

* During game play, the user should be allowed to hit a menu button to cause
  some form of menu to appear and allow the user to restart the game or
  change the language setting.

* The language preference should survive if the user quits and re-opens the
  app. If no preference is set, a default language should be used.

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

* The layout of your user interface should work on both tablets and phones, but you do not have to support landscape mode, which may not be very useful in this particular game (you must make sure that the interface doesn't rotate though!).

* On iOS, those defaults should be set in `NSUserDefaults`. On Android, those defaults should be set in `SharedPreferences`.

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
