package com.bsuir.ppvis.сook.cooking;

import com.bsuir.ppvis.сook.model.CookingStep;

import java.io.Serializable;

public interface Cooking extends Serializable {

    CookingStep receiveNextStep();

    boolean hasNext();

}
