package com.superzanti.serversync;

import com.superzanti.serversync.config.SyncConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServerSyncTest {

    final String TEST_ADDRESS = "test-address";
    final int TEST_PORT = 1234;
    final SyncConfig config;

    ServerSyncTest() {
        ServerSync.main(new String[]{"-q", "-r", "out/test","-a", TEST_ADDRESS, "-p", String.valueOf(TEST_PORT)});
        config = SyncConfig.getConfig();
    }

    @Test
    @DisplayName("Address argument should set config value")
    void addressPropertyIsSet() {
        assertEquals(TEST_ADDRESS, config.SERVER_IP);
    }

    @Test
    @DisplayName("Port argument should set config value")
    void portPropertyIsSet() {
        assertEquals(TEST_PORT, config.SERVER_PORT);
    }
}