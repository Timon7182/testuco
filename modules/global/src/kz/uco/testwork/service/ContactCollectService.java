package kz.uco.testwork.service;

import java.util.UUID;

public interface ContactCollectService {
    String NAME = "testwork_CotactCollectService";

    public String getAllContactValues(UUID id);
}