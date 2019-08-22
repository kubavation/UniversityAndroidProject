package com.example.hotelapp.service;

import com.example.hotelapp.model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelService {

    public static List<Hotel> hotels = new ArrayList<>();

    static {
        hotels.add(new Hotel("testowy","desc1",new double[]{51.02,33.03}));
        hotels.add(new Hotel("testowy2","desc2",new double[]{51.02,33.03}));
        hotels.add(new Hotel("testowy3","desc3",new double[]{51.02,33.03}));
    }

    public static Hotel findHotelById(String id) {
        for (Hotel hotel: hotels) {
            if ( hotel.getId().equals(id))
                return hotel;
        }
        return null;
    }

    public static void addHotel(Hotel hotel) {
        //+validation
        hotels.add(hotel);
    }


}
