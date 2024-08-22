package io.github.darkaster.chess;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Stack;

public class ChessController {
    private static final int TILE_SIZE = 80;
    private static final int PIECE_SIZE = (int) (TILE_SIZE * .8);
    private static final int BOARD_SIZE = 8;

    private Board board;
    private Stack<Move> moves;

    @FXML
    private GridPane chessBoardGrid;
    private Cell selectedCell;

    private static Rectangle createTile(Cell cell) {
        Rectangle tile = new Rectangle(TILE_SIZE, TILE_SIZE);
        Color color = null;
        if ((cell.getRow() + cell.getCol()) % 2 == 0) {
            color = Color.valueOf("#D2B48C");
        } else {
            color = Color.valueOf("#8B4513");
        }
        tile.setFill(color);
        return tile;
    }

    @FXML
    public void initialize() {
        moves = new Stack<>();
        board = new Board();
        renderBoard();
    }

    private void renderBoard() {
        chessBoardGrid.getChildren().clear();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Cell cell = board.getCell(i, j);
                chessBoardGrid.add(createCell(cell), j, i);
            }
        }
    }

    private Node createCell(Cell cell) {
        StackPane stackPane = new StackPane();
        Rectangle tile = createTile(cell);
        stackPane.getChildren().add(tile);
        ImageView pieceView = new ImageView();
        stackPane.getChildren().add(pieceView);
        pieceView.setFitHeight(PIECE_SIZE); // Example size, adjust to your images
        pieceView.setFitWidth(PIECE_SIZE);
        stackPane.setAlignment(Pos.CENTER);
        tile.setStroke(tile.getFill());
        tile.setStrokeWidth(2);

        if (cell.getState() == CellState.OCCUPIED) {
            String notation = cell.getPiece().getNotation();
            Image pieceImage = getImage(notation);
            pieceView.setImage(pieceImage);
        }

        if (cell.isSelected()) {
            tile.setStroke(Color.DARKSLATEGRAY);
        }

        stackPane.setOnMouseClicked(event -> clickCell(cell));
        return stackPane;
    }

    private Image getImage(String notation) {
        return new Image(getClass().getResourceAsStream("icpieces/%s.png".formatted(notation)));
    }

    private void clickCell(Cell cell) {
        if (selectedCell == null || selectedCell == cell) {
            if (cell.isSelected()) {
                cell.setIsSelected(false);
            } else {
                selectedCell = cell;
                cell.setIsSelected(true);
            }
        } else {
            Piece piece = selectedCell.getPiece();
            if (piece == null) {
                selectedCell = cell;
                selectedCell.setIsSelected(true);
            } else {
                cell.setPiece(piece);
                makeMove(new Move(selectedCell, cell));
                selectedCell.setIsSelected(false);
                selectedCell = null;
            }
        }

        renderBoard();
    }

    private void makeMove(Move move) {
        board.makeMove(move);
        moves.push(move);
        renderBoard();
    }
}