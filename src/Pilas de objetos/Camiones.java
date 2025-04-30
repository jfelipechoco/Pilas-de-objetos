import java.util.ArrayList;

public class Camiones 

{
    // Atributos
    private ArrayList<String> tipos;
    private ArrayList<Integer> cantidades;
    private ArrayList<Double> porcentajesGasolina;
    private ArrayList<Double> porcentajesDiesel;
    private ArrayList<Double> porcentajesGas;
    private double emisionGasolina;
    private double emisionDiesel;
    private double emisionGas;
    private ArrayList<Double> consumos;
    private double distanciaAnual;
    
    // Constructor por defecto
    public Camiones () {
        // Inicializar ArrayLists
        tipos = new ArrayList<>();
        cantidades = new ArrayList<>();
        porcentajesGasolina = new ArrayList<>();
        porcentajesDiesel = new ArrayList<>();
        porcentajesGas = new ArrayList<>();
        consumos = new ArrayList<>();
        
        emisionGasolina = 2.4;  
        emisionDiesel = 2.8;    
        emisionGas = 2.0;      
        distanciaAnual = 40000; 
    }
    
    // Métodos getter y setter
    public ArrayList<String> getTipos()
    {
        return tipos;
    }
    
    public void setTipos(ArrayList<String> tipos) 
    {
        this.tipos = tipos;
    }
    
    public ArrayList<Integer> getCantidades() 
    {
        return cantidades;
    }
    
    public void setCantidades(ArrayList<Integer> cantidades) 
    {
        this.cantidades = cantidades;
    }
    
    public ArrayList<Double> getPorcentajesGasolina() 
    {
        return porcentajesGasolina;
    }
    
    public void setPorcentajesGasolina(ArrayList<Double> porcentajesGasolina) 
    {
        this.porcentajesGasolina = porcentajesGasolina;
    }
    
    public ArrayList<Double> getPorcentajesDiesel() 
    {
        return porcentajesDiesel;
    }
    
    public void setPorcentajesDiesel(ArrayList<Double> porcentajesDiesel) 
    {
        this.porcentajesDiesel = porcentajesDiesel;
    }
    
    public ArrayList<Double> getPorcentajesGas() 
    {
        return porcentajesGas;
    }
    
    public void setPorcentajesGas(ArrayList<Double> porcentajesGas) 
    {
        this.porcentajesGas = porcentajesGas;
    }
    
    public double getEmisionGasolina() 
    {
        return emisionGasolina;
    }
    
    public void setEmisionGasolina(double emisionGasolina) 
    {
        this.emisionGasolina = emisionGasolina;
    }
    
    public double getEmisionDiesel() 
    {
        return emisionDiesel;
    }
    
    public void setEmisionDiesel(double emisionDiesel) {
        this.emisionDiesel = emisionDiesel;
    }
    
    public double getEmisionGas() {
        return emisionGas;
    }
    
    public void setEmisionGas(double emisionGas) 
    {
        this.emisionGas = emisionGas;
    }
    
    public ArrayList<Double> getConsumos() 
    {
        return consumos;
    }
    
    public void setConsumos(ArrayList<Double> consumos) 
    {
        this.consumos = consumos;
    }
    
    public double getDistanciaAnual() 
    {
        return distanciaAnual;
    }
    
    public void setDistanciaAnual(double distanciaAnual) 
    {
        this.distanciaAnual = distanciaAnual;
    }
    
    // Método para agregar un tipo de camión
    public void agregarTipoCamion(String tipo, int cantidad, double porcentajeGasolina, 
                                 double porcentajeDiesel, double porcentajeGas, double consumo) 
    {
        tipos.add(tipo);
        cantidades.add(cantidad);
        porcentajesGasolina.add(porcentajeGasolina);
        porcentajesDiesel.add(porcentajeDiesel);
        porcentajesGas.add(porcentajeGas);
        consumos.add(consumo);
    }
    
    // Método para calcular emisiones
    public void calcularEmisiones() {
        System.out.println("EMISIONES DE CO2 POR CATEGORÍA Y COMBUSTIBLE");
        System.out.println("");
        
        for (int i = 0; i < tipos.size(); i++) 
        {
            String tipo = tipos.get(i);
            int cantidad = cantidades.get(i);
            double consumo = consumos.get(i);
            
            // Vehículos por combustible
            int vehiculosGasolina = (int)(cantidad * porcentajesGasolina.get(i));
            int vehiculosDiesel = (int)(cantidad * porcentajesDiesel.get(i));
            int vehiculosGas = (int)(cantidad * porcentajesGas.get(i));
            
            // Emisiones por tipo toneladas
            double emisionGasolinaTipo = vehiculosGasolina * consumo * distanciaAnual * emisionGasolina / 2000;
            double emisionDieselTipo = vehiculosDiesel * consumo * distanciaAnual * emisionDiesel / 2000;
            double emisionGasTipo = vehiculosGas * consumo * distanciaAnual * emisionGas / 2000;
            double emisionTotalTipo = emisionGasolinaTipo + emisionDieselTipo + emisionGasTipo;
            
            System.out.println("Tipo: " + tipo);
            System.out.println("- Gasolina: " + vehiculosGasolina + " vehículos, " + emisionGasolinaTipo + " toneladas CO2");
            System.out.println("- Diesel: " + vehiculosDiesel + " vehículos, " + emisionDieselTipo + " toneladas CO2");
            System.out.println("- Gas: " + vehiculosGas + " vehículos, " + emisionGasTipo + " toneladas CO2");
            System.out.println("- Total: " + emisionTotalTipo + " toneladas CO2");
            System.out.println("");
        }
    }
    
    // Método principal
    public static void main(String[] args) 
    {
        // Crear instancia
            Camiones emisiones = new Camiones();
        
        // Agregar tipos de camiones
        emisiones.agregarTipoCamion("Livianos", 400000, 0.40, 0.50, 0.40, 0.13);
        emisiones.agregarTipoCamion("Medianos", 280000, 0.30, 0.60, 0.30, 0.40);
        emisiones.agregarTipoCamion("Pesados", 380000, 0.20, 0.90, 0.20, 0.40);
        emisiones.agregarTipoCamion("Tractocamiones", 1150000, 0.10, 0.90, 0.10, 0.40);
        emisiones.agregarTipoCamion("Volquetas", 936000, 0.50, 0.50, 0.30, 0.40);
        
        // Calcular y mostrar emisiones
        emisiones.calcularEmisiones();
    }
}