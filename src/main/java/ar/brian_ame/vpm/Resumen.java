package ar.brian_ame.vpm;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.text.DecimalFormat;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class Resumen extends JFrame {
	/**
	 * 
	 */
	private ArrayList<Campañas> array_campañas = new ArrayList<Campañas>();
	private static final long serialVersionUID = 1L;
	private static int WIDTH = 790;
	private static int HEIGHT = 510;
	private Container pane;
	private JLabel aTiempoTotalL, entre1y2L, masDe3L, totalCampañasL,
			demoraPromedioL;

	private JLabel llegadaArteL, pedidoPruebaColorL, okColorL, aprobacionOCL;
	private JLabel envioOCL, primerEntregaL, segundaEntregaL,
			inicioColocacionL, finiColocacionL;
	private JLabel entregaCierreL;

	private JLabel demorallegadaArteL, demorapedidoPruebaColorL,
			demoraokColorL, demoraaprobacionOCL;
	private JLabel demoraenvioOCL, demoraprimerEntregaL, demorasegundaEntregaL,
			demorainicioColocacionL, demorafiniColocacionL;
	private JLabel demoraentregaCierreL;

	private JTextField demorallegadaArteTF, demorapedidoPruebaColorTF,
			demoraokColorTF, demoraaprobacionOCTF;
	private JTextField demoraenvioOCTF, demoraprimerEntregaTF,
			demorasegundaEntregaTF, demorainicioColocacionTF,
			demorafiniColocacionTF;
	private JTextField demoraentregaCierreTF;

	private JTextField arteTotalTF, artePorcentualTF, arteEntre1y2TotalTF,
			arteEntre1y2PorcentualTF;
	private JTextField arteMasDe3TFTotal, arteMasDe3Porcentual,
			arteTotalCampañasTF;

	private JTextField pruebaTotalTF, pruebaPorcentualTF,
			pruebaEntre1y2TotalTF, pruebaEntre1y2PorcentualTF;
	private JTextField pruebaMasDe3TFTotal, pruebaMasDe3Porcentual,
			pruebaTotalCampañasTF;

	private JTextField okColorTotalTF, okColorPorcentualTF,
			okColorEntre1y2TotalTF, okColorEntre1y2PorcentualTF;
	private JTextField okColorMasDe3TFTotal, okColorMasDe3Porcentual,
			okColorTotalCampañasTF;

	private JTextField aprobacionOCTotalTF, aprobacionOCPorcentualTF,
			aprobacionOCEntre1y2TotalTF, aprobacionOCEntre1y2PorcentualTF;
	private JTextField aprobacionOCMasDe3TFTotal, aprobacionOCMasDe3Porcentual,
			aprobacionOCTotalCampañasTF;

	private JTextField envioOCTotalTF, envioOCPorcentualTF,
			envioOCEntre1y2TotalTF, envioOCEntre1y2PorcentualTF;
	private JTextField envioOCMasDe3TFTotal, envioOCMasDe3Porcentual,
			envioOCTotalCampañasTF;

	private JTextField primerEntregaTotalTF, primerEntregaPorcentualTF,
			primerEntregaEntre1y2TotalTF, primerEntregaEntre1y2PorcentualTF;
	private JTextField primerEntregaMasDe3TFTotal,
			primerEntregaMasDe3Porcentual, primerEntregaTotalCampañasTF;

	private JTextField segundaEntregaTotalTF, segundaEntregaPorcentualTF,
			segundaEntregaEntre1y2TotalTF, segundaEntregaEntre1y2PorcentualTF;
	private JTextField segundaEntregaMasDe3TFTotal,
			segundaEntregaMasDe3Porcentual, segundaEntregaTotalCampañasTF;

	private JTextField inicioTotalTF, inicioPorcentualTF,
			inicioEntre1y2TotalTF, inicioEntre1y2PorcentualTF;
	private JTextField inicioMasDe3TFTotal, inicioMasDe3Porcentual,
			inicioTotalCampañasTF;

	private JTextField finTotalTF, finPorcentualTF, finEntre1y2TotalTF,
			finEntre1y2PorcentualTF;
	private JTextField finMasDe3TFTotal, finMasDe3Porcentual,
			finTotalCampañasTF;

	private JTextField cierreTotalTF, cierrePorcentualTF,
			cierreEntre1y2TotalTF, cierreEntre1y2PorcentualTF;
	private JTextField cierreMasDe3TFTotal, cierreMasDe3Porcentual,
			cierreTotalCampañasTF;

	int dem_arte, dem_prueba, dem_ok, dem_aprobacion = 0;
	int campas_total = 1;
	int dem_envio, dem_primera, dem_segunda, dem_inicio, dem_fin,
			dem_cierre = 0;
	int aTiempo_arte, aTiempo_prueba, aTiempo_ok, aTiempo_aprobacion = 0;
	int aTiempo_envio, aTiempo_primera, aTiempo_segunda, aTiempo_inicio,
			aTiempo_fin, aTiempo_cierre = 0;

	int dem_arte1y2, dem_prueba1y2, dem_ok1y2, dem_aprobacion1y2 = 0;
	int dem_envio1y2, dem_primera1y2, dem_segunda1y2, dem_inicio1y2,
			dem_fin1y2, dem_cierre1y2 = 0;

	int dem_arte3, dem_prueba3, dem_ok3, dem_aprobacion3 = 0;
	int dem_envio3, dem_primera3, dem_segunda3, dem_inicio3, dem_fin3,
			dem_cierre3 = 0;

	private GridBagConstraints lastConstraints = null;
	private GridBagConstraints middleConstraints = null;
	private GridBagConstraints labelConstraints = null;
	private JComboBox<String> mesesB;
	private ElegirMesHanlder mesHandler;
	DecimalFormat df = new DecimalFormat("#.##");

	public Resumen() {
		aTiempoTotalL = new JLabel("a Tiempo ", SwingConstants.LEFT);
		entre1y2L = new JLabel("Entre 1 -2 días ", SwingConstants.LEFT);
		masDe3L = new JLabel("Más de 3 días ", SwingConstants.LEFT);
		totalCampañasL = new JLabel("Total Campañas ", SwingConstants.LEFT);
		demorallegadaArteL = new JLabel("Demora en llegada de arte ",
				SwingConstants.LEFT);
		demorapedidoPruebaColorL = new JLabel("Demora pedido de prueba color ",
				SwingConstants.LEFT);
		demoraokColorL = new JLabel("Demora en Ok Color ", SwingConstants.LEFT);
		demoraaprobacionOCL = new JLabel("Demora en Aprobacion OC ",
				SwingConstants.LEFT);
		demoraenvioOCL = new JLabel("Demora en envio OC ", SwingConstants.LEFT);
		demoraprimerEntregaL = new JLabel("Demora en 1er Entrega ",
				SwingConstants.LEFT);
		demorasegundaEntregaL = new JLabel("Demora en 2da Entrega ",
				SwingConstants.LEFT);
		demorainicioColocacionL = new JLabel("Demora en inicio de colocacion ",
				SwingConstants.LEFT);
		demorafiniColocacionL = new JLabel("Demora en fin de colocacion ",
				SwingConstants.LEFT);
		demoraentregaCierreL = new JLabel("Demora en entrega de cierre ",
				SwingConstants.LEFT);

		llegadaArteL = new JLabel("Llegada de arte ", SwingConstants.LEFT);
		pedidoPruebaColorL = new JLabel("Pedido de prueba color ",
				SwingConstants.LEFT);
		okColorL = new JLabel("Ok Color ", SwingConstants.LEFT);
		aprobacionOCL = new JLabel("Aprobacion OC ", SwingConstants.LEFT);
		envioOCL = new JLabel("Envio OC ", SwingConstants.LEFT);
		primerEntregaL = new JLabel("1er Entrega ", SwingConstants.LEFT);
		segundaEntregaL = new JLabel("2da Entrega ", SwingConstants.LEFT);
		inicioColocacionL = new JLabel("Inicio de colocacion ",
				SwingConstants.LEFT);
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

		arteTotalTF = new JTextField(4);
		artePorcentualTF = new JTextField(4);
		arteEntre1y2TotalTF = new JTextField(4);
		arteEntre1y2PorcentualTF = new JTextField(4);
		arteMasDe3TFTotal = new JTextField(4);
		arteMasDe3Porcentual = new JTextField(4);
		arteTotalCampañasTF = new JTextField(4);

		pruebaTotalTF = new JTextField(4);
		pruebaPorcentualTF = new JTextField(4);
		pruebaEntre1y2TotalTF = new JTextField(4);
		pruebaEntre1y2PorcentualTF = new JTextField(4);
		pruebaMasDe3TFTotal = new JTextField(4);
		pruebaMasDe3Porcentual = new JTextField(4);
		pruebaTotalCampañasTF = new JTextField(4);

		okColorTotalTF = new JTextField(4);
		okColorPorcentualTF = new JTextField(4);
		okColorEntre1y2TotalTF = new JTextField(4);
		okColorEntre1y2PorcentualTF = new JTextField(4);
		okColorMasDe3TFTotal = new JTextField(4);
		okColorMasDe3Porcentual = new JTextField(4);
		okColorTotalCampañasTF = new JTextField(4);

		aprobacionOCTotalTF = new JTextField(4);
		aprobacionOCPorcentualTF = new JTextField(4);
		aprobacionOCEntre1y2TotalTF = new JTextField(4);
		aprobacionOCEntre1y2PorcentualTF = new JTextField(4);
		aprobacionOCMasDe3TFTotal = new JTextField(4);
		aprobacionOCMasDe3Porcentual = new JTextField(4);
		aprobacionOCTotalCampañasTF = new JTextField(4);

		envioOCTotalTF = new JTextField(4);
		envioOCPorcentualTF = new JTextField(4);
		envioOCEntre1y2TotalTF = new JTextField(4);
		envioOCEntre1y2PorcentualTF = new JTextField(4);
		envioOCMasDe3TFTotal = new JTextField(4);
		envioOCMasDe3Porcentual = new JTextField(4);
		envioOCTotalCampañasTF = new JTextField(4);

		primerEntregaTotalTF = new JTextField(4);
		primerEntregaPorcentualTF = new JTextField(4);
		primerEntregaEntre1y2TotalTF = new JTextField(4);
		primerEntregaEntre1y2PorcentualTF = new JTextField(4);
		primerEntregaMasDe3TFTotal = new JTextField(4);
		primerEntregaMasDe3Porcentual = new JTextField(4);
		primerEntregaTotalCampañasTF = new JTextField(4);

		segundaEntregaTotalTF = new JTextField(4);
		segundaEntregaPorcentualTF = new JTextField(4);
		segundaEntregaEntre1y2TotalTF = new JTextField(4);
		segundaEntregaEntre1y2PorcentualTF = new JTextField(4);
		segundaEntregaMasDe3TFTotal = new JTextField(4);
		segundaEntregaMasDe3Porcentual = new JTextField(4);
		segundaEntregaTotalCampañasTF = new JTextField(4);

		inicioTotalTF = new JTextField(4);
		inicioPorcentualTF = new JTextField(4);
		inicioEntre1y2TotalTF = new JTextField(4);
		inicioEntre1y2PorcentualTF = new JTextField(4);
		inicioMasDe3TFTotal = new JTextField(4);
		inicioMasDe3Porcentual = new JTextField(4);
		inicioTotalCampañasTF = new JTextField(4);

		finTotalTF = new JTextField(4);
		finPorcentualTF = new JTextField(4);
		finEntre1y2TotalTF = new JTextField(4);
		finEntre1y2PorcentualTF = new JTextField(4);
		finMasDe3TFTotal = new JTextField(4);
		finMasDe3Porcentual = new JTextField(4);
		finTotalCampañasTF = new JTextField(4);

		cierreTotalTF = new JTextField(4);
		cierrePorcentualTF = new JTextField(4);
		cierreEntre1y2TotalTF = new JTextField(4);
		cierreEntre1y2PorcentualTF = new JTextField(4);
		cierreMasDe3TFTotal = new JTextField(4);
		cierreMasDe3Porcentual = new JTextField(4);
		cierreTotalCampañasTF = new JTextField(4);

		mesesB = new JComboBox<String>();
		mesHandler = new ElegirMesHanlder();
		mesesB.addActionListener(mesHandler);

		setTitle("Resumen de Retrasos");
		pane = getContentPane();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(1, 1, 1, 1);

		// agrego todos los labels de los inputs
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

		c.gridx = 5;
		c.gridy = 2;
		pane.add(aTiempoTotalL, c);

		c.gridx = 3;
		c.gridy = 2;
		pane.add(entre1y2L, c);

		c.gridx = 1;
		c.gridy = 2;
		pane.add(masDe3L, c);

		c.gridx = 7;
		c.gridy = 2;
		pane.add(totalCampañasL, c);

		c.gridx = 5;
		c.gridy = 3;
		pane.add(arteTotalTF, c);
		c.gridx = 6;
		c.gridy = 3;
		pane.add(artePorcentualTF, c);
		c.gridx = 3;
		c.gridy = 3;
		pane.add(arteEntre1y2TotalTF, c);
		c.gridx = 4;
		c.gridy = 3;
		pane.add(arteEntre1y2PorcentualTF, c);
		c.gridx = 1;
		c.gridy = 3;
		pane.add(arteMasDe3TFTotal, c);
		c.gridx = 2;
		c.gridy = 3;
		pane.add(arteMasDe3Porcentual, c);
		c.gridx = 7;
		c.gridy = 3;
		pane.add(arteTotalCampañasTF, c);

		c.gridx = 5;
		c.gridy = 4;
		pane.add(pruebaTotalTF, c);
		c.gridx = 6;
		c.gridy = 4;
		pane.add(pruebaPorcentualTF, c);
		c.gridx = 3;
		c.gridy = 4;
		pane.add(pruebaEntre1y2TotalTF, c);
		c.gridx = 4;
		c.gridy = 4;
		pane.add(pruebaEntre1y2PorcentualTF, c);
		c.gridx = 1;
		c.gridy = 4;
		pane.add(pruebaMasDe3TFTotal, c);
		c.gridx = 2;
		c.gridy = 4;
		pane.add(pruebaMasDe3Porcentual, c);
		c.gridx = 7;
		c.gridy = 4;
		pane.add(pruebaTotalCampañasTF, c);

		c.gridx = 5;
		c.gridy = 5;
		pane.add(okColorTotalTF, c);
		c.gridx = 6;
		c.gridy = 5;
		pane.add(okColorPorcentualTF, c);
		c.gridx = 3;
		c.gridy = 5;
		pane.add(okColorEntre1y2TotalTF, c);
		c.gridx = 4;
		c.gridy = 5;
		pane.add(okColorEntre1y2PorcentualTF, c);
		c.gridx = 1;
		c.gridy = 5;
		pane.add(okColorMasDe3TFTotal, c);
		c.gridx = 2;
		c.gridy = 5;
		pane.add(okColorMasDe3Porcentual, c);
		c.gridx = 7;
		c.gridy = 5;
		pane.add(okColorTotalCampañasTF, c);

		c.gridx = 5;
		c.gridy = 6;
		pane.add(aprobacionOCTotalTF, c);
		c.gridx = 6;
		c.gridy = 6;
		pane.add(aprobacionOCPorcentualTF, c);
		c.gridx = 3;
		c.gridy = 6;
		pane.add(aprobacionOCEntre1y2TotalTF, c);
		c.gridx = 4;
		c.gridy = 6;
		pane.add(aprobacionOCEntre1y2PorcentualTF, c);
		c.gridx = 1;
		c.gridy = 6;
		pane.add(aprobacionOCMasDe3TFTotal, c);
		c.gridx = 2;
		c.gridy = 6;
		pane.add(aprobacionOCMasDe3Porcentual, c);
		c.gridx = 7;
		c.gridy = 6;
		pane.add(aprobacionOCTotalCampañasTF, c);

		c.gridx = 5;
		c.gridy = 7;
		pane.add(envioOCTotalTF, c);
		c.gridx = 6;
		c.gridy = 7;
		pane.add(envioOCPorcentualTF, c);
		c.gridx = 3;
		c.gridy = 7;
		pane.add(envioOCEntre1y2TotalTF, c);
		c.gridx = 4;
		c.gridy = 7;
		pane.add(envioOCEntre1y2PorcentualTF, c);
		c.gridx = 1;
		c.gridy = 7;
		pane.add(envioOCMasDe3TFTotal, c);
		c.gridx = 2;
		c.gridy = 7;
		pane.add(envioOCMasDe3Porcentual, c);
		c.gridx = 7;
		c.gridy = 7;
		pane.add(envioOCTotalCampañasTF, c);

		c.gridx = 5;
		c.gridy = 8;
		pane.add(primerEntregaTotalTF, c);
		c.gridx = 6;
		c.gridy = 8;
		pane.add(primerEntregaPorcentualTF, c);
		c.gridx = 3;
		c.gridy = 8;
		pane.add(primerEntregaEntre1y2TotalTF, c);
		c.gridx = 4;
		c.gridy = 8;
		pane.add(primerEntregaEntre1y2PorcentualTF, c);
		c.gridx = 1;
		c.gridy = 8;
		pane.add(primerEntregaMasDe3TFTotal, c);
		c.gridx = 2;
		c.gridy = 8;
		pane.add(primerEntregaMasDe3Porcentual, c);
		c.gridx = 7;
		c.gridy = 8;
		pane.add(primerEntregaTotalCampañasTF, c);

		c.gridx = 5;
		c.gridy = 9;
		pane.add(segundaEntregaTotalTF, c);
		c.gridx = 6;
		c.gridy = 9;
		pane.add(segundaEntregaPorcentualTF, c);
		c.gridx = 3;
		c.gridy = 9;
		pane.add(segundaEntregaEntre1y2TotalTF, c);
		c.gridx = 4;
		c.gridy = 9;
		pane.add(segundaEntregaEntre1y2PorcentualTF, c);
		c.gridx = 1;
		c.gridy = 9;
		pane.add(segundaEntregaMasDe3TFTotal, c);
		c.gridx = 2;
		c.gridy = 9;
		pane.add(segundaEntregaMasDe3Porcentual, c);
		c.gridx = 7;
		c.gridy = 9;
		pane.add(segundaEntregaTotalCampañasTF, c);

		c.gridx = 5;
		c.gridy = 10;
		pane.add(inicioTotalTF, c);
		c.gridx = 6;
		c.gridy = 10;
		pane.add(inicioPorcentualTF, c);
		c.gridx = 3;
		c.gridy = 10;
		pane.add(inicioEntre1y2TotalTF, c);
		c.gridx = 4;
		c.gridy = 10;
		pane.add(inicioEntre1y2PorcentualTF, c);
		c.gridx = 1;
		c.gridy = 10;
		pane.add(inicioMasDe3TFTotal, c);
		c.gridx = 2;
		c.gridy = 10;
		pane.add(inicioMasDe3Porcentual, c);
		c.gridx = 7;
		c.gridy = 10;
		pane.add(inicioTotalCampañasTF, c);

		c.gridx = 5;
		c.gridy = 11;
		pane.add(finTotalTF, c);
		c.gridx = 6;
		c.gridy = 11;
		pane.add(finPorcentualTF, c);
		c.gridx = 3;
		c.gridy = 11;
		pane.add(finEntre1y2TotalTF, c);
		c.gridx = 4;
		c.gridy = 11;
		pane.add(finEntre1y2PorcentualTF, c);
		c.gridx = 1;
		c.gridy = 11;
		pane.add(finMasDe3TFTotal, c);
		c.gridx = 2;
		c.gridy = 11;
		pane.add(finMasDe3Porcentual, c);
		c.gridx = 7;
		c.gridy = 11;
		pane.add(finTotalCampañasTF, c);

		c.gridx = 5;
		c.gridy = 12;
		pane.add(cierreTotalTF, c);
		c.gridx = 6;
		c.gridy = 12;
		pane.add(cierrePorcentualTF, c);
		c.gridx = 3;
		c.gridy = 12;
		pane.add(cierreEntre1y2TotalTF, c);
		c.gridx = 4;
		c.gridy = 12;
		pane.add(cierreEntre1y2PorcentualTF, c);
		c.gridx = 1;
		c.gridy = 12;
		pane.add(cierreMasDe3TFTotal, c);
		c.gridx = 2;
		c.gridy = 12;
		pane.add(cierreMasDe3Porcentual, c);
		c.gridx = 7;
		c.gridy = 12;
		pane.add(cierreTotalCampañasTF, c);

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
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		mesesB.setSelectedIndex(-1);

	}

	public void resetTextFields() {

		arteTotalTF.setText("");
		artePorcentualTF.setText("");
		arteEntre1y2TotalTF.setText("");
		arteEntre1y2PorcentualTF.setText("");
		arteMasDe3TFTotal.setText("");
		arteMasDe3Porcentual.setText("");
		arteTotalCampañasTF.setText("");

		pruebaTotalTF.setText("");
		pruebaPorcentualTF.setText("");
		pruebaEntre1y2TotalTF.setText("");
		pruebaEntre1y2PorcentualTF.setText("");
		pruebaMasDe3TFTotal.setText("");
		pruebaMasDe3Porcentual.setText("");
		pruebaTotalCampañasTF.setText("");

		okColorTotalTF.setText("");
		okColorPorcentualTF.setText("");
		okColorEntre1y2TotalTF.setText("");
		okColorEntre1y2PorcentualTF.setText("");
		okColorMasDe3TFTotal.setText("");
		okColorMasDe3Porcentual.setText("");
		okColorTotalCampañasTF.setText("");

		aprobacionOCTotalTF.setText("");
		aprobacionOCPorcentualTF.setText("");
		aprobacionOCEntre1y2TotalTF.setText("");
		aprobacionOCEntre1y2PorcentualTF.setText("");
		aprobacionOCMasDe3TFTotal.setText("");
		aprobacionOCMasDe3Porcentual.setText("");
		aprobacionOCTotalCampañasTF.setText("");

		envioOCTotalTF.setText("");
		envioOCPorcentualTF.setText("");
		envioOCEntre1y2TotalTF.setText("");
		envioOCEntre1y2PorcentualTF.setText("");
		envioOCMasDe3TFTotal.setText("");
		envioOCMasDe3Porcentual.setText("");
		envioOCTotalCampañasTF.setText("");

		primerEntregaTotalTF.setText("");
		primerEntregaPorcentualTF.setText("");
		primerEntregaEntre1y2TotalTF.setText("");
		primerEntregaEntre1y2PorcentualTF.setText("");
		primerEntregaMasDe3TFTotal.setText("");
		primerEntregaMasDe3Porcentual.setText("");
		primerEntregaTotalCampañasTF.setText("");

		segundaEntregaTotalTF.setText("");
		segundaEntregaPorcentualTF.setText("");
		segundaEntregaEntre1y2TotalTF.setText("");
		segundaEntregaEntre1y2PorcentualTF.setText("");
		segundaEntregaMasDe3TFTotal.setText("");
		segundaEntregaMasDe3Porcentual.setText("");
		segundaEntregaTotalCampañasTF.setText("");

		inicioTotalTF.setText("");
		inicioPorcentualTF.setText("");
		inicioEntre1y2TotalTF.setText("");
		inicioEntre1y2PorcentualTF.setText("");
		inicioMasDe3TFTotal.setText("");
		inicioMasDe3Porcentual.setText("");
		inicioTotalCampañasTF.setText("");

		finTotalTF.setText("");
		finPorcentualTF.setText("");
		finEntre1y2TotalTF.setText("");
		finEntre1y2PorcentualTF.setText("");
		finMasDe3TFTotal.setText("");
		finMasDe3Porcentual.setText("");
		finTotalCampañasTF.setText("");

		cierreTotalTF.setText("");
		cierrePorcentualTF.setText("");
		cierreEntre1y2TotalTF.setText("");
		cierreEntre1y2PorcentualTF.setText("");
		cierreMasDe3TFTotal.setText("");
		cierreMasDe3Porcentual.setText("");
		cierreTotalCampañasTF.setText("");

		demorallegadaArteTF.setText("");
		demorapedidoPruebaColorTF.setText("");
		demoraokColorTF.setText("");
		demoraaprobacionOCTF.setText("");
		demoraenvioOCTF.setText("");
		demoraprimerEntregaTF.setText("");
		demorasegundaEntregaTF.setText("");
		demorainicioColocacionTF.setText("");
		demorafiniColocacionTF.setText("");
		demoraentregaCierreTF.setText("");

	}

	public class ElegirMesHanlder implements ActionListener {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			resetTextFields();
			ArrayList<Campañas> deEsteMes = new ArrayList<Campañas>();

			for (Campañas c : array_campañas) {
				try {
					if (c.getLlegada_arte().getMonth() == mesesB
							.getSelectedIndex()) {
						deEsteMes.add(c);
						try {
							dem_arte = +Integer
									.parseInt(c.retrasoLlegadaArte());
							switch (Integer.parseInt(c.retrasoLlegadaArte())) {
							case 0:
								aTiempo_arte = +1;
								break;
							case 1:
							case 2:
								dem_arte1y2 = +1;
								break;
							default:
								dem_arte3 = +1;
							}

						} catch (NumberFormatException e3) {
							System.out.println("no hay retraso de arte");

						}
						try {
							dem_prueba = +Integer.parseInt(c
									.retrasoPedidoPrueba());
							switch (Integer.parseInt(c.retrasoPedidoPrueba())) {
							case 0:
								aTiempo_prueba = +1;
								break;
							case 1:
							case 2:
								dem_prueba1y2 = +1;
								break;
							default:
								dem_prueba3 = +1;
							}

						} catch (NumberFormatException e3) {
							System.out.println("no hay retraso de prueba");
						}

						try {
							dem_ok = +Integer.parseInt(c.retraso_okColor());
							switch (Integer.parseInt(c.retraso_okColor())) {
							case 0:
								aTiempo_ok = +1;
								break;
							case 1:
							case 2:
								dem_ok1y2 = +1;
								break;
							default:
								dem_ok3 = +1;
							}
						} catch (NumberFormatException e3) {
							System.out.println("no hay retraso de ok color");
						}

						try {
							dem_aprobacion = +Integer.parseInt(c
									.retrasoAprobacionOC());
							switch (Integer.parseInt(c.retrasoAprobacionOC())) {
							case 0:
								aTiempo_aprobacion = +1;
								break;
							case 1:
							case 2:
								dem_aprobacion1y2 = +1;
								break;
							default:
								dem_aprobacion3 = +1;
							}
						} catch (NumberFormatException e3) {
							System.out.println("no hay retraso aprobacion oc");
						}

						try {
							dem_envio = +Integer.parseInt(c
									.retrasoOrdenCompra());
							switch (Integer.parseInt(c.retrasoOrdenCompra())) {
							case 0:
								aTiempo_envio = +1;
								break;
							case 1:
							case 2:
								dem_envio1y2 = +1;
								break;
							default:
								dem_envio3 = +1;
							}

						} catch (NumberFormatException e3) {
							System.out
									.println("no hay retraso de orden de compra");
						}

						try {
							dem_primera = +Integer.parseInt(c
									.retrasoPrimerEntrega());
							switch (Integer.parseInt(c.retrasoPrimerEntrega())) {
							case 0:
								aTiempo_primera = +1;
								break;
							case 1:
							case 2:
								dem_primera1y2 = +1;
								break;
							default:
								dem_primera3 = +1;
							}
						} catch (NumberFormatException e3) {
							System.out.println("no hay retrasoprimer entrega");
						}

						try {
							dem_segunda = +Integer.parseInt(c
									.retrasoEntregaFinal());
							System.out.println(c.retrasoEntregaFinal());
							switch (Integer.parseInt(c.retrasoEntregaFinal())) {

							case 0:
								aTiempo_segunda = +1;
								break;
							case 1:
							case 2:
								dem_segunda1y2 = +1;
								break;
							default:
								dem_segunda3 = +1;
							}

						} catch (NumberFormatException e3) {
							System.out.println("no hay retraso entrega final");
						}

						try {
							dem_inicio = +Integer.parseInt(c
									.retrasoInicioColocacion());
							switch (Integer.parseInt(c
									.retrasoInicioColocacion())) {
							case 0:
								aTiempo_inicio = +1;
								break;
							case 1:
							case 2:
								dem_inicio1y2 = +1;
								break;
							default:
								dem_inicio3 = +1;
							}

						} catch (NumberFormatException e3) {
							System.out
									.println("no hay retraso inicio colocacion");
						}

						try {
							dem_fin = +Integer.parseInt(c
									.retrasoFinColocacion());
							switch (Integer.parseInt(c.retrasoFinColocacion())) {
							case 0:
								aTiempo_fin = +1;
								break;
							case 1:
							case 2:
								dem_fin1y2 = +1;
								break;
							default:
								dem_fin3 = +1;
							}
						} catch (NumberFormatException e3) {
							System.out.println("no hay retras fin colocaciono");
						}

						try {
							dem_cierre = +Integer.parseInt(c
									.retrasoEnvioCierre());
							switch (Integer.parseInt(c.retrasoEnvioCierre())) {
							case 0:
								aTiempo_cierre = +1;
								break;
							case 1:
							case 2:
								dem_cierre1y2 = +1;
								break;
							default:
								dem_cierre3 = +1;
							}
						} catch (NumberFormatException e3) {
							System.out.println("no hay retraso envio cierre");
						}

					} else {
						resetTextFields();
					}

				} catch (NullPointerException e2) {
					resetTextFields();
					System.out.println("no hay campañas en ese mes");
				}

				arteTotalTF.setText(Long.toString(aTiempo_arte));
				arteEntre1y2TotalTF.setText(Long.toString(dem_arte1y2));
				arteMasDe3TFTotal.setText(Long.toString(dem_arte3));
				pruebaTotalTF.setText(Long.toString(aTiempo_prueba));
				pruebaEntre1y2TotalTF.setText(Long.toString(dem_prueba1y2));
				pruebaMasDe3TFTotal.setText(Long.toString(dem_prueba3));
				okColorTotalTF.setText(Long.toString(aTiempo_ok));
				okColorEntre1y2TotalTF.setText(Long.toString(dem_ok1y2));
				okColorMasDe3TFTotal.setText(Long.toString(dem_ok3));
				envioOCTotalTF.setText(Long.toString(aTiempo_envio));
				envioOCEntre1y2TotalTF.setText(Long.toString(dem_envio1y2));
				envioOCMasDe3TFTotal.setText(Long.toString(dem_envio3));
				aprobacionOCTotalTF.setText(Long.toString(aTiempo_aprobacion));
				aprobacionOCEntre1y2TotalTF.setText(Long
						.toString(dem_aprobacion1y2));
				aprobacionOCMasDe3TFTotal.setText(Long
						.toString(dem_aprobacion3));
				primerEntregaTotalTF.setText(Long.toString(aTiempo_primera));
				primerEntregaEntre1y2TotalTF.setText(Long
						.toString(dem_primera1y2));
				primerEntregaMasDe3TFTotal.setText(Long.toString(dem_primera3));
				segundaEntregaTotalTF.setText(Long.toString(aTiempo_segunda));
				segundaEntregaEntre1y2TotalTF.setText(Long
						.toString(dem_segunda1y2));
				segundaEntregaMasDe3TFTotal
						.setText(Long.toString(dem_segunda3));
				inicioTotalTF.setText(Long.toString(aTiempo_inicio));
				inicioEntre1y2TotalTF.setText(Long.toString(dem_inicio1y2));
				inicioMasDe3TFTotal.setText(Long.toString(dem_inicio3));
				finTotalTF.setText(Long.toString(aTiempo_fin));
				finEntre1y2TotalTF.setText(Long.toString(dem_fin1y2));
				finMasDe3TFTotal.setText(Long.toString(dem_fin3));
				cierreTotalTF.setText(Long.toString(aTiempo_cierre));
				cierreEntre1y2TotalTF.setText(Long.toString(dem_cierre1y2));
				cierreMasDe3TFTotal.setText(Long.toString(dem_cierre3));
			}

			if (deEsteMes.size() != 0) {
				campas_total = (dem_arte3 + dem_arte1y2 + aTiempo_arte);
				artePorcentualTF.setText(df.format((float) aTiempo_arte
						/ campas_total));
				arteEntre1y2PorcentualTF.setText(df.format((float) dem_arte1y2
						/ campas_total));
				arteMasDe3Porcentual.setText(df.format((float) dem_arte3
						/ campas_total));
				arteTotalCampañasTF.setText(Long.toString(dem_arte3
						+ dem_arte1y2 + aTiempo_arte));

				campas_total = (dem_prueba3 + dem_prueba1y2 + aTiempo_prueba);
				pruebaPorcentualTF.setText(df.format((float) aTiempo_prueba
						/ campas_total));
				pruebaEntre1y2PorcentualTF.setText(df
						.format((float) dem_prueba1y2 / campas_total));
				pruebaMasDe3Porcentual.setText(df.format((float) dem_prueba3
						/ campas_total));
				pruebaTotalCampañasTF.setText(Long.toString(dem_prueba3
						+ dem_prueba1y2 + aTiempo_prueba));

				campas_total = (dem_ok3 + dem_ok1y2 + aTiempo_ok);
				okColorPorcentualTF.setText(df.format((float) aTiempo_ok
						/ campas_total));
				okColorEntre1y2PorcentualTF.setText(df.format((float) dem_ok1y2
						/ campas_total));
				okColorMasDe3Porcentual.setText(df.format((float) dem_ok3
						/ campas_total));
				okColorTotalCampañasTF.setText(Long.toString(dem_ok3
						+ dem_ok1y2 + aTiempo_ok));

				campas_total = (dem_aprobacion3 + dem_aprobacion1y2 + aTiempo_aprobacion);
				aprobacionOCPorcentualTF.setText(df
						.format((float) aTiempo_aprobacion / campas_total));
				aprobacionOCEntre1y2PorcentualTF.setText(df
						.format((float) dem_aprobacion1y2 / campas_total));
				aprobacionOCMasDe3Porcentual.setText(df
						.format((float) dem_aprobacion3 / campas_total));
				aprobacionOCTotalCampañasTF.setText(Long
						.toString(dem_aprobacion3 + dem_aprobacion1y2
								+ aTiempo_aprobacion));

				campas_total = (dem_envio3 + dem_envio1y2 + aTiempo_envio);
				envioOCPorcentualTF.setText(df.format((float) aTiempo_envio
						/ campas_total));
				envioOCEntre1y2PorcentualTF.setText(df
						.format((float) dem_envio1y2 / campas_total));
				envioOCMasDe3Porcentual.setText(df.format((float) dem_envio3
						/ campas_total));
				envioOCTotalCampañasTF.setText(Long.toString(dem_envio3
						+ dem_envio1y2 + aTiempo_envio));

				campas_total = (dem_primera3 + dem_primera1y2 + aTiempo_primera);
				primerEntregaPorcentualTF.setText(df
						.format((float) aTiempo_primera / campas_total));
				primerEntregaEntre1y2PorcentualTF.setText(df
						.format((float) dem_primera1y2 / campas_total));
				primerEntregaMasDe3Porcentual.setText(df
						.format((float) dem_primera3 / campas_total));
				primerEntregaTotalCampañasTF.setText(Integer
						.toString(dem_primera3 + dem_primera1y2
								+ aTiempo_primera));

				campas_total = (dem_segunda3 + dem_segunda1y2 + aTiempo_segunda);
				segundaEntregaPorcentualTF.setText(df
						.format((float) aTiempo_segunda / campas_total));
				segundaEntregaEntre1y2PorcentualTF.setText(df
						.format((float) dem_segunda1y2 / campas_total));
				segundaEntregaMasDe3Porcentual.setText(df
						.format((float) dem_segunda3 / campas_total));
				segundaEntregaTotalCampañasTF.setText(Long
						.toString(dem_segunda3 + dem_segunda1y2
								+ aTiempo_segunda));

				campas_total = (dem_inicio3 + dem_inicio1y2 + aTiempo_inicio);
				inicioPorcentualTF.setText(df.format((float) aTiempo_inicio
						/ campas_total));
				inicioEntre1y2PorcentualTF.setText(df
						.format((float) dem_inicio1y2 / campas_total));
				inicioMasDe3Porcentual.setText(df.format((float) dem_inicio3
						/ campas_total));
				inicioTotalCampañasTF.setText(Long.toString(dem_inicio3
						+ dem_inicio1y2 + aTiempo_inicio));

				campas_total = (dem_fin3 + dem_fin1y2 + aTiempo_fin);
				finPorcentualTF.setText(df.format((float) aTiempo_fin
						/ campas_total));
				finEntre1y2PorcentualTF.setText(df.format((float) dem_fin1y2
						/ campas_total));
				finMasDe3Porcentual.setText(df.format((float) dem_fin3
						/ campas_total));
				finTotalCampañasTF.setText(Long.toString(dem_fin3 + dem_fin1y2
						+ aTiempo_fin));

				campas_total = (dem_cierre3 + dem_cierre1y2 + aTiempo_cierre);
				cierrePorcentualTF.setText(df.format((float) aTiempo_cierre
						/ campas_total));
				cierreEntre1y2PorcentualTF.setText(df
						.format((float) dem_cierre1y2 / campas_total));
				cierreMasDe3Porcentual.setText(df.format((float) dem_cierre3
						/ campas_total));
				cierreTotalCampañasTF.setText(df.format(dem_cierre3
						+ dem_cierre1y2 + aTiempo_cierre));

				campas_total = deEsteMes.size();

				demorallegadaArteTF.setText(df.format((float) dem_arte
						/ campas_total));
				demorapedidoPruebaColorTF.setText(df.format((float) dem_prueba
						/ campas_total));
				demoraokColorTF.setText(df
						.format((float) dem_ok / campas_total));
				demoraaprobacionOCTF.setText(df.format((float) dem_aprobacion
						/ campas_total));
				demoraenvioOCTF.setText(df.format((float) dem_envio
						/ campas_total));
				demoraprimerEntregaTF.setText(df.format((float) dem_primera
						/ campas_total));
				demorasegundaEntregaTF.setText(df.format((float) dem_segunda
						/ campas_total));
				demorainicioColocacionTF.setText(df.format((float) dem_inicio
						/ campas_total));
				demorafiniColocacionTF.setText(df.format((float) dem_fin
						/ campas_total));
				demoraentregaCierreTF.setText(df.format((float) dem_cierre
						/ campas_total));
			} else {
				resetTextFields();
				System.out.println("este mes no hubo campañas");
			}

		}

	}

	public static void main(ArrayList<Campañas> array) {
		Resumen resumen = new Resumen();
		resumen.array_campañas = array;
		// for (Campañas campañas : array) {
		// //System.out.println(campañas.getNombre_campaña());
		// }
	}

}
