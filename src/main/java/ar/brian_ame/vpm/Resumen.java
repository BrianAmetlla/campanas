package ar.brian_ame.vpm;


import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
 
@SuppressWarnings("unused")
public class Resumen extends JFrame{
	/**
	 * 
	 */
	private ArrayList<Campañas> array_campañas = new ArrayList<Campañas>();
	private static final long serialVersionUID = 1L;
	private static int WIDTH = 750;
	private static  int HEIGHT = 510;

	private JLabel aTiempoTotalL, entre1y2L, masDe3L, totalCampañasL, demoraPromedioL;
	
	private JLabel llegadaArteL, pedidoPruebaColorL, okColorL, aprobacionOCL;
	private JLabel envioOCL, primerEntregaL, segundaEntregaL, inicioColocacionL, finiColocacionL;
	private JLabel entregaCierreL;

	private JLabel demorallegadaArteL, demorapedidoPruebaColorL, demoraokColorL, demoraaprobacionOCL;
	private JLabel demoraenvioOCL, demoraprimerEntregaL, demorasegundaEntregaL, demorainicioColocacionL, demorafiniColocacionL;
	private JLabel demoraentregaCierreL;

	private JTextField demorallegadaArteTF, demorapedidoPruebaColorTF, demoraokColorTF, demoraaprobacionOCTF;
	private JTextField demoraenvioOCTF, demoraprimerEntregaTF, demorasegundaEntregaTF, demorainicioColocacionTF, demorafiniColocacionTF;
	private JTextField demoraentregaCierreTF;

	
	private JTextField arteTotalTF, artePorcentualTF, arteEntre1y2TotalTF, arteEntre1y2PorcentualTF;
	private JTextField arteMasDe3TFTotal, arteMasDe3Porcentual, arteTotalCampañasTF ;

	private JTextField pruebaTotalTF, pruebaPorcentualTF, pruebaEntre1y2TotalTF, pruebaEntre1y2PorcentualTF;
	private JTextField pruebaMasDe3TFTotal, pruebaMasDe3Porcentual, pruebaTotalCampañasTF ;
	
	private JTextField okColorTotalTF, okColorPorcentualTF, okColorEntre1y2TotalTF, okColorEntre1y2PorcentualTF;
	private JTextField okColorMasDe3TFTotal, okColorMasDe3Porcentual, okColorTotalCampañasTF ;
	
	private JTextField aprobacionOCTotalTF, aprobacionOCPorcentualTF, aprobacionOCEntre1y2TotalTF, aprobacionOCEntre1y2PorcentualTF;
	private JTextField aprobacionOCMasDe3TFTotal, aprobacionOCMasDe3Porcentual, aprobacionOCTotalCampañasTF ;

	private JTextField envioOCTotalTF, envioOCPorcentualTF, envioOCEntre1y2TotalTF, envioOCEntre1y2PorcentualTF;
	private JTextField envioOCMasDe3TFTotal, envioOCMasDe3Porcentual, envioOCTotalCampañasTF ;

	private JTextField primerEntregaTotalTF, primerEntregaPorcentualTF, primerEntregaEntre1y2TotalTF, primerEntregaEntre1y2PorcentualTF;
	private JTextField primerEntregaMasDe3TFTotal, primerEntregaMasDe3Porcentual, primerEntregaTotalCampañasTF ;

	private JTextField segundaEntregaTotalTF, segundaEntregaPorcentualTF, segundaEntregaEntre1y2TotalTF, segundaEntregaEntre1y2PorcentualTF;
	private JTextField segundaEntregaMasDe3TFTotal, segundaEntregaMasDe3Porcentual, segundaEntregaTotalCampañasTF ;

	private JTextField inicioTotalTF, inicioPorcentualTF, inicioEntre1y2TotalTF, inicioEntre1y2PorcentualTF;
	private JTextField inicioMasDe3TFTotal, inicioMasDe3Porcentual, inicioTotalCampañasTF ;

	private JTextField finTotalTF, finPorcentualTF, finEntre1y2TotalTF, finEntre1y2PorcentualTF;
	private JTextField finMasDe3TFTotal, finMasDe3Porcentual, finTotalCampañasTF ;

	private JTextField cierreTotalTF, cierrePorcentualTF, cierreEntre1y2TotalTF, cierreEntre1y2PorcentualTF;
	private JTextField cierreMasDe3TFTotal, cierreMasDe3Porcentual, cierreTotalCampañasTF;

	
	
