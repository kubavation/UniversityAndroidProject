package com.example.hotelapp.service;

import android.widget.ListView;

import com.example.hotelapp.model.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotelService {

    public static List<Hotel> hotels = new ArrayList<>();

    static {
        String desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam et viverra urna, " +
                "non convallis tellus. Vivamus molestie erat arcu, et aliquet urna ultricies ut. " +
                "Sed euismod lectus quis sagittis egestas. Morbi in libero venenatis, pharetra nibh a, " +
                "posuere massa. Nam placerat dui tortor, nec vestibulum diam consectetur ut. Praesent nec orci ante. Donec fermentum in " +
                "sem vitae pretium. Morbi interdum vel metus ac blandit. Ut dictum molestie turpis. Phasellus vitae suscipit urna. " +
                "Maecenas dapibus cursus turpis, eget porttitor enim placerat sit amet. Vivamus rutrum ex eget ipsum auctor semper. " +
                "Mauris id placerat magna. Praesent rutrum tellus vitae commodo faucibus.";

        /**
         * todo
         * wyszukiwane po miejscowosci !!!
         *
         */

        hotels.add(new Hotel("Hotel bałucki",desc,new double[]{51.781803,19.450916},
                "hotel1",100,"Łódź, Zachodnia 16","555 333 222"));
        hotels.add(new Hotel("Hotel Hilton",desc,new double[]{52.263378,21.038203},
                "hotel2",70,"Warszawa, 11 Listopada 5","532 111 211"));
        hotels.add(new Hotel("Hotel Złota Rybka",desc,new double[]{54.511329,18.529943},
                "hotel3",130,"Gdynia, Pomorska 15","112 998 276"));
        hotels.add(new Hotel("Hotel Mors",desc,new double[]{54.349128,18.650776},
                "hotel3",90,"Gdańsk, Długa 22","875 632 111"));
        hotels.add(new Hotel("Hotel Paprykarz",desc,new double[]{53.477106,14.583019},
                "hotel3",65,"Szczecin, Górna 2","992 226 745"));
        hotels.add(new Hotel("Hotel Zgierzok",desc,new double[]{51.869780,19.396657},
                "hotel3",110,"Zgierz, Ozorkowska 12","548 765 002"));
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
