package org.sid.customerservice.repository;

import org.sid.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//spring data rest

@RepositoryRestResource

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
