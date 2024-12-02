package vttp.sff.day18.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import vttp.sff.day18.models.Carpark;
import vttp.sff.day18.services.CarparkService;

import vttp.sff.day18.contants.*;

@Controller
@RequestMapping
public class CarparkController {

    @Autowired
    private CarparkService carparkSvc;

    @Value("${spring.data.local.api.url}")
    private String localCarparkUrl;

    @GetMapping(path = {"/", "index.html"})
    public ModelAndView getIndex() {

        List<Carpark> carparkList = carparkSvc.getCarparks();

        ModelAndView mav = new ModelAndView("index");
        mav.setStatus(HttpStatusCode.valueOf(200));
        mav.addObject(Constant.ATTR_CARPARK_LIST, carparkList);

        return mav;
    }

    // Getting the info from the Carpark Rest Controller instead of directly from the Service
    // [For good practice]
    @GetMapping("/carparkRest")
    public ModelAndView getCarparkRest() {

        RestTemplate restTemplate = new RestTemplate();

        List<Carpark> carparkList = restTemplate.exchange(localCarparkUrl,
                                                          HttpMethod.GET,
                                                          null,
                                                          new ParameterizedTypeReference<List<Carpark>>(){})
                                                          .getBody();

        ModelAndView mav = new ModelAndView("index");
        mav.setStatus(HttpStatusCode.valueOf(200));
        mav.addObject(Constant.ATTR_CARPARK_LIST, carparkList);

        return mav;
    }
    
}
