package kz.uco.testwork.core;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import kz.uco.testwork.entity.Account;
import kz.uco.testwork.entity.Contacts;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Component("contactCollect")
public class ContactCollect {

    @Inject
    private Persistence persistence;

    public String getAllContactValues(UUID accountId){

        Query query = persistence.getEntityManager().createQuery(
                "select e from testwork_Contacts e join e.account a where a.id = :accId");
        query.setParameter("accId", accountId);

        List<Contacts> contacts= (List<Contacts>) query.getResultList();

        StringBuffer full_contact = new StringBuffer("");
        for(Contacts contact:contacts){
            full_contact.append(contact.getValue()+",");
        }
        if(full_contact.length()>0){
            full_contact.setCharAt(full_contact.length()-1,' ');

        }
        return full_contact.toString();

    }

}
