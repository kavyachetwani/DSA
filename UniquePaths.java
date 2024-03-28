package Maze;

public class UniquePaths {
    private static boolean isSafe(int[][] matrix, boolean[][] visited, int x, int y)
    {
        return (x>=0 && x< matrix.length && y>=0 && y<matrix[0].length) && matrix[x][y] == 1 && !visited[x][y];
    }
    public static int countPath(int[][] matrix, boolean[][] visited, int i, int j, int x, int y)
    {
        //this is when we reach the required destination x,y
        if(i == x && j == y)
        {
            return 1;
        }

        int count = 0;

        visited[i][j] = true;

        //to go to top cell
        if(isSafe(matrix, visited, i - 1, j) && i - 1 >=0)
        {
            count +=countPath(matrix, visited, i - 1, j, x, y);
        }
        //to go to the bottom cell
        if(isSafe(matrix, visited, i + 1, j) && i + 1 < matrix.length)
        {
            count += countPath(matrix, visited, i + 1, j, x, y);
        }
        //to go to the right cell
        if(isSafe(matrix, visited, i, j+1) && j + 1 < matrix[0].length)
        {
            count += countPath(matrix, visited, i, j + 1, x, y);
        }
        //to go to the left cell
        if(isSafe(matrix, visited, i, j - 1) && j -1 >= 0)
        {
            count += countPath(matrix, visited, i, j - 1, x, y);
        }
        //backtracking it and removing it from current path
        visited[i][j] = false;

        return count;
    }
    public static int findCount(int[][] matrix, int i, int j, int x, int y)
    {
        if(matrix == null || matrix.length == 0 || matrix[i][j] == 0 || matrix[x][y] == 0)
        {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] visited = new boolean[n][m];

        return countPath(matrix, visited, i, j, x, y);
    }

    public static void main(String[] args) {
        int[][] matrix =  {
                { 1, 1, 1, 1 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 1 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 1 },
                { 1, 1, 0, 1 },
        };

        int count = findCount(matrix, 0, 0, 5, 3);
        System.out.println("The number of unique paths are " + count);
    }
}
