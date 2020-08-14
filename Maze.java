import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Maze {
    boolean solved = false;

    private char[][] maze;
    private int colStart, rowStart;
    private int rows, cols;
    boolean wall = false;
    int nrows = 8;
    int ncols = 13;
    private String outputFilename; // this is a way to pass the output filename from the main method to this class

    public static void main(String[] args) throws IOException {
        String fileName = "map.txt";
        Maze m = new Maze(fileName);

    }

    public Maze(String filename) throws IOException {
        try {
            this.outputFilename = filename;
            Scanner scan = new Scanner(new File(filename));
            StringBuilder sb = new StringBuilder();
            while (scan.hasNext()) {
                sb.append(scan.nextLine());
                this.rows++;
            }
            this.cols = sb.length() / this.rows;
            this.maze = new char[this.rows][this.cols];
            int m = 0;
            System.out.println();
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.cols; j++) {
                    this.maze[i][j] = sb.charAt(m++);
                }
            }
            scan.close();
            findStart();
            findPath(this.rowStart, this.colStart);
            printMaze(8, 13);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("ERROR : " + e.getMessage());
        }
    }

    /**
     * instantiate the index value value of 'S' to this.rowStart, this.colStart
     */
    private void findStart() {
        this.rowStart = 0;
        this.colStart = 0;
//	for (int i = 0; i < this.rows; i++) {
//	for (int j = 0; j < this.cols; j++) {
//	if (theMaze[i][j] == 'S') {
//
//	}
//	}
//	}
    }


    public void findPath(int row, int col) {

        if (maze[row][col] == '@') {

            solved = true;
//printMaze(8, 13);
            return;

        }

        maze[row][col] = '+';

        if (((row - 1) >= 0) && (maze[row - 1][col] == '-' || maze[row - 1][col] == '@')) {

            findPath(row - 1, col);

        } else if (((col + 1) < ncols) && (maze[row][col + 1] == '-' || maze[row][col + 1] == '@')) {

            findPath(row, col + 1);

        } else if (((row + 1) < nrows) && (maze[row + 1][col] == '-' || maze[row + 1][col] == '@')) {

            findPath(row + 1, col);

        } else if (((col - 1) >= 0) && (maze[row][col - 1] == '-' || maze[row][col - 1] == '@')) {

            findPath(row, col - 1);

        } else {
            maze[row][col] = '!';
            wall = true;

            return;

        }

        if (wall) {
            maze[row][col] = '!';
            wall = false;

            findPath(row, col);

        }

    }

    public void printMaze(int rows, int cols) {
        if (solved == true)
            for (int i = 0; i < rows; i++) {

                for (int j = 0; j < cols; j++) {

                    System.out.print(maze[i][j]);

                }

                System.out.println();

            }
        else {
            System.out.println("Not Solvable");
            for (int i = 0; i < rows; i++) {

                for (int j = 0; j < cols; j++) {

                    System.out.print(maze[i][j]);

                }

                System.out.println();

            }
        }


    } // no path exists. Eventually every path will lead to dead end.
}
