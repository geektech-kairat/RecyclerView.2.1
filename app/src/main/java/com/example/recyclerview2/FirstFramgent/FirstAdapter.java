package com.example.recyclerview2.FirstFramgent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview2.R;

import java.util.ArrayList;
import java.util.List;

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.FirstViewHolder> {

    private OnClickListener listener;

    public void initListener(OnClickListener listener) {
        this.listener = listener;
    }

    private List<Item_model> list = new ArrayList<>();


    @NonNull
    @Override
    //в этотм моменте мы делаем привязку наш готовый item_layout xml
    public FirstViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        return new FirstViewHolder(view);
    }

    @Override
    //в этом методе каждый раз будет перезаписывать наш метод onBind то есть мы передаем
    // в холдер данные а он нам отображает через лист
    public void onBindViewHolder(@NonNull FirstViewHolder holder, int position) {
        holder.onBind(list.get(position), listener);
    }

    @Override
    //здесь мы указываем сколько будет холдеров а мы сделали что он следил количеством листа
    public int getItemCount() {
        return list.size();
    }

    public void addItemModelForShowInHolder(Item_model itemModel) {
        list.add(itemModel);
        notifyDataSetChanged();
    }

    public void addListItemModelForShowHolder(List<Item_model> list2) {
        list.clear();
        list.addAll(list2);
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        list.remove(position);
        notifyDataSetChanged();
    }

    //////    \\\\\\
    /////      \\\\\
    ////        \\\\
    ///          \\\
    //            \\
    class FirstViewHolder extends RecyclerView.ViewHolder {

        private TextView name, number;
        ;
        private ImageView imageViewId;


        public FirstViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_layout_tv_name);
            number = itemView.findViewById(R.id.item_layout_tv_number);
            imageViewId = itemView.findViewById(R.id.item_layout_image);
        }

        public void onBind(Item_model itemModel, OnClickListener listener) {
            name.setText(itemModel.name);
            number.setText(itemModel.number);
            imageViewId.setImageResource(itemModel.imageId);
            itemView.setOnLongClickListener(v -> {
                listener.checkPosition(getAdapterPosition());
                return true;
            });
        }
    }
}
