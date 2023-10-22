package org.sid.orderservice.entities;

import org.sid.orderservice.enums.OrderStatus;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(types = Order.class, name = "fullOrder")
public interface OrderProjection {
    public long getId();
    public Date getCreatedAt();
    public OrderStatus getStatus();
    public long getCustomerId();
}
