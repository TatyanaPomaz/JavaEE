package client_task_service_executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by User on 25.06.2017.
 */
public class ClientSystemManager {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService =
                Executors.newFixedThreadPool(4);

        Client client1 = new Client("client1", "client1", 13);
        Client client2 = new Client("client2", "client2", 13);
        Client client3 = new Client("client3", "client3", 13);
        Client client4 = new Client("client4", "client4", 13);

        List<ClientTaskCallable> clientTaskCallableList = Arrays.asList(
                new ClientTaskCallable(client1, 1),
                new ClientTaskCallable(client1, 2),
                new ClientTaskCallable(client1, 3),
                new ClientTaskCallable(client2, 1),
                new ClientTaskCallable(client3, 1),
                new ClientTaskCallable(client4, 1)
        );
        // List<Future> futures = executorService.invokeAll(clientTaskCallableList);

//        for (ClientTaskCallable clientTaskCallable : clientTaskCallableList) {
//            executorService.submit(clientTaskCallable);
//        }
        ClientExecutor clientExecutor = new ClientExecutor(4);
        for (ClientTaskCallable clientTaskCallable : clientTaskCallableList) {
            clientExecutor.submit(clientTaskCallable);
        }

    }
}
