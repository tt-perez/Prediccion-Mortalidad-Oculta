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
public class Causa {
    String causa;
    String clasific;
@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        final Causa other = (Causa) obj;
        return this.causa != null ? this.causa.equalsIgnoreCase(other.getCausa()) : other.getCausa() == null;
    }

    @Override
    public int hashCode() {
        return this.getCausa() != null ? causa.toLowerCase().hashCode() : 0;
    }
 

    public Causa(String causa, String clasific) {
        this.causa = causa;
        this.clasific = clasific;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getClasific() {
        return clasific;
    }

    public void setClasific(String clasific) {
        this.clasific = clasific;
    }
    
}
