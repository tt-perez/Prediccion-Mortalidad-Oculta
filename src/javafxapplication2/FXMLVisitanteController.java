/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * FXML Controller class
 *
 * @author racli
 */
public class FXMLVisitanteController implements Initializable {

    @FXML
    private Button botfallec;
    @FXML
    private StackPane ventanaDatosUci;
    @FXML
    private StackPane VENTANAEMERG;
    @FXML
    private AnchorPane PANELpACIENTE;
    @FXML
    private AnchorPane panelEstadistica;
      @FXML
    private AnchorPane panelfallecimiento;
    @FXML
    private AnchorPane PaneliNFO;
    @FXML
    private AnchorPane mostrarbarras;
    @FXML
    private Button botEstad;
     @FXML
    private Text nonecro;
    @FXML
    private MenuItem botInfo;
    @FXML
    private TextArea area;
    @FXML
    private AnchorPane mostrarGrafica;
    @FXML
    private Button botMO;
    @FXML
    private Button botPaciente;
    @FXML
    private Button botestancia;
    @FXML
    private Label marcador;
   
    @FXML
    private LineChart<?, ?> gr11;
    @FXML
    private LineChart<?, ?> gr22;

    @FXML
    private ComboBox<String> procedimiento;
    @FXML
    private PieChart graficaResultado23;
    public ArrayList<Paciente> lista = new ArrayList<>(4);
  
    public Timeline timeLin;
    public DefaultCategoryDataset barras;
    public XYChart.Series<String, Number> series;
    public DefaultPieDataset dataset;
    public ChartPanel mostrarpastel;

    @FXML
    private TableColumn<Paciente, String> columnacodigo;

    @FXML
    private TableColumn<Paciente, String> columnaedad;
 @FXML
    private TableColumn<Diagnostico, String> columnapre;
  @FXML
    private TableColumn<Diagnostico, String> columnapost;
    @FXML
    private TableColumn<Paciente, String> columnaevolucion;
   @FXML
    private TableView<Paciente> tabla; 
   @FXML
    private TableColumn<Procedimiento, String> columnaresultado;

    @FXML
    private TableView<Procedimiento> tablaprocedimiento;
    @FXML
    private TableColumn<Procedimiento,String> columnatipo;
    @FXML
    private Hyperlink buscarporCodigo;
    @FXML
    private TableColumn<Paciente, String> columnarazza;
    public ConexionBD conectar = new ConexionBD();
    @FXML
    private TableColumn<Paciente, String> columnasexo;
 
     @FXML
    private TableView<Diagnostico> tablapre;
         @FXML
    private TextField campo;
      @FXML
    private TableView<Diagnostico> tablapost;
    public ObservableList<String> itemsp;
    public ObservableList<Paciente> data;
    public ObservableList<PieChart.Data> pieCh23;

    public void mostrarinformacion(String par1, String par2, String par3, String par4, String par5, String par6, String par7, String par8, String par9, String par10,String par11) {
        String mostrar = 
"Fecha de ingreso hospitalario: \n" + par1 + "\nFecha de ingreso a UCI: \n" + par4 + "\nApache II: \n" + par6  + "\nLimitación del Esfuerzo Terapéutico: \n" + par7+"\nHoras de VAM: \n"+par8+"\nClasificación de la Vía: \n"+par10+"\nTipo de Vía: \n"+par9+"\nFecha de egreso a UCI: \n" + par5+"\nEstadía en UCI: \n"+par11+" días"+"\nSala de egreso: \n" + par3 + "\nFecha de egreso hospitalario: \n" + par2;
        area.setText(mostrar);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            conectar.conectarVisitante();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLVisitanteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLVisitanteController.class.getName()).log(Level.SEVERE, null, ex);
        }
          TranslateTransition transition = new TranslateTransition(Duration.seconds(1.5), botPaciente);
        transition.setFromX(-200); // Posición inicial en X (fuera de la pantalla a la derecha)
        transition.setToX(0); // Posición final en X
        transition.play();
          TranslateTransition transition1 = new TranslateTransition(Duration.seconds(2),botEstad );
        transition1.setFromX(-200); // Posición inicial en X (fuera de la pantalla a la derecha)
        transition1.setToX(0); // Posición final en X
        transition1.play();
         TranslateTransition transition2 = new TranslateTransition(Duration.seconds(3), marcador);
        transition2.setFromX(200); // Posición inicial en X (fuera de la pantalla a la derecha)
        transition2.setToX(0); // Posición final en X
        transition2.play();
 columnapre.setCellValueFactory(new PropertyValueFactory<>("valor"));
  columnapost.setCellValueFactory(new PropertyValueFactory<>("valor"));
columnatipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
 columnaresultado.setCellValueFactory(new PropertyValueFactory<>("causa"));
 columnacodigo.setCellValueFactory(new PropertyValueFactory<>("paciente"));
        columnaedad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        columnaevolucion.setCellValueFactory(new PropertyValueFactory<>("evolucion"));
        columnarazza.setCellValueFactory(new PropertyValueFactory<>("raza"));
        columnasexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
       
tabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Paciente>() {
    @Override
    public void changed(ObservableValue<? extends Paciente> observable, Paciente oldValue, Paciente newValue) {
       area.setVisible(true); 
       if(newValue != null && newValue.getEvolucion().equals("vivo")) {
        botfallec.setVisible(false);
        }else{
                   botfallec.setVisible(true);
 
        }
            
        
    }
});
        ResultSet p = conectar.consultar("Select* from evolucion");

        try {
            while (p.next()) {
                Paciente nuevo = new Paciente(p.getString(1), p.getString(4), p.getString(2), p.getString(3), p.getString(5));
                lista.add(nuevo);
            }
            data = FXCollections.observableArrayList(lista);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLVisitanteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Bindings.bindContent(tabla.getItems(), data);
        tabla.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Paciente seleccionado=newSelection;
                ResultSet t = conectar.consultar("Select * from infopaciente(" + seleccionado.getPaciente() + ")");

                try {
                    while (t.next()) {
                       seleccionado.setLimitacion("Si");
                        if (t.getString(11).equals("f")) {
                        seleccionado.setLimitacion("No");
                        }
                        mostrarinformacion(t.getString(6), t.getString(7), t.getString(14), t.getString(12),t.getString(13),t.getString(10), seleccionado.getLimitacion(),t.getString(16),t.getString(17),t.getString(18),t.getString(26));
                        break;

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLVisitanteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
 procedimiento.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

if(newValue!=null){
        nonecro.setVisible(false);

    Paciente nuevo=tabla.getSelectionModel().getSelectedItem();
ObservableList<Procedimiento> listadefun = FXCollections.observableArrayList();
   if(newValue.equals("Defunsión")){
        ResultSet pt = conectar.consultar("Select *from buscar_pacdefun("+nuevo.getPaciente()+")");
             try {
                 while(pt.next()){
                     nuevo.getDefuncion().add(new Procedimiento(pt.getString(2),pt.getString(3)));
                 }            } catch (SQLException ex) {
                 Logger.getLogger(FXMLVisitanteController.class.getName()).log(Level.SEVERE, null, ex);
             }
listadefun = FXCollections.observableArrayList(nuevo.getDefuncion());

     }else{
        ResultSet pt = conectar.consultar("Select * from buscar_pacnecro("+nuevo.getPaciente()+")");
         if(pt==null){   
    nonecro.setVisible(true);
 }else{
       try {
                 while(pt.next()){
                     nuevo.getNecropsia().add(new Procedimiento(pt.getString(2),pt.getString(3)));
                 }           
             } catch (SQLException ex) {
                 Logger.getLogger(FXMLVisitanteController.class.getName()).log(Level.SEVERE, null, ex);
             }  
    listadefun = FXCollections.observableArrayList(nuevo.getNecropsia());       
         }}   
     Bindings.bindContent(tablaprocedimiento.getItems(), listadefun);  
   }           
 });
     FilteredList<Paciente> filteredData = new FilteredList<>(data, b -> true);
      buscarporCodigo.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                  
                        filteredData.setPredicate(item -> {
                            if (campo.getText().isEmpty()) {
                                return true;
                            } else {

                                return item.getEdad().equals(campo.getText())|| item.getSexo().equals(campo.getText()) || item.getRaza().equals(campo.getText())||item.getEvolucion().equals(campo.getText())|| item.getPaciente().equals(campo.getText());
                            }

                        });
                        tabla.setItems(filteredData);
                    }

                });
             campo.setOnAction(e -> {
                ActionEvent ae = new ActionEvent();
                buscarporCodigo.getOnAction().handle(ae);
}); 
                campo.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (newValue.isEmpty()) {
                            filteredData.setPredicate(item -> {
                                return true;
                            });
                        }
                    }
                });
    }

    public void volver() throws IOException, Exception {
      conectar.cerrar();
      Stage stage = (Stage) (botPaciente.getScene().getWindow());
        JavaFXApplication2 java = new JavaFXApplication2();
        java.start(new Stage());
        stage.close();
    }

    public void info() {
        marcador.setText("INFORMACIÓN");
        botPaciente.getStyleClass().remove("selected");
        botEstad.getStyleClass().remove("selected");
        PANELpACIENTE.setVisible(false);
        panelEstadistica.setVisible(false);
        PaneliNFO.setVisible(true);
    }

    public void pastel() throws SQLException {
 
     ResultSet pt = conectar.consultar("Select * from calcular_promedio_sala()");
             dataset = new DefaultPieDataset();

while(pt.next()){
   
      dataset.setValue(pt.getString(1),Double.parseDouble(pt.getString(2))*100);
//        dataset.setValue("Cardiología", Double.parseDouble(pt.getString(2))*100);
//        dataset.setValue("Cirugía", Double.parseDouble(pt.getString(3))*100);
//        dataset.setValue("Medicina", Double.parseDouble(pt.getString(4))*100);
//        dataset.setValue("Nefrología",Double.parseDouble(pt.getString(5))*100);
//        dataset.setValue("Neurocirugía", Double.parseDouble(pt.getString(6))*100);
//        dataset.setValue("Neurología", Double.parseDouble(pt.getString(7))*100);
//        dataset.setValue("Otros", Double.parseDouble(pt.getString(8))*100);
//         dataset.setValue("UCIM", Double.parseDouble(pt.getString(9))*100);
}
        JFreeChart grafica = ChartFactory.createPieChart3D(
                "Estadísticas promediadas de salas de egreso", // El nombre de la gráfica
                dataset, // El arreglo de datos
                true, // Indica si lleva leyenda
                true, // Indica si lleva tooltips
                false); // Indica si son URls

        PiePlot plot = (PiePlot) grafica.getPlot();
        plot.setBackgroundPaint(Color.WHITE);

        plot.setOutlinePaint(Color.white);
        plot.setShadowPaint(Color.black);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
                "{1} ({2})", new DecimalFormat("0.00"), new DecimalFormat("0%")
        ));
        
