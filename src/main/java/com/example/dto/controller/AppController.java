package com.example.dto.controller;

import com.example.dto.Inquilino;
import com.example.dto.Propiedad;
import com.example.dto.PropiedadDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping ("/propiedad/{id}")//id simulada como que recibimos una solicitud de id
    /*Mandamos la respuestra con ResponseBody*/
    @ResponseBody
    //Devolvemos el objeto DTO, lo cual llamamos a la clase PropiedadDTO
    public PropiedadDTO devolverPropiedad(@PathVariable Long id){
        /*A traves de la id buscamos la propiedad en cuestion
        * tambien traemos al inquilino asociado a la propiedad*/

        //Creamos la propiedad -> prop
        Propiedad prop = new Propiedad(123123L, "Casa", "308 Negro Arroyo Lane",
                200.0,40000.0);
        //tambien creamos el inquilino -> inqui
        Inquilino inqui = new Inquilino(1L, "12345678", "Walter", "White",
                "Profesor de Quimica");

        /*Creamos una instancia propiedadDTO*/
        PropiedadDTO propiDTO = new PropiedadDTO();

        /*Ahora unificamos dentro de propiedadDTO
        * los datos que necesitamos de propiedad
        * como de inquilino para devolver al front*/
        //Datos de -> propiedad con -> prop
        propiDTO.setId_propiedad(prop.getId_propiedad());
        propiDTO.setTipo_propiedad(prop.getTipo_propiedad());
        propiDTO.setDireccion(prop.getDireccion());
        propiDTO.setValor_alquiler(prop.getValor_alquiler());
        //Datos de -> Inquilino con -> inqui
        propiDTO.setNombre(inqui.getNombre());
        propiDTO.setApellido(inqui.getApellido());

        //Devolvemos los datos
        return propiDTO;

    }


    /*Respuesta de POSTMAN*/
/*
	{
    "id_propiedad": 123123,
    "tipo_propiedad": "Casa",
    "direccion": "308 Negro Arroyo Lane",
    "valor_alquiler": 40000.0,
    "nombre": "Walter",
    "apellido": "White"
}
*/

}
