package kz.uco.testwork.service;

import kz.uco.testwork.core.NameGenerator;
import kz.uco.testwork.service.NameGeneratorService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.UUID;

@Service(NameGeneratorService.NAME)
public class NameGeneratorServiceBean implements NameGeneratorService{
    public static final String NAME = "testwork_NameGeneratorServiceBean";

    @Inject
    private NameGenerator nameGenerator;


    @Override
    @Transactional
    public String getFullName(UUID id) {
        return nameGenerator.getFullName(id);
    }
}