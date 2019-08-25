package com.example.hotelapp.service;

import android.widget.ListView;

import com.example.hotelapp.model.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotelService {

    public static List<Hotel> hotels = new ArrayList<>();

    static {
        hotels.add(new Hotel("testowy","desc1",new double[]{51.759445,19.457216},"hotel1",50));
        hotels.add(new Hotel("testowy2","desc2",new double[]{51.759445,19.457216},"hotel2",70));
        hotels.add(new Hotel("testowy3","desc3",new double[]{51.759445,19.457216},"hotel3",130));
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


    public static List<Hotel> filterBy(Map<String,Object> filters) {

        List<Hotel> result = new ArrayList<>();
        //todo add temp list
        for (Map.Entry<String, Object> filter: filters.entrySet()) {

            //todo cost od / cost do
            if ( filter.getKey().equals("COST") ) {

                for ( Hotel hotel : hotels) {
                    if ( hotel.getCostPerPerson() <= (int) filter.getValue() ) {
                        result.add(hotel);
                    }
                }
            }

        }

        return result;
    }


}
