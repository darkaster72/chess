package io.github.darkaster.chess;

public class Piece {
    private IPieceType type;
    private ColorType color;
    private PieceStatus status;

    Piece(IPieceType type, ColorType color) {
        this.type = type;
        this.color = color;
    }

    public String getNotation() {
        return type.getFullNotation(color);
    }
}

enum PieceStatus {
    NORMAL,
    CAPTURED
}