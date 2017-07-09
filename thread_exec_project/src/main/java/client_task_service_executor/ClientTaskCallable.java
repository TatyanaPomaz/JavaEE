package client_task_service_executor;

import java.util.concurrent.Callable;

/**
 * Created by User on 25.06.2017.
 */
public class ClientTaskCallable implements Callable {
    private Client client;
    private int taskNumber;


    public ClientTaskCallable(Client client, int taskNumber) {
        this.client = client;
        this.taskNumber = taskNumber;
    }

    public Object call() throws Exception {
        System.out.println(client);
        Thread.sleep(300);
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientTaskCallable that = (ClientTaskCallable) o;

        return client != null ? client.equals(that.client) : that.client == null;
    }

    @Override
    public String toString() {
        return "ClientTaskCallable{" +
                "client=" + client +
                ", taskNumber=" + taskNumber +
                '}';
    }

    @Override
    public int hashCode() {
        return client != null ? client.hashCode() : 0;
    }
}
