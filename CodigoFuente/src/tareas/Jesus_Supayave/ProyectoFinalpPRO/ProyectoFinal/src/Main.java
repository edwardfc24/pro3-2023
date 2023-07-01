public class Main {
    public static void main(String[] args) {

        Cliente juanito = new Cliente("Juan");
        Cliente pepe = new Cliente("Pepe ");
        Cliente marta = new Cliente("Marta");
        Cliente carolina = new Cliente("Carolina");
        Cliente tito = new Cliente("Tito");
        Cliente claudia = new Cliente("Claudia");

        //Suscribimos a los individuos
        /*juanito.suscribir(juanito);
        pepe.suscribir(pepe);
        marta.suscribir(marta);*/


        //conectamos a quienes les llegara el mensaje

        juanito.escribir(pepe);
        juanito.escribir(marta);
        juanito.escribir(claudia);
        juanito.escribir(carolina);
        juanito.escribir(tito);

        pepe.escribir(juanito);
        pepe.escribir(marta);
        pepe.escribir(carolina);
        pepe.escribir(claudia);
        pepe.escribir(tito);

        marta.escribir(juanito);
        marta.escribir(pepe);
        marta.escribir(carolina);
        marta.escribir(claudia);
        marta.escribir(tito);

        claudia.escribir(juanito);
        claudia.escribir(pepe);
        claudia.escribir(tito);
        claudia.escribir(marta);
        claudia.escribir(carolina);

        carolina.escribir(juanito);
        carolina.escribir(pepe);
        carolina.escribir(marta);
        carolina.escribir(carolina);
        carolina.escribir(tito);

        tito.escribir(marta);
        tito.escribir(carolina);
        tito.escribir(claudia);
        tito.escribir(pepe);
        tito.escribir(juanito);

        System.out.println();

        //desarrollo del mensaje

        juanito.enviarMensaje("Hola chic@s");
        //juanito.enviarMensaje("Hola Marta");

        pepe.enviarMensaje("Hola juanito");
        // pepe.enviarMensaje("Hola Marta");

        marta.enviarMensaje("Hola a todos");
        // marta.enviarMensaje("Como estan");

        tito.enviarMensaje("Siguen ahi?");

        pepe.enviarMensaje("sigo igual que ayer");

        carolina.enviarMensaje("vivo Cerca de Ustedes");

        claudia.enviarMensaje("Puedo unirme a sus planes");
        marta.enviarMensaje("Bueno a Dormir");


        //pepe.desuscribir(juanito);




    }
}
