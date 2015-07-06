package com.example.testmyowntabactivity;

import java.util.ArrayList;
import java.util.List;

import com.example.fragment.Fragment01;
import com.example.fragment.Fragment02;
import com.example.fragment.Fragment03;
import com.example.fragment.Fragment04;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabWidget;

public class MainActivity extends FragmentActivity {
	private ViewPager vp;
	private TabWidget tab;
	private List<Fragment> list = new ArrayList<Fragment>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		initTab();
	}

	private void init() {
		vp = (ViewPager) findViewById(R.id.vp);
		list.add(new Fragment01());
		list.add(new Fragment02());
		list.add(new Fragment03());
		list.add(new Fragment04());
		MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), list);
		vp.setAdapter(adapter);
		vp.setOnPageChangeListener(onPageChangeListener);
	}

	private void initTab() {
		tab = (TabWidget) findViewById(R.id.tab);
		tab.setCurrentTab(0);
		findViewById(R.id.button1).setOnClickListener(onClickListener);
		findViewById(R.id.button2).setOnClickListener(onClickListener);
		findViewById(R.id.button3).setOnClickListener(onClickListener);
		findViewById(R.id.button4).setOnClickListener(onClickListener);
	}

	private class MyAdapter extends FragmentStatePagerAdapter {
		List<Fragment> list;

		public MyAdapter(FragmentManager fm, List<Fragment> list) {
			super(fm);
			this.list = list;
		}

		@Override
		public Fragment getItem(int position) {
			return list.get(position);
		}

		@Override
		public int getCount() {
			return list.size();
		}

	}

	private OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int index) {
			tab.setCurrentTab(index);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}
	};

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			System.out.println(v.getId());
			switch (v.getId()) {
			case R.id.button1:
				vp.setCurrentItem(0);
				break;
			case R.id.button2:
				vp.setCurrentItem(1);
				break;
			case R.id.button3:
				vp.setCurrentItem(2);
				break;
			case R.id.button4:
				vp.setCurrentItem(3);
				break;
			}
		}
	};
}
