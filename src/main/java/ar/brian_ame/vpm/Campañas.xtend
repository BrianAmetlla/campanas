package ar.brian_ame.vpm

import java.util.ArrayList
import java.util.Arrays
import java.util.Calendar
import java.util.Date
import org.eclipse.xtend.lib.annotations.Accessors

import static extension ar.brian_ame.vpm.TestUtils.*

@Accessors 

class Campañas   {
	String nombre_campaña
	String formatoYcantidad
	Date fecha_inicio
	Date llegada_arte
	Date pedido_prueba_color
	Date ok_prueba_color
	Date llegada_ajustes
	Date aprobacion_oc
	Date envio_oc
	Date primer_entrega
	Date segunda_entrega
	Date inicio_instalacion
	Date fin_instalacion
	Date envio_cierre
	ArrayList<String> feriados = new ArrayList<String>(Arrays.asList("01/01/2015", "16/02/2015", "17/02/2015", "23/03/2015",
		 "24/03/2015", "02/04/2015","03/04/2015", "10/05/2015", "25/05/2015", "20/06/2015", "09/07/2015", "17/08/2015", 
		 "12/10/2015", "23/11/2015", "07/12/2015", "08/12/2015", "25/12/2015"))
	//ArrayList<String> feriados  = new ArrayList<String>()
	

	
	
	def diaHabil(Date d1){
		//inicializo la variable c como calendar para chequear que dia de la semana es:
		var Calendar c = Calendar.getInstance
		//le asigno la fecha de inicio
		c.time = d1
		//asigno a day of week el dia de la fecha
		var int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
	   	
	   	
	   	switch (dayOfWeek) 
	   	{
		    case Calendar.SATURDAY : return false
		    case Calendar.SUNDAY : return false
		    default: return true
		}
	
	}


	new(){
		this.nombre_campaña = ""
		this.formatoYcantidad = ""
		this.fecha_inicio =  null
		this.llegada_arte =  null
		this.pedido_prueba_color =  null
		this.ok_prueba_color =  null
		this.aprobacion_oc =  null
		this.envio_oc =  null
		this.primer_entrega = null
		this.inicio_instalacion = null
		this.fin_instalacion = null
		this.envio_cierre = null
		this.llegada_ajustes = null
		this.segunda_entrega = null
	}

	new (String nombre, String formato, Date fecha_inicio, Date llegada_arte, Date pedido_prueba_color, Date ok_prueba_color, 
			Date llegada_ajustes, Date aprobacion_oc, Date envio_oc, Date primer_entrega, 
			Date segunda_entrega, Date inicio_instalacion, Date fin_instalacion, 
			Date envio_cierre)
			 {
		this.nombre_campaña = nombre
		this.formatoYcantidad = formato
		this.fecha_inicio =  fecha_inicio
		this.llegada_arte =  llegada_arte
		this.pedido_prueba_color =  pedido_prueba_color
		this.ok_prueba_color =  ok_prueba_color
		this.aprobacion_oc =  aprobacion_oc
		this.envio_oc =  envio_oc
		this.primer_entrega =  primer_entrega
		this.inicio_instalacion =  inicio_instalacion
		this.fin_instalacion =  fin_instalacion
		this.envio_cierre = envio_cierre
		if(llegada_ajustes != null){  this.llegada_ajustes = llegada_ajustes}
		if(segunda_entrega != null){  this.segunda_entrega = segunda_entrega}
	}

	def getFechaOptimaEntrega() {
		var Calendar c = Calendar.getInstance
		//Dias que me dijeron que tienen que estar antes para que sea de forma optima q se sube la campaña
		//chequeo si tengo iinicializada la fecha optima de oc
		if (this.getFechaOptimaOC != null){
		c.time = this.getFechaOptimaOC()
		for (var int i = 1; i <=2 ; i++){	
			if (!this.diaHabil(c.time))
				{
					i=i-1
				}
			c.add(Calendar.DATE, 1)
			}
		while (!this.diaHabil(c.getTime))
			{
				c.add(Calendar.DATE, 1)		
			}	
	
	return (c.getTime)
	}
	else { return null}
	}

