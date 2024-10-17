/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;


/**
 *
 * @author racli
 */
public class Procedimiento {
    String causa;
    String tipo;

    
@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        final Procedimiento other = (Procedimiento) obj;
        return this.causa != null ? this.causa.equalsIgnoreCase(other.getCausa()) : other.getCausa() == null;
    }

    @Override
    public int hashCode() {
        return this.getCausa() != null ? causa.toLowerCase().hashCode() : 0;
    }
 

    public Procedimiento(String causamuerte, String tipo) {
        this.causa = causamuerte;
        this.tipo = tipo;
    }
 public Procedimiento(String causa) {
        this.causa = causa;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
