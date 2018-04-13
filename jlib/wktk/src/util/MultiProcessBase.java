package util;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Colin Wang on 2018-1-9.
 * Multiple Process
 */

// // this ia a usage
//    List result = new MultiProcessBase() {
//        @Override
//        List subProcess(Object o) {
//            /* do your work */
//            return process_result;
//        }
//    }.process(data);  /* split to process data */


public abstract class MultiProcessBase {
    private static int numProcessor = Runtime.getRuntime().availableProcessors() - 1;

    protected MultiProcessBase() {
    }

    public abstract List subProcess(Object o);  /* you should implement it */

    @SuppressWarnings("unchecked")
    public List process(List data) {
        // multi process
        List<Future> futures = new LinkedList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(numProcessor);

        for (Object o : data) {
            futures.add(executorService.submit(new CallableImpl(o)));
        }

        // get split result
        List<Object> results = new LinkedList<>();
        for (Future future : futures) {
            try {
                results.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        // shutdown
        executorService.shutdown();

        return results;
    }

    public static List combine(List<List> list) {
        List results = new LinkedList<>();

        for (List l : list) {
            //noinspection unchecked
            results.addAll(l);
        }

        return results;
    }


    class CallableImpl implements Callable {
        Object o;

        CallableImpl(Object o) {
            this.o = o;
        }

        @Override
        public Object call() throws Exception {
            return subProcess(o);
        }
    }
}
