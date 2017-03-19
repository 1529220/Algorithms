package com.example.android.navigationdrawer;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import static android.R.attr.button;
import static com.example.android.navigationdrawer.R.drawable.profile;
import static com.example.android.navigationdrawer.R.id.address;
import static com.example.android.navigationdrawer.R.id.email;
import static com.example.android.navigationdrawer.R.id.imageButton;


/**
 * Created by laura on 14/03/2017.
 */

public class ProfileFragment extends Fragment {
    //ImageButton imageButton;
    View myView;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.profile_layout, container, false);
        ImageButton edit = (ImageButton) getActivity().findViewById(R.id.imageButton);
       //
        // FloatingActionButton edit = (FloatingActionButton) findViewById(R.id.edit_profile_details);
        // edit.setOnClickListener(new View.OnClickListener() {

        return myView;


    }
}
