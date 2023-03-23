import java.util.Random;
import java.util.Scanner;

public class GuessANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random ran = new Random();

        int computerNumber = ran.nextInt(100);
        computerNumber += 1;

        int playerNumber = 0;
        String playerInput = "";
        int gameLevel = 1;
        int playerAttemptsCounter = 0;
        int totalPlayedGamesCounter = 0;
        int playedLevel1Games = 0;
        int playedLevel2Games = 0;
        int playedLevel3Games = 0;
        int guessedNumbersCounter = 0;
        int guessedNumbersAtLevel1 = 0;
        int guessedNumbersAtLevel2 = 0;
        int guessedNumbersAtLevel3 = 0;

        while (!playerInput.equals("no")) {

            //Check for the chosen difficulty level by the user
            if (playerInput.equals("1") || playerInput.equals("[1]")) {
                gameLevel = 1;
            } else if (playerInput.equals("2") || playerInput.equals("[2]")) {
                gameLevel = 2;
            } else if (playerInput.equals("3") || playerInput.equals("[3]")) {
                gameLevel = 3;
            }

            //Asking for and then reading player's suggestion. If game level == 2, then the number will be between 1 and 200:
            if (gameLevel == 1 || gameLevel == 3) {
                System.out.print("Guess a number between 1 and 100: ");
            } else if (gameLevel == 2) {
                System.out.print("Guess a number between 1 and 200: ");
            }
            playerInput = scanner.nextLine();
            boolean isValidNumber = true;

            //Check for correct input by the user. The different chars of the input String are checked if they are numbers
            for (int i = 0; i < playerInput.length(); i++) {
                if (playerInput.charAt(i) >= 48 && playerInput.charAt(i) <= 57) {
                    continue;
                } else {
                    System.out.println("Invalid input!");
                    isValidNumber = false;
                    break;
                }
            }

            //Interrupt the loop's iteration if player's input is invalid
            if (!isValidNumber) {
                playerInput = "" + gameLevel;
                continue;
            }

            playerNumber = Integer.parseInt(playerInput);

            //Comparing of player's number and computer's number
            if (playerNumber < computerNumber) {
                System.out.println("The unknown number is higher");
                playerInput = "" + gameLevel;
                playerAttemptsCounter++;
                //Check for made 5 attempts in level 3
                if (playerAttemptsCounter == 5 && gameLevel == 3) {
                    System.out.printf("You couldn't guess the number in 5 tries. The number was: %d. Game over%n", computerNumber);
                    totalPlayedGamesCounter++;
                    if (gameLevel == 1) {
                        playedLevel1Games++;
                    } else if (gameLevel == 2) {
                        playedLevel2Games++;
                    } else if (gameLevel == 3) {
                        playedLevel3Games++;
                    }
                    break;
                }
            } else if (playerNumber > computerNumber) {
                System.out.println("The unknown number is lower");
                playerInput = "" + gameLevel;
                playerAttemptsCounter++;
                //Check for made 5 attempts in level 3
                if (playerAttemptsCounter == 5 && gameLevel == 3) {
                    System.out.printf("You couldn't guess the number in 5 tries. The number was: %d. Game over%n", computerNumber);
                    totalPlayedGamesCounter++;
                    if (gameLevel == 1) {
                        playedLevel1Games++;
                    } else if (gameLevel == 2) {
                        playedLevel2Games++;
                    } else if (gameLevel == 3) {
                        playedLevel3Games++;
                    }
                    break;
                }
            } else {
                System.out.println("Congratulations! You guessed.");
                totalPlayedGamesCounter++;
                guessedNumbersCounter++;
                playerAttemptsCounter = 0;
                if (gameLevel == 1) {
                    playedLevel1Games++;
                    guessedNumbersAtLevel1++;
                } else if (gameLevel == 2) {
                    playedLevel2Games++;
                    guessedNumbersAtLevel2++;
                } else if (gameLevel == 3) {
                    playedLevel3Games++;
                    guessedNumbersAtLevel3++;
                }
                System.out.println("Would you like to find another number?");
                System.out.print("Type [no] to stop the game or [yes] to continue: ");
                playerInput = scanner.nextLine();
                //Check if the input to stop or continue the game is correct:
                while (!playerInput.equals("no") && !playerInput.equals("No") && !playerInput.equals("NO") && !playerInput.equals("[no]") &&
                !playerInput.equals("[yes]") && !playerInput.equals("yes") && !playerInput.equals("Yes") && !playerInput.equals("YES")) {
                    System.out.print("Invalid input. Type [no] to stop the game or [yes] to continue: ");
                    playerInput = scanner.nextLine();
                }
                //If player wants to play another game, the program is asking the player to choose difficulty level for the next game:
                if (playerInput.equals("yes") || playerInput.equals("Yes") || playerInput.equals("YES") || playerInput.equals("[yes]")) {
                    System.out.println("Please choose difficulty level:");
                    System.out.println("Easy level (between 1 and 100 and unlimited tries).");
                    System.out.println("Medium level (between 1 and 200 and unlimited tries).");
                    System.out.println("Hard level (between 1 and 100 and 5 tries only).");
                    System.out.print("Type [1] for easy, [2] for medium and [3] for hard: ");
                    playerInput = scanner.nextLine();

                    //Check if the input for the next game difficulty level is correct:
                    while (!playerInput.equals("1") && !playerInput.equals("[1]]") && !playerInput.equals("2") && !playerInput.equals("[2]") &&
                            !playerInput.equals("[3]") && !playerInput.equals("3")) {
                        System.out.print("Invalid input. Type 1 for easy, 2 for medium or 3 for hard difficulty level: ");
                        playerInput = scanner.nextLine();
                    }

                    // Getting new random computer number for the next game:
                    gameLevel = Integer.parseInt(playerInput);
                    if (gameLevel == 1 || gameLevel == 3) {
                        computerNumber = ran.nextInt(100);
                        computerNumber += 1;
                    } else if (gameLevel == 2) {
                        computerNumber = ran.nextInt(200);
                        computerNumber += 1;
                    }

                }

            }


        }

        System.out.printf("You played %d games in total:%n", totalPlayedGamesCounter);
        System.out.printf("%d games at level 1;%n", playedLevel1Games);
        System.out.printf("%d games at level 2;%n", playedLevel2Games);
        System.out.printf("%d games at level 3.%n", playedLevel3Games);
        System.out.printf("You guessed %d numbers:%n", guessedNumbersCounter);
        System.out.printf("%d guessed numbers at level 1;%n", guessedNumbersAtLevel1);
        System.out.printf("%d guessed numbers at level 2;%n", guessedNumbersAtLevel2);
        System.out.printf("%d guessed numbers at level 3;%n", guessedNumbersAtLevel3);
    }
}
