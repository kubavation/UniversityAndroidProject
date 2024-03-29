package com.example.hotelapp.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotelapp.R;
import com.example.hotelapp.fragments.HotelFragmentList.OnListFragmentInteractionListener;

import com.example.hotelapp.model.Hotel;

import org.w3c.dom.Text;

import java.lang.reflect.Field;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
//public class MyHotelRecyclerViewAdapter extends RecyclerView.Adapter<MyHotelRecyclerViewAdapter.ViewHolder> {
//
//    private final List<DummyItem> mValues;
//    private final OnListFragmentInteractionListener mListener;
//
//    public MyHotelRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
//        mValues = items;
//        mListener = listener;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.fragment_hotel_item, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(final ViewHolder holder, int position) {
//        holder.mItem = mValues.get(position);
//        holder.mIdView.setText(mValues.get(position).id);
//        holder.mContentView.setText(mValues.get(position).content);
//
//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return mValues.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        public final View mView;
//        public final TextView mIdView;
//        public final TextView mContentView;
//        public DummyItem mItem;
//
//        public ViewHolder(View view) {
//            super(view);
//            mView = view;
//            mIdView = (TextView) view.findViewById(R.id.item_number);
//            mContentView = (TextView) view.findViewById(R.id.content);
//        }
//
//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
//        }
//    }
//}

public class MyHotelRecyclerViewAdapter extends RecyclerView.Adapter<MyHotelRecyclerViewAdapter.ViewHolder> {

    private final List<Hotel> mValues;
    private final OnListFragmentInteractionListener mListener;
    private Context context;

    public MyHotelRecyclerViewAdapter(List<Hotel> items, OnListFragmentInteractionListener listener, Context context) {
        mValues = items;
        mListener = listener;
        this.context = context;
        System.out.println("!!!" + context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_hotel_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getName());
        holder.mContentView.setText(mValues.get(position).getPlace());
        holder.mCostView.setText("Cena: " + mValues.get(position).getCostPerPerson() + ".00 PLN");

        int img = context.getResources().getIdentifier(mValues.get(position).getImgSrc()
                , "drawable", context.getPackageName());
        System.out.println("-------------");
        System.out.println(img);

        holder.imgView.setImageResource(img);

        //holder.imgView.setImageResource();
//        try {
//            Field x = R.drawable.class.getField(mValues.get(position).getImgSrc());
//            holder.imgView.setImageResource(x.getInt());
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }

        //    holder.mId.setText(mValues.get(position).getId());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final ImageView imgView;
        public final TextView mCostView;
       /// public final TextView mId;
        public Hotel mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
            imgView = view.findViewById(R.id.imageView2);
            mCostView = view.findViewById(R.id.cost);
          //  mId = view.findViewById(R.id.id);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}