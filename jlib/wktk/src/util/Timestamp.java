package util;


import java.util.Date;

public class Timestamp {
    private long start;
    private long cutStart;

    public Timestamp() {
        start = System.currentTimeMillis();
        cutStart = start;
        System.out.println("Timestamp | start: " + (new Date().toString()));
    }

    public float cut() {
        float duration;

        duration = (float) (System.currentTimeMillis() - cutStart) / 1000;
        cutStart = System.currentTimeMillis();

        System.out.println("Timestamp | cut: " + (new Date().toString()) + " " + duration + " seconds");
        return duration;
    }

    public void end() {
        float duration;

        duration = (float) (System.currentTimeMillis() - start) / 1000;

        System.out.println("Timestamp | end: " + (new Date().toString()) + " " + duration + " seconds");
    }

    public void exit() {
        float duration;

        duration = (float) (System.currentTimeMillis() - start) / 1000;

        System.out.println("Timestamp | exit: " + (new Date().toString()) + " " + duration + " seconds");
        System.exit(1015);
    }


    public void cut(String str) {
        float duration;

        duration = (float) (System.currentTimeMillis() - cutStart) / 1000;
        cutStart = System.currentTimeMillis();

        System.out.println("Timestamp | cut: " + (new Date().toString()) + " " + duration + " seconds");
        System.out.println(str);
    }

    public void end(String str) {
        float duration;

        duration = (float) (System.currentTimeMillis() - start) / 1000;

        System.out.println("Timestamp | end: " + (new Date().toString()) + " " + duration + " seconds");
        System.out.println(str);
    }

    public void exit(String str) {
        float duration;

        duration = (float) (System.currentTimeMillis() - start) / 1000;

        System.out.println("Timestamp | exit: " + (new Date().toString()) + " " + duration + " seconds");
        System.out.println(str);
        System.exit(1015);
    }

}
