package Patrones.Factory.TiendaOnline;

public class Cliente {
    private ProductoTienda vidrio;

    public Cliente(FabricaTienda fabrica){
        vidrio = fabrica.comprarProducto();
    }

    public void ordenarProducto(){
        vidrio.fabricarProducto();
        vidrio.empacarProducto();
        vidrio.pepidoProducto();
    }
}
