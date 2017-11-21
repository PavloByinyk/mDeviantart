package com.example.android.mddeviantart.base_mvp;

//abstract class BasePresenter<out M : IBaseModel, out V : IBaseView<out IBasePresenter>>(view: V) : IBasePresenter{



public abstract class BasePresenter<M extends IBaseModel, V extends IBaseView<? extends IBasePresenter>> implements IBasePresenter{

    private M mModel = null;
    private V mView;


    protected abstract M provideModel();

    public BasePresenter(V mView) {
        this.mView = mView;
    }

    @Override
    public void onStart() {
        lazyInitModel();
        mModel.init();
    }

    @Override
    public void onDestroy() {
        lazyInitModel();
        mModel.onDestroy();
    }


    private void lazyInitModel(){

        if(mModel == null){
            synchronized (this){
                if (mModel == null){
                    mModel = provideModel();
                }
            }
        }
    }

    public M getModel(){
        lazyInitModel();
        return mModel;
    }

    public V getView(){
        return mView;
    }
}


//    private var mView: V = view
//private var mModel: M? = null
//
//@CallSuper
//    override fun onStart() {
//            lazyInitModel()
//            mModel!!.init()
//            }
//
//
//
//@CallSuper
//    override fun onDestroy() {
//            lazyInitModel()
//            mModel!!.onDestroy()
//            }
//
//            fun getModel(): M? {
//            lazyInitModel()
//            return mModel
//            }
//
//            fun getView(): V = mView
//
//protected abstract fun provideModel(): M
//
//private fun lazyInitModel() {
//        if (mModel == null) {
//synchronized(this) {
//        if (mModel == null) {
//        mModel = provideModel()
//        }
//        }
//        }
//        }
