As with any beta, your project's beta should be feature-complete, even though
it may have some bugs. Per the syllabus, it will be evaluated primarily along
axes of scope, design, and style (whereas your project's release will be
evaluated primarily along those axes as well as correctness).

When ready to submit your beta, only one member of your two-person team should
follow the steps below. Let's call the team member who'll be submitting
"Alice" and the team member who won't be submitting "Bob". For the purposes
of submitting, it doesn't matter which of you are which: even if you were
Alice for your Design Doc and Style Guide, you can still be Bob this time; and
vice versa.

* Ensure that you (Alice) have the latest version of everything, including, if
  applicable, your database.

* Add to the top of the `README` instructions that explain, in succinct steps,
  how your instructor and classmates can get your project up and running in
  their own computer. Odds are those instructions will resemble the below,
  where **alice** is your actual Github username:

		# clone repo
		git clone git@github.com:alice/project0.git alice

		# make sure all gems are there
		cd alice
		bundle

		# initialize and seed database
		rake db:setup
	
		# start server
		rails s

* Commit your changes to the README:

		git commit -m "Added deployment instructions to README"
		git push

* Confirm that your changed README is now displayed at the bottom of
  <https://github.com/alice/project0>, where **alice** is your actual GitHub
  username.

* Ask Bob to follow your README's instructions inside of his own environment, to
  ensure they're 100% correct. If he's able to get your project up and running
  at `http://localhost:3000/`, where alice is still your actual GitHub
  username, odds are your README's instructions are correct! If incorrect,
  though, make (and push) any changes to your README as needed.

* "Tag" your official submission as follows:

		cd project0
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