	private GridBagConstraints lastConstraints = null;
    private GridBagConstraints middleConstraints = null;
    private GridBagConstraints labelConstraints = null;
	private JComboBox<String> mesesB;
	private ElegirMesHanlder mesHandler;

	public Resumen() {
		aTiempoTotalL = new JLabel("a Tiempo ", SwingConstants.LEFT);
		entre1y2L = new JLabel("Entre 1 -2 días ", SwingConstants.LEFT);
		masDe3L = new JLabel("Más de 3 días ", SwingConstants.LEFT);
		totalCampañasL = new JLabel("Total Campañas ", SwingConstants.LEFT);
		demorallegadaArteL = new JLabel("Demora en llegada de arte ", SwingConstants.LEFT);
		demorapedidoPruebaColorL = new JLabel("Demora pedido de prueba color ", SwingConstants.LEFT);
		demoraokColorL = new JLabel("Demora en Ok Color ", SwingConstants.LEFT);
		demoraaprobacionOCL = new JLabel("Demora en Aprobacion OC ", SwingConstants.LEFT);
		demoraenvioOCL = new JLabel("Demora en envio OC ", SwingConstants.LEFT);
		demoraprimerEntregaL = new JLabel("Demora en 1er Entrega ", SwingConstants.LEFT);
		demorasegundaEntregaL = new JLabel("Demora en 2da Entrega ", SwingConstants.LEFT);
		demorainicioColocacionL = new JLabel("Demora en inicio de colocacion ", SwingConstants.LEFT);
		demorafiniColocacionL = new JLabel("Demora en fin de colocacion ", SwingConstants.LEFT);
		demoraentregaCierreL = new JLabel("Demora en entrega de cierre ", SwingConstants.LEFT);
		
		
		llegadaArteL = new JLabel("Llegada de arte ", SwingConstants.LEFT);
		pedidoPruebaColorL = new JLabel("Pedido de prueba color ", SwingConstants.LEFT);
		okColorL = new JLabel("Ok Color ", SwingConstants.LEFT);
		aprobacionOCL = new JLabel("Aprobacion OC ", SwingConstants.LEFT);
		envioOCL = new JLabel("Envio OC ", SwingConstants.LEFT);
		primerEntregaL = new JLabel("1er Entrega ", SwingConstants.LEFT);
		segundaEntregaL = new JLabel("2da Entrega ", SwingConstants.LEFT);
		inicioColocacionL = new JLabel("Inicio de colocacion ", SwingConstants.LEFT);
		finiColocacionL = new JLabel("Fin de colocacion ", SwingConstants.LEFT);
		entregaCierreL = new JLabel("Entrega de cierre ", SwingConstants.LEFT);
		demoraPromedioL = new JLabel("Demora Promedio", SwingConstants.LEFT);

		
		demorallegadaArteTF = new JTextField();
		demorapedidoPruebaColorTF = new JTextField();
		demoraokColorTF = new JTextField();
		demoraaprobacionOCTF = new JTextField();
		demoraenvioOCTF = new JTextField();
		demoraprimerEntregaTF = new JTextField();
		demorasegundaEntregaTF = new JTextField();
		demorainicioColocacionTF = new JTextField();
		demorafiniColocacionTF = new JTextField();
		demoraentregaCierreTF = new JTextField();
		
		arteTotalTF= new JTextField();
		artePorcentualTF= new JTextField();
		arteEntre1y2TotalTF= new JTextField();
		arteEntre1y2PorcentualTF= new JTextField();
		arteMasDe3TFTotal= new JTextField();
		arteMasDe3Porcentual= new JTextField();
		arteTotalCampañasTF = new JTextField();
		
		pruebaTotalTF= new JTextField();
		pruebaPorcentualTF= new JTextField();
		pruebaEntre1y2TotalTF= new JTextField();
		pruebaEntre1y2PorcentualTF= new JTextField();
		pruebaMasDe3TFTotal= new JTextField();
		pruebaMasDe3Porcentual= new JTextField();
		pruebaTotalCampañasTF = new JTextField();
			
		okColorTotalTF= new JTextField();
		okColorPorcentualTF= new JTextField();
		okColorEntre1y2TotalTF= new JTextField();
		okColorEntre1y2PorcentualTF= new JTextField();
		okColorMasDe3TFTotal= new JTextField();
		okColorMasDe3Porcentual= new JTextField();
		okColorTotalCampañasTF = new JTextField();
			
		aprobacionOCTotalTF= new JTextField();
		aprobacionOCPorcentualTF= new JTextField();
		aprobacionOCEntre1y2TotalTF= new JTextField();
		aprobacionOCEntre1y2PorcentualTF= new JTextField();
		aprobacionOCMasDe3TFTotal= new JTextField();
		aprobacionOCMasDe3Porcentual= new JTextField();
		aprobacionOCTotalCampañasTF = new JTextField();
		
		envioOCTotalTF= new JTextField();
		envioOCPorcentualTF= new JTextField();
		envioOCEntre1y2TotalTF= new JTextField();
		envioOCEntre1y2PorcentualTF= new JTextField();
		envioOCMasDe3TFTotal= new JTextField();
		envioOCMasDe3Porcentual= new JTextField();
		envioOCTotalCampañasTF = new JTextField();
		
		primerEntregaTotalTF= new JTextField();
		primerEntregaPorcentualTF= new JTextField();
		primerEntregaEntre1y2TotalTF= new JTextField();
		primerEntregaEntre1y2PorcentualTF= new JTextField();
		primerEntregaMasDe3TFTotal= new JTextField();
		primerEntregaMasDe3Porcentual= new JTextField();
		primerEntregaTotalCampañasTF = new JTextField();

		segundaEntregaTotalTF= new JTextField();
		segundaEntregaPorcentualTF= new JTextField();
		segundaEntregaEntre1y2TotalTF= new JTextField();
		segundaEntregaEntre1y2PorcentualTF= new JTextField();
		segundaEntregaMasDe3TFTotal= new JTextField();
		segundaEntregaMasDe3Porcentual= new JTextField();
		segundaEntregaTotalCampañasTF = new JTextField();

		inicioTotalTF= new JTextField();
		inicioPorcentualTF= new JTextField();
		inicioEntre1y2TotalTF= new JTextField();
		inicioEntre1y2PorcentualTF= new JTextField();
		inicioMasDe3TFTotal= new JTextField();
		inicioMasDe3Porcentual= new JTextField();
		inicioTotalCampañasTF = new JTextField();

		finTotalTF= new JTextField();
		finPorcentualTF= new JTextField();
		finEntre1y2TotalTF= new JTextField();
		finEntre1y2PorcentualTF= new JTextField();
		finMasDe3TFTotal= new JTextField();
		finMasDe3Porcentual= new JTextField();
		finTotalCampañasTF = new JTextField();

		cierreTotalTF= new JTextField();
		cierrePorcentualTF= new JTextField();
		cierreEntre1y2TotalTF= new JTextField();
		cierreEntre1y2PorcentualTF= new JTextField();
		cierreMasDe3TFTotal= new JTextField(); 
		cierreMasDe3Porcentual= new JTextField();
		cierreTotalCampañasTF= new JTextField();
		
		
		mesesB = new JComboBox<String>();
		mesHandler = new ElegirMesHanlder();
		mesesB.addActionListener(mesHandler);
 
		
		setTitle("Resumen de Retrasos");
		Container pane = getContentPane();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(1,1,1,1);

		
		
		//agrego todos los labels de los inputs
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(mesesB, c);
		
		c.gridx = 0;
		c.gridy = 3;
		pane.add(demorallegadaArteL, c);

		c.gridx = 0;
		c.gridy = 4;
		pane.add(demorapedidoPruebaColorL, c);

		c.gridx = 0;
		c.gridy = 5;
		pane.add(demoraokColorL, c);
		
		c.gridx = 0;
		c.gridy = 6;
		pane.add(demoraaprobacionOCL, c);

		
		c.gridx = 0;
		c.gridy = 7;
		pane.add(demoraenvioOCL, c);
		
		c.gridx = 0;
		c.gridy = 8;
		pane.add(demoraprimerEntregaL, c);
		
		c.gridx = 0;
		c.gridy = 9;
		pane.add(demorasegundaEntregaL, c);

		c.gridx = 0;
		c.gridy = 10;
		pane.add(demorainicioColocacionL, c);


		c.gridx = 0;
		c.gridy = 11;
		pane.add(demorafiniColocacionL, c);

		c.gridx = 0;
		c.gridy = 12;
		pane.add(demoraentregaCierreL, c);

		c.gridx = 0;
		c.gridy = 0;
		pane.add(mesesB, c);
		
		
		
		c.gridx = 1;
		c.gridy = 16;
		pane.add(demoraPromedioL, c);

		c.gridx = 0;
		c.gridy = 17;
		pane.add(llegadaArteL, c);

		c.gridx = 0;
		c.gridy = 18;
		pane.add(pedidoPruebaColorL, c);

		c.gridx = 0;
		c.gridy = 19;
		pane.add(okColorL, c);
		
		
		c.gridx = 0;
		c.gridy = 20;
		pane.add(aprobacionOCL, c);

		
		c.gridx = 0;
		c.gridy = 21;
		pane.add(envioOCL, c);
		
		c.gridx = 0;
		c.gridy = 22;
		pane.add(primerEntregaL, c);
		
		c.gridx = 0;
		c.gridy = 23;
		pane.add(segundaEntregaL, c);

		c.gridx = 0;
		c.gridy = 24;
		pane.add(inicioColocacionL, c);


		c.gridx = 0;
		c.gridy = 25;
		pane.add(finiColocacionL, c);

		c.gridx = 0;
		c.gridy = 26;
		pane.add(entregaCierreL, c);		

		
		c.gridx = 1;
		c.gridy = 17;
		pane.add(demorallegadaArteTF, c);

		c.gridx = 1;
		c.gridy = 18;
		pane.add(demorapedidoPruebaColorTF, c);

		c.gridx = 1;
		c.gridy = 19;
		pane.add(demoraokColorTF, c);
		
		
		c.gridx = 1;
		c.gridy = 20;
		pane.add(demoraaprobacionOCTF, c);

		
		c.gridx = 1;
		c.gridy = 21;
		pane.add(demoraenvioOCTF, c);
		
		c.gridx = 1;
		c.gridy = 22;
		pane.add(demoraprimerEntregaTF, c);
		
		c.gridx = 1;
		c.gridy = 23;
		pane.add(demorasegundaEntregaTF, c);

		c.gridx = 1;
		c.gridy = 24;
		pane.add(demorainicioColocacionTF, c);


		c.gridx = 1;
		c.gridy = 25;
		pane.add(demorafiniColocacionTF, c);

		c.gridx = 1;
		c.gridy = 26;
		pane.add(demoraentregaCierreTF, c);

		

		c.gridx = 1;
		c.gridy = 2;
		pane.add(aTiempoTotalL, c);
		

		c.gridx = 3;
		c.gridy = 2;
		pane.add(entre1y2L, c);
		

		c.gridx = 5;
		c.gridy = 2;
		pane.add(masDe3L, c);
		

		c.gridx = 7;
		c.gridy = 2;
		pane.add(totalCampañasL, c);


		c.gridx = 1;
		c.gridy = 3;
		pane.add(arteTotalTF, c);
		c.gridx = 2;
		c.gridy = 3;
		pane.add(artePorcentualTF,c);
		c.gridx = 3;
		c.gridy = 3;
		pane.add(arteEntre1y2TotalTF,c);
		c.gridx = 4;
		c.gridy = 3;
		pane.add(arteEntre1y2PorcentualTF,c);
		c.gridx = 5;
		c.gridy = 3;
		pane.add(arteMasDe3TFTotal,c);
		c.gridx = 6;
		c.gridy = 3;
		pane.add(arteMasDe3Porcentual,c);
		c.gridx = 7;
		c.gridy = 3;
		pane.add(arteTotalCampañasTF,c);
		
		
		c.gridx = 1;
		c.gridy = 4;
		pane.add(pruebaTotalTF, c);
		c.gridx = 2;
		c.gridy = 4;
		pane.add(pruebaPorcentualTF,c);
		c.gridx = 3;
		c.gridy = 4;
		pane.add(pruebaEntre1y2TotalTF,c);
		c.gridx = 4;
		c.gridy = 4;
		pane.add(pruebaEntre1y2PorcentualTF,c);
		c.gridx = 5;
		c.gridy = 4;
		pane.add(pruebaMasDe3TFTotal,c);
		c.gridx = 6;
		c.gridy = 4;
		pane.add(pruebaMasDe3Porcentual,c);
		c.gridx = 7;
		c.gridy = 4;
		pane.add(pruebaTotalCampañasTF,c);
		
		
		c.gridx = 1;
		c.gridy = 5;
		pane.add(okColorTotalTF, c);
		c.gridx = 2;
		c.gridy = 5;
		pane.add(okColorPorcentualTF,c);
		c.gridx = 3;
		c.gridy = 5;
		pane.add(okColorEntre1y2TotalTF,c);
		c.gridx = 4;
		c.gridy = 5;
		pane.add(okColorEntre1y2PorcentualTF,c);
		c.gridx = 5;
		c.gridy = 5;
		pane.add(okColorMasDe3TFTotal,c);
		c.gridx = 6;
		c.gridy = 5;
		pane.add(okColorMasDe3Porcentual,c);
		c.gridx = 7;
		c.gridy = 5;
		pane.add(okColorTotalCampañasTF,c);
		
		
		c.gridx = 1;
		c.gridy = 6;
		pane.add(aprobacionOCTotalTF, c);
		c.gridx = 2;
		c.gridy = 6;
		pane.add(aprobacionOCPorcentualTF,c);
		c.gridx = 3;
		c.gridy = 6;
		pane.add(aprobacionOCEntre1y2TotalTF,c);
		c.gridx = 4;
		c.gridy = 6;
		pane.add(aprobacionOCEntre1y2PorcentualTF,c);
		c.gridx = 5;
		c.gridy = 6;
		pane.add(aprobacionOCMasDe3TFTotal,c);
		c.gridx = 6;
		c.gridy = 6;
		pane.add(aprobacionOCMasDe3Porcentual,c);
		c.gridx = 7;
		c.gridy = 6;
		pane.add(aprobacionOCTotalCampañasTF,c);
		
		
		
		c.gridx = 1;
		c.gridy = 7;
		pane.add(envioOCTotalTF, c);
		c.gridx = 2;
		c.gridy = 7;
		pane.add(envioOCPorcentualTF,c);
		c.gridx = 3;
		c.gridy = 7;
		pane.add(envioOCEntre1y2TotalTF,c);
		c.gridx = 4;
		c.gridy = 7;
		pane.add(envioOCEntre1y2PorcentualTF,c);
		c.gridx = 5;
		c.gridy = 7;
		pane.add(envioOCMasDe3TFTotal,c);
		c.gridx = 6;
		c.gridy = 7;
		pane.add(envioOCMasDe3Porcentual,c);
		c.gridx = 7;
		c.gridy = 7;
		pane.add(envioOCTotalCampañasTF,c);
		
		
		c.gridx = 1;
		c.gridy = 8;
		pane.add(primerEntregaTotalTF, c);
		c.gridx = 2;
		c.gridy = 8;
		pane.add(primerEntregaPorcentualTF,c);
		c.gridx = 3;
		c.gridy = 8;
		pane.add(primerEntregaEntre1y2TotalTF,c);
		c.gridx = 4;
		c.gridy = 8;
		pane.add(primerEntregaEntre1y2PorcentualTF,c);
		c.gridx = 5;
		c.gridy = 8;
		pane.add(primerEntregaMasDe3TFTotal,c);
		c.gridx = 6;
		c.gridy = 8;
		pane.add(primerEntregaMasDe3Porcentual,c);
		c.gridx = 7;
		c.gridy = 8;
		pane.add(primerEntregaTotalCampañasTF,c);
		
		
		c.gridx = 1;
		c.gridy = 9;
		pane.add(segundaEntregaTotalTF, c);
		c.gridx = 2;
		c.gridy = 9;
		pane.add(segundaEntregaPorcentualTF,c);
		c.gridx = 3;
		c.gridy = 9;
		pane.add(segundaEntregaEntre1y2TotalTF,c);
		c.gridx = 4;
		c.gridy = 9;
		pane.add(segundaEntregaEntre1y2PorcentualTF,c);
		c.gridx = 5;
		c.gridy = 9;
		pane.add(segundaEntregaMasDe3TFTotal,c);
		c.gridx = 6;
		c.gridy = 9;
		pane.add(segundaEntregaMasDe3Porcentual,c);
		c.gridx = 7;
		c.gridy = 9;
		pane.add(segundaEntregaTotalCampañasTF,c);
		
		
		
		c.gridx = 1;
		c.gridy = 10;
		pane.add(inicioTotalTF, c);
		c.gridx = 2;
		c.gridy = 10;
		pane.add(inicioPorcentualTF,c);
		c.gridx = 3;
		c.gridy = 10;
		pane.add(inicioEntre1y2TotalTF,c);
		c.gridx = 4;
		c.gridy = 10;
		pane.add(inicioEntre1y2PorcentualTF,c);
		c.gridx = 5;
		c.gridy = 10;
		pane.add(inicioMasDe3TFTotal,c);
		c.gridx = 6;
		c.gridy = 10;
		pane.add(inicioMasDe3Porcentual,c);
		c.gridx = 7;
		c.gridy = 10;
		pane.add(inicioTotalCampañasTF,c);
		
		
		c.gridx = 1;
		c.gridy = 11;
		pane.add(finTotalTF, c);
		c.gridx = 2;
		c.gridy = 11;
		pane.add(finPorcentualTF,c);
		c.gridx = 3;
		c.gridy = 11;
		pane.add(finEntre1y2TotalTF,c);
		c.gridx = 4;
		c.gridy = 11;
		pane.add(finEntre1y2PorcentualTF,c);
		c.gridx = 5;
		c.gridy = 11;
		pane.add(finMasDe3TFTotal,c);
		c.gridx = 6;
		c.gridy = 11;
		pane.add(finMasDe3Porcentual,c);
		c.gridx = 7;
		c.gridy = 11;
		pane.add(finTotalCampañasTF,c);
		
		
		c.gridx = 1;
		c.gridy = 12;
		pane.add(cierreTotalTF, c);
		c.gridx = 2;
		c.gridy = 12;
		pane.add(cierrePorcentualTF,c);
		c.gridx = 3;
		c.gridy = 12;
		pane.add(cierreEntre1y2TotalTF,c);
		c.gridx = 4;
		c.gridy = 12;
		pane.add(cierreEntre1y2PorcentualTF,c);
		c.gridx = 5;
		c.gridy = 12;
		pane.add(cierreMasDe3TFTotal,c);
		c.gridx = 6;
		c.gridy = 12;
		pane.add(cierreMasDe3Porcentual,c);
		c.gridx = 7;
		c.gridy = 12;
		pane.add(cierreTotalCampañasTF,c);

		arteTotalTF.setEditable(false);
		artePorcentualTF.setEditable(false);
		arteEntre1y2TotalTF.setEditable(false);
		arteEntre1y2PorcentualTF.setEditable(false);
		arteMasDe3TFTotal.setEditable(false);
		arteMasDe3Porcentual.setEditable(false);
		arteTotalCampañasTF.setEditable(false);
		
		pruebaTotalTF.setEditable(false);
		pruebaPorcentualTF.setEditable(false);
		pruebaEntre1y2TotalTF.setEditable(false);
		pruebaEntre1y2PorcentualTF.setEditable(false);
		pruebaMasDe3TFTotal.setEditable(false);
		pruebaMasDe3Porcentual.setEditable(false);
		pruebaTotalCampañasTF.setEditable(false);
			
		okColorTotalTF.setEditable(false);
		okColorPorcentualTF.setEditable(false);
		okColorEntre1y2TotalTF.setEditable(false);
		okColorEntre1y2PorcentualTF.setEditable(false);
		okColorMasDe3TFTotal.setEditable(false);
		okColorMasDe3Porcentual.setEditable(false);
		okColorTotalCampañasTF.setEditable(false);
			
		aprobacionOCTotalTF.setEditable(false);
		aprobacionOCPorcentualTF.setEditable(false);
		aprobacionOCEntre1y2TotalTF.setEditable(false);
		aprobacionOCEntre1y2PorcentualTF.setEditable(false);
		aprobacionOCMasDe3TFTotal.setEditable(false);
		aprobacionOCMasDe3Porcentual.setEditable(false);
		aprobacionOCTotalCampañasTF.setEditable(false);
		
		envioOCTotalTF.setEditable(false);
		envioOCPorcentualTF.setEditable(false);
		envioOCEntre1y2TotalTF.setEditable(false);
		envioOCEntre1y2PorcentualTF.setEditable(false);
		envioOCMasDe3TFTotal.setEditable(false);
		envioOCMasDe3Porcentual.setEditable(false);
		envioOCTotalCampañasTF.setEditable(false);
		
		primerEntregaTotalTF.setEditable(false);
		primerEntregaPorcentualTF.setEditable(false);
		primerEntregaEntre1y2TotalTF.setEditable(false);
		primerEntregaEntre1y2PorcentualTF.setEditable(false);
		primerEntregaMasDe3TFTotal.setEditable(false);
		primerEntregaMasDe3Porcentual.setEditable(false);
		primerEntregaTotalCampañasTF.setEditable(false);

		segundaEntregaTotalTF.setEditable(false);
		segundaEntregaPorcentualTF.setEditable(false);
		segundaEntregaEntre1y2TotalTF.setEditable(false);
		segundaEntregaEntre1y2PorcentualTF.setEditable(false);
		segundaEntregaMasDe3TFTotal.setEditable(false);
		segundaEntregaMasDe3Porcentual.setEditable(false);
		segundaEntregaTotalCampañasTF.setEditable(false);

		inicioTotalTF.setEditable(false);
		inicioPorcentualTF.setEditable(false);
		inicioEntre1y2TotalTF.setEditable(false);
		inicioEntre1y2PorcentualTF.setEditable(false);
		inicioMasDe3TFTotal.setEditable(false);
		inicioMasDe3Porcentual.setEditable(false);
		inicioTotalCampañasTF.setEditable(false);

		finTotalTF.setEditable(false);
		finPorcentualTF.setEditable(false);
		finEntre1y2TotalTF.setEditable(false);
		finEntre1y2PorcentualTF.setEditable(false);
		finMasDe3TFTotal.setEditable(false);
		finMasDe3Porcentual.setEditable(false);
		finTotalCampañasTF.setEditable(false);

		cierreTotalTF.setEditable(false);
		cierrePorcentualTF.setEditable(false);
		cierreEntre1y2TotalTF.setEditable(false);
		cierreEntre1y2PorcentualTF.setEditable(false);
		cierreMasDe3TFTotal.setEditable(false); 
		cierreMasDe3Porcentual.setEditable(false);
		cierreTotalCampañasTF.setEditable(false);

		demorallegadaArteTF.setEditable(false);
		demorapedidoPruebaColorTF.setEditable(false);
		demoraokColorTF.setEditable(false);
		demoraaprobacionOCTF.setEditable(false);
		demoraenvioOCTF.setEditable(false);
		demoraprimerEntregaTF.setEditable(false);
		demorasegundaEntregaTF.setEditable(false);
		demorainicioColocacionTF.setEditable(false);
		demorafiniColocacionTF.setEditable(false);
		demoraentregaCierreTF.setEditable(false);
		
		mesesB.addItem("Enero");
		mesesB.addItem("Febrero");
		mesesB.addItem("Marzo");
		mesesB.addItem("Abril");
		mesesB.addItem("Mayo");
		mesesB.addItem("Junio");
		mesesB.addItem("Julio");
		mesesB.addItem("Agosto");
		mesesB.addItem("Septiembre");
		mesesB.addItem("Octubre");
		mesesB.addItem("Noviembre");
		mesesB.addItem("Diciembre");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

	}
	
