package com.github.linghengqian;

import io.etcd.jetcd.ByteSequence;
import io.etcd.jetcd.Client;
import io.etcd.jetcd.KV;
import io.etcd.jetcd.kv.DeleteResponse;
import io.etcd.jetcd.kv.GetResponse;
import io.etcd.jetcd.test.EtcdClusterExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @RegisterExtension
    public static final EtcdClusterExtension CLUSTER = EtcdClusterExtension.builder()
            .withNodes(1)
            .withMountDirectory(false)
            .build();

    @Test
    void test() {
        assertDoesNotThrow(() -> {
            try (Client client = Client.builder().endpoints(CLUSTER.clientEndpoints()).build()) {
                KV kvClient = client.getKVClient();
                ByteSequence key = ByteSequence.from("test_key".getBytes());
                ByteSequence value = ByteSequence.from("test_value".getBytes());
                kvClient.put(key, value).get();
                CompletableFuture<GetResponse> getFuture = kvClient.get(key);
                GetResponse response = getFuture.get();
                assertEquals(1, response.getCount());
                DeleteResponse deleteResponse = kvClient.delete(key).get();
                assertEquals(1, deleteResponse.getDeleted());
            }
        });
    }
}
