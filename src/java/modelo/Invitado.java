package modelo;

public class Invitado {
    int invitado_id;
    String invitado_nombre;
    String invitado_estado;

    public Invitado(int invitado_id, String invitado_nombre, String invitado_estado) {
        this.invitado_id = invitado_id;
        this.invitado_nombre = invitado_nombre;
        this.invitado_estado = invitado_estado;
    }

    public Invitado() {
    }

    public int getInvitado_id() {
        return invitado_id;
    }

    public void setInvitado_id(int invitado_id) {
        this.invitado_id = invitado_id;
    }

    public String getInvitado_nombre() {
        return invitado_nombre;
    }

    public void setInvitado_nombre(String invitado_nombre) {
        this.invitado_nombre = invitado_nombre;
    }

    public String getInvitado_estado() {
        return invitado_estado;
    }

    public void setInvitado_estado(String invitado_estado) {
        this.invitado_estado = invitado_estado;
    }

}
