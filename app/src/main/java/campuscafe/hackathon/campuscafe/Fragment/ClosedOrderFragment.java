package campuscafe.hackathon.campuscafe.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import campuscafe.hackathon.campuscafe.R;


public class ClosedOrderFragment extends Fragment {

    public ClosedOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_closed_order, container, false);

        return rootView;    }


}
