# Kata: Java Proxy

This kata is about getting to know the Java Proxy `java.lang.reflect.Proxy`. While I first observed this interesting
pattern browsing the code [Selenide][] I was inspired to create this kata by
[Daniel Reuter's blog post at codecentric (de)][codecentric-dreuter]
how to use the Java Proxy to create a facade to message resource bundles with several advantages like code completion.

## Goals

1. Use `java.lang.reflect.Proxy` to represent resource bundle entries as interface methods

2. Test, that all resource bundle keys are represented by interface.

3. Test, that all interface methods are backed by resource bundle entries in all languages.

4. Test, that resource bundle parameter count matches interface method parameter count.

5. Resolve String arrays to some meaningful representation in messages.

6. Allow tests to retrieve raw messages, i. e. without accessing the resource bundle.

    Idea: Tests which only want to test for relevant information to be available in the message, might
    not be interested in the concrete message - but more in its raw arguments.

## Tips

For convenience you might want to use `com.google.common.reflect.Reflection.newProxy` to create the proxy instance.

<!-- Links -->

[Selenide]: <http://selenide.org/> "Selenide: concise UI tests in Java"
[codecentric-dreuter]: <https://blog.codecentric.de/2012/01/internationalisierung-mit-java-resourcebundle-und-kompilierabhangigkeiten/> "Internationalisierung mit Java ResourceBundle und Kompilierabhängigkeiten - codecentric Blog : codecentric Blog"
