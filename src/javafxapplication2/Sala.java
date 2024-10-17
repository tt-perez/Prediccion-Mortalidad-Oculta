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
public class Sala {
String especialidad;

@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        final Sala other = (Sala) obj;
        return this.especialidad != null ? this.especialidad.equalsIgnoreCase(other.getEspecialidad()) : other.getEspecialidad() == null;
    }

    @Override
    public int hashCode() {
        return this.getEspecialidad() != null ? especialidad.toLowerCase().hashCode() : 0;
    }
 

    public Sala(String especialidad) {
        this.especialidad = especialidad;
    
    }
  
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
            
}
