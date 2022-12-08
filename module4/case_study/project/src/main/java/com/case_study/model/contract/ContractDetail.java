package com.case_study.model.contract;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@SQLDelete(sql = "UPDATE employee SET flag_remove = false WHERE id = ?")
@Where(clause = "flag_remove = true")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Contract contract;
    @ManyToOne
    private AttachFacility attachFacility;
    private Integer quantity;
    private boolean flagRemove = true;

    public ContractDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isFlagRemove() {
        return flagRemove;
    }

    public void setFlagRemove(boolean flagRemove) {
        this.flagRemove = flagRemove;
    }
}
