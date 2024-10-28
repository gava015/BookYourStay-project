package co.edu.uniquindio.BookYourStay.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Oferta {
    private String descripcion;
    private Double descuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;


}
