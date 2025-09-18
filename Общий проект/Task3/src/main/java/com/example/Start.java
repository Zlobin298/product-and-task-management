package com.example;

import com.example.controller.ProductNotFoundException;
import com.example.service.ProjectLogic;

public class Start {
    public static void main(String[] args) throws ProductNotFoundException {
        new ProjectLogic().start();
    }
}
