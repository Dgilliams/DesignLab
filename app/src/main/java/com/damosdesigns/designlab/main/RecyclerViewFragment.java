package com.damosdesigns.designlab.main;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.damosdesigns.designlab.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by damosdesigns on 6/19/16.
 */

    public class RecyclerViewFragment extends Fragment {

    private RecyclerView.Adapter mAdapter;

    @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            RecyclerView rv = (RecyclerView) inflater.inflate(
                    R.layout.recycler_view_fragment, container, false);
            setupRecyclerView(rv);
            return rv;
        }

        private void setupRecyclerView(RecyclerView recyclerView) {

            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            Project[] listOfProjects = new Project[3];

            Project businessCard = new Project("Material Design Business Card", R.color.md_purple_400);
            businessCard.setmLogo(getContext(), R.drawable.businesscard_logo);
            Project cowculator = new Project("Cowculator", R.color.md_amber_400);
            Project origin = new Project("Origin", R.color.md_red_400);

            listOfProjects[0] = businessCard;
            listOfProjects[1] = cowculator;
            listOfProjects[2] = origin;


            mAdapter = new ProjectsAdapter(listOfProjects);
            recyclerView.setAdapter(mAdapter);
        }
}