	def getFechaOptimaInicio() {
		var Calendar c = Calendar.getInstance
		//Dias que me dijeron que tienen que estar antes para que sea de forma optima q se sube la campaña
		//si no tengo fecha optima entrega retorno null
		if(this.getFechaOptimaEntrega != null){
		c.time = this.getFechaOptimaEntrega
			if (this.diaHabil(c.time)){c.add(Calendar.DATE, 1)}
	
		while (!this.diaHabil(c.getTime))
			{
				c.add(Calendar.DATE, 1)		
			}	
	return (c.getTime)
	}
	else{return null} 
	}


	def getFechaOptimaFin() {
		var Calendar c = Calendar.getInstance
		//Dias que me dijeron que tienen que estar antes para que sea de forma optima q se sube la campaña
		if (this.getFechaOptimaOC !=null){
		c.time = this.getFechaOptimaOC
		for (var int i = 1; i <=6 ; i++)
			{	
			if (!this.diaHabil(c.time))
			{
				i=i-1
			}
			c.add(Calendar.DATE, 1)	
			}
		while (!this.diaHabil(c.getTime))
			{
				c.add(Calendar.DATE, 1)		
			}	
	
	return (c.getTime)
	}
	else {return null}
	}


	def getFechaArteOptima(){
		
		//inicializo la variable calendario
		var Calendar c = Calendar.getInstance;
		var Calendar c2 = Calendar.getInstance;
		//Dias que me dijeron que tienen que estar antes para que sea de forma optima q se sube la campaña
		var int dias_previos = 7
		//le asigno la fecha de inicio
		if (this.fecha_inicio != null){
		c.time = this.fecha_inicio
		c2.time = c.time
	        for (var int i = 1; i <= dias_previos;i++) 
	        {
	
				if(!this.diaHabil(c.time))
				{
					//el siguiente if es por si arranca un dia no habil, para que den bien las fechas
					if(c.time==c2.time)
					{
						i=i+1
					}
					i=i-1
				}
				c.add(Calendar.DATE, -1)
			}
		//este while es por si luego de que reste los 7 dias, me cae un dia no habil, lo muevo hasta el anterior habil.
		while (!this.diaHabil(c.getTime))
			{
				c.add(Calendar.DATE, -1)		
			}
			
	return (c.getTime)
	}
	else {return null}
}

	def okIdeal(){
			var Calendar c = Calendar.getInstance;
			if (this.fechaArteOptima != null){
			c.time = this.fechaArteOptima
			c.add(Calendar.DATE, 1)
			while (!this.diaHabil(c.getTime))
				{
					c.add(Calendar.DATE, 1)		
				}	
		
		return (c.getTime)
	}
	else {return null}
	}
	
	/*getFechaPC
	chequea que no hayan habido ajustes en el arte, si hubo, cambia la fecha a la nueva fecha con 
	las modificaciones.Despues sigue con el chequeo de horarios
	si llego despues de las 15 horas, se le suman 2 dias despues de la llegada del arte
	si llego antes de las 15, es al dia siguiente de la llegada del arte  */
	def getFechaPcOptima(){ 
		var Calendar c = Calendar.getInstance;
		if (this.llegada_arte != null){
		c.time = this.llegada_arte
		if(this.retrasoLlegadaArte <= 0.toString)
			{
				return this.okIdeal
			}
		else
			{
				if(this.llegada_ajustes != null )
				{
					c.time=this.llegada_ajustes 
					if(c.get(Calendar.HOUR_OF_DAY) < 15)
						{
							c.add(Calendar.DATE,1)
						}
					else
						{
							c.add(Calendar.DATE, 2)
						}
				}
				else  
					{
						if(c.get(Calendar.HOUR_OF_DAY) < 15)
							{
								c.add(Calendar.DATE,1)
							}
						else
							{
								c.add(Calendar.DATE, 2)
			 				}
				
				}
			}
			
			//Me fijo que el dia siguiente sea habil, de no ser asi, lo muevo hata el primer dia habil
			while (!this.diaHabil(c.getTime))
				{
					c.add(Calendar.DATE,1)	
				}
	return (c.getTime) 
	}
	else {return null}
	}

