package org.sid.orderservice.web;

import org.sid.orderservice.entities.Order;
import org.sid.orderservice.model.Customer;
import org.sid.orderservice.model.Product;
import org.sid.orderservice.repo.OrderRepository;
import org.sid.orderservice.repo.ProductItemRepository;
import org.sid.orderservice.services.CustomerRestClientService;
import org.sid.orderservice.services.InventoryRestClientService;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OrderRestController {
    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private InventoryRestClientService inventoryRestClientService;
    private CustomerRestClientService customerRestClientService;

    public OrderRestController(OrderRepository orderRepository, ProductItemRepository productItemRepository, InventoryRestClientService inventoryRestClientService, CustomerRestClientService customerRestClientService) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.inventoryRestClientService = inventoryRestClientService;
        this.customerRestClientService = customerRestClientService;
    }


    @GetMapping("/fullOrder/{id}")
    public Order fullOrder(@PathVariable Long id){
        Order order = orderRepository.findById(id).get();
        Customer customer = customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(pi->{
            Product product = inventoryRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
        });


        return  order;
    }
}
