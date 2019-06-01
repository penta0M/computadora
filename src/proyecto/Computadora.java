package proyecto;

/**
 *
 * @author poolm
 */
public class Computadora {
    
    String placaBase,procesador,tarjetaVideo,discoDuro,fuente,gabinete;
    int ram,idcomputadora;

    public Computadora() {
    }

    public Computadora(int idcomputadora,String placaBase, String procesador, String tarjetaVideo, String discoDuro, String fuente, String gabinete, int ram) {
        this.placaBase = placaBase;
        this.procesador = procesador;
        this.tarjetaVideo = tarjetaVideo;
        this.discoDuro = discoDuro;
        this.fuente = fuente;
        this.gabinete = gabinete;
        this.ram = ram;
        this.idcomputadora = idcomputadora;
    }

    public String getPlacaBase() {
        return placaBase;
    }

    public void setPlacaBase(String placaBase) {
        this.placaBase = placaBase;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getTarjetaVideo() {
        return tarjetaVideo;
    }

    public void setTarjetaVideo(String tarjetaVideo) {
        this.tarjetaVideo = tarjetaVideo;
    }

    public String getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(String discoDuro) {
        this.discoDuro = discoDuro;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getGabinete() {
        return gabinete;
    }

    public void setGabinete(String gabinete) {
        this.gabinete = gabinete;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getIdcomputadora() {
        return idcomputadora;
    }

    public void setIdcomputadora(int idcomputadora) {
        this.idcomputadora = idcomputadora;
    }
    
    
}
