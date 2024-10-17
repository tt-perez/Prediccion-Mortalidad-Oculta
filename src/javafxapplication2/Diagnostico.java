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
public class Diagnostico {
    public String valor;

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        final Diagnostico other = (Diagnostico) obj;
        return this.valor != null ? this.valor.equalsIgnoreCase(other.getValor()) : other.getValor()== null;
    }

    @Override
    public int hashCode() {
        return this.getValor()!= null ? valor.toLowerCase().hashCode() : 0;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String enfermedad) {
        this.valor = enfermedad;
    }

    public Diagnostico(String enfermedad) {
        this.valor = enfermedad;
    }
}