// Crear un Timer.
Timer timer = new Timer(2, null);

// Configurar el Timer para rotar el gráfico.
timer.addActionListener(new ActionListener() {
    private int angle = 0;

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
   plot.setStartAngle(angle);
        angle++;
        if (angle > 360) {
            angle = 0;
            timer.stop();
        }    }
});

// Iniciar el Timer.
timer.start();
        mostrarpastel = new ChartPanel(grafica);
               SwingNode nodo = new SwingNode();

        SwingUtilities.invokeLater(() -> nodo.setContent(mostrarpastel));
        
 
        
        mostrarGrafica.getChildren().add(nodo);
        mostrarGrafica.setTopAnchor(nodo, 0.0);
        mostrarGrafica.setBottomAnchor(nodo, 0.0);
        mostrarGrafica.setLeftAnchor(nodo, 0.0);
        mostrarGrafica.setRightAnchor(nodo, 0.0);


   mostrarbarras.getChildren().clear();
   
        CategoryAxis xAxis = new CategoryAxis();

      NumberAxis yAxis = new NumberAxis();
yAxis.setAutoRanging(false); // Desactiva el autoajuste
yAxis.setLowerBound(0); // El límite inferior del eje y
yAxis.setUpperBound(100); // El límite superior del eje y
yAxis.setTickUnit(20); // La distancia entre las marcas de graduación

     series = new XYChart.Series<>();
        BarChart<String, Number> graficabarras = new BarChart<>(xAxis, yAxis);
   ResultSet p = conectar.consultar("Select * from calcular_promedio_raza()");
while(p.next()){

        series.getData().add(new XYChart.Data<>("blanca-"+Double.parseDouble(p.getString(1))*100+"%", Double.parseDouble(p.getString(1))*100));
        series.getData().add(new XYChart.Data<>("negra-"+Double.parseDouble(p.getString(2))*100+"%", Double.parseDouble(p.getString(2))*100));
        series.getData().add(new XYChart.Data<>("mestiza-"+Double.parseDouble(p.getString(3))*100+"%", Double.parseDouble(p.getString(3))*100));
}     
graficabarras.lookup(".chart-plot-background").setStyle("-fx-background-color:transparent;");
     graficabarras.getData().add(series);
        graficabarras.lookupAll(".chart-bar").forEach(n -> n.setStyle("-fx-bar-fill: blue;"));
        graficabarras.setTitle("Promedio de fallecidos por raza");
        graficabarras.setLegendVisible(false);
