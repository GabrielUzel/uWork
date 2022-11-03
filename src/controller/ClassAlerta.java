package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;

public class ClassAlerta {
    private Alert alerta;

    public void confirmacao(String titulo, String textoCorpo, String rodaPe) {
        alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(textoCorpo);
        alerta.setContentText(rodaPe);
        alerta.show();
    }

    public void erro(String titulo, String textoCorpo, String rodaPe) {
        alerta = new Alert(AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(textoCorpo);
        alerta.setContentText(rodaPe);
        alerta.show();
    }

    public void informacao(String titulo, String textoCorpo, String rodaPe) {
        alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(textoCorpo);
        alerta.setContentText(rodaPe);
        alerta.show();
    }
}
