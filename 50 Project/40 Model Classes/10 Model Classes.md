# Creating two model classes

This week, you'll create classes that will implement much of the game's functionality. We give suggestions about how to approach this in a way that gives you classes that are concerned with very specific parts of the program and nothing else (*separating the concerns* of all classes).

> Besides making the model classes and testing these, you should probably make sure that all of your user interface is in the project and working. Fully connecting the models and the user interface can be postponed until next week, but be forwarned: making it all work will take two weeks!

## GoodGameplay and EvilGameplay

These classes should manage playing the game. That means these classes should know about the word list, about the rules of the game and about the results at each step in the game. The classes should be subclassed from an abstract `Gameplay` class that has all common functionality (maybe the loading of words?).

Tips:

- at first, hard-code a couple of words in your classes, so you can test the gameplay without actually implementing the loading of words from a file
- move some of the code that you wrote last week to these classes!



