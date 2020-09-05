package ie.williamswalsh.thread_pools;

public class SizingThreadPools {
    /**
     * The # of threads you should use should relate to the workload
     * #threads : workload
     *
     * Formula for sizing thread pool:
     * t = c * u * (1 + w/c)
     * #threads = #cpus * utilization rate * (1 + Waiting time/Compute Time)
     * 800      = 8     * 1                * (1 + 100)
     *
     * #cpus -> Runtime.getRuntime().availableProcessors();
     * utilization rate -> between 0-1 rate of utilization that you want/choose 70% -> 0.7
     * Waiting time -> How long cpu is waiting
     * Compute time -> How long cpu is executing operations
     */
    public static void main(String[] args) {
        System.out.println("Cores: " + Runtime.getRuntime().availableProcessors());
    }
}
