import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * La clase AnalizadorAccesosAServidor analiza los accesos
 * producidos al servidor.
 * @author Javier de Cea Dominguez.
 * @version 2018.03.03
 */
public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> accesos;
    
    /**
     * Constructor para objetos de la clase AnalizadorAccesosAServidor.
     */
    public AnalizadorAccesosAServidor() 
    {
        accesos = new ArrayList<>();
    }
    
    /**
     * Lee el archivo de log introducido por parametro y guarda sus datos.
     * @param archivo El nombre del archivo de log que va a ser leido.
     */    
    public void analizarArchivoDeLog(String archivo)
    {
        accesos.clear();
        File archivoALeer = new File(archivo);
        try {
            Scanner sc = new Scanner(archivoALeer);
            while (sc.hasNextLine()) {
                String lineaLeida = sc.nextLine();                               
                Acceso accesoActual = new Acceso(lineaLeida);               
                
                accesos.add(accesoActual);
            }
            sc.close();
        }
        catch (Exception e) {
            System.out.println("Ocurrio algun error al leer el archivo.");
        }
    }
    
    /**
     * Devuelve la hora con mas accesos. Si hay empate devuelve la mas alta.
     * @return Devuelve un int que equivale a la hora con mas accesos.
     * Si hay empate, devuelve la hora mas alta, o si no hay datos de 
     * acceso devuelve -1.
     */    
    public int obtenerHoraMasAccesos() 
    {
        int valorADevolver = -1;
        
        if (!accesos.isEmpty()) {
            int[] accesosPorHora = new int[24];
    
            for (Acceso accesoActual : accesos) {
                int horaAccesoActual = accesoActual.getHora();
                accesosPorHora[horaAccesoActual] = accesosPorHora[horaAccesoActual] + 1;
            }
            
            int numeroDeAccesosMasAlto = accesosPorHora[0];
            int horaDeAccesosMasAlto = 0;
            for (int i = 0; i < accesosPorHora.length; i++) {
                if (accesosPorHora[i] >= numeroDeAccesosMasAlto) {
                    numeroDeAccesosMasAlto = accesosPorHora[i];
                    horaDeAccesosMasAlto = i;
                }
            }
            
            valorADevolver = horaDeAccesosMasAlto;                      
        }
        
        return valorADevolver;
    }
    
    /**
     * Devuelve el nombre de la pagina web mas solicitada. Si no hay 
     * datos de acceso, muestra por pantalla tal acontecimiento.
     * @return Devuelve un String que contiene el nombre de la pagina 
     * web mas solicitada. En caso de empate devuelve cualquiera de 
     * las paginas. Si no hay datos de accesos, devuelve null.
     */    
    public String paginaWebMasSolicitada() 
    {
        String paginaWebMasSolicitada = null;
        HashSet<String> conjuntoDePaginasWeb = new HashSet<>();
        
        for(Acceso acceso : accesos) {
            conjuntoDePaginasWeb.add(acceso.getPaginaWeb());
        }
        
        int numeroDeVecesMasAltoQueSeHaRepetidoUnaPaginaWeb = 0;
        
        for(String paginaWeb : conjuntoDePaginasWeb) {
            int numeroDeVecesQueSeRepiteUnaPaginaWeb = 0;
            for(Acceso acceso : accesos) {
                if(acceso.getPaginaWeb().equals(paginaWeb)) {
                    numeroDeVecesQueSeRepiteUnaPaginaWeb += 1;
                }
            }
            if(numeroDeVecesQueSeRepiteUnaPaginaWeb > numeroDeVecesMasAltoQueSeHaRepetidoUnaPaginaWeb) {
                numeroDeVecesMasAltoQueSeHaRepetidoUnaPaginaWeb = numeroDeVecesQueSeRepiteUnaPaginaWeb;
                paginaWebMasSolicitada = paginaWeb;
            }
        }
        
        if(paginaWebMasSolicitada == null) {
            System.out.println("No hay datos de acceso al servidor.");
        }
        
        return paginaWebMasSolicitada;
    }
    
    /**
     * Devuelve la dirección IP del cliente que ha realizado el mayor numero de 
     * accesos exitosos al servidor. Si no hay datos de acceso al servidor, 
     * muestra por pantalla dicho acontecimiento.
     * @return Devuelve un String que contiene la dirección IP del cliente que
     * mas ha accedido al servidor. Si no hay datos de acceso, devuelve null. 
     * En caso de empate se muestra el cliente con la IP más alta.
     */    
    public String clienteConMasAccesosExitosos()
    {
        String direccionIPDelClienteQueMasHaAccedidoAlServidorDeFormaExitosa = null;
        HashSet<Acceso> conjuntoDeAccesos = new HashSet<>();

        for(Acceso acceso : accesos) {
            conjuntoDeAccesos.add(acceso);
        }
        
        int numeroDeVecesMasAltoQueSeHaRepetidoUnaDireccionIPQueHaAccedidoAlServidorDeFormaExitosa = 0;
        int direccionIPMasAlta = 0;
        
        for(Acceso acceso1 : conjuntoDeAccesos) {
            int numeroDeVecesQueSeRepiteUnaDireccionIPQueHaAccedidoAlServidorDeFormaExitosa = 0;
            for(Acceso acceso2 : accesos) {
                if(acceso1.getDireccionIP().equals(acceso2.getDireccionIP()) && Integer.parseInt(acceso2.getCodigo().substring(0, 1)) != 4) {
                    numeroDeVecesQueSeRepiteUnaDireccionIPQueHaAccedidoAlServidorDeFormaExitosa += 1;
                }
            }
            String[] direccionIPSeparada = acceso1.getDireccionIP().replace(".", " ").split(" ");
            if(numeroDeVecesQueSeRepiteUnaDireccionIPQueHaAccedidoAlServidorDeFormaExitosa > numeroDeVecesMasAltoQueSeHaRepetidoUnaDireccionIPQueHaAccedidoAlServidorDeFormaExitosa) {
                numeroDeVecesMasAltoQueSeHaRepetidoUnaDireccionIPQueHaAccedidoAlServidorDeFormaExitosa = numeroDeVecesQueSeRepiteUnaDireccionIPQueHaAccedidoAlServidorDeFormaExitosa;
                direccionIPDelClienteQueMasHaAccedidoAlServidorDeFormaExitosa = acceso1.getDireccionIP();
                direccionIPMasAlta = Integer.parseInt(direccionIPSeparada[3]);
            }
            else if (numeroDeVecesQueSeRepiteUnaDireccionIPQueHaAccedidoAlServidorDeFormaExitosa == numeroDeVecesMasAltoQueSeHaRepetidoUnaDireccionIPQueHaAccedidoAlServidorDeFormaExitosa && direccionIPMasAlta < Integer.parseInt(direccionIPSeparada[3])) {
                direccionIPDelClienteQueMasHaAccedidoAlServidorDeFormaExitosa = acceso1.getDireccionIP();                
            }
        }
        
        if(direccionIPDelClienteQueMasHaAccedidoAlServidorDeFormaExitosa == null) {
            System.out.println("No hay datos de acceso al servidor.");
        }

        return direccionIPDelClienteQueMasHaAccedidoAlServidorDeFormaExitosa;
    }


}
