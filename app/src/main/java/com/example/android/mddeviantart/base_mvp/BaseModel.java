package com.example.android.mddeviantart.base_mvp;



import com.example.android.mddeviantart.remote.ApiUtils;
import com.example.android.mddeviantart.remote.RetrofitService;

import java.util.HashSet;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;


public class BaseModel implements IBaseModel{

    private RetrofitService mApiService;
    private Set<Call<?>> mRequestsRegistry = new HashSet<>();

    @Override
    public void init() {
        mApiService = ApiUtils.getRetrofitService();
    }

    @Override
    public void onDestroy() {

        for (Call call : mRequestsRegistry){
            if(!call.isCanceled() && !call.isExecuted()){
                call.cancel();
            }
        }
    }

    public <T> void observe(Call<T> call, Callback<T> callback){
        mRequestsRegistry.add(call);
        call.enqueue(callback);
    }

    public RetrofitService getmApiService(){
        return mApiService;
    }


//    interface IRequestlistener{
//        void onSuccess(String msg);
//        void onError(String errorMsg);
//    }
}



//: IBaseModel{
//
//private val mRequestsRegistry = HashSet<Call<*>>()
//private lateinit var mApiService: RetrofitService
//
//
//@CallSuper
//    override fun onDestroy() {
//            mRequestsRegistry
//            .filter { !it.isCanceled && !it.isExecuted }
//            .forEach { it.cancel() }
//            }
//
//            override fun init() {
//            mApiService = ApiUtils.getRetrofitService()
//            }
//
//            fun <T> observe(call: Call<T>, callback: Callback<T>) {
//        mRequestsRegistry.add(call)
//        call.enqueue(callback)
//        }
//
//protected fun getApiService(): RetrofitService = mApiService
//
//interface IRequestListener {
//    fun onSuccess(msg: String)
//    fun onError(errorMsg: String)
//}
