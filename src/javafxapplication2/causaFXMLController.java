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
import javafx.scene.control.ComboBox;
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
public class causaFXMLController implements Initializable {
    @FXML
    private AnchorPane paneltime; 
                @FXML
    private StackPane panelnivel;
         @FXML
    private Text aviso;
    public ConexionBD bd = new ConexionBD();
     
    @FXML
    private TableColumn<Causa, String> cod;
    @FXML
    private TableColumn<Causa, String> clasif;
    @FXML
    private Button bot_elim;
    public FXMLDocumentController controlador = new FXMLDocumentController();
    public ObservableList<Causa> data;
    public ArrayList<Causa> lista = new ArrayList<>(4);
    @FXML
    private TableView<Causa> tabla;
        @FXML
    private TextField codigo;
         @FXML
    private ComboBox clasificacion;
 @FXML
    private Label cartelaviso;
     ObservableList<String> items;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 items = FXCollections.observableArrayList(
                "respiratorias",
                "no respiratorias"
        );
        clasificacion.setItems(items);

         
        try {
            bd.conectarDoctor(controlador.getContra());
             ResultSet p = bd.consultar("SELECT * FROM causa order by 1");
                while (p.next()) {
                   
                    Causa nuevo = new Causa(p.getString(1),p.getString(2));
                    lista.add(nuevo);
                }
                data = FXCollections.observableArrayList(lista);
          
                cod.setCellValueFactory(new PropertyValueFactory<>("causa"));
       clasif.setCellValueFactory(new PropertyValueFactory<>("clasific"));
               
                Bindings.bindContent(tabla.getItems(), data);
        } catch (SQLException e) {
            Logger.getLogger(causaFXMLController.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException eTx) {
            Logger.getLogger(causaFXMLController.class.getName()).log(Level.SEVERE, null, eTx);
        }
               
           
         

    }
     public void cerrarCambio() {
        panelnivel.setVisible(false);
    }
    public void mostrarpanel(){
            panelnivel.setVisible(true);
             cartelaviso.setVisible(false);
         clasificacion.setValue(null);
                codigo.clear();
                     
    }
   public void nuevotipo() throws SQLException{
     if(codigo.getText().trim().isEmpty() || clasificacion.getValue()==null){
             cartelaviso.setText("   Campos Obligatorios");
           cartelaviso.setVisible(true);       
     } else{
       
              Causa nuevo=new Causa(codigo.getText(),clasificacion.getValue().toString());
         if(data.contains(nuevo)){
               cartelaviso.setText("   Causa ya existente");
              cartelaviso.setVisible(true);
         }else{
                cartelaviso.setVisible(false);  
       
              ResultSet p=  bd.consultar("select insertar_causa('"+codigo.getText()+"','"+clasificacion.getValue().toString()+"')");
       if(p==null){
                cartelaviso.setText("Clasificación no válida");
              cartelaviso.setVisible(true);
       }else{
            if(p.next()){
                data.add(new Causa(codigo.getText(),clasificacion.getValue().toString()));
            cerrarCambio();
        }}
            
          }}
         
         
   }
    
    
public void eliminar(){
      Causa nuevo=tabla.getSelectionModel().getSelectedItem();
   try {
      ResultSet p= bd.consultar("SELECT eliminar_causa('" +nuevo.getCausa()+"')");
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
