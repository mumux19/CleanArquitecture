package Modelo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PersonaTest {

    @Test
    public void IntanciarPersona_AtributosNoNulo(){

        Persona nuevaPersona=Persona.create("Agustin","Gomez","43611353", LocalDate.of(2001,6,2),1.70,100);

        Assertions.assertNotNull(nuevaPersona);
        Assertions.assertEquals("Gomez",nuevaPersona.getApellido());
    }

    @Test
    public void create_nombreVacioONulo_execption(){

        PersonaExceptionNombre exception=Assertions.assertThrows(PersonaExceptionNombre.class, ()->Persona.create(" ","Gomez","43611353",LocalDate.of(2001,6,2),1.70,90));
        Assertions.assertEquals("El nombre no puede ser nulo ni vacio", exception.getMessage());

    }



    @Test
    public void create_EdadIncorrecta(){


        PersonaExceptionEdad exception=Assertions.assertThrows(PersonaExceptionEdad.class, ()->Persona.create("Agustin","Gomez","43611353",LocalDate.of(2010,6,2),1.40,93));


        Assertions.assertEquals("La persona no puede ser menor de edad", exception.getMessage());



    }

    @Test
    public void create_fechaNacimientoIncorrecta(){

        PersonaExceptionFecha exceptionFecha= Assertions.assertThrows(PersonaExceptionFecha.class, ()-> Persona.create("Agustin","Gomez","43611363",LocalDate.of(2025,12,2),1.70,80));

        Assertions.assertEquals("La fecha de nacimiento no puede ser despues de la fecha actual",exceptionFecha.getMessage());

    }


}
