package util;

public class HeapMomory {
    public static int MB = 1024 * 1024;
    // Getting the runtime reference from system
    public static Runtime runtime = Runtime.getRuntime();

    public static void printFreeMemory() {
        // Print free Memory
        System.out.println("Free Memory:" + runtime.freeMemory() / MB);
    }

    public static void printTotalMemory() {
        // Print total available Memory
        System.out.println("Total Memory:" + runtime.totalMemory() / MB);
    }

    public static void printUsedMemory() {
        // Print used Memory
        System.out.println("Used Memory:" + (runtime.totalMemory() - runtime.freeMemory()) / MB);
    }

    public static void printMaxMemory() {
        // Print Maximum available Memory
        System.out.println("Max Memory:" + runtime.maxMemory() / MB);
    }

    public static void printMemoryInfo() {
        System.out.println("##### Heap utilization statistics [MB] #####");

        // Print used Memory
        System.out.println("Used Memory:" + (runtime.totalMemory() - runtime.freeMemory()) / MB);

        // Print free Memory
        System.out.println("Free Memory:" + runtime.freeMemory() / MB);

        // Print total available Memory
        System.out.println("Total Memory:" + runtime.totalMemory() / MB);

        // Print Maximum available Memory
        System.out.println("Max Memory:" + runtime.maxMemory() / MB);
    }
}
