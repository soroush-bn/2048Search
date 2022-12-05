# 2048 game

### Introduction

2048 is a single-player sliding tile puzzle video game written by Italian web developer Gabriele Cirulli and published on GitHub. The objective of the game is to slide numbered tiles on a grid to combine them to create a tile with the number 2048; however, one can continue to play the game after reaching the goal, creating tiles with larger numbers. It was originally written in JavaScript and CSS over a weekend, and released on 9 March 2014 as free and open-source software subject to the MIT License. Versions for iOS and Android followed in May 2014. (wikipedia)

What I implemented is slightly different to the known 2048 as there is no new tile in each move. In order to keep it as simple as possible and make it suitable for study purposes, I decided to 
remove the new tile per each move policy so the deterministic nature of the problem would be satisfied.

[try it yourself!](https://play2048.co/)

### Rules

* There are 2 modes for the game :
  1. normal mode, in which two tiles can be merged without any constraint
  2. advance mode, in which two tiles can only be merged if they have the same value, e.g. both are 4.
* there are four movements in the game and with each movement, only one shift will occur.
  e.g. consider you move left, then all the coloumn will shift one place to the left side and the left-most coloumn would'nt change but (if possible) will be merged with its neighbour coloumn.

### what YOU need to do:

* Implement ** Blind Searches ** :
  1. DFS
  2. IDS
  3. UCS
  4. BDS (extra point)
* Implement ** Informed Searches ** :
  1. A*
  2. IDA*
  3. GBFS
  4 RBFS (extra point)

p.s. BFS is implemented for you.

### assessment

* you will be assessed based on your participate in your team.
* you must write the codes with your own idea and any obvious cheating would result in some penalty.
* any creativity in your huristic function have + points.
 
