package ar.brian_ame.vpm

import java.text.SimpleDateFormat
import java.util.Date

class TestUtils {
	static val fechaConHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	def static toDateWithTime(String date) {
		if 	(date != "" ){
			if (date.matches("[1-12]/[1-31]/[2000..3000] [0-23]:[0-59]")){
				return fechaConHora.parse(date)
			}
			else{
				var String d2=(date.concat(" 10:30"))
				return fechaConHora.parse(d2)
				
				
			} 
	}
	else{}
	}
	

		def static fechaToString(Date date) {
			if (date != null){
				return new SimpleDateFormat("dd/MM/yyyy").format(date)
			}
			else {return ""}
			}
	
}
