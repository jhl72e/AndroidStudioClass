package com.example.test17;

public abstract class Item {

    static final int TYPE_HEADER =0;
    static final int TYPE_DATA =1;

    abstract int getType();


}


 class Headeritem extends Item {
    String title;

     public String getTitle() {
         return title;
     }

     public void setTitle(String title) {
         this.title = title;
     }

     public Headeritem(String title) {
         this.title = title;
     }

     @Override
    int getType() {
        return Item.TYPE_HEADER;

    }
}

class DataItem extends Item{



    String name, date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DataItem(String name, String date) {
        this.name = name;
        this.date = date;
    }

    @Override
    int getType() {
        return Item.TYPE_HEADER;
    }

}