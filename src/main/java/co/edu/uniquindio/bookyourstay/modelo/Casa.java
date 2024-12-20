package co.edu.uniquindio.bookyourstay.modelo;

import co.edu.uniquindio.bookyourstay.enums.Servicio;
import co.edu.uniquindio.bookyourstay.utils.FechaUtil;

import java.time.LocalDate;
import java.util.List;

public class Casa extends Alojamiento {

    public Casa(String id, String nombre, String ciudad, String descripcion, String urlImagen, double precioPorNoche,
                int capacidadMax, Double costoAseoMantenimiento, List<Servicio> listaServicios) {
        this.id = id;
        this.nombre = nombre;
        this.cuidad = ciudad;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.precioPorNoche = precioPorNoche;
        this.capacidadMax = capacidadMax;
        this.costoAseoMantenimiento = costoAseoMantenimiento;
        this.listaServicios = listaServicios;
    }

    @Override
    double calcularValorTotal(LocalDate fechaInicio, LocalDate fechaFinal, int numeroHuespedes) {
        int diasReserva = FechaUtil.obtenerDiferenciaEnDias(fechaInicio, fechaFinal);
        return (precioPorNoche * numeroHuespedes * diasReserva) + costoAseoMantenimiento;
    }
}
