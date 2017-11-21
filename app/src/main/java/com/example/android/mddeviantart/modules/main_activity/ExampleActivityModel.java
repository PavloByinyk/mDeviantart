package com.example.android.mddeviantart.modules.main_activity;


import com.example.android.mddeviantart.base_mvp.BaseModel;

/**
 * BaseModel() , IBuyContract.IModel
 */

public class ExampleActivityModel extends BaseModel implements IExampleActivityContract.IModel {




    //    override fun makeRequestGetTraidedItems(iRequestListener: IRequestListener, limit: Int, offset: Int ) {
//        observe(getApiService().getTrendingSpotlights(limit, offset), object : Callback<List<TradedItemR>> {
//            override fun onFailure(call: Call<List<TradedItemR>>?, t: Throwable?) {
//                iRequestListener.onError(t!!.message.toString())
//            }
//
//            override fun onResponse(call: Call<List<TradedItemR>>?, response: Response<List<TradedItemR>>?) {
//                if(response!!.isSuccessful) {
//                    iRequestListener.onSuccess(response.body())
//                }else{
//                    iRequestListener.onError("ERROR")
//                }
//            }
//        })
//    }
//
    interface IRequestListener{
        void onSuccess(String response);
        void onError(String msg);
    }


}
