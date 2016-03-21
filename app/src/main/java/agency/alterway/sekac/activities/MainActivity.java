package agency.alterway.sekac.activities;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.List;

import agency.alterway.sekac.R;
import agency.alterway.sekac.db.DatabaseManager;
import agency.alterway.sekac.models.Cut;
import agency.alterway.sekac.views.adapters.CutAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements CutAdapter.ActivityCallback
{
    private static final int NOTE_SCREEN = 0;
    private static final int EMPTY_LABEL = 1;

    private List<Cut> cutList;
    private CutAdapter adapter;

    @Bind(R.id.switcher_main)
    ViewSwitcher switcher;
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
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        cutList = DatabaseManager.getInstance(this).getTreeCuts();
        adapter = new CutAdapter(this, cutList);
        recordsRecycler.setAdapter(adapter);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        if (cutList.size() > 0)
        {
            recordsRecycler.scrollToPosition(cutList.size()-1);
            switcher.setDisplayedChild(NOTE_SCREEN);
        }
        else
        {
            switcher.setDisplayedChild(EMPTY_LABEL);
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

            recordsRecycler.scrollToPosition(cutList.size()-1);
            switcher.setDisplayedChild(NOTE_SCREEN);
        }
        catch (SQLiteException e)
        {
            Toast.makeText(this, "Chyba", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void onRemovedCut(boolean isEmpty)
    {
        if (isEmpty)
        {
            switcher.setDisplayedChild(EMPTY_LABEL);
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
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                Intent goToSummary = new Intent(this, SummaryActivity.class);
                startActivity(goToSummary);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                return true;
            default:
                return false;
        }
    }
}
