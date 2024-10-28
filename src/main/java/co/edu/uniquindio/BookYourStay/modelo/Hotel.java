package co.edu.uniquindio.BookYourStay.modelo;

import java.util.ArrayList;
import java.util.List;


public class Hotel extends Alojamiento{
    private List<Habitacion> habitaciones;

    public Hotel(List<Habitacion> habitaciones) {
        habitaciones = new ArrayList<>();
    }

    @Override
    String calcularValorTotal() {
        return null;
    }
}
