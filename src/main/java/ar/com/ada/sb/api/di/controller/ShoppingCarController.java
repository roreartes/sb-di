package ar.com.ada.sb.api.di.controller;

import ar.com.ada.sb.api.di.model.dto.ShoppigCar;
import ar.com.ada.sb.api.di.service.ProductService;
import ar.com.ada.sb.api.di.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/shopping-car")
public class ShoppingCarController {


    @Autowired @Qualifier("shoppingCarService")
    private ShoppingCarService service;

    @PostMapping({"", "/"})
    public ResponseEntity addNewShop( @Valid @RequestBody ShoppigCar shoppigCar){
        HttpStatus status = HttpStatus.OK;

        try {
            service.saveShoppingCar(shoppigCar);
        } catch (Exception e) {
         status = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.ok().body(null);

    }



}
