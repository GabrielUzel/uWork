package controller_telas;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerHome {

    @FXML
    private Button buscaVagas;

    @FXML
    private Button adicionaVagas;

    @FXML
    private Button perfil;

    @FXML
    private Button removeVagas;

    private static String id = "";

    @FXML
    void btAdicionaVagas(ActionEvent event) {
        System.out.println(id);
    }

    @FXML
    void btBuscaVagas(ActionEvent event) {

    }

    @FXML
    void btPerfil(ActionEvent event) {

    }

    @FXML
    void btRemoveVagas(ActionEvent event) {

    }

    public void chamar(String caminhoTela, String titulo, String pid) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(caminhoTela));
        Scene scene = new Scene(root);
        stage.setTitle(titulo);
        stage.setScene(scene);
        stage.show();
        stage.resizableProperty().setValue(false);
        id=pid;
    }
}