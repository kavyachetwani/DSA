package Maze;



public class ShortestPath {
    public static void main(String[] args)
    {
        int matrix[][] = {
                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
                { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
        };
        int mindist = findShortestPathLength(matrix, 0, 0, 7, 5);
        if(mindist != -1)
        {
            System.out.println("The shortest path from the source to the destination has length " + mindist);
        }
        else
        {
            System.out.println("Destination cannot be reached");
        }
    }
    private static boolean isSafe(int[][] matrix, boolean[][] visited, int x, int y)
    {
        //this method tells us it the specific chosen cell is allowed to be part of the path
        //reasons why it cant be - the source location is a zero, it is already part of the path, index of cell is invalid
        //therfore x and y both are coordinates of cell positions
        return (x>=0 && x < matrix.length && y>=0 && y < matrix[0].length) && matrix[x][y] == 1 && !visited[x][y];
    }
    //actual method
    //to find the shortest path from the source (i,j), the destination cell is (x,y)
    // mindist maintains the shortest path from the source to the destination
    //dist maintains the count of the cells from the source to the current cell
    public static int firdShortestPAth(int[][] matrix, boolean[][] visited, int i, int j, int x, int y, int mindist, int dist)
    {
        //if we find the destination, update the mindist counter
        if(i == x && j == y)
        {
            return Integer.min(dist, mindist);
            //this function of the integer class returns the minimum of the two values
        }
        visited[i][j] = true;
        //set the value of current cell as visited

        //now we explain all the possible movements

        //explore bottom cell
        if(isSafe(matrix, visited, i + 1, j))
        {
            mindist = firdShortestPAth(matrix, visited, i + 1, j , x, y, mindist, dist + 1);
        }
        //explore top cell
        if(isSafe(matrix, visited, i -1, j))
        {
            mindist = firdShortestPAth(matrix, visited, i - 1, j , x, y, mindist, dist + 1);
        }
        //explore left cell
        if(isSafe(matrix, visited, i, j -1))
        {
            mindist = firdShortestPAth(matrix, visited, i, j -1, x, y, mindist, dist + 1);
        }
        //explore right cell
        if(isSafe(matrix, visited, i, j + 1))
        {
            mindist = firdShortestPAth(matrix, visited, i , j + 1, x, y, mindist, dist + 1);
        }

        //backtrack:  we remove i, j from the visited path
        visited[i][j] = false;

        return mindist;
    }

    //we create a wrapper method over the findShortestMethod
    public static int findShortestPathLength(int[][] matrix, int i, int j, int x, int y)
    {
        //base case: for invalid input and to prevent infinite recursion
        if( matrix == null || matrix.length == 0 || matrix[i][j] == 0 || matrix[x][y] == 0 )
        {
            //Neither the source nor the final destination can be 0
            return -1;
        }
        // M x N Matrix
        int m = matrix.length; //gives length of the outer array
        int n = matrix[0].length; //gives the length of the inner array

        int mindist;
        boolean[][] visited = new boolean[m][n];
        //constructing an M x N matrix to keep track of the visited cells

        mindist = firdShortestPAth(matrix, visited, i, j, x, y, Integer.MAX_VALUE, 0);
        if(mindist != Integer.MAX_VALUE)
        {
            return mindist;
        }
        return -1;
    }
}
