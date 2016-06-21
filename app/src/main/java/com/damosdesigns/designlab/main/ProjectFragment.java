package com.damosdesigns.designlab.main;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
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
import android.widget.Toast;

import com.damosdesigns.designlab.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by damosdesigns on 6/19/16.
 */

public class ProjectFragment extends Fragment {

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
        ArrayList<Project> projects = new ArrayList<Project>();

        Project businessCard = new Project("Material Design Business Card", R.color.md_purple_400);
        businessCard.setmLogo(getContext(), R.drawable.businesscard_logo);

        Project cowculator = new Project("Cowculator", R.color.md_amber_400);
        cowculator.setmLogo(getContext(), R.drawable.cowculator_card_background);

        Project origin = new Project("Origin", R.color.md_red_400);
        origin.setmLogo(getContext(), R.drawable.origin_card_background);

        Project experiments = new Project("Prototypes and Experiments", R.color.md_red_400);
        experiments.setmLogo(getContext(), R.color.md_red_400);

        Project dev4hire = new Project("This Application: Dev for Hire", 0);
        dev4hire.setmLogo(getContext(), R.color.md_green_600);

        projects.add(dev4hire);
        projects.add(businessCard);
        projects.add(cowculator);
        projects.add(origin);
        projects.add(experiments);

        mAdapter = new ProjectsAdapter(projects);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        switch (position) {
                            case 0:
                                //material design business card
                                Util.launchPlaystore(getContext(), "com.damosdesigns.damo.material_design_business_card");
                                break;
                            case 1:
                                Util.launchPlaystore(getContext(), "com.damosdesigns.cowculatorcalculator");
                                break;
                            case 2:
                                Util.launchPlaystore(getContext(), "com.OriginalOrigins.Origin");
                                break;
                        }
                    }
                })
        );
    }
}
