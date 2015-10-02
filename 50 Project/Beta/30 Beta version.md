# Beta version

As with any software beta release, your project's beta should be
feature-complete, even though it may have some bugs. Broadly speaking:

- a fully playable game with a real word list
- entering names etc.
- high scores
- requirements such as restoring the game state if the app is killed

The following stuff isn't required, though:

- bug-free gameplay
- good coding style
- efficient algorithms
- user interface layout etc.

## Tagging your beta release

Git allows you to *tag* specific versions of your code as a release. This way, you can share these different versions with the public. GitHub also has a special page listing releases of your project.

* Ensure that you have the latest version of everything, including, if
  applicable, your database.

* Add to the top of the `README` instructions that explain, in succinct steps,
  how your instructor and classmates can get your project up and running in
  their own computer.

* Commit your changes to the README:

		git commit -m "Added deployment instructions to README"
		git push

* Confirm that your changed README is now displayed at the bottom of
  <https://github.com/alice/project0>, where **alice** is your actual GitHub
  username.

* "Tag" your official submission as follows:

		cd project
		git tag --force beta
		git push --tags

* That's it! If you make any changes to your project and want to re-submit
  (before the beta's deadline), you probably want to execute, at least,
  these commands after making those changes:

		cd project0
		git add --all
		git commit -m "Last-minute changes"
		git push
		git tag --force beta
		git push --tags
