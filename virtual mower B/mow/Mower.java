package mow;

public class Mower {

    private int row;      // vertical position
    private int col;      // horizontal position
    private int direction; // 0 = up, 1 = right, 2 = down, 3 = left

    // Constructor
    public Mower(int startRow, int startCol, int startDir) {
        row = startRow;
        col = startCol;
        direction = startDir;
    }

    // Getters and setters
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction % 4; // ensure 0-3
    }

    // Turn left or right
    public void turnLeft() {
        direction = (direction + 3) % 4; // turn counter-clockwise
    }

    public void turnRight() {
        direction = (direction + 1) % 4; // turn clockwise
    }

    // Move forward one unit
    public void moveForward() {
        switch (direction) {
            case 0: row--; break;  // up
            case 1: col++; break;  // right
            case 2: row++; break;  // down
            case 3: col--; break;  // left
        }
    }

    // Sense the cell in front
    public char senseAhead(Yard yard) {
        int r = row, c = col;
        switch (direction) {
            case 0: r--; break;
            case 1: c++; break;
            case 2: r++; break;
            case 3: c--; break;
        }
        return yard.getCell(r, c);
    }

    // Cut grass under the mower
    public void cutGrass(Yard yard) {
        if (yard.getCell(row, col) == '+') {
            yard.setCell(row, col, ' ');
        }
    }

    // Get the character representing the mower for display
    public char getSymbol() {
        switch (direction) {
            case 0: return '^';
            case 1: return '>';
            case 2: return 'v';
            case 3: return '<';
        }
        return '?';
    }
}