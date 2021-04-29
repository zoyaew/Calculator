import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Calculator extends Application{
    private TexttPane text = new TexttPane();
    private int x;
    private int y;
    private char operator;
    @Override
    public void start(Stage stage){
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setVgap(2);
        pane.setHgap(2);
        pane.add(text.getText(), 0, 0, 4, 1);
        GridPane.setHalignment(text.getText(), HPos.RIGHT);

        Button[] buttonNum = new Button[10];
        for(int i=0; i<=9; i++) {
            buttonNum[i] = new Button(String.valueOf(i));
            if (i == 0) pane.add(buttonNum[i], 0, 5);
            else {
                pane.add(buttonNum[i], (i-1)%3, 4-(i-1)/3);
            }
        }
        Button[] buttonOper = new Button[10];
        buttonOper[0] = new Button(".");
        buttonOper[1] = new Button("=");
        buttonOper[2] = new Button("+");
        buttonOper[3] = new Button("-");
        buttonOper[4] = new Button("*");
        buttonOper[5] = new Button("/");
        buttonOper[6] = new Button("C");
        buttonOper[7] = new Button("%");
        buttonOper[8] = new Button(")");
        buttonOper[9] = new Button("(");
        pane.add(buttonOper[0],1,5);
        pane.add(buttonOper[1],2,5);
        pane.add(buttonOper[2],3,5);
        pane.add(buttonOper[3],3,4);
        pane.add(buttonOper[4],3,3);
        pane.add(buttonOper[5],3,2);
        pane.add(buttonOper[6],3,1);
        pane.add(buttonOper[7],2,1);
        pane.add(buttonOper[8],1,1);
        pane.add(buttonOper[9],0,1);

        Scene scene = new Scene(pane);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){ launch(args); }
    public int getX(){return x;}
    public int getY(){return y;}
    public char getOperator() {return operator;}
}

class TexttPane extends GridPane{
    private int result = 0;
    private Text text = new Text(String.valueOf(result));
    public TexttPane() {
        add(text, 0, 0, 4, 1);
        GridPane.setHalignment(text, HPos.RIGHT);
    }
    public void compute(){

    }
    public Text getText() {return text;}
}
