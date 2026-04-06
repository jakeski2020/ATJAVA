package mow;

public class Yard {
    public char[][] yard;

    public Yard(int lawnHeight, int lawnWidth) {
        int totalHeight = lawnHeight + 2;
        int totalWidth  = lawnWidth + 2;
        yard = new char[totalHeight][totalWidth];

        for (int i = 0; i < totalHeight; i++) {
            for (int j = 0; j < totalWidth; j++) {
                if (i == 0 || i == totalHeight - 1 || j == 0 || j == totalWidth - 1) {
                    yard[i][j] = 'R';
                } else {
                    yard[i][j] = '+';
                }
            }
        }
    }

    public char getCell(int row, int col) {
        return yard[row][col];
    }

    public void setCell(int row, int col, char value) {
        yard[row][col] = value;
    }

    public int getLawnHeight() {
        return yard.length - 2;
    }

    public int getLawnWidth() {
        return yard[0].length - 2;
    }

    public void print() {
        for (int i = 0; i < yard.length; i++) {
            for (int j = 0; j < yard[0].length; j++) {
                System.out.print(yard[i][j]);
            }
            System.out.println();
        }
    }
}
