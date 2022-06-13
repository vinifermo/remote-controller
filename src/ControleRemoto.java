import jdk.internal.dynalink.linker.LinkerServices;

interface Controlador {
    //Métodos Abstratos
    public abstract void ligar();

    public abstract void desligar();

    public abstract void abrirMenu();

    public abstract void fecharMenu();

    public abstract void maisVolume();

    public abstract void menosVolume();

    public abstract void ligarMudo();

    public abstract void desligarMudo();

    public abstract void play();

    public abstract void pause();

}

public class ControleRemoto implements Controlador {
    //ATRIBUTOS
    private int volume;
    private boolean ligado;
    private boolean tocando;

    //Métodos Especiais
    public ControleRemoto() {
        volume = 50;
        ligado = false;
        tocando = false;
    }

    private int getVolume() {
        return volume;
    }

    private boolean getLigado() {
        return ligado;
    }

    private boolean getTocando() {
        return tocando;
    }

    private void setVolume(int v) {
        this.volume = v;
    }

    private void setLigado(boolean l) {
        this.ligado = l;
    }

    private void setTocando(boolean t) {
        this.tocando = t;
    }

    public void ligar() {
        setLigado(true);

    }

    public void desligar() {
        setLigado(false);

    }

    public void abrirMenu() {
        System.out.println("---------------MENU-----------------");
        System.out.println("Esta ligado?" + this.getLigado());
        System.out.println("Esta tocando?" + this.getTocando());
        System.out.print("Volume:" + this.getVolume());
        for (int i = 0; i <= this.getVolume(); i += 10) {
            System.out.print("I");
        }
        System.out.println("");


    }

    public void fecharMenu() {
        System.out.println("Fechando menu!");

    }

    public void maisVolume() {
        if (this.getLigado()) {
            this.setVolume(this.getVolume() + 5);

        }

    }

    public void menosVolume() {
        if (this.getLigado()) {
            this.setVolume(this.getVolume() - 5);

        }

    }

    public void ligarMudo() {
        if (this.getLigado()&& this.getVolume()>0) {
            this.setVolume(0);
        }

    }


    public void desligarMudo() {
        if (this.getLigado()&&this.getVolume()==0) {
            this.setVolume(50);
        }

    }


    public void play() {
        if (this.getLigado()&& !(getTocando())) {
            this.setTocando(true);
        }

    }


    public void pause() {
        if (this.getLigado()&& !(getTocando())) {
            this.setTocando(false);
        }

    }

    public static void main(String[] args) {
        ControleRemoto c = new ControleRemoto();
        c.ligar();
        c.maisVolume();
        c.abrirMenu();
    }
}








