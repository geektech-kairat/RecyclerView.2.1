package com.example.recyclerview2.FirstFramgent;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.recyclerview2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment  implements  OnClickListener{

    private FirstAdapter firstAdapter;
    private FloatingActionButton addNewContact;

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_container);

        firstAdapter = new FirstAdapter();
        firstAdapter.initListener(this);

        recyclerView.setAdapter(firstAdapter);

        firstAdapter.addItemModelForShowInHolder(new Item_model("asd", "asd"));
        addNewContact = view.findViewById(R.id.addNewContact);


        return view;
    }


    @Override
    public void checkPosition(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage("Вы хотите удалить ?");
        String positive = "Да";
        String negative = "Нет";
        builder.setPositiveButton(positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                firstAdapter.deleteItem(position);
            }
        });
        builder.setNegativeButton(negative,null);
        builder.show();
        Toast.makeText(requireContext(), "holder " + position, Toast.LENGTH_SHORT).show();
    }
}