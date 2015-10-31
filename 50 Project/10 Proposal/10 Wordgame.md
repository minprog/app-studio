# Hangman

Well hello! I am thinking of a seven-letter word:

	–––––––

Guess a letter, and I'll tell you where, if anywhere, it appears in the word.
You can guess incorrectly up to, oh, six times. If you can figure out the
word, you win; if you can't (and you're out of guesses), I win. Ready? Okay,
guess a letter.

A, you say? You are so smart. That letter appears twice:

	–A–––A–

Recognize the word now? No? Not to worry, you still have six chances left,
since your first guess was a good one. Guess again.

E, you say? Nope, sorry, not so smart after all. You've now used up one of
your six chances, so you have five chances left. Guess again.

I, you say? Nope! You have four chances left. Guess again.

Z, you say? Nope! You now have three chances left. Guess again.

N, you say? Nice! That letter also appears twice:

	–AN––AN

You still have three chances left. Guess again.

E, you say? I'll pretend I didn't hear that. You guessed that already! You
still have three chances left. Guess again.

H, you say? Nice! That letter appears once:

	HAN––AN

Recognize the word yet? G, you say? M, you say? That's right! It's `HANGMAN`!

So that is how the age-old game of Hangman is played. But for this project, you
will not just implement Hangman. (Hangman is boring.) You will implement...

Wait for it...

## *Evil* Hangman

Evil Hangman is quite like Hangman, except that the computer cheats. Rather
than pick, say, a seven-letter word at the game's start, the computer instead
starts off with a mental list (well, maybe a set or array) of all possible
seven-letter English words. Each time the human guesses a letter, the computer
checks whether there are more words in its list with the letter than without
and then whittles the list down to the largest such subset. If there were more
words with the letter than without, the computer congratulates the user and
reveals the letter's location(s). If there were more words without the letter
than with, the computer just laughs.

Put more simply, the computer constantly tries to dodge the user's guesses by
changing the word it's (supposedly) thinking of. Pretty evil, huh? The funny
thing is most humans wouldn't catch on to this scheme. They'd instead conclude
they're pretty bad at Hangman. Mwah hah hah.

Suffice it to say that the challenge ahead if you is to implement...

Wait for it...

*Evil* Hangman.

But what is the algorithm for evil? Well, let's consider what the computer
needs to do anytime the user guesses a letter. Suppose that the user needs to
guess a four-letter word and that there are only a few such words in the whole
English language: `BEAR`, `BOAR`, `DEER`, `DUCK`, and `HARE`. And so the
computer starts off with a universe (i.e., list) of five words. Next suppose
that the user guesses `E`. A few of those words contain `E`, so the computer
had best decide how to dodge this guess best. Let's partition those words into
"equivalence classes" based on whether and where they contain `E`. It turns out
there are four such classes in this case:

- `----`, which contains `BOAR` and `DUCK`
- `-E--`, which contains `BEAR`
- `-EE-`, which contains `DEER`
- `---E`, which contains `HARE`

Note that `HARE` is not in the same equivalence class as `BEAR`. Even though
both have just one `E`, each's `E` is in a different location. If the computer
is forced to admit that the word that it's "thinking of" contains an `E`
(because it just so happens to have discarded all words that lack `E` in
response to the user's past guesses), it will be forced to announce (and thus
commit to) that letter's location.

So, back to our story: the user has guessed `E`. What should the computer now
do? Well, it could certainly declare that the word it's "thinking of" does not
contain `E`, the implication of which is that the list of five words becomes
two (`BOAR` and `DUCK`). That does feel optimal: armed with two words, the
computer might still have a chance to “change its mind” yet again later. Then
again, `DUCK` seems pretty easy to guess, whereas most people might not even
think of `HARE`. On the other hand, I don't remember the last time I used
`BOAR` in a sentence. But let's keep it simple: you may assume that the
computer will always react to a user's guess by whittling its list down to the
largest equivalence class, with pseudorandomness breaking any ties.

Realize, though, that the largest equivalence class might not always correspond
to `----`. For instance, suppose that the user had guessed `R` instead of `E`.
The equivalence classes would thus be as follows:

- `----`, which contains `DUCK`
- `---R`, which contains `BEAR`, `BOAR`, and `DEER`
- `--R-`, which contains `HARE`

In this case, the computer should go ahead and admit that the word that it's
"thinking of" contains `R` at its end, since that leaves three possible words
(`BEAR`, `BOAR`, and `DEER`) and thus the maximum amount of maneuverability
down the road in reaction to subsequent guesses. Of course, if the user has
never heard of a `DUCK`, then `----` could very well be a superior strategy.
But, again, lest you drive yourself nuts with overanalysis, you may assume that
the largest equivalence class is optimal, even though it might not be in
reality.

Indeed, that strategy might sometimes backfire, at least in a sense. Suppose
that, in a new version of the story at hand, there are only three four-letter
words in the English language: `BOAR`, `DEER`, and `HARE`. Suppose now that the
user guesses `E`. In this case, our equivalence classes are:

- `----`, which contains `BOAR`
- `-EE-`, which contains `DEER`
- `---E`, which contains `HARE`

Because each has one word, these classes are, of course, of the same size. But
if we happen to select `-EE-` pseudorandomly, thereby whittling our list down to
just `DEER`, we'll have revealed to the user two of the word's letters, whereas
we could have revealed zero (had we selected `----` instead) or one (had we
selected `---E` instead). But, again, that's okay. You are welcome, but not
required, to implement a more sophisticated algorithm than that prescribed
here; just make clear in some comments how yours happens to work.

For this project, you will be provided with a `words.plist` (for use on iOS)
and a `words.xml` (for use on Android) to serve as the universe of potential
words for your game. As for how to divide a list of words into equivalence
classes programmatically, well, we'll leave that as a challenge for you!
