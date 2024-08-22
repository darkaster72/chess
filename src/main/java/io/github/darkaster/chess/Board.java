package io.github.darkaster.chess;

public class Board {
    private static final int SIZE = 8;

    private static final IPieceType[] initialPieces = {
            NewPieceType.ROOK,
            NewPieceType.KNIGHT,
            NewPieceType.BISHOP,
            NewPieceType.QUEEN,
            NewPieceType.KING,
            NewPieceType.BISHOP,
            NewPieceType.KNIGHT,
            NewPieceType.ROOK
    };

    private Cell[][] cells;

    Board() {
        cells = new Cell[SIZE][SIZE];
        populateBoard();
    }

    private void populateBoard() {
        for (int rank = 0; rank < SIZE; rank++) {
            for (int file = 0; file < SIZE; file++) {
                cells[rank][file] = new Cell(rank, file);
            }
        }

        for (int j = 0; j < SIZE; j++) {
            // set black pieces
            cells[0][j].setPiece(new Piece(initialPieces[j], ColorType.BLACK));
            cells[1][j].setPiece(new Piece(NewPieceType.PAWN, ColorType.BLACK));

            // set white pieces
            cells[7][j].setPiece(new Piece(initialPieces[j], ColorType.WHITE));
            cells[6][j].setPiece(new Piece(NewPieceType.PAWN, ColorType.WHITE));
        }
    }

    public Cell getCell(int i, int j) {
        return cells[i][j];
    }

    public void makeMove(Move move) {
        Cell fromCell = move.getFromCell();
        Cell toCell = move.getToCell();

        toCell.setPiece(move.getFromPiece());
        fromCell.setPiece(null);
    }
}
