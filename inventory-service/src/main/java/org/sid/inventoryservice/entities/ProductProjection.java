package org.sid.inventoryservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullProduct",types = Product.class)
public interface ProductProjection {
    public int getId();
    public String getName();
    public double getPrice();
    public int getQuantity();
}
