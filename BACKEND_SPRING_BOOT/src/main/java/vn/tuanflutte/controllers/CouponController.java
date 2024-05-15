package vn.tuanflutte.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.tuanflutte.entities.Category;
import vn.tuanflutte.entities.Coupon;
import vn.tuanflutte.exception.ResponseObject;
import vn.tuanflutte.services.coupon.CouponService;
import vn.tuanflutte.services.coupon.ICouponService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/coupon")
public class CouponController {
    @Autowired
    private ICouponService couponService;

    @GetMapping("")
    ResponseEntity<ResponseObject> findAll(){
        List<Coupon> list = couponService.findAll();
        if(!list.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query coupon successfully", list)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "No Data", "")
            );
        }
    }

    @GetMapping("/{couponId}")
    ResponseEntity<ResponseObject> findById(@PathVariable int couponId){
        Optional<Coupon> foundCoupon = couponService.findById(couponId);
        if(foundCoupon.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query coupon successfully", foundCoupon)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "cannot find category with id = "+couponId, "")
            );
        }
    }

    @PostMapping("")
    @PreAuthorize("hasRole('Admin')")
    ResponseEntity<ResponseObject> insertCoupon(@RequestBody Coupon coupon){
        try {
            couponService.save(coupon);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Insert data successfully", "")
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("error", "Insert data failed", "")
            );
        }
    }

    @PutMapping("/{couponId}")
    @PreAuthorize("hasRole('Admin')")
    ResponseEntity<ResponseObject> updateCoupon(@RequestBody Coupon coupon, @PathVariable int couponId){
       couponService.update(couponId, coupon);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "Update data successfuly", "")
        );
    }

    @DeleteMapping("/{couponId}")
    ResponseEntity<ResponseObject> deleteCoupon(@PathVariable int couponId){
        boolean exits = couponService.existsById(couponId);
        if(exits){
            couponService.deleteById(couponId);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "delete data successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find data to delete", "")
        );
    }

    @GetMapping("/caculate")
    ResponseEntity<ResponseObject> caculateCouponValue(
            @RequestParam("couponCode") String couponCode,
            @RequestParam("totalAmount") double totalAmount
            ){
        try {
            double finalAmount = couponService.caculateCouponValue(couponCode, totalAmount);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "caculateCouponValue successfully", finalAmount)
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed", "caculateCouponValue failed", e.getMessage())
            );
        }
    }
}
