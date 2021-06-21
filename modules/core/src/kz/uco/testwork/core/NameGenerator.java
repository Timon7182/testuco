package kz.uco.testwork.core;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import kz.uco.testwork.entity.Account;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Component("nameGenerator")
public class NameGenerator {

    @Inject
    private Persistence persistence;

    public String getFullName(UUID accountId) {

        Query query = persistence.getEntityManager().createQuery(
                "select e from testwork_Account e where e.id = :accId");
        query.setParameter("accId", accountId);

        Account account= (Account) query.getSingleResult();
        StringBuffer full_name = new StringBuffer("");


          full_name.append(account.getName());
          full_name.append(" "+account.getLast_name());
          if(account.getMiddle_name()!=null){
               full_name.append(" "+ account.getMiddle_name());
           }

        return full_name.toString();
    }
}
