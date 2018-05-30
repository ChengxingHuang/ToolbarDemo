package com.huang.toolbardemo;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView tv = toolbar.findViewById(R.id.tv);
        tv.setTextSize(10f);
        setSupportActionBar(toolbar);

        //需要在setSupportActionBar之后才会生效
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Navigation Click", Toast.LENGTH_SHORT).show();
            }
        });

        //需要在setSupportActionBar之后才会生效
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //根据id判断点击了哪个action
                switch(item.getItemId()){
                    case R.id.action_setting:
                        Toast.makeText(MainActivity.this, "Setting click", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_about:
                        Toast.makeText(MainActivity.this, "About click", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //将指定menu绑定到toolbar
        getMenuInflater().inflate(R.menu.toolbar_menu_option, menu);

        //在menu中指定class只能通过这种方式拿到
        MenuItem searchMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchMenuItem);
        searchView.setQueryHint("aaaa");

        return true;
    }
}