	//fecha real del arte
	def arte(){
		if (llegada_arte != null){
		var Calendar c = Calendar.getInstance
		if (this.llegada_arte != null) {
		c.time = this.llegada_arte
		if(this.llegada_ajustes != null )
			{
				c.time=this.llegada_ajustes
				if(c.get(Calendar.HOUR_OF_DAY) >= 15)
					{
						c.add(Calendar.DATE,1)
					}
			}
		else 
			{
				if(c.get(Calendar.HOUR_OF_DAY) >= 15)
				{
					c.add(Calendar.DATE,1)
				}
			}
			
		//Me fijo que el dia siguiente sea habil, de no ser asi, lo muevo hata el primer dia habil
		while (!this.diaHabil(c.getTime))
			{
				c.add(Calendar.DATE,1)	
			}	
		return (c.getTime)
	}
	else {return null}
	}
	else {return null}
	}

	def okReal(){ 
			var Calendar c = Calendar.getInstance();
			if (ok_prueba_color != null){
			c.time = ok_prueba_color
			if(c.get(Calendar.HOUR_OF_DAY) >= 15)
				{
					c.add(Calendar.DATE,1)
				}
			while (!this.diaHabil(c.getTime))
				{
					c.add(Calendar.DATE,1)	
				}
		return (c.getTime())
	}
	else {return null}
	}

	
//                   PC     OK
def retrasoAccion(Date d1, Date d2){

		var Calendar c = Calendar.getInstance();
		var Calendar c2 = Calendar.getInstance();
		c.time=d1
		c2.time=d2
		
		d1.hours= 0 
		d2.hours = 0
		var dias_totales = ( (d1.getTime() - d2.getTime()) / (1000 * 60 * 60 * 24));
		//System.out.println(dias_totales)
		
		var long dias_habiles = 0
		//System.out.println(dias_totales)
		if(dias_totales > 0){
			{for (var int i = 1; i <= dias_totales;i++) {
					if(this.diaHabil(c.time)){
						dias_habiles = dias_habiles + 1
						//System.out.println(c.time)
						c.add(Calendar.DATE,-1)}
					else{c.add(Calendar.DATE,-1)}
						}
					}
			return (-dias_habiles)
				
			}
		else
		{
			dias_totales = -dias_totales
			for (var int i = 1; i <= dias_totales;i++) {
				if(this.diaHabil(c.time)){
				//System.out.println(c.time)
				dias_habiles = dias_habiles + 1
				c.add(Calendar.DATE,1)
				}
				else{c.add(Calendar.DATE,1)}
				
				}
       		}
      // System.out.println(dias_habiles)
      //chequeo q en la diferencia de dias, el ultimo dia no caiga dia no habil, de ser asi, lo muevo hasta la primer fecha habil anterior
		while (!this.diaHabil(c.time))
		{c.add(Calendar.DATE,-1); dias_habiles = dias_habiles -1} 
		return dias_habiles
}    
	
//diferencia entre la fecha real de aprobacion del color y la fecha real del arte
def retraso_okColor(){
	if (getFechaPcOptima != null && okReal != null)
	{
	retrasoAccion(this.getFechaPcOptima,this.okReal).toString
	}
	else {return ""}
	}

	
	
def getFechaOptimaOC() {
	if (retraso_okColor != null){
  if(this.retraso_okColor() <= 0.toString){
	return this.getFechaPcOptima()	
	}
	else
	{
		if(this.arte>this.okReal())
		{return this.arte()}
		else {
		return this.okReal()}
	}
}
else {return null}
}
  
def retrasoOrdenCompra(){
	if (getFechaOptimaOC != null && envio_oc != null){
retrasoAccion(this.getFechaOptimaOC(),this.envio_oc).toString	
 }
 else {return ""}
    }    

def retrasoAprobacionOC(){

	if (aprobacion_oc != null && ok_prueba_color != null )	
	{
	return ( (aprobacion_oc.getTime() - this.ok_prueba_color.getTime()) / (1000 * 60 * 60 * 24)).toString();
	}
	else {return ""}
} 
	
def retrasoLlegadaArte(){

if( this.getFechaArteOptima() != null && arte != null){
retrasoAccion(this.getFechaArteOptima(),this.arte()).toString	
 }
 else {return ""}
    }
   
def retrasoPedidoPrueba(){

		if(this.pedido_prueba_color != null && llegada_arte != null)
		{
			return ((this.pedido_prueba_color.getTime() - this.llegada_arte.getTime()) / (1000 * 60 * 60 * 24)).toString();
 		}
 		else {return ""}
    }     

def retrasoPrimerEntrega(){
	if (getFechaOptimaEntrega.toString != null && primer_entrega != null)
	{
retrasoAccion(this.getFechaOptimaEntrega(),this.primer_entrega).toString
 	 }
 	 else{return ""}
   } 


def retrasoEntregaFinal(){

	if(this.segunda_entrega != null )
	{
		retrasoAccion(this.getFechaOptimaEntrega(),this.segunda_entrega).toString
		
		 
	}
	else{	
		return ""			
	}
}     


def retrasoInicioColocacion(){

	if(getFechaOptimaInicio().toString != null  && this.inicio_instalacion != null)
		{
		 retrasoAccion(this.getFechaOptimaInicio(),this.inicio_instalacion).toString
    	}
    	else{return ""}
    	}     
      
def retrasoFinColocacion(){
	
	if(!this.fin_instalacion.toString.isNullOrEmpty){
		retrasoAccion(this.getFechaOptimaFin,this.fin_instalacion).toString
		}
	else {
		var Calendar c2 = Calendar.getInstance();
		retrasoAccion(this.getFechaOptimaFin,c2.time).toString
		 
		}
	

}     



