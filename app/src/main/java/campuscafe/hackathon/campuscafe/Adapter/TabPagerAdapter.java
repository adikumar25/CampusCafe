package campuscafe.hackathon.campuscafe.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import campuscafe.hackathon.campuscafe.Fragment.ClosedOrderFragment;
import campuscafe.hackathon.campuscafe.Fragment.OpenOrderFragment;

public class TabPagerAdapter extends FragmentPagerAdapter {

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new OpenOrderFragment();
            case 1:
                // Games fragment activity
                return new ClosedOrderFragment();

        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }

}