	public class ElegirMesHanlder implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
				ArrayList<Campañas> deEsteMes = new ArrayList<Campañas>();
				int dem_arte, dem_prueba, dem_ok, dem_aprobacion = 0;
				int dem_envio, dem_primera, dem_segunda, dem_inicio, dem_fin, dem_cierre = 0;
				
				int dem_arte1y2, dem_prueba1y2, dem_ok1y2, dem_aprobacion1y2 = 0;
				int dem_envio1y2, dem_primera1y2, dem_segunda1y2, dem_inicio1y2, dem_fin1y2, dem_cierre1y2 = 0;

				int dem_arte3, dem_prueba3, dem_ok3, dem_aprobacion3 = 0;
				int dem_envio3, dem_primera3, dem_segunda3, dem_inicio3, dem_fin3, dem_cierre3 = 0;

				
				for(Campañas c:array_campañas)
				{
					if(c.getLlegada_arte().getMonth() == mesesB.getSelectedIndex())
					{
						deEsteMes.add(c);
						System.out.println(c.getNombre_campaña());
						//preguntarle a jalio si este resumen es solo sobre aquellas campañas que 
						//ya cerraron o si incluye a aquellas que todavia no
					}
					
				}
		}
	}
	
	public static void main(ArrayList<Campañas> array)
	{
		Resumen resumen = new Resumen();
		resumen.array_campañas = array;
		for (Campañas campañas : array) {
			System.out.println(campañas.getNombre_campaña());	
		}
	} 	

}

