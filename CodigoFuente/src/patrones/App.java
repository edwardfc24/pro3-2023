package patrones;

public class App {
    public static void main(String[] args) {
        // Creamos un Publisher
        Pro3Informa informador = new Pro3Informa();
        GrupoVip especial = new GrupoVip();

        // Creamos unos suscriptores
        Suscriptor juanito = new Suscriptor("Juan Perez");
        Suscriptor pepe = new Suscriptor("Pepe Peña");
        Suscriptor maria = new Suscriptor("Maria Fuentes");

        // Agregamos los suscriptores
        informador.suscribir(juanito);
        informador.suscribir(pepe);
        informador.suscribir(maria);

        //especial.suscribir(juanito);
        // Mandamos un mensaje
        informador.notificar("Bienvenidos al grupo");
        // especial.notificar("Tenés 5 puntos");

        informador.desuscribir(pepe);
        informador.notificar("Pepep ha dejado el grupo");
        // especial.notificar("Mantenga el grupo vip en secreto");

        SuscriptorAritmetico suma = new SuscriptorAritmetico("suma");
        SuscriptorAritmetico resta = new SuscriptorAritmetico("resta");
        SuscriptorAritmetico multi = new SuscriptorAritmetico("multiplicacion");
        SuscriptorAritmetico divi = new SuscriptorAritmetico("division");

        especial.suscribir(suma);
        especial.suscribir(resta);
        especial.suscribir(multi);
        especial.suscribir(divi);

        especial.notificar("5");
        especial.notificar("3");


    }
}
