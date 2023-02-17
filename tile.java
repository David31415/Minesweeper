class Tile{
    double chance = Math.random(); // returns a random value between 0 and 1. This will be used to determine if the tile is a mine.
    boolean IsMine; // If it is a mine or not.
    String type; // A temporary variable used in the toString() function.
    boolean RevealMines; // determines if we want to reveal the mines.
    boolean isflipped; // If it is flipped or not.
    boolean isflagged; // if it is flagged or not.
    int NumAdjacentMines = 0; // Number of adjacent mines around the tile.
    
    Tile(){ // Constructor.

        if (chance <0.8){ // Using the math.random() --> 20% chance of it being a mine.
            IsMine = false;
        }

        else if (chance >0.2){ 
            IsMine = true;
        }

    } // Tile is just [ ], so it has an empty constructor.

  public String toString(){
    if (isflagged == false){ // If the tile isn't flagged:
        if (isflipped == false){ // If the tile isn't flipped.
        if (RevealMines == true){ // If we want to show mines, 
            if (IsMine == false){
                type = "[ ]"; // [ ] is the default value of a tile after showing the mines.
            }
        if (IsMine == true){
            type = "[•]"; // [•] means it is a mine.
         }
        }
         if (RevealMines == false){
            type = "[ ]"; // if we don't want to reveal (or hide the mines), then everythihng is [ ], the default value.
        }
    }
    if (isflipped == true){ // If it is flipped
        if (IsMine == true){
            type = "[•]"; // Mine
        }
        else{
            type = "[" + NumAdjacentMines + "]"; // Showing the number of adjacent mines if it's not a mine.
        }
        
    }
        }

    if (isflagged == true){
        type = "[F]"; // If flagged, then there is only one option.
    }
    return type; // return the toString() --> gets used every time when we print the grid.
    }
  }