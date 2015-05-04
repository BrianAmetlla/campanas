package ar.brian_ame.vpm;

import ar.brian_ame.vpm.*;
import ar.brian_ame.vpm.TestUtils.*;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

import org.apache.poi.*;
import org.apache.poi.ss.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hpsf.*;

@SuppressWarnings("unused")
public class Vista extends JFrame
{
	private static final long serialVersionUID = 01;
	private static int WIDTH = 800;
	private static  int HEIGHT = 380;
	DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	private JFormattedTextField fecha_inicioTF, llegada_arteTF, pedido_prueba_colorTF, ok_prueba_colorTF;
	private JFormattedTextField llegada_ajustesTF, aprobacion_ocTF, envio_ocTF, primer_entregaTF;
	private JFormattedTextField segunda_entregaTF, inicio_instalacionTF, fin_instalacionTF, envio_cierreTF;
	private JFormattedTextField fecha_optima_pcTF, fecha_optima_ocTF, fecha_optima_entregaTF;
	private JFormattedTextField fecha_optima_inicioTF, fecha_optima_finTF, fechaOptimaArteTF;
	private JFormattedTextField arteTF, okRealTF, okIdealTF;
   	
	private JTextField retraso_llegada_arteTF, retraso_pedido_pruebaTF, retraso_ok_colorTF, retraso_aprobacion_ocTF, retraso_orden_compraTF, retraso_primer_entregaTF, retraso_segunda_entregaTF, retraso_inicio_colocacionTF, retraso_fin_colocacionTF, retraso_fin_cierreTF;
	private JTextField campañaTF, formatoTF;

	private JLabel retraso_llegada_arteL, retraso_pedido_pruebaL, retraso_ok_colorL, retraso_aprobacion_ocL, retraso_orden_compraL, retraso_primer_entregaL, retraso_segunda_entregaL, retraso_inicio_colocacionL, retraso_fin_cierreL, retraso_fin_colocacionL;
	private JLabel campañanaL, formatoL, fecha_inicioL, fechaOptimaArteL;
	private JLabel llegada_ajustesL, aprobacion_ocL, envio_ocL, primer_entregaL, pedido_prueba_colorL;
	private JLabel llegada_arteL, ok_prueba_colorL, segunda_entregaL, inicio_instalacionL, fin_instalacionL;
	private JLabel envio_cierreL, fecha_optima_pcL, fecha_optima_ocL, fecha_optima_entregaL;
	private JLabel fecha_optima_inicioL, fecha_optima_finL;
	private JButton actualizarCampaña, exitB, verRetrasos, expoAexcelB, nuevaCB, importarExcelB;
    
	private GridBagConstraints lastConstraints = null;
    private GridBagConstraints middleConstraints = null;
    private GridBagConstraints labelConstraints = null;

    //Button handlers:
    private VerRetrasos vRetrasoHandler;
    private CrearNuevaCampañaButtonHandler nuevaCHandler;
	private ActualizarButtonHandler abHandler;
	private ExitButtonHandler ebHandler;
	private ImportarExcelbuttonHandler importarExcelHandler;  
	private ExpoAexcelbuttonHandler expoAexcelHandler;
	private SelectCampañaHandler selectCampañahandler;
	private JComboBox<Campañas> allCampañasB;
	
	//inicializo variables y objetos que voy a user
	Campañas campa ;
	//ArrayList<String> lista_campañas = new ArrayList<String>();
	ArrayList<ArrayList<String>> todasLasCampañas = new ArrayList<ArrayList<String>> ();
	ArrayList<ArrayList<String>> campañasImportadas = new ArrayList<ArrayList<String>> ();
	ArrayList<String> estado_viejo = new ArrayList<String>();
	int estado_viejo_index = -1 ;

	
public Vista()
	{
		crearGUI();
	}
	
private class ActualizarButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		

		{   	//tengo q remover el estado viejo de la lista de campañas y agregar el nevo
				// recorro la lista, y busco el nombre de la campaña
				// cuando lo encuentra saco la posicicon en la lista para removerlo despues
			if (jbotonTiene(allCampañasB, campa)){
				//vuelvo a llenar los campos con los datos del nuevo objeto
				calcularFechas();
				//remuevo de la lista el estado viejo
				todasLasCampañas.remove(estado_viejo);
				//agrego la info actualizada del objeto a la lista
				todasLasCampañas.add(guardar_estado());

			}
			else
			{
				//no existe lo grabo x primera vez
				calcularFechas();
				allCampañasB.addItem(campa);
				//agrego la info actualizada del objeto a la lista
				todasLasCampañas.add(guardar_estado());
				
			}
			allCampañasB.setSelectedIndex(-1);
			bloquearTextos();
			
		}
	}

private class CrearNuevaCampañaButtonHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{   
		allCampañasB.setSelectedIndex(-1);
		campa = new Campañas();
		inicializar();
		estado_viejo = guardar_estado();
		desbloquearTextos();
	}
}


public boolean jbotonTiene(JComboBox<Campañas> boton,Campañas c)
{
	int size = boton.getItemCount();
	boolean a;
	for (int i = 0; i< size; i++)
	{
	Campañas c2 = boton.getItemAt(i);
		if(c.equals(c2))
		{return true;
		}
	}
	return false;

}
	
public class SelectCampañaHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (allCampañasB.getSelectedIndex()>-1){
			campa = (Campañas) allCampañasB.getSelectedItem();
			dameCampa(campa);
			estado_viejo = guardar_estado();
			desbloquearTextos();
			campañaTF.setEditable(false);
			}
		}
	}
	

