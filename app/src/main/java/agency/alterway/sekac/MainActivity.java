package agency.alterway.sekac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import java.util.List;

import agency.alterway.sekac.db.DatabaseManager;
import agency.alterway.sekac.models.Cut;
import agency.alterway.sekac.views.adapters.CutAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{
    private List<Cut> cutList;
    private CutAdapter adapter;

    @Bind(R.id.field_addHeight)
    EditText heightField;
    @Bind(R.id.field_addWidth)
    EditText widthField;
    @Bind(R.id.recycler_previousRecords)
    RecyclerView recordsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recordsRecycler.setLayoutManager(layoutManager);

        cutList = DatabaseManager.getInstance(this).getTreeCuts();
        adapter = new CutAdapter(cutList);
        recordsRecycler.setAdapter(adapter);

        recordsRecycler.smoothScrollToPosition(cutList.size()-1);
    }

    @OnClick(R.id.button_addCut)
    void addCut()
    {
        try
        {
            int height = Integer.parseInt(heightField.getText().toString());
            int width = Integer.parseInt(widthField.getText().toString());
            int volume = DatabaseManager.getInstance(this).getPineVolume(width, height);

            Cut newCut = new Cut(width, height, volume);

            newCut.setId(DatabaseManager.getInstance(this).addTreeCut(newCut));

            cutList.add(newCut);

            adapter.notifyDataSetChanged();

            heightField.setText("");
            widthField.setText("");

            recordsRecycler.smoothScrollToPosition(cutList.size()-1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


}
