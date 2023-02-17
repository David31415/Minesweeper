import java.util.*;

class Main{ // Main class, where everything from the 3 classes interact with one another. 
    public static void main(String[] args){ 
        Game g = new Game(); // Creating a new game object. You can only use the methods attributed to one class if you make that class object.
        boolean GameOn = false; // GameOn is for the playing while loop.
        boolean safe = true; // Safe is for the flipping/flagging tiles while loop and ensuring that a mine is not flipped.
        String player_choice; // Player_choice corresponds to user_choice.
        Scanner user_choice = new Scanner(System.in); // Allows for user input.
        System.out.println("Hello, do you want to play Minesweeper? Please enter Y or N.");
        player_choice = user_choice.nextLine();
        if (player_choice.equals("Y")){
            System.out.println("Starting game...");
            GameOn = true; // Starting game if they answer yes.
        }
        else{
            GameOn = false;
        }

        while(GameOn){ // create while true loop ask player if they want to play or not.
            g.startGame(); // Refers to method in the Game class.
            g.arena.countMines(); // Count the total number of mines.
            while(safe){
                    System.out.println("There are " + g.arena.total_mines + " mines left."); // Print out total mines number.
                    System.out.println("Which tile would you like to flag/unflag or flip?");
                    player_choice = user_choice.nextLine(); // To flip a tile,  type in the coordinates separated by a space.
                    // To flag a tile, type in "f",  followed by a space and then the coordinates.

                if (player_choice.substring(0,1).equals("f")){ // If the first character in the user input is "f",
                // we will flag it. Note that the substring indexing follows the "up to but not including" rule.

                    if (player_choice.length() == 5){ // If the total length is 5, we know the pair of coordinates to flag is a single digit pair.
                            g.arena.flagTile(Integer.parseInt(player_choice.substring(2, 3)), 
                        Integer.parseInt(player_choice.substring(4,5)));
                        // ParseInt function turns each coordinate (obtained from the substring function) into an integer. 
                        // These 2 arguments (x and y coordinates) then get inputted into the flagTile(arg, arg) method. 
                        }
                    
                    if (player_choice.length() == 7){ // If the total length is 7, we know the pair of coordinates to flag is a double digit pair.
                            g.arena.flagTile(Integer.parseInt(player_choice.substring(2, 4)),
                        Integer.parseInt(player_choice.substring(5,7)));
                        // Same logic.
                        }
                    
                    if (player_choice.length() == 6){ // However, in the cases where the length is 6, we have 2 cases.
                        if (player_choice.substring(3, 4).equals(" ")){
                            // Case 1 is a single digit followed by a double digit. 
                            // We test this to see if there is a space immediately after the first number (first coordinate).
                            // If there is, we know it is a single digit followed by a double digit. 
                                g.arena.flagTile(Integer.parseInt(player_choice.substring(2,3)), 
                            Integer.parseInt(player_choice.substring(4, 6)));
                            }
                            
                        else{
                            // Otherwise, we know it is a double digit, then followed by a single digit. 
                                g.arena.flagTile(Integer.parseInt(player_choice.substring(2, 4)),
                            Integer.parseInt(player_choice.substring(5, 6)));
                        }
                            
                        }
                    }
                    else{ // Otherwise, we would flip the tiles. 
                        // I made the if and else statements so that a tile can't flag and flip at the same time. 
                        // It is the same logic, except that there is no "f" in index 0. 
                        if (player_choice.length() == 3){ // We know this is a single digit followed by a single digit. 
                    g.arena.flipTile(Integer.parseInt(player_choice.substring(0,1)), 
                Integer.parseInt(player_choice.substring(player_choice.length()-1, player_choice.length())));
                }

                if (player_choice.length() == 5){
                    g.arena.flipTile(Integer.parseInt(player_choice.substring(0,2)),
                Integer.parseInt(player_choice.substring(player_choice.length()-2, player_choice.length())));
                // Double digit followed by a double digit coordinate.
                }

                if (player_choice.length() == 4){ // Either a single double or double single.
                    if (player_choice.substring(1, 2).equals(" ")){ // If index 1 is null value, then we know
                        // that it must be a single, double.
                        g.arena.flipTile(Integer.parseInt(player_choice.substring(0,1)),
                Integer.parseInt(player_choice.substring(player_choice.length()-2, player_choice.length())));
                    }

                    else { // otherwise it has to be a double digit, then single.
                        g.arena.flipTile(Integer.parseInt(player_choice.substring(0,2)),
                Integer.parseInt(player_choice.substring(player_choice.length()-1, player_choice.length())));
                    }
                }
                    }
                    
                if (g.arena.endgame == true){ // Check to see if you flipped a mine.
                    g.losingGame(); // If so, we reveal the mines and break out of the loop.
                    safe = false;
                    break;
                }
                if (g.arena.endgame == false){ // If you don't flip a mine, print the grid and show the updated settings. 
                    g.arena.printGrid();
                }
                if (g.arena.total_mines == 0){ // Check to see the total number of mines.
                    g.winningGame(); // If there is no mines left, you win the game.
                    safe = false;
                    break;
                }

                
            }

            System.out.println("Play again?"); // Ask if they want to play again.
            player_choice = user_choice.nextLine();
            if (player_choice.equals("Y")){
                safe = true;
            }
            else{ // If not, we break out of the while loop.
                GameOn = false;
            }
}
}
}