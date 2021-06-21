package kz.uco.testwork.web.screens.product;

import com.haulmont.cuba.gui.screen.*;
import kz.uco.testwork.entity.Product;

@UiController("testwork_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> {
}