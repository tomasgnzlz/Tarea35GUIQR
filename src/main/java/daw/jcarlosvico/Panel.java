/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.jcarlosvico;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author jfervic933
 */
public class Panel extends JPanel {

    // Tamaño del panel. Constantes
    public static final int ANCHO_PANEL = 600;
    public static final int ALTO_PANEL = 200;

    // Atributos del panel
    private JButton btnGenerar, btnCerrar;
    private JLabel lblUrl, lblFichero;
    private JTextField tfUrl, tfFichero;
    private String nombreFichero;

    // Modificaciónes ejercicios
//    JList<String> desplegableExtensiones;
    JLabel textoExt;
    JComboBox<String> comboxAux;
    String extensionEscogida;// como default png

    private JRadioButton botonPNG;
    private JRadioButton botonJPG;
    private ButtonGroup grupoBotones;

    // Constructor 
    public Panel() {
        // Establece el layout del panel
        this.setLayout(new FlowLayout());
        // Establece el color del fondo del panel
        this.setBackground(Color.gray);
        // Establece el tamaño del panel
        this.setSize(ANCHO_PANEL, ALTO_PANEL);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Añade URL Label
        lblUrl = new JLabel("Introduce el texto: ");
        this.add(lblUrl);

        // Añade área de texto para la URL
        // Ancho de unos 40 caracteres aprox
        tfUrl = new JTextField(40);
        this.add(tfUrl);

        // Añade Fichero Label
        lblFichero = new JLabel("Nombre del fichero: ");
        this.add(lblFichero);

        // Añade área de texto para el nombre del fichero
        tfFichero = new JTextField(40);
        this.add(tfFichero);

//*********************************PARTE A**************************************
        String[] datos = {"jpg", "png"};
        textoExt = new JLabel("Escoge el tipo de Extensión");
        this.add(textoExt);
        comboxAux = new JComboBox<>(datos);
        this.add(comboxAux);
//******************************************************************************
//*********************************PARTE B**************************************
        botonJPG = new JRadioButton("jpg");
        botonPNG = new JRadioButton("png");
        this.add(botonJPG);
        this.add(botonPNG);

        grupoBotones = new ButtonGroup();
        grupoBotones.add(botonPNG);
        grupoBotones.add(botonJPG);
//******************************************************************************
        // Añade el botón generar
        btnGenerar = new JButton("Generar código QR");
        this.add(btnGenerar);
        // Comportamiento del botón generar 
        btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Si el contenido de los textField no está vacío
                if (!tfUrl.getText().isEmpty() && !tfFichero.getText().isEmpty()) {

                    //QR.escribirQR(tfUrl.getText(), tfFichero.getText(), "png");
                    // PARTE A
                    QR.escribirQR(tfUrl.getText(), tfFichero.getText(), comboxAux.getSelectedItem().toString());
                    // PARTE B
//                    String ext = (botonJPG.isSelected()) ? "jpg" : "png";
//                    QR.escribirQR(tfUrl.getText(), tfFichero.getText(), ext);

                    new VentanaResultado(tfFichero.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "No puede haber campos vacíos.");
                }
            }
        });

        // Añade botón cerrar
        btnCerrar = new JButton("Salir");
        this.add(btnCerrar);
        // Comportamiento del botón Cerrar
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }

}
