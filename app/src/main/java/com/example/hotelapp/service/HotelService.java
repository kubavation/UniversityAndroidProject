package com.example.hotelapp.service;

import android.widget.ListView;

import com.example.hotelapp.model.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotelService {

    public static List<Hotel> hotels = new ArrayList<>();

    static {
        hotels.add(new Hotel("Hotel bałucki","desc1",new double[]{51.759445,19.457216},"hotel1",50,"Łódź, Zachodnia 16"));
        hotels.add(new Hotel("Hotel Hilton","desc2",new double[]{51.759445,19.457216},"hotel2",70,"Warszawa, 11 Listopada 5"));
        hotels.add(new Hotel("Hotel Złota Rybka","desc3",new double[]{51.759445,19.457216},"hotel3",130,"Gdynia, Pomorska 15"));
        hotels.add(new Hotel("Hotel Mors","desc3",new double[]{51.759445,19.457216},"hotel3",130,"Gdańsk, Długa 22"));
        hotels.add(new Hotel("Hotel Paprykarz","desc3",new double[]{51.759445,19.457216},"hotel3",130,"Szczecin, Górna 2"));
        hotels.add(new Hotel("Hotel Zgierzok","desc3",new double[]{51.759445,19.457216},"hotel3",130,"Zgierz, Ozorkowska 12"));
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


    public static List<Hotel> filterBy(Map<String,String> filters) {


        System.out.println("filterss: ");
        for (Map.Entry<String, String> filter: filters.entrySet()) {
            System.out.println(filter.getKey() + " |  " + filter.getValue());
        }
        System.out.println("end filters.");

        List<Hotel> result = new ArrayList<>();

        for (Hotel hotel : hotels) {

            System.out.println(hotel);
            int count = 0;

            if ( filters.containsKey("COST") ) {
                if(hotel.getCostPerPerson() <= Integer.parseInt(filters.get("COST")) ) {
                    count++;
                }
            }

            if ( filters.containsKey("NAME") ) {
                if(hotel.getName().equalsIgnoreCase(filters.get("NAME"))  ) {
                    count++;
                }
            }

            if ( filters.containsKey("PLACE") ) {
                if(hotel.getPlace().equalsIgnoreCase(filters.get("PLACE")) ) {
                    count++;
                }
            }

            if ( count == filters.size() ) {
                result.add(hotel);
            }

        }

        return result;
    }


}
