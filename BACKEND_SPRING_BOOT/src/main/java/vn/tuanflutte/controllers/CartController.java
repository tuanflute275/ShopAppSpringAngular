package vn.tuanflutte.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import vn.tuanflutte.entities.Cart;
import vn.tuanflutte.exception.ResponseObject;

import vn.tuanflutte.repositories.CartRepository;
import vn.tuanflutte.services.cart.CartService;

import java.util.Optional;

@RestController
@RequestMapping(path = "/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    private CartRepository cartRepository;

    @GetMapping("")
    ResponseEntity<ResponseObject> getAllCart(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query data successfully", cartService.getCart())
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("error", "Query data failed", "")
            );
        }
    }

    @GetMapping("/{cartId}")
    ResponseEntity<ResponseObject> getById(@PathVariable int cartId){
        Optional<Cart> foundCart = cartService.findById(cartId);
        if(foundCart.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query category successfully", foundCart)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "cannot find cart with id = "+cartId, "")
            );
        }
    }

    @GetMapping("/{productId}/{quantity}")
    ResponseEntity<ResponseObject> postCart(@PathVariable(name = "productId") Integer productId, @PathVariable(name = "quantity") Integer quantity){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "Insert data successfully", cartService.addToCart(productId, quantity))
        );
    }

    @PutMapping("/{cartId}/{productId}/{quantity}/{totalAmount}")
    ResponseEntity<ResponseObject> putCart(
            @PathVariable(name = "cartId") Integer cartId,
            @PathVariable(name = "productId") Integer productId,
            @PathVariable(name = "quantity") Integer quantity,
            @PathVariable(name = "totalAmount") Integer totalAmount){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "Update data successfully", cartService.updateToCart(cartId,productId, quantity, totalAmount))
        );
    }

    @PutMapping("/{cartId}")
    ResponseEntity<ResponseObject> updateQuantity(@PathVariable(name = "cartId") Integer cartId){
        cartService.updateQuantity(cartId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "Update data successfully", "")
        );
    }

    @DeleteMapping("/{cartId}")
    ResponseEntity<ResponseObject> deleteCart(@PathVariable int cartId){
        boolean exits = cartService.existsById(cartId);
        if(exits){
            cartService.deleteById(cartId);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "delete data successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find data to delete", "")
        );
    }
}
