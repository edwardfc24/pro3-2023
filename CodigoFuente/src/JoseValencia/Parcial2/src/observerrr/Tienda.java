package observerrr;

import observerrr.Observable;
import observerrr.Observer;

import java.util.ArrayList;
import java.util.List;

public class Tienda implements Observable, Observer {
    List<Observer> almacen;
    int stock;
    public Tienda(){
        this.almacen= new ArrayList<>();
    }
    public int  notificar(int stockacc){
        this.stock= this.stock +stockacc;
        this.notificarObservadores();


        return this.stock;

    }
    @Override
    public void suscribir(Observer observer) {
        this.almacen.add(observer);
    }

    @Override
    public void desuscribir(Observer observer) {

    }

    @Override
    public void notificarObservadores() {
        for (Observer observer : this.almacen) {
            observer.Actualizar(this.stock+"");
        }

    }


    @Override
    public void Actualizar(String mensaje) {
        System.out.println("se ajusto el stock a: " + mensaje);

    }
}
