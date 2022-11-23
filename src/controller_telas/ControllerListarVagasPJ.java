package controller_telas;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import DAO.VagaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CacheUsuario;
import model.Vaga;

public class ControllerListarVagasPJ implements Initializable {
    CacheUsuario cacheUsuario = new CacheUsuario();

    @FXML
    private Button btn_voltar;

    @FXML
    private TableView<Vaga> Vagas;

    @FXML
    private TableColumn<Vaga, Integer> cId;

    @FXML
    private TableColumn<Vaga, String> cVaga;

    @FXML
    private TableColumn<Vaga, String> cArea;

    @FXML
    private TableColumn<Vaga, String> cRegime;

    @FXML
    void btn_voltarFUN(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cId.setCellValueFactory(new PropertyValueFactory<Vaga, Integer>("idVaga"));
        cVaga.setCellValueFactory(new PropertyValueFactory<Vaga, String>("nomeVaga"));
        cArea.setCellValueFactory(new PropertyValueFactory<Vaga, String>("area"));
        cRegime.setCellValueFactory(new PropertyValueFactory<Vaga, String>("regime"));

        VagaDAO vd = new VagaDAO();
        ObservableList<Vaga> list = null;
        try {
            List l = vd.listarTodasVagasUsuario(cacheUsuario.getUsuario());
            list = criarLista(l);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }       
        Vagas.setItems(list);
    }

    private ObservableList<Vaga> criarLista(List l) {
        ObservableList<Vaga> lt = FXCollections.observableArrayList();
        for(int i=0;i<l.size();i++){
            lt.add((Vaga) l.get(i));
        }
        
        return lt;
    }
}
