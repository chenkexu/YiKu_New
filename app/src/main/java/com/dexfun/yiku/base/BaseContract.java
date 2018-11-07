package com.dexfun.yiku.base;



public  interface BaseContract {
	
	

    interface BasePresenter<T> {
        void attachView(T view);
        void detachView();
    }

    
    
    interface BaseView {
        void showToast(String str);
        /**
         * 显示加载图
         */
        public void showLoading();
        /**
         * 隐藏加载图
         */
        public void hideLoading();
    }


    
    
  
    
    
}
