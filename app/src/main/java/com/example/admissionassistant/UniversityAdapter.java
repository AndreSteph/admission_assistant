package com.example.admissionassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<University> courseModelArrayList;

    // Constructor
    public UniversityAdapter(Context context, ArrayList<University> courseModelArrayList) {
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull UniversityAdapter.ViewHolder holder, int position) {
        // to set data to textview and imageview of each card layout
        University model = courseModelArrayList.get(position);
        holder.courseNameTV.setText(model.getName());
        holder.courseIV.setImageResource(model.getImage());

    }

    @Override
    public int getItemCount() {
        // this method is used for showing number of card items in recycler view
        return courseModelArrayList.size();
    }

    // View holder class for initializing of your views such as TextView and Imageview
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView courseIV;
        private final TextView courseNameTV;

        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            courseIV = itemView.findViewById(R.id.unimage);
            courseNameTV = itemView.findViewById(R.id.uniname);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    BlankFragment fragment = new BlankFragment();
                    Fragment previousFragment = fragmentManager.findFragmentById(R.id.frame);
                    if (previousFragment != null && !(previousFragment instanceof BlankFragment)){
                        fragmentTransaction.remove(previousFragment).commitNow();

                    }
                    fragmentTransaction.replace(R.id.frame, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                }

            });
        }






    }

}
