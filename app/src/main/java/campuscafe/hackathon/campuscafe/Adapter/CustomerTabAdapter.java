package campuscafe.hackathon.campuscafe.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import campuscafe.hackathon.campuscafe.Fragment.CafeteriaFragement;
import campuscafe.hackathon.campuscafe.Fragment.CustomerSuggestionFragment;
import campuscafe.hackathon.campuscafe.Fragment.NotifyFragment;

public class CustomerTabAdapter extends FragmentPagerAdapter {

    public CustomerTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new CafeteriaFragement();
            case 1:
                // Games fragment activity
                return new NotifyFragment();
            case 2:
                return new CustomerSuggestionFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}