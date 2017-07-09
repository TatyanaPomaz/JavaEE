package client_task_service_executor;

import java.util.concurrent.*;

/**
 * Created by User on 02.07.2017.
 */
public class ClientExecutor extends ThreadPoolExecutor {
    private BlockingQueue<ClientEntry> tasksInProgressQueue = new ArrayBlockingQueue(10);
    private BlockingQueue<ClientEntry> tasksInWaitQueue = new ArrayBlockingQueue(10);

    public ClientExecutor(int nThreads) {
        super(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<T> ftask = newTaskFor(task);
        ClientEntry clientEntry = new ClientEntry(ftask, task);
        if(!tasksInProgressQueue.contains(clientEntry)){
            tasksInProgressQueue.add(clientEntry);
            execute(ftask);
        }else {
            tasksInWaitQueue.add(clientEntry);
        }

        return ftask;
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
         for(ClientEntry clientEntry : tasksInProgressQueue){
             if(r.equals(clientEntry.getRunnableFuture())){
                 tasksInProgressQueue.remove(clientEntry);

                 for(ClientEntry clientEntry1 : tasksInWaitQueue){
                     if(clientEntry1.getTask().equals(clientEntry.getTask())){
                         tasksInWaitQueue.remove(clientEntry1);
                         submit(clientEntry1.getTask());
                         break;
                     }
                 }
                 break;
             }
         }



    }

    class ClientEntry {
        private RunnableFuture runnableFuture;
        private Callable task;

        public ClientEntry(RunnableFuture runnableFuture, Callable task) {
            this.runnableFuture = runnableFuture;
            this.task = task;
        }

        public RunnableFuture getRunnableFuture() {
            return runnableFuture;
        }

        public void setRunnableFuture(RunnableFuture runnableFuture) {
            this.runnableFuture = runnableFuture;
        }

        public Callable getTask() {
            return task;
        }

        public void setTask(Callable task) {
            this.task = task;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClientEntry that = (ClientEntry) o;

            return task != null ? task.equals(that.task) : that.task == null;
        }

        @Override
        public int hashCode() {
            return task != null ? task.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "ClientEntry{" +
                    "runnableFuture=" + runnableFuture +
                    ", task=" + task +
                    '}';
        }
    }
}
