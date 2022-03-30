package fr.epf.min1.gestionclient;

public class Paire<A,Z> {

    private A premier;
    private Z second;

    public Paire(A premier, Z second) {
        this.premier = premier;
        this.second = second;
    }

    public A getPremier() {
        return premier;
    }

    public void setPremier(A premier) {
        this.premier = premier;
    }

    public Z getSecond() {
        return second;
    }

    public void setSecond(Z second) {
        this.second = second;
    }

    public static void main(String[] args) {
        Paire<String, Integer> paire =
                new Paire<String, Integer>("Coucou", 4);
        String premier = paire.getPremier();
    }

}
