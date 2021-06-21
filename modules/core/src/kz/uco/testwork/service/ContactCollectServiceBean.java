package kz.uco.testwork.service;

import kz.uco.testwork.core.ContactCollect;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.UUID;

@Service(ContactCollectService.NAME)
public class ContactCollectServiceBean implements ContactCollectService {

    @Inject
    ContactCollect contactCollect;

    @Override
    @Transactional
    public String getAllContactValues(UUID id) {
        return contactCollect.getAllContactValues(id);
    }
}