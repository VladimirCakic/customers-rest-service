
package com.vlade.crm.service;

import com.vlade.crm.dao.CustomerDAO;
import com.vlade.crm.dao.StubCustomerDAO;
import com.vlade.crm.entity.Customer;
import com.vlade.crm.rest.CustomerNotFoundException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vladimir Cakic
 */
public class CustomerServiceImplTest {
    
    public CustomerServiceImplTest() {
    }
    
    static final int CUSTOMER_ID = 1;
    static final int INIT_NUM_OF_CUSTOMERS = 4;
    final Customer customer = new Customer("Nevenka", "Djordjevic", "nena@mail.com");
    
    StubCustomerDAO dao = new StubCustomerDAO();
    
    //Object to be tested
    CustomerServiceImpl service = new CustomerServiceImpl();
    
    @Before
    public void setUp() {
        dao.init();
        
        //create object to be tested
        service = new CustomerServiceImpl();
        service.setCustomerDAO(dao);
    }
    
    @After
    public void tearDown() {
        dao.clear();
    }

    /**
     * Test of getCustomers method, of class CustomerServiceImpl.
     */
    @Test
    public void testGetCustomersPositiv() {
        System.out.println("getCustomersPositiv");
        int numOfCustomers = service.getCustomers().size();
        assertEquals(INIT_NUM_OF_CUSTOMERS, numOfCustomers);
    }

    /**
     * Positive test of saveCustomer method, of class CustomerServiceImpl.
     */
    @Test
    public void testSaveCustomerPositive() {
        System.out.println("saveCustomerPositive");
        service.saveCustomer(customer);
        int newNumOfCustomers = service.getCustomers().size();
        assertEquals(INIT_NUM_OF_CUSTOMERS + 1, newNumOfCustomers);
    }
    
    /**
     * Test of getCustomer method, of class CustomerServiceImpl, with the existing id.
     */
    @Test
    public void testGetCustomerPositive() {
        System.out.println("getCustomerPositive");
        Customer customer = service.getCustomer(CUSTOMER_ID);
        assertNotNull(customer);
    }
    
     /**
     * Test of getCustomer method, of class CustomerServiceImpl, with the nonexisting id.
     */
    @Test(expected = CustomerNotFoundException.class)
    public void testGetCustomerNegative() {
        System.out.println("getCustomerNegative");
        Customer customer = service.getCustomer(99);
        assertNull(customer);
    }

    /**
     * Positive test of deleteCustomer method, of class CustomerServiceImpl.
     */
    @Test
    public void testDeleteCustomerPositive() {
        System.out.println("deleteCustomerPositive");
        service.deleteCustomer(CUSTOMER_ID);
        try {
            Customer customer = service.getCustomer(CUSTOMER_ID);
        } catch (CustomerNotFoundException cnfe){
            assertTrue(cnfe.getMessage().contains("Customer with id 1 "
                    + "could not be processed because it does not exist."));
        }
    }
    
     /**
     * Negative test of deleteCustomer method, of class CustomerServiceImpl.
     * Attemt to delete non-existing customer.
     */
    @Test(expected = CustomerNotFoundException.class)
    public void testDeleteCustomerNegative() {
        System.out.println("deleteCustomerNegativ");
        service.deleteCustomer(99);
    }
   
}