public void bloquearTextos() {
	
	campañaTF.setEditable(false);
	formatoTF.setEditable(false);
	fecha_inicioTF.setEditable(false);
	fecha_inicioTF.setEditable(false);
	llegada_arteTF.setEditable(false);
	pedido_prueba_colorTF.setEditable(false);
	ok_prueba_colorTF.setEditable(false);
	llegada_ajustesTF.setEditable(false);
	aprobacion_ocTF.setEditable(false);
	envio_ocTF.setEditable(false);
	primer_entregaTF.setEditable(false);
	segunda_entregaTF.setEditable(false);
	inicio_instalacionTF.setEditable(false);
	fin_instalacionTF.setEditable(false);
	envio_cierreTF.setEditable(false);

}

public void desbloquearTextos() {
	
	campañaTF.setEditable(true);
	formatoTF.setEditable(true);
	fecha_inicioTF.setEditable(true);
	fecha_inicioTF.setEditable(true);
	llegada_arteTF.setEditable(true);
	pedido_prueba_colorTF.setEditable(true);
	ok_prueba_colorTF.setEditable(true);
	llegada_ajustesTF.setEditable(true);
	aprobacion_ocTF.setEditable(true);
	envio_ocTF.setEditable(true);
	primer_entregaTF.setEditable(true);
	segunda_entregaTF.setEditable(true);
	inicio_instalacionTF.setEditable(true);
	fin_instalacionTF.setEditable(true);
	envio_cierreTF.setEditable(true);

}

public class ExpoAexcelbuttonHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		//  muestra todas las campñanas que graba
		Iterator<ArrayList<String>> it = todasLasCampañas.iterator();

	    while(it.hasNext())
	        {
 
	         System.out.println(it.next());
	       
	        }
	    
		  WriteExcel.main(todasLasCampañas);
		
	}
}


public class ImportarExcelbuttonHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
	    String[] args = null;
	    campañasImportadas = ReadExcel.main(args);
	    todasLasCampañas = campañasImportadas;
	    
	    
	    //creo un objeto por cada arraylist del arraylist(arraylis)
	    for(ArrayList<String> c : todasLasCampañas )
	    {
	    	
	    	String impor_nombre = c.get(0);
	    	String impor_formato = c.get(1);
	    	String impot_fecha_inicio =  c.get(2); 
	    	String impor_llegada_arte = c.get(4);
	    	String impor_pedido_prueba_color  = c.get(6);
	    	String impor_ok_pruebacolo = c.get(7);
	    	String impor_llegada_justes = c.get(8);
	    	String impor_aprobacion_oc = c.get(10);
	    	String impor_envio_oc = c.get(11);
	    	String impor_primer_entrega = c.get(13);
	    	String impor_segunda_entrega = c.get(14);
	    	String impor_inicio_instalacion = c.get(16);
	    	String impor_find_instalacion = c.get(18);
	    	String impor_envio_cierre = c.get(19);
	    	
	   	   	 campa = new Campañas(impor_nombre, impor_formato, TestUtils.toDateWithTime(impot_fecha_inicio), 
	   	   			TestUtils.toDateWithTime(impor_llegada_arte), TestUtils.toDateWithTime(impor_pedido_prueba_color), 
	   	   			TestUtils.toDateWithTime(impor_ok_pruebacolo), 
	   	   			TestUtils.toDateWithTime(impor_llegada_justes), TestUtils.toDateWithTime(impor_aprobacion_oc), 
	   	   			TestUtils.toDateWithTime(impor_envio_oc), TestUtils.toDateWithTime(impor_primer_entrega), 
	   	   			TestUtils.toDateWithTime(impor_segunda_entrega), TestUtils.toDateWithTime(impor_inicio_instalacion), 
	   	   			TestUtils.toDateWithTime(impor_find_instalacion), 
	   	   			TestUtils.toDateWithTime(impor_envio_cierre));
	   	   	 
	   	  allCampañasB.addItem(campa);
	    
	    }
	    
	}
}


public ArrayList<String>  guardar_estado() {
	ArrayList<String> estado = new ArrayList<String>(Arrays.asList(
			campañaTF.getText(), formatoTF.getText(), fecha_inicioTF.getText(), 
			fechaOptimaArteTF.getText(), llegada_arteTF.getText(), 
			fecha_optima_pcTF.getText(), pedido_prueba_colorTF.getText(),
			ok_prueba_colorTF.getText(), llegada_ajustesTF.getText(), 
			fecha_optima_ocTF.getText(), aprobacion_ocTF.getText(), envio_ocTF.getText(), 
			fecha_optima_entregaTF.getText(), primer_entregaTF.getText(), 
			segunda_entregaTF.getText(), fecha_optima_inicioTF.getText(), 
			inicio_instalacionTF.getText(), fecha_optima_finTF.getText(), 
			fin_instalacionTF.getText(), envio_cierreTF.getText(), 
			retraso_llegada_arteTF.getText(), retraso_pedido_pruebaTF.getText(), 
			retraso_ok_colorTF.getText(), retraso_aprobacion_ocTF.getText(), 
			retraso_orden_compraTF.getText(), retraso_primer_entregaTF.getText(), 
			retraso_segunda_entregaTF.getText(), retraso_inicio_colocacionTF.getText(), 
			retraso_fin_colocacionTF.getText(), retraso_fin_cierreTF.getText(), 
			arteTF.getText(), okRealTF.getText(), okIdealTF.getText())
			);
	return estado;


}

public class FixedSizeDocument extends PlainDocument
	{
	   /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	private int max = 10;
	   
	   public FixedSizeDocument(int max) 
	   { 
	        this.max = max; 
	   } 

	   @Override
	   public void insertString(int offs, String str, AttributeSet a)
	      throws BadLocationException
	   {
	      // check string being inserted does not exceed max length
		   
	      if (getLength()+str.length()>max)
	      {
	         // If it does, then truncate it
	    	  
	         str = str.substring(0, max - getLength());
	      }
	      super.insertString(offs, str, a);
	   }
	}

