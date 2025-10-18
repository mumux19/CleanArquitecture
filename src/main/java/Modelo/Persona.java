package Modelo;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String apellido;
    private String DNI;
    private LocalDate fechaNacimiento;
    private double altura;
    private int peso;

    public static Persona create(String nombre, String apellido, String DNI, LocalDate fechaNacimiento, double altura, int peso) {

        LocalDate fechaActual=LocalDate.now();
        if(nombre.isBlank() || nombre==null){
            throw new PersonaExceptionNombre("El nombre no puede ser nulo ni vacio");

        }

        if(fechaNacimiento.isAfter(fechaActual)){
            throw new PersonaExceptionFecha("La fecha de nacimiento no puede ser despues de la fecha actual");

        }

        int edad= fechaActual.getYear()-fechaNacimiento.getYear();

        if(fechaActual.getMonthValue()< fechaNacimiento.getMonthValue()|| (fechaActual.getMonthValue()== fechaNacimiento.getMonthValue() && fechaActual.getDayOfMonth()<fechaNacimiento.getDayOfMonth())){
            edad--;

        }



        if(edad<18){

            throw new PersonaExceptionEdad("La persona no puede ser menor de edad");
        }

        return new Persona(nombre, apellido, DNI, fechaNacimiento, altura, peso);
    }



    private Persona(String nombre, String apellido, String DNI, LocalDate fechaNacimiento, double altura, int peso) {


        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
        this.altura = altura;
        this.peso = peso;

    }


    public String getApellido() {
        return this.apellido;
    }

}
