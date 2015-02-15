# Quick Words

Your challenge for this project is to implement Quick Words as a native iOS app. The overall design and aesthetics of this app are ultimately up to you, but we require that your app meet some requirements. All other details are left to your own creativity and interpretation.

Quick Words is not entirely unlike Scrabble. Letters are dealt to players, who
then construct one or more words out of their letters. Each valid word receives
a score, based on the length of the word and the letters in that word.

The rules of the game are as follows:

## Dealing

- A player is dealt a *hand* of $$n$$ letters chosen at random (assume $$n=7$$ for now).

- The player arranges the hand into a set of words using each letter at most once.

- Some letters may remain unused (these won't be scored).

## Scoring

- The score for the hand is the sum of the score for the words.

- The score for a word is the sum of the points for letters in the word, plus
  50 points if all $$n$$ letters are used on the first go.

- Letters are scored as in Scrabble; A is worth 1, B is worth 3, C is worth 3,
  D is worth 2, E is worth 1, and so on.

- For example, 'weed' would be worth 8 points ($$4+1+1+2=8$$), as long as the hand actually has 1 'w', 2 'e's, and 1 'd'.

- As another example, if $$n=7$$ and you get 'waybill' on the first go, it
  would be worth 65 points ($$4+1+4+3+1+1+1=15$$, and 50 for the 'bingo' bonus
  of using all seven letters).

## Values

	SCRABBLE_LETTER_VALUES = {
	    'a': 1, 'b': 3, 'c': 3, 'd': 2, 'e': 1, 'f': 4, 'g': 2, 'h': 4, 'i': 1, 'j': 8, 'k': 5, 'l': 1, 'm': 3, 'n': 1, 'o': 1, 'p': 3, 'q': 10, 'r': 1, 's': 1, 't': 1, 'u': 1, 'v': 4, 'w': 4, 'x': 8, 'y': 4, 'z': 10
	}

## Feature requirements

*   The game must have three levels of difficulty: "easy", "medium", and "hard". The "easy" level indicates that n=8 (in other words, a 3x3 puzzle), "medium" represents n=15 or 4x4, and "hard" means n=24 or 5x5. The default difficulty should be "medium".

*   During game play, the user should be allowed to hit the MENU button on the Android device (or emulator) to cause a menu to appear and allow the user to reset the puzzle to a shuffled state, change the difficulty, or quit the current game and pick another image. This menu should only appear during game play and not during an image selection.

*   If the user changes the difficulty level it must cause game play to restart. The solution preview must appear and be replaced by the shuffled n-puzzle after three seconds, as above. Additionally, the user's preference for difficulty level must be remembered by the app so that the same difficulty is used automatically the next time the game is played. The preference should survive if the user quits and re-opens the app. If no preference is set, the default difficulty should be used.

*   The game's state must also survive if the user quits the app or other activities appear above it. The end result should be that a user can return to the game and continue playing where they left off even if the app is quit or the device is turned off. Don't forget to save such things as the image selection, difficulty, number of moves taken so far, and current tile positions!

*   When the user has successfully solved the puzzle, a new activity must appear that congratulates the user on their accomplishment, displays the original image, and lists the number of moves they used while solving it. There must also be a button to return back to the list of images and allow the user to play another game.

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

### Implementation details

*   Your app's UI should be sized for an iPhone or iPod touch (i.e., 320 × 480 points) with support for, at least, `UIInterfaceOrientationPortrait`. However, if you own an iPad and would prefer to optimize your app for it (i.e., 768 $$\times$$ 1024 points), you may, so long as you inform your TF prior to this project's deadline.

*   You must use the contents of `words.plist` as your universe of possible words. You're welcome, but not required, to transform it into some other format (e.g., SQLite).

*   Your app must come with default values for the flipside's two settings; those defaults should be set in `NSUserDefaults` with `registerDefaults:`. Anytime the user changes those settings, the new values should be stored immediately in `NSUserDefaults` (so that changes are not lost if the application is terminated).

*   You must implement each of the flipside's numeric settings with a `UISlider`. Each slider should be accompanied by at least one `UILabel` that reports its current value (as an integer).

*   You are welcome to implement your UI with Xcode's interface builder in `MainViewController.xib` and `FlipsideViewController.xib`, or you may implement your UI in code in `MainViewController.{h,m}` and `FlipsideViewController.{h,m}`.

*   You must obtain a user's guesses via a `UITextField` (and the on-screen keyboard that accompanies it). For the sake of aesthetics, you are welcome, but not required, to keep that `UITextField` hidden (so long as the on-screen keyboard works). You are also welcome, but not required, to respond to user's keypresses instantly, without waiting for them to hit return or the like, in which case `textField:shouldChangeCharactersInRange:replacementString` in the `UITextFieldDelegate` protocol might be of some interest.

*   Your app must use Automatic Reference Counting (ARC).

*   Your app must tolerate low-memory warnings (as by reloading views when needed).

*   Your app must work within the iPhone 5.1 Simulator; you need not test it on actual hardware. However, if you own an iPad, iPhone, or iPod touch, and you'd like to install your app on it, ask your tutor.

*   The application should have a minimum SDK API level of 7 (Android 2.1).
*   You must include at least 3 images of your choosing in the res/drawable folder that can be selected as puzzle solutions. The file names must be `puzzle_N.jpg`, where N will begin at 0 and increment sequentially to a maximum value of 9. Keep in mind that we reserve the right to swap out these images or add additional ones (up to a maximum of 10) during testing, so be sure that your tiles are generated on-the-fly by your app and not pre- generated by you and that the quantity of images and sizes of each are not hard-coded. In other words, your image selection activity must dynamically detect the quantity of images and present the user with an appropriate number of choices.
*   Per the features list you should have three activities in this application. The initial list activity should be called ImageSelection, the activity where game play occurs should be called GamePlay, and the congratulatory activity called YouWin. The `.java` files should be named accordingly. You may include other `.java` files if you deem it necessary to implement other classes for your game.
*   Under no circumstances should we be able to cause your program to crash at runtime.
*   Be sure the project and application name are both `nPuzzle########`, where `########` is your student ID.
*   Your project's package name should be: `nl.mprog.projects.nPuzzle########`
*   You must include your name, email, and student ID in a comment atop every Java source file in the project.
