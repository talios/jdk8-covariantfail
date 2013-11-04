JFLAGS = -g -cp fest-assert-core-2.0M10.jar
JC = javac
.SUFFIXES: .java .class
.java.class:
				$(JC) $(JFLAGS) $*.java

CLASSES = \
				AppTest.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
				$(RM) *.class
