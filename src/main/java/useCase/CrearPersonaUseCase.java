package useCase;

import Modelo.Persona;
import input.CrearPersonaInput;
import output.GuardarPersonaRepositorio;

import java.time.LocalDate;


public class CrearPersonaUseCase implements CrearPersonaInput {
    //implemento el metodo del input en una variable
    private GuardarPersonaRepositorio guardarPersonaRepositorio ;

    //defino el constructor de la clase

    public CrearPersonaUseCase(GuardarPersonaRepositorio guardarPersonaRepositorio){
        this.guardarPersonaRepositorio=guardarPersonaRepositorio;

    }

    @Override
    public Boolean create(String nombre, String apellido, String DNI, LocalDate fechaNacimiento, double altura, int peso) {

        //hacemos un try catch y lanzo las excepciones afuera
        Persona persona;
        try {

            persona =Persona.create(nombre,apellido,DNI,fechaNacimiento,altura,peso);

        }
        catch (PersonaException e){

            System.out.println(e.getMessage());
            return false;

        }



        if(this.guardarPersonaRepositorio.buscarPersona(DNI)){
            //si falla entra y es porque la persona ya existe y tiro una excepsion

            throw new PersonaExisteExceptiion("Persona ya existe");

        }
        //valido si fallo por x motivo preguntando por true o false con un if

        //llamo al metodo del repositorio para guardar la persona

        if(!this.guardarPersonaRepositorio.guardar(persona)){

            throw new RepostiorioException("algo salio mal");

        }


        return true;


    }


}
