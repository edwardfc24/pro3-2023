package pruebas;

import javax.swing.*;
import java.awt.*;

public class PanelCentral extends JPanel {
    private PanelPersona local;
    private PanelChats visitante;

    public PanelCentral() {
        this.setSize(400,400);
        this.setLayout(null);
        local=new PanelPersona();
        /*local.getMensajes().setBackground(Color.blue);
        local.getMensajes().setText(local.getMensajes().getText()+"\n");
        local.getMensajes().setText(local.getMensajes().getText()+"otro mensaje");
        */

        visitante = new PanelChats();
        this.add(visitante);
        this.add(local);
        this.setVisible(true);
    }


    public PanelPersona getLocal() {
        return local;
    }

    public void setLocal(PanelPersona local) {
        this.local = local;
    }

    public PanelChats getVisitante() {
        return visitante;
    }

    public void setVisitante(PanelChats visitante) {
        this.visitante = visitante;
    }
}
