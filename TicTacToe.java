import java.util.Scanner;
public class TicTacToe {

    private static char[][] board = new char[3][3];
    private static int takenSpotsCounter = 0;

    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        initializeGame();
        while (true){
            updateBoardOutput();
            System.out.println("\nPlayer 1 (O):");
            System.out.println("Row: ");
            int x1 = in.nextInt();
            System.out.println("Column: ");
            int y1 = in.nextInt();
            int check1 = updateBoardValues(x1, y1, 1);
            if (isWin()==1){
                System.out.println("Congratulations! Player 1 wins!");
                updateBoardOutput();
                break;
            }
            else if (takenSpotsCounter==9){
                System.out.println("It's a draw!");
                updateBoardOutput();
                break;
            }
            if (check1 != 1){
                System.out.println("Spot taken! You lose your turn.");
                System.out.println("Pay attention next time.");
            }
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

    public static void initializeGame(){
        System.out.println("\nWelcome to Tic Tac Toe!");
        System.out.println("Directions:");
        System.out.println("Choose a spot on the board by typing row and column numbers indexed at 0.");
        System.out.println("Ex.) Row: 0, Column: 1");
        System.out.println("Win the game when you get three spaces in a row vertically, horizontally, or diagonally.");
        System.out.println("Good Luck!!!");
    }

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

    public static void updateBoardOutput(){
        for (int i = 0; i < 3; i++){
            System.out.println("| "+board[i][0] + " | "+board[i][1]+" | "+board[i][2] + " |");
       }
    }

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