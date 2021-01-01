package com.example.adsbydee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this)

        bannerAd()
    }

    private fun bannerAd(){
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mAdView.adListener = object : AdListener(){

            override fun onAdLoaded() {
               Log.d(TAG, "Ad loaded")
            }

            override fun onAdFailedToLoad(p0: LoadAdError?) {
                Log.d(TAG, "Add failed to load")
            }

            override fun onAdOpened() {
                Log.d(TAG, "Ad opened")
            }

            override fun onAdClosed() {
                Log.d(TAG, "Ad closed")
            }

            override fun onAdLeftApplication() {
                Log.d(TAG, "User left app on AD")
            }

            override fun onAdClicked() {
                Log.d(TAG, "Ad clicked")
            }
        }
    }
}