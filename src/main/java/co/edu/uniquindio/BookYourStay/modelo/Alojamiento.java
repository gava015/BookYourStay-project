package co.edu.uniquindio.BookYourStay.modelo;

import co.edu.uniquindio.BookYourStay.modelo.Enums.Servicio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public abstract class  Alojamiento {
    protected String nombre;
    protected String cuidad;
    protected String descripcion;
    protected String imagen;
    protected Double precio;
    protected int capacidadMax;
    protected List<Servicio> listaServicios;
    protected List<Oferta> listaOfertas;
    protected List<Reseña> listaReseñas;
    
    abstract String calcularValorTotal();

}