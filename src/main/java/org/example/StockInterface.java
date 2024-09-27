package org.example;

import Controller.StockItemController;
import View.StockItemView;

public class StockInterface implements PointOfSales {

    @Override
    public void getInterface() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> database.Database.closeConnection()));

        StockItemView view = new StockItemView();
        Stock model = new Stock();

        StockItemRepository stockItemRepository = new StockItemRepository(database.Database.getInstance());
        new StockItemController(view, model, stockItemRepository);


        view.setVisible(true);
    }
}
