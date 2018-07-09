/**
 * @author Pablo Ríos Ramírez
 * @Created 28-06-2018 2:43:46
 * @web http://www.pabloriosramirez.com
 *
 */

package com.pabloriosramirez.springboot.web.service;

import com.pabloriosramirez.springboot.web.model.Customer;
import java.util.Arrays;
import java.util.List; 
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Override
    public List<Customer> findAll() {

        Customer customer1 = new Customer(1L, "Juan", "Uno", "Calle 274", "Santiago");
        Customer customer2 = new Customer(2L, "Pedro", "Dos", "Calle 004", "Valdivia");
        Customer customer3 = new Customer(3L, "Miguel", "Tres", "Calle 174", "Temuco");
        Customer customer4 = new Customer(4L, "Daniel", "Cuatro", "Calle 284", "Chillan");
        Customer customer5 = new Customer(5L, "Ramiro", "Cinco", "Calle 277", "Iquique");

        return Arrays.asList(customer1, customer2, customer3, customer4, customer5);
    }

}
