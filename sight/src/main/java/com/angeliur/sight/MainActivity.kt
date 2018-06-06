package com.angeliur.sight

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.angeliur.sight.fragment.*
import com.xfhy.deeplibrary.basekit.BaseActivity
import com.xfhy.deeplibrary.basekit.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var mAreaFragment: AreaMainFragment? = null
    private var mPictureFragment: PictureMainFragment? = null
    private var mStationFragment: StationMainFragment? = null
    private var mDigFragment: DigMainFragment? = null
    private var mAboutFragment: AboutFragment? = null

    override fun getContentViewResId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        setToolbar("首页")
        val toggle = ActionBarDrawerToggle(this, drawer_main, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_main.addDrawerListener(toggle)
        toggle.syncState()

        //设置菜单默认选中项
        navigation.setCheckedItem(R.id.nav_menu_area)
        navigation.setNavigationItemSelectedListener(this)

        showArea()

    }

    /**
     * 默认将地区显示出来
     */
    private fun showArea() {
        val supportFragmentManager = supportFragmentManager
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.main_content,AreaMainFragment.newInstance())
        transaction.commit()
    }

    /*设置toolbar标题*/
    private fun setToolbar(title: String) {
        //setSupportActionBar之前设置标题
        toolbar.setTitle(title)
        setSupportActionBar(toolbar)
        val supportActionBar = supportActionBar
        if (supportActionBar != null){
            //让导航按钮显示出来
            supportActionBar.setDisplayHomeAsUpEnabled(true)
            //设置导航按钮图标
            supportActionBar.setDisplayShowHomeEnabled(true)
        }
    }

    override fun initData() {
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val transaction = supportFragmentManager.beginTransaction()
        hideAllFragment(transaction)
        when(item.itemId) {
            R.id.nav_menu_area -> {
                setToolbar("首页")
                mAreaFragment?.let {
                    transaction.show(it)
                } ?: AreaMainFragment.newInstance().let {
                    transaction.add(R.id.main_content, it,"area")
                    transaction.show(it)
                }
            }

            R.id.nav_menu_picture -> {
                setToolbar("图片分类")
//                if (mPictureFragment != null) {
//                    hideAllFragment(transaction)
//                    transaction.show(mPictureFragment)
//                } else {
//                    mPictureFragment = PictureMainFragment.newInstance()
//                    transaction.add(R.id.main_content, mPictureFragment,"pictrue")
//                    transaction.show(mPictureFragment)
//                }

                mPictureFragment?.let {
                    transaction.show(it)
                } ?: PictureMainFragment.newInstance().let {
                    transaction.add(R.id.main_content, it,"diagrams")
                    transaction.show(it)
                }
                
            }

            R.id.nav_menu_diagrams -> {
                setToolbar("套图")
                mDigFragment?.let {
                    transaction.show(it)
                } ?: DigMainFragment.newInstance().let {
                    transaction.add(R.id.main_content, it,"diagrams")
                    transaction.show(it)
                }

            }

            R.id.nav_menu_station -> {
                setToolbar("写真")
                mStationFragment?.let {
                    transaction.show(it)
                } ?: StationMainFragment.newInstance().let {
                    transaction.add(R.id.main_content, it,"station")
                    transaction.show(it)
                }
            }

            R.id.nav_menu_about -> {
                setToolbar("关于")
                mAboutFragment?.let {
                    transaction.show(it)
                } ?: AboutFragment.newInstance().let {
                    transaction.add(R.id.main_content, it,"about")
                    transaction.show(it)
                }
            }
            else ->{}
        }
        transaction.commit()
        //关闭侧滑菜单
        drawer_main.closeDrawers()
        return true
    }

    private fun hideAllFragment(transaction: FragmentTransaction) {
        //默认当前这个对象作为闭包的it参数   这里避免了mHomeFragment为null时调用transaction.hide()的问题
        mAreaFragment?.let { transaction.hide(it) }
        mPictureFragment?.let { transaction.hide(it) }
        mDigFragment?.let { transaction.hide(it) }
        mStationFragment?.let { transaction.hide(it) }
        mAboutFragment?.let { transaction.hide(it) }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            //这个是HomeAsUp按钮的id永远都是android.R.id.home
            android.R.id.home -> drawer_main.openDrawer(GravityCompat.START)//将滑动菜单显示出来
        }
        return true
    }

}
