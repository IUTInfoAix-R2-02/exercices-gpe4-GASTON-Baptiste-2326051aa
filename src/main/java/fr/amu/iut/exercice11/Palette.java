package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private IntegerProperty nbFois;
    private StringProperty message;

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;


    @Override
    public void start(Stage primaryStage) {

        message = new SimpleStringProperty();
        nbFois = new SimpleIntegerProperty(0);

        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        /* VOTRE CODE ICI */
        vert.setOnAction(event ->{nbFois.set(++nbVert);
            message.set(vert.getText()+"choisi");
            this.texteDuHaut.setText( vert.getText() + " choisi "+ nbVert +" fois ");
            this.panneau.setStyle("-fx-background-color: #0F0");});

        bleu.setOnAction(event ->{nbFois.set(++nbBleu);
            message.set(bleu.getText()+"choisi");
        this.texteDuHaut.setText( bleu.getText() + " choisi "+ nbBleu +" fois ");
        this.panneau.setStyle("-fx-background-color: #00F");});

        rouge.setOnAction(event ->{nbFois.set(++nbRouge);
            message.set(rouge.getText()+"choisi");
        this.texteDuHaut.setText( rouge.getText() + " choisi "+ nbRouge +" fois ");
        this.panneau.setStyle("-fx-background-color: #F00");});


        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