public void crearGUI() {
		campañanaL = new JLabel("Nombre Campaña: ", SwingConstants.LEFT);
		formatoL = new JLabel("Formato Y Cantidad: ", SwingConstants.LEFT);
		fecha_inicioL = new JLabel("Fecha inicio: ", SwingConstants.LEFT);
		llegada_ajustesL = new JLabel("Fecha Llegada ajustes: ", SwingConstants.LEFT);
		aprobacion_ocL = new JLabel("Fecha Aprobaciones OCs: ", SwingConstants.LEFT);
		envio_ocL = new JLabel("Fecha Envio OC: ", SwingConstants.LEFT);
		primer_entregaL = new JLabel("Fecha Primer Entrega: ", SwingConstants.LEFT);
		pedido_prueba_colorL = new JLabel("Fecha Pedido Color: ", SwingConstants.LEFT);
		llegada_arteL = new JLabel("Fecha Llegada Arte: ", SwingConstants.LEFT);
		ok_prueba_colorL = new JLabel("Fecha Ok Prueba Color: ", SwingConstants.LEFT);
		segunda_entregaL = new JLabel("Fecha Segunda Entrega: ", SwingConstants.LEFT);
		inicio_instalacionL = new JLabel("Fecha Inicio Instalacion: ", SwingConstants.LEFT);
		fin_instalacionL = new JLabel("Fecha Fin Instalacion: ", SwingConstants.LEFT);
		envio_cierreL = new JLabel("Fecha Envio Cierre: ", SwingConstants.LEFT);
		fechaOptimaArteL = new JLabel("Fecha Optima Arte: ", SwingConstants.LEFT);
		arteTF = new JFormattedTextField(format);
		okRealTF = new JFormattedTextField(format);
		okIdealTF = new JFormattedTextField(format);
		campañaTF = new JTextField();
		formatoTF = new JTextField();
		fecha_inicioTF = new JFormattedTextField(format);
		fecha_inicioTF = new JFormattedTextField(format);
		llegada_arteTF = new JFormattedTextField(format);
		pedido_prueba_colorTF = new JFormattedTextField(format);
		ok_prueba_colorTF = new JFormattedTextField(format);
		llegada_ajustesTF = new JFormattedTextField(format);
		aprobacion_ocTF = new JFormattedTextField(format);
		envio_ocTF = new JFormattedTextField(format);
		primer_entregaTF = new JFormattedTextField(format);
		segunda_entregaTF = new JFormattedTextField(format);
		inicio_instalacionTF = new JFormattedTextField(format);
		fin_instalacionTF = new JFormattedTextField(format);
		envio_cierreTF = new JFormattedTextField(format);

		fecha_optima_pcL = new JLabel("Fecha Optima PC: ", SwingConstants.LEFT);
		fecha_optima_pcTF = new JFormattedTextField(format);
		fecha_optima_ocL = new JLabel("Fecha Optima OC: ", SwingConstants.LEFT);
		fecha_optima_ocTF = new JFormattedTextField(format);
		fecha_optima_entregaL = new JLabel("Fecha Optima Entrega: ", SwingConstants.LEFT);
		fecha_optima_entregaTF = new JFormattedTextField(format);
		fecha_optima_inicioL = new JLabel("Fecha Inicio PC: ", SwingConstants.LEFT);
		fecha_optima_inicioTF = new JFormattedTextField(format);
		fecha_optima_finL = new JLabel("Fecha Optima PC: ", SwingConstants.LEFT);
		fecha_optima_finTF = new JFormattedTextField(format);

		retraso_llegada_arteL = new JLabel("Retraso Llegada Arte: ", SwingConstants.LEFT);
		retraso_llegada_arteTF = new JFormattedTextField(format);
		retraso_pedido_pruebaL = new JLabel("Retraso Pedido Prueba: ", SwingConstants.LEFT);
		retraso_pedido_pruebaTF = new JFormattedTextField(format);
		retraso_ok_colorL = new JLabel("Retraso OK Color: ", SwingConstants.LEFT);
		retraso_ok_colorTF = new JFormattedTextField(format);
		retraso_aprobacion_ocL = new JLabel("Retraso Aprobacion OC: ", SwingConstants.LEFT);
		retraso_aprobacion_ocTF = new JFormattedTextField(format);
		retraso_orden_compraL = new JLabel("Retraso Orden Compra: ", SwingConstants.LEFT);
		retraso_orden_compraTF = new JFormattedTextField(format);
		retraso_primer_entregaL = new JLabel("Retraso Primer Entrega: ", SwingConstants.LEFT);
		retraso_primer_entregaTF = new JFormattedTextField(format);
		retraso_segunda_entregaL = new JLabel("Retraso Entrega Final: ", SwingConstants.LEFT);
		retraso_segunda_entregaTF = new JFormattedTextField(format);
		retraso_inicio_colocacionL = new JLabel("Retraso Inicio Colocacion: ", SwingConstants.LEFT);
		retraso_inicio_colocacionTF = new JFormattedTextField(format);
		retraso_fin_colocacionL =  new JLabel("Retraso Fin Colocacion: ", SwingConstants.LEFT);
		retraso_fin_colocacionTF =  new JTextField();
		retraso_fin_cierreL = new JLabel("Retraso Fin Cierre: ", SwingConstants.LEFT);
		retraso_fin_cierreTF = new JFormattedTextField(format);
		fechaOptimaArteTF = new JFormattedTextField(format);

		//SPecify handlers for each button and add (register) ActionListeners to each button.
		actualizarCampaña = new JButton("Grabar Campaña");
		abHandler = new ActualizarButtonHandler();
		actualizarCampaña.addActionListener(abHandler);

		verRetrasos = new JButton("Ver Retrasos");
		vRetrasoHandler = new VerRetrasos();
		//calculasRetrasos.setPreferredSize(new Dimension(null));
		verRetrasos.addActionListener(vRetrasoHandler);


		exitB = new JButton("Exit");
		ebHandler = new ExitButtonHandler();
		//exitB.setPreferredSize(new Dimension(null));
		exitB.addActionListener(ebHandler);

		expoAexcelB = new JButton("A Excel");
		expoAexcelHandler = new ExpoAexcelbuttonHandler();
		//exitB.setPreferredSize(new Dimension(null));
		expoAexcelB.addActionListener(expoAexcelHandler);

		
		 importarExcelB = new JButton("Desde Excel");
		 importarExcelHandler = new  ImportarExcelbuttonHandler();
		 importarExcelB.addActionListener(importarExcelHandler);
		
		
		nuevaCB = new JButton("Crear Campaña");
	    //private CrearNuevaCampaña nuevaCHandler;
		nuevaCHandler = new CrearNuevaCampañaButtonHandler();
		nuevaCB.addActionListener(nuevaCHandler);


		allCampañasB =  new JComboBox<Campañas>(); 
		selectCampañahandler = new SelectCampañaHandler();
		allCampañasB.addActionListener(selectCampañahandler);
		
		
		
		
		bloquearTextos();
		
		
		allCampañasB.setRenderer(new DefaultListCellRenderer() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Campañas){
                	Campañas c = (Campañas) value;
                    setText(c.getNombre_campaña().toString());
                }
                return this;
            }
        } );
       
		setTitle("Titulo:Calcular Fecha Optimas y retrasos");
		Container pane = getContentPane();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(1,1,1,1);
		
		
		//agrego todos los labels de los inputs
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(campañanaL, c);
		c.gridx = 0;
		c.gridy = 1;
		pane.add(formatoL, c);
		c.gridx = 0;
		c.gridy = 2;
		pane.add(fecha_inicioL, c);
		c.gridx = 0;
		c.gridy = 3;
		pane.add(llegada_arteL,c);
		c.gridx = 0;
		c.gridy = 4;
		pane.add(pedido_prueba_colorL,c);
		c.gridx = 0;
		c.gridy = 5;
		pane.add(ok_prueba_colorL,c);
		c.gridx = 0;
		c.gridy = 6;
		pane.add(llegada_ajustesL,c);
		c.gridx = 0;
		c.gridy = 7;
		pane.add(aprobacion_ocL,c);
		c.gridx = 0;
		c.gridy = 8;
		pane.add(envio_ocL ,c);
		c.gridx = 0;
		c.gridy = 9;
		pane.add(primer_entregaL,c);
		c.gridx = 0;
		c.gridy = 10;
		pane.add(segunda_entregaL,c);
		c.gridx = 0;
		c.gridy = 11;
		pane.add(inicio_instalacionL,c);
		c.gridx = 0;
		c.gridy = 12;
		pane.add(fin_instalacionL,c);
		c.gridx = 0;
		c.gridy = 13;
		pane.add(envio_cierreL,c);
		c.gridx = 2;
		c.gridy = 3;
		pane.add(retraso_llegada_arteL, c);
		c.gridx = 2;
		c.gridy = 4;
		pane.add(retraso_pedido_pruebaL, c);
		c.gridx = 2;
		c.gridy = 5;
		pane.add(retraso_ok_colorL, c);
		c.gridx = 2;
		c.gridy = 6;
		pane.add(retraso_aprobacion_ocL, c);
		c.gridx = 2;
		c.gridy = 7;
		pane.add(retraso_orden_compraL, c);
		c.gridx = 2;
		c.gridy = 8;
		pane.add(retraso_primer_entregaL, c);
		c.gridx = 2;
		c.gridy = 9;
		pane.add(retraso_segunda_entregaL, c);
		c.gridx = 2;
		c.gridy = 10;
		pane.add(retraso_inicio_colocacionL, c);
		c.gridx = 2;
		c.gridy = 11;
		pane.add(retraso_fin_colocacionL, c);
		c.gridx = 2;
		c.gridy = 12;
		pane.add(retraso_fin_cierreL, c);
		c.gridx = 2;
		c.gridy = 2;
		pane.add(fechaOptimaArteL, c);
		c.gridx = 2;
		c.gridy = 3;
		pane.add(fecha_optima_pcL, c);
		c.gridx = 2;
		c.gridy = 4;
		pane.add(fecha_optima_ocL, c);
		c.gridx = 2;
		c.gridy = 5;
		pane.add(fecha_optima_entregaL, c);
		c.gridx = 2;
		c.gridy = 6;
		pane.add(fecha_optima_inicioL, c);
		c.gridx = 2;
		c.gridy = 7;
		pane.add(fecha_optima_finL, c);

		//c.weightx = 0.04;
		//
		//botones
		c.gridx = 2;
		c.gridy = 15;
		pane.add(actualizarCampaña,c);
		c.gridx = 2;
		c.gridy = 14;
		pane.add(verRetrasos,c);
		c.gridx = 3;
		c.gridy = 15;
		pane.add(exitB,c);
		c.gridx = 3;
		c.gridy =14 ;
		pane.add(nuevaCB, c);
		
		
		c.gridx = 1;
		c.gridy = 14;
		pane.add(expoAexcelB,c);
		
		c.gridx = 0;
		c.gridy = 14;
		pane.add(importarExcelB,c);
		
		
		
		c.gridx = 1;
		c.gridy = 15;
		allCampañasB.setPreferredSize(new Dimension(20, 20));
		pane.add(allCampañasB,c);
		

        //agrego todos los TF de los inputs
		c.weightx = 0.1;
		c.gridx = 1;
		c.gridy = 0;
		pane.add(campañaTF, c);
		c.gridx = 1;
		c.gridy = 1;
		pane.add(formatoTF, c);
		c.gridx = 1;
		c.gridy = 2;
		pane.add(fecha_inicioTF, c);
		c.gridx = 1;
		c.gridy = 3;
		pane.add(llegada_arteTF,c);
		c.gridx = 1;
		c.gridy = 4;
		pane.add(pedido_prueba_colorTF,c);
		c.gridx = 1;
		c.gridy = 5;
		pane.add(ok_prueba_colorTF,c);
		c.gridx = 1;
		c.gridy = 6;
		pane.add(llegada_ajustesTF,c);
		c.gridx = 1;
		c.gridy = 7;
		pane.add(aprobacion_ocTF,c);
		c.gridx = 1;
		c.gridy = 8;
		pane.add(envio_ocTF,c);
		c.gridx = 1;
		c.gridy = 11;
		pane.add(inicio_instalacionTF,c);
		c.gridx = 1;
		c.gridy = 12;
		pane.add(fin_instalacionTF,c);
		c.gridx = 1;
		c.gridy = 9;
		pane.add(primer_entregaTF,c);
		c.gridx = 1;
		c.gridy = 10;
		pane.add(segunda_entregaTF,c);
		c.gridx = 1;
		c.gridy = 13;
		pane.add(envio_cierreTF,c);
		c.gridx = 3;
		c.gridy = 5;
		pane.add(retraso_ok_colorTF, c);
		c.gridx = 3;
		c.gridy = 4;
		pane.add(retraso_pedido_pruebaTF, c);
		c.gridx = 3;
		c.gridy = 6;
		pane.add(retraso_aprobacion_ocTF, c);
		c.gridx = 3;
		c.gridy = 7;
		pane.add(retraso_orden_compraTF, c);
		c.gridx = 3;
		c.gridy = 8;
		pane.add(retraso_primer_entregaTF, c);
		c.gridx = 3;
		c.gridy = 9;
		pane.add(retraso_segunda_entregaTF, c);	
		c.gridx = 3;
		c.gridy = 10;
		pane.add(retraso_inicio_colocacionTF, c);
		c.gridx = 3;
		c.gridy = 3;
		pane.add(retraso_llegada_arteTF, c);
		c.gridx = 3;
		c.gridy = 12;
		pane.add(retraso_fin_cierreTF, c);
		c.gridx = 3;
		c.gridy = 11;
		pane.add(retraso_fin_colocacionTF, c);
		c.gridx = 3;
		c.gridy = 3;
		pane.add(fecha_optima_pcTF, c);
		c.gridx = 3;
		c.gridy = 4;
		pane.add(fecha_optima_ocTF, c);
		c.gridx = 3;
		c.gridy = 2;
		pane.add(fechaOptimaArteTF, c);
		c.gridx = 3;
		c.gridy = 7;
		pane.add(fecha_optima_finTF, c);;
		c.gridx = 3;
		c.gridy = 6;
		pane.add(fecha_optima_inicioTF, c);
		c.gridx = 3;
		c.gridy = 5;
		pane.add(fecha_optima_entregaTF, c);
		
		
		//limito los chars de los TF
		campañaTF.setDocument(new FixedSizeDocument(10));
		formatoTF.setDocument(new FixedSizeDocument(10));
		fecha_inicioTF.setDocument(new FixedSizeDocument(10));
		llegada_arteTF.setDocument(new FixedSizeDocument(10));
		pedido_prueba_colorTF.setDocument(new FixedSizeDocument(10));
		ok_prueba_colorTF.setDocument(new FixedSizeDocument(10));
		llegada_ajustesTF.setDocument(new FixedSizeDocument(10));
		aprobacion_ocTF.setDocument(new FixedSizeDocument(10));
		envio_ocTF.setDocument(new FixedSizeDocument(10));
		inicio_instalacionTF.setDocument(new FixedSizeDocument(10));
		fin_instalacionTF.setDocument(new FixedSizeDocument(10));
		primer_entregaTF.setDocument(new FixedSizeDocument(10));
		segunda_entregaTF.setDocument(new FixedSizeDocument(10));
		envio_cierreTF.setDocument(new FixedSizeDocument(10));
		retraso_ok_colorTF.setDocument(new FixedSizeDocument(10));
		retraso_pedido_pruebaTF.setDocument(new FixedSizeDocument(10));
		retraso_aprobacion_ocTF.setDocument(new FixedSizeDocument(10));
		retraso_orden_compraTF.setDocument(new FixedSizeDocument(10));
		retraso_primer_entregaTF.setDocument(new FixedSizeDocument(10));
		retraso_segunda_entregaTF.setDocument(new FixedSizeDocument(10));	
		retraso_inicio_colocacionTF.setDocument(new FixedSizeDocument(10));
		retraso_llegada_arteTF.setDocument(new FixedSizeDocument(10));
		retraso_fin_cierreTF.setDocument(new FixedSizeDocument(10));
		retraso_fin_colocacionTF.setDocument(new FixedSizeDocument(10));
		fecha_optima_pcTF.setDocument(new FixedSizeDocument(10));
		fecha_optima_ocTF.setDocument(new FixedSizeDocument(10));
		fechaOptimaArteTF.setDocument(new FixedSizeDocument(10));
		fecha_optima_finTF.setDocument(new FixedSizeDocument(10));;
		fecha_optima_inicioTF.setDocument(new FixedSizeDocument(10));
		fecha_optima_entregaTF.setDocument(new FixedSizeDocument(10));
		
		
		//fechas optimas no editable
		fecha_optima_finTF.setEditable(false);
		fecha_optima_inicioTF.setEditable(false);
		fecha_optima_entregaTF.setEditable(false);
		fecha_optima_ocTF.setEditable(false);
		fecha_optima_pcTF.setEditable(false);
		fechaOptimaArteTF.setEditable(false);
		//fechas retrasadas no editables
		retraso_llegada_arteTF.setEditable(false);
		retraso_pedido_pruebaTF.setEditable(false);
		retraso_ok_colorTF.setEditable(false);
		retraso_aprobacion_ocTF.setEditable(false);
		retraso_orden_compraTF.setEditable(false);
		retraso_primer_entregaTF.setEditable(false);
		retraso_segunda_entregaTF.setEditable(false);	
		retraso_inicio_colocacionTF.setEditable(false);
		retraso_fin_colocacionTF.setEditable(false);
		retraso_fin_cierreTF.setEditable(false);
		
		//fechas optmias no visibles
		fechaOptimaArteL.setVisible(false);
		fechaOptimaArteTF.setVisible(false);
		fecha_optima_pcL.setVisible(false);
		fecha_optima_pcTF.setVisible(false);
		fecha_optima_ocL.setVisible(false);
		fecha_optima_ocTF.setVisible(false);
		fecha_optima_entregaL.setVisible(false);
		fecha_optima_entregaTF.setVisible(false);
		fecha_optima_inicioL.setVisible(false);
		fecha_optima_inicioTF.setVisible(false);
		fecha_optima_finL.setVisible(false);
		fecha_optima_finTF.setVisible(false);
		
		//retrasos
		retraso_llegada_arteL.setVisible(false);
		retraso_llegada_arteTF.setVisible(false);
		retraso_pedido_pruebaL.setVisible(false);
		retraso_pedido_pruebaTF.setVisible(false);
		retraso_ok_colorL.setVisible(false);
		retraso_ok_colorTF.setVisible(false);
		retraso_aprobacion_ocL.setVisible(false);
		retraso_aprobacion_ocTF.setVisible(false);
		retraso_orden_compraL.setVisible(false);
		retraso_orden_compraTF.setVisible(false);
		retraso_primer_entregaL.setVisible(false);
		retraso_primer_entregaTF.setVisible(false);
		retraso_segunda_entregaL.setVisible(false);
		retraso_segunda_entregaTF.setVisible(false);	
		retraso_inicio_colocacionL.setVisible(false);
		retraso_inicio_colocacionTF.setVisible(false);
		retraso_fin_colocacionL.setVisible(false);
		retraso_fin_colocacionTF.setVisible(false);
		retraso_fin_cierreL.setVisible(false);
		retraso_fin_cierreTF.setVisible(false);
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


