# Game specification

Your challenge for this project is to implement Evil Hangman as a native
app. The overall design and aesthetics of this app are ultimately up to you but
we require that your app meet some requirements. All other details are left to
your own creativity and interpretation.

## Requirements

* Immediately upon launch, gameplay must start (unless the app was simply backgrounded, in which case gameplay, if in progress prior to backgrounding, should resume).

* Your app must inform the user of all relevant state for the current game: open letter positions, guessed letters, guesses left, and so on. Be creative on this aspect! If unsure about how to proceed, study some Hangman games that are available in the app store.

* The user must be able to input guesses via an on-screen keyboard.

* Your app must only accept as valid input single alphabetical characters
  (case-insensitively). Invalid input (e.g., multiple characters, no
  characters, characters already inputted, punctuation, etc.) should be ignored
  (silently or with some sort of alert) but not penalized.

* Your app's front side must have a title (e.g., Hangman) or logo as well as navigation to go to the app's settings and to start a new game.

* If the user guesses every letter in some word before running out of chances,
  he or she should be somehow congratulated, and gameplay should end (i.e., the
  game should ignore any subsequent keyboard input). If the user fails to guess
  every letter in some word before running out of chances, he or she should be
  somehow consoled, and gameplay should end. The front side's two buttons
  should continue to operate.

* A user must be able to configure three settings: the length of words to be
  guessed (the allowed range for which must be $$[1, n]$$, where $$n$$ is the
  length of the longest word in `words.plist` or `words.xml`); the maximum
  number of incorrect guesses allowed (the allowed range for which must be
  $$[1, 26]$$); and whether or not to be evil. By default, your app must be
  evil. But if the user opts to disable evil, gameplay should occur in a
  traditional, non-evil way, whereby the app must choose a word pseudorandomly
  from the start and stay committed to that word until the game's end.

* When settings are changed, they should only take effect for new games, not one already in progress, if any.

* Your app must maintain a history of high scores that's displayed anytime a
  game is won or lost. We leave the definition of "high scores" to you, but you
  should somehow rank the results of at least 10 games (assuming at least 10
  games have been won), displaying for each the word guessed and the number of
  mistakes made (which is presumably low). The history of high scores should
  persist even when your app is backgrounded or force-quit.
