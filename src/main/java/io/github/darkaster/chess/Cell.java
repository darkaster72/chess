package io.github.darkaster.chess;


enum CellState {
    EMPTY,
    OCCUPIED,
    CHECK,
    CHECKMATE
}

public class Cell implements CellNotation {
    private int row; // row
    private int col; // column
    private Piece piece;
    private boolean isSelected;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellState getState() {
        return piece == null ? CellState.EMPTY : CellState.OCCUPIED;
    }

    @Override
    public int getRank() {
        return 8 - row;
    }

    @Override
    public int getFile() {
        return col + 'a';
    }

    public String toString() {
        return String.format("%c%d", getFile(), getRank());
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setIsSelected(boolean value) {
        this.isSelected = value;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
