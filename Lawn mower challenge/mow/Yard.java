package mow;

public class Yard {
    public char[][] yard;

    public Yard(int height, int width) {
        if (height < 1 || width < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1.");
        }

        int totalRows = height + 2;
        int totalCols = width + 2;
        yard = new char[totalRows][totalCols];

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                boolean boundary = row == 0 || row == totalRows - 1 || col == 0 || col == totalCols - 1;
                yard[row][col] = boundary ? 'R' : '+';
            }
        }
    }

    public char getCell(int row, int column) {
        return yard[row][column];
    }

    public void setCell(int row, int column, char value) {
        yard[row][column] = value;
    }

    public int getHeight() {
        return yard.length - 2;
    }

    public int getWidth() {
        return yard[0].length - 2;
    }

    public void printYard() {
        for (char[] row : yard) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public void printYard(Mower mower) {
        for (int rowIndex = 0; rowIndex < yard.length; rowIndex++) {
            for (int colIndex = 0; colIndex < yard[rowIndex].length; colIndex++) {
                if (rowIndex == mower.getRow() && colIndex == mower.getColumn()) {
                    System.out.print(mower.getDirectionSymbol());
                } else {
                    System.out.print(yard[rowIndex][colIndex]);
                }
            }
            System.out.println();
        }
    }
}