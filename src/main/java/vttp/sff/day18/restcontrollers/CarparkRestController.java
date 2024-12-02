package vttp.sff.day18.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp.sff.day18.models.Carpark;
import vttp.sff.day18.services.CarparkService;

// GOOD PRACTICE - separate the UI controller and the API calling controller

@RestController
@RequestMapping
public class CarparkRestController {

    @Autowired
    private CarparkService carparkSvc;

    @GetMapping(path = {"/api/carparks"})
    public ResponseEntity<List<Carpark>> getIndex() {

        List<Carpark> carparks = carparkSvc.getCarparks();

        return ResponseEntity.ok().body(carparks);
    }

    
}
