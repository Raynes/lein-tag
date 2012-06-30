# lein-tag

A Leiningen plugin to do many wonderful things.

## Usage

Put `[lein-tag "0.1.0"]` into the `:plugins` vector of your
`:user` profile, or if you are on Leiningen 1.x do `lein plugin install
lein-tag 0.1.0-SNAPSHOT`.

To actually use it, just run `lein tag`. It'll create an annotated git tag
on the current commit named after the current version with the message.

## License

Copyright © 2012 Anthony Grimes

Distributed under the Eclipse Public License, the same as Clojure.
