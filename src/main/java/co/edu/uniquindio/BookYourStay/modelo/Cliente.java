package co.edu.uniquindio.BookYourStay.modelo;

public class Cliente extends Usuario{
    public Cliente(String correo, String contraseña, String identificacion, String nombre, String telefono, BilleteraVirtual billeteraVirtual) {
        super(correo, contraseña, identificacion, nombre, telefono);
        this.billeteraVirtual = billeteraVirtual;
    }

    private BilleteraVirtual billeteraVirtual;
}