private void inicializar(){
	campañaTF.setText("");
	formatoTF.setText("");
	fecha_inicioTF.setText("");
	llegada_arteTF.setText("");
	pedido_prueba_colorTF.setText("");
	ok_prueba_colorTF.setText("");
	llegada_ajustesTF.setText("");
	aprobacion_ocTF.setText("");
	envio_ocTF.setText("");
	primer_entregaTF.setText("");
	segunda_entregaTF.setText("");
	inicio_instalacionTF.setText("");
	fin_instalacionTF.setText("");
	envio_cierreTF.setText("");
	
	
}

	
public class ExitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
public class VerRetrasos implements ActionListener
	{
	public void actionPerformed(ActionEvent e)
		{
			//escondo los optimos
			fechaOptimaArteL.setVisible(false);
			fechaOptimaArteTF.setVisible(false);
			fecha_optima_pcL.setVisible(false);
			fecha_optima_pcTF.setVisible(false);
			fecha_optima_ocL.setVisible(false);
			fecha_optima_ocTF.setVisible(false);
			fecha_optima_entregaL.setVisible(false);
			fecha_optima_entregaTF.setVisible(false);
			fecha_optima_inicioL.setVisible(false);
			fecha_optima_inicioTF.setVisible(false);
			fecha_optima_finL.setVisible(false);
			fecha_optima_finTF.setVisible(false);
			
			//muestro los retrasos
			retraso_llegada_arteL.setVisible(true);
			retraso_llegada_arteTF.setVisible(true);
			retraso_pedido_pruebaL.setVisible(true);
			retraso_pedido_pruebaTF.setVisible(true);
			retraso_ok_colorL.setVisible(true);
			retraso_ok_colorTF.setVisible(true);
			retraso_aprobacion_ocL.setVisible(true);
			retraso_aprobacion_ocTF.setVisible(true);
			retraso_orden_compraL.setVisible(true);
			retraso_orden_compraTF.setVisible(true);
			retraso_primer_entregaL.setVisible(true);
			retraso_primer_entregaTF.setVisible(true);
			retraso_segunda_entregaL.setVisible(true);
			retraso_segunda_entregaTF.setVisible(true);	
			retraso_inicio_colocacionL.setVisible(true);
			retraso_inicio_colocacionTF.setVisible(true);
			retraso_fin_colocacionL.setVisible(true);
			retraso_fin_colocacionTF.setVisible(true);
			retraso_fin_cierreL.setVisible(true);
			retraso_fin_cierreTF.setVisible(true);
				
		}
		
		
}


