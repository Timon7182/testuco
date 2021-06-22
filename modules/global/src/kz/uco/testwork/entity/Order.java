package kz.uco.testwork.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "TESTWORK_ORDER")
@Entity(name = "testwork_Order")
@NamePattern("%s|name")
public class Order extends StandardEntity {
    private static final long serialVersionUID = -3149129037191696210L;

    @Column(name = "NAME")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_")
    private Date date;

    @Column(name = "AMOUNT")
    private Double amount;

    @OneToMany(mappedBy = "order")
    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    private List<Product> product;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public Double getAmount() {
        double amount=0.0;
        if(getProduct()!=null){
            if( getProduct().size()>0 ){
                for (Product product:getProduct()){
                    amount+=(product.getPrice()*product.getQuantity());
                }
            }
        }

        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}