# Minesweeper

This is the classic Minesweeper game, but played using text format through the terminal.
You can download the code in visual studio code (or any other coding software that you prefer) and play the game there through a terminal.

### Basic Description

The player can choose between 3 different levels. Each level consists of a square grid that has a set number of tiles. To flip a tile, the user enters its coordinates, which are shown along with the grid. (Note that there *must* be a space bewteen each coordinate). To flag a tile, the user simply types "f" before the coordinates. There is also a number on top of the grid that indicates how many mines the player has left to sweep. 

Every flipped tile will display a number that shows how many mines are adjacent to that tile (diagonal, left, right, top, bottom). If the flipped tile is empty, it will be blank, and all the other tile around the blank tile are also flipped. This recursive process continues until it reaches the edge of the board, or until a tile that has mines adjacent to it is flipped.

If the user flips a mine, the game is over. All the other mines are immediately revealed and the user loses. If the user flags all the mines, they win.

Have fun playing :)