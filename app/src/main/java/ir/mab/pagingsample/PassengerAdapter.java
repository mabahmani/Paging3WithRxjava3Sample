package ir.mab.pagingsample;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class PassengerAdapter extends PagingDataAdapter<PassengerModel.Data,PassengerAdapter.ViewHolder> {

    public PassengerAdapter(@NotNull DiffUtil.ItemCallback<PassengerModel.Data> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.passenger_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        Log.d("getItemCount", super.getItemCount() + "");
        return super.getItemCount();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("onBindViewHolder", getItem(position).toString());
        if (getItem(position) != null){
            holder.id.setText(getItem(position).getId());
            holder.name.setText(getItem(position).getName());
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,id;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.passengerName);
            id = itemView.findViewById(R.id.passengerId);
        }
    }


}
