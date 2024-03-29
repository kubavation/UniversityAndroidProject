package com.example.hotelapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotelapp.R;
import com.example.hotelapp.model.Hotel;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HotelDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HotelDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotelDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Hotel hotel;

    private TextView name;
    private TextView desc;
    private ImageView img;
    private Button locationButton;

    protected View mView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HotelDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HotelDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HotelDetailsFragment newInstance(String param1, String param2) {
        HotelDetailsFragment fragment = new HotelDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("HERE ????1");
        Serializable obj = this.getArguments().getSerializable("hotel");
        Hotel hotel = (Hotel) obj;
        System.out.println(hotel);
        this.hotel = hotel;

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_hotel_details, container, false);
        this.mView = view;

        name = mView.findViewById(R.id.details_name);
        desc = mView.findViewById(R.id.details_desc);
        img = mView.findViewById(R.id.details_img);

        locationButton = mView.findViewById(R.id.locationButton);

        name.setText(hotel.getName());
        desc.setText(hotel.getDesc());
        int idImg = getActivity().getResources().getIdentifier(hotel.getImgSrc()
                , "drawable", getActivity().getPackageName());
        img.setImageResource(idImg);

        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putSerializable("hotel", hotel);
                MapFragment fragment = new MapFragment();
                fragment.setArguments(bundle);
                System.out.println("SENT TO MAP");
                addFragment(fragment,true,"map_fragment");

            }
        });


        return mView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void addFragment(Fragment fragment, boolean addToBackStack, String tag) {

        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

//        if (addToBackStack) {
//            ft.addToBackStack(tag);
//        }

        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right,
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        ft.replace(R.id.frameLayout, fragment, tag);
        ft.addToBackStack(tag);
        ft.commitAllowingStateLoss();

        System.out.println("ADDING TO BACKSTACK");
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
