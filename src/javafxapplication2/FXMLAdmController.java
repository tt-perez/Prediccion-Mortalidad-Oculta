/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author racli
 */
public class FXMLAdmController implements Initializable {
    @FXML
private ImageView img;
    @FXML
    private AnchorPane panelInfo;
    @FXML
    private AnchorPane PanelRegistros;
    @FXML
    private AnchorPane panelexito;
    @FXML
    private Button botExport;

    @FXML
    private Button botRegistrousuarios;

    @FXML
    private Button CambiarContra;
@FXML
    private AnchorPane panelexitoso;
    @FXML
    private Label marcador;
    @FXML
    private Label avisogeneral;
    @FXML
    private Label avisoinsorrecto;
    @FXML
    private Label avisogeneralAdm;
    @FXML
    private Label avisoincAdm;
    @FXML
    private StackPane ventanaCambioC;

    @FXML
    private Button CancelarContra;
    @FXML
    private TextField anterior;
    @FXML
    private TextField repeticion;
    @FXML
    private TextField nueva;
    @FXML
    private TextField anteriordoctor;
    @FXML
    private TextField repeticiondoctor;
    @FXML
    private TextField nuevadoctor;

    public static ConexionBD conectar = new ConexionBD();

    public FXMLDocumentController controlador = new FXMLDocumentController();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            conectar.conectarAdministrador(controlador.getContra());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAdmController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLAdmController.class.getName()).log(Level.SEVERE, null, ex);
        }
           TranslateTransition transition = new TranslateTransition(Duration.seconds(1.5), botRegistrousuarios);
        transition.setFromX(-200); // Posición inicial en X (fuera de la pantalla a la derecha)
        transition.setToX(0); // Posición final en X
        transition.play();
          TranslateTransition transition1 = new TranslateTransition(Duration.seconds(2),botExport );
        transition1.setFromX(-200); // Posición inicial en X (fuera de la pantalla a la derecha)
        transition1.setToX(0); // Posición final en X
        transition1.play();
         TranslateTransition transition2 = new TranslateTransition(Duration.seconds(3), marcador);
        transition2.setFromX(200); // Posición inicial en X (fuera de la pantalla a la derecha)
        transition2.setToX(0); // Posición final en X
        transition2.play();
                 TranslateTransition transition3 = new TranslateTransition(Duration.seconds(2), img);
        transition3.setFromX(100); // Posición inicial en X (fuera de la pantalla a la derecha)
        transition3.setToX(0); // Posición final en X
        transition3.play();
        
        botExport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser file = new FileChooser();
           
                file.setInitialFileName("datos.csv");
                Stage stage = (Stage) botExport.getScene().getWindow();
               stage.getIcons().add(new Image("design/medicine_icon-icons.com_66070.png"));
               file.setTitle("MonitorVital-Exportar");
                File selected = file.showSaveDialog(stage);
                if (selected != null) {
                    conectar.consultar("select * from crearcsv('" + selected.getPath() + "')");
                }

            }
        });
        CancelarContra.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ventanaCambioC.setVisible(false);
avisoincAdm.setVisible(false);avisogeneralAdm.setVisible(false);
            }
        });
        CambiarContra.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (anterior.getText().trim().isEmpty() || nueva.getText().trim().isEmpty() || repeticion.getText().trim().isEmpty()) {
                    avisoincAdm.setVisible(false);
                    avisogeneralAdm.setVisible(true);
                    avisogeneralAdm.setText("Campos obligatorios");
                } else {
                    avisogeneralAdm.setVisible(false);
                    if (!anterior.getText().equals(controlador.getContra())) {
                        avisoincAdm.setVisible(true);

                    } else {
                        if (!nueva.getText().equals(repeticion.getText())) {
                            avisoincAdm.setVisible(false);
                            avisogeneralAdm.setVisible(true);
                            avisogeneralAdm.setText("Contraseñas diferentes");
                        } else {
                            conectar.cambiarContrasena(nueva.getText());
                            ventanaCambioC.setVisible(false);
                            controlador.setContra(nueva.getText());
                            panelexitoso.setVisible(true);avisoincAdm.setVisible(false);avisogeneralAdm.setVisible(false);
                 PauseTransition pause = new PauseTransition(Duration.seconds(2));
                    pause.setOnFinished(actionevent -> panelexitoso.setVisible(false));
                    pause.play();               
                        }
                    }
                }
            }
        });
    }

    public void abrirpanelCambio() {
        ventanaCambioC.setVisible(true);
        nueva.clear();
        repeticion.clear();
        anterior.clear();
        avisoinsorrecto.setText("");
        avisogeneral.setText("");
    }

    public void cambiardoctor() {
        if (anteriordoctor.getText().trim().isEmpty() || nuevadoctor.getText().trim().isEmpty() || repeticiondoctor.getText().trim().isEmpty()) {
            avisoinsorrecto.setVisible(false);
            avisogeneral.setVisible(true);
            avisogeneral.setText("Campos obligatorios");
        } else {
            avisogeneral.setVisible(false);
            try {
                ConexionBD bd = new ConexionBD();
                bd.conectarDoctor(anteriordoctor.getText());
                bd.cerrar();
                 if (!nuevadoctor.getText().equals(repeticiondoctor.getText())) {
                    avisogeneral.setVisible(true);
                    avisogeneral.setText("Contraseñas diferentes");
                } else {
                    panelexito.setVisible(true);
                    conectar.cambiarContrasenaDoctor(nuevadoctor.getText());
                    anteriordoctor.clear();
                    nuevadoctor.clear();
                    repeticiondoctor.clear(); avisogeneral.setVisible(false);  avisoinsorrecto.setVisible(false);
                    PauseTransition pause = new PauseTransition(Duration.seconds(2));
                    pause.setOnFinished(event -> panelexito.setVisible(false));
                    pause.play();

                }
            } catch (Exception ex) {
                 avisoinsorrecto.setVisible(true);
            
          
               
            }
        }
    }

    public void info() {
        marcador.setText("INFORMACIÓN");
        botRegistrousuarios.getStyleClass().remove("selected");
        botExport.getStyleClass().remove("selected");
        PanelRegistros.setVisible(false);
        panelInfo.setVisible(true);
          avisoinsorrecto.setVisible(false);
            avisogeneral.setVisible(false);
    }

    public void volver() throws IOException, Exception {
        conectar.cerrar();
        Stage stage = (Stage) (botExport.getScene().getWindow());
        JavaFXApplication2 java = new JavaFXApplication2();
        java.start(new Stage());
        stage.close();

    }

    public void cambiopanel(ActionEvent event) {
        if (event.getSource() == botRegistrousuarios) {
            marcador.setText("CONTRASEÑA DEL DOCTOR");
            botRegistrousuarios.getStyleClass().add("selected");
            botExport.getStyleClass().remove("selected");
            PanelRegistros.setVisible(true);
            panelInfo.setVisible(false);
        } else {

            botExport.getStyleClass().add("selected");
            botRegistrousuarios.getStyleClass().remove("selected");

        }
    }

    public void cerrarApp() throws SQLException {
        conectar.cerrar();
        System.exit(0);
    }
}
