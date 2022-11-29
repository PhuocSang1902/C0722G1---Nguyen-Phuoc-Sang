package com.case_study.model.contract;

import com.case_study.model.customer.Customer;
import com.case_study.model.employee.Employee;
import com.case_study.model.facility.Facility;
import com.case_study.service.Impl.CustomerService;
import org.hibernate.engine.spi.Mapping;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String startDate;
    private String endDate;
    private Double deposit;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Facility facility;
    @OneToMany(mappedBy="contract")
    private Set<ContractDetail> contractDetailSet;
    private boolean flagRemove;

    public Contract() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public boolean isFlagRemove() {
        return flagRemove;
    }

    public void setFlagRemove(boolean flagRemove) {
        this.flagRemove = flagRemove;
    }
}