package com.example.demo;


import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;



import com.example.demo.weixinFragment;
import com.example.demo.friendFragment;
import com.example.demo.addressbookFragment;
import com.example.demo.settingFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FragmentManager fm;

    private Fragment mtab1=new weixinFragment();
    private Fragment mtab2=new friendFragment();
    private Fragment mtab3=new addressbookFragment();
    private Fragment mtab4=new settingFragment();

    LinearLayout tabweixin;
    LinearLayout tabfriend;
    LinearLayout tabaddressbook;
    LinearLayout tabsetting;

    ImageButton mImgweixin;
    ImageButton mImgfriend;
    ImageButton mImgaddressbook;
    ImageButton mImgsetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_main);

        initView();
        initFragment();
        initEvent();
        selectFragment(0);
    }

    private void initView() {
        tabweixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        tabfriend = (LinearLayout) findViewById(R.id.id_tab_friend);
        tabaddressbook = (LinearLayout) findViewById(R.id.id_tab_addressbook);
        tabsetting = (LinearLayout) findViewById(R.id.id_tab_setting);

        mImgweixin = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mImgfriend = (ImageButton) findViewById(R.id.id_tab_friend_img);
        mImgaddressbook = (ImageButton) findViewById(R.id.id_tab_addressbook_img);
        mImgsetting = (ImageButton) findViewById(R.id.id_tab_setting_img);
    }

    public void initFragment() {
        fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.id_content, mtab1);
        transaction.add(R.id.id_content, mtab2);
        transaction.add(R.id.id_content, mtab3);
        transaction.add(R.id.id_content, mtab4);
        transaction.commit();
    }

    private void initEvent() {
        tabweixin.setOnClickListener(this);
        tabfriend.setOnClickListener(this);
        tabaddressbook.setOnClickListener(this);
        tabsetting.setOnClickListener(this);
    }

    private void selectFragment(int i) {
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (i) {
            case 0:
                transaction.show(mtab1);
                mImgweixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                transaction.show(mtab2);
                mImgfriend.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                transaction.show(mtab3);
                mImgaddressbook.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                transaction.show(mtab4);
                mImgsetting.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;
        }
        transaction.commit();
    }
    private void hideFragment(FragmentTransaction transaction) {
        transaction.hide(mtab1);
        transaction.hide(mtab2);
        transaction.hide(mtab3);
        transaction.hide(mtab4);
    }

    @Override
    public void onClick(View v) {
        resetImgs();
        switch (v.getId()) {
            case R.id.id_tab_weixin:
                selectFragment(0);
                break;
            case R.id.id_tab_friend:
                selectFragment(1);
                break;
            case R.id.id_tab_addressbook:
                selectFragment(2);
                break;
            case R.id.id_tab_setting:
                selectFragment(3);
                break;
            default:
                break;
                
        }
    }

    public void resetImgs() {
        mImgweixin.setImageResource(R.drawable.tab_weixin_normal);
        mImgfriend.setImageResource(R.drawable.tab_find_frd_normal);
        mImgaddressbook.setImageResource(R.drawable.tab_address_normal);
        mImgsetting.setImageResource(R.drawable.tab_settings_normal);
    }

}