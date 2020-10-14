
package com.vlade.crm.rest;

import com.vlade.crm.entity.Customer;
import com.vlade.crm.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vladimir Cakic
 */

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    
    //Autowire the CustomerService
    @Autowired
    private CustomerService customerService;
    
    //mapping for GET /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }
    
    //mapping for GET /customers/{customerId}
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer theCustomer = customerService.getCustomer(customerId);
        if (theCustomer == null) {
            throw new CustomerNotFoundException("Customer Id not found - " + customerId);
        }
        return theCustomer;
    }
    
    //mapping for POST /customers
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer){
        //if client passes id in json, set it to 0
        theCustomer.setId(0);
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }
    
     //mapping for PUT /customers
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer){
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }
    
    //mapping for DELETE /customers/{customerId}
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer theCustomer = customerService.getCustomer(customerId);
        if (theCustomer == null) {
            throw new CustomerNotFoundException("Customer Id not found - " + customerId);
        }
        customerService.deleteCustomer(customerId);
        return "Deleted Customer Id - " + customerId;
    }
    
    
}
