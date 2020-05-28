package datos;

import java.io.Serializable;

public class Habitacion implements Serializable{
    private int id;
    private int numero;
    private int habitaciones;
    private int banios;
    private boolean amueblada;
    private boolean intYcab;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getBanios() {
        return banios;
    }

    public void setBanios(int banios) {
        this.banios = banios;
    }

    public boolean isAmueblada() {
        return amueblada;
    }

    public void setAmueblada(boolean amueblada) {
        this.amueblada = amueblada;
    }

    public boolean isIntYcab() {
        return intYcab;
    }

    public void setIntYcab(boolean intYcab) {
        this.intYcab = intYcab;
    }

    @Override
    public String toString() {
        return "Habitacion: " + numero + "\nCuartos: "+this.habitaciones +"\nBaños: "+this.banios;
    }
    
    
}
