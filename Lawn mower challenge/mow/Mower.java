package mow;
import java.util.Random;
public class Mower {
    private int row;
    private int col;
    private int direction;
    public Mower(int row, int col, int direction) {
        this.row = row;
        this.col = col;
        this.direction = direction;
    }
    public int getRow() { return row; }
    public void setRow(int row) { this.row = row; }
    public int getCol() { return col; }
    public void setCol(int col) { this.col = col; }
    public int getDirection() { return direction; }
    public void setDirection(int direction) { this.direction = direction; }
    public void moveForward() {
        if (direction == 0) row--;
        else if (direction == 1) col++;
        else if (direction == 2) row++;
        else if (direction == 3) col--;
    }
    public void turnLeft() {
        direction = (direction + 3) % 4;
    }
    public void turnRight() {
        direction = (direction + 1) % 4;
    }
    public char senseForward(Yard yard) {
        int nextRow = row;
        int nextCol = col;
        if (direction == 0) nextRow--;
        else if (direction == 1) nextCol++;
        else if (direction == 2) nextRow++;
        else if (direction == 3) nextCol--;
        return yard.getCell(nextRow, nextCol);
    }
    public char senseRight(Yard yard) {
        int nextRow = row;
        int nextCol = col;
        int rightDir = (direction + 1) % 4;
        if (rightDir == 0) nextRow--;
        else if (rightDir == 1) nextCol++;
        else if (rightDir == 2) nextRow++;
        else if (rightDir == 3) nextCol--;
        return yard.getCell(nextRow, nextCol);
    }
    public char senseLeft(Yard yard) {
        int nextRow = row;
        int nextCol = col;
        int leftDir = (direction + 3) % 4;
        if (leftDir == 0) nextRow--;
        else if (leftDir == 1) nextCol++;
        else if (leftDir == 2) nextRow++;
        else if (leftDir == 3) nextCol--;
        return yard.getCell(nextRow, nextCol);
    }
    public void cutGrass(Yard yard) {
        yard.setCell(row, col, ' ');
    }
    public char getDirectionChar() {
        if (direction == 0) return '^';
        else if (direction == 1) return '>';
        else if (direction == 2) return 'v';
        else return '<';
    }
    public void randomize(Yard yard) {
        Random rand = new Random();
        int lawnHeight = yard.getLawnHeight();
        int lawnWidth  = yard.getLawnWidth();
        int[][] corners = {
            {1, 1},
            {1, lawnWidth},
            {lawnHeight, 1},
            {lawnHeight, lawnWidth}
        };
        int[] corner = corners[rand.nextInt(4)];
        row = corner[0];
        col = corner[1];
        direction = rand.nextInt(4);
    }
    public boolean updateMower(Yard yard) {
        cutGrass(yard);
        if (!hasUnmowedGrass(yard)) {
            return false;
        }
        if (senseForward(yard) == '+') {
            moveForward();
            return true;
        }
        if (senseRight(yard) == '+') {
            turnRight();
            moveForward();
            return true;
        }
        if (senseLeft(yard) == '+') {
            turnLeft();
            moveForward();
            return true;
        }
        turnRight();
        turnRight();
        if (senseForward(yard) == '+') {
            moveForward();
            return true;
        }
        for (int i = 1; i <= yard.getLawnHeight(); i++) {
            for (int j = 1; j <= yard.getLawnWidth(); j++) {
                if (yard.getCell(i, j) == '+') {
                    row = i;
                    col = j;
                    return true;
                }
            }
        }

        return false;
    }
    private boolean hasUnmowedGrass(Yard yard) {
        for (int i = 1; i <= yard.getLawnHeight(); i++) {
            for (int j = 1; j <= yard.getLawnWidth(); j++) {
                if (yard.getCell(i, j) == '+') {
                    return true;
                }
            }
        }
        return false;
    }
}