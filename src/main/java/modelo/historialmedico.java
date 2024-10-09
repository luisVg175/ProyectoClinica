
package modelo;


public class historialmedico {
    private int codH;
    private String fechaC;
    private Double peso;
    private Double talla;
    private String tipoSangre;
    private Double presionAlte;
    private String diagnostico;

    public int getCodH() {
        return codH;
    }

    public void setCodH(int codH) {
        this.codH = codH;
    }

    public String getFechaC() {
        return fechaC;
    }

    public void setFechaC(String fechaC) {
        this.fechaC = fechaC;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getTalla() {
        return talla;
    }

    public void setTalla(Double talla) {
        this.talla = talla;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public Double getPresionAlte() {
        return presionAlte;
    }

    public void setPresionAlte(Double presionAlte) {
        this.presionAlte = presionAlte;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    
    
}
