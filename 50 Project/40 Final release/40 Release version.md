To submit your final, you need to follow these steps:

* Ensure that you have the latest version of your code, as via `git pull`.

* Ensure that you have a README (which you should already have created prior
  to submission of your beta version). Update that README with any thoughts
  you'd like to communicate to your instructor. For instance, if you made some
  design decision that you're worried might be questioned, argue your case.

  If you made some design decision that you know is suboptimal but you had
  your reasons, e.g., difficulty getting an alternative design to work,
  explain as much. (Merely disclaiming suboptimal designs won't necessary
  yield a higher score, but we'll at least know you gave the matter some
  thought and didn't make a suboptimal decision in a vacuum.)

* Tag and push your code for submission as follows:

		cd ~/project_name
		git add --all
		git commit -m "Ready for release"
		git push
		git tag --force release
		git push --tags

* Ask a classmate to pull down your code via `git` and confirm that
  everything is indeed in working order, lest your instructor find otherwise.
