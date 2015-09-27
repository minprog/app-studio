# Creating a playable game

This week, you'll implement the user interface to play a single instance of the game. A user needs to be able to start the app and play the game with a friend. There is no concept of player names yet, nor should there be reset buttons, menus or a high score list.

## The game

- Create your *game screen* as you have sketched it in your design document. It needs to be coupled to a controlled class called `GameActivity` (Android) or `GameViewController` (iOS).

- As before, create a `Dictionary` instance and a `Game` instance that will contain the game functionality.

- The game logic comes to live every time a user enters a character. You need to feed that character to the `Game` class instance you created, and each time, ask the game class if something has changed in the state of the game.

- To keep it simple, show who has won the game by changing the displayed text of some user interface element to 'Player 1 has won' or the like.

