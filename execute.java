import java.util.*;

class Main{
    public static void main(String[] args){
        Game g = new Game();
        boolean GameOn = false;
        boolean safe = true;
        String player_choice;
        Scanner user_choice = new Scanner(System.in); // Allows for user input.
        System.out.println("Hello, do you want to play Minesweeper? Please enter Y or N.");
        player_choice = user_choice.nextLine();
        if (player_choice.equals("Y")){
            System.out.println("Starting game...");
            GameOn = true;
        }
        else{
            GameOn = false;
        }

        while(GameOn){ // create while true loop ask player if they want to play or not.
            g.startGame(); 
            g.arena.showMines();
            g.arena.printGrid();
            while(safe){
                System.out.println("Which tile would you like to flag or flip?");
                player_choice = user_choice.nextLine();
                if (player_choice.length() == 3){ // single single coordinate 
                    g.arena.flipTile(Integer.parseInt(player_choice.substring(0,1)), 
                Integer.parseInt(player_choice.substring(player_choice.length()-1, player_choice.length())));
                }
                if (player_choice.length() == 5){
                    g.arena.flipTile(Integer.parseInt(player_choice.substring(0,2)),// double double coord.
                Integer.parseInt(player_choice.substring(player_choice.length()-2, player_choice.length())));
                }
                if (player_choice.length() == 4){ // either a single double or double single.
                    if (player_choice.substring(1, 2).equals(" ")){ // if the index 1 is null value, then we know
                        // that it must be a single, double.
                        g.arena.flipTile(Integer.parseInt(player_choice.substring(0,1)),
                Integer.parseInt(player_choice.substring(player_choice.length()-2, player_choice.length())));
                    }
                    else { // else it has to be a double, single.
                        g.arena.flipTile(Integer.parseInt(player_choice.substring(0,2)),
                Integer.parseInt(player_choice.substring(player_choice.length()-1, player_choice.length())));
                    }
                }
                if (g.arena.endgame == true){
                    safe = false;
                    break;
                }
                if (g.arena.endgame == false){
                    g.arena.printGrid();
                }
            }

            System.out.println("Play again?");
            player_choice = user_choice.nextLine();
            if (player_choice.equals("Y")){
                GameOn = true;
                safe = true;
            }
            else{
                GameOn = false;
                break;
            }
            
}
}
}