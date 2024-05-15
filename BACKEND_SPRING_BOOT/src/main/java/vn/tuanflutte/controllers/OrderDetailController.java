package vn.tuanflutte.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.tuanflutte.entities.OrderDetail;
import vn.tuanflutte.exception.ResponseObject;
import vn.tuanflutte.services.orderDetail.OrderDetailService;

import java.util.List;

@RestController
@RequestMapping(path = "/orderDetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("")
    @PreAuthorize("hasRole('User')")
    ResponseEntity<ResponseObject> findAll(){
        List<OrderDetail> orders = orderDetailService.findAll();

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

    @PostMapping("")
    @PreAuthorize("hasRole('User')")
    ResponseEntity<ResponseObject> saveOrderDetail(@RequestBody OrderDetail orderDetail){
        try {
            orderDetailService.save(orderDetail);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Insert data successfully", "")
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("error", "Insert data failed", e.getMessage())
            );
        }
    }
}
