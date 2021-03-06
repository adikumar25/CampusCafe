package campuscafe.hackathon.campuscafe;
import campuscafe.hackathon.campuscafe.Adapter.CustomerTabAdapter;


import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CustomerHomeActivity extends AppCompatActivity implements ActionBar.TabListener {

private ViewPager viewPager;
        CustomerTabAdapter mAdapter;
        ActionBar actionBar;
// Tab titles
private String[] tabs = { "Cafeteria", "Notify","Suggestions"};


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getSupportActionBar();
        mAdapter = new CustomerTabAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Adding Tabs
        for (String tab_name : tabs) {
        actionBar.addTab(actionBar.newTab().setText(tab_name)
        .setTabListener(this));
        }
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
                }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
                }

        @Override
        public void onPageScrollStateChanged(int arg0) {
                }
                });
                }



        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
                viewPager.setCurrentItem(tab.getPosition());
                }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

                }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

                }
        }
