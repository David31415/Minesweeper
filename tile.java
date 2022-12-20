class Tile{
    double chance = Math.random(); // returns a random value between 0 and 1.
    boolean IsMine; // If it is a mine.
    String type;
    boolean RevealMines; // determines if we want to reveal the mines.
    boolean isflipped;
    boolean isflagged;
    int NumAdjacentMines = 0;
    boolean isBlank;
    
    Tile(){

        if (chance <0.8){ // 20% chance of it being a mine.
            IsMine = false;
        }

        else if (chance >0.8){
            IsMine = true;
        }

        if (NumAdjacentMines == 0){
            isBlank = true;
        }
        if (NumAdjacentMines != 0){
            isBlank = false;
        }

    } // Tile is just [?], so it has an empty constructor.

  public String toString(){
    if (isflipped == false){
        if (RevealMines == true){ // If we want to show mines, 
            if (IsMine == false){
                type = "[?]"; // [?] means not a mine.
            }
        if (IsMine == true){
            type = "[•]"; // [•] means it is a mine.
         }
        }
         if (RevealMines == false){
            type = "[?]"; // if we don't want to reveal (or hide the mines), then everythihng is [?].
        }
    }
    if (isflipped == true){
        type = "[" + NumAdjacentMines + "]";
    }
        
    return type;
        }

    public void flagTile(){

    }

    public void unflagTile(){

    }
  }