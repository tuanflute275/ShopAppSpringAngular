package vn.tuanflutte.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.tuanflutte.dtos.request.CouponConditionDTO;
import vn.tuanflutte.entities.CouponCondition;
import vn.tuanflutte.exception.ResponseObject;
import vn.tuanflutte.services.couponCondition.ICouponConditionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/couponCondition")
public class CouponConditionController {
    @Autowired
    private ICouponConditionService couponConditionService;

    @GetMapping("")
    @PreAuthorize("hasRole('Admin')")
    ResponseEntity<ResponseObject> findAll(){
        List<CouponCondition> list = couponConditionService.findAll();
        List<CouponConditionDTO> listDTO = new ArrayList<>();
        for (CouponCondition c : list){
            CouponConditionDTO dto = new CouponConditionDTO();
            dto.setId(c.getId());
            dto.setOperator(c.getOperator());
            dto.setAttribute(c.getAttribute());
            dto.setValue(c.getValue());
            dto.setDiscount_amount(c.getDiscount_amount());
            dto.setCoupon_id(c.getCoupon().getId());
            dto.setCoupon_name(c.getCoupon().getCode());
            listDTO.add(dto);
        }

        if(list.size() > 0){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query coupon condition successfully", listDTO)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "No Data", "")
            );
        }
    }

    @GetMapping("/{couponConditionId}")
    @PreAuthorize("hasRole('Admin')")
    ResponseEntity<ResponseObject> findById(@PathVariable int couponConditionId){
        Optional<CouponCondition> foundCouponCondition = couponConditionService.findById(couponConditionId);
        if(foundCouponCondition.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query data successfully", foundCouponCondition)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "cannot find data with id = "+couponConditionId, "")
            );
        }
    }

    @PostMapping("")
    @PreAuthorize("hasRole('Admin')")
    ResponseEntity<ResponseObject> insertCouponCondition(@RequestBody CouponCondition condition){
        try {
            couponConditionService.save(condition);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Insert data successfully", "")
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("error", "Insert data failed", "")
            );
        }
    }

    @PutMapping("/{couponConditionId}")
    @PreAuthorize("hasRole('Admin')")
    ResponseEntity<ResponseObject> updateCouponCondition(@RequestBody CouponCondition condition, @PathVariable int couponConditionId){
        couponConditionService.update(couponConditionId, condition);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "Update data successfuly", "")
        );
    }

    @DeleteMapping("/{couponConditionId}")
    ResponseEntity<ResponseObject> deleteCouponCondition(@PathVariable int couponConditionId){
        boolean exits = couponConditionService.existsById(couponConditionId);
        if(exits){
            couponConditionService.deleteById(couponConditionId);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "delete data successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "cannot find data with id = "+couponConditionId, "")
        );
    }
}
