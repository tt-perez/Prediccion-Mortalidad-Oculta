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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
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
public class DoctorFXMLController implements Initializable {

    @FXML
    private Tab tabfallecimiento;
    public boolean tiempo = false;
    public boolean senal = false;
    @FXML
    private AnchorPane Fallo2Apane;
    @FXML
    private TableColumn<Paciente, String> columnapre;
    @FXML
    private TableColumn<Paciente, String> columnapost;
    @FXML
    private TableColumn<Paciente, String> columnasexo;
    @FXML
    private TableColumn<Paciente, String> columnarazza;
    @FXML
    private TableColumn<Paciente, String> columnacodigo;
    @FXML
    private Text nonecro;
    @FXML
    private Text labelporciento;
    @FXML
    private TableColumn<Paciente, String> columnaedad;
    @FXML
    private AnchorPane Fallo1Apane;
    public boolean estanU = false;
    @FXML
    private TabPane tabMayor;
    @FXML
    private ScrollPane Fallo1A;
    @FXML
    private AnchorPane panelnecro;
    @FXML
    private AnchorPane paneldefun;
    @FXML
    private StackPane ventanaMortalidad;

    @FXML
    private AnchorPane mostrarGrafica;

    @FXML
    private ScrollPane Fallo2A;

    @FXML
    private ToggleGroup limitacion;
    @FXML
    private CheckBox noFallece;
    @FXML
    private ToggleGroup GrupoRaza;
    @FXML
    private Label cronometro;
    @FXML
    private Label marcador;

    @FXML
    private ListView diagnostico1;
    @FXML
    private ListView diagnostico2;
    @FXML
    private ListView diagnosticoE1;
    @FXML
    private ListView diagnosticoE2;
    @FXML
    private ToggleGroup GrupoSexo;

    @FXML
    private ProgressIndicator progreso;

    @FXML
    private Button tablaFallo;

    /**
     * Initializes the controller class.
     */
    @FXML
    private CheckBox pacfallecido;
    @FXML
    private AnchorPane PanelInformacion;
    @FXML
    private TabPane tablaprocedimiento;
    @FXML
    private AnchorPane mostrarbarras;
    @FXML
    private AnchorPane noSeleccion;
    @FXML
    private AnchorPane PanelRegistros;
    @FXML
    private AnchorPane PanelAgregar;
    @FXML
    private AnchorPane PanelEstadistica;
    @FXML
    private Button botAddPaciente;
    @FXML
    private AnchorPane DatosPersonales;
    @FXML
    private AnchorPane panelIngresoUci;
    @FXML
    private AnchorPane panelieHospit;
    @FXML
    private ProgressBar progresos;
    @FXML
    private StackPane ventanaemergente;
    @FXML
    private AnchorPane panelFallece;
    @FXML
    private AnchorPane panelVAM;
    @FXML
    private AnchorPane panelEgresoUci;
    @FXML
    private Button botEstadist;
    @FXML
    private Button Boton_Listo;
    @FXML
    private Button botRegistroDatos;
    @FXML
    private Spinner<Integer> edad;
    @FXML
    private TableColumn<Procedimiento, String> columnaresultadod;
    @FXML
    private TableColumn<Procedimiento, String> columnaresultadon;
    @FXML
    private TableColumn<Procedimiento, String> columnatipon;
    @FXML
    private TableView<Procedimiento> tabladefun;
    @FXML
    private TableView<Procedimiento> tablanecro;
    @FXML
    private TableColumn<Procedimiento, String> columnatipod;
    @FXML
    private Spinner<Integer> apache;
    @FXML
    private Spinner<Integer> timeVam;
    @FXML
    private TextField campo;
    @FXML
    public ComboBox<String> Sala;
    @FXML
    private Hyperlink buscarporCodigo;
    @FXML
    private TableView<Procedimiento> resultadoNecrop;
    @FXML
    private TableView<Procedimiento> resultadoNecrop1;
    @FXML
    private TableView<Procedimiento> resultadodefun;
    @FXML
    private TableView<Procedimiento> resultadodefun1;
    @FXML
    private TableColumn<Procedimiento, String> resultadonecro;
    @FXML
    private TableColumn<Procedimiento, String> resultDefun;
    @FXML
    private TableColumn<Procedimiento, String> resultadonecro1;
    @FXML
    private TableColumn<Procedimiento, String> resultDefun1;
    @FXML
    private TableColumn<Procedimiento, String> tiponecro1;
    @FXML
    private TableColumn<Procedimiento, String> tipodefun1;
    @FXML
    private TableColumn<Procedimiento, String> tiponecro;
    @FXML
    private TableColumn<Procedimiento, String> tipodefun;
    @FXML
    public ComboBox<String> causaMuerte;
    @FXML
    public ComboBox<String> Lugar;
    @FXML
    public ComboBox<String> Lugar1;
    @FXML
    public ComboBox<String> via;

    @FXML
    private DatePicker FechaIngresoUci;
    @FXML
    private CheckBox noNecropsia;
    @FXML
    private CheckBox noNecropsia1;
    @FXML
    private DatePicker FechaAlta;
    @FXML
    private DatePicker FechaIngreso;
    @FXML
    private DatePicker fechaEgreso;
    @FXML
    private PieChart graficaResultado;
    @FXML
    private PieChart graficaResultado2;
    @FXML
    private LineChart<?, ?> gr1;
    @FXML
    private LineChart<?, ?> gr2;
    @FXML
    private ListView necropsia;
    @FXML
    private ListView necropsia1;
    @FXML
    private ListView defunsion1;
    @FXML
    private ListView defunsion;

    @FXML
    private Label avisoNocausa;

    @FXML
    private Hyperlink cambioContr;

    @FXML
    private Hyperlink cerrar;

    @FXML
    private Button botagregar;

    @FXML
    private Button dialogo1;

    @FXML
    private AnchorPane mostrarGrafica1;
    @FXML
    private AnchorPane panelagregar;
    @FXML
    private AnchorPane mostrarGrafica11;

    @FXML
    private Button boteliminar;

    @FXML
    private StackPane ventanaCambioC;
    @FXML
    private StackPane paneldeagregar;
    @FXML
    private CategoryAxis x1;

    @FXML
    private CategoryAxis x2;

    @FXML
    private NumberAxis y1;

