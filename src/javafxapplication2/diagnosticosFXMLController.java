/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;



/**
 * FXML Controller class
 *
 * @author racli
 */
public class diagnosticosFXMLController implements Initializable {
    @FXML
    private AnchorPane paneltime; 
                @FXML
    private StackPane panelnivel;
         @FXML
    private Text aviso;
    public ConexionBD bd = new ConexionBD();
    
    @FXML
    private TableColumn<Diagnostico, String> cod;
    @FXML
    private Button bot_elim;
    public FXMLDocumentController controlador = new FXMLDocumentController();
    public ObservableList<Diagnostico> data;
    public ArrayList<Diagnostico> lista = new ArrayList<>(4);
    @FXML
    private TableView<Diagnostico> tabla;
        @FXML
    private TextField codigo;
 @FXML
    private Label cartelaviso;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


         
        try {
            bd.conectarDoctor(controlador.getContra());
             ResultSet p = bd.consultar("SELECT * FROM diagnostico order by 1");
                while (p.next()) {
                   
                    Diagnostico nuevo = new Diagnostico(p.getString(1));
                    lista.add(nuevo);
                }
                data = FXCollections.observableArrayList(lista);
          
                cod.setCellValueFactory(new PropertyValueFactory<>("valor"));
       
               
                Bindings.bindContent(tabla.getItems(), data);
        } catch (SQLException e) {
            Logger.getLogger(diagnosticosFXMLController.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException eTx) {
            Logger.getLogger(diagnosticosFXMLController.class.getName()).log(Level.SEVERE, null, eTx);
        }
               
           
         

    }
     public void cerrarCambio() {
        panelnivel.setVisible(false);
    }
    public void mostrarpanel(){
            panelnivel.setVisible(true);
             cartelaviso.setVisible(false);
         
                codigo.clear();
                     
    }
   public void nuevotipo() throws SQLException{
     if(codigo.getText().trim().isEmpty()){
             cartelaviso.setText("   Campo Obligatorio");
           cartelaviso.setVisible(true);       
     } else{
        Diagnostico nuevo=new Diagnostico(codigo.getText());
         if(data.contains(nuevo)){
               cartelaviso.setText("   Enfermedad ya existente");
              cartelaviso.setVisible(true);
         }else{
                cartelaviso.setVisible(false);  
       
              ResultSet p=  bd.consultar("select insertar_diagnostico('"+codigo.getText()+"')");
//        if(p==null){
//                cartelaviso.setText(" Enfermedad ya existente");
//              cartelaviso.setVisible(true);
//        }else{
            if(p.next()){
                data.add(new Diagnostico(codigo.getText()));
            cerrarCambio();
        }//}
            
          }
         
         }
   }
    
    
public void eliminar(){
      Diagnostico nuevo=tabla.getSelectionModel().getSelectedItem();
   try {
      ResultSet p= bd.consultar("SELECT eliminar_diagnostico('" +nuevo.getValor()+"')");
 if(p!=null){
               data.remove(nuevo);
           }

    } catch (Exception e) {
        System.out.println(e);
    }
}
    public void cerrarApp() throws SQLException {
        bd.cerrar();
        System.exit(0);
    }

    public void volvermenu() throws IOException, SQLException {
        bd.cerrar();
        Parent root = FXMLLoader.load(getClass().getResource("DoctorFXML.fxml"));
        Stage stage = new Stage();
          stage.setMinWidth(1500);
        stage.setMinHeight(800);
                                stage.getIcons().add(new Image("design/medicine_icon-icons.com_66070.png"));

        stage.setTitle("MonitorVital-Doctor");
        stage.setScene(new Scene(root));
        stage.show();
        bot_elim.getScene().getWindow().hide();
    }

}
