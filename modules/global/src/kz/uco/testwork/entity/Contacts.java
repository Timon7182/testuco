package kz.uco.testwork.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.validation.groups.UiCrossFieldChecks;
import kz.uco.testwork.service.CheckContactType;

import javax.persistence.*;

@CheckContactType(groups = UiCrossFieldChecks.class)
@Table(name = "TESTWORK_CONTACTS")
@Entity(name = "testwork_Contacts")
public class Contacts extends StandardEntity {
    private static final long serialVersionUID = 2499222767734210017L;


    @Column(name = "CONTACT")
    private String contact;


    @Column(name = "VALUE_")
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setContact(ContactType contact) {
        this.contact = contact == null ? null : contact.getId();
    }

    public ContactType getContact() {
        return contact == null ? null : ContactType.fromId(contact);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}