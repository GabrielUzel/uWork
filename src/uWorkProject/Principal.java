/* ***************************************************************
* Autor............: Weslei Ferreira Santos
* Matricula........: 202011393
* Inicio...........: 14/05/2022
* Ultima alteracao.: 22/05/2022
* Nome.............: Simulador de transito
* Funcao...........: É um programa feito para Simular um transito automatico
*************************************************************** */



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Principal extends Application {
    public static void main(String[] args) throws Exception {
        //instancia a controller da tela, que por sua vez chama a thread pai e a thread pai chama todas as outras 
        launch(args);
       
    }
    /* ***************************************************************
    * Metodo: start
    * Funcao: mostra a primeira tela do programa
    * Parametros: recebe os parametros atgs da função main
    * Retorno: nao retorna valores, mas mostra a tela de simulaçãodo programa
    *************************************************************** */

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));//carrega o arquivo .fxml
        Scene scene = new Scene(root); // instancia uma nova sena
        stage.setTitle("uWork");// cria o titulo 
        stage.setScene(scene);// seta a nova sena
        stage.show();// mostra a sena na tela do PC
        stage.resizableProperty().setValue(false);//não permite a maximizacao da tela
        
    }// fim do metodo start
}