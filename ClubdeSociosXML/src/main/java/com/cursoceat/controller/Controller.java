package com.cursoceat.controller;


import java.io.File;
import com.cursoceat.xml.schema.Club;
import com.cursoceat.xml.schema.Club.Socio;

//import com.cursoceat.xml.schema.Club;
//import com.cursoceat.xml.schema.Club.Socio;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Controller {

	public static void main(String[] args) throws JAXBException{
		// TODO Auto-generated method stub
		escribirXML();
	}
	public static void leerXML() throws JAXBException{
	    File miArchivo=new File("C:\\Users\\PROGRAMACION\\Desktop\\miClub.xml");
	    /**
		 * desAgrupar xml marshaller es leer un xml a partir de un archivo
		 * 1. crear el contexto
		 * 2. leer o desagrupar a partir de un archivo  xml
		 */
		JAXBContext miContexto=JAXBContext.newInstance(Club.class);
		
		Unmarshaller miLectura=miContexto.createUnmarshaller();
		/** (Hacemos un casting de club) , creamos el objeto club de socios a partir de la lectura que ha echo el unmarsahall */
		Club socios=(Club)miLectura.unmarshal(miArchivo);
		/*Al ser una coleccion, lo leemos con un for each*/
		for(Socio s:socios.getSocio()) {
			System.out.println(s.getIdSocio());
			System.out.println(s.getNombreSocio());
			System.out.println(s.getDireccion());
			System.out.println(s.getFechaAlta());			
		}
		
	}
	public static void escribirXML() throws JAXBException {
		/**creamos una colecdcion que nos permita guardar los datos de los socio leidos del xML*/
		Club miClub=new Club();
		Socio socio1=new Socio();
	//	socio1.setIdSocio(1);
		socio1.setNombreSocio("Victor");
		socio1.setDireccion("Campo.2");
		socio1.setFechaAlta("01-01-2021");
		miClub.getSocio().add(socio1);
		
		Socio socio2=new Socio();
//		socio2.setIdSocio(2);
		socio2.setNombreSocio("Victoria");
		socio2.setDireccion("Campo.20");
		socio2.setFechaAlta("01-01-2020");
		miClub.getSocio().add(socio2);
		
		Socio socio3=new Socio();
//		socio3.setIdSocio(3);
		socio3.setNombreSocio("Monica");
		socio3.setDireccion("Campo.102");
		socio3.setFechaAlta("01-01-2021");
		miClub.getSocio().add(socio3);
		/**
		 * Agrupar xml marshaller es crear un xml a partir de unos datos:
		 * 1. crear el contexto
		 * 2. crear a partir de ese contexto el xml
		 */
		JAXBContext miContexto=JAXBContext.newInstance(Club.class);
		/* creamos el agrupamiento */
		Marshaller miLectura=miContexto.createMarshaller();
		/* indicamos el formato como se genera el agrupamiento, con JASB:formatedd_output nos guarda el archivo con estructura organizada XML*/
		miLectura.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		/**mostramos por pantalla*/
		miLectura.marshal(miClub, System.out);
		/** crear un archivo a partir de los objetos creados */
		miLectura.marshal(miClub, new File("C:\\Users\\PROGRAMACION\\Desktop\\miClub.xml"));
	}

}



