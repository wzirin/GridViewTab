package com.example.dummy.gridviewtab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Pictures extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pictures, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdapter(view.getContext()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getActivity(), "Not yet implemented", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
