import java.util.*;

public class Game extends Grid{
     Scanner user_input = new Scanner(System.in); // Allows for user input.
     Grid arena; // The playing space.
     String player_name; // The name of the player
     String level;
     String user_choice;
     boolean GameOn;
    
    

    Game (){ // empty constructor.
    }

     void startGame(){
        System.out.println("Welcome to Minesweeper!");
        System.out.println("Please enter your name");
        player_name = user_input.nextLine();
        System.out.println("Player name is: " + player_name);
        System.out.println("Please enter a level of difficulty between 1 and 3.");
        level = user_input.nextLine();
        while (Integer.parseInt(level) != 1 && Integer.parseInt(level) != 2 && Integer.parseInt(level) != 3){
            System.out.println("Please enter a level from 1 to 3, and not anything else.");
            level = user_input.nextLine();
        }
        System.out.println("Playing level " + level);
        System.out.println("Starting game... NOW!");
        arena = new Grid(Integer.parseInt(level)); // Convert string to integer.
        arena.createGrid();
        arena.printGrid();

    }

    void endGame() {
        System.out.println("End Game.");
    }
}