//asigna al objeto campaña los datos de los TF
public void calcularFechas() {
		try {
			String strDate = new SimpleDateFormat("dd/MM/yyyy").format(fecha_inicioTF.getValue());
			campa.setFecha_inicio(TestUtils.toDateWithTime(strDate));
		} 
		catch (IllegalArgumentException a)
		{
			campa.setFecha_inicio(TestUtils.toDateWithTime(""));
		}
		
		try {
			campa.setNombre_campaña(campañaTF.getText());
		} 
		catch (IllegalArgumentException a)
		{
			campa.setNombre_campaña("");
		}

		try {
			campa.setFormatoYcantidad(formatoTF.getText());
		} 
		catch (IllegalArgumentException a)
		{
			campa.setFormatoYcantidad("");
		}

		try {
		String strDate2 = new SimpleDateFormat("dd/MM/yyyy").format(llegada_arteTF.getValue());
		campa.setLlegada_arte(TestUtils.toDateWithTime(strDate2));
		} 
		catch (IllegalArgumentException a)
		{
			campa.setLlegada_arte(TestUtils.toDateWithTime(""));
		}

		
		try {
		String strDate3 = new SimpleDateFormat("dd/MM/yyyy").format(pedido_prueba_colorTF.getValue());
		campa.setPedido_prueba_color(TestUtils.toDateWithTime(strDate3));
		} 
		catch (IllegalArgumentException a)
		{
			campa.setPedido_prueba_color(TestUtils.toDateWithTime(""));
		}

		try {
		String strDate4 = new SimpleDateFormat("dd/MM/yyyy").format(ok_prueba_colorTF.getValue());
		campa.setOk_prueba_color(TestUtils.toDateWithTime(strDate4));
		} 
		catch (IllegalArgumentException a)
		{
			campa.setOk_prueba_color(TestUtils.toDateWithTime(""));
		}


		try {
		String strDate5 = new SimpleDateFormat("dd/MM/yyyy").format(llegada_ajustesTF.getValue());
		campa.setLlegada_ajustes(TestUtils.toDateWithTime(strDate5));
		} 
		catch (IllegalArgumentException a)
		{
			campa.setLlegada_ajustes(TestUtils.toDateWithTime(""));
		}


		try {
		String strDate6 = new SimpleDateFormat("dd/MM/yyyy").format(envio_ocTF.getValue());
		campa.setEnvio_oc(TestUtils.toDateWithTime(strDate6));
		} 
		catch (IllegalArgumentException a)
		{
			campa.setEnvio_oc(TestUtils.toDateWithTime(""));
		}


		try {
		String strDate7 = new SimpleDateFormat("dd/MM/yyyy").format(primer_entregaTF.getValue());
		campa.setPrimer_entrega(TestUtils.toDateWithTime(strDate7));
		} 
		catch (IllegalArgumentException a)
		{
			campa.setPrimer_entrega(TestUtils.toDateWithTime(""));
		}

		try {
		String strDate8 = new SimpleDateFormat("dd/MM/yyyy").format(segunda_entregaTF.getValue());
		campa.setSegunda_entrega(TestUtils.toDateWithTime(strDate8));
		} 
		catch (IllegalArgumentException a)
		{
			campa.setSegunda_entrega(TestUtils.toDateWithTime(""));
		}

		try {
		String strDate9 = new SimpleDateFormat("dd/MM/yyyy").format(inicio_instalacionTF.getValue());
		campa.setInicio_instalacion(TestUtils.toDateWithTime(strDate9));
		} 
		catch (IllegalArgumentException a)
		{
			campa.setInicio_instalacion(TestUtils.toDateWithTime(""));
		}

		try {
		String strDate10 = new SimpleDateFormat("dd/MM/yyyy").format(fin_instalacionTF.getValue());
		campa.setFin_instalacion(TestUtils.toDateWithTime(strDate10));
		} 
		catch (IllegalArgumentException a)
		{
			campa.setFin_instalacion(TestUtils.toDateWithTime(""));
		}
		try {
		String strDate11 = new SimpleDateFormat("dd/MM/yyyy").format(envio_cierreTF.getValue());
		campa.setEnvio_cierre(TestUtils.toDateWithTime(strDate11));
		} 
		catch (IllegalArgumentException a)
		{
			campa.setEnvio_cierre(TestUtils.toDateWithTime(""));
		}
		
		try {
		String strDate11 = new SimpleDateFormat("dd/MM/yyyy").format(aprobacion_ocTF.getValue());
		campa.setAprobacion_oc(TestUtils.toDateWithTime(strDate11));
		} 
		catch (IllegalArgumentException a)
		{
			campa.setAprobacion_oc(TestUtils.toDateWithTime(""));
		}
		
		try {	
		fechaOptimaArteTF.setText(TestUtils.fechaToString(campa.getFechaArteOptima()));
		}
		catch (NullPointerException a)
		{
			fechaOptimaArteTF.setText("");
		}
		
		try {	
		fecha_optima_pcTF.setText(TestUtils.fechaToString(campa.getFechaPcOptima()));
		}
		catch (NullPointerException a)
		{
			fecha_optima_pcTF.setText("");
		}

		try {
		fecha_optima_ocTF.setText(TestUtils.fechaToString(campa.getFechaOptimaOC()));
		}
		catch (NullPointerException a)
		{
			fecha_optima_ocTF.setText("");
		}
		
		try {	
		fecha_optima_entregaTF.setText(TestUtils.fechaToString(campa.getFechaOptimaEntrega()));
		}
		catch (NullPointerException a)
		{
			fecha_optima_entregaTF.setText("");
		}

		try {	
			fecha_optima_inicioTF.setText(TestUtils.fechaToString(campa.getFechaOptimaInicio()));
		}
		catch (NullPointerException a)
		{
			fecha_optima_inicioTF.setText("");
		}

		try {	
			fecha_optima_finTF.setText(TestUtils.fechaToString(campa.getFechaOptimaFin()));
		}
		catch (NullPointerException a)
		{
			fecha_optima_finTF.setText("");
		}

		try {	
			arteTF.setText(TestUtils.fechaToString(campa.arte()));
		}
		catch (NullPointerException a)
		{
			arteTF.setText("");
		}
		


		try {	
			okRealTF.setText(TestUtils.fechaToString(campa.okReal()));
		}
		catch (NullPointerException a)
		{
			okRealTF.setText("");
		}

		try {	
			okIdealTF.setText(TestUtils.fechaToString(campa.okIdeal()));
		}
		catch (NullPointerException a)
		{
			okIdealTF.setText("");
		}

		try {
		retraso_ok_colorTF.setText(campa.retraso_okColor());
		}					
		catch (NullPointerException a1)
		{
			retraso_ok_colorTF.setText("");
		}

		
		try {
			retraso_fin_cierreTF.setText(campa.retrasoEnvioCierre());
		}
		catch (NullPointerException a1)
		{ 
			retraso_fin_cierreTF.setText("");
		}

		try {
		retraso_aprobacion_ocTF.setText(campa.retrasoAprobacionOC());
		}
				catch (NullPointerException a1)
		{
			retraso_aprobacion_ocTF.setText("");
		}
		


		try 
		{
		retraso_pedido_pruebaTF.setText((campa.retrasoPedidoPrueba()));
		}
		catch (NullPointerException a1)
		{
			retraso_pedido_pruebaTF.setText("");
		}
		
		
		try 
		{
			retraso_orden_compraTF.setText(campa.retrasoOrdenCompra());
		}					
		catch (NullPointerException a1)
		{
			retraso_orden_compraTF.setText("");
		}
		
		
	
		try {

		retraso_primer_entregaTF.setText(campa.retrasoPrimerEntrega());
		}					
		catch (NullPointerException a1)
		{
			retraso_primer_entregaTF.setText("");
		}
		
		try {
			retraso_segunda_entregaTF.setText(campa.retrasoEntregaFinal());
		}					
		catch (NullPointerException a1)
		{
			retraso_segunda_entregaTF.setText("");
		}
		
		
		try 
		{
			retraso_inicio_colocacionTF.setText(campa.retrasoInicioColocacion());
		}					
		catch (NullPointerException a11)
		{
			retraso_inicio_colocacionTF.setText("");
		}

		try {
		retraso_fin_colocacionTF.setText(campa.retrasoFinColocacion());
		}					
		catch (NullPointerException a11)
		{
		retraso_fin_colocacionTF.setText("");
		}
		
}
public void muestroOptimos(){
	//escondo los campos retrasos;
	retraso_llegada_arteL.setVisible(false);
	retraso_llegada_arteTF.setVisible(false);
	retraso_pedido_pruebaL.setVisible(false);
	retraso_pedido_pruebaTF.setVisible(false);
	retraso_ok_colorL.setVisible(false);
	retraso_ok_colorTF.setVisible(false);
	retraso_aprobacion_ocL.setVisible(false);
	retraso_aprobacion_ocTF.setVisible(false);
	retraso_orden_compraL.setVisible(false);
	retraso_orden_compraTF.setVisible(false);
	retraso_primer_entregaL.setVisible(false);
	retraso_primer_entregaTF.setVisible(false);
	retraso_segunda_entregaL.setVisible(false);
	retraso_segunda_entregaTF.setVisible(false);	
	retraso_inicio_colocacionL.setVisible(false);
	retraso_inicio_colocacionTF.setVisible(false);
	retraso_fin_colocacionL.setVisible(false);
	retraso_fin_colocacionTF.setVisible(false);
	retraso_fin_cierreL.setVisible(false);
	retraso_fin_cierreTF.setVisible(false);
	//muestro campos optimos
	fechaOptimaArteL.setVisible(true);
	fechaOptimaArteTF.setVisible(true);
	fecha_optima_pcL.setVisible(true);
	fecha_optima_pcTF.setVisible(true);
	fecha_optima_ocL.setVisible(true);
	fecha_optima_ocTF.setVisible(true);
	fecha_optima_entregaL.setVisible(true);
	fecha_optima_entregaTF.setVisible(true);
	fecha_optima_inicioL.setVisible(true);
	fecha_optima_inicioTF.setVisible(true);
	fecha_optima_finL.setVisible(true);
	fecha_optima_finTF.setVisible(true);
}
	 


