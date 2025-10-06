package org.ceo.apis;

public class NodeBackendAPI implements BackendAPI {
    @Override
    public int createTransaction() {
        return (int) (Math.random() * 1000);
    }

    @Override
    public boolean updateState() {
        return true;
    }

    @Override
    public double getATMAmount(String atmId) {
        return 10000.0;
    }
}
