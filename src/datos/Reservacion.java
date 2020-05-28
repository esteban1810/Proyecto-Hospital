package datos;

import java.io.Serializable;
import java.util.Date;

public class Reservacion implements Serializable{
    int id;
    int id_habitacion;
    int id_cliente;
    Date fechaReservacion;
    Date fechaEntrada;
    Date fechaSalida;
    String horaReservacion;

    public void setId(int id) {
        this.id = id;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    

    public void setHoraReservacion(String horaReservacion) {
        this.horaReservacion = horaReservacion;
    }

    public int getId() {
        return id;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getHoraReservacion() {
        return horaReservacion;
    }

    public Date getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(Date fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
