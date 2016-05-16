package Ventana;

import javax.swing.JProgressBar;

public class Cargar extends Thread {

    private JProgressBar progress;

    public Cargar(JProgressBar progress) {
        super();
        this.progress = progress;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            this.progress.setValue(i);
            pause((int)(Math.random() * 1));
        }
    }

    private void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
