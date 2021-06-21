package kz.uco.testwork.service;

import java.util.UUID;

public interface NameGeneratorService {
    String NAME = "testwork_NameGeneratorService";

    String getFullName(UUID id);
}