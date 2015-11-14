# Basic Gameplay

As a first step towards creating a full game, implement the basic gameplay. No high scores, no introductory screens, a simple word list (not from the xml/plist), but simply a way of playing the game using a normal GoodGameplay strategy. Make sure it fully works, although there may still be bugs, of course!

The following stuff is not required!

- bug-free gameplay
- good coding style
- efficient algorithms
- user interface layout etc.

## Tagging your beta release

Git allows you to *tag* specific versions of your code as a release. This way, you can share these different versions with the public. GitHub also has a special page listing releases of your project.

* Ensure that you have the latest version of everything, including, if
  applicable, your database.

* Add to the `README` descriptions of what is implemented and what is still `TODO`.

* Commit your changes to the README:

		git commit -m "Added description of release features to README"
		git push

* Confirm that your changed README is now displayed at the bottom of
  <https://github.com/alice/Hangman>, where **alice** is your actual GitHub
  username.

* "Tag" your official submission as follows:

		cd project
		git tag --force gameplay
		git push --tags

* That's it! If you make any changes to your project and want to re-submit
  (before the beta's deadline), you probably want to execute, at least,
  these commands after making those changes:

		cd project0
		git add --all
		git commit -m "Last-minute changes"
		git push
		git tag --force gameplay
		git push --tags
