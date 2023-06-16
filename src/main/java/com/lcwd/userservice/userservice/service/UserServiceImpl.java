package com.lcwd.userservice.userservice.service;

import com.lcwd.userservice.userservice.entity.Hotel;
import com.lcwd.userservice.userservice.entity.Rating;
import com.lcwd.userservice.userservice.entity.User;
import com.lcwd.userservice.userservice.exceptions.ResourceNotFoundException;
import com.lcwd.userservice.userservice.external.service.HotelService;
import com.lcwd.userservice.userservice.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.*;

import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    //Logger logger= (Logger) LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> saveAllUser(List<User> users) {

        for (User u:users) {
            String randomUserId = UUID.randomUUID().toString();
            u.setUserId(randomUserId);
        }
        return userRepository.saveAll(users);
    }

    @Override
    public User getUser(String UserId) {

        //API Call for Rating Service
        User user = userRepository.findById(UserId).orElseThrow(() -> new ResourceNotFoundException());
        Rating[] ratingOfUser = restTemplate.getForObject("http://Rating-Service/getRating/"+user.getUserId(), Rating[].class);
       //logger.info("{ }"+ratingOfUser);



        List<Rating> collect = Arrays.stream(ratingOfUser).collect(Collectors.toList());
        collect.stream().map(rating->{
            //restTemplate.getForEntity("http://localhost:8082/getHotel/2e746d9c-0a76-4465-a3a3-7417ad0b8487",Hotel.class);

            //api call to hotel service to get the hotel(Using Rest Template)

//           ResponseEntity<Hotel> listOfHotel= restTemplate.getForEntity("http://HOTELSERVICE/getHotel/"+rating.getHotelId(), Hotel.class);
//            Hotel hotel = listOfHotel.getBody();
//            //set the hotel rating
//            rating.setHotel(hotel);

        // api call to hotel service to get the hotel(Using Rest Template)
                Hotel hotel=hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);


              //return the rating
               return rating;
                }).collect(Collectors.toList());
        user.setRating(collect);
        return user;

    }

    @Override
    public List<User> getAllUser() {
        List<User> allUsers = userRepository.findAll();
        //ArrayList rateByHotelId = restTemplate.getForObject("http://localhost:8083/getRatings/e7024beb-8495-4188-a83a-039241b53efe", ArrayList.class);

        return allUsers;
    }

    @Override
    public String updateUser(String user) {
        return null;
    }

    @Override
    public String deleteUser(String id) {
        return null;
    }
}


