package com.example.defaultview

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.CameraPosition

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.jar.Manifest

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkPermission()
    }

    fun startProcess(){
        setContentView(R.layout.activity_maps)
        val mapFragment=supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    @SuppressLint("MissingPermission")

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        fusedLocationClient=LocationServices.getFusedLocationProviderClient(this)
        updateLocation()
    }

    fun updateLocation(){
        val locationRequest=LocationRequest.create()

        locationRequest.run {
            priority=LocationRequest.PRIORITY_HIGH_ACCURACY
            interval=1000
        }

        locationCallback=object :LocationCallback(){
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult?.let {
                    for((i, location) in it.locations.withIndex()){
                        Log.d("Location", "$i ${location.latitude}, ${location.longitude}")
                        setLastLocation(location)
                    }
                }
            }
        }
        //noinspection ResourceType
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper())
    }

    fun setLastLocation(lastLocation:Location){
        val LATLNG=LatLng(lastLocation.latitude, lastLocation.longitude)
        val markerOptions=MarkerOptions().position(LATLNG).title("Here!")
        val cameraPosition=CameraPosition.Builder().target(LATLNG).zoom(15.0f).build()
        mMap.clear()
        mMap.addMarker(markerOptions)
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition((cameraPosition)))
    }

    override fun onDestroy() {
        fusedLocationClient.removeLocationUpdates(locationCallback)
        super.onDestroy()
    }

    val permissions= arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
    val PERM_LOCATION=99
    fun checkPermission(){
        var permitted_all=true
        for(permission in permissions){
            val result=ContextCompat.checkSelfPermission(this, permission)
            if(result!=PackageManager.PERMISSION_GRANTED){
                permitted_all=false
                requestPermission()
                break
            }
        }
        if(permitted_all){
            startProcess()
        }
    }

    fun requestPermission(){
        ActivityCompat.requestPermissions(this, permissions, PERM_LOCATION)
    }

    fun confirmAgain(){
        AlertDialog.Builder(this).setTitle("권한 승인 확인")
            .setMessage("위치 관련 권한을 모두 승인하셔야 앱을 사용할 수 있습니다. 권한 승인을 다시하시겠습니까?")
            .setPositiveButton("네",{_,_->
                requestPermission()
            }).setNegativeButton("아니요",{_, _->
                finish()
            }).create()
            .show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {

        when(requestCode){
            99->{
                var granted_all=true
                for(result in grantResults){
                    if(result!=PackageManager.PERMISSION_GRANTED){
                        granted_all=false
                        break
                    }
                }
                if(granted_all){
                    startProcess()
                }else{
                    confirmAgain()
                }
            }
        }
    }
}