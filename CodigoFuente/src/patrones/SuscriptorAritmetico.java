package patrones;

public class SuscriptorAritmetico implements Observer {
    private int previo;
    private int numero;
    private String operacion;

    public SuscriptorAritmetico(String operacion) {
        this.operacion = operacion;
        this.previo = 1;
    }

    @Override
    public void actualizar(String mensaje) {
        int result = 0;
        try {
            numero = Integer.parseInt(mensaje);
            switch (this.operacion) {
                case "suma":
                    result = numero + previo;
                    break;
                case "resta":
                    result = numero - previo;
                    break;
                case "multiplicacion":
                    result = numero * previo;
                    break;
                case "division":
                    result = numero / previo;
                    break;
            }
            System.out.println(result);
            previo = numero;
        } catch (Exception e) {
            System.out.println("Ha ocurrido el siguiente problema: " + e.getMessage());
        }
    }
}
