package com.example.android.mddeviantart.bases;

import android.support.v7.app.AppCompatActivity;


public class BaseActivity extends AppCompatActivity {}






//    private val PERMISSIONS_REQUEST_LOCATION = 10
//    private lateinit var mLocationPermissionResult: ILocationPermissionResult
//
//interface ILocationPermissionResult {
//    fun onLocationPermissionGranted()
//    fun onLocationPermissionDenied()
//}
//
//    fun checkLocationPermission(permissionResult: ILocationPermissionResult) {
//        mLocationPermissionResult = permissionResult
////        if (alreadyAskedForLocationPermission) return
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
//            if (ContextCompat.checkSelfPermission(this,
//                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
//                    && ContextCompat.checkSelfPermission(this,
//                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
//                    //show dialog
//                    return
//                }
//
////                alreadyAskedForLocationPermission = true
//                requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION),
//                        PERMISSIONS_REQUEST_LOCATION)
//            } else {
//                permissionResult.onLocationPermissionGranted()
//            }
//        } else {
//            permissionResult.onLocationPermissionGranted()
//        }
//    }
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
//    when (requestCode) {
//        PERMISSIONS_REQUEST_LOCATION -> {
////                alreadyAskedForLocationPermission = false
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                mLocationPermissionResult.onLocationPermissionGranted()
//            } else {
//                mLocationPermissionResult.onLocationPermissionDenied()
//            }
//        }
//    }
//}

