
package com.vlade.crm.dao;

import com.vlade.crm.entity.Customer;
import com.vlade.crm.rest.CustomerNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Vladimir Cakic
 */
public class StubCustomerDAO implements CustomerDAO{
    
    protected Map<Integer, Customer> repo = new HashMap<>();
    
    public void init(){
        Customer customer1 = new Customer("Nenad", "Ivkovic", "nenad@email.com");
        Customer customer2 = new Customer("Marko", "Markovic", "marko@email.com");
        Customer customer3 = new Customer("Jana", "Igic", "jana@email.com");
        Customer customer4 = new Customer("Ivana", "Ivkovic", "ivana@email.com");
        this.saveCustomer(customer1);
        this.saveCustomer(customer2);
        this.saveCustomer(customer3);
        this.saveCustomer(customer4);
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        repo.values().forEach(customer -> customers.add(customer));
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        theCustomer.setId(repo.size() + 1);
            repo.put(theCustomer.getId(), theCustomer);
        }

    @Override
    public Customer getCustomer(int theId) {
        if (repo.containsKey(theId)){
            return repo.get(theId);
        } else {
            throw new CustomerNotFoundException("Customer with id "
            + theId + " could not be processed because it does not exist.");
        }
        
    }

    @Override
    public void deleteCustomer(int theId) {
        if (repo.containsKey(theId)){
            repo.remove(theId);
        } else {
            throw new CustomerNotFoundException("Customer with id "
            + theId + " could not be processed because it does not exist.");
        }
    }

    public void clear() {
        repo.clear();
    }
    
}

