package agency.alterway.sekac.views.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
 * <p>
 * Created by marekrigan on 22/02/16.
 */
public class CutAdapter extends RecyclerView.Adapter<CutAdapter.ViewHolder> {
    private List<Cut> cutList;
    private ActivityCallback callback;

    public CutAdapter(ActivityCallback callback, List<Cut> cutList) {
        this.callback = callback;
        this.cutList = cutList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cut, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Cut cut = cutList.get(position);

        holder.deleteButton.setOnClickListener(v -> {
            DatabaseManager.getInstance(SekacApplication.getAppContext()).removeCut(cut);
            cutList.remove(holder.getAdapterPosition());
            notifyDataSetChanged();
            callback.onRemovedCut(cutList.isEmpty());
        });

        holder.height.setText(cut.getFormattedHeight());
        holder.width.setText(cut.getFormattedWidth());
        holder.volume.setText(cut.getFormattedVolume());
    }

    @Override
    public int getItemCount() {
        return cutList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton deleteButton;
        TextView height;
        TextView width;
        TextView volume;

        ViewHolder(View itemView) {
            super(itemView);

            deleteButton = itemView.findViewById(R.id.imgButton_remove);
            height = itemView.findViewById(R.id.text_heightValue);
            width = itemView.findViewById(R.id.text_widthValue);
            volume = itemView.findViewById(R.id.text_volumeValue);
        }

    }

    public interface ActivityCallback {
        void onRemovedCut(boolean isEmpty);
    }
}
