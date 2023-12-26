package interfaces;

import java.util.List;
import modelo.Invitado;

public interface ICRUD {
    public List listarInvitado();
    public Invitado mostrarInvitado(int _id);
    public boolean agregarInvitado(Invitado invitado);
    public boolean altaInvitado(String _id);
    public boolean bajaInvitado(String _id);
}
