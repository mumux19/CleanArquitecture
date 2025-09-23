package output;

import Modelo.Persona;

public interface GuardarPersonaRepositorio {
    //guardo el objeto con el metodo abstracto y podria devolver una excepsion
    boolean guardar(Persona persona);
    //implemento buscar persona

    Boolean buscarPersona(String DNI);


}
