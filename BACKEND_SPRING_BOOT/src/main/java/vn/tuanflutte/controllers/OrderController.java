package vn.tuanflutte.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.tuanflutte.entities.Order;
import vn.tuanflutte.dtos.request.OrderInput;
import vn.tuanflutte.exception.ResponseObject;
import vn.tuanflutte.services.cart.CartService;
import vn.tuanflutte.services.order.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('Admin')")
    ResponseEntity<ResponseObject> findAllByAdmin(@RequestParam(defaultValue = "") String key){
        List<Order> orders = null;
        if (key.equals("")){
            orders = orderService.findAll();
        }else {
            orders = orderService.findByOrderPhoneNumber(key);
            if(orders.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "No Data", "")
                );
            }
        }

        if(!orders.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query order successfully", orders)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "No Data", "")
            );
        }
    }

    @GetMapping("")
    @PreAuthorize("hasRole('User')")
    ResponseEntity<ResponseObject> findAllByUser(@RequestParam(defaultValue = "") String key){
        List<Order> orders = null;
        if (key.equals("")){
            orders = orderService.findAllByUser();
        }else {
            orders = orderService.findByOrderPhoneNumber(key);
            if(orders.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "No Data", "")
                );
            }
        }

        if(!orders.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query order successfully", orders)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "No Data", "")
            );
        }
    }

    @GetMapping("/{orderId}")
//    @PreAuthorize("hasRole('User')")
    ResponseEntity<ResponseObject> findById(@PathVariable int orderId){
        Optional<Order> foundOrder = orderService.findById(orderId);
        if(foundOrder.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query order successfully", foundOrder)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "cannot find order with id = "+orderId, "")
            );
        }
    }


    @PostMapping("")
    @PreAuthorize("hasRole('User')")
    ResponseEntity<ResponseObject> saveOrder(@RequestBody OrderInput orderInput){
        try {
            orderService.save(orderInput);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Insert data successfully", "")
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("error", "Insert data failed", e.getMessage())
            );
        }
    }

    @PutMapping("/{orderId}/{status}")
//    @PreAuthorize("hasRole('User')")
    ResponseEntity<ResponseObject> updateStatus(@PathVariable int orderId, @PathVariable int status){
        try {
            orderService.updateStatus(orderId, status);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Change status successfully", "")
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("error", "Change status failed", "")
            );
        }
    }

    @DeleteMapping("/{orderId}")
    ResponseEntity<ResponseObject> deleteOrder(@PathVariable int orderId){
        boolean exits = orderService.existsById(orderId);
        if(exits){
            orderService.deleteById(orderId);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "delete data successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find data to delete", "")
        );
    }
}
