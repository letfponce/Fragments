package android.dominando.fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leticiafuzzattiponce on 06/06/16.
 */
public class HotelListFragment extends ListFragment {

    List<Hotel> mHoteis;
    ArrayAdapter<Hotel> mAdapter;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mHoteis = carregaHoteis();

        mAdapter = new ArrayAdapter<Hotel>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mHoteis);
        setListAdapter(mAdapter);

    }

    private List<Hotel> carregaHoteis(){

        List<Hotel> hoteis = new ArrayList<Hotel>();

        hoteis.add(new Hotel("Hotel Vitoria", "Rua XYZ, 123", 1.2f));
        hoteis.add(new Hotel("Hotel Bahia", "Rua ABC, 44", 1f));
        hoteis.add(new Hotel("Hotel São Paulo", "Rua XYZ, 123", 2f));
        hoteis.add(new Hotel("Hotel Minas", "Rua XYZ, 963", 4.5f));
        hoteis.add(new Hotel("Hotel Acre", "Rua XYZ, 485", 3.2f));
        hoteis.add(new Hotel("Hotel Tristeza Feliz", "Rua XYZ, 1113", 2.2f));


        return hoteis;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Activity activity = getActivity();
        if(activity instanceof AoClicarNoHotel){
            Hotel hotel = (Hotel)l.getItemAtPosition(position);

            AoClicarNoHotel listener = (AoClicarNoHotel)activity;
            listener.clicouNoHotel(hotel);
        }
    }

    public interface AoClicarNoHotel{
        void clicouNoHotel(Hotel hotel);
    }
}
