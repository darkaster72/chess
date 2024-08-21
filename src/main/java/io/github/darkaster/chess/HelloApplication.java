package io.github.darkaster.chess;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

import static io.github.darkaster.chess.Piece.*;

enum Piece {
    WHITE_PAWN("wP"),
    BLACK_PAWN("bP"),
    WHITE_ROOK("wR"),
    BLACK_ROOK("bR"),
    WHITE_KNIGHT("wN"),
    BLACK_KNIGHT("bN"),
    WHITE_BISHOP("wB"),
    BLACK_BISHOP("bB"),
    WHITE_QUEEN("wQ"),
    BLACK_QUEEN("bQ"),
    WHITE_KING("wK"),
    BLACK_KING("bK");

    private final String imageName;

    Piece(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }
}

public class HelloApplication extends Application {

    private static final int TILE_SIZE = 80;
    private static final int PIECE_SIZE = (int) (TILE_SIZE * .8);
    private static final int BOARD_SIZE = 8;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        GridPane gridPane = new GridPane();
        setupBoard(gridPane);
        setupPieces(gridPane);

        Scene scene = new Scene(gridPane, TILE_SIZE * BOARD_SIZE, TILE_SIZE * BOARD_SIZE);
        primaryStage.setTitle("Chess UI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setupBoard(GridPane gridPane) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Rectangle tile = new Rectangle(TILE_SIZE, TILE_SIZE);
                if ((row + col) % 2 == 0) {
                    tile.setFill(Color.valueOf("#D2B48C"));
                } else {
                    tile.setFill(Color.valueOf("#8B4513"));
                }
                gridPane.add(tile, col, row);
            }
        }
    }


    private void setupPieces(GridPane gridPane) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            // Add pawns
            gridPane.add(createPiece(WHITE_PAWN), i, 6);
            gridPane.add(createPiece(BLACK_PAWN), i, 1);
        }

        // Add other pieces
        gridPane.add(createPiece(WHITE_ROOK), 0, 7);
        gridPane.add(createPiece(WHITE_ROOK), 7, 7);
        gridPane.add(createPiece(BLACK_ROOK), 0, 0);
        gridPane.add(createPiece(BLACK_ROOK), 7, 0);

        gridPane.add(createPiece(WHITE_KNIGHT), 1, 7);
        gridPane.add(createPiece(WHITE_KNIGHT), 6, 7);
        gridPane.add(createPiece(BLACK_KNIGHT), 1, 0);
        gridPane.add(createPiece(BLACK_KNIGHT), 6, 0);

        gridPane.add(createPiece(WHITE_BISHOP), 2, 7);
        gridPane.add(createPiece(WHITE_BISHOP), 5, 7);
        gridPane.add(createPiece(BLACK_BISHOP), 2, 0);
        gridPane.add(createPiece(BLACK_BISHOP), 5, 0);

        gridPane.add(createPiece(WHITE_QUEEN), 3, 7);
        gridPane.add(createPiece(BLACK_QUEEN), 3, 0);

        gridPane.add(createPiece(WHITE_KING), 4, 7);
        gridPane.add(createPiece(BLACK_KING), 4, 0);
    }

    private Node createPiece(Piece piece) {
        Image pieceImage = new Image(getClass().getResourceAsStream("icpieces/%s.png".formatted(piece.getImageName())));
        ImageView pieceView = new ImageView(pieceImage);
        pieceView.setFitHeight(PIECE_SIZE); // Example size, adjust to your images
        pieceView.setFitWidth(PIECE_SIZE);
        StackPane stackPane = new StackPane(pieceView);
        stackPane.setAlignment(Pos.CENTER);
        stackPane.setPadding(new Insets(8));
        stackPane.setOnMouseClicked(event -> System.out.println("Clicked " + piece));
        return stackPane;
    }
}