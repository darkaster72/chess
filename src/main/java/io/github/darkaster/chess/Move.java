package io.github.darkaster.chess;

enum MoveType {
    NORMAL,
    CASTLING,
    PROMOTION,
    EN_PASSANT,
    CAPTURE
}

public class Move {
    Cell from;
    Cell to;
    Piece fromPiece;
    Piece toPiece;
    MoveType type;

    public Move(Cell from, Cell to) {
        this.from = from;
        this.to = to;
        this.fromPiece = from.getPiece();
        this.toPiece = to.getPiece();
        this.type = MoveType.NORMAL;
    }

    public Cell getFromCell() {
        return from;
    }

    public Cell getToCell() {
        return to;
    }

    public Piece getFromPiece() {
        return fromPiece;
    }

    public Piece getToPiece() {
        return toPiece;
    }

    public MoveType getType() {
        return type;
    }
}