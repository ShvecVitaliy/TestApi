package com.example.testapi.retrofitclien;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.testapi.R;
import com.example.testapi.model.ModelGet;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<ModelGet> item;
    private Context context ;

    public RecyclerViewAdapter(Context context, List<ModelGet> item ) {
        Log.i("autolog", "RecyclerViewAdapter");
        this.item = item;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("autolog", "onCreateViewHolder");
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_row, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.i("autolog", "onBindViewHolder");
        holder.id.setText("Id: "+ item.get(position).getId().toString());
        holder.actualTime.setText("ActualTime: "+item.get(position).getActualTime().toString());
        holder.comment.setText("Comment: "+item.get(position).getComment());
        holder.pair.setText("Pair: "+item.get(position).getPair());
        holder.cmd.setText("Cmd: "+item.get(position).getCmd().toString());
        holder.tradingSystem.setText("TradingSystem: "+item.get(position).getTradingSystem().toString());
        holder.period.setText("Period: "+item.get(position).getPeriod());
        holder.price.setText("Price: "+item.get(position).getPrice().toString());
        holder.sl.setText("Sl: "+item.get(position).getSl().toString());
        holder.tp.setText("Tp: "+item.get(position).getTp().toString());

    }

    @Override
    public int getItemCount() {
        Log.i("autolog", "getItemCount");
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id, actualTime, comment, pair, cmd,
                tradingSystem, period, price, sl, tp;

        public ViewHolder(View itemView) {
            super(itemView);
            Log.i("autolog", "ViewHolder");

            id = (TextView) itemView.findViewById(R.id.idTextView);
            actualTime = (TextView) itemView.findViewById(R.id.actualTimeTextView);
            comment = (TextView) itemView.findViewById(R.id.commentTextView);
            pair = (TextView) itemView.findViewById(R.id.pairTextView);
            cmd = (TextView) itemView.findViewById(R.id.cmdTextView);
            tradingSystem = (TextView) itemView.findViewById(R.id.tradingSystemTextView);
            period = (TextView) itemView.findViewById(R.id.periodTextView);
            price = (TextView) itemView.findViewById(R.id.priceTextView);
            sl = (TextView) itemView.findViewById(R.id.slTextView);
            tp = (TextView) itemView.findViewById(R.id.tpTextView);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
        }
    }
}
