public class WordSearch {
    public static boolean wordExist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int row, int col, String word, int indx) {
        if (indx == word.length())
            return true;

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(indx)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#'; // Temporarily mark current cell as visited

        // Explore all 4 directions
        boolean found = dfs(board, row + 1, col, word, indx + 1) ||
                dfs(board, row - 1, col, word, indx + 1) ||
                dfs(board, row, col + 1, word, indx + 1) ||
                dfs(board, row, col - 1, word, indx + 1);

        // Restore cell after backtracking

        board[row][col] = temp;

        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };

        String word = "ABCCED";
        boolean ans = wordExist(board, word);
        System.out.println("Does the word exist in the board? " + ans);
    }
}
