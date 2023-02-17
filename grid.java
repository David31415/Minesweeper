class Grid extends Tile{ // Inheriting from Tile class
    Integer level; // 3 different levels of difficulty
    Tile [][] Grid_Array; // 2D array consisting of tiles.
    int column_number = 0; // Labeling each column of the grid, progressively.
    int grid_size = 0; // The side length of each Grid (10 by 10, 15 by 15, etc).
    int total_mines; // total number of mines that a grid has
    boolean endgame = false; // endgame is true if you win/lose.
        
        
    Grid(Integer level_num){
            level = level_num; // Setting the level of difficulty.
        }
        Tile [][] createGrid(){
    
             if (level == 1){
                grid_size = 10; // Setting the grid size and 2D array.
                Grid_Array = new Tile [10][10];
                for (int i = 0; i <10; i++){
                    for (int j = 0; j <10; j++){ // Nested forloop through each coordinate.
                        Grid_Array[i][j] = new Tile(); // Each coordinate is a tile.
                        
                        }
                    }
                }
    
                if (level == 2){ // Same thing as above for medium difficulty.
                    grid_size = 15;
                    Grid_Array = new Tile [15][15];
                    for (int i = 0; i <15; i++){
                        for (int j = 0; j <15; j++){
                            Grid_Array[i][j] = new Tile();
                        }
                            
                        }
                    }
    
                    if (level == 3){ // Hard difficulty.
                        grid_size = 20;
                        Grid_Array = new Tile [20][20];
                        for (int i = 0; i <20; i++){
                            for (int j = 0; j <20; j++){
                                Grid_Array[i][j] = new Tile();
                                
                                }
                            }
                        }
        
        return Grid_Array; // returns result
            }
    
        void printGrid(){ // Prints out the array
            System.out.print("\n\n");
        for (int i = 0; i<grid_size; i++){  // Prints out the numbers at the top. Numbering each column.
            if (i == 0){
                System.out.print("    "); // Spacing in front of zero (formatting) (One tab = 4 spaces)
            }
    
            if (i<10 && i != grid_size-1){
                System.out.print(i + "  "); // If the number is single digit and not the last number, print out the number and a double space behind it.
            }
    
            if (i >=10 && i != grid_size-1){ // If the number is double digit and not the last number, print out the number and a single sp9ace.
                System.out.print(i + " ");
            }
    
            if (i == grid_size -1){
                System.out.print(i); // At the end of the row of numbers, go to the next line.
                System.out.print("\n");
                break;
            }
        }
        for (int i = 0; i <grid_size; i++){
            for (int j = 0; j <grid_size; j++){ // Nested for loop to print out each coordinate.
                if (j == 0){ // Give a double space at the beginning of each row (formatting) after the number
                   if (column_number <10){ // If the number is single digit, add an extra space.
                    System.out.print(column_number + "  ");
                   }
                   if (column_number >= 10){ // Numbering each row.
                    System.out.print(column_number + " "); // 2 digits only have 1 space after the number.
                   }
                   column_number ++;
                }
                System.out.print(Grid_Array[i][j].toString());
                if (j == grid_size-1){ // At the end of the row, go to the next line.
                    System.out.print("\n");
                }
            
            }
            
          }
    
          column_number= 0; // Resetting the column_number so that it starts back from 0.
        }
        void showMines(){ // Showing and hiding the mines.
            for (int i = 0; i < grid_size; i++){
                for (int j = 0; j < grid_size; j++){
                    Grid_Array[i][j].RevealMines = true; // We would put reveal mines as true, and the tostring() function would update itself.
            }
        }
        }
        void hideMines(){
            for (int i = 0; i < grid_size; i++){
                for (int j = 0; j < grid_size; j++){
                    Grid_Array[i][j].RevealMines = false; // Same logic as above, but this time we set it to false.
            }
        }
        }
    
        Grid(){} // Needed for inheritance to Game class.

        void countMines(){ // Get the total amount of mines in the grid.
            for (int i = 0; i < grid_size; i++){
                for (int j = 0; j < grid_size; j++){
                    if (Grid_Array[i][j].IsMine == true){
                        total_mines++; // Scan the entire grid for mines and add one if we find a mine.
                    }
            }
        }
        }

        public void flagTile(int x_coordinate, int y_coordinate){ // 2 arguments that the user have to input.
               Tile tile = Grid_Array[y_coordinate][x_coordinate]; // We have to switch the coordinates around because
               // the y_ccordinates indicates row, and the x_coordinate indicate column. In the 2D array, the x and y coordinates behaves
               // differently than how we think about them. 
               if (tile.isflipped == false){ // Only flag the tile if it's not already flipped.
                if (tile.isflagged == true){ // If it is already flagged, unflag it (switching the flagged state to false.)
                    tile.isflagged = false;
                    if (tile.IsMine == true){
                        total_mines ++; // If it is a mine, increase the total mines count.
                    }
                    
                } 
                else{
                    if (tile.isflagged == false){ // If it isn't flagged, flag it. 
                    tile.isflagged = true; 
                    if (tile.IsMine == true){
                        total_mines --;
                    }
                    // The else section here has to go after the previous if statement, because otherwise, the program would unflag a tile
                    // immediately after it flags it. The self contradiction would produce no effect. 
                }
                }
               }
                
            }
            
        
        public void flipTile(int x_coordinate, int y_coordinate){ // User input x and y coordinate.
            if (x_coordinate >= 0 && x_coordinate <grid_size && y_coordinate
            >= 0 && y_coordinate < grid_size){ // Check that the coordinates are within the grid bounds
                Tile tile = Grid_Array[y_coordinate][x_coordinate]; // we need the define the actual tile.

                if (tile.isflipped == false && tile.isflagged == false){ // Only flip tiles that have not being flipped or 
                    // have not being flagged
                    tile.isflipped = true; // set isflipped to true.

                    if (tile.IsMine == true){ // if it is a mine, end the game.
                        showMines(); // show the mines.
                        printGrid();
                        endgame = true;


                    }
                    else{ // Count the number of mines surrounding it.
                        int numMines = 0; // set a local variable to count the number of mines.
                        for (int i = y_coordinate-1; i <= y_coordinate+1; i++){
                            for (int j = x_coordinate -1; j<= x_coordinate +1; j++){
                                if (i >= 0 && i<grid_size && j >= 0 && j<grid_size){
                                    // Tile coordinates need to be within bounds.
                                    // This also gets rid of the different cases (corners, edges,etc)
                                    // We can just chck all the 9 tiles around the tile that is flipped.
                                    // If a set of coordinates is not within bounds, we would 
                                    // just ignore it and move to the next pair.
                                    if (Grid_Array[i][j].IsMine == true){ 
                                        numMines++; 
                                    }

                                }
                            }
                        }
                        tile.NumAdjacentMines = numMines;
                    }
                    if (tile.NumAdjacentMines == 0 && tile.IsMine == false){ // If it is a blank tile and not a mine, proceed.
                        for (int i = y_coordinate-1; i<= y_coordinate+1; i++){ 
                            // This is the same logic as before.
                            for (int j = x_coordinate-1; j <= x_coordinate+1; j++){
                                if (i >= 0 && i<grid_size && j>= 0 && j<grid_size){
                                    if (Grid_Array[i][j].isflipped == false){
                                        flipTile(j, i); // Only flip if it is not flipped.
                                    }
                                }
                            }
                        }
                    }
                }
                
            }
        }
     }