graficabarras.setStyle("-fx-font-weight: bold;");
        mostrarbarras.getChildren().add(graficabarras);

    }

    public void mostrarestancia() {
        VENTANAEMERG.setVisible(true);
    }

    public void cerrarventana() {
        VENTANAEMERG.setVisible(false);
    }

    public void cambiarpaneles(ActionEvent event) throws SQLException {
        if (event.getSource() == botInfo) {
            marcador.setText("INFORMACIÓN");
            botPaciente.getStyleClass().remove("selected");
            botestancia.getStyleClass().remove("selected");
            PANELpACIENTE.setVisible(false);
            panelEstadistica.setVisible(false);

            PaneliNFO.setVisible(true);
        } else {
            if (event.getSource() == botPaciente) {
                marcador.setText("REGISTRO DE PACIENTES");
                botPaciente.getStyleClass().add("selected");
                botestancia.getStyleClass().remove("selected");
                PANELpACIENTE.setVisible(true);
                panelEstadistica.setVisible(false);

                PaneliNFO.setVisible(false);
            } else {
                marcador.setText("ESTADÍSTICAS");

                botPaciente.getStyleClass().remove("selected");
                botestancia.getStyleClass().add("selected");
                PANELpACIENTE.setVisible(false);
                panelEstadistica.setVisible(true);

                PaneliNFO.setVisible(false);
                              
                pastel();
ResultSet p=null;
p=conectar.consultar("select * from calcular_promedio_apache()");
                   XYChart.Series series1 = new XYChart.Series();
       
while(p.next()){
    XYChart.Data data1 = new XYChart.Data("2014", Double.parseDouble(p.getString(1)));
    series1.getData().add(data1);
    data1.setNode(new HoveredThresholdNode((double) data1.getYValue()));

    XYChart.Data data2 = new XYChart.Data("2015", Double.parseDouble(p.getString(2)));
    series1.getData().add(data2);
    data2.setNode(new HoveredThresholdNode((double) data2.getYValue()));
 XYChart.Data data3 = new XYChart.Data("2023", Double.parseDouble(p.getString(3)));
    series1.getData().add(data3);
    data3.setNode(new HoveredThresholdNode((double) data3.getYValue()));
     XYChart.Data data4 = new XYChart.Data("2024", Double.parseDouble(p.getString(4)));
    series1.getData().add(data4);
    data4.setNode(new HoveredThresholdNode((double) data4.getYValue()));
    NumberAxis yAxis = (NumberAxis) gr11.getYAxis();
yAxis.setAutoRanging(false);
yAxis.setLowerBound(0);
yAxis.setUpperBound(Math.max(Math.max(Math.max(Double.parseDouble(p.getString(1)), Double.parseDouble(p.getString(2))), Double.parseDouble(p.getString(3))), Double.parseDouble(p.getString(4)))+10);
yAxis.setTickUnit(10);
}


gr11.getData().addAll(series1);
gr11.setLegendVisible(false);
gr11.setTitle("Promedios de apache a lo largo del tiempo");
  p=conectar.consultar("select * from calcular_promedio_vam()");
            
                XYChart.Series series2 = new XYChart.Series();  
while(p.next()){
    XYChart.Data data1 = new XYChart.Data("2014", Double.parseDouble(p.getString(1)));
    series2.getData().add(data1);
    data1.setNode(new HoveredThresholdNode((double) data1.getYValue()));

    XYChart.Data data2 = new XYChart.Data("2015", Double.parseDouble(p.getString(2)));
    series2.getData().add(data2);
    data2.setNode(new HoveredThresholdNode((double) data2.getYValue()));
 XYChart.Data data3 = new XYChart.Data("2023", Double.parseDouble(p.getString(3)));
    series2.getData().add(data3);
    data3.setNode(new HoveredThresholdNode((double) data3.getYValue()));
     XYChart.Data data4 = new XYChart.Data("2024", Double.parseDouble(p.getString(4)));
    series2.getData().add(data4);
    data4.setNode(new HoveredThresholdNode((double) data4.getYValue()));
    NumberAxis yAxis = (NumberAxis) gr22.getYAxis();
yAxis.setAutoRanging(false);
yAxis.setLowerBound(0);
yAxis.setUpperBound(Math.max(Math.max(Math.max(Double.parseDouble(p.getString(1)), Double.parseDouble(p.getString(2))), Double.parseDouble(p.getString(3))), Double.parseDouble(p.getString(4)))+10);
yAxis.setTickUnit(10);
}     
    gr22.getData().addAll(series2);
gr22.setLegendVisible(false);
gr22.setTitle("Promedios de tiempo de VAM a lo largo del tiempo");

     }
    

        }
    }

    public void cerrarApp() throws SQLException {
            conectar.cerrar();
  System.exit(0);
    }
