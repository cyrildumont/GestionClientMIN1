package fr.epf.min1.gestionclient;

import org.junit.Test;

public class Main {


    private String execute(TestFunction f){
        return f.exec("d");
    }

    @Test
    public void main() {
        TestFunction f = new TestFunction() {
            @Override
            public String exec(String input) {
                return input.toUpperCase();
            }
        };

        execute((String s) -> s.toUpperCase());


//        System.out.println(f2.exec("cyril"));
    }

    static class Maj implements TestFunction{

        @Override
        public String exec(String input) {
            return input.toUpperCase();
        }
    }

}
