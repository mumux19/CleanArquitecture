package input;

import Modelo.Persona;

import java.time.LocalDate;

public interface CrearPersonaInput {
    //creo la persona y hago con un metodo abstracto y devolvemos algun dato, y lo implementamos en una clase en caso de uso
    Boolean create(String nombre,String apellido, String DNI,LocalDate fechaNacimiento,double altura,int peso);


}
