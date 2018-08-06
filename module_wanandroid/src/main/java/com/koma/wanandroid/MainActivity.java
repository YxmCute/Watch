package com.koma.wanandroid;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.koma.component_base.base.BaseFragment;
import com.koma.component_base.base.BaseResponse;
import com.koma.component_base.bean.w.BannerData;
import com.koma.component_base.net.ApiConstants;
import com.koma.component_base.net.HttpClient;
import com.koma.wanandroid.ui.fragment.KnowledgeFragment;
import com.koma.wanandroid.ui.fragment.MainFragment;
import com.koma.wanandroid.ui.fragment.MeFragment;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {
  private BottomNavigationView bottomNavigationView;
  private DrawerLayout drawer;
  private MainFragment mainFragment;
  private KnowledgeFragment knowledgeFragment;
  private MeFragment meFragment;
  private List<Fragment> baseFragmentList = new ArrayList<>();
  private FragmentManager fragmentManager = getSupportFragmentManager();


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (savedInstanceState != null) {
      Log.i("timo", "onCreate:" + savedInstanceState.toString());

    } else {
      Log.i("timo", "onCreate");
    }

    setContentView(R.layout.wanandroid_activity_main);
    if (fragmentManager.findFragmentByTag("main") == null) {
      mainFragment = new MainFragment();
      baseFragmentList.add(mainFragment);

    } else {
      baseFragmentList.add((MainFragment) fragmentManager.findFragmentByTag("main"));
    }
    if (fragmentManager.findFragmentByTag("know") == null) {
      knowledgeFragment = new KnowledgeFragment();
      baseFragmentList.add(knowledgeFragment);

    } else {
      baseFragmentList.add((KnowledgeFragment) fragmentManager.findFragmentByTag("know"));

    }
    if (fragmentManager.findFragmentByTag("me") == null) {
      meFragment = new MeFragment();
      baseFragmentList.add(meFragment);

    } else {
      baseFragmentList.add((MeFragment) fragmentManager.findFragmentByTag("me"));

    }
    if (savedInstanceState == null) {
      setSelectIndex(0);
    }
    bottomNavigationView = findViewById(R.id.bottom_navigation);
    bottomNavigationView.setOnNavigationItemSelectedListener(this);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
  }


  private void setSelectIndex(int index) {
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    for (int i = 0; i < baseFragmentList.size(); i++) {
      Fragment fragment = baseFragmentList.get(i);

      if (i == index) {

        if (null != fragment) {
          if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
          } else {
            switch (index) {
              case 0:
                fragmentTransaction.add(R.id.frameLayout, fragment, "main");

                break;
              case 1:
                fragmentTransaction.add(R.id.frameLayout, fragment, "know");

                break;
              case 2:
                fragmentTransaction.add(R.id.frameLayout, fragment, "me");

                break;
              default:
                break;
            }
          }
        }
      } else {
        if (fragment.isAdded() && !fragment.isHidden()) {
          fragmentTransaction.hide(fragment);
        }
      }
    }
    fragmentTransaction.commit();

  }


  @Override
  public void onBackPressed() {

    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }


  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }


  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.nav_camera) {
      ARouter.getInstance().build("/zhihu/main").navigation();
      item.setChecked(false);

      // Handle the camera action
    } else if (id == R.id.nav_gallery) {
      ARouter.getInstance().build("/gank/main").navigation();

    } else if (id == R.id.nav_slideshow) {

    } else if (id == R.id.nav_manage) {

    } else if (id == R.id.nav_share) {

    } else if (id == R.id.nav_send) {

    } else if (id == R.id.navigation_main) {
      setSelectIndex(0);

    } else if (id == R.id.navigation_knowledge) {
      setSelectIndex(1);

    } else if (id == R.id.navigation_me) {
      setSelectIndex(2);

    }

    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    }

    return true;
  }


  @Override protected void onPause() {
    super.onPause();


  }


  @Override protected void onRestart() {
    super.onRestart();

  }


  @Override protected void onDestroy() {
    super.onDestroy();
  }


  @Override protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    if (outState != null) {
      Log.i("timo", "onSaveInstanceState:" + outState.toString());

    } else {
      Log.i("timo", "onSaveInstanceState");
    }
  }


  @Override public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
    Log.i("timo", "onSaveInstanceState--");

  }


  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    if (savedInstanceState != null) {
      Log.i("timo", "onRestoreInstanceState:" + savedInstanceState.toString());
    } else {
      Log.i("timo", "onRestoreInstanceState");
    }
  }
}
