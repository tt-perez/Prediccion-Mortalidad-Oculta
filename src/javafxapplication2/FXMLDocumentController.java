/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author racli
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label alerta_pass;
    @FXML
    private Button bot_login;

    @FXML
    private FontAwesomeIconView idADM;

    @FXML
    private FontAwesomeIconView idDR;

    @FXML
    private Label label;

    @FXML
    private FontAwesomeIconView login_fot;

    @FXML
    private Hyperlink login_link;

    @FXML
    private Hyperlink login_ojo;

    @FXML
    private PasswordField login_pass;

    @FXML
    private TextField login_textpass;

    @FXML
    private AnchorPane login_form;

    @FXML
    private FontAwesomeIconView register_ojo;

    @FXML
    private Label textADM;

    @FXML
    private Label textDR;

    @FXML
    private Label usuario;

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        FXMLDocumentController.contra = contra;
    }

 

    @FXML
    private Hyperlink usuarioADM;
public static String contra="";
    @FXML
    private Hyperlink usuarioDR;
public static ConexionBD conectar;
        public boolean doctor=true;
        public boolean adm=false;
    public void ver(ActionEvent event){
            if(event.getSource()==login_ojo){
               if("EYE".equals(register_ojo.getGlyphName())){
                register_ojo.setGlyphName("EYE_SLASH");
                 login_textpass.setText(login_pass.getText());
          login_textpass.setVisible(!login_textpass.isVisible()); 
          login_pass.setVisible(!login_textpass.isVisible()); 
                }else{
                     register_ojo.setGlyphName("EYE");
                      login_pass.setText(login_textpass.getText());
          login_textpass.setVisible(!login_textpass.isVisible()); 
          login_pass.setVisible(!login_textpass.isVisible()); 
                }
            
            
      }}
     public void entrar() throws IOException, ClassNotFoundException{
      if("EYE".equals(register_ojo.getGlyphName())){
         contra=login_pass.getText();
          }else{
        contra=login_textpass.getText();   
        }
          
     
         
     }
     public void Login() throws IOException, ClassNotFoundException, SQLException {
       entrar();
       
        if (contra.isEmpty()) {
          alerta_pass.setVisible(true);
          alerta_pass.setText("Campo obligatorio");
        } else {
            alerta_pass.setVisible(false);
               alerta_pass.setText("");
        }
     
     
        if(doctor==true && alerta_pass.getText().equals("") ){
       try{   
           conectar.conectarDoctor(contra);   
      Parent root= FXMLLoader.load(getClass().getResource("DoctorFXML.fxml"));
           Stage stage=new Stage();
         stage.setMinWidth(1500);
        stage.setMinHeight(800);
        stage.getIcons().add(new Image("design/medicine_icon-icons.com_66070.png"));
        stage.setTitle("MonitorVital-Doctor");
        stage.setScene(new Scene(root));
        stage.show(); 
        bot_login.getScene().getWindow().hide();   conectar.cerrar();
       }catch(Exception e){
         alerta_pass.setVisible(true);

            alerta_pass.setText("Contraseña incorrecta");  }
      
     
        } else{   
            if(adm==true && alerta_pass.getText().equals("") ){
          try{    
              conectar.conectarAdministrador(contra); 
            
                   Parent root= FXMLLoader.load(getClass().getResource("FXMLAdm.fxml"));
        Stage stage=new Stage();
       stage.setMinWidth(836);
   stage.setMinHeight(526);
           stage.getIcons().add(new Image("design/medicine_icon-icons.com_66070.png"));

    stage.setTitle("MonitorVital-Administrador");
     stage.setScene(new Scene(root));
     stage.show(); 
      bot_login.getScene().getWindow().hide();    
          conectar.cerrar();
       }catch(Exception e){
         alerta_pass.setVisible(true);
              System.out.println(e);
            alerta_pass.setText("Contraseña incorrecta");  } 
            }
           }     
       
  
    }
    public void visitar(){
          try{      
          
              Parent root= FXMLLoader.load(getClass().getResource("FXMLVisitante.fxml"));
        Stage stage=new Stage();
       stage.setMinWidth(1500);
   stage.setMinHeight(800);
              stage.getIcons().add(new Image("design/medicine_icon-icons.com_66070.png"));

    stage.setTitle("MonitorVital-Visitante");
     stage.setScene(new Scene(root));
     stage.show(); 
     login_link.getScene().getWindow().hide(); 
       }catch(Exception e){
             System.out.println(e);
            } 
    }
           
 public void seleccionarUsuario(ActionEvent event) {
        DropShadow ds=new DropShadow();

    login_pass.clear();
    login_textpass.clear();
        ds.setRadius(5);
        ds.setOffsetX(5);
        
        if (event.getSource() == usuarioADM) {
            usuario.setText("Administrador");
            login_fot.setGlyphName("USER");
            login_fot.setFill(javafx.scene.paint.Color.RED);
           bot_login.setStyle("-fx-background-color:linear-gradient(to bottom right,#b11d1d,#ff0000);-fx-background-radius:5px;");
  
       
            ds.setColor(Color.RED);    idADM.setEffect(ds);
            idDR.setEffect(null);
           doctor=false;
 adm=true;
           
        } else {

            if (event.getSource() == usuarioDR) {
                usuario.setText("Doctor");
                login_fot.setGlyphName("USER_MD");
                login_fot.setFill(javafx.scene.paint.Color.BLUE);
                           bot_login.setStyle("-fx-background-color:linear-gradient(to bottom right,#306090,#1a00ff);-fx-background-radius:5px;");

               ds.setColor(Color.BLUE);
                idDR.setEffect(ds);
                idADM.setEffect(null);
 doctor=true;
 adm=false;
 
            }
        }
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     DropShadow ds=new DropShadow();
        ds.setColor(Color.BLUE);
        ds.setRadius(5);
        ds.setOffsetX(5);
        idDR.setEffect(ds);
              TranslateTransition transition = new TranslateTransition(Duration.seconds(1.5), usuarioADM);
        transition.setFromX(-200); // Posición inicial en X (fuera de la pantalla a la derecha)
        transition.setToX(0); // Posición final en X
        transition.play();
          TranslateTransition transition1 = new TranslateTransition(Duration.seconds(1.5),usuarioDR );
        transition1.setFromX(200); // Posición inicial en X (fuera de la pantalla a la derecha)
        transition1.setToX(0); // Posición final en X
        transition1.play();
         TranslateTransition transition2 = new TranslateTransition(Duration.seconds(1.5), login_fot);
        transition2.setFromY(-200); // Posición inicial en X (fuera de la pantalla a la derecha)
        transition2.setToY(0); // Posición final en X
        transition2.play();
                 TranslateTransition transition3 = new TranslateTransition(Duration.seconds(1.5), usuario);
        transition3.setFromY(-200); // Posición inicial en X (fuera de la pantalla a la derecha)
        transition3.setToY(0); // Posición final en X
        transition3.play();
     conectar=new ConexionBD();
   
      login_pass.focusedProperty().addListener(new ChangeListener<Boolean>()
{
    @Override
    public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
    {
        if (newPropertyValue)
        {
label.setVisible(true);
        }
        else
        {
if(login_textpass.getText().isEmpty() && login_pass.getText().isEmpty()){
    label.setVisible(false);

}   
    }
    }

     });
  login_textpass.focusedProperty().addListener(new ChangeListener<Boolean>()
{
    @Override
    public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
    {
        if (newPropertyValue)
        {
label.setVisible(true);
        }
        else
        {
if(login_textpass.getText().isEmpty() && login_pass.getText().isEmpty()){
    label.setVisible(false);

}   
    }
    }

     });
  login_textpass.setOnAction(e -> {
    try {
        Login();
    } catch (IOException ex) {
        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
    }    catch (SQLException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
});         
login_pass.setOnAction(e -> {
    try {
        Login();
   }    catch (SQLException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
});         
    }

}