	def retrasoEnvioCierre(){
				if(this.envio_cierre!= null  && this.ok_prueba_color != null)
				{
		return ((this.envio_cierre.getTime() - this.ok_prueba_color.getTime()) / (1000 * 60 * 60 * 24)-9).toString;
				}
				else
				return ""
    }
    
    
    
	def darEstadoArray(){
			var ArrayList<String> estado = new ArrayList<String>(Arrays.asList(
			nombre_campaña, formatoYcantidad, fecha_inicio.fechaToString,fechaArteOptima.fechaToString,
				 llegada_arte.fechaToString,fechaPcOptima.fechaToString, pedido_prueba_color.fechaToString, ok_prueba_color.fechaToString,
				 llegada_ajustes.fechaToString, fechaOptimaOC.fechaToString, aprobacion_oc.fechaToString,
				 envio_oc.fechaToString, fechaOptimaEntrega.fechaToString, primer_entrega.fechaToString,
				 segunda_entrega.fechaToString, fechaOptimaInicio.fechaToString, inicio_instalacion.fechaToString,
				 fechaOptimaFin.fechaToString, fin_instalacion.fechaToString, envio_cierre.fechaToString,
				 retrasoLlegadaArte, retrasoPedidoPrueba, retraso_okColor, retrasoAprobacionOC,
				 retrasoOrdenCompra, retrasoPrimerEntrega, retrasoEntregaFinal, retrasoInicioColocacion,
				 retrasoFinColocacion, retrasoEnvioCierre, arte.fechaToString, okReal.fechaToString, okIdeal.fechaToString))
				 			 
	 return estado
	}
	
	
		
		
		
		
		
} 
	
	
	









