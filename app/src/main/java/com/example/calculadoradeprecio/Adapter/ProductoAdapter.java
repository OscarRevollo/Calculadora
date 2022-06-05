package com.example.calculadoradeprecio.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.calculadoradeprecio.Model.Producto;
import com.example.calculadoradeprecio.R;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {

    private List<Producto> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public ProductoAdapter(Context context, List<Producto> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.producto_adapter, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String productoText = mData.get(position).getNombre();
        String cantidadText = mData.get(position).getCantidad();
        holder.producto.setText(productoText);
        holder.cantidad.setText(cantidadText);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }





    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView producto,cantidad;

        ViewHolder(View itemView) {
            super(itemView);
            producto = itemView.findViewById(R.id.producto);
            cantidad = itemView.findViewById(R.id.cantidad);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}
