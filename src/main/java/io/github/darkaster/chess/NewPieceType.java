package io.github.darkaster.chess;

public enum NewPieceType implements IPieceType {
    PAWN("P"),
    ROOK("R"),
    KNIGHT("N"),
    BISHOP("B"),
    QUEEN("Q"),
    KING("K");

    private final String notation;

    NewPieceType(String notation) {
        this.notation = notation;
    }

    @Override
    public String getNotation() {
        return notation;
    }

    public String getFullNotation(ColorType color) {
        return switch (color) {
            case WHITE -> "w" + notation;
            case BLACK -> "b" + notation;
        };
    }

}

