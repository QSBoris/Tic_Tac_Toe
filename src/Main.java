import java.util.Scanner;

class Main {

    Main() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Player 1, What's your name");
        String p1 = in.nextLine();
        System.out.println("Player 2, What's your name");
        String p2 = in.nextLine();
        char[][] board = new char[3][3];

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                board[i][j] = '-';
            }
        }

        boolean isPlayer1 = true;
        boolean gameEnded = false;

        while(!gameEnded) {
            drawboard(board);
            char symbol = (char)32;
            if (isPlayer1) {
                symbol = (char)120;
            } else {
                symbol = (char)111;
            }

            if (isPlayer1) {
                System.out.println(p1 + "s Turn(x): ");
            } else {
                System.out.println(p2 + "s Tur(o): ");
            }

            int row = 0;
            int col = 0;

            while(true) {
                System.err.println("Enter a row(0,1 or 2): ");
                row = in.nextInt();
                System.out.println("Enter a col (0,1 or 2): ");
                col = in.nextInt();
                if (row >= 0 && col >= 0 && row <= 2 && col <= 2) {
                    if (board[row][col] == '-') {
                        board[row][col] = symbol;
                        if (hasWon(board) == 'x') {
                            System.out.println(p1 + " Has won!");
                            gameEnded = true;
                        } else if (hasWon(board) == 'o') {
                            System.out.println(p2 + " Has won!");
                            gameEnded = true;
                        } else if (hasTied(board)) {
                            System.out.println("It's a tie!");
                        } else {
                            isPlayer1 = !isPlayer1;
                        }
                        break;
                    }

                    System.out.println("Someone has already made a move there!");
                } else {
                    System.out.println("Your row and col are out of bounds!");
                }
            }
        }

        drawboard(board);
    }

    public static void drawboard(char[][] board) {
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                System.out.print(board[i][j]);
            }

            System.out.println();
        }

    }

    public static char hasWon(char[][] board) {
        for(int i = 0; i < 3; ++i) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }

        for(int j = 0; j < 3; ++j) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return board[0][j];
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        } else if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
            return board[2][0];
        } else {
            return '-';
        }
    }

    public static boolean hasTied(char[][] board) {
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        return true;
    }
}