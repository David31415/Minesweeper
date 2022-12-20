public class Grid extends Tile{ // Inheriting from Tile class
    Integer level; // 3 different levels
    Tile [][] Grid_Array; //2D tile array.
    int column_number = 0; // Labeling each column of Grid, progressively.
    int grid_size = 0; // The side length of each Grid (10 by 10, 15 by 15, etc).
    int start_x;
    int end_x;
    int start_y;
    int end_y;
    boolean endgame = false;
        
        
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
            System.out.print("This is a " + grid_size + " by " + grid_size + " board."); // Descriptoin.
            System.out.print("\n\n");
        for (int i = 0; i<grid_size; i++){  // Prints out the numbers at the top. Numbering each column.
            if (i == 0){
                System.out.print("    "); // Spacing in front of zero (formatting)
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
            for (int j = 0; j <grid_size; j++){ // Nested for loop to printout each coordinate.
                if (j == 0){ // Give a double space at the beginning of each row (formatting).
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
                    Grid_Array[i][j].RevealMines = true;
            }
        }
        }
        void hideMines(){
            for (int i = 0; i < grid_size; i++){
                for (int j = 0; j < grid_size; j++){
                    Grid_Array[i][j].RevealMines = false;
            }
        }
        }
    
        Grid(){} // Needed for inheritance to Game class.
        
        public void flipTile(int x_coordinate, int y_coordinate){
            if (Grid_Array[y_coordinate][x_coordinate].IsMine == true){

                endgame = true;
                System.out.println("Sorry, you lost the game!");
                showMines();
                
            }
            if (Grid_Array[y_coordinate][x_coordinate].IsMine == false && Grid_Array[y_coordinate][x_coordinate].isflipped == false){ 
                endgame = false;
                Grid_Array[y_coordinate][x_coordinate].isflipped = true;
                if (x_coordinate == 0 && y_coordinate == grid_size-1){ // bottom left corner
                    start_y = grid_size-2;
                    end_y = grid_size-1;
                    start_x = 0;
                    end_x = 1;
                 for (int i = grid_size-2; i<=grid_size-1; i++){
                    for (int j = 0; j<=1; j++){
                        if (Grid_Array[i][j].IsMine == true){
                            Grid_Array[y_coordinate][x_coordinate].NumAdjacentMines ++;
                        }
                    }
                 }
    
            }
            if (x_coordinate == 0 && y_coordinate == 0){ // upper left corner
                start_y = 0;
                end_y = 1;
                start_x = 0;
                end_x = 1;
                for (int i = 0; i<=1; i++){
                    for (int j = 0; j<=1; j++){
                        if (Grid_Array[i][j].IsMine == true){
                            Grid_Array[y_coordinate][x_coordinate].NumAdjacentMines ++;
                    }
                }
            }
        }
        if (x_coordinate == grid_size-1 && y_coordinate == 0){ // upper right corner
            start_y = 0;
            end_y = 1;
            start_x = grid_size-2;
            end_x = grid_size-1;
            for (int i = 0; i<=1; i++){
                for (int j = grid_size-2; j<=grid_size-1; j++){
                    if (Grid_Array[i][j].IsMine == true){
                        Grid_Array[y_coordinate][x_coordinate].NumAdjacentMines ++;
                     }
                }
            }
        }
        if (x_coordinate == grid_size-1 && grid_size-1 == 0){ // bottom right corner
            start_y = grid_size-2;
            end_y = grid_size-1;
            start_x = grid_size-2;
            end_x = grid_size-1;
            for (int i = grid_size-2; i<=grid_size-1; i++){
                for (int j = grid_size-2; j<=grid_size-1; j++){
                    if (Grid_Array[i][j].IsMine == true){
                        Grid_Array[y_coordinate][x_coordinate]. NumAdjacentMines ++;
                }
            }
        }
    }
        if (x_coordinate == 0 && y_coordinate >= 1 && y_coordinate <= grid_size -2){ // Excluding corner, the first left column
            start_y = y_coordinate-1;
            end_y = y_coordinate+1;
            start_x = 0;
            end_x = 1;
            for (int i = y_coordinate-1; i<=y_coordinate+1; i++){
                for (int j = 0; j<=1; j++){
                    if (Grid_Array[i][j].IsMine == true){
                        Grid_Array[y_coordinate][x_coordinate].NumAdjacentMines ++;
                }
            }
        }
        }
    
        if (x_coordinate >= 1 && x_coordinate <= grid_size -2 && y_coordinate == 0){ // top row
            start_y = 0;
            end_y = 1;
            start_x = x_coordinate-1;
            end_x = x_coordinate+1;
            for (int i = 0; i<=1; i++){
                for (int j = x_coordinate-1; j<=x_coordinate+1; j++){
                    if (Grid_Array[i][j].IsMine == true){
                        Grid_Array[y_coordinate][x_coordinate].NumAdjacentMines ++;
                }
            }
        }
        }
    
        if (x_coordinate == grid_size -1 && y_coordinate >= 1 && y_coordinate <= grid_size -2){ // rightmost column
            start_y = y_coordinate-1;
            end_y = y_coordinate+1;
            start_x = grid_size-2;
            end_x = grid_size-1;
            for (int i = y_coordinate-1; i<=y_coordinate+1; i++){
                for (int j = grid_size-2; j<=grid_size-1; j++){
                    if (Grid_Array[i][j].IsMine == true){
                        Grid_Array[y_coordinate][x_coordinate].NumAdjacentMines ++;
                }
            }
        }
        }
        if (x_coordinate >= 1 && x_coordinate <= grid_size -2 && y_coordinate == grid_size-1){ // bottom row
            start_y = grid_size-2;
            end_y = grid_size-1;
            start_x = x_coordinate-1;
            end_x = x_coordinate+1;
            for (int i = grid_size-2; i<=grid_size-1; i++){
                for (int j = x_coordinate-1; j<=x_coordinate+1; j++){
                    if (Grid_Array[i][j].IsMine == true){
                        Grid_Array[y_coordinate][x_coordinate].NumAdjacentMines ++;
                }
            }
        }
        }
        if (x_coordinate >= 1 && x_coordinate <= grid_size -2 && y_coordinate >= 1 && y_coordinate <= grid_size -2){ // everything else 
            // (exluding all tiles surroudning, aka inner square)
            start_y = y_coordinate-1;
            end_y = y_coordinate+1;
            start_x = x_coordinate-1; 
            end_x = x_coordinate+1;
            for (int i = y_coordinate-1; i<=y_coordinate+1; i++){
                for (int j = x_coordinate-1; j<=x_coordinate+1; j++){
                    if (Grid_Array[i][j].IsMine == true){
                        Grid_Array[y_coordinate][x_coordinate].NumAdjacentMines ++;
                }
            }
        }
        }
    
        
        }

        if (Grid_Array[y_coordinate][x_coordinate].isBlank == true){
            for (int i = start_y; i <= end_y; i++){
                for (int j = start_x; j<= end_x; j++){
                    if (Grid_Array[i][j].isflipped == false && Grid_Array[i][j].IsMine == false){
                         // If it is not already flipped.
                        flipTile(j, i); // flipping the coordinates around.
                    } 
                }
            }
        }
    }
                    
        }