# Clojure-Project
A project created for subject using Clojure Programming Language


DESCRIPTION: It’s time to try a little functional programming. In this assignment, you will have a
chance to gain experience with the Clojure programming language. The program itself should be
relatively small. However, you will have to think a little about the algorithm in order to actually
produce a working solution. In the process, you should get some sense of the syntax and style of a
functional language.

In terms of your task, it can be described as follows. You can assume that you are an intrepid
explorer, searching for buried treasure. Specifically, you are underground, wandering through a
series of very dark tunnels. You have no light and no signs to guide your way. All you can do is
blindly feel around and wander through the tunnels until you hopefully enter the room that
contains the treasure. You can, however, leave a trail of breadcrumbs behind you so that if you
come to the end of a tunnel and you can’t go any further, you can get back to where you were and
try again in another direction.



DESCRIPTION: It’s time to try a little functional programming. In this assignment, you will have a
chance to gain experience with the Clojure programming language. The program itself should be
relatively small. However, you will have to think a little about the algorithm in order to actually
produce a working solution. In the process, you should get some sense of the syntax and style of a
functional language.
In terms of your task, it can be described as follows. You can assume that you are an intrepid
explorer, searching for buried treasure. Specifically, you are underground, wandering through a
series of very dark tunnels. You have no light and no signs to guide your way. All you can do is
blindly feel around and wander through the tunnels until you hopefully enter the room that
contains the treasure. You can, however, leave a trail of breadcrumbs behind you so that if you
come to the end of a tunnel and you can’t go any further, you can get back to where you were and
try again in another direction.
This may all sound very abstract, but a simple example will illustrate what has to be done. A map of
the tunnels will be stored in a simple text file. The map is used by the application to determine if the
explorer can move in a certain direction. The map could look like this:
```
---#--###----
-#---#----##-
####-#-#-#-##
---#---#-#---
-#-####---##-
-#------#----
-############
------------@
```
Here, the – characters indicate that you are free to move in this direction. The # character indicates
that you cannot move any further in this direction and you should go somewhere else. The @
character indicates the location of the treasure. In this case, it is in the bottom right corner, but it
could be anywhere in the map.
In your application, you will always begin searching in the top left corner of the map. So when you
run your code, you might print something like the following to the screen:
This is my challenge:

```
---#--###--#-
-#---#----##-
####-#-#-#-##
---#---#-#---
-#-####---##-
-#------#----
-############
------------@
```


Woo hoo, I found the treasure :-)
```
+++#--###--#-
!#+++#+++-##-
####+#+#+#!##
+++#+++#+#!!!
+#+####++!##!
+#++++++#!!!!
+############
++++++++++++@
```

Note that we first print the current map and then indicate success or failure. In this case,
we were successful. You will also see that the map has been updated to indicate how the
walk was done. The + characters indicate the path that led to the treasure. The ! characters
indicate the tunnels that were tried but did not to lead to a viable path. Note, for example,
that after starting in the top left corner, the explorer tried to go down but that path was a
dead end. So a ! was used to mark a bad path and then the explorer went to the right, which
eventually lead to the treasure.
Let’s modify the input file and try another treasure hunt.
This is my challenge:
```
---#--###--#@
-#---#----##-
####-#-#-#-##
---#---#-#---
-#-####---##-
-#------#----
-############
-------------
```
Uh oh, I could not find the treasure :-(
```
!!!#!!###!!#@
!#!!!#!!!!##-
####!#!#!#!##
!!!#!!!#!#!!!
!#!####!!!##!
!#!!!!!!#!!!!
!############
!!!!!!!!!!!!!
```
In this case, there was no way to get to the treasure. The ! characters indicate that we tried almost
every possible pathway but eventually had to give up (there is one – location that we couldn’t
reach). Oh well.
So that’s the entire problem. You will read the map from a file called map.txt (in the same folder as
the application), try to find the treasure, and then provide a final updated map that shows how you
explored the tunnels and, of course, whether you were successful or not.
