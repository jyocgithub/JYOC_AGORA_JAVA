package talkUDP;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Vista {
	JFrame ventana;
	Container container;
	JPanel panel1;
	JButton botonEnviar;
	JScrollPane scrollEnviar, scrollRecibir;
	JTextField textFieldHost;
	JTextArea textAreaEnviar, textAreaRecibir;
	JLabel labelHost, labelEnviar, labelRecibir;
	int puertoOrigen, puertoDestino;

	public Vista() {
		crear();
		colocar();
		pedirPuertos();
	}

	public void crear() {
		this.ventana = new JFrame("BIENVENIDO AL CHAT UDP");
		this.botonEnviar = new JButton("Enviar");
		this.panel1 = new JPanel();
		this.textFieldHost = new JTextField(12);
		this.textAreaEnviar = new JTextArea(8, 30);
		this.textAreaRecibir = new JTextArea(8, 30);
		this.scrollEnviar = new JScrollPane(this.textAreaEnviar);
		this.scrollRecibir = new JScrollPane(this.textAreaRecibir);
		this.labelHost = new JLabel("Host destino");
		this.labelEnviar = new JLabel("Texto a enviar");
		this.labelRecibir = new JLabel("Texto recibido");
		this.container = ventana.getContentPane();
	}

	public void colocar() {
		this.container.add(panel1);
		this.panel1.add(labelHost);
		this.panel1.add(textFieldHost);
		this.panel1.add(botonEnviar);
		this.panel1.add(labelEnviar);
		this.panel1.add(scrollEnviar);
		this.panel1.add(labelRecibir);
		this.panel1.add(scrollRecibir);
		this.ventana.setSize(400, 300);
		this.ventana.setVisible(true);
		this.ventana.setResizable(true);
	}
	
	public void pedirPuertos() {
		String puerto = JOptionPane.showInputDialog("Puerto de origen:");
		puertoOrigen = Integer.valueOf(puerto);
		
		String puerto2 = JOptionPane.showInputDialog("Puerto de destino:");
		puertoDestino = Integer.valueOf(puerto2);		
	}

	public void controlador(Controlador controlador) {
		botonEnviar.addActionListener(controlador);
	}
}