package com.example.recyclerview2.FirstFramgent;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

import com.example.recyclerview2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements OnClickListener {

    private FirstAdapter firstAdapter;
    private FloatingActionButton addNewContact;

    RecyclerView recyclerView;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_container);

        firstAdapter = new FirstAdapter();
        firstAdapter.initListener(this);
        addNewContact = view.findViewById(R.id.addNewContact);

        recyclerView.setAdapter(firstAdapter);

        firstAdapter.addItemModelForShowInHolder(new Item_model("Kairat", "+996709089032",R.drawable.red));
        firstAdapter.addItemModelForShowInHolder(new Item_model("Kairat", "+996709089032",R.drawable.red));
        firstAdapter.addItemModelForShowInHolder(new Item_model("Kairat", "+996709089032",R.drawable.red));
        firstAdapter.addItemModelForShowInHolder(new Item_model("Kairat", "+996709089032",R.drawable.red));
        firstAdapter.addItemModelForShowInHolder(new Item_model("Kairat", "+996709089032",R.drawable.red));
        firstAdapter.addItemModelForShowInHolder(new Item_model("Kairat", "+996709089032",R.drawable.red));

        addNewContact = view.findViewById(R.id.addNewContact);

        recyclerView.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            int x = scrollY - oldScrollY;
            if ((x > 0)) {
                addNewContact.hide();

//                addNewContact.setVisibility(View.INVISIBLE);
            } else {
                addNewContact.show();
//                addNewContact.setVisibility(View.VISIBLE);


            }
        });

        return view;
    }


    @Override
    public void checkPosition(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage("Вы хотите удалить ?");
        String positive = "Да";
        String negative = "Нет";
        builder.setPositiveButton(positive, (dialog, which) -> firstAdapter.deleteItem(position));
        builder.setNegativeButton(negative, null);
        builder.show();
        Toast.makeText(requireContext(), "holder " + position, Toast.LENGTH_SHORT).show();
    }
}