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
        final ArrayList<Project> projects = new ArrayList<Project>();

        Project businessCard = new Project("Material Design Business Card", "material_card");
        businessCard.setmLogo(getContext(), R.drawable.businesscard_logo);

        Project cowculator = new Project("Cowculator", "cowculator");
        cowculator.setmLogo(getContext(), R.drawable.cowculator_card_background);

        Project origin = new Project("Origin", "origin");
        origin.setmLogo(getContext(), R.drawable.origin_card_background);

        Project experiments = new Project("Prototypes and Experiments", "prototypes");
        experiments.setmLogo(getContext(), R.color.md_red_400);

        final Project dev4hire = new Project("This Application: Dev for Hire", "dev4hire");
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
                        final ArrayList<Project> proj = projects;
                        switch (proj.get(position).getmID()) {
                            case "dev4hire" :
                                //Launch new activity
                                Intent intent = new Intent(getContext(), Dev4HireActivity.class);
                                startActivity(intent);
                                break;
                            case "material_card":
                                //material design business card
                                Util.launchPlaystore(getContext(), "com.damosdesigns.damo.material_design_business_card");
                                break;
                            case "cowculator":
                                Util.launchPlaystore(getContext(), "com.damosdesigns.cowculatorcalculator");
                                break;
                            case "origin":
                                Util.launchPlaystore(getContext(), "com.OriginalOrigins.Origin");
                                break;
                        }
                    }
                })
        );
    }
}
