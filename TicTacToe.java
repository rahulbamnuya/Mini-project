import java.util.Scanner;

public class TicTacToe 
    {
    private static char[][] board;
    private static char currentPlayer;
    private static String playerXName;
    private static String playerOName;

    public static void main(String[] args)
     {
        //Game mayrix initialize
        initializeGame();
        //Display the matrix blue print 
        //along horizontal vertical line
        displayBoard();

        while (true) 
        {
            // take input from user
            makeMove(); 
            //display input value along with user name 
            displayBoard();
// condition they win or not//
            if (checkWin()) {
                if (currentPlayer == 'X')
                 {
    System.out.print(playerXName);
    System.out.println( " is winner ");
    System.out.println("Thankyou for playing");
    break;
} 
else 
{
    System.out.println(playerOName);
    System.out.println(" is winner ");
    System.out.println("Thankyou for playing");
    break;
}

            }
            //check board is empty or full 
            else if (isBoardFull()) 
            //change one player to another//
            {
                System.out.println("The game is  tie.");
                break;
            }

            switchPlayer();
            // change player X to O and O to X//
        }
    }
//INITIALIZE game matrix
    private static void initializeGame() 
    {
        board = new char[3][3];
        currentPlayer = 'X';

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Game TicTacToe Started ");

// make sure that in your respective block you 
//in which you want to put your choice you shoud 
//represent as matrix row AND columns//
System.out.println();
System.out.println("Some important rules .");
System.out.println();
System.out.println("1. you should only when your turns.");
System.out.println();
System.out.println("2. when you play make shure that");
System.out.println();
System.out.println("3.your chice represent as a matrix form");
System.out.println();
System.out.println("4. Example  row 0 col 0 represent first block");
System.out.println();
System.out.println();
        System.out.print("Player X Name is : ");
        playerXName = sc.nextLine();

        System.out.println();
        System.out.print("Player O Nmae is : ");
        playerOName = sc.nextLine();
        System.out.println();
        initBoard();  //call matrix blue print
    }


    // print matrix in respective size//
      private static void initBoard() 
      {
        for (int row = 0; row < 3; row++)
         {
            for (int col = 0; col < 3; col++)
             {
                board[row][col] = ' ';
            }
        }
    }

    //matrix blue print//

    private static void displayBoard() 
    {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) 
        {
            System.out.print("| ");
            for (int col = 0; col < 3; col++)
             {
                System.out.print(board[row][col] + " | ");
            }
            System.out.print("\n-------------");
            System.out.println();
            System.out.println();
        }
    }
    // matrix call end blue print printed


    // now input values
    private static void makeMove() {
        Scanner sc = new Scanner(System.in);

        while (true)
        
        {
            if (currentPlayer == 'X')
             {
                System.out.print(playerXName);
            } else 
            {
                System.out.print(playerOName);
            }
            
             System.out.print(" your turn: ");
             System.out.println();
             System.out.println();
             System.out.print("enter row column : ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            System.out.println();
//now check row column exist 
            if (isValidMove(row, col))
             {
                board[row][col] = currentPlayer;
                break;
            } else 
            {
                //in case not exist so new change for user//
                //enter valid
                System.out.println();
                System.out.println("Invalid move." );
                System.out.println();
                System.out.println("Try again");
            }
        }
    }
//chevck valid condition//
    private static boolean isValidMove(int row, int col)
     {
        return row >= 0 && row < 3 && col >= 0 && col < 3 
        && board[row][col] == ' ';
    }
//  winner selection
    private static boolean checkWin() 
    {
        // Check rows, columns, and diagonals for a win

        for (int i = 0; i < 3; i++) {
            //Check first row equal to X or O
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer
             && board[i][2] == currentPlayer)
               {
                 return true
                 ;
               }
               //Check second row equal to X or O//
                          
               if (board[0][i] == currentPlayer && board[1][i] == currentPlayer
             && board[2][i] == currentPlayer)
               { 
                return true;
            }
        }//check third row equal or
         //not to X or O//
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer
         && board[2][2] == currentPlayer)
            {
                return true;
            }// they Check diagonal right //
            //equal to X or O
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer 
        && board[2][0] == currentPlayer)
           { 
            return true;
        }

        return false;
    }


    /// board is full or emplty 
    //checking condition//
    private static boolean isBoardFull()
     {
        for (int row = 0; row < 3; row++) 
        {
            for (int col = 0; col < 3; col++) 
            {
                if (board[row][col] == ' ')
                 {
                    return false;
                }
            }
        }
        return true;
    }


    // Switching player X to O an O to X
    private static void switchPlayer()
     {
        if (currentPlayer == 'X')
        {
    currentPlayer = 'O';
}
else
{
    currentPlayer = 'X';
}

    }
}
