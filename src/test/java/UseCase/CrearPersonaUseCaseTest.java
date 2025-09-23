package UseCase;
import Modelo.Persona;
import input.CrearPersonaInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import output.GuardarPersonaRepositorio;
import useCase.CrearPersonaUseCase;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)


public class CrearPersonaUseCaseTest {
    //defino el mock

    @Mock
    GuardarPersonaRepositorio repositorio;


    //defino el test
    //camino feliz
    @Test
    void CrearPersona_Success(){
        //arrange
        CrearPersonaInput usecase= new CrearPersonaUseCase(repositorio);
        //el parametro que le pasamos a mockito (DNI)tiene que ser el mismo que el act
        when(repositorio.buscarPersona("43611353")).thenReturn(false);
        when(repositorio.guardar(any(Persona.class))).thenReturn(true);
       //act
        //esto devuelve un booleano
       boolean resultado= usecase.create("agustin","gomez","43611353", LocalDate.of(2000,2,5),1.60,90);


       //assert

        Assertions.assertTrue(resultado);

    }

    @Test
    void CrearPersona_AtributosInvalidos_Error(){
        CrearPersonaInput usecase=new CrearPersonaUseCase(repositorio);

        //espera que nunca llame a los metodos buscar y guardar
        verify(repositorio,never()).buscarPersona(any());
        verify(repositorio,never()).guardar(any());

        //act
        //esto devuelve un booleano
        boolean resultado= usecase.create("agustin","gomez","43611353", LocalDate.of(2000,2,5),1.60,90);


        //assert

        Assertions.assertThrows(ExceptionPersona.class, )

    }

    @Test
    void CrearPersona_ExistePersona_Error(){
        CrearPersonaInput usecase=new CrearPersonaUseCase(repositorio);


       when(repositorio.buscarPersona("43611353")).thenReturn(true);


        //act
        //esto devuelve un booleano
        boolean resultado= usecase.create("agustin","gomez","43611353", LocalDate.of(2000,2,5),1.60,90);


        //assert

        Assertions.assertTrue(resultado);

    }


}
