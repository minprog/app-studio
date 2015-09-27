# Creating two model classes

This week, you'll create two simple classes that will implement much of the game's functionality. We give suggestions about how to approach this in a way where you have classes that are concerned with very specific parts of the program and nothing else.

> Besides making the model classes and testing these, you should probably make sure that all of your user interface is in the project and working. Fully connecting the models and the user interface can be postponed until next week, but be forwarned: making it all work will take two weeks!

## Dictionary

The first is the `Dictionary` class, which represents a dictionary of words in any language and that can filter its list of words by prefix.

Upon construction of an instance, the class should load the words contained in a dictionary file that is included with the application. However, in a class that is not a controller, you do not usually have access to files. You should therefore include the full path to a file as a parameter to the Dictionary constructor.

In Java:

    class Dictionary {
        
        Dictionary(String sourcePath) {
            // open file and read into local data structure
        }
        
    }

In Swift:

    class Dictionary {
        init(sourcePath: String) {
            // open file and read into local data structure
        }
    }

Furthermore, it should probably implement these public methods:

- `filter`: this method takes a string as input and filters the word list using this string. Because loading the dictionary takes quite a bit of time, this method should not destroy the base dictionary and thus allows it to be re-used.

- `count`: this method returns the length of the words remaining in the filtered list.

- `result`: this method returns the single remaining word in the list. Obviously, this method can only be called if `count` returns the number `1`.

- `reset`: to remove the filter and re-start with the original dictionary.

On iOS, you will need to use an `NSMutableSet` ([documentation][1]). This class has a very convenient method `filterUsingPredicate:` that helps you implement the filtering in a more compact fashion.

On Android, you will need to use a `HashSet` ([documentation][2]). With this class, you will need to implement your own filtering loop, but it does have a very convenient method `remove` that allows you to easily remove items.

[1]: https://developer.apple.com/library/mac/documentation/Cocoa/Reference/Foundation/Classes/NSMutableSet_Class/index.html

[2]: http://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html

## Game

The second is the `Game` class, which represents a single game. It should implement all relevant game rules and use a `Dictionary` instance to serve as the dictionary. It implements a 2-player game and should keep track of which player is currently up!

Upon construction of an instance, the class should connect to the `Dictionary` instance that is provided as a parameter. It should implement these public methods:

- `guess`: this method takes a string as input, representing the letter that the *current* player has guessed. It uses the `Dictionary` instance to decide

- `turn`: this method returns a boolean indicating which player is up for guessing.

- `ended`: this method returns a boolean indicating if the game has ended.

- `winner`: this method returns a boolean indicating which player has won the game. This method can obviously only make sense if `ended` returns `true`.

## Testing the classes

- In your `Activity` or `ViewController`, you should create a string containing a couple of example dictionary words, separated by newlines, and use it to create a new `Dictionary` instance.

- Then, you should create a new `Game` instance, passing in the `Dictionary` instance just created.

- Finally, you can call a few methods of the `Game` instance in the correct order, to ensure that no errors occur and the right winner is indeed chosen.
