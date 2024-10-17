/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author racli
 */
public class Paciente {
   
    String paciente;
    String edad;
    String sexo;
    String raza;
    String evolucion;
    String limitacion;
    int tiempovam;
    String fingH;
    String fingU;
    String fegU;
    String fegH;
    String tipovia;
    int apache;
    Sala salaegreso;
    Sala saladefuncion;
    double mortalidad;
 ArrayList<Causa> causas;
    ArrayList<Diagnostico> diagIngreso;
    ArrayList<Diagnostico> diagEgreso;
    ArrayList<Procedimiento> necropsia;
    ArrayList<Procedimiento> defuncion;
    public double getMortalidad() {
        return mortalidad;
    }

    public void setMortalidad(double mortalidad) {
        this.mortalidad = mortalidad;
    }
   

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getLimitacion() {
        return limitacion;
    }

    public void setLimitacion(String limitacion) {
        this.limitacion = limitacion;
    }

    public int getTiempovam() {
        return tiempovam;
    }

    public void setTiempovam(int tiempovam) {
        this.tiempovam = tiempovam;
    }

    public String getFingH() {
        return fingH;
    }

    public void setFingH(String fingH) {
        this.fingH = fingH;
    }

    public String getFingU() {
        return fingU;
    }

    public void setFingU(String fingU) {
        this.fingU = fingU;
    }

    public String getFegU() {
        return fegU;
    }

    public void setFegU(String fegU) {
        this.fegU = fegU;
    }

    public String getFegH() {
        return fegH;
    }

    public void setFegH(String fegH) {
        this.fegH = fegH;
    }

    public String getTipovia() {
        return tipovia;
    }

    public void setTipovia(String tipovia) {
        this.tipovia = tipovia;
    }

    public int getApache() {
        return apache;
    }

    public void setApache(int apache) {
        this.apache = apache;
    }

    public Sala getSalaegreso() {
        return salaegreso;
    }

    public void setSalaegreso(Sala salaegreso) {
        this.salaegreso = salaegreso;
    }

    public Sala getSaladefuncion() {
        return saladefuncion;
    }

    public void setSaladefuncion(Sala saladefuncion) {
        this.saladefuncion = saladefuncion;
    }

    public ArrayList<Causa> getCausas() {
        return causas;
    }

    public void setCausas(ArrayList<Causa> causas) {
        this.causas = causas;
    }

    public ArrayList<Diagnostico> getDiagIngreso() {
        return diagIngreso;
    }

    public void setDiagIngreso(ArrayList<Diagnostico> diagIngreso) {
        this.diagIngreso = diagIngreso;
    }

    public ArrayList<Diagnostico> getDiagEgreso() {
        return diagEgreso;
    }

    public void setDiagEgreso(ArrayList<Diagnostico> diagEgreso) {
        this.diagEgreso = diagEgreso;
    }

    public ArrayList<Procedimiento> getNecropsia() {
        return necropsia;
    }

    public void setNecropsia(ArrayList<Procedimiento> necropsia) {
        this.necropsia = necropsia;
    }

    public ArrayList<Procedimiento> getDefuncion() {
        return defuncion;
    }

    public void setDefuncion(ArrayList<Procedimiento> defuncion) {
        this.defuncion = defuncion;
    }

    public String getEvolucion() {
        return evolucion;
    }

    public void setEvolucion(String evolucion) {
        this.evolucion = evolucion;
    }

    public Paciente(String paciente, String edad, String sexo, String raza) {
        this.paciente = paciente;
        this.edad = edad;
        this.sexo = sexo;
        this.raza = raza;

    }
 public Paciente(Paciente a) {

    this.paciente = a.getPaciente();
        this.edad = a.getEdad();
        this.sexo = a.getSexo();
        this.raza = a.getRaza();
        this.evolucion = a.getEvolucion();
  causas=new ArrayList<>(1);
   diagIngreso=new ArrayList<>(1);
  diagEgreso=new ArrayList<>(1);
  necropsia=new ArrayList<>(1);
   defuncion=new ArrayList<>(1);   
    }
    public Paciente(String paciente, String edad, String sexo, String raza, String evolucion) {
        this.paciente = paciente;
        this.edad = edad;
        this.sexo = sexo;
        this.raza = raza;
        this.evolucion = evolucion;
  causas=new ArrayList<>(1);
   diagIngreso=new ArrayList<>(1);
  diagEgreso=new ArrayList<>(1);
  necropsia=new ArrayList<>(1);
   defuncion=new ArrayList<>(1);   
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.paciente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        return true;
    }

}
