package Maze;

public class LongestPath {
    //we cant have any cycles in the path
    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
                { 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }
        };
        int maxdist = findLongestPathLength(matrix, 0, 0, 5, 7);
        System.out.println("The longest path for the given matrix is " + maxdist);

    }
    private static boolean isSafe(int[][] matrix, boolean[][] visited, int x, int y)
    {
        return (x>=0 && x<matrix.length && y>=0 && y<matrix[0].length) && matrix[x][y] == 1 && !visited[x][y];
    }
    public static int findLongestPath(int[][] matrix, boolean[][] visited, int i, int j, int x, int y, int maxdist, int dist)
    {
        if (matrix[i][j] == 0) {
            return 0;
        }
        //Also the base case for recursion
        if(i == x && j == y)
        {
            //if we have reached the destination we update the maxdist
            return Integer.max(dist, maxdist);
        }
        visited[i][j] = true;

        //to explore top cell
        if(isSafe(matrix, visited, i - 1, j))
        {
            findLongestPath(matrix, visited, i - 1, j, x, y,maxdist, dist + 1);
        }

        //to explore bottom cell
        if(isSafe(matrix, visited, i + 1, j))
        {
            findLongestPath(matrix, visited, i + 1, j, x, y, maxdist, dist+1);
        }

        //to explore right cell
        if(isSafe(matrix, visited, i, j + 1))
        {
            findLongestPath(matrix, visited, i , j+1, x, y, maxdist, dist + 1);
        }

        //to explore left cell
        if(isSafe(matrix,visited, i, j -1))
        {
            findLongestPath(matrix, visited, i, j - 1, x, y, maxdist, dist + 1);
        }

        //backtracking: we remove i, j from the visited path
        visited[i][j] = false;


        return maxdist;
    }
    //this is a wrapper method for the findLongestPath method
    public static int findLongestPathLength(int[][] matrix, int i, int j, int x, int y)
    {
        //base case
        if(matrix == null || matrix.length == 0 || matrix[i][j] == 0 || matrix[x][y] == 0)
        {
            return -1;
        }
        //now we create the visited matrix
        int m = matrix.length;
        int n = matrix[0].length;


        boolean[][] visited = new boolean[m][n];


        return findLongestPath(matrix, visited, i, j, x, y, 0 , 0);
    }
}
