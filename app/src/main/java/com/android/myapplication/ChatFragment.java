package com.android.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {
    ListView list;
    FloatingActionButton fab2;
    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View frag2= inflater.inflate(R.layout.fragment_chat, container, false);
        fab2=(FloatingActionButton)frag2.findViewById(R.id.fab_chat);
        String[]maintitle={"Tony","Julia","Nirmal","Michael","Bruce Wayne"};
        String[]subtext={"I am Iron man","Roberts","I'm not from nepal","osas","morningstar","I'm batman"};
        list=frag2.findViewById(R.id.listv2);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,maintitle);
        list.setAdapter(adapter);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivity(j);
            }
        });
        return frag2;
    }
}
