package task.project.postmemespammer3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    private sharedpreferenceconfig preferenceconfig;
    private TabLayout tabLayout;
    private ViewPagerAdapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        SharedPreferences sharedpref = getApplicationContext().getSharedPreferences("save", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpref.edit();

        preferenceconfig = new sharedpreferenceconfig(getApplicationContext());


        tabLayout = (TabLayout) findViewById(R.id.tab_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new FragmentNews(),"");
        adapter.AddFragment(new FragmentHot3(),"");
        adapter.AddFragment(new FragmentAccount3(),"");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.news);
        tabLayout.getTabAt(1).setIcon(R.drawable.hot);
        tabLayout.getTabAt(2).setIcon(R.drawable.profile);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

    }
    public void logoutUser(View view) {
        preferenceconfig.writeLoginStatus(false);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
