package task.project.postmemespammer3;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<News> mData;
    List<Hot3> mData3;
    Dialog myDialog;

    public RecyclerViewAdapter(Context mContext, List<News> mData) {
        this.mContext = mContext;
        this.mData = mData;
        this.mData3 = mData3;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_news,viewGroup, false);
        final MyViewHolder viewHolder = new MyViewHolder(v);

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_news);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        viewHolder.item_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_title_id = (TextView) myDialog.findViewById(R.id.dialog_title_id);
                ImageView dialog_image_id = (ImageView) myDialog.findViewById(R.id.dialog_image_id);
                dialog_title_id.setText(mData.get(viewHolder.getAdapterPosition()).getTitle());
                dialog_image_id.setImageResource(mData.get(viewHolder.getAdapterPosition()).getImage());
                Toast.makeText(mContext, "Click"+String.valueOf(viewHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
                myDialog.show();

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.post_title.setText(mData.get(i).getTitle());
        myViewHolder.img.setImageResource(mData.get(i).getImage());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout item_news;
        private TextView post_title;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_news = (LinearLayout) itemView.findViewById(R.id.news_item_id);
            post_title = (TextView) itemView.findViewById(R.id.post_title_id);
            img = (ImageView) itemView.findViewById(R.id.image_post_id);

        }
    }
}
