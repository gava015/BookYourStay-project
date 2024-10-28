package co.edu.uniquindio.BookYourStay.modelo;

import co.edu.uniquindio.BookYourStay.modelo.Enums.Estado;

import java.time.LocalDate;

public class Reserva {

    private Cliente cliente;
    private Alojamiento alojamiento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String total;
    private Estado estadoReserva;

}
