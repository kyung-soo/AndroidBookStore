package com.example.bookstore.main;

import com.example.bookstore.base.BasePresenter;
import com.example.bookstore.base.BaseView;

import java.util.List;

public class MainContract {
    public interface View
            extends BaseView {
        void fetchItemsDone(List<Object> items);
    }

    public interface Presenter
            extends BasePresenter<View> {
        //TODO fetch Items
        void fetchItems();
        void fetchItemsDone(List<Object> items);
    }
}
