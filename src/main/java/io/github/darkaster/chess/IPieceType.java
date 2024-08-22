package io.github.darkaster.chess;

public interface IPieceType {
    String getFullNotation(ColorType color);

    String getNotation();
}
