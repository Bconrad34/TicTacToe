import java.util.Scanner;
//this program creates a simple two player tictactoe game
public class TicTacToe {

    //create variables, one for the board matrix and one for the counter to see if the game is a tie
    private static char[][] board = new char[3][3];
    private static int takenSpotsCounter = 0;

    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        //call method to start game
        initializeGame();

        while (true){
            //we want to print the board right before each turn
            updateBoardOutput();
            //have the player 1 choose the spot on the board, and then update the board
            System.out.println("\nPlayer 1 (O):");
            System.out.println("Row: ");
            int x1 = in.nextInt();
            System.out.println("Column: ");
            int y1 = in.nextInt();
            int check1 = updateBoardValues(x1, y1, 1);
            //after every choice, check to see if the player has won, if so, break loop
            if (isWin()==1){
                System.out.println("Congratulations! Player 1 wins!");
                updateBoardOutput();
                break;
            }
            //also need to check if all spots on the board are filled, if so, tie
            else if (takenSpotsCounter==9){
                System.out.println("It's a draw!");
                updateBoardOutput();
                break;
            }
            //also need to check if the player is trying to choose a spot that is already taken, if so, penalize the player
            if (check1 != 1){
                System.out.println("Spot taken! You lose your turn.");
                System.out.println("Pay attention next time.");
            }
            //repeat for player 2
            updateBoardOutput();
            System.out.println("\nPlayer 2 (X):");
            System.out.println("Row: ");
            int x2 = in.nextInt();
            System.out.println("Column: ");
            int y2 = in.nextInt();
            int check2 = updateBoardValues(x2, y2, 2);
            if (isWin()==1){
                System.out.println("Congratulations! Player 2 wins!");
                updateBoardOutput();
                break;
            }
            else if (takenSpotsCounter==9){
                System.out.println("It's a draw!");
                updateBoardOutput();
                break;
            }
            if (check2 != 1){
                System.out.println("Spot taken! You lose your turn.");
                System.out.println("Pay attention next time.");
            }


        }
    }

    //this function will display the directions for the game
    public static void initializeGame(){
        System.out.println("\nWelcome to Tic Tac Toe!");
        System.out.println("Directions:");
        System.out.println("Choose a spot on the board by typing row and column numbers indexed at 0.");
        System.out.println("Ex.) Row: 0, Column: 1");
        System.out.println("Win the game when you get three spaces in a row vertically, horizontally, or diagonally.");
        System.out.println("Good Luck!!!");
    }

    //this function updates the board matrix, also updating the takenSpotsCounter if a new position was filled
    public static int updateBoardValues(int x, int y, int player){
        if (board[x][y] == 'O' || board[x][y] == 'X'){
            return 0;
        }
        if (player == 1){
            board[x][y] = 'O';
            takenSpotsCounter++;
        }
        else if (player == 2){
            board[x][y] = 'X';
            takenSpotsCounter++;
        }
            return 1;
    }

    //this function prints the current board to the screen, making it look like a real tictactoe board
    public static void updateBoardOutput(){
        for (int i = 0; i < 3; i++){
            System.out.println("| "+board[i][0] + " | "+board[i][1]+" | "+board[i][2] + " |");
       }
    }

    //this function checks te possible winning combinations to see if the board contains a winning combination
    public static int isWin(){
        if ((board[0][0] == board[1][1]) && (board[0][0] == board[2][2]) && (board[1][1]==board[2][2]) && board[0][0] != 0){
            return 1;
        }
        else if ((board[0][2] == board[1][1]) && (board[0][2] == board[2][0]) && (board[1][1]==board[2][0]) && board[0][2] != 0){
            return 1;
        }
        for (int x = 0; x < 3; x++){
            if ((board[0][x]==board[1][x]) && (board[0][x]==board[2][x]) && (board[1][x]==board[2][x]) &&board[0][x] != 0){
                return 1;
            }
            else if ((board[x][0]==board[x][1]) && (board[x][0]==board[x][2]) && board[x][1]==board[x][2] && board[x][0] != 0){
                return 1;
            }
        }
        return 0;
    }

}