# Creating a playable game

This week, you'll implement the user interface to play a single instance of the game. A user needs to be able to start the app and play the game with a friend. There is no concept of player names yet, nor should there be reset buttons, menus or a high score list.

## Refactoring the `game` class

You will first refactor the dictionary class to use a specific *data type* to represent the word list.

On iOS, you will need to use an `NSMutableSet` ([documentation][1]). This class has a very convenient method `filterUsingPredicate:` that helps you implement the filtering in a more compact fashion.

On Android, you will need to use a `HashSet` ([documentation][2]). With this class, you will need to implement your own filtering loop, but it does have a very convenient method `remove` that allows you to easily remove items.

[1]: https://developer.apple.com/library/mac/documentation/Cocoa/Reference/Foundation/Classes/NSMutableSet_Class/index.html

[2]: http://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html

## The game

- Create your *game screen* as you have sketched it in your design document. It needs to be coupled to a controlled class called `GameActivity` (Android) or `GameViewController` (iOS).

- As before, create a `Dictionary` instance and a `Game` instance that will contain the game functionality.

- The game logic comes to live every time a user enters a character. You need to feed that character to the `Game` class instance you created, and each time, ask the game class if something has changed in the state of the game.

- To keep it simple, show who has won the game by changing the displayed text of some user interface element to 'Player 1 has won' or the like.

