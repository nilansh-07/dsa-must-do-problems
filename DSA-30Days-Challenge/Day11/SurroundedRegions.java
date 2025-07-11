public class SurroundedRegions {

    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Mark all 'O's connected to the border with 'T'
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0);         // Left border
            dfs(board, i, cols - 1);  // Right border
        }
        for (int j = 0; j < cols; j++) {
            dfs(board, 0, j);         // Top border
            dfs(board, rows - 1, j);  // Bottom border
        }

        // Step 2: Flip all remaining 'O' to 'X' (surrounded ones)
        // Step 3: Convert 'T' back to 'O' (safe ones)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void dfs(char[][] board, int row, int col) {
        // Boundary and condition check
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
            || board[row][col] != 'O') {
            return;
        }

        board[row][col] = 'T'; // Temporarily mark as safe

        // Visit 4 directions
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }

    public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        solve(board);

        // Print updated board
        System.out.println("Updated Board:");
        for (char[] row : board) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