public static void main(String[] args)
	{
		Vista rectObj = new Vista();
	} 	


//asigna a los TF los datos del objeto campaña
public void dameCampa(Campañas c)
		{ 
	campañaTF.setText(c.getNombre_campaña());
	formatoTF.setText(c.getFormatoYcantidad());
	fecha_inicioTF.setText(TestUtils.fechaToString(c.getFecha_inicio()));
	llegada_arteTF.setText(TestUtils.fechaToString(c.getLlegada_arte()));
	pedido_prueba_colorTF.setText(TestUtils.fechaToString(c.getPedido_prueba_color()));
	ok_prueba_colorTF.setText(TestUtils.fechaToString(c.getOk_prueba_color()));
	llegada_ajustesTF.setText(TestUtils.fechaToString(c.getLlegada_ajustes()));
	aprobacion_ocTF.setText(TestUtils.fechaToString(c.getAprobacion_oc()));
	envio_ocTF.setText(TestUtils.fechaToString(c.getEnvio_oc()));
	primer_entregaTF.setText(TestUtils.fechaToString(c.getPrimer_entrega()));
	segunda_entregaTF.setText(TestUtils.fechaToString( c.getSegunda_entrega()));
	inicio_instalacionTF.setText(TestUtils.fechaToString( c.getInicio_instalacion()));
	fin_instalacionTF.setText(TestUtils.fechaToString( c.getFin_instalacion()));
	envio_cierreTF.setText(TestUtils.fechaToString(c.getEnvio_cierre()));

		}

}



