package agency.alterway.sekac.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.List;

import agency.alterway.sekac.R;
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

        if (cutList.size() > 0)
        {
            recordsRecycler.smoothScrollToPosition(cutList.size()-1);
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_summary:
                Intent goToSummary = new Intent(this, SummaryActivity.class);
                startActivity(goToSummary);
                return true;
            default:
                return false;
        }
    }
}
