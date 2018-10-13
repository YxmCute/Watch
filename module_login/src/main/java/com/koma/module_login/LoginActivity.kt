package com.koma.module_login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_login.*

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    setContentView(R.layout.activity_login)
    supportActionBar?.hide()
    val adapter = FileImageAdapter(this)
    val recyclerView = recycler
   // recyclerView.
    recyclerView.layoutManager = ScrollLinearLayoutManager(this)

    recyclerView.adapter = adapter

  }


}
