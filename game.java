import java.util.*;

class Game extends Grid{ // Extends from the Grid class
     Scanner user_input = new Scanner(System.in); // Creating the Scanner object "user_input" for user input.
     Grid arena; // The playing space.
     String player_name; // The name of the player.
     String level; // level of the grid.

     void startGame(){
        System.out.println("Welcome to Minesweeper!"); // Couple of introductions. 
        System.out.println("Please enter your name"); // Set player name.
        player_name = user_input.nextLine();
        System.out.println("Player name is: " + player_name);
        System.out.println("Please enter a level of difficulty between 1 and 3."); // Set game difficulty.
        level = user_input.nextLine();
        while (Integer.parseInt(level) != 1 && Integer.parseInt(level) != 2 && Integer.parseInt(level) != 3){
            // ParseInt function turns inputted string level to an integer. 
            System.out.println("Please enter a level from 1 to 3, and not anything else."); // Handling exception. 
            level = user_input.nextLine(); // Returns player's choice.
        }
        System.out.println("Playing level " + level);
        System.out.println("Starting game... NOW!");
        arena = new Grid(Integer.parseInt(level)); // Convert string to integer for the level the player wants to play. 
        arena.createGrid(); // creating + printing the grid.
        arena.printGrid();

    }
    // Below are some special cases.
    void losingGame(){
        System.out.println("Sorry, you lost :("); 
    }

    void winningGame(){
        System.out.println("Congratulations, you won :)");
    }
}