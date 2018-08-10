package com.koma.component_base.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.koma.component_base.R;
import org.jetbrains.annotations.NotNull;

/**
 * @author Koma
 * @date 2018/8/10 下午 04:20
 * @des
 */
public class ProgressBarWebView extends WebView {
  private ProgressBar progressBar;


  public ProgressBarWebView(Context context, AttributeSet attrs) {
    super(context, attrs);
    progressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 8);
    progressBar.setLayoutParams(params);
    Drawable drawable = context.getResources().getDrawable(R.drawable.progress_bar);
        //ContextCompat.getDrawable(context,R.drawable.progress_bar);
    progressBar.setProgressDrawable(drawable);
    addView(progressBar);
    setWebChromeClient(new WebChromeClient());
  }


  private class WebChromeClient extends android.webkit.WebChromeClient {
    @Override public void onProgressChanged(WebView view, int newProgress) {
      if (newProgress == 100) {
        progressBar.setVisibility(GONE);
      } else {
        if (progressBar.getVisibility() == GONE) {
          progressBar.setVisibility(VISIBLE);
        }
        progressBar.setProgress(newProgress);
      }
      super.onProgressChanged(view, newProgress);
    }
  }


  @Override protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
    LayoutParams params = (LayoutParams) progressBar.getLayoutParams();
    params.x = scrollX;
    params.y = scrollY;
    progressBar.setLayoutParams(params);
    super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
  }
}
