package com.matt1479.inmemoryrestitems;

import java.util.Objects;

public class Item {
    
    private Long id;
    private String name;
    
    public Item() { }

    public Item(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Item)) {
            return false;
        }

        Item item = (Item) o;
        return Objects.equals(this.id, item.id) && Objects.equals(this.name, item.name);
    }

}
