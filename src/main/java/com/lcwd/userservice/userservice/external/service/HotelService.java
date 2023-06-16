package com.lcwd.userservice.userservice.external.service;

import com.lcwd.userservice.userservice.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Hotel-Service")
public interface HotelService {

    @GetMapping("/getHotel/{id}")
    Hotel getHotel(@PathVariable("id") String id);
}
