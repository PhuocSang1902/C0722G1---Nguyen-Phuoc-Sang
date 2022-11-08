package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.customer.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {

    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> getList() {
        return customerRepository.getList();
    }

    @Override
    public Customer findById(int id) {

        return customerRepository.findById(id);
    }

    @Override
    public boolean remove(String id) {
        return customerRepository.remove(id);
    }

    @Override
    public boolean edit(int id, Customer customer) {
        return customerRepository.edit(id, customer);
    }
}