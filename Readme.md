# Clj / Cljs App

An extraction of our main app at Cognician.

## Minimum Requirements

A JDK supporting the [Java Platform Module System][illegal-access-faq] (>= JDK 9).
If your distro's default JDK is version 8 or older, you will need to [upgrade][migrate-to-jdk-11] before building this app.

## Usage

Clone this repo, run the commands explained below to see it in action, and then use it as a reference to create (or alter) your own app.

## Contents

It composes the following:

The `clojure` runtime, and `tools.deps.alpha` for Clojure dependency management.

An nREPL server for a pure Clojure REPL, with CIDER and clj-refactor middleware included.

Shadow CLJS, which has:

- An empty app, with working dev and release builds, and a working ClojureScript REPL.
- A Clojure + ClojureScript REPL, via shadow's system, with CIDER and clj-refactor middleware included.
- A `package.json`, for bringing in libraries from npm.
- We don't provide an explicit ClojureScript dependency; we simply use the one Shadow CLJS provides.

A Makefile, to encapsulate the various commands that make this all happen.

## Clojure and ClojureScript REPL in action

Run `npm install`. You only need to do this bit once (unless you add/upgrade versions to `package.json`).

Run `make`.
This will start a shadow-cljs REPL capable of both pure Clojure and Clojure+ClojureScript repl connections from Emacs.

From Emacs, run the `M-x cider-connect-clj&cljs` command, and select `:shadow` when prompted.

In a new terminal, run `make http`. (I assume you have a basic Python installed so you can start this service up!)

Browse to <http://localhost:8000/app.html>. You should be able to write and evaluate this, and see it happen in your browser:

`(js/window.alert "hello from Emacs")`

See `Makefile` for more goodies!

## CIDER Clojure Refresh in action

Once your Clojure or Clojure+ClojureScript repl is connected, you can run the `M-x cider-ns-refresh` to reload your code. The `start` and `stop` functions in `clj-cljs-app.main` give you hooks to handle the lifecycle of your application entrypoint.

## References

### Clojure

<https://clojure.org/guides/getting_started#_clojure_installer_and_cli_tools>

<https://clojure.org/reference/deps_and_cli>

Clojurians Slack: `#clojure`

### CIDER

<https://cider.mx/>

Clojurians Slack: `#cider`

### clj-refactor

<https://github.com/clojure-emacs/clj-refactor.el>

Clojurians Slack: No specific one, but `#emacs` will probably help!

### Shadow-CLJS

<https://shadow-cljs.github.io/docs/UsersGuide.html>

Clojurians Slack: `#shadow-cljs`


<!-- JDK help topics -->
[illegal-access-faq]: https://clojure.org/guides/faq#illegal_access
[migrate-to-jdk-11]: https://www.deps.co/blog/how-to-upgrade-clojure-projects-to-use-java-11