    @FXML
    private NumberAxis y2;
    public boolean edadB = false;
    public boolean apII = false;
    SpinnerValueFactory<Integer> apach = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 67, 0);
    SpinnerValueFactory<Integer> vam = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
    SpinnerValueFactory<Integer> sp = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
    ObservableList<String> itemsNecro;
    ObservableList<String> itemsNecro1;
    ObservableList<String> itemsDefun;
    ObservableList<String> itemsDefun1;
    ObservableList<String> itemsDiagnostico1;
    ObservableList<String> itemsDiagnosticoE;
    @FXML
    private Label fechaegreso;
    @FXML
    private Label salalabel;
    @FXML
    private MenuItem diagnosticonuevo;
    @FXML
    private MenuItem causavamnueva;
    @FXML
    private MenuItem salanueva;
    @FXML
    private MenuItem procedimientonuevo;
    @FXML
    private Label fechaegresouci;
    @FXML
    private TableView<Causa> tablavam;
    @FXML
    private TableView<Diagnostico> tablapost;
    @FXML
    private TableView<Diagnostico> tablapre;
    @FXML
    private Label fechaingreso;

    @FXML
    private Label limitlabel;
    @FXML
    private Label tiempolabel;
    @FXML
    private Label salaegresolabel;
    @FXML
    private Label vialabel;
    @FXML
    private Label dialabel;
    @FXML
    private Label clasiflabel;
    @FXML
    private Label apachelabel;
    @FXML
    private TableColumn<Causa, String> columnacausa;
    @FXML
    private DatePicker textField;

    @FXML
    private TableColumn<Causa, String> columnaclasif;
    @FXML
    private Label fechaingresouci;
    public boolean breke = false;
    public Timeline timeLin;
    public DefaultCategoryDataset barras;
    public XYChart.Series<String, Number> series;
    public DefaultPieDataset dataset;
    public ChartPanel mostrarpastel;
    public ArrayList<Paciente> lista = new ArrayList<>(4);
    public ObservableList<Paciente> data;
    public static ConexionBD conectar = new ConexionBD();
    @FXML
    private TableView<Paciente> tabla;

    private void applyTransition(AnchorPane pane, double delay, double xy) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(delay), pane);
        transition.setFromY(xy); // Posición inicial en X (fuera de la pantalla a la derecha)
        transition.setToY(0); // Posición final en X
        transition.play();
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
    public FXMLDocumentController controlador = new FXMLDocumentController();

    public void asignacion() throws SQLException {
        ArrayList<String> lista = new ArrayList<>(1);
        ResultSet p = conectar.consultar("SELECT distinct causaproc FROM public.procedimiento ORDER BY causaproc ASC");
        while (p.next()) {
            lista.add(p.getString(1));
        }

        itemsNecro = FXCollections.observableArrayList(lista);
        itemsNecro1 = FXCollections.observableArrayList(lista);
        itemsDefun1 = FXCollections.observableArrayList(lista);
        itemsDefun = FXCollections.observableArrayList(lista);
        lista.clear();
        p = conectar.consultar("SELECT * from diagnostico ORDER BY enfermedad ASC");
        while (p.next()) {
            lista.add(p.getString(1));
        }
        itemsDiagnostico1 = FXCollections.observableArrayList(lista);

        itemsDiagnosticoE = FXCollections.observableArrayList(lista);
    }
    public String ident = "";

    public void cerrarApp() throws SQLException {
        conectar.cerrar();
        System.exit(0);
    }

    public void abrirpanelCambio() {
        ventanaCambioC.setVisible(true);
    }

    public void cerrarCambio(ActionEvent e) throws SQLException {

        if (e.getSource() == boteliminar) {
            paneldeagregar.setVisible(false);
            vaciar(panelagregar);
        } else {
            ventanaCambioC.setVisible(false);
        }
    }

    public void CambioPanel(ActionEvent event) throws SQLException {
        if (event.getSource() == botRegistroDatos) {
            marcador.setText("REGISTRO DE DATOS");
            botRegistroDatos.getStyleClass().add("selected");
            botAddPaciente.getStyleClass().remove("selected");
            botEstadist.getStyleClass().remove("selected");
            PanelAgregar.setVisible(false);
            PanelEstadistica.setVisible(false);
            PanelInformacion.setVisible(false);

            PanelRegistros.setVisible(true);
            tabla.refresh();
        } else {
            if (event.getSource() == botEstadist) {
                marcador.setText("ESTADÍSTICAS");
                PanelInformacion.setVisible(false);

                botEstadist.getStyleClass().add("selected");
                botRegistroDatos.getStyleClass().remove("selected");
                botAddPaciente.getStyleClass().remove("selected");
                PanelEstadistica.setVisible(true);
                PanelRegistros.setVisible(false);
                PanelAgregar.setVisible(false);
                pastel();
                ResultSet p = null;
                p = conectar.consultar("select * from calcular_promedio_apache()");
                XYChart.Series series1 = new XYChart.Series();

                while (p.next()) {
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
                    NumberAxis yAxis = (NumberAxis) gr1.getYAxis();
                    yAxis.setAutoRanging(false);
                    yAxis.setLowerBound(0);
                    yAxis.setUpperBound(Math.max(Math.max(Math.max(Double.parseDouble(p.getString(1)), Double.parseDouble(p.getString(2))), Double.parseDouble(p.getString(3))), Double.parseDouble(p.getString(4))) + 10);
                    yAxis.setTickUnit(10);
                }

                gr1.getData().addAll(series1);
                gr1.setLegendVisible(false);
                gr1.setTitle("Promedios de apache a lo largo del tiempo");
                gr1.setStyle("-fx-font-weight: bold;");
                p = conectar.consultar("select * from calcular_promedio_vam()");

                XYChart.Series series2 = new XYChart.Series();
                while (p.next()) {
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
                    NumberAxis yAxis = (NumberAxis) gr2.getYAxis();
                    yAxis.setAutoRanging(false);
                    yAxis.setLowerBound(0);
                    yAxis.setUpperBound(Math.max(Math.max(Math.max(Double.parseDouble(p.getString(1)), Double.parseDouble(p.getString(2))), Double.parseDouble(p.getString(3))), Double.parseDouble(p.getString(4))) + 10);
                    yAxis.setTickUnit(10);
                }
                gr2.getData().addAll(series2);
                gr2.setLegendVisible(false);
                gr2.setTitle("Promedios de tiempo de VAM a lo largo del tiempo");
                gr2.setStyle("-fx-font-weight: bold;");
            } else {
                marcador.setText("PLANILLA DE RECOLECCIÓN DE DATOS");

                limpiar();
                botAddPaciente.getStyleClass().add("selected");
                botRegistroDatos.getStyleClass().remove("selected");
                botEstadist.getStyleClass().remove("selected");
                PanelAgregar.setVisible(true);
                PanelRegistros.setVisible(false);
                PanelEstadistica.setVisible(false);
                PanelInformacion.setVisible(false);
            }
        }

    }

    public void volver() throws IOException, Exception {
        conectar.cerrar();
        Stage stage = (Stage) (botRegistroDatos.getScene().getWindow());
        JavaFXApplication2 java = new JavaFXApplication2();
        java.start(new Stage());

        stage.close();
    }

    public void nuevo(ActionEvent event) throws IOException, Exception {
        if (event.getSource() == diagnosticonuevo) {
            Parent root = FXMLLoader.load(getClass().getResource("diagnosticosFXML.fxml"));
            Stage stage = new Stage();
            stage.setMinWidth(343);
            stage.setMinHeight(600);
            stage.getIcons().add(new Image("design/medicine_icon-icons.com_66070.png"));

            stage.setTitle("MonitorVital-Diagnosticos");
            stage.setScene(new Scene(root));
            stage.show();
            tablaFallo.getScene().getWindow().hide();
        } else {
            if (event.getSource() == causavamnueva) {
                Parent root = FXMLLoader.load(getClass().getResource("causaFXML.fxml"));
                Stage stage = new Stage();
                stage.setMinWidth(343);
                stage.setMinHeight(600);
                stage.getIcons().add(new Image("design/medicine_icon-icons.com_66070.png"));

                stage.setTitle("MonitorVital-CausasVam");
                stage.setScene(new Scene(root));
                stage.show();
                tablaFallo.getScene().getWindow().hide();
            } else {
                if (event.getSource() == procedimientonuevo) {
                    Parent root = FXMLLoader.load(getClass().getResource("procedimientoFXML.fxml"));
                    Stage stage = new Stage();
                    stage.setMinWidth(343);
                    stage.setMinHeight(600);
                    stage.getIcons().add(new Image("design/medicine_icon-icons.com_66070.png"));

                    stage.setTitle("MonitorVital-Resultados");
                    stage.setScene(new Scene(root));
                    stage.show();
                    tablaFallo.getScene().getWindow().hide();
                } else {
                    if (event.getSource() == salanueva) {
                        Parent root = FXMLLoader.load(getClass().getResource("salasFXML.fxml"));
                        Stage stage = new Stage();
                        stage.setMinWidth(343);
                        stage.setMinHeight(600);
                        stage.getIcons().add(new Image("design/medicine_icon-icons.com_66070.png"));

                        stage.setTitle("MonitorVital-SalasHospitalarias");
                        stage.setScene(new Scene(root));
                        stage.show();
                        tablaFallo.getScene().getWindow().hide();
                    }
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    
        try {
            conectar.conectarDoctor(controlador.getContra());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAdmController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLAdmController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            asignacion();
        } catch (SQLException ex) {
            Logger.getLogger(DoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
         TranslateTransition transition = new TranslateTransition(Duration.seconds(1), DatosPersonales);
        transition.setFromY(200); // Posición inicial en X (fuera de la pantalla a la derecha)
        transition.setToY(0); // Posición final en X
        transition.play();
          TranslateTransition transition1 = new TranslateTransition(Duration.seconds(2), panelieHospit);
        transition1.setFromY(200); // Posición inicial en X (fuera de la pantalla a la derecha)
        transition1.setToY(0); // Posición final en X
        transition1.play();
         TranslateTransition transition2 = new TranslateTransition(Duration.seconds(3), panelFallece);
        transition2.setFromY(200); // Posición inicial en X (fuera de la pantalla a la derecha)
        transition2.setToY(0); // Posición final en X
        transition2.play();
                 TranslateTransition transition3 = new TranslateTransition(Duration.seconds(2), panelIngresoUci);
        transition3.setFromY(-200); // Posición inicial en X (fuera de la pantalla a la derecha)
        transition3.setToY(0); // Posición final en X
        transition3.play();

          TranslateTransition label = new TranslateTransition(Duration.seconds(3), marcador);
   
        label.setFromX(200); // Posición inicial obtenida desde Scene Builder
        label.setToX(0); // Posición final en el centro de la pantalla
        label.play();
         double initialX = -200; // Obtener la posición inicial del botón desde Scene Builder

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1.8), botRegistroDatos);
   
        translateTransition.setFromX(initialX); // Posición inicial obtenida desde Scene Builder
        translateTransition.setToX(0); // Posición final en el centro de la pantalla
        translateTransition.play();
         TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(2.4), botAddPaciente);
   
        translateTransition1.setFromX(initialX); // Posición inicial obtenida desde Scene Builder
        translateTransition1.setToX(0); // Posición final en el centro de la pantalla
        translateTransition1.play();
         TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(2.8), botEstadist);
   
        translateTransition2.setFromX(initialX); // Posición inicial obtenida desde Scene Builder
        translateTransition2.setToX(0); // Posición final en el centro de la pantalla
        translateTransition2.play();
        columnatipod.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnaresultadod.setCellValueFactory(new PropertyValueFactory<>("causa"));
        columnatipon.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnaresultadon.setCellValueFactory(new PropertyValueFactory<>("causa"));
        columnacodigo.setCellValueFactory(new PropertyValueFactory<>("paciente"));
        columnaedad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        columnarazza.setCellValueFactory(new PropertyValueFactory<>("raza"));
        columnasexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        columnapre.setCellValueFactory(new PropertyValueFactory<>("valor"));
        columnapost.setCellValueFactory(new PropertyValueFactory<>("valor"));
        columnaclasif.setCellValueFactory(new PropertyValueFactory<>("clasific"));
        columnacausa.setCellValueFactory(new PropertyValueFactory<>("causa"));
        columnaedad.setCellFactory(TextFieldTableCell.forTableColumn());
        columnaedad.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Paciente, String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Paciente, String> t) {
                Paciente nuevo = tabla.getSelectionModel().getSelectedItem();
                String nuevonombre = t.getNewValue();

                if (nuevonombre.trim().isEmpty() || !nuevonombre.matches("[0-9]+") || Integer.parseInt(nuevo.getPaciente()) <= 208) {

                    data.get(data.indexOf(nuevo)).setEdad(data.get(data.indexOf(nuevo)).getEdad());
                    tabla.refresh();
                } else {
                    int posicion = data.indexOf((new Paciente(nuevo.getPaciente(), null, null, null, null)));
                    Paciente updatedP = data.get(posicion);
                    ResultSet p = conectar.consultar("SELECT actualizar_edadpaciente(" + nuevo.getPaciente() + "," + nuevonombre + ")");
                    p = conectar.consultar("SELECT actualizar_mortalidadpaciente(" + nuevo.getPaciente() + ")");
                    double mortalidad = 0;
                    try {
                        while (p.next()) {
                            mortalidad = Double.parseDouble(p.getString(1));
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ObservableList<PieChart.Data> pieCh2 = FXCollections.observableArrayList(
                            new PieChart.Data("No Mortalidad", 65.0), new PieChart.Data("No Mortalidad", 35.0)
                    );
                    graficaResultado2.getData().clear();
                    pieCh2 = FXCollections.observableArrayList(
                            new PieChart.Data("Mortalidad Oculta ", mortalidad), new PieChart.Data("Sobrevivencia ", Double.parseDouble(String.format("%.2f", 100 - mortalidad)))
                    );
                    pieCh2.forEach(data
                            -> data.nameProperty().bind(Bindings.concat(data.getName(), ": ", data.pieValueProperty(), "%"))
                    );
                    graficaResultado2.getData().addAll(pieCh2);
                    graficaResultado2.setVisible(true);
                    updatedP.setEdad(nuevonombre);
                    data.set(posicion, updatedP);
                    tabla.refresh();

                }
            }
        });

        columnarazza.setCellFactory(TextFieldTableCell.forTableColumn());
        columnarazza.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Paciente, String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Paciente, String> t) {
                Paciente nuevo = tabla.getSelectionModel().getSelectedItem();
                String nuevonombre = t.getNewValue();

                if (nuevonombre.trim().isEmpty() || (!nuevonombre.equals("blanco") && !nuevonombre.equals("mestizo") && !nuevonombre.equals("negro")) || Integer.parseInt(nuevo.getPaciente()) <= 208) {

                    data.get(data.indexOf(nuevo)).setRaza(data.get(data.indexOf(nuevo)).getRaza());
                    tabla.refresh();
                } else {
                    int posicion = data.indexOf((new Paciente(nuevo.getPaciente(), null, null, null, null)));
                    Paciente updatedP = data.get(posicion);
                    ResultSet p = conectar.consultar("SELECT actualizar_razapaciente(" + nuevo.getPaciente() + ",'" + nuevonombre + "')");
                    p = conectar.consultar("SELECT actualizar_mortalidadpaciente(" + nuevo.getPaciente() + ")");
                    double mortalidad = 0;
                    try {
                        while (p.next()) {
                            mortalidad = Double.parseDouble(p.getString(1));
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ObservableList<PieChart.Data> pieCh2 = FXCollections.observableArrayList(
                            new PieChart.Data("No Mortalidad", 65.0), new PieChart.Data("No Mortalidad", 35.0)
                    );
                    graficaResultado2.getData().clear();
                    pieCh2 = FXCollections.observableArrayList(
                            new PieChart.Data("Mortalidad Oculta ", mortalidad), new PieChart.Data("Sobrevivencia ", Double.parseDouble(String.format("%.2f", 100 - mortalidad)))
                    );
                    pieCh2.forEach(data
                            -> data.nameProperty().bind(Bindings.concat(data.getName(), ": ", data.pieValueProperty(), "%"))
                    );
                    graficaResultado2.getData().addAll(pieCh2);
                    graficaResultado2.setVisible(true);
                    updatedP.setRaza(nuevonombre);
                    data.set(posicion, updatedP);
                    tabla.refresh();

                }
            }
        });
        columnasexo.setCellFactory(TextFieldTableCell.forTableColumn());
        columnasexo.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Paciente, String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Paciente, String> t) {
                Paciente nuevo = tabla.getSelectionModel().getSelectedItem();

                String nuevonombre = t.getNewValue();
                if (nuevonombre.trim().isEmpty() || (!nuevonombre.equals("f") && !nuevonombre.equals("m")) || Integer.parseInt(nuevo.getPaciente()) <= 208) {
                    data.get(data.indexOf(nuevo)).setSexo(data.get(data.indexOf(nuevo)).getSexo());
                    tabla.refresh();
                } else {
                    int posicion = data.indexOf((new Paciente(nuevo.getPaciente(), null, null, null, null)));
                    Paciente updatedP = data.get(posicion);
                    ResultSet p = conectar.consultar("SELECT actualizar_sexopaciente(" + nuevo.getPaciente() + ",'" + nuevonombre + "')");
                    p = conectar.consultar("SELECT actualizar_mortalidadpaciente(" + nuevo.getPaciente() + ")");
                    double mortalidad = 0;
                    try {
                        while (p.next()) {
                            mortalidad = Double.parseDouble(p.getString(1));
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ObservableList<PieChart.Data> pieCh2 = FXCollections.observableArrayList(
                            new PieChart.Data("No Mortalidad", 65.0), new PieChart.Data("No Mortalidad", 35.0)
                    );
                    graficaResultado2.getData().clear();
                    pieCh2 = FXCollections.observableArrayList(
                            new PieChart.Data("Mortalidad Oculta ", mortalidad), new PieChart.Data("Sobrevivencia ", Double.parseDouble(String.format("%.2f", 100 - mortalidad)))
                    );
                    pieCh2.forEach(data
                            -> data.nameProperty().bind(Bindings.concat(data.getName(), ": ", data.pieValueProperty(), "%"))
                    );
                    graficaResultado2.getData().addAll(pieCh2);
                    graficaResultado2.setVisible(true);
                    updatedP.setSexo(nuevonombre);
                    data.set(posicion, updatedP);
                    tabla.refresh();

                }

            }
        });
        ResultSet p = conectar.consultar("Select* from evolucion");
        fechaegreso.setOnMouseClicked((MouseEvent event) -> {
            if (Integer.parseInt(tabla.getSelectionModel().getSelectedItem().getPaciente()) > 208) { // Doble clic para editar
                textField.setVisible(true);
                textField.setDayCellFactory(picker -> new DateCell() {
                    @Override
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        if (date != null && fechaegresouci.getText().substring(19) != null) {
                            setDisable(date.isBefore(LocalDate.parse(fechaegresouci.getText().substring(19))));
                        }
                    }
                });
                textField.setValue(LocalDate.parse(fechaegreso.getText().substring(28)));
                textField.requestFocus();

            }
        });

        textField.setOnAction(event -> {
            fechaegreso.setText("Fecha Egreso Hospitalario : ".concat(textField.getValue().toString()));
            ResultSet tp = conectar.consultar("SELECT actualizar_fegresopaciente(" + tabla.getSelectionModel().getSelectedItem().getPaciente() + ",'" + textField.getValue() + "')");

            textField.setVisible(false);

        });
        try {
            while (p.next()) {
                Paciente nuevo = new Paciente(p.getString(1), p.getString(4), p.getString(2), p.getString(3), p.getString(5));
                lista.add(nuevo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FXMLVisitanteController.class.getName()).log(Level.SEVERE, null, ex);
        }

        data = FXCollections.observableArrayList(lista);

        Bindings.bindContent(tabla.getItems(), data);
        progresos.setStyle("-fx-accent:#5c3dd4");
        tabla.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                      pacfallecido.setVisible(false);
                ObservableList<Diagnostico> listadiagnosticopre = FXCollections.observableArrayList();
                ObservableList<Diagnostico> listadiagnosticopost = FXCollections.observableArrayList();
                ObservableList<Causa> listavamdata = FXCollections.observableArrayList();
                Paciente seleccionado = new Paciente(newSelection);
                ResultSet pt = conectar.consultar("Select DISTINCT enfermedadpre from vistatodoslospacientes where idpaciente=" + seleccionado.getPaciente());
                try {
                    while (pt.next()) {
                        seleccionado.getDiagIngreso().add(new Diagnostico(pt.getString(1)));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
                listadiagnosticopre = FXCollections.observableArrayList(seleccionado.getDiagIngreso());

                Bindings.bindContent(tablapre.getItems(), listadiagnosticopre);
                pt = conectar.consultar("Select DISTINCT enfermedadpost from vistatodoslospacientes where idpaciente=" + newSelection.getPaciente());
                try {
                    while (pt.next()) {
                        seleccionado.getDiagEgreso().add(new Diagnostico(pt.getString(1)));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
                listadiagnosticopost = FXCollections.observableArrayList(seleccionado.getDiagEgreso());
                Bindings.bindContent(tablapost.getItems(), listadiagnosticopost);
                pt = conectar.consultar("Select DISTINCT nombrecvam,motivovam from vistatodoslospacientes where idpaciente=" + newSelection.getPaciente());
                try {
                    while (pt.next()) {

                        seleccionado.getCausas().add(new Causa(pt.getString(1), pt.getString(2)));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
                listavamdata = FXCollections.observableArrayList(seleccionado.getCausas());
                Bindings.bindContent(tablavam.getItems(), listavamdata);
                ResultSet t = conectar.consultar("Select * from infopaciente(" + newSelection.getPaciente() + ")");

                try {
                    while (t.next()) {
                        seleccionado.setLimitacion("Si");
                        if (t.getString(11).equals("f")) {
                            seleccionado.setLimitacion("No");
                        }
                        if (t.getString(7) == null) {
                            fechaegreso.setText("Fecha Egreso Hospitalario : ".concat("-"));
                        } else {
                            fechaegreso.setText("Fecha Egreso Hospitalario : ".concat(t.getString(7)));
                        }
                        fechaegresouci.setText("Fecha Egreso UCI : ".concat(t.getString(13)));
                        fechaingreso.setText("Fecha Ingreso Hospitalario : ".concat(t.getString(6)));
                        fechaingresouci.setText("Fecha Ingreso UCI : ".concat(t.getString(12)));
                        salaegresolabel.setText("Sala de Egreso : ".concat(t.getString(14)));
                        apachelabel.setText("APACHE II : ".concat(t.getString(10)));
                        limitlabel.setText("Limitación de Esfuerzo Terapéutico : ".concat(seleccionado.getLimitacion()));
                        dialabel.setText("Días de Estancia : ".concat(t.getString(26)));
                        tiempolabel.setText("Horas conectado al VAM : ".concat(t.getString(16)));
                        vialabel.setText("Tipo de vía aérea : ".concat(t.getString(17)));
                        clasiflabel.setText("Clasificación de vía aérea : ".concat(t.getString(18)));
                        seleccionado.setMortalidad(Double.parseDouble(t.getString(8)));
                        ObservableList<PieChart.Data> pieCh2 = FXCollections.observableArrayList(
                                new PieChart.Data("No Mortalidad", 65.0), new PieChart.Data("No Mortalidad", 35.0)
                        );
                        graficaResultado2.getData().clear();
                        pieCh2 = FXCollections.observableArrayList(
                                new PieChart.Data("Mortalidad Oculta ", seleccionado.getMortalidad()), new PieChart.Data("Sobrevivencia ", Double.parseDouble(String.format("%.2f", 100 - seleccionado.getMortalidad())))
                        );
                        pieCh2.forEach(data
                                -> data.nameProperty().bind(Bindings.concat(data.getName(), ": ", data.pieValueProperty(), "%"))
                        );
                        graficaResultado2.getData().addAll(pieCh2);
                        graficaResultado2.setVisible(true);
                        if (t.getString(2).equals("vivo")) {
                            tabfallecimiento.setDisable(true);
                            nonecro.setDisable(true);
                            if (Integer.parseInt(seleccionado.getPaciente()) > 208) {
                                pacfallecido.setVisible(true);
                            } else {
                                pacfallecido.setVisible(false);
                            }

                        } else {
                            tabfallecimiento.setDisable(false);
                            nonecro.setDisable(false);
                            salalabel.setText("Sala de defunsión : ".concat(t.getString(9)));
                            ObservableList<Procedimiento> listadefun = FXCollections.observableArrayList();
                            ObservableList<Procedimiento> listanecr = FXCollections.observableArrayList();

                            pt = conectar.consultar("Select *from buscar_pacdefun(" + newSelection.getPaciente() + ")");
                            try {
                                while (pt.next()) {
                                    seleccionado.getDefuncion().add(new Procedimiento(pt.getString(2), pt.getString(3)));
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(FXMLVisitanteController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            listadefun = FXCollections.observableArrayList(seleccionado.getDefuncion());
                            Bindings.bindContent(tabladefun.getItems(), listadefun);
                            pt = conectar.consultar("Select * from buscar_pacnecro(" + newSelection.getPaciente() + ")");
                            if (pt == null) {
                                nonecro.setVisible(true);

                            } else {
                                nonecro.setVisible(false);

                                try {
                                    while (pt.next()) {
                                        seleccionado.getNecropsia().add(new Procedimiento(pt.getString(2), pt.getString(3)));
                                    }
                                } catch (SQLException ex) {

                                }
                                listanecr = FXCollections.observableArrayList(seleccionado.getNecropsia());
                            }
                            Bindings.bindContent(tablanecro.getItems(), listanecr);
                        }
                        break;

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
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

                        return item.getEdad().equals(campo.getText()) || item.getSexo().equals(campo.getText()) || item.getRaza().equals(campo.getText()) || item.getPaciente().equals(campo.getText());
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
        necropsia.setItems(itemsNecro);
        defunsion.setItems(itemsDefun);
        diagnostico1.setItems(itemsDiagnostico1);
        diagnosticoE1.setItems(itemsDiagnosticoE);
        tiponecro.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        resultadonecro.setCellValueFactory(new PropertyValueFactory<>("causa"));
        tiponecro.setCellFactory(TextFieldTableCell.forTableColumn());
        tipodefun.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        resultDefun.setCellValueFactory(new PropertyValueFactory<>("causa"));
        tipodefun.setCellFactory(TextFieldTableCell.forTableColumn());
        tiponecro1.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        resultadonecro1.setCellValueFactory(new PropertyValueFactory<>("causa"));
        tiponecro1.setCellFactory(TextFieldTableCell.forTableColumn());
        tipodefun1.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        resultDefun1.setCellValueFactory(new PropertyValueFactory<>("causa"));
        tipodefun1.setCellFactory(TextFieldTableCell.forTableColumn());
        edad.setValueFactory(sp);
        timeVam.setValueFactory(vam);
        apache.setValueFactory(apach);
        ArrayList<String> lista = new ArrayList<>(1);
        ResultSet pt = conectar.consultar("SELECT * FROM sala ORDER BY especialidad ASC");
        try {
            while (pt.next()) {
                lista.add(pt.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Lugar1.getItems().addAll(lista);
        Lugar.getItems().addAll(lista);
        Sala.getItems().addAll(lista);
        via.getItems().addAll("tubo endotraqueal", "TET-TQ", "traqueotomia TQ");
        pt = conectar.consultar("SELECT * FROM causa ORDER BY nombre ASC");
        VBox vbox1 = new VBox();
        VBox vbox2 = new VBox();

        vbox1.setStyle("-fx-padding: 15 12 15 12; -fx-spacing: 10;-fx-background-color: white;");
        vbox2.setStyle("-fx-padding: 15 12 15 12; -fx-spacing: 10;-fx-background-color: white;");
        try {
            while (pt.next()) {
                if (pt.getString(2).equals("respiratorias")) {
                    vbox1.getChildren().add(new CheckBox(pt.getString(1)));
                } else {
                    vbox2.getChildren().add(new CheckBox(pt.getString(1)));
                }
            }

            Fallo1A.setContent(vbox1);
            Fallo2A.setContent(vbox2);

        } catch (SQLException ex) {
            Logger.getLogger(DoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        limitacion.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue == null) {
                progreso.setProgress(progreso.getProgress() + 0.03);
            }

        });

        GrupoRaza.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue == null) {
                progreso.setProgress(progreso.getProgress() + 0.05);
            }

        });
        GrupoSexo.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue == null) {
                progreso.setProgress(progreso.getProgress() + 0.06);
            }
        });
        edad.focusedProperty().addListener((observable, wasFocused, isFocused) -> {
            if (!isFocused && wasFocused) {
                if (edad.getValue() != 0 && !edadB) {
                    progreso.setProgress(progreso.getProgress() + 0.06);
                    edadB = true;

                }
                if (edad.getValue() == 0 && edadB) {
                    progreso.setProgress(progreso.getProgress() - 0.06);
                    edadB = false;

                }

            }
        });

        timeVam.focusedProperty().addListener((observable, wasFocused, isFocused) -> {
            if (!isFocused && wasFocused) {
                if (timeVam.getValue() != 0 && !tiempo) {
                    progreso.setProgress(progreso.getProgress() + 0.06);
                    tiempo = true;
                }
                if (timeVam.getValue() == 0 && tiempo) {
                    progreso.setProgress(progreso.getProgress() - 0.06);
                    tiempo = false;

                }

            }
        });

        tablaFallo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if ((saber(Fallo1A) || saber(Fallo2A)) && !senal) {

                    progreso.setProgress(progreso.getProgress() + 0.06);
                    senal = true;
                    tabMayor.setDisable(true);
                    tablaFallo.setDisable(true);
                    noSeleccion.setVisible(false);

                } else {
                    if (!(saber(Fallo1A) || saber(Fallo2A)) && senal) {
                        senal = false;
                        progreso.setProgress(progreso.getProgress() - 0.06);
                        tabMayor.setDisable(false);
                        tablaFallo.setDisable(false);
                        noSeleccion.setVisible(true);

                    }
                    if ((saber(Fallo1A) || saber(Fallo2A)) && senal) {
                        senal = true;
                        tabMayor.setDisable(true);
                        tablaFallo.setDisable(true);
                        noSeleccion.setVisible(false);
                    }
                }
            }
        });

        apache.focusedProperty().addListener((observable, wasFocused, isFocused) -> {
            if (!isFocused && wasFocused) {
                if (apache.getValue() != 0 && !apII) {
                    progreso.setProgress(progreso.getProgress() + 0.05);
                    apII = true;
                }
                if (apache.getValue() == 0 && apII) {
                    progreso.setProgress(progreso.getProgress() - 0.05);
                    apII = false;

                }

            }
        });
        progreso.progressProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue.intValue() == 1 && (noFallece.isSelected() || (!noFallece.isSelected() && FechaAlta.getValue() != null))) {

                Boton_Listo.setDisable(false);
            } else {
                Boton_Listo.setDisable(true);
            }

        });
        progresos.progressProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue.intValue() == 1) {
                botagregar.setDisable(false);
            } else {
                botagregar.setDisable(true);
            }

        });
        FechaIngreso.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue == null && newValue != null) {
                progreso.setProgress(progreso.getProgress() + 0.10);
                FechaIngresoUci.setDisable(false);
                FechaIngresoUci.setDayCellFactory(picker -> new DateCell() {
                    @Override
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        if (date != null && FechaIngreso.getValue() != null) {
                            setDisable(date.isBefore(FechaIngreso.getValue()));
                        }
                    }
                });
            }

            if (oldValue != null && newValue == null) {
                progreso.setProgress(progreso.getProgress() - 0.10);
                FechaIngresoUci.setDisable(true);
            }

        });
        fechaEgreso.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue == null && newValue != null) {
                progreso.setProgress(progreso.getProgress() + 0.05);
                FechaAlta.setDisable(false);
                FechaAlta.setDayCellFactory(picker -> new DateCell() {
                    @Override
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        if (date != null && fechaEgreso.getValue() != null) {
                            setDisable(date.isBefore(fechaEgreso.getValue()));
                        }
                    }
                });
            }

            if (oldValue != null && newValue == null) {
                FechaAlta.setDisable(true);
                progreso.setProgress(progreso.getProgress() - 0.05);
            }

        });

        FechaIngresoUci.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue == null && newValue != null) {
                progreso.setProgress(progreso.getProgress() + 0.05);
                fechaEgreso.setDisable(false);
                fechaEgreso.setDayCellFactory(picker -> new DateCell() {
                    @Override
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        if (date != null && FechaIngresoUci.getValue() != null) {
                            setDisable(date.isBefore(FechaIngresoUci.getValue()));
                        }
                    }
                });
            }

            if (oldValue != null && newValue == null) {
                fechaEgreso.setDisable(true);
                progreso.setProgress(progreso.getProgress() - 0.05);
            }

        });
        FechaAlta.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                if (progreso.getProgress() == 1) {
                    if (noFallece.isSelected()) {
                        Boton_Listo.setDisable(false);
                    } else {
                        Boton_Listo.setDisable(true);
                    }
                }
            } else if (progreso.getProgress() == 1) {
                Boton_Listo.setDisable(false);
            }

        });
        noFallece.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (!oldValue) {
                if (Lugar.getValue() != null) {
                    progreso.setProgress(progreso.getProgress() - 0.08);
                }
                if (!resultadodefun.getItems().isEmpty()) {
                    progreso.setProgress(progreso.getProgress() - 0.06);
                }
                if (noNecropsia.isSelected()) {
                    progreso.setProgress(progreso.getProgress() - 0.06);
                } else {
                    if (!resultadoNecrop.getItems().isEmpty()) {
                        progreso.setProgress(progreso.getProgress() - 0.06);
                    }

                }
                tablaprocedimiento.setDisable(true);
                Lugar.setDisable(true);
                progreso.setProgress(progreso.getProgress() + 0.20);
            } else {

                if (Lugar.getValue() != null) {
                    progreso.setProgress(progreso.getProgress() + 0.08);
                }
                if (!resultadodefun.getItems().isEmpty()) {
                    progreso.setProgress(progreso.getProgress() + 0.06); 

                }
                if (noNecropsia.isSelected()) {
                    progreso.setProgress(progreso.getProgress() + 0.06);

                } else {

                    if (!resultadoNecrop.getItems().isEmpty()) {
                        progreso.setProgress(progreso.getProgress() + 0.06);
                    }

                }
                tablaprocedimiento.setDisable(false);
                Lugar.setDisable(false);

                progreso.setProgress(progreso.getProgress() - 0.20);
            }

        });

        Boton_Listo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!senal) {
                    noSeleccion.setVisible(true);
                } else {
                    noSeleccion.setVisible(false);

                    String clasificacion = "";
                    if (via.getSelectionModel().getSelectedItem().equals("tubo endotraqueal")) {
                        clasificacion = "sin traqueotomia";
                    } else {
                        clasificacion = "con traqueotomia";
                    }
                    if (noFallece.isSelected()) {
                        try {
                            vaciar(panelnecro);
                            vaciar(paneldefun);
                        } catch (SQLException ex) {
                            Logger.getLogger(DoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    ArrayList<Procedimiento> listanecropsia = new ArrayList<>(resultadoNecrop.getItems());
                    ArrayList<Procedimiento> listadefuncion = new ArrayList<>(resultadodefun.getItems());
                    ArrayList<String> listapreuci = new ArrayList<>(diagnostico2.getItems());
                    ArrayList<String> listapostuci = new ArrayList<>(diagnosticoE2.getItems());
                    ArrayList<Causa> causavam = new ArrayList<>(1);
                    for (Node node : ((VBox) Fallo1A.getContent()).getChildren()) {
                        CheckBox cb = (CheckBox) node;
                        if (cb.isSelected()) {
                            causavam.add(new Causa(cb.getText(), "respiratorias"));
                        }
                    }

                    for (Node node : ((VBox) Fallo2A.getContent()).getChildren()) {
                        CheckBox cb = (CheckBox) node;
                        if (cb.isSelected()) {
                            causavam.add(new Causa(cb.getText(), "no respiratorias"));
                        }
                    }

                    ResultSet p = null;

                    if (noNecropsia.isSelected() && !noFallece.isSelected()) {
                        if (FechaAlta.getValue() != null) {
                            p = conectar.consultar("Select * from insertarpaciente('" + ((RadioButton) GrupoSexo.getSelectedToggle()).getId() + "','" + ((RadioButton) GrupoRaza.getSelectedToggle()).getId() + "','" + FechaIngreso.getValue() + "','" + FechaAlta.getValue() + "','" + Lugar.getSelectionModel().getSelectedItem() + "'," + edad.getValue() + "," + apache.getValue() + ",'" + ((RadioButton) limitacion.getSelectedToggle()).getId().substring(1) + "','" + FechaIngresoUci.getValue() + "','" + fechaEgreso.getValue() + "','" + Sala.getSelectionModel().getSelectedItem() + "'," + timeVam.getValue() + ",'" + via.getSelectionModel().getSelectedItem() + "','" + clasificacion + "','" + listapreuci.get(0) + "','" + listadefuncion.get(0).getCausa() + "','" + listadefuncion.get(0).getTipo() + "'," + "null" + "," + "null" + ",'" + listapostuci.get(0) + "','" + causavam.get(0).getCausa() + "','" + causavam.get(0).getClasific() + "')");
                        } else {
                            p = conectar.consultar("Select * from insertarpaciente('" + ((RadioButton) GrupoSexo.getSelectedToggle()).getId() + "','" + ((RadioButton) GrupoRaza.getSelectedToggle()).getId() + "','" + FechaIngreso.getValue() + "',null,'" + Lugar.getSelectionModel().getSelectedItem() + "'," + edad.getValue() + "," + apache.getValue() + ",'" + ((RadioButton) limitacion.getSelectedToggle()).getId().substring(1) + "','" + FechaIngresoUci.getValue() + "','" + fechaEgreso.getValue() + "','" + Sala.getSelectionModel().getSelectedItem() + "'," + timeVam.getValue() + ",'" + via.getSelectionModel().getSelectedItem() + "','" + clasificacion + "','" + listapreuci.get(0) + "','" + listadefuncion.get(0).getCausa() + "','" + listadefuncion.get(0).getTipo() + "'," + "null" + "," + "null" + ",'" + listapostuci.get(0) + "','" + causavam.get(0).getCausa() + "','" + causavam.get(0).getClasific() + "')");
                        }

                    } else {

                        if (noFallece.isSelected()) {
                            if (FechaAlta.getValue() != null) {
                                p = conectar.consultar("Select * from insertarpaciente('" + ((RadioButton) GrupoSexo.getSelectedToggle()).getId() + "','" + ((RadioButton) GrupoRaza.getSelectedToggle()).getId() + "','" + FechaIngreso.getValue() + "','" + FechaAlta.getValue() + "'," + "null" + "," + edad.getValue() + "," + apache.getValue() + ",'" + ((RadioButton) limitacion.getSelectedToggle()).getId().substring(1) + "','" + FechaIngresoUci.getValue() + "','" + fechaEgreso.getValue() + "','" + Sala.getSelectionModel().getSelectedItem() + "'," + timeVam.getValue() + ",'" + via.getSelectionModel().getSelectedItem() + "','" + clasificacion + "','" + listapreuci.get(0) + "'," + "null" + "," + "null" + "," + "null" + "," + "null" + ",'" + listapostuci.get(0) + "','" + causavam.get(0).getCausa() + "','" + causavam.get(0).getClasific() + "')");
                            } else {
                                p = conectar.consultar("Select * from insertarpaciente('" + ((RadioButton) GrupoSexo.getSelectedToggle()).getId() + "','" + ((RadioButton) GrupoRaza.getSelectedToggle()).getId() + "','" + FechaIngreso.getValue() + "',null," + "null" + "," + edad.getValue() + "," + apache.getValue() + ",'" + ((RadioButton) limitacion.getSelectedToggle()).getId().substring(1) + "','" + FechaIngresoUci.getValue() + "','" + fechaEgreso.getValue() + "','" + Sala.getSelectionModel().getSelectedItem() + "'," + timeVam.getValue() + ",'" + via.getSelectionModel().getSelectedItem() + "','" + clasificacion + "','" + listapreuci.get(0) + "'," + "null" + "," + "null" + "," + "null" + "," + "null" + ",'" + listapostuci.get(0) + "','" + causavam.get(0).getCausa() + "','" + causavam.get(0).getClasific() + "')");
                            }
                        } else {
                            if (FechaAlta.getValue() != null) {
                                p = conectar.consultar("Select * from insertarpaciente('" + ((RadioButton) GrupoSexo.getSelectedToggle()).getId() + "','" + ((RadioButton) GrupoRaza.getSelectedToggle()).getId() + "','" + FechaIngreso.getValue() + "','" + FechaAlta.getValue() + "','" + Lugar.getSelectionModel().getSelectedItem() + "'," + edad.getValue() + "," + apache.getValue() + ",'" + ((RadioButton) limitacion.getSelectedToggle()).getId().substring(1) + "','" + FechaIngresoUci.getValue() + "','" + fechaEgreso.getValue() + "','" + Sala.getSelectionModel().getSelectedItem() + "'," + timeVam.getValue() + ",'" + via.getSelectionModel().getSelectedItem() + "','" + clasificacion + "','" + listapreuci.get(0) + "','" + listadefuncion.get(0).getCausa() + "','" + listadefuncion.get(0).getTipo() + "','" + listanecropsia.get(0).getCausa() + "','" + listanecropsia.get(0).getTipo() + "','" + listapostuci.get(0) + "','" + causavam.get(0).getCausa() + "','" + causavam.get(0).getClasific() + "')");
                            } else {
                                p = conectar.consultar("Select * from insertarpaciente('" + ((RadioButton) GrupoSexo.getSelectedToggle()).getId() + "','" + ((RadioButton) GrupoRaza.getSelectedToggle()).getId() + "','" + FechaIngreso.getValue() + "',null,'" + Lugar.getSelectionModel().getSelectedItem() + "'," + edad.getValue() + "," + apache.getValue() + ",'" + ((RadioButton) limitacion.getSelectedToggle()).getId().substring(1) + "','" + FechaIngresoUci.getValue() + "','" + fechaEgreso.getValue() + "','" + Sala.getSelectionModel().getSelectedItem() + "'," + timeVam.getValue() + ",'" + via.getSelectionModel().getSelectedItem() + "','" + clasificacion + "','" + listapreuci.get(0) + "','" + listadefuncion.get(0).getCausa() + "','" + listadefuncion.get(0).getTipo() + "','" + listanecropsia.get(0).getCausa() + "','" + listanecropsia.get(0).getTipo() + "','" + listapostuci.get(0) + "','" + causavam.get(0).getCausa() + "','" + causavam.get(0).getClasific() + "')");
                            }

                        }
                    }
                    if (p == null) {
                        Alert alerta = new Alert(Alert.AlertType.WARNING);
                        alerta.setHeaderText(null);
                        alerta.setTitle("Paciente existente");
                        alerta.setContentText("Se esta duplicando información.");
                        alerta.showAndWait();
                    } else {
                        try {
                            while (p.next()) {
                                ident = p.getString(1);
                                data.add(new Paciente(ident, edad.getValue().toString(), ((RadioButton) GrupoSexo.getSelectedToggle()).getId(), ((RadioButton) GrupoRaza.getSelectedToggle()).getId()));
                            }

                            for (int i = 1; i < listapreuci.size(); i++) {
                                ResultSet n = conectar.consultar("select * from nuevaenf(" + ident + ",'" + listapreuci.get(i) + "')");
                            }

                            for (int i = 1; i < listadefuncion.size(); i++) {
                                ResultSet n = conectar.consultar("select * from nueva_causadefun(" + ident + ",'" + listadefuncion.get(i).getCausa() + "','" + listadefuncion.get(i).getTipo() + "')");
                            }

                            for (int i = 1; i < listanecropsia.size(); i++) {
                                ResultSet n = conectar.consultar("select * from nueva_causanecro(" + ident + ",'" + listanecropsia.get(i).getCausa() + "','" + listanecropsia.get(i).getTipo() + "')");

                            }
                            for (int i = 1; i < listapostuci.size(); i++) {
                                ResultSet n = conectar.consultar("select * from nuevaenfpost(" + ident + ",'" + listapostuci.get(i) + "')");
                            }

                            for (int i = 1; i < causavam.size(); i++) {
                                ResultSet n = conectar.consultar("select * from nueva_causavam(" + ident + ",'" + causavam.get(i).getCausa() + "')");
                            }

                            limpiar();
                            PanelAgregar.setDisable(true);
                            ventanaemergente.setVisible(true);
                            Cronometraje(3);
                        } catch (SQLException ex) {
                            Logger.getLogger(DoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });

        Sala.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue == null) {
                progreso.setProgress(progreso.getProgress() + 0.05);
            }

        });
        via.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue == null) {
                progreso.setProgress(progreso.getProgress() + 0.08);
            }

        });
        Lugar.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue == null) {
                progreso.setProgress(progreso.getProgress() + 0.08);
            }

        });
        Lugar1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue == null) {
                progresos.setProgress(progresos.getProgress() + 0.20);
                labelporciento.setText(progresos.getProgress() * 100 + "%");
            }

        });
        noNecropsia.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (!oldValue) {
                progreso.setProgress(progreso.getProgress() + 0.06);
                necropsia.setDisable(true);
                resultadoNecrop.setDisable(true);

                if (!resultadoNecrop.getItems().isEmpty()) {
                    progreso.setProgress(progreso.getProgress() - 0.06);

                }
            } else {
                try {
                    vaciar(panelnecro);
                } catch (SQLException ex) {
                    Logger.getLogger(DoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
                progreso.setProgress(progreso.getProgress() - 0.06);
                necropsia.setDisable(false);

                resultadoNecrop.setDisable(false);

                if (!resultadoNecrop.getItems().isEmpty()) {
                    progreso.setProgress(progreso.getProgress() + 0.06);

                }
            }

        });
        noNecropsia1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (!oldValue) {
                progresos.setProgress(progresos.getProgress() + 0.30);

                necropsia1.setDisable(true);
                resultadoNecrop1.setDisable(true);
                if (!resultadoNecrop1.getItems().isEmpty()) {
                    progresos.setProgress(progresos.getProgress() - 0.30);

                }
                labelporciento.setText(progresos.getProgress() * 100 + "%");
            } else {
                progresos.setProgress(progresos.getProgress() - 0.30);
                necropsia1.setDisable(false);
                resultadoNecrop1.setDisable(false);
                if (!resultadoNecrop1.getItems().isEmpty()) {
                    progresos.setProgress(progresos.getProgress() + 0.30);

                }
                labelporciento.setText(progresos.getProgress() * 100 + "%");
            }

        });
        necropsia.setOnMouseClicked(ActionEvent -> {
            if (resultadoNecrop.getItems().isEmpty()) {
                progreso.setProgress(progreso.getProgress() + 0.06);

            }
            if (necropsia.getSelectionModel().getSelectedItem() != null) {
                resultadoNecrop.getItems().add(new Procedimiento(necropsia.getSelectionModel().getSelectedItem().toString(), "basica"));
                necropsia.getItems().remove(necropsia.getSelectionModel().getSelectedItem());
            }

        });
        defunsion.setOnMouseClicked(ActionEvent -> {
            if (resultadodefun.getItems().isEmpty()) {
                progreso.setProgress(progreso.getProgress() + 0.06);

            }
            if (defunsion.getSelectionModel().getSelectedItem() != null) {
                resultadodefun.getItems().add(new Procedimiento(defunsion.getSelectionModel().getSelectedItem().toString(), "basica"));
                defunsion.getItems().remove(defunsion.getSelectionModel().getSelectedItem());
            }

        });
        necropsia1.setOnMouseClicked(ActionEvent -> {
            if (resultadoNecrop1.getItems().isEmpty()) {
                progresos.setProgress(progresos.getProgress() + 0.30);

            }
            if (necropsia1.getSelectionModel().getSelectedItem() != null) {
                resultadoNecrop1.getItems().add(new Procedimiento(necropsia1.getSelectionModel().getSelectedItem().toString(), "basica"));
                necropsia1.getItems().remove(necropsia1.getSelectionModel().getSelectedItem());
            }
            labelporciento.setText(progresos.getProgress() * 100 + "%");
        });
        defunsion1.setOnMouseClicked(ActionEvent -> {
            if (resultadodefun1.getItems().isEmpty()) {
                progresos.setProgress(progresos.getProgress() + 0.50);

            }
            if (defunsion1.getSelectionModel().getSelectedItem() != null) {
                resultadodefun1.getItems().add(new Procedimiento(defunsion1.getSelectionModel().getSelectedItem().toString(), "basica"));
                defunsion1.getItems().remove(defunsion1.getSelectionModel().getSelectedItem());
            }
            labelporciento.setText(progresos.getProgress() * 100 + "%");
        });
        tabla.setRowFactory(new Callback<TableView<Paciente>, TableRow<Paciente>>() {
            @Override
            public TableRow<Paciente> call(TableView<Paciente> tableView) {
                final TableRow<Paciente> row = new TableRow<>();
                final ContextMenu rowMenu = new ContextMenu();

                MenuItem removeItem = new MenuItem("Eliminar");
                removeItem.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Paciente selectedItem = tabla.getSelectionModel().getSelectedItem();
                        if (selectedItem != null) {
                            ResultSet n = conectar.consultar("Select * from eliminar_paciente(" + selectedItem.getPaciente() + ")");
                            data.remove(selectedItem);
                            tabla.refresh();
                        }
                    }
                });

                // Agrega el elemento al menú solo si cumple con la condición
                row.itemProperty().addListener((obs, previousPaciente, currentPaciente) -> {
                    rowMenu.getItems().clear();
                    if (currentPaciente != null && Integer.parseInt(currentPaciente.getPaciente()) > 208) {
                        rowMenu.getItems().add(removeItem);
                    }
                });

                row.contextMenuProperty().bind(
                        Bindings.when(row.emptyProperty())
                                .then((ContextMenu) null)
                                .otherwise(rowMenu)
                );
                return row;
            }
        });

        tiponecro.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Procedimiento, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Procedimiento, String> t) {
                Procedimiento nuevo = resultadoNecrop.getSelectionModel().getSelectedItem();
                String nuevonombre = t.getNewValue();
                int rowIndex = resultadoNecrop.getItems().indexOf(nuevo);
                if (nuevonombre.trim().isEmpty()) {
                    resultadoNecrop.getItems().set(rowIndex, nuevo);
                    resultadoNecrop.refresh();
                } else {
                    nuevo.setTipo(nuevonombre);
                    resultadoNecrop.getItems().set(rowIndex, nuevo);
                    resultadoNecrop.refresh();
                }
            }
        });
        tipodefun.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Procedimiento, String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Procedimiento, String> t) {
                Procedimiento nuevo = resultadodefun.getSelectionModel().getSelectedItem();
                String nuevonombre = t.getNewValue();
                int rowIndex = resultadodefun.getItems().indexOf(nuevo);
                if (nuevonombre.trim().isEmpty()) {
                    resultadodefun.getItems().set(rowIndex, nuevo);
                    resultadodefun.refresh();
                } else {
                    nuevo.setTipo(nuevonombre);
                    resultadodefun.getItems().set(rowIndex, nuevo);
                    resultadodefun.refresh();
                }
            }
        });
        resultadodefun.setRowFactory(new Callback<TableView<Procedimiento>, TableRow<Procedimiento>>() {
            @Override
            public TableRow<Procedimiento> call(TableView<Procedimiento> tableView) {
                final TableRow<Procedimiento> row = new TableRow<>();
                final ContextMenu rowMenu = new ContextMenu();

                MenuItem removeItem = new MenuItem("Eliminar");
                removeItem.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (resultadodefun.getSelectionModel().getSelectedItem() != null) {
                            defunsion.getItems().add(resultadodefun.getSelectionModel().getSelectedItem().getCausa());
                            resultadodefun.getItems().remove(resultadodefun.getSelectionModel().getSelectedItem());
                            if (resultadodefun.getItems().isEmpty()) {
                                progreso.setProgress(progreso.getProgress() - 0.06);

                            }
                        }

                    }
                });
                rowMenu.getItems().add(removeItem);

                row.contextMenuProperty().bind(
                        Bindings.when(row.emptyProperty())
                                .then((ContextMenu) null)
                                .otherwise(rowMenu)
                );
                return row;
            }
        });
        resultadodefun1.setRowFactory(new Callback<TableView<Procedimiento>, TableRow<Procedimiento>>() {
            @Override
            public TableRow<Procedimiento> call(TableView<Procedimiento> tableView) {
                final TableRow<Procedimiento> row = new TableRow<>();
                final ContextMenu rowMenu = new ContextMenu();

                MenuItem removeItem = new MenuItem("Eliminar");
                removeItem.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (resultadodefun1.getSelectionModel().getSelectedItem() != null) {
                            defunsion1.getItems().add(resultadodefun1.getSelectionModel().getSelectedItem().getCausa());
                            resultadodefun1.getItems().remove(resultadodefun1.getSelectionModel().getSelectedItem());
                            if (resultadodefun1.getItems().isEmpty()) {
                                progresos.setProgress(progresos.getProgress() - 0.50);
                                labelporciento.setText(progresos.getProgress() * 100 + "%");
                            }
                        }

                    }
                });
                rowMenu.getItems().add(removeItem);

                row.contextMenuProperty().bind(
                        Bindings.when(row.emptyProperty())
                                .then((ContextMenu) null)
                                .otherwise(rowMenu)
                );
                return row;
            }
        });
        resultadoNecrop.setRowFactory(new Callback<TableView<Procedimiento>, TableRow<Procedimiento>>() {
            @Override
            public TableRow<Procedimiento> call(TableView<Procedimiento> tableView) {
                final TableRow<Procedimiento> row = new TableRow<>();
                final ContextMenu rowMenu = new ContextMenu();

                MenuItem removeItem = new MenuItem("Eliminar");
                removeItem.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (resultadoNecrop.getSelectionModel().getSelectedItem() != null) {
                            necropsia.getItems().add(resultadoNecrop.getSelectionModel().getSelectedItem().getCausa());
                            resultadoNecrop.getItems().remove(resultadoNecrop.getSelectionModel().getSelectedItem());
                            if (resultadoNecrop.getItems().isEmpty()) {
                                progreso.setProgress(progreso.getProgress() - 0.06);

                            }
                        }

                    }
                });
                rowMenu.getItems().add(removeItem);

                row.contextMenuProperty().bind(
                        Bindings.when(row.emptyProperty())
                                .then((ContextMenu) null)
                                .otherwise(rowMenu)
                );
                return row;
            }
        });
        resultadoNecrop1.setRowFactory(new Callback<TableView<Procedimiento>, TableRow<Procedimiento>>() {
            @Override
            public TableRow<Procedimiento> call(TableView<Procedimiento> tableView) {
                final TableRow<Procedimiento> row = new TableRow<>();
                final ContextMenu rowMenu = new ContextMenu();

                MenuItem removeItem = new MenuItem("Eliminar");
                removeItem.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (resultadoNecrop1.getSelectionModel().getSelectedItem() != null) {
                            necropsia1.getItems().add(resultadoNecrop1.getSelectionModel().getSelectedItem().getCausa());
                            resultadoNecrop1.getItems().remove(resultadoNecrop1.getSelectionModel().getSelectedItem());
                            if (resultadoNecrop1.getItems().isEmpty()) {
                                progresos.setProgress(progresos.getProgress() - 0.30);
                                labelporciento.setText(progresos.getProgress() * 100 + "%");
                            }
                        }

                    }
                });
                rowMenu.getItems().add(removeItem);

                row.contextMenuProperty().bind(
                        Bindings.when(row.emptyProperty())
                                .then((ContextMenu) null)
                                .otherwise(rowMenu)
                );
                return row;
            }
        });
        diagnostico1.setOnMouseClicked(ActionEvent -> {
            if (diagnostico2.getItems().isEmpty()) {
                progreso.setProgress(progreso.getProgress() + 0.05);

            }
            if (diagnostico1.getSelectionModel().getSelectedItem() != null) {
                diagnostico2.getItems().add(diagnostico1.getSelectionModel().getSelectedItem());
                diagnostico1.getItems().remove(diagnostico1.getSelectionModel().getSelectedItem());
            }

        });
        diagnostico2.setOnMouseClicked(ActionEvent -> {
            if (diagnostico2.getSelectionModel().getSelectedItem() != null) {
                diagnostico1.getItems().add(diagnostico2.getSelectionModel().getSelectedItem());
                diagnostico2.getItems().remove(diagnostico2.getSelectionModel().getSelectedItem());
                if (diagnostico2.getItems().isEmpty()) {
                    progreso.setProgress(progreso.getProgress() - 0.05);

                }
            }

        });
        diagnosticoE1.setOnMouseClicked(ActionEvent -> {
            if (diagnosticoE2.getItems().isEmpty()) {
                progreso.setProgress(progreso.getProgress() + 0.05);

            }
            if (diagnosticoE1.getSelectionModel().getSelectedItem() != null) {
                diagnosticoE2.getItems().add(diagnosticoE1.getSelectionModel().getSelectedItem());
                diagnosticoE1.getItems().remove(diagnosticoE1.getSelectionModel().getSelectedItem());
            }

        });
        diagnosticoE2.setOnMouseClicked(ActionEvent -> {
            if (diagnosticoE2.getSelectionModel().getSelectedItem() != null) {
                diagnosticoE1.getItems().add(diagnosticoE2.getSelectionModel().getSelectedItem());
                diagnosticoE2.getItems().remove(diagnosticoE2.getSelectionModel().getSelectedItem());
                if (diagnosticoE2.getItems().isEmpty()) {
                    progreso.setProgress(progreso.getProgress() - 0.05);

                }
            }

        });
    }

    public void limpiar() throws SQLException {
        edadB = false;
        tiempo = false;
        senal = false;
        apII = false;
        estanU = false;
        vaciar(DatosPersonales);
        vaciar(panelieHospit);
        vaciar(panelFallece);
        vaciar(panelIngresoUci);
        vaciar(panelVAM);
        vaciar(panelEgresoUci);
        vaciar(Fallo1Apane);
        vaciar(Fallo2Apane);

        vaciar(panelnecro);
        vaciar(paneldefun);
        progreso.setProgress(0);
    }

    public void habilitarTabla() {
        tabMayor.setDisable(false);
        tablaFallo.setDisable(false);
    }

    public void vaciar(AnchorPane panel) throws SQLException {
        for (Node node : panel.getChildren()) {
            if (node instanceof TextField) {
                TextField cb = (TextField) node;
                cb.setText("");
            }
            if (node instanceof Spinner) {
                Spinner spin = (Spinner) node;
                spin.getValueFactory().setValue(0);

            }
            if (node instanceof ScrollPane) {
                ScrollPane scroll = (ScrollPane) node;
                Node content = scroll.getContent();
                if (content instanceof VBox) {
                    ObservableList<Node> children = ((VBox) content).getChildren();
                    for (Node child : children) {
                        if (child instanceof CheckBox) {
                            CheckBox cbx = (CheckBox) child;
                            cbx.setSelected(false);
                        }
                    }
                }
            }
            if (node instanceof ListView) {
                ListView lista = (ListView) node;
                lista.getItems().clear();
                asignacion();
                if (lista.getId().equals("necropsia")) {
                    lista.setItems(itemsNecro);

                } else {
                    if (lista.getId().equals("diagnostico1")) {
                        lista.setItems(itemsDiagnostico1);
                    } else {
                        if (lista.getId().equals("diagnosticoE1")) {
                            lista.setItems(itemsDiagnosticoE);
                        } else {
                            if (lista.getId().equals("defunsion")) {
                                lista.setItems(itemsDefun);
                            } else {
                                if (lista.getId().equals("defunsion1")) {
                                    lista.setItems(itemsDefun1);
                                } else {
                                    if (lista.getId().equals("necropsia1")) {
                                        lista.setItems(itemsNecro1);
                                    }
                                }
                            }

                        }
                    }
                }
            }
            if (node instanceof RadioButton) {
                RadioButton radio = (RadioButton) node;
                radio.setSelected(false);
            }
            if (node instanceof DatePicker) {
                DatePicker fechass = (DatePicker) node;
                fechass.setValue(null);
            }
            if (node instanceof CheckBox) {
                CheckBox cbx = (CheckBox) node;
                cbx.setSelected(false);
            }
            if (node instanceof ComboBox) {
                ComboBox cbo = (ComboBox) node;
                cbo.setValue(null);
            }
            if (node instanceof TextArea) {
                TextArea tx = (TextArea) node;
                tx.setText("");
            }
            if (node instanceof TableView) {

                ((TableView) node).getItems().clear();
            }

        }

    }

    public boolean saber(ScrollPane name) {
        Node content = name.getContent();
        if (content instanceof VBox) {
            ObservableList<Node> children = ((VBox) content).getChildren();
            for (Node child : children) {
                if (child instanceof CheckBox) {
                    CheckBox cbx = (CheckBox) child;
                    if (cbx.isSelected()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void pastel() throws SQLException {
// Obtener los datos de la base de datos.
        ResultSet pt = conectar.consultar("Select * from calcular_promedio_sala()");
        DefaultPieDataset dataset = new DefaultPieDataset();

        while (pt.next()) {
            dataset.setValue(pt.getString(1), Double.parseDouble(pt.getString(2)) * 100);
        }

// Crear el gráfico de pastel.
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
                }
            }
        });

// Iniciar el Timer.
        timer.start();

// Mostrar el gráfico de pastel.
        ChartPanel mostrarpastel = new ChartPanel(grafica);
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
        while (p.next()) {

            series.getData().add(new XYChart.Data<>("blanca-" + Double.parseDouble(p.getString(1)) * 100 + "%", Double.parseDouble(p.getString(1)) * 100));
            series.getData().add(new XYChart.Data<>("negra-" + Double.parseDouble(p.getString(2)) * 100 + "%", Double.parseDouble(p.getString(2)) * 100));
            series.getData().add(new XYChart.Data<>("mestiza-" + Double.parseDouble(p.getString(3)) * 100 + "%", Double.parseDouble(p.getString(3)) * 100));
        }
        graficabarras.lookup(".chart-plot-background").setStyle("-fx-background-color:transparent;");
        graficabarras.getData().add(series);
        graficabarras.lookupAll(".chart-bar").forEach(n -> n.setStyle("-fx-bar-fill: blue;"));
        graficabarras.setTitle("Promedio de fallecidos por raza");
        graficabarras.setLegendVisible(false);
        graficabarras.setStyle("-fx-font-weight: bold;");
        mostrarbarras.getChildren().add(graficabarras);

    }

    public void informacion() {
        marcador.setText("INFORMACIÓN");
        botRegistroDatos.getStyleClass().remove("selected");
        botAddPaciente.getStyleClass().remove("selected");
        botEstadist.getStyleClass().remove("selected");
        PanelAgregar.setVisible(false);
        PanelEstadistica.setVisible(false);
        PanelInformacion.setVisible(true);
        PanelRegistros.setVisible(false);
    }

    public void Cronometraje(int inicio) {
        if (inicio >= 0) {
            cronometro.setText(Integer.toString(inicio));
            PauseTransition pausa = new PauseTransition(Duration.seconds(inicio));
            pausa.setOnFinished(ActionEvent -> {
                Cronometraje(inicio - 1);

            });

            pausa.play();
        } else {

            PanelAgregar.setDisable(false);
            ventanaemergente.setVisible(false);

        }

    }

    public void mostrarMortalidad() throws SQLException {

        graficaResultado.getData().clear();
        double mortalidad = 0;
        ResultSet p = conectar.consultar("Select mort_oculta  from mortalidad where id_pac=" + ident);
        while (p.next()) {
            mortalidad = Double.parseDouble(p.getString(1));
        }
        ObservableList<PieChart.Data> pieCh = FXCollections.observableArrayList(
                new PieChart.Data("Mortalidad Oculta ", 65.00), new PieChart.Data("Sobrevivencia ", 35.00)
        );
        pieCh.forEach(data
                -> data.nameProperty().bind(Bindings.concat(data.getName(), ": ", data.pieValueProperty(), "%"))
        );
        graficaResultado.getData().addAll(pieCh);

        timeLin = new Timeline();

        KeyValue key = new KeyValue(pieCh.get(0).pieValueProperty(),mortalidad);
        KeyFrame keyf = new KeyFrame(Duration.seconds(0.3), key);
        timeLin.getKeyFrames().add(keyf);
        double calculo = 100 - mortalidad;

        KeyValue key2 = new KeyValue(pieCh.get(1).pieValueProperty(), Double.parseDouble(String.format("%.2f", calculo)));
        KeyFrame keyf2 = new KeyFrame(Duration.seconds(0.3), key2);
        timeLin.getKeyFrames().add(keyf2);

        timeLin.playFromStart();
        ventanaMortalidad.setVisible(true);
        ventanaemergente.setVisible(false);

    }

    public void AgregarFallecido() throws SQLException {
        paneldeagregar.setVisible(true);
        vaciar(panelagregar);
    }

    public void agregarbd() throws SQLException {
        paneldeagregar.setVisible(false);
        pacfallecido.setSelected(false);
        ResultSet p = conectar.consultar("Select * from actualizar_salamuertepaciente(" + tabla.getSelectionModel().getSelectedItem().getPaciente() + ",'" + Lugar1.getSelectionModel().getSelectedItem() + "')");
        ArrayList<Procedimiento> nuevadefunc = new ArrayList<>(resultadodefun1.getItems());
        for (Procedimiento x : nuevadefunc) {
            p = conectar.consultar("Select * from nueva_causadefun(" + tabla.getSelectionModel().getSelectedItem().getPaciente() + ",'" + x.getCausa() + "','" + x.getTipo() + "')");
        }

        if (!noNecropsia.isSelected()) {
            ArrayList<Procedimiento> nuevadenecro = new ArrayList<>(resultadoNecrop1.getItems());
            for (Procedimiento x : nuevadenecro) {
                p = conectar.consultar("Select * from nueva_causanecro(" + tabla.getSelectionModel().getSelectedItem().getPaciente() + ",'" + x.getCausa() + "','" + x.getTipo() + "')");
            }
            tabladefun.getItems().addAll(nuevadenecro);
        }
        progresos.setProgress(0);
        pacfallecido.setVisible(false);
        tabfallecimiento.setDisable(false);
        salalabel.setText("Sala de defunsión : ".concat(Lugar1.getSelectionModel().getSelectedItem()));
        tablanecro.getItems().addAll(nuevadefunc);
        ResultSet pt = conectar.consultar("select * from actualizar_mortalidadpaciente(" + tabla.getSelectionModel().getSelectedItem().getPaciente() + ")");
        double mortalidad = 0;
        while (pt.next()) {
            mortalidad = Double.parseDouble(pt.getString(1));
        }
        ObservableList<PieChart.Data> pieCh2 = FXCollections.observableArrayList(
                new PieChart.Data("No Mortalidad", 65.0), new PieChart.Data("No Mortalidad", 35.0)
        );
        graficaResultado2.getData().clear();
        pieCh2 = FXCollections.observableArrayList(
                new PieChart.Data("Mortalidad Oculta ", mortalidad), new PieChart.Data("Sobrevivencia ", Double.parseDouble(String.format("%.2f", 100 - mortalidad)))
        );
        pieCh2.forEach(data
                -> data.nameProperty().bind(Bindings.concat(data.getName(), ": ", data.pieValueProperty(), "%"))
        );
        graficaResultado2.getData().addAll(pieCh2);
        graficaResultado2.setVisible(true);
    }

    public void CerrarMortalidad() {
        timeLin.stop();
        ventanaMortalidad.setVisible(false);
        PanelAgregar.setDisable(false);
    }
}
