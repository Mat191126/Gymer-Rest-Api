package com.gymer.gymer_rest_api.entity;

public interface BaseEntityBehaviour<K> {

    K getId();
    void setActive(boolean status);

}
