package agency.alterway.sekac.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import agency.alterway.sekac.R;
import agency.alterway.sekac.SekacApplication;
import agency.alterway.sekac.db.DatabaseManager;
import agency.alterway.sekac.models.Cut;

/**
 * Adapter class for all cut records saved
 *
 * Created by marekrigan on 22/02/16.
 */
public class CutAdapter extends RecyclerView.Adapter<CutAdapter.ViewHolder>
{
    private List<Cut> cutList;

    public CutAdapter(List<Cut> cutList)
    {
        this.cutList = cutList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cut, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {
        final Cut cut = cutList.get(position);

        holder.deleteButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DatabaseManager.getInstance(SekacApplication.getAppContext()).removeCut(cut);
                cutList.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
            }
        });

        holder.height.setText(cut.getFormattedHeight());
        holder.width.setText(cut.getFormattedWidth());
        holder.volume.setText(cut.getFormattedVolume());
    }

    @Override
    public int getItemCount()
    {
        return cutList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageButton deleteButton;
        public TextView height;
        public TextView width;
        public TextView volume;

        public ViewHolder(View itemView)
        {
            super(itemView);

            deleteButton = (ImageButton) itemView.findViewById(R.id.imgButton_remove);
            height = (TextView) itemView.findViewById(R.id.text_heightValue);
            width = (TextView) itemView.findViewById(R.id.text_widthValue);
            volume = (TextView) itemView.findViewById(R.id.text_volumeValue);
        }

    }
}
