package com.bsuir.ppvis.сook.diagnostics;

import com.bsuir.ppvis.сook.model.Product;

public interface DiagnosticWithAnalogue extends Diagnostic{

    void addAnalogue(Product product, Product analogue);

}