class HoveredThresholdNode extends StackPane {
    HoveredThresholdNode(double value) {
        setPrefSize(15, 15);
        final Label label = createDataThresholdLabel(value);
        setOnMouseEntered(mouseEvent -> {
            getChildren().setAll(label);
            setCursor(Cursor.NONE);
            toFront();
        });
        setOnMouseExited(mouseEvent -> {
            getChildren().clear();
            setCursor(Cursor.CROSSHAIR);
        });
    }

    private Label createDataThresholdLabel(double value) {
        final Label label = new Label(value + "");
        label.getStyleClass().addAll("default-color0", "chart-line-symbol", "chart-series-line");
        label.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");
        label.setMinSize(Label.USE_PREF_SIZE, Label.USE_PREF_SIZE);
        return label;
    }
}
    public void mostrarEmergente(ActionEvent evento) throws SQLException {
        ventanaDatosUci.setVisible(true); 
        Paciente nuevo=tabla.getSelectionModel().getSelectedItem();
        if (evento.getSource() == botestancia) {
         panelfallecimiento.setVisible(false);      
         tablapre.setVisible(true);
               tablapost.setVisible(true);

ObservableList<Diagnostico> listadiagnosticopre = FXCollections.observableArrayList();
ObservableList<Diagnostico> listadiagnosticopost = FXCollections.observableArrayList();

      
        ResultSet p = conectar.consultar("Select DISTINCT enfermedadpre from vistatodoslospacientes where idpaciente="+nuevo.getPaciente());
       while(p.next()){
    nuevo.getDiagIngreso().add(new Diagnostico(p.getString(1)));
}
listadiagnosticopre = FXCollections.observableArrayList(nuevo.getDiagIngreso());

   Bindings.bindContent(tablapre.getItems(), listadiagnosticopre);
    p = conectar.consultar("Select DISTINCT enfermedadpost from vistatodoslospacientes where idpaciente="+nuevo.getPaciente());
       while(p.next()){
        nuevo.getDiagEgreso().add(new Diagnostico(p.getString(1)));
          }          
         listadiagnosticopost = FXCollections.observableArrayList(nuevo.getDiagEgreso());
        Bindings.bindContent(tablapost.getItems(), listadiagnosticopost);
     
     

            graficaResultado23.setVisible(false);
        } else {
panelfallecimiento.setVisible(false);

            if (evento.getSource() == botMO) {
                
nuevo.setMortalidad(0);
ResultSet p = conectar.consultar("Select Distinct mortalidad from vistatodoslospacientes where idpaciente="+nuevo.getPaciente());
       while(p.next()){
    nuevo.setMortalidad(Double.parseDouble(p.getString(1)));
}
       graficaResultado23.getData().clear();
                pieCh23 = FXCollections.observableArrayList(
                new PieChart.Data("Mortalidad Oculta ", nuevo.getMortalidad()), new PieChart.Data("Sobrevivencia ", Double.parseDouble(String.format("%.2f",100-nuevo.getMortalidad())))
        );
        pieCh23.forEach(data
                -> data.nameProperty().bind(Bindings.concat(data.getName(),": ",data.pieValueProperty(),"%"))
        );
        graficaResultado23.getData().addAll(pieCh23);
        tablapre.setVisible(false);
                     tablapost.setVisible(false);

                graficaResultado23.setVisible(true);

            }else{
                   procedimiento.getItems().clear();
     itemsp = FXCollections.observableArrayList("Defunsión", "Necropsia");
                   procedimiento.setItems(itemsp);
                   tablaprocedimiento.getItems().clear();
                  nonecro.setVisible(false);
panelfallecimiento.setVisible(true);
                tablapre.setVisible(false);
                tablapost.setVisible(false);
        
                graficaResultado23.setVisible(false);
            }
        }
    }

    public void cerrarVent() {
        ventanaDatosUci.setVisible(false);
    }
}
